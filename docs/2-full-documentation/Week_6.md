\pagebreak

## **Week 6 documentation: 20th-26th November** 

## **Process**

### Weekly Overview
In Week 5, the team reconsidered what could be achieved in a limited amount of time left for this project and adjusted user stories and use cases to make sure that the most basic customer requirements get fulfilled first before spending time on other features. Therefore, this week the team focused on improving the existing features of the game such as enemy attack, destroy and place blocks, anti-gravity and map. Moreover, sprint tasks that connect different components of the game were accomplished such as Pebble speech and inventory screen, which allow players to see tutorial, storyline and collect materials for crafting after destroying blocks. Use cases were generated based on the previous user stories and use cases to have a more specific implementation. 

Judging from last week, shorter sprints were not suited to the current situation since some tasks took longer to finish than planned. Thus, the team went back to having one long sprint with three meetings for this week. As a result, this week’s sprint tasks could be achieved on time and there was no rush to finish them in a short period. 



The presentation created for the customer meeting on the 13th November can be found here, which will have GIFs for some of the artefacts shown here:   [Presentation](https://github.bath.ac.uk/Team-Cyan/Dungeon/tree/master/docs/1-presentations/week6-presentation)

\pagebreak


### Meeting Minutes
**Customer meeting debrief and sprint planning**

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \

**Minutes:**

In the debrief, the team decided to have more features from the storyline implemented such as Pebble speech based on what the customer suggested. The grappling hook idea was interesting but the team did not think there is enough time left to do that and it can be hard to be implemented so the idea was recorded but not put into the product backlog. It would be attempted if other features have been developed to a satisfying level. 

After discussing the customer requirements, the team continued talking about how to improve some existing features of the game. The current background of the game is blue, which may go against the narrative of the character being in a cave. Therefore, a darker background is needed. Moreover, since there is attack animation which shows an arrow being shot at the main character, the character should have a health bar that decreases with each attack received from the enemies. Now the arrow goes through the character so the animation needs to be shown in a way that the arrow hits the character and disappears.

\

**Sprint planning**

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo  \

**Minutes:**

- Markdown can be converted to a pdf file, just need to format style sheet
- Has an example horizontal map, needs to get the block into correct sizes
- Block health was added
- Change background colour
- Enemy attack should have a refined animation: arrow projectiles that aim for the main character, and shows the character’s health decreases
- Anti-gravity: can have sections of the map which allow the character to get to a higher position quickly
- Pebble dialog box that gives players instructions
- Inventory screen is needed so that the players can see how many resources have been gathered
- In-game buttons are needed to give access to the main menu and inventory

\

**Sprint review and presentation creation**

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo 

**Minutes:**

Documentation can be converted from Markdown to PDF so a PDF file will be created after all the sprint documentations are uploaded and revised to a satisfying level without worrying about formatting the documentation according to the requirement in the end.

\

Difficulty level is added to the main menu screen so that the players can choose from three levels of difficulties. Moreover, an in-game menu was added which displays the inventory screen: it has three types of materials along with how many the player currently has. 

\bcenter

![](./week_6_artifacts/diffScreen.png){ width=50% }

![](./week_6_artifacts/Inventory.png){ width=50% }

\ecenter

Pebble speech is shown by a speech bubble above its head.

![](./week_6_artifacts/speech.gif)

\pagebreak

Anti-gravity upward movement has been implemented for certain sections of the map.

![](./week_6_artifacts/gravity.gif)

\pagebreak

A bigger map was generated with an underground theme (black background which shows a dark environment). HP and properties of blocks inside the map have been implemented. 

Enemy attack projectiles make the arrow fly towards the character and character's health decreases are shown by a health bar  

![](./week_6_artifacts/health.gif)

\pagebreak

### Backlog  

**Product backlog:**

- The crafted tools will break over time

- There will be tasks to complete in order for the player to escape
- The player will fight a boss in the final game scene to escape the dungeon 
- Random generation of block map (side on view)

- Have a map that includes blocks made out of different materials such as iron and gold

**Sprint backlog:**

- Enemy projectiles
- Arrow collision with player when attacked by enemies
- Inventory screen
- Add buttons on game screen (inventory & menu)
- Add blocks with properties to the map
- Character can destroy and place blocks right and down in addition to left
- Pebble speech
- There is an antigravity block allowing the player to rise until he is out of the vertical axis or collides with block
- Video for the end of the game (credits)
- Documentation

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
- A player is spawned on the map
- Collision

- Find character and enemy sprites

- Game name

- A more detailed storyline

- Implement sounds
- Animations added to main character, Pebble and enemies
- The player can interact with the blocks of the map (destroy and create)
- Example map that the game will load (horizontal view)
- Documentation formatting and sprint documentation
- Code refactoring which restructured codes into classes
- There will be a timer shown to the player on the screen which runs down as they go through the game

\pagebreak


### Exception Handling
There were no exceptions to be handled for this week.

\pagebreak

## **Product content**

### Customer meeting
The customer indicated a liking for the sanity implementation which zooms in the screen as the countdown timer decreases. According to the customer, this feature creates a claustrophobic feeling which has a stronger psychological effect. However, the customer mentioned that the relationship between where the player is, what the player can do and the storyline seems disconnected. An additional feature that the customer proposed was having a grappling iron that can be thrown to the next platform to aid in movement.

### User stories

| ID    | Version | Priority | Story                                                        |
| ----- | ------- | -------- | ------------------------------------------------------------ |
| US_01 | 2       | 1        | **AS A**   player  **I WANT**   to be able to  play a dungeon game on different platforms web platforms **SO THAT**   I have choices  for playing the game |
| US_02 | 2       | 5        | **AS A**   player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game by offering advice |
| US_04 | 2       | 6        | **AS A**   player  **I WANT**   to be able to  see a timer go down  **SO THAT**  I know  if I am doing well at the game as I play |
| US_05 | 2       | 13       | **AS A**   player  **I WANT**   to have different  choices between games modes and different paths to the end in each game mode **SO THAT**   I have new scenarios  to play |
| US_06 | 1       | 2        | **AS A** player **I WANT** to control the character’s movement and interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07 | 2       | 3        | **AS A** player **I WANT** to use resources to upgrade armour and weapons **SO THAT** I can use them throughout the game to make fighting enemies easier |
| US_08 | 1       | 10        | **AS A** player **I WANT** to be able to regenerate health **SO THAT** I can survive longer |
| US_09 | 1       | 8        | **AS A**   player  **I WANT**   to see a high-resolution game style **SO THAT** the background, items and characters seem clearer |
| US_10 | 1       | 12       | **AS A**   player  **I WANT**   to be able to explore a range of different backgrounds **SO THAT** the game is more playable |
| US_11 | 1       | 11       | **AS A**   player  **I WANT**   to see a more detailed storyline with episodes and gain skills along the way **SO THAT** I can be more motivated to play and see how an episode will end and how the character develops |
| US_12 | 1       | 8        | **AS A** player **I WANT** to be able to gain height in the map quickly **SO THAT** I can save time in reaching parts of the map |
| US_13 | 1       | 7        | **AS A** player **I WANT** to battle enemies **SO THAT** the game has a challenge to it |
| US_14 | 1       | 4        | **AS A** player **I WANT** to see how many resources have been collected **SO THAT** I know the current number of each materials already collected and how many more I need in order to upgrade armour or craft items |

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
| US_11         | Have a storyline and give character various abilities as the plots continue | The player should be able to find torches, mine, craft weapons as the story progresses | NO        |
| US_12         | The player starts a certain y position. Then in a time shorter than climbing blocks, the player is elevated to a higher y coordinate | There are different ways to achieve this, such as placing a block down which will change the gravity in the vertical plane | YES        |
| US_13         | The player will come into contact with the enemy, where the enemy will begin to attack the player | The enemy could use projectiles or melee to attack the player. They could also be stationary or mobile. | NO            |
| US_14         | The player will see an inventory screen with different materials shown and craft items | Each type of block will be shown using both a small picture and name such as iron, with a number behind. | NO            |

\pagebreak

### Use cases

#### Existing Use cases:**

| Use case ID | Use case description                                         | Tested |
| ----------- | ------------------------------------------------------------ | ------ |
| UC_01       | Player starts game on different systems                      | YES    |
| UC_02       | Player destroys a block on the map                           | YES     |
| UC_03       | Player places a block on the map                             | YES     |
| UC_04       | Player crafts an item from the inventory                     | NO     |
| UC_05       | Player controls the movement of the character                | YES    |
| UC_06       | As the players sanity goes up his sidekick will offer advice | NO     |
| UC_07       | have high-resolution items, characters and environment       | YES    |
| UC_08       | Play in different environments                               | NO     |
| UC_09       | The characters’ down movements                                | YES     |
| UC_10       | Collision system                                              | YES     |
| UC_11       | Main character gain skills as the story progresses           | NO     |
| UC_12       | The enemy will fire a projectile at the main character           | YES     |
| UC_13       | The boss attacks the player           | NO     |
| UC_14       | Player walks on block and reverses gravity           | YES     |

#### **New Use cases:**  

\

#### **UC_15**

**Use case**: Check inventory  \
**Author**: TJ  \
**Date**: 20/11/2020  \
**Modification date**: 20/11/2020  \
**Purpose**: show the number of each material collected  \
**Overview**: The player will gather resources and then check how many they have by accessing the inventory screen  \
**Cross reference**: US_06, US_14 \ 

**Actors**: player  \

**Precondition**:

- Have different types of blocks that are placed on the map which can be collected

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Collect different materials from blocks      | 2. Update the number of each material in inventory                 |
| 3. Open inventory menu                 | 4. Shows the updated inventory               |

**Alternative flow of events:**
- There are none

**Exceptional flow of events:**
- The number does not update according to the users’ collection

\

**UC_16 (related to UC_12)**

**Use case**: Player’s health decreases when taking damage  \
**Author**: TJ  \
**Date**: 20/11/2020   \
**Modification date**: 20/11/2020 \
**Purpose**: Give player a sense of the character’s health status during a fight \
**Overview**: The character will take damage from an enemy and the health bar reduces in length \
**Cross reference**: US_08 \
**Actors**: player \ 

**Precondition**:
- A health bar is shown to the player

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Character shot by the enemies’ arrows      | 2. Decrease the character’s health                  |
|                  | 3. Show the changes through health bar   |

**Alternative flow of events:**
- There are none

**Exceptional flow of events:**
- The attack fails to reduce the character’s health
- The changes in health bar react slowly so the character has taken more damage than shown and will be dead which appears sudden to the player

\

**UC_17**

**Use case**: Difficulty selection  \
**Author**: TJ  \
**Date**: 20/11/2020    \
**Modification date**: 20/11/2020  \
**Purpose**: Let players choose what level of gaming difficulty they want  \
**Overview**: The player will choose difficulty level and the countdown timer will change accordingly  \
**Cross reference**: US_05  \
**Actors**: player  \

**Precondition**:
- Countdown timer is implemented
- Menu screen has options for different levels of difficulties

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Select a desired difficulty level      | 2. Interprets the option and picks a corresponding total time in the countdown timer                 |
|                      | 3. Show the countdown timer           |

**Alternative flow of events:**
- The player chooses “hard” and finds it too challenging. He/She can click on the menu button in the game, go back to the main menu and change the difficulty level

**Exceptional flow of events:**
- The timer does not correspond with the difficulty level; for example, more time for a harder level

\pagebreak


### Use cases testing
- [x] **UC_01**
- [x] **UC_02**
- [x] **UC_03**
- [ ] **UC_04**
- [x] **UC_05**
- [ ] **UC_06**
- [x] **UC_07**
- [ ] **UC_08**
- [x] **UC_09**
- [x] **UC_10**
- [ ] **UC_11**
- [x] **UC_12**
- [ ] **UC_13**
- [x] **UC_14**
- [ ] **UC_15**
- The player collects materials for crafting
- The system updates the number of materials in the inventory screen
- The player checks how many resources have been gathered and make decisions during game play such as how many more materials to collect
- [x] **UC_16**
- The enemy attacks the player
- The health bar reduces in length
- [x] **UC_17**
- The player chooses a difficulty level
- Time limitation indicated by a countdown timer is shown to the player differently in all three levels.

\pagebreak


### Software design Documentation
Class: Inventory (see UC_04, UC_15)
- Responsibilities
  - shows the number of each type of materials collected
  - crafts items                                  
- Collaborators
  - Environment
  - Element
  - Character

\pagebreak

### User interface design

**Character:**

- Once in the game there will be character that can move and interact with the whole map [1]
- The character needs to be able to drop to lower heights [1]

**Menu:**  

- There will be a starting menu screen with the game settings, load game, continue and new game [2]
- In the settings tab there will be choices for audio, visuals, and controls [1]
- The player can go to an in game menu with save game and achievements [1]  
- **When player is in the game, two buttons are shown on the top of the screen (inventory and menu) [1]**

**Sounds:**

- There should be background music played at the menu screen and during the game. Background music can change along with the character’s state such as sanity levels and become more intense during events like a boss fight [1]
- Sounds should be triggered when certain actions are performed (e.g. menu click, fight, mining) [1]

**Inventory:**

- The player can access an inventory screen which has options for equipment [1]
- On this screen the player can see amount of each block, craft option for armour and which block is being placed[2]
- **Different types of materials gathered from a variety of blocks are shown, each with a number that indicates how many have been collected [1]**

**Game flow:**

- When the player had successfully completed the game they will be sent to the credits and the starting screen [2]
- **A video will be shown that includes credits at the end of the game [1]**

**Map:**

- **The map should have edges and certain sections that the user cannot pass through such as a wall [1]**
- **The map should have different types of blocks [1]**

**Pebble:** 

- **A speech bubble will appear above Pebble that gives players instructions [1]**
- Dialog box at the bottom of the screen at the beginning of each episode (instructions and story-telling from Pebble), which can be skipped [1]