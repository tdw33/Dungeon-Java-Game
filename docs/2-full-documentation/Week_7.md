\pagebreak

# **Week 7 documentation: 27th November-3rd December** 

## Process

### Weekly Overview
During last week, the team decided to stick to minimum requirements that could be achieved in the last few weeks of this project considering the need to work on product documentation during the final week. Basic functions that are core to the game were further developed such as enemy attack, block interaction, map and anti-gravity movement. As a result, the game appeared as a whole rather than components that can be shown to the customer. 

This week the team had a clearer goal on what needs to be achieved by the end of the term and continued working on essential features such as creating a final map with different types of blocks and enemies in addition to fixing bugs. Enemy health and death animation for all characters were added. The inventory was made to count number of blocks collected by the player. More sounds were implemented for different scenarios. Documentation was generated up to last week for the preparation of final organization into pdf file which was tested last week. From these aspects we can see that the sprint went successfully and many tasks were finished on time. The game starts to grow into a more finalized product.  

The presentation created for the customer meeting on the 4th December can be found here, which will have GIFs for some of the artefacts shown here:    [Presentation](https://github.bath.ac.uk/Team-Cyan/Dungeon/blob/week7-presentation/doc/week7-presentation/presentation.md)

\pagebreak

### Meeting Minutes
**Customer meeting debrief and sprint planning**

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \

After the customer meeting, the team held a meeting to discuss game features that need to be worked on: 
- A general map larger than the previously developed ones, which will be the final map for this game with blocks that can be mined as well as anti-gravity blocks 
- Enemies need to follow the player around within a certain distance
- Enemies need to have health bar as well 
- Death animation will need to be implemented for the characters
- Armor can be crafted within the inventory menu after the player collects a certain number of blocks and animation will need to be added with the character wearing the armour. After the health drops below a certain level, the armour will break
- Need to have more Pebble speech added  

**Sprint planning**

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \  

- Change menu screen options to make them look better
- Non-linear zoom for sanity feature
- Different types of armour can be made that add to the character’s health
- Now has a general map
- add blocks that can’t be destroyed for the edge of the map
- add some more blocks for mining
- add more enemies
- can have secret passages to be discovered
- Have death animation
- Add gold to inventory
- Pebble will appear beside the main character again if the distance between them reaches a certain amount 
- Decide style for the final pdf document
- page break for each title 
- have hyperlinks
- format for user stories
- Keep working on sprint documents
- Start to work on a template for user manual and installation guide


**Sprint review and presentation creation**

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo 

- Final map has been created
- Mining blocks has been improved
- Added enemy health bar
- Inventory can count number of blocks collected for each type
- Sound has been implemented
- Pebble’s speech bubble has improved to be larger and more clear
- Menu screen was improved
- Player can attack
- Death animation added to every character

\pagebreak

### Backlog  

**Product backlog:**

- There will be tasks to complete in order for the player to escape
- Random generation of block map (side on view)

- Interaction between characters (Pebble, enemies) 

**Sprint backlog:**

- Non-linear zoom
- Armor crafting in inventory, with it breaking over time(health dependent)
- Final map (add blocks (gold, iron), enemies, possibly secret passages)
- Death animation
- Inventory (add gold)
- Pebble will appear beside the main character again if the distance between them reaches a certain amount 
- Refine final pdf document style
- Sprint documents
- Template for user manual and installation guide
- The player will fight a boss in the final game scene to escape the dungeon 

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
- Map generation (early implementation)
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

- Enemy projectiles
- Arrow collision with player when attacked by enemies
- Inventory screen
- Add buttons on game screen (inventory & menu)
- Add blocks with properties to the map
- Character can destroy and place blocks right and down in addition to left
- Pebble speech
- Anti-gravity
- Video for credits

\pagebreak

### Exception Handling
There were no exceptions to be handled for this week.

\pagebreak

## Product content

### Customer meeting
The customer seemed to be satisfied with the progress shown. No requirements were mentioned during the meeting. The main point raised was having all the features we showed joined onto one to form the game. We agreed with this, which is why the major end result of the sprint week was to have the features running in one version of the game. This would then be shown to the customer in the next meeting with a little playthrough

\pagebreak

### User stories

| ID    | Version | Priority | Story                                                        |
| ----- | ------- | -------- | ------------------------------------------------------------ |
| US_01 | 2     | 1        | **AS A**   player  **I WANT**   to be able to  play a dungeon game on different platforms web platforms **SO THAT**   I have choices  for playing the game |
| US_02 | 2     | 5        | **AS A**   player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game by offering advice |
| US_04 | 2     | 6        | **AS A**   player  **I WANT**   to be able to  see a timer go down  **SO THAT**  I know  if I am doing well at the game as I play |
| US_05 | 2     | 14       | **AS A**   player  **I WANT**   to have different  choices between games modes and different paths to the end in each game mode **SO THAT**   I have new scenarios  to play |
| US_06 | 1     | 2        | **AS A** player **I WANT** to control the character’s movement and interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07 | 2     | 3        | **AS A** player **I WANT** to use resources to upgrade armour and weapons **SO THAT** I can use them throughout the game to make fighting enemies easier |
| US_08 | 1     | 11        | **AS A** player **I WANT** to be able to regenerate health **SO THAT** I can survive longer |
| US_09 | 1     | 9        | **AS A**   player  **I WANT**   to see a high-resolution game style **SO THAT** the background, items and characters seem clearer |
| US_10 | 1     | 13       | **AS A**   player  **I WANT**   to be able to explore a range of different backgrounds **SO THAT** the game is more playable |
| US_11 | 1     | 12       | **AS A**   player  **I WANT**   to see a more detailed storyline with episodes and gain skills along the way **SO THAT** I can be more motivated to play and see how an episode will end and how the character develops |
| US_12 | 1     | 10        | **AS A** player **I WANT** to be able to gain height in the map quickly **SO THAT** I can save time in reaching parts of the map |
| US_13 | 1     | 7        | **AS A** player **I WANT** to battle enemies **SO THAT** the game has a challenge to it |
| US_14 | 1     | 4        | **AS A** player **I WANT** to see how many resources have been collected **SO THAT** I know the current number of each materials already collected and how many more I need in order to upgrade armour or craft items |
| **US_15** | 1     | 8        | **AS A** player **I WANT** to see how much health the enemies I’m fighting against have left **SO THAT** I have an idea of how much time it takes to defeat them |

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
| US_08         | Have the player take damage, from then the player can craft armour which will reset the health |                                                              | NO        |
| US_09         | Add sprites into the game                                    | The sprites need to be suitable in terms of the theme of the game and overall art style | YES      |
| US_10         | Add sprites, generate different types of ground and environment texture | The player should be able to go to different places with various environment such as river, woods, stone road | NO        |
| US_11         | Have a storyline and give character various abilities as the plots continue | The player should be able to find torches, mine, craft weapons as the story progresses | NO        |
| US_12         | The player starts a certain y position. Then in a time shorter than climbing blocks, the player is elevated to a higher y coordinate | There are different ways to achieve this, such as placing a block down which will change the gravity in the vertical plane | YES        |
| US_13         | The player will come into contact with the enemy, where the enemy will begin to attack the player | The enemy could use projectiles or melee to attack the player. They could also be stationary or mobile. | YES            |
| US_14         | The player will see an inventory screen with different materials shown and craft items | Each type of block will be shown using both a small picture and name such as iron, with a number behind. | YES            |
| **US_15**         | The player will see a health bar above each enemy’s head | The health bar reduces when the player attacks the enemy. | YES         |

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
| UC_15       | Check inventory           | YES     |
| UC_16       | Player’s health decreases when taking damage             | YES     |
| UC_17       | Player walks on block and reverses gravity           | YES     |


#### **New and updated use cases:**  

**UC_18**

**Use case**: Player crafts armour from the inventory  \
**Author**: TJ  \
**Date**: 27/11/2020  \
**Modification date**: 27/11/2020  \
**Purpose**: Allow player to regenerate health and make fighting enemies easier  \
**Overview**: The player will collect blocks until a certain number and open the inventory menu to craft armour  \
**Cross reference**: US_07  \
**Actors**: player  \

**Precondition**:
- There are enough blocks to be crafted

**Normal flow of event**:

| Actor actions                                                | System actions                                 |
| ------------------------------------------------------------ | ---------------------------------------------- |
| 1. Gather different types of blocks                          | 2. Keep a record of number of blocks collected |
| 4. Open the inventory menu and see how many blocks have been collected for each type | 3. Update the inventory screen                 |
| 6. Craft armour                                              | 5. Show the inventory screen                   |
| 7. Close inventory screen                                    | 8. Armor animation is shown on the character   |

**Alternative flow of events:**
- Player wants to craft armour without enough resources. Error message shows: “Insufficient resources”
- The health added by the armour is used up. The armour animation disappears, which indicates that it has broke.

**Exceptional flow of events:**
- Player has gathered many resources but the system fails to update the number on inventory screen

\

**UC_19**

**Use case**: Enemy has a health bar that will go down when attacked  \
**Author**: TJ \
**Date**: 27/11/2020 \
**Modification date**: 27/11/2020 \
**Purpose**: Allow player to see how much health has left for enemies \
**Overview**: The player will attack an enemy and the health bar reduces \
**Cross reference**: US_15 \
**Actors**: player \

**Precondition**:
- The enemy is being attacked

**Normal flow of event**:

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. Attack an enemy      | 2. Show health bar for the enemy      |
| 3. Keep attacking   | 4. Health bar reduces     |

**Alternative flow of events:**
- Player attacks the enemy and runs away. Health bar disappears after a certain range of distance

**Exceptional flow of events:**
- Health bar is not shown and the player does not know whether the enemy can be defeated

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
- [x] **UC_15**
- [x] **UC_16**
- [x] **UC_17**
- [x] **UC_18**

- Player gathers blocks
- Player opens inventory
- Inventory shows how many blocks collected for each type
- Player crafts armour

- [x] **UC_19**

- Player attacks enemy
- Enemy’s health bar reduces in length


### Software design Documentation
Class: Armor (see UC_18)
- Responsibilities
  - shows the number of each type of materials collected
  - crafts items                                  
- Collaborators
  - Character
  - Inventory

\pagebreak

### User interface design

**Character:**

- Once in the game there will be character that can move and interact with the whole map [1]
- The character needs to be able to drop to lower heights [1]

**Menu:**  

- There will be a starting menu screen with the game settings, load game, continue and new game [2]
- In the settings tab there will be choices for audio, visuals, and controls [1]
- The player can go to an in game menu with save game and achievements [1]  
- When player is in the game, two buttons are shown on the top of the screen (inventory and menu) [1]

**Sounds:**

- There should be background music played at the menu screen and during the game. Background music can change along with the character’s state such as sanity levels and become more intense during events like a boss fight [1]
- Sounds should be triggered when certain actions are performed (e.g. menu click, fight, mining) [1]

**Inventory:**

- The player can access an inventory screen which has options for equipment [1]
- In the equipment tab there will be options for view, craft, and delete [1]
- Different types of materials gathered from a variety of blocks are shown, each with a number that indicates how many have been collected [1]
- **Player can craft armour from gathered blocks [1]**

**Game flow:**

- When the player had successfully completed the game they will be sent to the credits and the starting screen [2]
- A video will be shown that includes credits at the end of the game [1]

**Map:**

- **The map should have blocks that can’t be destroyed along the edge** [2]

- The map should have different types of blocks [1]

**Pebble:** 

- A speech bubble will appear above Pebble that gives players instructions [1]
- **Pebble will appear near the main character again if the distance between them gets to a certain amount [1]**
