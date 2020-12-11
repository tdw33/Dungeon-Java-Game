\pagebreak

# **Week 4: 6th - 12th November**

## **Process**

### Weekly Overview
More progress was made on making the character’s movements seem more real by adding gravity and collision. The sounds are starting to be implemented as well for the menu screen. Character and enemy sprites as well as walking animation that fit with the style of the game were found. Moreover, game name and general storyline were established so that further game development can have a template or structure to refer to when it comes to making scenes, environments and characters. 

What we learned: On top of the daily stand-ups we began to show visual progress within Microsoft Teams or direct them to pull an update from a branch to check if its functional and show progress. This on top of daily-stand-ups, helped give everyone a better idea what was going on throughout the week. The sprint was conducted in much the same format before, with us setting up the week following the customer meeting. Here we informally talked about the features that need implementing to progress the game, and after the meeting had finished they were written up into user stories and use cases.

The presentation created for the customer meeting on the 13th November can be found here, which will have GIFs for some of the artefacts shown here: [Presentation](https://github.bath.ac.uk/Team-Cyan/Dungeon/blob/master/docs/1-presentations/week4-presentation/presentation.md)

\pagebreak


### Meeting Minutes
**Customer meeting debrief and sprint planning:**

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \

**minutes:** 

As with previous weeks, the team had a meeting to organize customer requirement mentioned in the customer meeting and plan the sprint accordingly. After seeing the progress of the game development which was having basic elements such as generating a map, character movement, user input and a main menu, the customer was satisfied with the initial state of the game. Nevertheless, the customer mentioned having a more detailed storyline. In the last sprints, we only had a general idea that the main character is in a world that requires crafting items and fighting monsters to survive along with a Bot called Pebble which is a small stone. As time passes by, the character’s sanity changes which influences the process of the game. The customer was interested in this idea and wanted to see the game divided into episodes with a more detailed storyline and the character can gain various abilities or items as the storyline progresses. Therefore, the team needs to work on adding more content to the story such as character motivation and expand the background story. The following game development can be based on this storyline to create certain features. In addition to customer’s suggestion, the team decided to have tasks that addressed the combination of previously developed features such as gravity, map and user input. Moreover, the sprint included finding character sprites and related animation. \

**Sprint re-planning and progress check** 

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo  \

**minutes:**

- Documentation: can combine the different markdown files into one pdf file in the end
- Sprites for character had been found that conform to user’s preferred high resolution, considered actions that the main character needs such as attacking, walking and mining
Rock enemy sprite was found. The sprites can be changed in size as the game needs, such as reducing or increasing the rock enemy sprite size  

![](./week_4_artifacts/main%20character%20sprite.png)  
![](./week_4_artifacts/enemy%20sprite.png)     

- Found background music for different environments and scenes (e.g. boss fight)
- Implement sounds in reaction to input/an event, have background music playing when at the main menu and when playing the game
- Add more details to  the storyline, and find a name for the game
- Found some potential main menu background design images
- A testing map can be created with different types of objects (e.g. trees, rocks...)
- Think about crafting in the game, can find more sprites
- Create settings menu
- Implement walking animation
- Implement destroying a block

\

**Sprint review and presentation creation**

Below are all the new implementations we had this week. It is recommended that you follow the presentation link in the weekly overview to see the GIF version.

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \

**Minutes:**

Collision and gravity had been implemented with the character (a block) and user input shown below. 

![](./week_4_artifacts/GravityAndCollision.gif)



A new main character sprite has been chosen instead of the previous one because there are more potential actions and the sprite can be modified more flexibly.

\bcenter

![](./week_4_artifacts/characterSpriteUpdate.png){ width=50% }   

\ecenter

The main character’s walking animation had been created with a tool (pickaxe) in hand.

\bcenter

![](./week_4_artifacts/walking.gif)

\ecenter

The map had been linked with the game, providing interaction from selecting an option (new game) and generating a map. A boss map was created.

\bcenter

![](./week_4_artifacts/map.gif){ width=50% }

\ecenter 

The team also decided on a game name: Into the Dark, which fits with the sanity feature of the game. Several menu background images were found that correspond to the theme of the game. 

\bcenter

![](./week_4_artifacts/01.png){ width=50% }



![](./week_4_artifacts/05.png){ width=50% }

![](./week_4_artifacts/06.png){ width=50% }

![](./week_4_artifacts/07.png){ width=50% }

\ecenter

As the customer required, a more detailed storyline was generated with episodes that gradually unwrap plots that give the main character certain items or abilities with Pebble as the guide to tell the story and give instructions. 

![](./week_4_artifacts/story.png)

Sound effects and game background music had been further selected for implementation.

\pagebreak

### Backlog  

**Product backlog:** 

- Generation of block map (side on view)
- The blocks of the map can be interacted with by the player
- A player is spawned on the map
- The player can interact with the blocks (destroy and create)
- The player can collect these resources in an inventory 
- The players resources can be used to craft items (pickaxe, sword, and light)
- The crafted tools will break over time
- The player's will have a sidekick (bot) which will either help or race against the player
- There will be a timer shown to the player on the screen which runs down as they go through the game
- There will be tasks to complete in order for the player to escape
- The player can go through a door and the screen will change to top down view 
- In the top down view, the player will fight bosses

**Sprint backlog:**

- Collision
- Implementing sounds
- Implement animation
- Find character and enemy sprites 
- Documentation
- Game name
- A more detailed storyline

**Completed:**

- Find cross platform library
- Research on how GitHub version control works 
- Java research 
- Game development research 
- Create a simple character (square)
- give this character up, down, left, and right movement 
- Find a common naming system
- Design classes and create a UML diagram
- General game structure (features & menu files)
- Pebble backstory
- Map generation
- Main menu screen
- Gravity
- Camera view
- User input

\pagebreak


### Exception Handling
Some members have other coursework to finish so not much progress was made after the customer meeting. In the second meeting, the team further planned the sprint and started to get more work done after that.

\pagebreak

## **Product contents**

### Customer interview
The customer mentioned that more details of the game background story should be added. Episodes can be developed that advance the game progress with more main character capabilities introduced so that there are layers to the storyline. The rest of the comments were positive about the features that have been implemented. 

\pagebreak

### User stories

| ID    | Version      | Priority     | Story                                                        |
| ----- | ------------ | ------------ | ------------------------------------------------------------ |
| US_01 | 2            | 1            | **AS A**   player  **I WANT**   to be able to  play a dungeon game on different platforms web platforms **SO THAT**   I have choices  for playing the game |
| US_02 | 2            | 4            | **AS A**   player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game by offering advice |
| US_04 | 1            | 5            | **AS A**   player  **I WANT**   to be able to  see my progress  **SO THAT**  I know  if I am doing well at the game as I play |
| US_05 | 2            | 7            | **AS A**   player  **I WANT**   to have different  choices between games modes and different paths to the end in each game mode **SO THAT**   I have new scenarios  to play |
| US_06 | 1            | 2            | **AS A** player **I WANT** to control the character’s movement and interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07 | 1            | 3            | **AS A** player **I WANT** to use resources to craft items **SO THAT** I can use them throughout the game to make tasks easier |
| US_08 | 1            | 6            | **AS A** player **I WANT** to be able to regenerate health **SO THAT** I can survive longer |
| US_09 | 1       | 8        | **AS A**   player  **I WANT**   to see a high-resolution game style **SO THAT** the background, items and characters seem clearer |
| US_10 | 1       | 9        | **AS A**   player  **I WANT**   to be able to explore a range of different backgrounds **SO THAT** the game is more playable |
| **US_11** | 1       | 10        | **AS A**   player  **I WANT**   to see a more detailed storyline with episodes and gain skills along the way **SO THAT** I can be more motivated to play and see how an episode will end and how the character develops |

\pagebreak

### User story testing

| User story ID | Test                                                         | Comments                                                     | completed |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | --------- |
| US_01         | Run code on different systems and see if code compiles       | Web based systems on Windows, Mac and Linux                  | YES       |
| US_02         | A bot character is generated on the game screen  The bot aids the user with text aids | The bot will have to be able to follow the player around the map, meaning it will need similar movement animations to the main character | NO        |
| US_04         | There is a visual queue on the screen that will track specific progression. | There are multiple types of progress – elevation, time ore collection | NO        |
| US_05         | Within the menu screen the player sets the game mode and the characteristics of the game change | These characteristics could be unlimited health, unlimited resources and no enemies | NO        |
| US_06         | The player can destroy a block and it disappears from the game screen. This block will then show up within the inventory | From the inventory screen there are multiple options the player can take which require use cases and user stories | NO        |
| US_07         | There is an option to craft items from the inventory screen. If the player has the required resources, they can craft the item and the resources are taken from their inventory | You can implement many ways to show what can be crafted with the resources provided. | NO        |
| US_08         | Have the player take damage, from then the health will decrease and then it regenerates once they stop taking damage |                                                              | NO        |
| US_09         | Add sprites into the game                                    | The sprites need to be suitable in terms of the theme of the game and overall art style | NO        |
| US_10         | Add sprites, generate different types of ground and environment texture | The player should be able to go to different places with various environment such as river, woods, stone road | NO        |
| **US_11**     | Have a storyline and give character various abilities as the plots continue | The player should be able to find torches, mine, craft weapons as the story progresses | NO        |

\pagebreak

### Use cases

#### **Existing Use cases:**
| Use case ID | Use case description                     | Tested |
| ----------- | ---------------------------------------- | ------ |
| UC_01       | Player starts game on different systems  | YES     |
| UC_02       | Player destroys a block on the map       | NO     |
| UC_03       | Player places a block on the map         | NO     |
| UC_04       | Player crafts an item from the inventory | NO     |
| UC_05       | Player controls the movement of the character  | YES     |
| UC_06       | As the players sanity goes up his sidekick will offer advice | NO     |
| UC_07       | have high-resolution items, characters and environment | NO     |
| UC_08       | Play in different environments | NO     |

#### **New Use cases:** \

**UC_09**

**Use case**: The character’s down movements  
**Author**: TJ  
**Date**: 06/11/2020    
**Modification date**: 06/11/2020  
**Purpose**: The player needs to be able to control the character to drop from a certain height in order to proceed in the game  
**Overview**: The player will control the character to walk towards the edge of a platform and go down  
**Cross reference**: US_06  
**Actors**: player  

**Precondition**:
- Have a working map with different heights of platforms
- Character can move

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Control the character to walk to the edge of a platform and further      | 2. The system will let the character drop to the next firm ground/platform                 |
| 3. Continue playing                 |                                              |

**Alternative flow of events:**
- There are none

**Exceptional flow of events:**
- The character not able to go down, stays on the same height
- The character drops when getting close to the edge but the player is not ready to go down yet

\

**UC_10**

**Use case**: Collision  
**Author**: TJ  
**Date**: 06/11/2020    
**Modification date**: 06/11/2020  
**Purpose**: Define edges in the game map which the player cannot pass through, like a wall  
**Overview**: The player will control the character to walk until reaching a wall and will not be able to go further  
**Cross reference**: US_06  
**Actors**: player  

**Precondition**:
- Have a working map with edges that has certain shapes

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Control the character to walk towards a wall      | 2. The system will stop the character to walk any further                 |
| 3. Change walking direction                 |                                              |

**Alternative flow of events:**
- There are none

**Exceptional flow of events:**
- The system fails to detect character’s position and the character goes out the edge of the map or gets stuck

\

**UC_11**

**Use case**: Main character gain skills as the story progresses  
**Author**: TJ  
**Date**: 11/19/2020  
**Modification date**: 11/19/2020  
**Purpose**: make the game layered so that the player will be introduced to different functions the game has and build up the concept of the storyline and what the main character can do  
**Overview**: The player will listen to Pebble telling the storyline so that reasons for a particular ability are given and related tutorials are shown.  
**Cross reference**: US_11  
**Actors**: player  

**Precondition**:
- Storyline needs to be in place with main episodes with a beginning and an end

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Play until a certain point in the story       | 2. Pebble talks (pop-up dialog box), gives instructions of mining and crafting items                   |
| 3. Follow the tutorial       | 4. Update the character status and the environment                   |

**Alternative flow of events:**
- The player may not want to see the tutorial due to familiarity with the game (e.g. second time playing). The dialog box can have a skip button so that the player does not need to see the tutorial again.

**Exceptional flow of events:**
- The system does not provide tutorial when the player gets to a certain point. 
- The player sees the tutorial but does not gain the new capabilities or make progress.

\pagebreak

### Use cases testing
- [x] **UC_01**
- [ ] **UC_02**
- [ ] **UC_03**
- [ ] **UC_04**
- [x] **UC_05**
- [ ] **UC_06**
- [ ] **UC_07**
- [ ] **UC_08**
- [x] **UC_09**
- The player will control the character to move downwards
- The character will drop to the ground/platform on the next level
- [x] **UC_10**
- The player will walk until reaching the edge of a map or a wall
- The character stops
- [ ] **UC_11**
- The player gets to the start of a new episode
- Pebble tells new parts of the storyline, gives tutorial and the character gains additional abilities/materials

\pagebreak

### Software design Documentation

**Class: Position (see UC_01)**

Responsibilities:

- Get an element (character/item/environment)’s position
-  Set an element’s position

Collaborators:

-   Game Element

\

**Class Game element (see UC_01)**

Responsibilities:

- Get an element’s position
- Provide interactions such as being attacked, destroyed or created

Collaborators:

- Recipe
- Item
- Character
- Environment

\

**Class: Character (see UC_01)**

Responsibilities:

- Make the character walk, attack, sleep and drop
- Acquire items

Collaborators:

- Game Element
- Player
- Boss

\

**Class: Recipe (see UC_03)**

Responsibilities:

- Show different elements of the environment which can be crafted

Collaborators:

- Game element 
- Item

\

**Class: Environment (see UC_04)**

Responsibilities:

- Present different environments such as water, stone, coal and tree

Collaborators:

- Game Element

\

**Class: Gravity (see UC_09)**  

Responsibilities:

- Make the character drop when there's no ground below him

Collaborators:

- Position    
- Character   
- Environment

\

**Class: Collision (see UC_10)**

Responsibilities:

- Make the character stop when reaching an obstacle or the edge of the map

Collaborators:

- Position    
- Character    
- Environment

\pagebreak

### User interface design

**Character:**

- Once in the game there will be character that can move and interact with the whole map [1]
- The character needs to be able to drop to lower heights [1]

**Menu:**  

- There will be a starting menu screen with the game settings, load game, continue and new game [2]
- In the settings tab there will be choices for audio, visuals, and controls [1]
- The player can go to an in game menu with save game and achievements [1]

**Sounds:**

- There should be background music played at the menu screen and during the game. Background music can change along with the character’s state such as sanity levels and become more intense during events like a boss fight [1]
- Sounds should be triggered when certain actions are performed (e.g. menu click, fight, mining) [1]

**Inventory:**

- The player can access an inventory screen which has options for equipment [1]
- In the equipment tab there will be options for view, craft, and delete [1]

**Game flow:**

- When the player had successfully completed the game they will be sent to the credits and the starting screen [2]
- The map should have edges and certain sections that the user cannot pass through such as a wall [1]

**Pebble:**

- Dialog box at the bottom of the screen at the beginning of each episode (instructions and story-telling from Pebble), which can be skipped [1]

