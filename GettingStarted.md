# Getting started with DKPro WSD #

## System requirements ##

DKPro WSD is not a standalone WSD system, but rather a development framework and library consisting of a type system, a Java API, and Apache UIMA components.  To use it you will need a Java development framework and runtime environment supporting Java 6 or later.

## Obtaining DKPro WSD ##

The Google Code Subversion repository contains [source code for DKPro WSD](https://code.google.com/p/dkpro-wsd/source/checkout) and the [DKPro WSD GPL components](https://code.google.com/p/dkpro-wsd-gpl/source/checkout).

If you are a Maven user, you can obtain prepackaged artifacts by adding the following repository section to your project:

```
<repositories>
  <repository>
    <id>ukp-oss-releases</id>
    <url>http://zoidberg.ukp.informatik.tu-darmstadt.de/artifactory/public-releases</url>
   </repository>
</repositories>
```

You can then add individual DKPro WSD artifacts to your POM.  For example:
```
<dependency>
    <groupId>de.tudarmstadt.ukp.dkpro.wsd</groupId>
    <artifactId>de.tudarmstadt.ukp.dkpro.wsd.core</artifactId>
    <version>1.2.0</version>
</dependency>
```

(Of course, you will probably always want to use the latest available version.)

## Obtaining data and resources ##

Data and resources such as sense inventories and sense-annotated corpora are not included with DKPro WSD.  These can be many gigabytes in size, and are usually not freely redistributable by third parties such as us, so you need to obtain them yourself.

Our [table of WSD corpora](WSDCorpora.md) includes links to where you can download the most commonly used WSD data sets, including the Senseval and SemEval tasks.  Be aware that these data sets often have syntax errors and other problems which make them impossible to use as-is.  We provide [patches and conversion scripts](https://code.google.com/p/dkpro-wsd/source/browse/#svn%2Ftrunk%2Fde.tudarmstadt.ukp.dkpro.wsd.senseval%2Fsrc%2Fmain%2Fresources) to fix many of these problems.

Our [table of lexical semantic resources](LSRs.md) includes links to where you can download the most commonly used sense inventories.

## Example code ##

You can get a good feel for DKPro WSD's capabilities by examining and running the example code.  The [DKPro WSD GPL project](https://code.google.com/p/dkpro-wsd-gpl/source/checkout) has a module, `de.tudarmstadt.ukp.dkpro.wsd.examples`, containing several short example programs.  Read through the example documentation, make the indicated changes to the variables so that they point to the required resources on your file system, and then run them.