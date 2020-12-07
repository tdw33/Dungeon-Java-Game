# Week 8 Documentation: 4th- 7th December

## Process

### Weekly overview 

This was the final week of the Software Engineering unit, meaning  we decided to focus most the week on documentation. This is why the dates are from 4th-7th December, as we wanted to have our final version of the game finished on Monday. The game was able to fulfil most of our user stories and use cases to its basic level, which we adjusted back in week 5. 

We had on meeting on the Friday after the customer meeting to discuss what needed implementing and what bugs needed to be looked at in the last few days. We only had one think to implement and the rest was just fixing bugs and tweaking already implemented features. Then on Monday we had our final meeting to check the game and agree that was our final version. While this was going on  we did break up the team to start tackling the different parts of the documentation.

We carried on the same style of sprint as last week and although we were not implanting a lot this week, we still looked over the documentation to assess if we were able to fulfil user stories and use cases. This helped decide what bugs to fix in this sprint. This was a small sprint so not too much was learnt from the process. Instead we appreciated the time to develop features within a game, and the importance of having up to date use cases and user stories to optimize your time. 

### Meeting minutes 

#### Customer meeting debrief and sprint planning

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo 

After the customer meeting, the team held a meeting to discuss game features bugs that need to be worked on: 

- Have the end credits pop up onto the screen when the boss is killed
- After the end credits you are taken to the starting screen
- Fix some bugs within the game:
  - The archers will face the way they are shooting
  - The enemies will only follow the player when the player is in a certain radius of the player
  - 

#### Sprint review and final game development meeting

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo 



### Backlog

**Product backlog:**

**Sprint backlog:**

- Add credit scenes which are triggered when the boos dies or the timer runs out
- From the credit scene the user is taken back to the starting game screen
- fix bugs
- Documentation part 1

**completed:**

### Exception Handling:

Due to a major part of the unit being the documentation, we had to accept what our final game is capable of being. 



## Product content

### customer meeting

The customer seemed to be satisfied with the progress shown. No requirements were mentioned during the meeting.

### User stories

| ID        | Version | Priority | Story                                                        |
| --------- | ------- | -------- | ------------------------------------------------------------ |
| US_01     | 2       | 1        | **AS A**   Player  **I WANT**   to be able to  play a dungeon game on different platforms web platforms **SO THAT**   I have choices  for playing the game |
| US_02     | 2       | 5        | **AS A**   Player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game by offering advice |
| US_04     | 2       | 6        | **AS A**   **Player**  **I WANT**   to be able to  see a timer go down  **SO THAT**  I know  if I am doing well at the game as I play |
| US_05     | 2       | 14       | **AS A**   Player  **I WANT**   to have different  choices between games modes and different paths to the end in each game mode **SO THAT**   I have new scenarios  to play |
| US_06     | 1       | 2        | **AS A** Player **I WANT** to control the character’s movement and interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07     | 2       | 3        | **AS A** Player **I WANT** to use resources to upgrade armour and weapons **SO THAT** I can use them throughout the game to make fighting enemies easier |
| US_08     | 1       | 11       | **AS A** player **I WANT** to be able to regenerate health **SO THAT** I can survive longer |
| US_09     | 1       | 9        | **AS A**   Player  **I WANT**   to see a high-resolution game style **SO THAT** the background, items and characters seem clearer |
| US_10     | 1       | 13       | **AS A**   Player  **I WANT**   to be able to explore a range of different backgrounds **SO THAT** the game is more playable |
| US_11     | 1       | 12       | **AS A**   Player  **I WANT**   to see a more detailed storyline with episodes and gain skills along the way **SO THAT** I can be more motivated to play and see how an episode will end and how the character develops |
| US_12     | 1       | 10       | **AS A** player **I WANT** to be able to gain height in the map quickly **SO THAT** I can save time in reaching parts of the map |
| US_13     | 1       | 7        | **AS A** player **I WANT** to battle enemies **SO THAT** the game has a challenge to it |
| US_14     | 1       | 4        | **AS A** player **I WANT** to see how many resources have been collected **SO THAT** I know the current number of each materials already collected and how many more I need in order to upgrade armour or craft items |
| US_15     | 1       | 8        | **AS A** player **I WANT** to see how much health the enemies I’m fighting against have left **SO THAT** I have an idea of how much time it takes to defeat them |
| **US_16** | 1       | 15       | AS A player I WANT to see the end credits when I kill the boss at the end of the game, run out of time or die |

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
| US_12         | The player starts a certain y position. Then in a time shorter than climbing blocks, the player is elevated to a higher y coordinate | There are different ways to achieve this, such as placing a block down which will change the gravity in the vertical plane | YES       |
| US_13         | The player will come into contact with the enemy, where the enemy will begin to attack the player | The enemy could use projectiles or melee to attack the player. They could also be stationary or mobile. | YES       |
| US_14         | The player will see an inventory screen with different materials shown and craft items | Each type of block will be shown using both a small picture and name such as iron, with a number behind. | YES       |
| US_15         | The player will see a health bar above each enemy’s head     | The health bar reduces when the player attacks the enemy.    | YES       |
| **US_16**     | The player will either kill the boss, run out of time or die. As soon as this happens the credits will take up the screen. | Following the credits the user should be taken to the starting screen | YES       |

### Use cases

| Use case ID | Use case description                                         | Tested |
| ----------- | ------------------------------------------------------------ | ------ |
| UC_01       | Player starts game on different systems                      | YES    |
| UC_02       | Player destroys a block on the map                           | YES    |
| UC_03       | Player places a block on the map                             | YES    |
| UC_04       | Player crafts armour from the inventory                      | YES    |
| UC_05       | Player controls the movement of the character                | YES    |
| UC_06       | As the players sanity goes up his sidekick will offer advice | NO     |
| UC_07       | have high-resolution items, characters and environment       | YES    |
| UC_08       | Play in different environments                               | NO     |
| UC_09       | The characters’ down movements                               | YES    |
| UC_10       | Collision system                                             | YES    |
| UC_11       | Main character gain skills as the story progresses           | NO     |
| UC_12       | The enemy will fire a projectile at the main character       | YES    |
| UC_13       | The boss attacks the player                                  | YES    |
| UC_14       | Player walks on block and reverses gravity                   | YES    |
| UC_15       | Check inventory                                              | YES    |
| UC_16       | Player’s health decreases when taking damage                 | YES    |
| UC_17       | Player walks on block and reverses gravity                   | YES    |
| UC_18       | Enemy has a health bar that will go down when attacked       | YES    |

### Use case testing

## 

- [x] **UC_01**
- [x] **UC_02**
- [x] **UC_03**
- [x] **UC_04**
- [x] **UC_05**
- [ ] **UC_06**
- [x] **UC_07**
- [ ] **UC_08**
- [x] **UC_09**
- [x] **UC_10**
- [x] **UC_11**
- [x] **UC_12**
- [x] **UC_13**
- [x] **UC_14**
- [x] **UC_15**
- [x] **UC_16**
- [x] **UC_17**
- [x] **UC_18**

### Software design documentation

 Class: credits

**Responsibilities:**

- Show the user the authors of the game
- be able to close main game (return to starting screen)

**Collaborators:**

- Boss enemy
- Character
- Timer

### User interface design

- Character:
  - Once in the game there will be character that can move and interact with the whole map [1]
  - The character needs to be able to drop to lower heights [1]

- Menu:  
  - There will be a starting menu screen with the game settings, load game, continue and new game [2]
  - In the settings tab there will be choices for audio, visuals, and controls [1]
  - The player can go to an in game menu with save game and achievements [1]  
  - When player is in the game, two buttons are shown on the top of the screen (inventory and menu) [1]

- Sounds:
  - There should be background music played at the menu screen and during the game. Background music can change along with the character’s state such as sanity levels and become more intense during events like a boss fight [1]
  - Sounds should be triggered when certain actions are performed (e.g. menu click, fight, mining) [1]

- Inventory:
  - The player can access an inventory screen which has options for equipment [1]
  - In the equipment tab there will be options for view, craft, and delete [1]
  - Different types of materials gathered from a variety of blocks are shown, each with a number that indicates how many have been collected [1]
  - **Player can craft Armor from gathered blocks [1]**

- Game flow:
  - When the player had successfully completed the game they will be sent to the credits and the starting screen [2]
  - A video will be shown that includes credits at the end of the game [1]
  - **Following the end credits the plater will be taken to the starting screen [1]**

- Map:
  **The map should have blocks that can’t be destroyed along the edge [2]**
  - The map should have different types of blocks [1]

- Pebble: 
  - A speech bubble will appear above Pebble that gives players instructions [1]
  - **Pebble will appear near the main character again if the distance between them gets to a certain amount [1]**

