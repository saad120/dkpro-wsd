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
package de.tudarmstadt.ukp.dkpro.wsd.si.resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import net.sf.extjwnl.JWNLException;

import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.uimafit.descriptor.ConfigurationParameter;

import de.tudarmstadt.ukp.dkpro.core.api.resources.ResourceUtils;
import de.tudarmstadt.ukp.dkpro.wsd.si.SenseInventoryException;
import de.tudarmstadt.ukp.dkpro.wsd.si.wordnet.WordNetSynsetSenseInventory;

/**
 * A resource wrapping {@link WordNetSynsetSenseInventory}
 *
 * @author Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 *
 */
public class WordNetSynsetSenseInventoryResource
    extends SenseInventoryResourceBase
{
    public static final String PARAM_WORDNET_PROPERTIES_URL = "wordNetPropertiesURL";
    @ConfigurationParameter(name = PARAM_WORDNET_PROPERTIES_URL, description = "The URL of the WordNet properties file", mandatory = true)
    protected String wordNetPropertiesURL;

    public static final String PARAM_SENSE_DESCRIPTION_FORMAT = "senseDescriptionFormat";
    @ConfigurationParameter(name = PARAM_SENSE_DESCRIPTION_FORMAT, description = "A format string specifying how sense descriptions should be printed", mandatory = false)
    protected String senseDescriptionFormat;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean initialize(ResourceSpecifier aSpecifier,
            Map aAdditionalParams)
        throws ResourceInitializationException
    {
        if (!super.initialize(aSpecifier, aAdditionalParams)) {
            return false;
        }

        try {
            inventory = new WordNetSynsetSenseInventory(
                    ResourceUtils.resolveLocation(wordNetPropertiesURL, this,
                            null));
        }
        catch (MalformedURLException e) {
            throw new ResourceInitializationException(e);
        }
        catch (JWNLException e) {
            throw new ResourceInitializationException(e);
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }

        if (senseDescriptionFormat != null) {
            ((WordNetSynsetSenseInventory) inventory)
                    .setSenseDescriptionFormat(senseDescriptionFormat);
        }
        return true;
    }

    /**
     * Given a lemma and a string representing a synset + part of speech,
     * returns a corresponding sense key.
     *
     * @param senseId
     * @param lemma
     * @return
     * @throws SenseInventoryException
     */
    public String getWordNetSenseKey(String senseId, String lemma)
        throws SenseInventoryException
    {
        return ((WordNetSynsetSenseInventory) inventory).getWordNetSenseKey(senseId,
                lemma);
    }

}
