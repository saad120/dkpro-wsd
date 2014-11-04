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

package de.tudarmstadt.ukp.dkpro.wsd.si.lsr.util;

import de.tudarmstadt.ukp.dkpro.lexsemresource.Entity.PoS;
import de.tudarmstadt.ukp.dkpro.wsd.si.POS;
import de.tudarmstadt.ukp.dkpro.wsd.si.lsr.LsrSenseInventory;

/**
 * Utility class for {@link LsrSenseInventory}
 *
 * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 *
 */
public final class LsrSenseInventoryUtil
{
    private LsrSenseInventoryUtil()
    {
        throw new AssertionError();
    }

    public static POS convertPos(PoS pos)
    {
        switch (pos) {
        case n:
            return POS.NOUN;
        case v:
            return POS.VERB;
        case adj:
            return POS.ADJ;
        case adv:
            return POS.ADV;
        default:
            return null;
        }
    }

    public static PoS convertPos(POS pos)
    {
        switch (pos) {
        case NOUN:
            return PoS.n;
        case VERB:
            return PoS.v;
        case ADJ:
            return PoS.adj;
        case ADV:
            return PoS.adv;
        default:
            return PoS.unk;
        }
    }
}
