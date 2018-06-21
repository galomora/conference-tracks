# conference-tracks
Implementation of Conference Tracks problem

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d726f02788b048bc8abcf148a751da72)](https://www.codacy.com/app/galomora/conference-tracks?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=galomora/conference-tracks&amp;utm_campaign=Badge_Grade)

[![Build Status](https://travis-ci.org/galomora/conference-tracks.svg?branch=master)](https://travis-ci.org/galomora/conference-tracks)

Greetings

I have chosen PROBLEM TWO: CONFERENCE TRACK MANAGEMENT

I have used the language Java

- I established a model wich includes classes for Conference, Session, Track an Talk
in the package ec.gm.tracks.model
- Classes that contain all the logic to implement the solution in the package
ec.gm.tracks.process
- The file loading and parsing logic is contained in the classes in the package
ec.gm.tracks.input
- The main logic contains backtracking (recursivity) to obtain the solution


## FILE STRUCTURE
###############################

Project directory contains:

Directories:

- src/main/java - Contains the source code for the app
- src/main/resources - Contains an input file example, containing the input described in Problem Two
- src/test/java - Contains source code for the unit tests

Files:

- pom.xml - Maven POM descriptor used to build an executable jar, and execute unit tests

## PREREQUISITES
###############################

Java version 7 is required, and shall be accesible from command line

This is usually achieved defining the environment variables: 

- JAVA_HOME whose value is Java installation directory
- PATH, adding the variable JAVA_HOME followed by subdirectory bin


## INSTRUCTIONS TO COMPILE
###############################

Apache Maven is required, can be executed from command line or an IDE, personally I use Eclipse IDE.

Tested with Apache Maven version 3.3.9

To compile from command line:

Maven shall be available in the path environment variable, this is usually achieved defining the environment variables: 

- MAVEN_HOME whose value is Maven installation directory
- PATH, adding the variable MAVEN_HOME followed by subdirectory bin, may refer to Maven installation guide

In command line:
1. Enter to project directory
2. Execute the command:
mvn clean install

this should create a subdirectory target in the current directory containing the file conference-tracks-0.0.1-SNAPSHOT.jar.
This file is the executable compiled jar

## TO RUN UNIT TESTS
###############################

Same command as compiling:

In command line:
1. Enter to project directory
2. Execute the command:
mvn clean install

This should create a subdirectory surefire-reports in the current directory containing the JUnit reports

## INSTRUCTIONS TO RUN THE APP
###############################

Place the executable jar file conference-tracks-0.0.1-SNAPSHOT.jar (found in directory target after compiling) and input text file containing the talks, in the same directory

Sample input file is provided in directory resources

In command line:
1. Enter to the directory containing the executable jar and talks file
2. Execute the command:

java -jar conference-tracks-0.0.1-SNAPSHOT.jar <TALKS_FILE_NAME>

TALKS_FILE_NAME is the name of the text file containing the talks list. 

This parameter is optional provided there is a text file named "talks" (without quotes, no extension)

If no talks file is found, you will see a message:
- Cannot find talks file, place a file named talks in the current directory

If talks file is found in the same directory, the program will execute and show the output

## RUNNING THE APP WITH PROVIDED FILE
###############################

Place the executable jar file conference-tracks-0.0.1-SNAPSHOT.jar and talks file (provided in the directory src/main/resources), in the same directory

The provided file is a text file that contains the talks definition (Test input) defined in PROBLEM TWO: CONFERENCE TRACK MANAGEMENT spec

That is:

```
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
Ruby Errors from Mismatched Gem Versions 45min
Common Ruby Errors 45min
Rails for Python Developers lightning
Communicating Over Distance 60min
Accounting-Driven Development 45min
Woah 30min
Sit Down and Write 30min
Pair Programming vs Noise 45min
Rails Magic 60min
Ruby on Rails: Why We Should Move On 60min
Clojure Ate Scala (on my project) 45min
Programming in the Boondocks of Seattle 30min
Ruby vs. Clojure for Back-End Development 30min
Ruby on Rails Legacy App Maintenance 60min
A World Without HackerNews 30min
User Interface CSS in Rails Apps 30min
```

Executing the program with the command line:

java -jar conference-tracks-0.0.1-SNAPSHOT.jar

will give the output:

```
Track No. 1:
09:00 AM Writing Fast Tests Against Enterprise Rails 60min
10:00 AM Overdoing it in Python 45min
10:45 AM Lua for the Masses 30min
11:15 AM Ruby Errors from Mismatched Gem Versions 45min
12:00 AM Lunch
01:00 PM Common Ruby Errors 45min
01:45 PM Communicating Over Distance 60min
02:45 PM Accounting-Driven Development 45min
03:30 PM Woah 30min
04:00 PM Sit Down and Write 30min
04:30 PM Programming in the Boondocks of Seattle 30min
05:00 PM Networking Event

Track No. 2:
09:00 AM Pair Programming vs Noise 45min
09:45 AM Rails Magic 60min
10:45 AM Clojure Ate Scala (on my project) 45min
11:30 AM Ruby vs. Clojure for Back-End Development 30min
12:00 AM Lunch
01:00 PM Rails for Python Developers lightning
01:05 PM Ruby on Rails: Why We Should Move On 60min
02:05 PM Ruby on Rails Legacy App Maintenance 60min
03:05 PM A World Without HackerNews 30min
03:35 PM User Interface CSS in Rails Apps 30min
04:05 PM Networking Event
```

Main difference with Test output provided in PROBLEM TWO: CONFERENCE TRACK MANAGEMENT spec is time in Track No. 2 last activity, Networking Event

In test output provided:
- 05:00PM Networking Event

In my execution
- 04:05 PM Networking Event

I have chosen this because of the specification:
- The networking event can start no earlier than 4:00 and no later than 5:00

So it works according to the spec

To be honest I'm not sure why it is 05:00 PM time in the provided test output, the previous activity is:

- 04:00PM Rails for Python Developers lightning

with a duration lightning = 5 minutes starting at 04:00 PM

so I think the next activity should start at 04:05 PM

That's all

Greetings

Galo Mora

Quito, Ecuador

THANKS :)



