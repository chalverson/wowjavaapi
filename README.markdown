About
=====

This is a Java implementation of the Blizzard World of Warcraft API published
at [http://blizzard.github.com/api-wow-docs/](http://blizzard.github.com/api-wow-docs/).

This API follows the DAO pattern for access to the API. It uses simple Java Beans for entity modelling.

There are a number of Junit tests that test the parsing of the resulting JSON. In order to run the tests, you will need
the [http://mockito.org/](Mockito) mock library and JUnit. These are not needed to use the API, just for testing. Anything in the
test hierarchy is not needed to use the API. It includes pre-generated JSON responses from the API to speed up testing
and to just test the JSON parsing and not require a network connection to run the tests. In other words, we just assume
the network reading code works as expected (it's pretty simple, so it should always work and throw the correct
exception if it doesn't).

This libaray current supports the Character, Guild and Realm areas of the Blizzard API.

Use at your own risk, this comes with no warranty.

Dependencies
============

* [Google Gson](http://code.google.com/p/google-gson/) is required to use this API. The allows the parsing of JSON
directly into Java objects. Plus I didn't want to reinvent the wheel.

* [Mockito](http://mockito.org/) for unit testing

* [JUnit](http://junit.org/) for unit testing

The argument checking code was taken from [Google Guava](http://code.google.com/p/guava-libraries/).

Usage
=====

Characaters are retrieved via the CharacterDao class:

    CharacterDao dao = new CharacterDao(); // Defaults to US Region
    Character borvoh = dao.getCharacter("Duskwood", "Borvoh");

    // To get reputation
    Characater repUser = dao.getCharacter("Duskwood", "Borvoh", CharacterOptions.REPUTATION);

There are a number of getCharacter methods using varying defaults. See the JavaDoc for details.

Guilds are retrieved via the GuildDao class:

    GuildDao dao = new GuildDao(); // Defaults to US
    Guild guild = dao.getGuild("Duskwood", "Sheep the Moon");

Realm status is retrieved via the RealmDao class:

    RealmDao dao = new RealmDao();
    Realm duskwood = dao.getRealmStatus("Duskwood");


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
