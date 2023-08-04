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
