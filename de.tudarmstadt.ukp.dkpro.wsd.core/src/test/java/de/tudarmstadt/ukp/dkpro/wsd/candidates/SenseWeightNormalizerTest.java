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

package de.tudarmstadt.ukp.dkpro.wsd.candidates;


// TODO: Rewrite to eliminate dependency on Senseval reader


public class SenseWeightNormalizerTest
{
//	@Test
//	public void senseWeightNormalizerTest()
//    throws Exception
//	{
//		WSDItem w;
//		WSDResult r;
//
//		CollectionReader reader = createCollectionReader(
//                Senseval2LSReader.class,
//                Senseval2LSReader.PARAM_FILE, "classpath:/senseval/senseval2ls.xml"
//                );
//        AnalysisEngineDescription answerReader = createPrimitiveDescription(
//                SensevalAnswerKeyReader.class,
//                SensevalAnswerKeyReader.PARAM_FILE, "classpath:/senseval/senseval2ls.key"
//        );
//        AnalysisEngineDescription senseWeightNormalizer = createPrimitiveDescription(
//                SenseConfidenceNormalizer.class
//        );
//        AnalysisEngineDescription aggregate = createAggregateDescription(
//           		answerReader,
//           		senseWeightNormalizer
//            );
//
//        AnalysisEngine engine = createAggregate(aggregate);
//        JCasIterable i = new JCasIterable(reader, engine);
//		assertTrue(i.hasNext());
//		JCas j = i.next();
//
//		w = JCasUtil.selectByIndex(j, WSDItem.class, 0);
//		r = JCasUtil.selectByIndex(j, WSDResult.class, 0);
////		System.out.println(r.toSensevalAnswerKey());
//		assertEquals(w, r.getWsdItem());
//		assertEquals(0.6, r.getSenses(0).getConfidence(), 0.001);
//		assertEquals(0.4, r.getSenses(1).getConfidence(), 0.001);
//
//		r = JCasUtil.selectByIndex(j, WSDResult.class, -1);
//		assertEquals(w, r.getWsdItem());
//
//		assertTrue(i.hasNext());
//		j = i.next();
//
//		w = JCasUtil.selectByIndex(j, WSDItem.class, -1);
//		r = JCasUtil.selectByIndex(j, WSDResult.class, -1);
////		System.out.println(r.toSensevalAnswerKey());
//		assertEquals(w, r.getWsdItem());
//		assertNull(r.getComment());
//		assertEquals(0.5, r.getSenses(0).getConfidence(), 0.001);
//		assertEquals(0.5, r.getSenses(1).getConfidence(), 0.001);
//	}

}
