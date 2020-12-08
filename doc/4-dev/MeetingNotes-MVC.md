MVC: 
- User uses controller->Controller manipulates model->Model updates view->View sees user 
  - Need a model class- the map of all the elements
  - View is the camera - main view takes input and send to controller
  - Controller is all of the characters and elements/methods of the elements

Move
- View reads position from model
- Player in the model gives player position to the main view->Render(): A key press in main view->sends to controller which interprets the key and then change player position in the model

Map
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


This week: have a map generator, seed is the size, implement easy roles of how to place elements

