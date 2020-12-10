\pagebreak

# Week 1: 16th- 2nd October

## **Process**



### Weekly overview 

This was the start of the project, meaning there was no coding. Instead, we planned: what game we wanted to create based on the initial customer specification; the programming language; control flow and communication (meetings), and the agile approach to the project. The week consisted of 2 meetings. The first meeting was to introduce ourselves and brainstorm ideas for the game, as well as plan the agile approach (Scrum) for the week. The second meeting was a sprint review followed by preparing the customer presentation. In between these two meetings we had daily stand-ups that were carried out on Microsoft teams.

\bcenter

![](./week_1_artifacts/week1_backlog.png){ width=50% }

\ecenter

Since the Scrum approach was chosen to be used in this project, we assigned a product lead and Scrum master. The product lead was responsible for setting out the sprint backlog from the product backlog created from the brainstorm meeting, while the Scrum master assured daily stand-up posts were being completed. All the sprint information was stored on GitHub for ease of access and updating the tasks.

From this initial sprint, we were able to analyse the use of teams for daily stand-up posts. This approach was great for dealing with multiple time zones as we had members in China, and clearly outlined what everyone had done, struggled with, and what they are working on. However, it did not notify everyone until the group was tagged in the post. This resulted in members missing the first couple of stand-ups. So, heading forward the Scrum master will tag the team in the initial post.




\pagebreak
### Meeting minutes

**Brainstorming and sprint planning meeting**

**Attendance:** He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo 

**Minutes:**

- Everyone in the group introduced themselves and discussed their programming background

- We decided what programming language we thought would be best for the project

- Each member presented their idea for the game based on the customer criteria given:

  - Top down view with the aim to escape the dungeon by doing tasks
  - Text type game where the user will pick answers that dedicate their journey through the dungeon
  - Side scroller game where the player can interact with the map as seen in Minecraft

- From the presentations we brainstormed a final game idea:

  - The player can generate tools from gathering resources from the map (blocks)
  - These tools will perish meaning the player will keep gathering resources throughout the game
  
  - The player can be assigned tasks to complete so they can escape the dungeon 
  - There could be a bot which can either help you or you race against it to escape
  
  - The game will have a time constraint so the user can be ware how good they are doing
  - The user can battle bosses which can be in a top down view
  
- We established initial tools to use in this project. This was GitHub to contain the sprint documentation and share code between use. Then teams for communication within the project as well as daily stand-ups.

- The first sprint everyone was assigned the same tasks as it was all researched based. These include find a cross-platform Java library, research version control and how GitHub works, game development research, Java research. The end of the sprint was the Friday.

**sprint review and presentation creation**

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu Ji, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo 

- From the assigned sprint tasks we were able to complete many of them for different individuals. 
- As many were understanding concept tasks, not all could be considered done. E.G for GitHub, some team members were still not comfortable with it.
- We created a presentation for the customer meeting next week. This contained our original idea for the game for the customer to decide if it fills the starting criteria to develop from.

This is a link to the first presentation for the customer meeting 23rd October: [link](https://computingservices-my.sharepoint.com/:p:/g/personal/vpl22_bath_ac_uk/EXuDPu9iA85BjODgRgP3Y6wBMNTvxc8W3fzBx68dvrNY4A?e=TCF88V)




\pagebreak
### Backlog

**Product backlog:**

- Find cross platform library
- Understand GitHub for version control
- Java research
- Game development research 

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

**sprint backlog**

- Find cross platform library
- Understand GitHub for version control
- Java research 
- Game development research 



\pagebreak

### Exception handling

At this early stage there were no issues within the project. 


\pagebreak
## **Product contents**



### Customer interview

In this week we had no customer meeting but instead the customer debrief:

- I want a dungeon game that I can play on my laptop, or perhaps on my phone. 
- Perhaps it would be nice to be able to build a “bot” to play the game on its own or perhaps to compete with other bots?
- How can I know whether I or my bot are doing well? 
- How can the challenge of the game be changed?



This was vague meaning we had plenty of choice of where we wanted to go with the game. One key part was the game being able to be played on multiple devices. This made Java a good choice for game development as it can be used for android gaming. The use of a bot in our mining dungeon game had multiple possibilities such as: mining for the player, hold items for the player, provide hints and tips, and fight for the player. In order to track progress, we could implement a progress bar, time limit, kill number, equipment gained (precious ores). The game can have multiple ways of how it can change the difficulty. We can include achievement system, creative or survival mode, altitude challenge, mining challenge and adjust time constraint.

\pagebreak
### User stories

| ID    | Version | Priority | Story                                                        |
| ----- | ------- | -------- | ------------------------------------------------------------ |
| US_01 | 1       | 1        | **AS A**   player  **I WANT**   to be able to  play a dungeon game on different platforms  **SO THAT**   I have choices  for playing the game |
| US_02 | 1       | 4        | **AS A**   player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game |
| US_03 | 1       | 5        | **AS A**   player  **I WANT**   to be able to compete  with a bot  **SO THAT**   I can have a goal  when playing |
| US_04 | 1       | 6        | **AS A**   player  **I WANT**   to be able to  see my progress  **SO THAT**   So that I know  if I am doing well at the game as I play |
| US_05 | 1       | 7        | **AS A**   player  **I WANT**   to have different  choices between games modes  **SO THAT**   I have new scenarios  to play |
| US_06 | 1       | 2        | **AS A** player **I WANT** to move around and interact with the blocks on the map **SO THAT** I can gather resources, place resources, and make new paths |
| US_07 | 1       | 3        | **AS A** player **I WANT** to use resources to craft items **SO THAT** I can use them throughout the game to make tasks easier |


\pagebreak
### User stories tests

| User story ID | Test acceptance                                              | comments                                                     | completed |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | --------- |
| US_01         | Run code on different systems and see if code compiles       |                                                              | NO        |
| US_02         | A bot character is generated on the game screen  The bot aids the user with text aids | The bot will have to be able to follow the player around the map, meaning it will need similar movement animations to the main character | NO        |
| US_03         | Monitor to see if the bot is attempting task within the game |                                                              | NO        |
| US_04         | There is a visual queue on the screen that will track specific progression. | There are multiple types of progress – elevation, time ore collection | NO        |
| US_05         | Within the menu screen the player sets the game mode and the characteristics of the game change | These characteristics could be unlimited health, unlimited resources and no enemies | NO        |
| US_06         | The player can destroy a block and it disappears from the game screen. This block will then show up with in the inventory | From the inventory screen there are multiple options the player can take which require use cases and user stories | NO        |
| US_07         | There is an option to craft items from the inventory screen. If the player has the required resources, they can craft the item and the resources are taken from their inventory | You can implement many ways to show what can be crafted with the resources provided. | NO        |


\pagebreak
### Use cases

At this stage of the process we had not considered to implement use cases in our development approach. This was due to us not having our game idea confirmed by the customer, as well as not being aware of the process since the lecture material was not release yet. Instead we had user stories as shown in the user story section, which is a similar to a less dressed version of the use cases. 

\pagebreak
###  Use cases Tests

As we had no use case there were no tests to conduct. 


\pagebreak
### Software design Documentation

At this stage, no thought has been given into the software design and classes as the mining game has not been confirmed by the customer. 


\pagebreak
### User interface design

This is a basic framework of how the potential game will look like to the user. 

| Design implement                                             | Version |
| ------------------------------------------------------------ | ------- |
| There will be a starting menu screen with the game setting and the start function | 1       |
| Once in the game there will be character that can move and interact with the whole map | 1       |
| When the player had successfully completed the game they will be sent back to the starting menu screen | 1       |



