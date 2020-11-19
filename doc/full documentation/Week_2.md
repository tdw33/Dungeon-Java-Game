# Week 2

## Process





## Weekly overview 

With the customer happy with our initial game idea for a Minecraft inspired dungeon game, we were able to start planning out the game and wrote some basic code. This meant the product backlog continued to be filled out withideas that we had, and the initial game architecture was looked at: menu system and game function. To achieve this planned architecture we used Miro board, which was also used to sort out the class UML. This was also based on our product backlog, but we did not use CRC cards which could of made the process simpler. The week had 3 meetings: customer debrief with sprint plan; game architecture; and sprint review with presentation creation. For the coding side everyone was assigned to generate a basic square that could move left, right, up, and down.

**Artifact of the miro board for game architecture and classes**

The Scrum technique was continued for this week with the Scrum master and product lead roles being switched around, so each member of the group can experience them. In between these first and last meeting we had daily stand-ups that were carried out on Microsoft teams. From the last sprint we made sure to tag the team within the post, so everyone will get a notification and remider to post.

**Artifact daily stand up** 

This sprint was conducted in much the same way as the last one as we thought it was generating good results in the last sprint. The only problem was we still assigned everybody the coding task which is not efficient. However, there were 3 different systems (mac, windows Linux) used my different members of the team and the task would help in getting people comfortable with libGDX. Heading into the next sprint we will make sure to spread the tasks more efficiently so that a grater progression of the game can be achieved. 

We assigned the sprint tasks from looking at the product backlog and the existing user stories we had. Since US_01 was a great priorty we assigned everbody to coding the character with movement as explained before. 

## Meeting minutes

### Customer meeting debrief and sprint planning:

We discussed how the customer meeting went and how it affected the game. In the meeting the customer said they were happy with the idea of doing an interactive game like Minecraft in a dungeon themed setting. We presented a broad overview of the game so there was plenty to look into as potential final ideas, meaning the customer still has plenty of choice in how the game will look and feel. One important part was clarification of cross platform relating to windows, linux and mac instead of referring to mobile. So, our focus will be ensuring the game runs on those operating systems with android as a potential bonus. 

Now the initial game idea was confirmed, and we have established our coding language with framework (Java with Libgdx), we initiated coding with this sprint. As no one had used Libgdx before everyone was assigned to create a basic character (square) and give it basic movement (up, down, left and right). On top of this everyone was assigned finding a naming system, designing classes and UML diagram.

**Have and artifact of our sprint board**



### Miro board

In this meeting we used our thoughts on classes to generate the architecture of the game as well as a UML diagram. First, we looked at the game flow which will be how the menu and game will function together, which can be seen below. The important part of this architecture is the ability to save the game and how this will function in different scenarios, So, it shows the flow with saving the game and then continuing the game from this save state. Upon dying the user will be able to start from the last save state. From the initiating a new game from the staring menu screen, a new seed will be generated. This will allow the user to have more unique experiences in future playthrough of our game. 

**Have and artifact of the menu and game design**

In the next part we designed an UML off the initial idea for the class system as shown below as well as our product backlog. Everything will stem from the Game element, as our map is fully interactive. This means each block will in theory die when the player destroys it. like and enemy and main character.  The process of designing this UML diagram did not use CRC cards as we were not aware of that. Instead we all interacted with the miro board and discussed our ideas until we had the classes maped out. This was proablaly not as effcient as using CRC cards

**The artifact of the UML diagram** 



### Sprint review and presentation creation

From this second sprint we were all able to generate a basic character and have basic movement using libGdx and Java. The naming class we established and an initial UML borard was generated. All of these can be seen below. No one had any major problems, so the sprint was considered successful.

**All three artifacts** 

Following the sprint review we created the presentation for the customer meeting. This highlighted all our progress on each sprint task as well proposing some art styles for the game. 



## Backlog

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

- Create a simple character (square)
- give this character up, down, left, and right movement 
- FInd a common naming system
- Design classes and create a UML diagram

**Completed:**

- Find cross platofrm library
- Research on how GitHub version control works 
- Java research 
- Game development research 



## Exceptoinal handling 

There were no problems with this sprint or week.



## Product content 



## Customer meeting 

At the start of the week we had our first customer meeting which was presenting our initial idea for the game. The customer was happy with the premise of a mining based game where the user is able to interact with the map, whether it be destroying or building. We did not present a rigid plot. Instead we simply suggested the idea of the player falling down a hole where they awake and see a small figure approach (name: Pebble). Pebble explains the world they are now in and that he can help the player escape back above the surface. We suggested that Pebble could be the imagination of the main player, which could lead to many story plots. The feature we suggested was sanity which could change throughout the game. As the player gets more insane Pebble will help the player out more. This game mechanic can be used to help the player when they are stuck. The customer liked the idea of this and how we can implement this, and suggested we looked into Senua’s sacrifice. Finally, we showed some potential art styles for the game. The customer expressed interest in the high resolution with earth tones

 

We showed the progress of our game development. This was the UML diagram and game architecture. As the customer is very well versed in software engineering he suggested we look into Research Model view, and adapt out UML. We also showed the basic character moving around the screen to show visual game progress. 

**artifact here**

## User stories

| ID    | Version      | Priority     | Story                                                        |
| ----- | ------------ | ------------ | ------------------------------------------------------------ |
| US_01 | 2            | 1            | **AS A**   Player  **I WANT**   to be able to  play a dungeon game on different platforms web platforms **SO THAT**   I have choices  for playing the game |
| US_02 | 2            | 4            | **AS A**   Player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game by offering adivce |
| US_03 | **Deleting** | **Deleting** | **AS A**   Player  **I WANT**   to be able to compete  with a bot  **SO THAT**   I can have a goal  when playing |
| US_04 | 1            | 5            | **AS A**   **Player**  **I WANT**   to be able to  see my progress  **SO THAT**   So that I know  if I am doing well at the game as I play |
| US_05 | 2            | 7            | **AS A**   Player  **I WANT**   to have different  choices between games modes and diffrent paths to the end in each game mode **SO THAT**   I have new scenarios  to play |
| US_06 | 1            | 2            | **AS A** Player **I WANT** to interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07 | 1            | 3            | **AS A** Player **I WANT** to use resources to craft items **SO THAT** I can use them throughout the game to make tasks easier |
| US_08 | 1            | 6            | **AS A** player **I WANT** to be able to regenerate health **SO THAT** I can survive longer |

 

## User story testing 

| User story ID | Test                                                         | Comments                                                     | completed |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | --------- |
| US_01         | Run code on different systems and see if code compiles       | Web based sytems on Windows, Mac and Linux                   | YES       |
| US_02         | A bot character is generated on the game screen  The bot aids the user with text aids | The bot will have to be able to follow the player around the map, meaning it will need similar movement animations to the main character | NO        |
| US_04         | There is a visual queue on the screen that will track specific progression. | There are multiple types of progress – elevation, time ore collection | NO        |
| US_05         | Within the menu screen the player sets the game mode and the characteristics of the game change | These characteristics could be unlimited health, unlimited resources and no enemies | NO        |
| US_06         | The player can destroy a block and it disappears from the game screen. This block will then show up with in the inventory | From the inventory screen there are multiple options the player can take which require use cases and user stories | NO        |
| US_07         | There is an option to craft items from the inventory screen. If the player has the required resources, they can craft the item and the resources are taken from their inventory | You can implement many ways to show what can be crafted with the resources provided. | NO        |
| US_08         | Have the player take damage, from then the health will decrease and then it regenerates once they stop taking damage |                                                              | NO        |



## Use cases

##### UC_01

**Use case**: Player starts game on different systems

**Author**: TW

**Date**: 11/11/2020

**Modification date**: 11/11/202

**Purpose**: the game can run and be played on different systems

**Overview**: Frist the player will boot up their system (windows, mac or linux) and then open the game. If the code can compile and run on the system, the game starting screen will appear on a window else alternative: the code fails to run, and a system error will appear on their screen.

**Cross reference:** US_01

**Actors:** player

**Precondition:** 

- The system must have all the game components downloaded and ready to run
- There must be a screen to show the game on 
- Post condition: the system will access the code and run it
- The game is shown on the screen for the player to interact with 

**Normal flow of event:** 

| Actor actions                                  | System actions                                               |
| ---------------------------------------------- | ------------------------------------------------------------ |
| 1. The player will start up their system       | 2. the system will boot up and show desktop                  |
| 3. The player will click and run the game file | 4. System will start to run the code                         |
| 6. Player then interacts with the game         | 5. If the code can be run the game window will pop up on the players system |

**Alternative flow of events:**

- The code cannot run, the system will show an error message

**Exceptional flow of events:**

- The players system will not boot up
- The game window will pop up but the player cannot interact with it and the player will then close the game window



##### UC_02

**Use case**: Player destroys a block on the map

**Author**: TW

**Date**: 16/11/2020

**Modification date**: 16/11/202

**Purpose**: A major part of the game is allowing the user to interact with the map and change it. This means destroying the generated blocks and picking it up as a resource. 

**Overview**: First the player will decide they want to destroy a certain block in the game. Then they will attack the block until it is destroyed. The block will not be shown on the map and the player will add that block to their inventory.

**Cross reference:** US_06, US_04

**Actors:** player

**Precondition:** 

- There must be a block to destroy 
- The player must have an object that can cause damage to the block (fist, pickaxe, sword)

**Normal flow of events:** 

| Actor actions                                       | System actions                                          |
| --------------------------------------------------- | ------------------------------------------------------- |
| 1. The player will begin to attack the block (mine) | 2. The map generated block will take damage             |
| 3. The player will keep attacking the player        | 4. The map generated takes damage until it reaches zero |
| 7. Player can then repeat cycle with new blocks     | 5. The block will disappear                             |
|                                                     | 6. The block type will appear in the players’ inventory |

**Alternative flow of events:**

- The player destroys a block they are standing on. This will mean they will fall when it is destroyed until they encounter another block. They still gather the resource 

**Exceptional flow of events:**

- The player will stop attacking the block halfway, meaning the block is left with half health. 



##### UC_03

**Use case**: Player places a block on the map

**Author**: TW

**Date**: 16/11/2020

**Modification date**: 16/11/202

**Purpose**: A major part of the game is allowing the user to interact with the map and change it. This means placing blocks onto the map and taking it out of the players’ inventory 

**Overview**:  First the player will decide they want to place a certain block. Then the game will check of they have the resource to place. If they have, a block will appear on the game in the postion they wanted to place

**Cross reference:** US_06

**Actors:** player

**Precondition:** 

-  There must be a map block to place the new one on  

-  The player must have the desired block to place within their inventory

**Normal flow of events:** 

| Actor actions                                                | System actions                                               |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1. The player will enter the inventory                       | 4. The map notes the request to place a block on an existing block |
| 2. The player must have the desired block to place within their inventory | 5. The map generates the new block on the existing block     |
| 3. The player attempts to place the block on the map         | 6. The block type will be taken from the players’ inventory  |
| 7. Player can then repeat cycle with new blocks              |                                                              |

**Alternative flow of events:**

There are none

**Exceptional flow of events:**

- The player does not have any of the block type in their inventory, meaning no block will be placed



##### UC_04

**Use case**: Player crafts an item from the inventory

**Author**: TW

**Date**: 16/11/2020

**Modification date**: 16/11/202

**Purpose**: As the player gathers resources in the game, they will be able to create items such as a pickaxe. They will use these items to interact with enemies and the map.  

**Overview**:  First the player will decide they want to craft a certain item. Then the gaem will check they have the required resources for the item. If so, the item is crafted and the resources are taken from the players inventory. The item is also added to the inventory.

**Cross reference:**  US_07

**Actors:** player

**Precondition:** 

-  There must be the correct amount of resources to craft the item

**Normal flow of events:** 

| Actor actions                                                | System actions                                               |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1. The player will go to the inventory screen                | 3. The game will show what items can be crafted and what cannot |
| 2. The player will go to the craft menu                      | 5. The game will generate the item for the player and add it to their inventory |
| 4. The player will choose an item which they have resources for | 6. The resources required for the item will be taken form the players overall resources |
| 7. Player can then equip the item                            |                                                              |

**Alternative flow of events:**

There are none

**Exceptional flow of events:**

- The player will attempt to craft an item where they do not have the resources. A message will be displayed stating insufficient resources



**UC_05**

**Use case**: Player controls the movement of the character 

**Author**: TJ 

**Date**: 11/14/2020 

**Modification date**: 11/14/2020 

**Purpose**: the player can control the character to move up, down, left and right 

**Overview**: The player will press arrow keys and the block (the character) will move accordingly. 

**Cross reference:** US_01 

**Actors:** player 

**Precondition:** 

- The system must be able to show the player’s current position 
- The player needs to have a way of giving input (e.g. key press) 
- The input needs to be interpreted by the system 

- The system needs to respond by showing the updated position 

| Actor actions                                                | System actions                                               |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1. The player will press a key                               | 2. The system will interpret the input                       |
| 4. The player will keep giving input based on visual feedback and goals | 3. The system will update and show the player’s current position |

**Alternative flow of events:** 

- There are none

**Exceptional flow of events:** 

- The system not able to interpret player’s input 

- The system does not update or show the player’s position in time 



**UC_06**

**Use case**: As the players sanity goes up his sidekick will offer advice

**Author:** TW

**Date:** 15/11/2020

**Modification date:** 15/11/202

**Purpose:** the game can run and be played on different systems

**Overview:** During the game the player will go insane due to multiple conditions. This will often be due to parameters that are based on the player struggling to pass a certain stage of the game. Therefore, to help the player, the sidekick (Pebble) will offer advice to the certain stage of the game.

**Cross reference:** US_02

 **Actors:** player, sidekick

**Precondition**: The player must be a certain level of sanity to retrieve a certain amount of helpful information**.** As the sanity goes up so does the amount of information given.

**Post condition**: The system will assess the sanity percentage. If it reaches the required level, information will pop up on screen coming from Pebble.

| Actor actions                                            | System actions                                               |
| -------------------------------------------------------- | ------------------------------------------------------------ |
| 1. The player will start the game                        | 2. The system will set sanity to zero 10%                    |
| 3. Players begin to play the game                        | 5. System will constantly loop checking if the sanity level is at threshold for certain information |
| 4. As they play the sanity percentage will increase      | 6. If sanity is high enough, system will display information coming from pebble (1min cycle) |
| 7. Player sees information and keeps playing with advice | 9. System will constantly loop checking if the sanity level is at threshold for certain information |
| 8. Player sanity will decrease with progress             | 10. If sanity is below the threshold, then the information is no longer displayed. |

**Alternative flow of events:**

- The sanity stays in a certain band, so level of information is always given 
- Sanity jumps more than one band in one go, so the information given will skip one

**Exceptional flow of events:**

- The player sanity does not increase meaning that no information is given throughout the game. 



## Use cases testing

- [ ] **UC_01**
- [ ] **UC_02**
- [ ] **UC_03**
- [ ] **UC_04**

- [x] **UC_05:**

- The player will press one of the directional keys which will move the character in that desired direction. 
- The character will move by the specified amount of pixels in the sytem 

- [ ] **UC_06:**

- The sanity level will rise with the condition set 
- When the sanity level hits the threshold information function is triggered
- When the information function is triggered, Pebble will display information 
- Information can be seen coming from pebble, not random on the screen
- At higher sanity levels you don’t have lower tier information given with the said tear

 

 ##  Software design documentation

**UML artifact**



## User interface design

| Design implement                                             | Version |
| ------------------------------------------------------------ | ------- |
| There will be a starting menu screen with the game settings, load game, continue and new game | 2       |
| In the settings tab there will be choices for audio, visuals, and controls | 1       |
| Once in the game there will be character that can move and interact with the whole map | 1       |
| The player can go to an in game menu with save game and acheivements | 1       |
| The player can access an inventory screen which has options for equipment | 1       |
| In the equipment tab there will be options for view, craft, and delete | 1       |
| When the player had successfully completed the game they will be sent to the credits and the starting screen | 2       |

