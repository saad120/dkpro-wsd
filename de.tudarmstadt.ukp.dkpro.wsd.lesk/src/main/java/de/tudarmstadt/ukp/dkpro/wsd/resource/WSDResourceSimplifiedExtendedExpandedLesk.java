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

/**
 *
 */
package de.tudarmstadt.ukp.dkpro.wsd.resource;

import de.tudarmstadt.ukp.dkpro.wsd.algorithms.lesk.SimplifiedExtendedExpandedLesk;
import de.tudarmstadt.ukp.dkpro.wsd.algorithms.lesk.util.tokenization.AbstractLexicalExpander;
import de.tudarmstadt.ukp.dkpro.wsd.algorithms.lesk.util.tokenization.AbstractLexicalExpander.Expansion;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseTaxonomy;

/**
 * A resource for {@link SimplifiedExtendedExpandedLesk}.
 *
 * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 *
 */
public class WSDResourceSimplifiedExtendedExpandedLesk
    extends WSDResourceSimplifiedExpandedLesk
{
    @Override
    protected void initializeWsdAlgorithm()
    {
        wsdAlgorithm = new SimplifiedExtendedExpandedLesk((SenseTaxonomy) inventory,
                overlapStrategy, normalizationStrategy,
                (AbstractLexicalExpander) defaultTokenizationStrategy, (AbstractLexicalExpander) contextTokenizationStrategy);
        ((SimplifiedExtendedExpandedLesk) wsdAlgorithm).setExpansions(new Expansion(aExpansions), new Expansion(nExpansions), new Expansion(rExpansions), new Expansion(vExpansions));
    }

}
