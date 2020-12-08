# Maintenance Guide

Into the dark is a Java programme based on the libGDX framework.

## <a name="prerequisites">Prerequisites</a>

- Java Development Kit 8+ (Must be JDK)
- libGDX

The only direct prerequisite needed to contribute to the game is libGDX. 
All the indirect prerequisites needed to setup libGDX (including JDK) and extensive setup guides for several IDEs can be found [here](https://libgdx.badlogicgames.com/documentation/gettingstarted/Setting%20Up.html). We highly recommend following libGDX's setup guides before moving on. 

## Project organization

Make sure to satisfy all the [prerequisites](#prerequisites) before moving on.

### Introduction
libGDX comes with a predefined structure optimized for multiplatform development.
In this project this structure is represented inside the [DungeonCrafter](../../DungeonCrafter) directory.
Two kinds of subdirectories exist: platform-specific directories and a logic directory.
Platform-specific directories only consist of code specific to the according platform, while the logic directory holds all the project's actual platform independent logic.
The platform-specific code accesses the logical code and makes it accessible to the respective platform. 
For more information on platform-specific setups in libGDX, refer to [libGDX](https://libgdx.badlogicgames.com/documentation/gettingstarted/Creating%20Projects.html#structure-of-libgdx-projects).

### Platform support
Into the Dark is currently setup to only work on Desktop. 
You find all the desktop-specific code in [DungeonCrafter/desktop](../../DungeonCrafter/desktop).
If you want to extend the game to work in a browser or on iOS or android, please refer to libGDX's guides [guides](https://libgdx.badlogicgames.com/documentation/gettingstarted/Creating%20Projects.html#structure-of-libgdx-projects).

### Game Logic - MVC
The game logic is found in the [DungeonCrafter/core](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter) directory.
The game is structured by the Model-View-Controller pattern (MVC) according to [this](https://otter.tech/an-mvc-guide-for-libgdx/) libGDX's specific MVC-guide.
The controller logic of the game is found in the [DungeonCrafter](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/DungeonCrafter.java) file.
The view logic of the game is spread over several classes in the [screens](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/screens) directory.
The model logic of the game is spread over several classes in the [classes](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/classes) directory.

#### Controller
The controller holds the current game model, the audioManager, KeyListener and assetManager.
Furthermore, the [controller](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/DungeonCrafter.java) takes care of initializing and changing between all the game screens.
If a new game screen is setup, it needs to be initialized in the controller.

#### View
The view logic is spread over several screen classes. 
Depending on the current location in the game, a different screen is active.
There is an abstract [BaseScreen](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/screens/BaseScreen.java) class,
from which all the other screens inherit from.
New screens have to inherit from BaseScreen.

##### How to add a new screen
1. Create new class inside [screens](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/screens) directory.
2. Make sure the class inherits from [BaseScreen](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/screens/BaseScreen.java).
3. Make sure the class overrides the following methods: (init(), draw(), keyDown(), keyUp(), keyTyped(), touchDown(), touchUp(), touchDragged(), mouseMoved(), scrolled(), pause(), resume(), hide())
4. Go to [DungeonCrafter](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/DungeonCrafter.java) and initialize the new screen in the loadScreens() methods like the other screens.
5. Switch to screen by calling changeScreen(NEWSCREEN.class) on your controller instance.


#### Model
The model logic is spread over several classes, but all the information will be held by a [GameModel](../../DungeonCrafter/core/src/dev/teamcyan/dungeoncrafter/classes/GameModel.java) instance.
The map, the player, the sidekick pebble and enemies origin here. 
Therefore, if you want to add enemies to the game, change positions of any character, etc. this is the class to go to and make according changes.
