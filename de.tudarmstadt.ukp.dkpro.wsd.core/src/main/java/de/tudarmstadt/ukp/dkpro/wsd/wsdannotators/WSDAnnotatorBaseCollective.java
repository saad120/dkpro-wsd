/*******************************************************************************
 * Copyright 2013
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package de.tudarmstadt.ukp.dkpro.wsd.wsdannotators;

import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.tcas.DocumentAnnotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;

import de.tudarmstadt.ukp.dkpro.wsd.WSDUtils;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventoryException;
import de.tudarmstadt.ukp.dkpro.wsd.type.WSDItem;

/**
 * An abstract class for annotators which call a disambiguation algorithm taking
 * as a parameter all the {@link WSDItem}s in the document so that the algorithm
 * can disambiguate them all simultaneously.
 *
 * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 *
 */
public abstract class WSDAnnotatorBaseCollective
    extends WSDAnnotatorBase
{

    protected static final int CONTEXT_TRUNCATION_LENGTH = 80;

    // TODO: Support other ways of specifying context, such as a window of
    // tokens on either side of the WSDItem.
    public final static String PARAM_CONTEXT_ANNOTATION = "contextAnnotationClass";
    @ConfigurationParameter(name = PARAM_CONTEXT_ANNOTATION, mandatory = false, description = "The annotation type determining the context")
    protected String contextAnnotationClass;

    protected Class<Annotation> contextClass;

    private final static Logger logger = Logger
            .getLogger(WSDAnnotatorBaseCollective.class.getName());

    protected abstract Map<WSDItem, Map<String, Double>> getDisambiguation(
            Collection<WSDItem> wsdItems)
        throws SenseInventoryException;

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);

        try {
            if (contextAnnotationClass == null) {
                contextAnnotationClass = DocumentAnnotation.class.getName();
            }
            contextClass = (Class<Annotation>) Class
                    .forName(contextAnnotationClass);
        }
        catch (Exception e) {
            throw new ResourceInitializationException(e);
        }
    }

    @Override
    public void process(JCas aJCas)
        throws AnalysisEngineProcessException
    {
        try {
            for (Annotation context : JCasUtil.select(aJCas, contextClass)) {
                logger.debug("Entering context "
                        + WSDUtils.truncate(context.getCoveredText(),
                                CONTEXT_TRUNCATION_LENGTH));
                Map<WSDItem, Map<String, Double>> disambiguationResults = getDisambiguation(JCasUtil
                        .selectCovered(aJCas, WSDItem.class, context));
                for (WSDItem wsdItem : disambiguationResults.keySet()) {
                    if (maxItemsAttempted >= 0 && numItemsAttempted++ >= maxItemsAttempted) {
                        return;
                    }
                    setWSDItem(aJCas, wsdItem,
                            disambiguationResults.get(wsdItem));
                }
            }
        }
        catch (Exception e) {
            throw new AnalysisEngineProcessException(e);
        }

    }
}