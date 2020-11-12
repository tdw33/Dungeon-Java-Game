# Week 0



## **Process**



## Weekly overview 

This was the start of the project, meaning there was no coding. Instead, we planned: what game we wanted to create based on the initial customer specification; the programming language; control flow and communication (meetings), and the agile approach to the project. The week consisted of 2 meetings. The first meeting was to introduce ourselves and brainstorm ideas for the game, as well as plan the agile approach (Scrum) for the week. The second meeting was a sprint review followed by preparing the customer presentation. In between these two meetings we had daily stand-ups that were carried out on Microsoft teams.

**Artifact on the stand-ups used**

Since the Scrum approach was chosen to be used in this project, we assigned a product lead and Scrum master. The product lead was responsible for setting out the sprint backlog from the product backlog created from the brainstorm meeting, while the Scrum master assured daily stand-up posts were being completed. All the sprint information was stored on GitHub for ease of access and updating the tasks.

**Artifact of the project on GitHub**

From this initial sprint, we were able to analyse the use of teams for daily stand-up posts. This approach was great for dealing with multiple time zones as we had members in China, and clearly outlined what everyone had done, struggled with, and what they are working on. However, it did not notify everyone until the group was tagged in the post. This resulted in members missing the first stand-ups. So, heading forward the Scrum master will tag the team in the initial post.



## Meeting minutes

### Brainstorming and sprint planning meeting

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo

Minutes:

- Everyone in the group introduced themselves and discussed their programming background.

- We decided what programming language we thought would be best for the project.

- Each member presented their idea for the game based on the customer criteria given:

  - Top down view with the aim to escape the dungeon by doing tasks.
  - Text type game where the user will pick answers that dedicate their journey through the dungeon.
  - Side scroller game where the player can interact with the map as seen in Minecraft.

- From the presentations we brainstormed a final game idea:

  - The player can generate tools from gathering resources from the map (blocks).
  - These tools will perish meaning the player will keep gathering resources throughout the game.
  
  - The player can be assigned tasks to complete so they can escape the dungeon. 
  - There could be a bot which can either help you or you race against it to escape.
  
  - The game will have a time constraint so the user can be ware how good they are doing.
  - The user can battle bosses which can be in a top down view.
  
- We established initial tools to use in this project. This was GitHub to contain the sprint documentation and share code between use. Then teams for communication within the project as well as daily stand-ups.

- The first sprint everyone was assigned the same tasks as it was all researched based. These include find a cross-platform Java library, research version control and how GitHub works, game development research, Java research. The end of the sprint was the Friday.

### sprint review and presentation creation

Attendance: He Jiang, Julius Martinez, Lewis Williams, Samuel Love, Tianyu, Tom Wells, Vlad Postmangiu Luchian, Yandong Guo

- From the assigned sprint tasks we were able to complete many of them for different individuals. 
- As many were understanding concept tasks, not all could be considered done. E.G GitHub some team members were still not comfortable with the it
- We created a presentation for the customer meeting next week. This contained our original idea for the game for the customer to decide if it fills the starting criteria to develop from.

**Have artifact showing part of the presentation**



## backlog

**This could be a artefact from the wiki page but probably best to make a new one**

**artefact of the new sprint backlog**



## Exception handling

At this early stage there were no issues within the project. 



## product contents



### Customer interview

In this week we had no customer meeting but instead the customer debrief:

- I want a dungeon game that I can play on my laptop, or perhaps on my phone. 
- Perhaps it would be nice to be able to build a “bot” to play the game on its own or perhaps to compete with other bots?
- How can I know whether I or my bot are doing well? 
- How can the challenge of the game be changed?



This was vague meaning we had plenty of choice of where we wanted to go with the game. One key part was the game being able to be played on multiple devices. This made Java a good choice for game development as it can be used for android gaming. The use of a bot in our mining dungeon game has multiple possibilities such as: can mine for the player, hold items for the player, provide hints and tips, and fight for the player. In order to track progress, we could implement a progress bar, time limit, kill number, equipment gained (precious ores). The game can have multiple ways of how it can change the difficulty. We can include achievement system, creative or survival mode, altitude challenge, mining challenge and adjust time constraint.

### User stories

| ID    | Version | Priority | Story                                                        |
| ----- | ------- | -------- | ------------------------------------------------------------ |
| US_01 | 1       | 1        | **AS A**   Player  **I WANT**   to be able to  play a dungeon game on different platforms  **SO THAT**   I have choices  for playing the game |
| US_02 | 1       | 4        | **AS A**   Player  **I WANT**   to have a bot  that that will play for me  **SO THAT**   It can help me  with playing through the game |
| US_03 | 1       | 5        | **AS A**   Player  **I WANT**   to be able to compete  with a bot  **SO THAT**   I can have a goal  when playing |
| US_04 | 1       | 2        | **AS A**   **Player**  **I WANT**   to be able to  see my progress  **SO THAT**   So that I know  if I am doing well at the game as I play |
| US_05 | 1       | 3        | **AS A**   Player  **I WANT**   to have different  choices between games modes  **SO THAT**   I have new scenarios  to play |



### User tests

| User story ID | Test                                                         | Comments                                                     | completed |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | --------- |
| US_01         | Run code on different systems and see if code compiles       |                                                              | NO        |
| US_02         | A bot character is generated on the game screen  The bot aids the user with text aids | The bot will have to be able to follow the player around the map, meaning it will need similar movement animations to the main character | NO        |
| US_03         |                                                              |                                                              | NO        |
| US_04         | There is a visual queue on the screen that will track specific progression. | There are multiple types of progress – elevation, time ore collection | NO        |
| US_05         | Within the menu screen the player sets the game mode and the characteristics of the game change | These characteristics could be unlimited health, unlimited resources and no enemies | NO        |



### Use cases

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



### Tests

No tests this week



### Software design Documentation

Need to look at CRC

### User interface design

