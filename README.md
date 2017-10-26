# Tatai Project

This application is built for training in mathematical skills and recognition of Māori numbers, targeted towards smaller children. The GUI is implemented via JavaFX and Scenebuilder, with the main functionality being performed through Bash Scripting, and ProcessBuilder.

## Computer Requirements

In order to be able to run this application and use it succesfully, you must have the following folder structure, after having unzipped the Project.zip:

```
Project
|
|__Tatai.jar (JAR file, from which you shold run the application)
|
|__HTK (External Speech Recognition Software)
|  |
|  |__GoSpeech (Script file that does the GUI's speech recognition)
|  |
|  |__recout.mlf (GUI Created recognition file that stores what was said)
|  |
|  |__HMMs
|  |  |__ ...
|  |
|  |__user
|     |__ ...
|
|__README.md (Where you are, if you are reading this currently)
```

## Getting Started

These instructions will get your copy of the project up and running on your local machine for development and testing purposes. In order to run the application on your own personal computer, one must first perform the following commands from the command line, within their environment:

```
$ sudo apt update
$ sudo apt upgrade
$ sudo apt install openjfx
```
Having done this, the user must then navigate to where they have unzipped the Project.zip, and enter the Project directory.
Following from this, the user must make the application jar executable: at this point, the Tatai.jar should be listed, upon the user performing the following command, from within the Project folder:

```
$ ls 
```

If the JAR does get echoed in the terminal upon performing this command, then the user is in the right location, to continue on to succesfully run it. From here, the user should either type:

```
$ chmod a+x Tatai.jar
```
or 
```
$ chmod 777 Tatai.jar
```
in order to make the JAR executable. 

**__NOTE: DUE TO THE WAY WE HAVE DESIGNED THE PROGRAM, AT THIS POINT THE USER CAN ONLY SUCCESFULLY RUN THE PROGRAM FROM THE COMMAND LINE AND NOT BY DOUBLE CLICKING THE JAR IN A FILE EXPLORER.__**

If running the jar from the command line, use the command:

```
$ xdg-open Tatai.jar
```
Provided the folder structure was as specified before, this should run the program fine, and you should be able to succesfully use all of the features of the application!



[alt text](https://www.howtogeek.com/wp-content/uploads/2014/08/hidden-configuration-folders-in-ubuntu-home-folder.png)

**NOTE THIS APPLICATION RELIES ON THE LOCATIONS OF ALL THE HTK FILES BEING RELATIVELY THE SAME AS THE LOCATIONS OF THE HTK FILES PROVIDED IN THE VIRTUAL MACHINE FROM CATHERINE WATSON.**

Enjoy!
