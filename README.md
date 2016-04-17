README.md
-------------------------------
How to run the app:
1) Extract the tar.gz file, and execute the shell script run-robot-manager.sh. If you're on windows, just rename the file to .bat and run it.
2) The app uses Cliche, an open source command parsing library. It generates a shell like environment and we can run commands one after the other in the same JVM. Run '?--list-all' to list all the commands. '?l' will list commands of our app alone. To see help of a particular command try '?h <command-name>'.
For eg - 
RobotPrompt> ?l
abbrev  name    params
l       left    ()
r       right   ()
pl      place   (x, y, facing)
mv      move    ()
re      report  ()

OR

RobotPrompt> ?h pl
Command: place
Abbrev:  pl
Params:  (x, y, facing)
Description: This command places the robot on the playfield in a particular position and orientation. Placements outside the playfield are ignored.
Number of parameters: 3
x       int     X coordinate of robot's position. (0-4)
y       int     Y coordinate of robot's position. (0-4)
facing  String  Direction the robot should face. (NORTH, SOUTH, EAST, WEST)

-------------------------------

How to build the source code:
The app is built using Maven as the build tool. 
1) Goto the root directory of the app, open a command prompt / terminal and fire 'mvn -e clean install -DskipTests=true'
2) This will generate the '*jar-with-dependencies.jar' file in the 'target' folder. Run that jar file as an executable.


-------------------------------
Design considerations:
1) I applied object oriented design practices to the problem and identified the main objects involved, and the kind of operations / properties they had.
2) ToyRobot became one class. Instead of storing the position and orientation in different objects, I put them together in the Position object as it made more sense.
3) Move, Place, Rotate(left/right) were classified as operations, and I found some common aspects between them. So, the IOperation interface was born.
4) The problem spoke about a square shaped table. I extrapolated this a bit, and thought of some scenarios where this could be extended. So, I made it a bit generic and created the IShape interface and put some methods in it. So, the SquareTable implements the IShape interface and defines what would be out of bounds in that shape, and what move would likely make the robot fall off. This will be specific for each shape, so it needs to be implemented by each shape.
5) Orientation and RotateDirection were identified as type of constants with specific values. So they became enums. For Orientation, I found a good way to implement the rotation operation. By creating enum methods, I was able to turn the robot depending on whichever direction it was facing.
6) Added a logger to the code, and created a CLI for the app. 


-------------------------------
Credits:
1) Cliche - An open source library for command line parsing. https://code.google.com/archive/p/cliche/