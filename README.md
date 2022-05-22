# Proyect-2

Luis E. Ortiz cotto
#801-16-5704
CCOM4029 Sec.002
Prof. Patricia Ordonez

The purpose of this project is to run a game of rummy for which the player has to create a stack and modify 
the hand, deck and pile so that it can be run from the stack. Also to create a file that makes the main 
function run independently. The game starts with a deck of 52 cards and between two players runs the game 
either until they run out of cards or when the deck ends the player that has less points wins.

How to run the program:
In the terminal first compile all files by putting javac *.java
Then run java proj2 to begin the game

The files created:
Mystack:
Contains the push, pop, getSize, top, isEmpty and a main. The stack is created using an arrayList.

proj2:
Has the main from Table.java

The files modified:
Deck:
Almost all functions were modified so that it can be used for the stack.

Hand:
The functions that were added are remove cards but for its parameters are objects and a getArray so that it can 
read the array that are stored in the stack.

Pile:
It was created using deck.java as base but uses Mystack to run.

Table:
In the actionPerformed function it was modified so that it can get the results from both players.
