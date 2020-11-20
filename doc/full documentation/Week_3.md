# Week 3

## Process

## Weekly Overview
Having a general class structure is helpful when developing the game. However, the class diagram needs to be based on use cases. Internal user stories need to be created when developing game features so that user requirements will be fulfilled and the whole process should be documented for future reference. Moreover, it may be better to set a small rather than a hard-to-reach goal since each sprint is only one week long. It is also helpful to move the tasks which had been done on GitHub in time so that the sprint progress is up-to-date. The team may function better when taking course load into consideration while assigning tasks so that distribution of the development tasks can be more reasonable and effective. 

## Meeting Minutes

### Customer meeting debrief and sprint planning:
A sprint planning meeting was held right after the customer meeting, in which the team added tasks to sprint backlog according to the user requirements and additional features that could be added to the game. The customer expressed a preference toward a high-resolution art style for the game so a task to find sprites that would fit the style was created and assigned. The customer also wanted to see a variety of backgrounds and scenes while playing the game. Therefore, map generation was added to this week's sprint tasks. In addition to the customer's suggestions, the team also decided to work on menu screens since they are a fundamental part of a game. Another component of a game is sounds so some member were assigned to find background music and short sound effects that fit with the game theme. In terms of character movement, since a map will be generated which will influence where the character can go, gravity and collision are needed to make the movements seem more real (e.g. the character jumps down - gravity; cannot pass the edge of the map - collision). 

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

### Sprint review and presentation creation
- A map could be generated that had a black background with edges, different obstacles and materials. 

![ ](../week3-presentation/gifs/mapexample.gif)  

- User input can be shown as current position that constantly changes according to the user's control. 

![ ](../week3-presentation/imgs/gifedit.gif)    

- Camera view was implemented to always have the character in the center of the screen. 

![ ](../week3-presentation/gifs/InitialGameRecording.gif)  

- A menu was created with basic functions such as new game, load game, settings and exit.   

![ ](../week3-presentation/imgs/mainmenu.gif)  

## backlog  

**Product backlog:** 

- Create a character (square) and give it basic movement (up, down, left, right)
- Find a common naming system 
- Design classes and create a UML diagram

- Generation of block map (side on view)
- The blocks of the map can be interacted with by the player
- A player is spawned on the map
- The player can interact with the blocks (destroy and create)
- The player can collect these resources in an inventory 
- The players resources can be used to craft items (pickaxe, sword, and light)
- The crafted tools will break over time
- The player will have a sidekick (bot) which will either help or race against the player
- There will be a timer shown to the player on the screen which runs down as they go through the game
- There will be tasks to complete in order for the player to escape
- The player can go through a door and the screen will change to top down view 
- In the top down view, the player will fight bosses

**Sprint backlog:**
- Map generation
- Sprite class and art style
- Menu screens
- Keymapping/controls
- Sounds implementation
- Implement animation
- Find character and enemy sprites
- Gravity/Collisions

**Completed:**
- General game structure (features & menu files)
- Find a common naming system for programming
- Design classes and create a UML diagram
- Generate a character (a block) that can move around
- Pebble backstory

## Exception Handling
Many members had course deadlines this week so the team had to balance between keeping up with the progress of game development and finishing individual coursework. Sprint planning meeting was delayed until after a deadline that several members had for their coursework.

## product contents

### Customer interview

The customer suggested having a way to interact with the game by controlling the character so that the main character needs to be able to move according to user’s input. After the team presented a general idea of the background story and some possible features for the game, the customer expressed an interest in the sanity level feature again (same as the last customer meeting). After looking at several proposed art styles for the game, the customer had indicated that the one with higher resolution could show better layers of the ground and material types. Related to that, the customer also wanted to play in different backgrounds so a wider variety of scenes need to be constructed with relatively high resolution.

### User stories

| ID    | Version      | Priority     | Story                                                        |
| ----- | ------------ | ------------ | ------------------------------------------------------------ |
| US_01 | 2            | 1            | **AS A**   Player  **I WANT**   to be able to  play a dungeon game on different platforms web platforms **SO THAT**   I have choices  for playing the game |
| US_02 | 2            | 4            | **AS A**   Player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game by offering adivce |
| US_03 | **Deleting** | **Deleting** | **AS A**   Player  **I WANT**   to be able to compete  with a bot  **SO THAT**   I can have a goal when playing |
| US_04 | 1            | 5            | **AS A**   **Player**  **I WANT**   to be able to  see my progress  **SO THAT**  I know  if I am doing well at the game as I play |
| US_05 | 2            | 7            | **AS A**   Player  **I WANT**   to have different  choices between games modes and diffrent paths to the end in each game mode **SO THAT**   I have new scenarios  to play |
| US_06 | 1            | 2            | **AS A** Player **I WANT** to interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07 | 1            | 3            | **AS A** Player **I WANT** to use resources to craft items **SO THAT** I can use them throughout the game to make tasks easier |
| US_08 | 1            | 6            | **AS A** player **I WANT** to be able to regenerate health **SO THAT** I can survive longer |
| US_09 | 1       | 9        | **AS A**   Player  **I WANT**   to see a high-resolution game style **SO THAT** the background, items and characters seem clearer |
| US_10 | 1       | 8        | **AS A**   Player  **I WANT**   to be able to explore a range of different backgrounds **SO THAT** the game is more playable |



### User story testing

| User story ID | Test                                                         | Comments                                                     | completed |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | --------- |
| US_01         | Run code on different systems and see if code compiles       | Web based sytems on Windows, Mac and Linux                   | YES       |
| US_02         | A bot character is generated on the game screen  The bot aids the user with text aids | The bot will have to be able to follow the player around the map, meaning it will need similar movement animations to the main character | NO        |
| US_04         | There is a visual queue on the screen that will track specific progression. | There are multiple types of progress – elevation, time ore collection | NO        |
| US_05         | Within the menu screen the player sets the game mode and the characteristics of the game change | These characteristics could be unlimited health, unlimited resources and no enemies | NO        |
| US_06         | The player can destroy a block and it disappears from the game screen. This block will then show up within the inventory | From the inventory screen there are multiple options the player can take which require use cases and user stories | NO        |
| US_07         | There is an option to craft items from the inventory screen. If the player has the required resources, they can craft the item and the resources are taken from their inventory | You can implement many ways to show what can be crafted with the resources provided. | NO        |
| US_08         | Have the player take damage, from then the health will decrease and then it regenerates once they stop taking damage |                                                              | NO        |
| US_09         | Add sprites into the game |  The sprites need to be suitable in terms of the theme of the game and overall art style | NO        |
| US_10         | Add sprites, generate different types of ground and environment texture | The player should be able to go to different places with various environment such as river, woods, stone road | NO        |

### Use cases

#### **Exisitng Use cases:**
| Use case ID | Use case description                     | Tested |
| ----------- | ---------------------------------------- | ------ |
| UC_01       | Player starts game on different systems  | NO     |
| UC_02       | Player destroys a block on the map       | NO     |
| UC_03       | Player places a block on the map         | NO     |
| UC_04       | Player crafts an item from the inventory | NO     |
| UC_05       | Player controls the movement of the character  | YES     |
| UC_06       | As the players sanity goes up his sidekick will offer advice | NO     |


#### **New Use cases:**  

#### UC_07

**Use case**: have high-resolution items, characters and environment  
**Author**: TJ  
**Date**: 11/15/2020  
**Modification date**: 11/15/2020  
**Purpose**: make the game more visually appealing and make the elements clearer  
**Overview**: The player will open the game and see the scenes, characters and items as high-resolution.  
**Cross reference**: US_09  
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

#### UC_08

**Use case**: Play in different environments  
**Author**: TJ  
**Date**: 11/15/2020    
**Modification date**: 11/15/2020  
**Purpose**: Provide the player with various scenes to play in  
**Overview**: The player controls character to walk around the map and different sections of the map shows different environments  
**Cross reference**: US_10    
**Actors**: player  

**Precondition**:
- Sprites need to be found for elements in the environment such as water and land

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Control the character to walk around      | 2. The system will show the environment continuously                 |
| 3. Character interacts with the environment                 |                                              |

**Alternative flow of events:**
- There are none
**Exceptional flow of events:**
- The player not able to enter certain parts of the map
- The environment is shown in a blurry or confusing manner



## Use cases testing
- [ ] **UC_01**
- [ ] **UC_02**
- [ ] **UC_03**
- [ ] **UC_04**
- [ ] **UC_05**
- [ ] **UC_06**

- [ ] **UC_07**
- The player will open up the game
- The player will see the main character
- The player will see blocks that can be destroyed/mined and can tell what they are and differentiate between types of blocks/materials

- [ ] **UC_08**
- The player will enter different sections of the map which contain various environment such as sand, water, stone, woods



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

| Design implement                                             | Version |
| ------------------------------------------------------------ | ------- |
| There will be a starting menu screen with the game settings, load game, continue and new game | 2       |
| In the settings tab there will be choices for audio, visuals, and controls | 1       |
| There should be background music played at the menu screen and during the game. Background music can change along with the character’s state such as sanity levels and become more intense during events like a boss fight | 1       |
| Sounds should be triggered when certain actions are performed (e.g. menu click, fight, mining) | 1       |
| Once in the game there will be character that can move and interact with the whole map | 1       |
| The player can go to an in game menu with save game and acheivements | 1       |
| The player can access an inventory screen which has options for equipment | 1       |
| In the equipment tab there will be options for view, craft, and delete | 1       |
| When the player had successfully completed the game they will be sent to the credits and the starting screen | 2       |

