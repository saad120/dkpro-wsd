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
package de.tudarmstadt.ukp.dkpro.wsd.wsi.algorithm;

import java.util.Collection;

import de.tudarmstadt.ukp.dkpro.wsd.WSDException;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventory;

public interface SenseInductionAlgorithm
{
    /**
     * Starts a batch induction
     * 
     * @param targetWords
     * @return
     */
    public SenseInventory induce(Collection<String> targetWords);

    /**
     * @param term
     * @throws WSDException
     */
    public void induceSenses(String term)
        throws WSDException;

    /**
     * Returns
     * 
     * @return
     */
    public SenseInventory getSenseInventory();
}