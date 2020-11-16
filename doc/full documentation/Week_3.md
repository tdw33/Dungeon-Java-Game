# Week 3

## Process

## Weekly Overview
Having a general class structure is helpful when developing the game. However, the class diagram needs to be based on use cases. Internal user stories need to be created when developing game features so that user requirements will be fulfilled and the whole process should be documented for future reference. Moreover, it may be better to set a small rather than a hard-to-reach goal since each sprint is only one week long. It is also helpful to move the tasks which had been done on GitHub in time so that the sprint progress is up-to-date. The team may function better when taking course load into consideration while assigning tasks so that distribution of the development tasks can be more reasonable and effective. 

## Meeting Minutes
### MVC model - Controller, Map and Elements
Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo  
Minutes:  
MVC:
- User uses controller->Controller manipulates model->Model updates view->View sees user
  - Need a model class- the map of all the elements
  - View is the camera - main view takes input and send to controller
  - Controller is all of the characters and elements/methods of the elements
Move:
- View reads position from model
- Player in the model gives player position to the main view->Render(): A key press in main view->sends to controller which interprets the key and then change player position in the model
Map:
- Random map generator
- Menu->seed->generate map
- Every bit of the map has coordinate, get type of environment from coordinate
   - Map has get element at position function, returns game element
  - Destroy-return void
  - Getplayer(): return position
  - private: horizontal & vertical size, seed; have setters & getters
Elements
- Elements relative to the player position
- Elements in environment can become items that can be picked up (update map), interact with player
- Call items in the range of the player
- Every element is on the map, view just takes info from the map
- Action 1 hit-> takes element from the environment and reduces the health

Questions:
- Main view has to be re-rendered when the player gets to the edge of the screen - controller or model?
- Each class has a method called view?
- How to implement main map controller?  

## backlog  
Completed:
- General game structure (features & menu files)
- Class UML diagrams and typings
- Generate a block that can move around
- Pebble backstory
- Research on how github version control works  

Sprint backlog:
- Map generation
- Sprite class and art style
- Menu screens
- Keymapping/controls
- Sounds implementation
- Implement animation
- Find character and enemy sprites
- Gravity/Collisions

## Exception Handling
Many members had course deadlines this week so the team had to balance between keeping up with the progress of game development and finishing individual coursework. Sprint planning meeting was delayed until after a deadline that several members had for their coursework.

## product contents

### Customer interview
- I want to be able to control the character’s movements
- I think Pebble helping more when sanity level drops is an interesting idea
- I prefer the art style that is high-resolution
- It will be good to explore a range of different backgrounds as the game progresses  

The customer suggested having a way to interact with the game by controlling the character so that the main character needs to be able to move according to user’s input. After the team presented a general idea of the background story and some possible features for the game, the customer expressed an interest in the sanity level feature. After looking at several proposed art styles for the game, the customer had indicated that the one with higher resolution could show better layers of the ground and material types. Related to that, the customer also wanted to play in different backgrounds so a wider variety of scenes need to be constructed with relatively high resolution.

### User stories

| ID    | Version | Priority | Story                                                        |
| ----- | ------- | -------- | ------------------------------------------------------------ |
| US_01 | 1       | 1        | **AS A**   Player  **I WANT**   to be able to control the character **SO THAT** the process can be more interactive |
| US_02 | 1       | 4        | **AS A**   Player  **I WANT**   to have Pebble (the bot) help me more when sanity level increases **SO THAT** the game will not be too difficult |
| US_03 | 1       | 2        | **AS A**   Player  **I WANT**   to see a high-resolution game style **SO THAT** the background, items and characters seem clearer |
| US_04 | 1       | 3        | **AS A**   Player  **I WANT**   to be able to explore a range of different backgrounds **SO THAT** the game is more playable |



### User tests

| User story ID | Test                                                         | Comments                                                     | completed |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | --------- |
| US_01         | A block that represents the character can be controlled by user input by pressing a key       | When the player presses arrow keys, the block will move accordingly  | YES        |
| US_02         | Pebble gives more instructions and provides more material when main character’s sanity level drops | Pebble will need to respond to the sanity state of the player and different amount of help are given based on sanity level | NO        |
| US_03         | Add sprites into the game |  The sprites need to be suitable in terms of the theme of the game and overall art style | NO        |
| US_04         | Add sprites, generate different types of ground and environment texture | The player should be able to go to different places with various environment such as river, woods, stone road | NO        |

### Use cases

#### UC_01

**Use case**: Player controls the movement of the character  
**Author**: TJ  
**Date**: 11/14/2020  
**Modification date**: 11/14/2020  
**Purpose**: the player can control the character to move up, down, left and right  
**Overview**: The player will press arrow keys and the block (the character) will move accordingly.  
**Cross reference**: US_01  
**Actors**: player  

**Precondition**:
- The system must be able to show the player’s current position
- The player needs to have a way of giving input (e.g. key press)
- The input needs to be interpreted by the system
- The system needs to respond by showing the updated position

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. The player will press a key       | 2. The system will interpret the input                  |
| 4. The player will keep giving input based on visual feedback and goals | 3. The system will update and show the player’s current position                         |

**Alternative flow of events:**


**Exceptional flow of events:**
- The system not able to interpret player’s input
- The system does not update or show the player’s position in time



#### UC_02

**Use case**: Pebble helps more when the character’s sanity level drops  
**Author**: TJ  
**Date**: 11/14/2020  
**Modification date**: 11/14/2020  
**Purpose**: have Pebble react to the sanity state of the character  
**Overview**: After sanity level drops, Pebble helps more by talking more and giving more materials needed.  
**Cross reference**: US_02 
**Actors**: player  

**Precondition**:
- The system should have a way for Pebble to detect the character’s sanity level
- Pebble needs to respond by helping more

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. The character’s sanity level drops       | 2. The system will detect the change                  |
| 4. The player will make use of the items | 3. Pebble will give more items to the character and give more instructions                       |

**Alternative flow of events:**


**Exceptional flow of events:**
- The system not able to detect a change to sanity level
- The system has detected the sanity change but no responses from Pebble


#### UC_03

**Use case**: have high-resolution items, characters and environment  
**Author**: TJ  
**Date**: 11/15/2020  
**Modification date**: 11/15/2020  
**Purpose**: make the game more visually appealing and make the elements clearer  
**Overview**: The player will open the game and see the scenes, characters and items as high-resolution.  
**Cross reference**: US_03  
**Actors**: player  

**Precondition**:
- Sprites need to be found for different ground and material types  

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Open the game       | 2. Different elements are shown on the map                  |

**Alternative flow of events:**
- Some elements load slower than the others so some items are missing after the player starts the game. The system will have a loading icon and the character cannot move until all the elements are fully loaded

**Exceptional flow of events:**
- Some elements cannot be seen on the map
- The elements appear blurry

#### UC_04

**Use case**: Play in different environments  
**Author**: TJ  
**Date**: 11/15/2020    
**Modification date**: 11/15/2020  
**Purpose**: Provide the player with various scenes to play in  
**Overview**: The player controls character to walk around the map and different sections of the map shows different environments  
**Cross reference**: US_04  
**Actors**: player  

**Precondition**:
- Sprites need to be found for elements in the environment such as water and land

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Control the character to walk around      | 2. The system will show the environment continuously                 |
| 3. Character interacts with the environment                 |                                              |

**Alternative flow of events:**

**Exceptional flow of events:**
- The player not able to enter certain parts of the map
- The environment is shown in a blurry or confusing manner



### Tests

No tests this week



### Software design Documentation
Class: Position (see UC_01)         
| Responsibilities                                  |                   Collaborators                            |
| ---------------------------------------------- | ------------------------------------------------------------ |
| Get an element (character/item/environment)’s position | Game Element                 |  
  Set an element’s position      |                |  
  
Class: Game Element (see UC_01)
| Responsibilities                                  |                   Collaborators                            |
| ---------------------------------------------- | ------------------------------------------------------------ |
| Get an element’s position   | Recipe
| Provide interactions such as being attacked, destroyed or created    |Item
| | Character
| |Environment              |  

Class: Character (see UC_01)
| Responsibilities                                  |                   Collaborators                            |
| ---------------------------------------------- | ------------------------------------------------------------ |
| Make the character walk, attack, sleep and drop | Game Element
Acquire items   | Player
|     |Boss

Class: Recipe (see UC_03)
| Responsibilities                                  |                   Collaborators                            |
| ---------------------------------------------- | ------------------------------------------------------------ |
| Show different elements of the environment which can be crafted | Game Element|
|| Item |

Class: Environment (see UC_04)
| Responsibilities                                  |                   Collaborators                            |
| ---------------------------------------------- | ------------------------------------------------------------ |
| Present different environments such as water, stone, coal and tree | Game Element|





### User interface design
- At the start of the game, a main menu is needed in order to perform some functions such as start a new game, load game, change settings and exit the game. 
- The player should be able to control the main character to move around and explore areas by pressing keys. 
- There should be background music played at the menu screen and during the game. Background music can change along with the character’s state such as sanity levels and become more intense during events like a boss fight. Sounds should be triggered when certain actions are performed (e.g. menu click, fight, mining) 
- Gravity needs to be implemented when the character is moving up and down to have more realistic physical movements
