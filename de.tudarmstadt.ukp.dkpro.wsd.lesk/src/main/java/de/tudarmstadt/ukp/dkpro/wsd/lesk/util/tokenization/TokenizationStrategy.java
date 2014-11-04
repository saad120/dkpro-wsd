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

package de.tudarmstadt.ukp.dkpro.wsd.lesk.util.tokenization;

import java.util.List;

/**
 * Strategies for tokenizing a string into a list of strings
 *
 * @author	Tristan Miller <miller@ukp.informatik.tu-darmstadt.de>
 */
public interface TokenizationStrategy
{
	/**
	 * Tokenizes a string into a list of strings
	 *
	 * @param s	the string to tokenize
     * @return	a list of strings
	 */
	public List<String> tokenize(String s);
}
