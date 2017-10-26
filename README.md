# Tatai Project

This application is built for training in mathematical skills and recognition of Māori numbers, targeted towards smaller children. The GUI is implemented via JavaFX and Scenebuilder, with the main functionality being performed through Bash Scripting, and ProcessBuilder.

## Computer Requirements

To maximise the probability of the application running without problems, the user should run the application on a Linux OS, preferably Ubuntu. In order to be able to run this application and use it succesfully, you must have the following folder structure, after having unzipped the Project.zip:

```
Project
|
|__Tatai.jar (JAR file, from which you shold run the application)
|
|__HTK (External Speech Recognition Software)
|  |
|  |_MaoriNumbers
|     |
|     |__GoSpeech (Script file that does the GUI's speech recognition)
|     |
|     |__recout.mlf (GUI Created recognition file that stores what was said)
|     |
|     |__HMMs
|     |  |__ ...
|     |
|     |__user
|        |__ ...
|
|
|__README.md (Where you are, if you are reading this currently)
```

## Getting Started

### Running via Command Line:
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

**_NOTE: DUE TO THE WAY WE HAVE DESIGNED THE PROGRAM, AT THIS POINT IF YOU WISH TO RUN THE APPLICATION BY DOUBLE CLICKING IT, READ ONTO THE NEXT SUBSECTION, ENTITLED: "RUNNING VIA DOUBLE-CLICKING THE APPLICATION._**

If running the jar from the command line, use the command:

```
$ xdg-open Tatai.jar
```
Provided the folder structure was as specified before, this should run the program fine, and you should be able to succesfully use all of the features of the application!


### Running via double-clicking application:

As stated before, upon extracting the contents of the Project.zip, the user should have a folder structure exactly the same as the following:

```
Project
|
|__Tatai.jar (JAR file, from which you shold run the application)
|
|__HTK (External Speech Recognition Software)
|  |
|  |_MaoriNumbers
|     |
|     |__GoSpeech (Script file that does the GUI's speech recognition)
|     |
|     |__recout.mlf (GUI Created recognition file that stores what was said)
|     |
|     |__HMMs
|     |  |__ ...
|     |
|     |__user
|        |__ ...
|
|
|__README.md (Where you are, if you are reading this currently)
```

To run the application by double-clicking the JAR from a file explorer, **you must move the HTK folder in its entirety to your Home Directory**. An example of the Home Directory in Linux, is given in the following image:

[Home Directory Example Image](https://www.howtogeek.com/wp-content/uploads/2014/08/hidden-configuration-folders-in-ubuntu-home-folder.png)

****Note the sidebar, and the "Home" Option, highlighted in orange. If your file explorer sidebar looks like that in the picture above, then you are in the correct Home Directory.****

Upon succesfully moving the entire HTK folder to the Home Directory, the user may run the application by double-clicking it, regardless of where exactly the runnable JAR is. It is of note however, that once the HTK folder is moved to the Home Directory, the user may possibly not utilise the first method of running the application via the command line.

Any questions regarding the usage of the application or the initial setup, can be forwarded on to either one of the following email addresses:

_**crai897@aucklanduni.ac.nz**_

_**tmcl494@aucklanduni.ac.nz**_


Enjoy!
