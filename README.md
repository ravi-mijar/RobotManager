README.md

How to build the source code:
The app is built using Maven as the build tool. 
- Goto the root directory of the app, open a command prompt / terminal and fire 'mvn -e clean install'
-------------------------------
How to run the app:
Run the test cases:
mvn -e clean install test

-------------------------------
Design considerations:
1) I applied object oriented design practices to the problem and identified the main objects involved, and the kind of operations / properties they had.
2) ToyRobot became one class. Instead of storing the position and orientation in different objects, I put them together in the Position object as it made more sense.
3) Move, Place, Rotate(left/right) were classified as operations on the robot having a dependency on the shape the robot is on. So they became methods.
4) The problem spoke about a square shaped table. I extrapolated this a bit, and thought of some scenarios where this could be extended. So, I made it a bit generic and created the IShape interface and put some methods in it. So, the SquareTable implements the IShape interface and defines what would be out of bounds in that shape, and what move would likely make the robot fall off. This will be specific for each shape, so it needs to be implemented by each shape.
5) Orientation and RotateDirection were identified as type of constants with specific values. So they became enums. For Orientation, I found a good way to implement the rotation operation. By creating enum methods, I was able to turn the robot depending on whichever direction it was facing.
6) Added a logger to the code.