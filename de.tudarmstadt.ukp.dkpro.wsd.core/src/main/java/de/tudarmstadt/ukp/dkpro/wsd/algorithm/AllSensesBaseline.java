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

package de.tudarmstadt.ukp.dkpro.wsd.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.tudarmstadt.ukp.dkpro.wsd.si.POS;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventory;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventoryException;

/**
 * A word sense disambiguation algorithm which, given a subject of
 * disambiguation, looks up all the candidate senses in the sense inventory and
 * chooses all of them, splitting the confidence scores evenly. This approach is
 * more useful than the random sense baseline as its results are consistently
 * reproducible; the score for repeated runs of the random sense baseline will
 * converge to that of this algorithm anyway.
 *
 * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 *
 */
public class AllSensesBaseline
    extends AbstractWSDAlgorithm
    implements WSDAlgorithmIndividualBasic, WSDAlgorithmIndividualPOS
{

    public AllSensesBaseline(SenseInventory inventory)
    {
        super(inventory);
    }

    @Override
    public Map<String, Double> getDisambiguation(String sod)
        throws SenseInventoryException
    {
        List<String> senses = inventory.getSenses(sod);
        if (!senses.isEmpty()) {
            double[] confidenceValues = new double[senses.size()];
            Arrays.fill(confidenceValues, 1.0 / senses.size());
            return getDisambiguationMap(senses.toArray(new String[0]),
                    confidenceValues);
        }

        return null;
    }

    @Override
    public Map<String, Double> getDisambiguation(String sod, POS pos)
        throws SenseInventoryException
    {
        List<String> senses = inventory.getSenses(sod, pos);
        if (!senses.isEmpty()) {
            double[] confidenceValues = new double[senses.size()];
            Arrays.fill(confidenceValues, 1.0 / senses.size());
            return getDisambiguationMap(senses.toArray(new String[0]),
                    confidenceValues);
        }

        return null;
    }
}