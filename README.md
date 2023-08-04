# XML Testbed

The purpose of this repo is to compare and contrast a few different libraries for generating and
parsing XML on Android. Each library has its own module.

## simplexml

Uses the [SimpleXML](https://simple.sourceforge.net/) library. It is a very popular XML parser that
has been around for a long time, and is frequently recommended in articles on the subject. Its main 
dependencies are the [StAX](https://www.xml.com/pub/a/2003/09/17/stax.html) and [XPP3](https://github.com/codelibs/xpp3)
pull parsers. Benefits of SimpleXML include a proven and stable implementation, a small library size
(less than 1 MB) and an extensive documentation with plenty of tutorials and examples.

### Usage

Usage is very straightforward at the point of (de)serialization but DTOs must be specially designed
to work with SimpleXML. All fields must be mutable with default values and there must be an empty
class constructor; in addition, custom attributes are used to control the XML format. While these
offer a lot of power and flexibility, knowing the right ones to use can be tricky.

### Known issues

SimpleXML has [one known vulnerability](https://www.cvedetails.com/cve/CVE-2017-1000190/) by which
the parser can be made to include an arbitrary file from the local file system. This is not 
exploitable unless an attacker is able to inject a document specially crafted to exploit the
vulnerability. However, a [fixed version](https://github.com/carrotsearch/simplexml-safe) which also
includes modernization for Java 8 is also available and is the one used here.

## xmlutil

Uses the [xmlutil](https://github.com/pdvrieze/xmlutil) library which is based on the
[kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) library and compiler
plugin. This allows for easier use of Kotlin constructs, but the library is relatively new and still
in active development, although it has a fair number of users. Unfortunately there isn't much in
the way of examples or tutorials, and the documentation is little more than a README.

### Usage

Usage is very straightforward and regular Kotlin data classes work just fine, although they do need
special attributes that control serialization. By default, the type name rather than the field name
is used as the name of the element/attribute in the serialized XML, which requires a lot of explicit
naming. The project must include the Kotlin serialization compiler plugin.

### Known issues

See the [issue tracker](https://github.com/pdvrieze/xmlutil/issues). At this time there are no known
security vulnerabilities. The project README file calls out that additional testing is needed, and
as the library is relatively new, issues should be expected to pop up from time to time. Using this
library would require developers to pay attention and stay up to date with new releases.

## tikxml

Uses the [tikxml](https://github.com/Tickaroo/tikxml) library. This is a very lightweight library
which appears to be pretty popular and well-used. Sadly, it has been left in a somewhat sorry 
state after several years of no maintenance, having quite a number of unfixed issues - the most
recent version isn't even published anywhere. Due to unstable ordering of elements, tikxml
can't pass a roundtrip test.

### Usage

Usage is less straightforward than other libraries because tikxml requires additional configuration,
and does not support all primitive types (neither enums nor floats are supported by default). There
are no convenience methods that take strings or string buffers. Tikxml relies on kapt annotation
processing, so the project must include the kapt plugin.

### Known issues

See the [issue tracker](https://github.com/Tickaroo/tikxml/issues). At this time there are no known
security vulnerabilities, but the generally shoddy state of the library and lack of maintenance for
something that was never finished to begin with does not inspire confidence. The project has a
number of open issues that may never be fixed, most notably, the support for overriding default
type converters appears to be broken in the most recently published release.

## Other libraries

* [codemonstur/simplexml](https://github.com/codemonstur/simplexml) is another XML library also
  named SimpleXML, seems easy to use, lightweight, and in active development. However recent
  versions only support Java 19, which makes it a non-starter on Android at this time.
* [Jakarta XML Binding (JAXB)](https://javaee.github.io/jaxb-v2/) used to be the default XML
  framework embedded into Java, meaning it has a lot of features and excellent documentation. It's
  also not compatible with Android by default, [though people have made it work](https://stackoverflow.com/questions/5461127/using-jaxb-with-google-android),
  driven by the need for compatibility with legacy systems.
