About
=====

This is a Java implementation of the Blizzard World of Warcraft API published
at [http://blizzard.github.com/api-wow-docs/](http://blizzard.github.com/api-wow-docs/).

This API follows the DAO pattern for access to the API. It uses simple Java Beans for entity modelling.

There are a number of Junit tests that test the parsing of the resulting JSON. In order to run the tests, you will need
the [http://mockito.org/](Mockito) mock library. This is not needed to use the API, just for testing. Anything in the
test hierarchy is not needed to use the API. It includes pre-generated JSON responses from the API to speed up testing
and to just test the JSON parsing and not require a network connection to run the tests. In other words, we just assume
the network reading code works as expected (it's pretty simple, so it should always work and throw the correct
exception if it doesn't).

Dependencies
============

* [http://code.google.com/p/google-gson/](Google Gson) is required to use this API. The allows the parsing of JSON
directly into Java objects.

* [http://mockito.org/](Mockito) for unit testing

* [http://junit.org/](JUnit) for unit testing

The argument checking code was taken from [http://code.google.com/p/guava-libraries/](Google Guava) but since I didn't
use anything else I just copied that directly.

License
=======

Copyright (C) 2011 Chris D. Halverson <cdh@halverson.org>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
