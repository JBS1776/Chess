# Chess project Sommers

A fun summer project I have been working on in my spare time.  Every piece currently moves as intended in a real game of Chess with the exception of checking whether or not moving the piece towards a given position will result in their King being placed in check. Running it is only a matter of compiling the Game.java file. The interface will subsequently appear with each of the 32 black and white chess pieces appearing on it.  </br>
</br>
If you are compiling this with eclipse, move the sprites folder from Chess/src to Chess.  Placing the sprites folder in the wrong place will result in the pieces being invisible with the rest of the interface features being fully operational.</br>
As of the December 2018 update to this game, most of the menu features are fully functional.  Saving a game from the menu bar is not available yet.  This will be fixed in a later update.</br>
Core gameplay with regular and take-me chess work properly.  The settings let you choose which mode of chess you wish to play.  </br>
This app won't allow you to make any illegal moves.  Pieces won't be allowed to move where they cannot move.  For instance, assuming you are playing regular chess, you won't be allowed to make a move that will put or keep your King in check.</br>  In take-me chess, capturing an opponent's piece, when possible, is required.  Like all other pieces, the King can be captured in take-me chess.  The king can also be promoted to in take-me chess.

# Update September 6 2022

Finally got around to updating this again!  I added support for custom sprite pieces.  It allows you to choose a directory and then load custom sprites for the pieces allowing the user to choose their own style of pieces rather than just using the default styles.  Your chosen file structure must have the filenames of WhiteKing.png, WhiteQueen.png, WhitePawn.png, WhiteBishop.png, WhiteKnight.png, WhiteRook.png, BlackKing.png, BlackQueen.png, BlackBishop.png, BlackKnight.png, BlackRook.png and BlackPawn.png.  This turned out to be not too difficult to implement but there is a strange glitch where if I'm running this feature from the .jar file on my Mac, the file chooser won't be able to access the Downloads, Documents or Desktop folders.  They show as empty if you try to click on them as if there is nothing at all in them.  This works find on my Linux machine when compiled to a .jar and I'm even able to use it just fine on eclipse so I'm not sure what is causing that.  I'll have to look into this at some moment.  I'll also see if I can make this feature easier for the user to perform but this might require me to make some fundamental changes to the code in how pieces are able to be seen by the game.

# Update March 15 2021

Included a hard level AI that will capture a piece when it can (and isn't enpassant capture) and otherwise performs a random move.  
More difficult AIs will be worked on in future updates.

# Update March 7 2021

Fixed the minimized popup issue described in the previous update
Corrected issues with take me chess mode where tiles won't properly highlight when deselected and need to caputure a piece

# Update Februrary 28 2021

Corrected a bug that takes place during Computer vs. Computer mode where a promoted piece didn't register properly.
This bug caused the opponent's king to not be put in check when it needed to be put in check in certain situations.
There also still exists a bug during Computer vs. Computer mode where a minimized popup will occur during promotion.
It doesn't seem to affect gameplay at all according to my test cases but it's still an unnecessary task that should be removed.
I should hopefully have this corrected in the next update.

# Update February 2021

Modified the project so a .jar file can be output.  The jar file reflects the latest version of this app and should function as intended upon running it.  I also corrected a bug that gave team Black an extra queen at the start of the game.

# Update September 2020

I uploaded a few changes to the game.  I corrected an issue where multiple game windows can open at once.  The main window can't be used when a settings window or the graveyard is open.  The time setting for time-enabled games also wasn't working correctly with the AI enabled.  I fixed the faulty boolean logic in the preceding if statements that control this function.  During this update, I also removed the TileButton class from this part of the project as this was largely a duplicate of the Tile class.  Removing this class not only reduced a large number of lines of code but it also seems to have made the game a little smoother.  The TileButton class will still exist in the repo. as a backup in case I need it for whatever reason.  The timer will still go down if you are viewing the graveyard or other option window.  This feature will be kept to prevent the player from freezing the timer to stall for time.

In future updates, I plan on seeing what other pieces of code I can reduce.  This is important as the code should be as simple as possible so I can include algorithms for a more difficult AI, include a resizeable game, etc.

As of this update the project (.java) files contain a cumulative 5,285 lines, 22 classes (counting inner or private classes) in 18 files and 3 piece styles(regular, classic, mario)

# Update as of April 2020

After a long time away from this project, I thought I'd update it with extra features.  </br> The game now reliably keeps track of the movements made by both players, contains a graveyard so you can view captured pieces, the ability to save a game so you can continue from where you left off.  I also implemented a dumb AI that you can activate from the settings.  Currently this AI can only make totally random moves.  When it's the AI's turn, they won't move until you click on any tile on the board after your move.  Of course if you set the AI to play itself, you'll need to click on any tile on the board to get them to make their move.  There is a setting to make the AI harder but it does not work yet.  I plan on updating this app further to make the AI more difficult to beat.  Another goal of mine is to see if I can trim the code so it has fewer lists or data structures to reduce memory usage as I may see about increasing the size of the board for the player's choosing.  There are many different types of chess out there and I may explore impementing more styles of chess besides suicide chess and regular chess.</br>

After weeks of head smashing, thousands of lines of code, and accounting for as many senarios as possible to prevent illegal moves from being made, I am proud of the progress I have made on this app.  I have dreamed of writing a Chess app ever since I started programming during my undergrad years and I'm ecstatic to live that dream everyday that I work on this.  The development process has taught me that if you keep going until it's done right, the results will be to your great satisfaction.  I challenged myself to implement every aspect of the project EXACTLY the way I desired no matter how many steps it took.  The exact same situation applies to the difficult times we are going through right now.  They will last a while but if we put our minds to getting through this, a brighter future will happen before we know it.  </br>

As of this update the project (.java) files contain a cumulative 6,069 lines, 21 classes (counting inner or private classes) in 19 files and 3 piece styles(regular, classic, mario)
