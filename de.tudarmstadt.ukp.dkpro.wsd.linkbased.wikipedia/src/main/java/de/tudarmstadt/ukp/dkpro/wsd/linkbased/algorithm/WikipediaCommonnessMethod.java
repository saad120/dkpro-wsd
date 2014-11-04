/*******************************************************************************
 * Copyright 2014
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

package de.tudarmstadt.ukp.dkpro.wsd.linkbased.algorithm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.tudarmstadt.ukp.dkpro.wsd.algorithm.AbstractWSDAlgorithm;
import de.tudarmstadt.ukp.dkpro.wsd.algorithm.WSDAlgorithmCollectiveBasic;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventory;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventoryException;
import de.tudarmstadt.ukp.dkpro.wsd.si.linkdatabase.LinkDatabaseInventoryResource;

/**
 * An disambiguation algorithm based on the 'prior probability' of links
 * 
 * @author nico.erbs@gmail.com
 *
 */
public class WikipediaCommonnessMethod extends AbstractWSDAlgorithm implements WSDAlgorithmCollectiveBasic {

	public WikipediaCommonnessMethod(SenseInventory inventory)
    {
        super(inventory);
    }

	@Override
	public Map<String, Map<String, Double>> getDisambiguation(Collection<String> sods)
			throws SenseInventoryException {
		Map<String, Map<String, Double>> disambiguationResults = new HashMap<String, Map<String, Double>>();

		for(String sod : sods){
			disambiguationResults.put(sod, ((LinkDatabaseInventoryResource) inventory).getWeightedSenses(sod));
		}

		return disambiguationResults;
	}

}
