# Goal

The repo is to contain the experiments based on the [Mastermind Game] (https://en.wikipedia.org/wiki/Mastermind_(board_game)). The result of this 
exercise is to 

1. implement the game with mutliple extensions 
2. evaluate libs from JDK with regards to what the class is trying to teach the students 
3. create assignments/rubrics for use with CS5004 
4. test harness for assignments 

# Plan 

We plan to build different versions of the game 

1. One player, no network, single thread, GUI game 
  * Program randomly selects the hidden peg pattern (codemaker)
  * Player is the codebreaker 
  * On every turn codemaker annotates the proposed peg pattern suggested by the codebreaker
2. One player, no network, single thread, GUI game 
  * Player is codemaker, sets the peg pattern 
  * Program is codebreaker, suggests proposed pattern player annotates 
  * Extend so that annotations are made by the program 
  * Run a competition to see which solution breaks the code faster 
    * program's wall time 
    * number of moves 
3. Two player, network, 
  * Codemaker on machine A 
  * Codebreaker on machine B 

———
# To Dos

1. Model:


2. View:
  * extract the color maps from KeyRow and CodePegRow and replace with 1 universal color map for pegs - probably should be its own class…
    * also, use that color map to create the color key display on the GUI
  * make an interface for the GUI
  * make all coordinates into constants rather than magic values
  * make some Board components into classes, try to group them together - targetRow plus targetLabel, etc.





