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
package de.tudarmstadt.ukp.dkpro.wsd.si;

import java.util.Set;

/**
 * An interface for sense inventories which encode alignments between senses
 *
 * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 *
 */
public interface SenseAlignment
    extends SenseInventory
{
    /**
     * Returns a set of alignments for the given sense
     *
     * @param senseId
     *            The ID of the sense whose alignments should be found
     * @return A (possibly empty) set of sense IDs for aligned senses
     *
     * @throws SenseInventoryException
     */
    public Set<String> getSenseAlignments(String senseId)
        throws SenseInventoryException;

    /**
     * For sense inventories implementing SenseAlignment it is often expensive
     * to compute the sense's alignments. This interface is intended to help
     * such methods cache their sense details so that they need be computed only
     * once.
     *
     * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
     *
     */
    public interface CachedAlignedSense
    {
        public Set<String> getAlignments()
            throws SenseInventoryException;
    }

}
