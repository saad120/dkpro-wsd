/*******************************************************************************
 * Copyright 2015
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

package de.tudarmstadt.ukp.dkpro.wsd.annotator;

import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.fit.util.JCasUtil;

import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventoryException;
import de.tudarmstadt.ukp.dkpro.wsd.type.WSDItem;

/**
 * An abstract class for annotators which call a disambiguation algorithm taking
 * as a parameter the id of the document.
 *
 * @author Nicolai Erbs <erbs@ukp.informatik.tu-darmstadt.de>
 *
 */
public abstract class WSDAnnotatorBaseDocumentDependent
    extends WSDAnnotatorBase
{

	protected abstract Map<String, Double> getDisambiguation(JCas aJCas, String sod)
		throws SenseInventoryException;

	@Override
	public void process(JCas aJCas)
		throws AnalysisEngineProcessException
	{

		try {

			for (WSDItem wsdItem : JCasUtil.select(aJCas, WSDItem.class)) {
				setWSDItem(aJCas, wsdItem, getDisambiguation(aJCas, wsdItem.getSubjectOfDisambiguation()));
			}
		}
		catch (Exception e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
}