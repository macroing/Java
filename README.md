Macroing Java
=============
Macroing Java is an extension to the standard Java library.

Getting Started
---------------
To clone this repository and build the project using Apache Ant, you can type the following in Git Bash.

```bash
git clone https://github.com/macroing/Java.git
cd Java
ant
```

Supported Features
------------------
 - `org.macroing.java.awt.image` provides an extension to `java.awt.image`.
 - `org.macroing.java.io` provides an extension to `java.io`.
 - `org.macroing.java.lang` provides an extension to `java.lang`.
 - `org.macroing.java.util` provides an extension to `java.util`.
 - `org.macroing.java.util.concurrent.atomic` provides an extension to `java.util.concurrent.atomic`.
 - `org.macroing.java.util.function` provides an extension to `java.util.function`.

Documentation
-------------
The documentation for this library can be found in the Javadocs that are generated when building it.

Library
-------
The following table describes the different APIs and their current status in the library.

| Name                                     | Javadoc | Unit Test | Package                                  |
| ---------------------------------------- | ------- | --------- | ---------------------------------------- |
| Macroing Java AWT Image API              | 100.0%  |   0.0%    | org.macroing.java.awt.image              |
| Macroing Java I/O API                    | 100.0%  |   0.0%    | org.macroing.java.io                     |
| Macroing Java Lang API                   | 100.0%  | 100.0%    | org.macroing.java.lang                   |
| Macroing Java Util API                   | 100.0%  |   0.0%    | org.macroing.java.util                   |
| Macroing Java Util Concurrent Atomic API | 100.0%  |   0.0%    | org.macroing.java.util.concurrent.atomic |
| Macroing Java Util Function API          | 100.0%  | 100.0%    | org.macroing.java.util.function          |

Dependencies
------------
 - [Java 8](http://www.java.com).

Note
----
This library has not reached version 1.0.0 and been released to the public yet. Therefore, you can expect that backward incompatible changes are likely to occur between commits. When this library reaches version 1.0.0, it will be tagged and available on the "releases" page. At that point, backward incompatible changes should only occur when a new major release is made.