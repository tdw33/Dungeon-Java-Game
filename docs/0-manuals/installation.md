# Installation Manual


Cross platform compatibility was at the heart of this project. To achieve this we used Java and LibGDX.

The team agreed that given more time we would have looked into porting this to HTML and mobile.

## Notes

### Links

- [releases page](https://github.bath.ac.uk/Team-Cyan/Dungeon/releases/)
is the SSO for our application releases - please alway use the latest version

### Depenedency

- !!! It is very important to use JRE 8 [!Link to the official repository!](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)

---

## Linux and MacOS

1. Download and install JRE 8 for your Distro
2. Download the latest `DungeonCrafter-v1.0.jar`
3. Open a terminal at this location
4. Run `export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)` to set your JRE to 88
5. Run ` java -jar ./DungeonCrafter-v1.0.jar` to play the game

---
## Windows
1. Download and install JRE 1.8 for your Distro
2. Download the latest `DungeonCrafter-v1.0.jar`  
3. Go to `Start -> Control Panel -> System -> Advanced`
4. Click on Environment Variables, under System Variables, find PATH, and click on it.
5. In the Edit windows, modify PATH by adding the location of your jdk8/bin directory to the beginning. If you do not have the item PATH, you may select to add a new variable and add PATH as the name and the location of the directory as the value.
7. Close the window.
6. Reopen Command prompt window, and run java -version to test if the version has changed
8. Open a terminal at the location of your download
8. Run `java -jar ./DungeonCrafter-v1.0.jar` to play the game
