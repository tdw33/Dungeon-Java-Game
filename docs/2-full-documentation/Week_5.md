\pagebreak

# **Week 5 documentation: 13th-19th November** 

## **Process**

### Weekly overview

From week 4 we had a greater sense of the direction of the story and as a result, was able to develop the game with great progress. From both sprints we were able to achieve: documentation for week 2-3, code refactoring, animation added to the main character, enemy implementation, pebble walk animation and pebble follows player, digging and block placement, countdown timer, arrow projectile, menu screen. Many of these were achieved in early implementation so would be continued in next week's sprint. Within the customer meeting, there was great interest in gravity implemented from the week prior, and how it could be changed throughout the map. Therefore, we planned how gravity can be implemented in the game under different circumstances.

From last week we attempted to have shorter sprints so that we could review what we achieved and plan a second sprint before the next customer meeting. This resulted in the first sprint from 13th- 17th and the second sprint from 17th- 19th. The results from both sprints did result in plenty of progress from the team and served a good update where other members of the team were on top of the daily stand-ups. However, the team agreed many of the tasks set ended up taking longer than the first sprint so it was not beneficial to have two sprints. Heading forward we will go back to one long sprint with an extra sprint meeting between the planning and sprint review if required.

As a group, we became concerned about what we set out to achieve and the time to do it. Therefore, the user stories and use cases were adjusted to their basic level. An example being the inventory being just full armour and weapon upgrades instead of having a crafting table to create different types of armour. These revised changes will allow our minimum viable product goals to be met, which has been a crucial goal of our team throughout this process. It was also apparent we were not putting in enough thought to prioritise our backlog and what needed achieving. Future weeks will focus on analysing what needs doing first and then focus on the added touches to features. To achieve this we would assess the previous use cases and user stories, instead of previous weeks where we informally talked about what has been done and needs completing next in the sprint planning meeting. 

The presentation created for the customer meeting on the 13th November can be found here, which will have GIFs for some of the artefacts shown here:  [Presentation](https://github.bath.ac.uk/Team-Cyan/Dungeon/blob/master/docs/1-presentations/week5-presentation/presentation.md)

\pagebreak

### Meeting minutes

**Customer meeting debrief and sprint planning:** 

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \

**Minutes:**

Following the costumer meeting we agreed that it would be much appreciated by the customer if we definitely  included varying gravity in the game. So , we talked about implementing reverse gravity in the game in order to elevate the payer to new heights.  

For the sprint we decided to focus on getting some core components of the game down:  character sprite implemented, dig and placing blocks, pebble movement, sound, enemy projectiles, and menu screen. At the same time, the documentation was continued to be worked on. The sprint goal was to finish week 4 and 5.

\

 **First sprint review and second sprint plan**:

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \

**Minutes:**

At the start of the meeting we went over what has been achieved by each member of the group. This ended up being a mix of finishing what we aimed to do and not. After this, we discussed our concerns on what could be achieved by the end of this game development process. It was clear we had not thought enough previously on what is achievable by us as a group and that we can split task more effectively. The new revised changes were:

- Having an example map that we make so that there is a playable map for the player. Map will consist of 3 different types of staged areas and a side scroller boss area for the player to fight against
- The inventory will not have a crafting element, but just options to upgrade full armour set. This is based on if the payer has enough of a certain block (e.g. gold)
-  One enemy type that will have a projectile. The enemies can have different armour and damage ratings

With all this we made our second sprint goals. These were to continue projectiles, digging and placing blocks, documentation. Then new targets were refactoring code and countdown timer. 

\

**Second sprint review and presentation creation**

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo \

**Minutes:**

As this was a big week and many of the previous sprint tasks were not completed, so we were excited to see the progress be put all together. All the previous sprint goals were achieved. One major change was the refactoring of the code, so now it is clearer, and any future developments should not cause as many bugs when being merged.

Below are all the features achieved, but make sure to check the presentation link in the weekly overview to see the GIF version.

\

\bcenter

**Game animations**

![](./week_5_artifacts/animations.gif)

\pagebreak

**Enemy projectile**

![](./week_5_artifacts/arrow.gif){ width=50% }



**Mining and placing**

![](./week_5_artifacts/dignplace.gif)

\pagebreak

**Final menu screen choice**

![](./week_5_artifacts/menuscreen.png)

\pagebreak

**Timer**

![](./week_5_artifacts/timer.gif)

\pagebreak

**Code refactoring**

![](./week_5_artifacts/tree.png)

\ecenter

Following our sprint review, we created the presentation for the customer. This followed the same template with reminding the customer of last week’s presentation, then showing updated and finally telling them our future work. This was done on Markdown so that we could show GIFs, meaning the customer could visually see the changes. 

\pagebreak

### Backlog

**Product backlog:**

This product backlog was revised this week as we discussed what is achievable in the time frame given. The items in bold are potential implementations if there is time. 

- **The crafted tools will break over time**

- **There will be tasks to complete in order for the player to escape**
- The player will fight a boss in the final game scene to escape the dungeon 
- There is an antigravity block allowing the player to rise until he is out of the vertical axis or collides with block
- **Random generation of block map (side on view)**

 **Sprint backlog:**

- Implementing sounds
- Implement animations
- Example map that the game will load (horizontal view)
- Documentation
- A player is spawned on the map
- The player can interact with the blocks of the map (destroy and create)
- The player can collect blocks as resources which is stored in an inventory
- The players resources can be used to upgrade armour and weapon sets
- The player will have a sidekick (bot) which will help the player by offering advice
- Code refactoring 
- Enemy projectiles
- There will be a timer shown to the player on the screen which runs down as they go through the game

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

\pagebreak


### Exceptional handling 

There were no problems with this sprint or week.

\pagebreak

## **Product content** 

### Customer meeting 

This followed the previous weeks. The customer was happy with the progress again and was curious about how we could develop some first feature implementations. The greatest curiosity was in the use of gravity throughout the game. Therefore, we discussed how best this could be implemented into the game. The game had still not sorted out the player climbing and ascending in the game, so we thought it would be good to have a block that could reverse gravity. This would mean the player could gain height in empty space, for that vertical game.

\pagebreak

### User stories

| ID        | Version | Priority | Story                                                        |
| --------- | ------- | -------- | ------------------------------------------------------------ |
| US_01     | 2       | 1        | **AS A**   player  **I WANT**   to be able to  play a dungeon game on different platforms web platforms **SO THAT**   I have choices  for playing the game |
| US_02     | 2       | 4        | **AS A**   player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game by offering advice |
| US_04     | 2       | 5        | **AS A**   player  **I WANT**   to be able to  see a timer go down  **SO THAT**  I know  if I am doing well at the game as I play |
| US_05     | 2       | 12       | **AS A**   player  **I WANT**   to have different  choices between games modes and different paths to the end in each game mode **SO THAT**   I have new scenarios  to play |
| US_06     | 1       | 2        | **AS A** player **I WANT** to control the character’s movement and interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07     | 2       | 3        | **AS A** player **I WANT** to use resources to upgrade armour and weapons **SO THAT** I can use them throughout the game to make fighting enemies easier |
| US_08     | 1       | 9        | **AS A** player **I WANT** to be able to regenerate health **SO THAT** I can survive longer |
| US_09     | 1       | 7        | **AS A**   player  **I WANT**   to see a high-resolution game style **SO THAT** the background, items and characters seem clearer |
| US_10     | 1       | 11       | **AS A**   player  **I WANT**   to be able to explore a range of different backgrounds **SO THAT** the game is more playable |
| US_11     | 1       | 10       | **AS A**   player  **I WANT**   to see a more detailed storyline with episodes and gain skills along the way **SO THAT** I can be more motivated to play and see how an episode will end and how the character develops |
| **US_12** | 1       | 7        | **AS A** player **I WANT** to be able to gain height in the map quickly **SO THAT** I can save time in reaching parts of the map |
| **US_13** | 1       | 6        | **AS A** player **I WANT** to battle enemies **SO THAT** the game has a challenge to it |

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
| **US_12**     | The player starts a certain y position. Then in a time shorter than climbing blocks, the player is elevated to a higher y coordinate | There are different ways to achieve this, such as placing a block down which will change the gravity in the vertical plane | NO        |
| **US_13**     | The player will come into contact with the enemy, where the enemy will begin to attack the player | The enemy could use projectiles or melee to attack the player. They could also be stationary or mobile. | NO        |

\pagebreak

### Use cases

##### Existing use cases:

| Use case ID | Use case description                                         | Tested |
| ----------- | ------------------------------------------------------------ | ------ |
| UC_01       | Player starts game on different systems                      | YES    |
| UC_02       | Player destroys a block on the map                           | NO     |
| UC_03       | Player places a block on the map                             | NO     |
| UC_04       | Player crafts an item from the inventory                     | NO     |
| UC_05       | Player controls the movement of the character                | YES    |
| UC_06       | As the players sanity goes up his sidekick will offer advice | NO     |
| UC_07       | have high-resolution items, characters and environment       | YES    |
| UC_08       | Play in different environments                               | NO     |
| UC_09       | The characters down movements                                | NO     |
| UC_10       | Collison system                                              | NO     |
| UC_11       | Main character gain skills as the story progresses           | NO     |

##### New use cases:

\

**UC_12**

**Use case**: The enemy will fire a projectile at the enemy\
**Author**: TW\
**Date**: 13/11/2020\
**Modification date**: 13/11/2020 \
**Purpose**: The player needs a challenge in the game. One part is battling enemies so they need to be able to identify and attack the player.\
**Overview**: The player will come in range of the enemy where it will begin to fire projectiles targeted at the player. Either the player will die or the move out of the firing range. Then the enemy will stop shooting.\
**Cross reference**: US_13 \
**Actors**: Player, enemy\

**Precondition**:

- Character can move into range of the enemy 
- The enemy is spawned within the map

**Normal flow of events:**

| Actors actions                                               | System actions (enemy)                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1. Player will walk until they are in range of enemy         | 2. The enemy will pick up the player in the attack range     |
| 4. The player will take damage form the projectile           | 3. The enemy will begin to fire projectiles targeted at the player (projectile animation) |
| 5. The player ends up dying and goes through death animation | 6. The enemy no longer sees player in range so will stop firing projectiles |

 **Alternative flow of events:**

- The player will attack the enemy and kills it. The enemy will have death animation and no longer fire projectiles at the player when in range
- The player runs away from the enemy so is no longer in range. The enemy will therefore stop firing projectiles

 **Exceptional flow of events:**

- The player builds a wall between them and the enemy. The enemy will stop firing projectiles even if it was the player was in range before as the enemy can no longer see the player 

\

**UC_13**

**Use case**: The boss attacks the player \
**Author**: TW \
**Date**: 13/11/2020 \
**Modification date**: 13/11/2020 \
**Purpose**: The player needs a challenge in the game. One part is battling enemies so they need to be able to identify and attack the player. In this case this is a more powerful enemy. \
**Overview**: The player will come in range of the enemy where it will begin to follow and attack the player through melee. Either the player will die or the move out of attack range. Then the boss will stop following. \
**Cross reference**: US_13  \
**Actors**: Player, boss \

**Precondition**:

- Character can move into range of the enemy 
- The enemy is spawned within the map

**Normal flow of events:**

| Actors actions                                               | System actions (boss)                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1. Player will walk until they are in range of boss          | 2. The boss will pick up the player in the attack range      |
| 4. The player will take damage form the attack               | 3. The enemy will begin to follow and attack the player (melee animation) |
| 5. The player ends up dying and goes through death animation | 6. The enemy no longer sees player in range so will stop following and attacking |

 **Alternative flow of events:**

- The player will attack the enemy and kills it. The boss will have death animation and no follows or attacks the player
- The player runs away from the boss so is no longer in range. The boss will therefore stop following

 **Exceptional flow of events:**

- The player builds a wall between them and the boss. The boss will stop following the player even if the player was in range before as the boss can no longer see the player 

\

**UC_14**

**Use case**: Player walks on block and reverses gravity \
**Author**: TW \
**Date**: 13/11/2020 \
**Modification date**: 13/11/2020 \
**Purpose**: The player needs to move up the dungeon to progress. This antigravity method will allow quick upward movement in the game. \
**Overview**: This block will allow the plater to quickly elevate in the map, adding more depth to the game and feel. \
**Cross reference**: US_12 \
**Actors**: Player\

**Precondition**:

- Antigravity block is placed within the map
- There is no block directly on top of the antigravity block 

**Normal flow of event**s:

| Actors actions                                               | System actions (boss)                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1. Player will walk until they are on top of the antigravity block | 2. The system will acknowledge player is in y plane of the block |
| 4. The player will appear to move up on the map              | 3. The system will push the player upwards                   |
| 5. The player will collide with a block above them within the map | 6. The system will acknowledge the collision but will keep attempting to push the player upwards |
| 7. The player will no longer move up                         | 9. System will acknowledge the player is not in y plane of the antigravity block, so reverts gravity back to normal for the player |
| 8. The player will move out of the y plane                   |                                                              |
| 10. The player will fall down until they collide with a block |                                                              |

 **Alternative flow of events:**

- The player will place the block from there inventory. Then it follows the same flow of events
- The player leaves the y plane before they collide with a block above them. This will cause the plater gravity to revert back to normal

 **Exceptional flow of events:**

- The player will place block above them as they go upwards which will cause them to stop in that direction

\pagebreak

### Use case testing

- [x] **UC_01**
- [ ] **UC_02**
- [ ] **UC_03**
- [ ] **UC_04**
- [x] **UC_05**
- [ ] **UC_06**
- [ ] **UC_07**
- [ ] **UC_08**
- [x] **UC_09**
- [ ] **UC_10**
- [ ] **UC_11**
- [ ] **UC_12**

- The enemy is able to identify player when in range
- The enemy can fire projectiles when they pick up the player
- The projectile will disappear when it hits the enemy 
- The projectile causes damage to the player

- [ ] **UC_13**

- The enemy is able to identify player when in range
- The enemy will follow and attack the player
- The melee causes damage to the player

- [ ] **UC_14**

- The system can pick up when the player is in the blocks y plane
- Gravity is reversed to a certain speed set 
- The player does not travel through any blocks and does not get caught on block horizontally to them

\pagebreak

### Software design documentation 

**Class: antigravity (see UC_14)**

Responsibilities:

- reverse the gravity on that block
- allows the character to fell this affect

Collaborators:

- Position    
- Character   
- Environment

\

**Class: Boss (see UC_13)**

Responsibilities:

- Player damage

Collaborators:

- Player health

\

**Class: Enemy (see UC_12)**

Responsibilities:

- Player damage

Collaborators:

- Player health
- gravity

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
- On this screen the player can see amount of each block, craft option for armour and which block is being placed[2]

**Game flow:**

- When the player had successfully completed the game they will be sent to the credits and the starting screen [2]
- The map should have edges and certain sections that the user cannot pass through such as a wall [1]

**Pebble:**

- Dialog box at the bottom of the screen at the beginning of each episode (instructions and story-telling from Pebble), which can be skipped [1]

