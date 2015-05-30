# 1.1.0 (released on 2014-06-16) #

  * Evaluators now permit chaining of backoff algorithms ([Issue 29](https://code.google.com/p/dkpro-wsd/issues/detail?id=29))
  * Added annotators that allow for disambiguating the complete text collectively ([Issue 56](https://code.google.com/p/dkpro-wsd/issues/detail?id=56))
  * Added a weighted MFS baseline
  * Sense cluster evaluator now computes McNemar's test
  * Sense cluster evaluator now handles the case where there are multiple gold-standard senses, and includes undisambiguated instances in the confusion matrix
  * Improved logging output
  * Various bugfixes

# 1.0.0 (released on 2013-11-29) #

New features:
  * Support for the It Makes Sense (IMS) disambiguator. ([Issue 20](https://code.google.com/p/dkpro-wsd/issues/detail?id=20))
  * Added a sense inventory wrapping the GermaNet Java API. ([Issue 47](https://code.google.com/p/dkpro-wsd/issues/detail?id=47))
  * WebCAGe data set reader now works with the official release of WebCAGe. ([Issue 13](https://code.google.com/p/dkpro-wsd/issues/detail?id=13))
  * SemCor reader now optionally writes Token, Lemma, and POS annotations. ([Issue 49](https://code.google.com/p/dkpro-wsd/issues/detail?id=49))
  * Readers of XML-based data sets can now optionally ignore the DTD. ([Issue 43](https://code.google.com/p/dkpro-wsd/issues/detail?id=43))
  * New wrapper module for easy disambiguation of a text string. ([Issue 38](https://code.google.com/p/dkpro-wsd/issues/detail?id=38))
  * Senseval answer key readers now optionally normalize the sense confidence. ([Issue 42](https://code.google.com/p/dkpro-wsd/issues/detail?id=42))
  * Cluster evaluator's output is more verbose and informative.
  * Improved logging output in various modules.

Bug fixes:
  * SemCor reader now sets correct annotation offsets. ([Issue 52](https://code.google.com/p/dkpro-wsd/issues/detail?id=52))
  * Methods in si.dictionary inventories now correctly throw an exception when passed an invalid sense ID. ([Issue 45](https://code.google.com/p/dkpro-wsd/issues/detail?id=45))


API/dependency changes:
  * Restructured the package hierarchy.  Users will need to update some package references (e.g., in import statements). ([Issue 48](https://code.google.com/p/dkpro-wsd/issues/detail?id=48))
  * Upgraded to DKPro Lab 0.10.0 and TWSI 1.0.2. ([Issue 33](https://code.google.com/p/dkpro-wsd/issues/detail?id=33))

# 0.9.1 (released on 2013-10-14) #

  * Upgraded to DKPro Core 1.5.0, uimaFIT 2.0.0, UBY 0.4.0, and TWSI 1.0.1. ([Issue 33](https://code.google.com/p/dkpro-wsd/issues/detail?id=33))
  * Added module for word sense induction. ([Issue 11](https://code.google.com/p/dkpro-wsd/issues/detail?id=11))
  * Moved Wikipedia-specific graph algorithms to a separate module. ([Issue 34](https://code.google.com/p/dkpro-wsd/issues/detail?id=34))

# 0.9.0 (released on 2013-08-14) #

Initial preview release.