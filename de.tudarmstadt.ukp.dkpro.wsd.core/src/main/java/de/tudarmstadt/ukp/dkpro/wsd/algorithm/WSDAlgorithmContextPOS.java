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
package de.tudarmstadt.ukp.dkpro.wsd.algorithm;

import java.util.Map;

import de.tudarmstadt.ukp.dkpro.wsd.si.POS;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventoryException;

/**
 * An interface for word sense disambiguation algorithms which take a single
 * subject of disambiguation (typically a lemma) represented by a {@link String}
 * and an associated part of speech, along with the context in which this
 * subject occurs (represented by another {@link String}), and return a map of
 * sense IDs to confidence values.
 *
 * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 *
 */
public interface WSDAlgorithmContextPOS
	extends WSDAlgorithm
{
	public Map<String, Double> getDisambiguation(String sod, POS pos,
			String context)
		throws SenseInventoryException;
}
