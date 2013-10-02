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

package de.tudarmstadt.ukp.dkpro.wsd.si.dictionary.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.fit.descriptor.ConfigurationParameter;

import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventoryException;
import de.tudarmstadt.ukp.dkpro.wsd.si.dictionary.IUkbDictionary;
import de.tudarmstadt.ukp.dkpro.wsd.si.dictionary.UkbDictionaryInventory;
import de.tudarmstadt.ukp.dkpro.wsd.si.resource.SenseInventoryResourceBase;

public class UkbDictionaryInventoryResource
extends SenseInventoryResourceBase
implements IUkbDictionary
{
	public static final String PARAM_INVENTORY_PATH = "InventoryPath";
	@ConfigurationParameter(name = PARAM_INVENTORY_PATH, mandatory = true)
	protected String inventoryPath;

	public static final String PARAM_INVENTORY_SERIALIZABLE = "InventorySerializable";
	@ConfigurationParameter(name = PARAM_INVENTORY_SERIALIZABLE, mandatory = true)
	protected String inventorySerializable;

	public static final String PARAM_NEEDED_MENTIONS_PATH = "NeededMentionsPath";
	@ConfigurationParameter(name = PARAM_NEEDED_MENTIONS_PATH, mandatory = true)
	protected String neededMentionsPath;

	@SuppressWarnings("unchecked")
	@Override
	public boolean initialize(ResourceSpecifier aSpecifier, Map additionalParams)
	throws ResourceInitializationException
	{
		if (!super.initialize(aSpecifier, additionalParams)) {
			return false;
		}

		try {
			System.out.println(inventoryPath);
			System.out.println(inventorySerializable);
			System.out.println(neededMentionsPath);
			inventory = new UkbDictionaryInventory(inventoryPath, inventorySerializable, neededMentionsPath);
		} catch (FileNotFoundException e) {
			throw new ResourceInitializationException();
		} catch (IOException e) {
			throw new ResourceInitializationException();
		}

		return true;
	}

	@Override
	public Map<String, Double> getWeightedSenses(String sod)
			throws SenseInventoryException {
		return ((UkbDictionaryInventory) inventory).getWeightedSenses(sod);
	}

	@Override
	public Map<String, Double> getPopularityWeightedSenses(String sod)
			throws SenseInventoryException {
		return ((UkbDictionaryInventory) inventory).getPopularityWeightedSenses(sod);
	}

	@Override
	public Map<String, Double> getRandomlyWeightedSenses(String sod)
			throws SenseInventoryException {
		return ((UkbDictionaryInventory) inventory).getRandomnylWeightedSenses(sod);
	}
}
