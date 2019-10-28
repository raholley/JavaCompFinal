# This was the final project for my Java comprehensive class using Multi-threading

## Final Project: Marathon race runners

**User Story:**  A sports company has hired you to write an application that would simulate a
marathon race between interesting groups of participants. They could be slow as a tortoise, as
fast as a hare, and anything in between. The runners differ in their speed and how often they need
to rest. Some may be slow and never rest; others may run fast but lose steam quickly and rest a
lot of the time. Still others could be anything in between.

**Example operation between two runners: A Tortoise and a Hare** 

• Say in this case, there are only two runners. The runners differ in their speed and how often
they need to rest. One of the runners, named “Tortoise,” is slow but never rests. The other
runner, named “Hare,” is ten times as fast but rests 90% of the time.

• There is a random element to the runners’ performance, so the outcome of the race is
different each time the application is run.

• The race is run over a course of 1000 meters. Each time one of the runners move, the
application display the runner’s new position on the course. The first runner to reach 1000
wins the race.

• When one of the runners finishes the race, the application declares that runner to be the
winner and the other runner concedes.

**Example specifications for N runners**  (this gives you lot of hints; however, you
are encouraged to come up with your own innovative design)

• Each runner should be implemented as a separate thread using a class named ThreadRunner.
The ThreadRunner class should include a constructor that accepts three parameters: a string
representing the name of the runner, an int value from 1 to 100 indicating the likelihood that
on any given move the runner will rest instead of run, and an int value that indicates the
runners speed—that is, how many meters the runner travels in each move.

• Each runner has following information:

RunnersName        
Tortoise        
Hare
Dog
Cat              
RunnersSpeed
10
100
50
30
RestPercentage
0
90
40
75
The program accommodates N number of runners.
• You will read the above runners information from an input source.

• The run method of the ThreadRunner class should consist of a loop that repeats until the
runner has reached 1000 meters. Each time through the loop, the thread should decide
whether it should run or rest based on a random number and the percentage passed to the
constructor (RestPercentage). If this random number indicates that the runner should run, the
class should add the speed value passed to the constructor (RunnersSpeed). The run method
should sleep for 100 milliseconds on each repetition of the loop.

• To determine whether a thread should run or rest, calculate a random number between 1 and
100. Then, have the thread rest if the number is less than or equal to the percentage of time
that the thread rests (RestPercentage). Otherwise, the thread should run.• If the run method is interrupted, it should display a message that concedes the race and quits.

• The main method of the application’s main class should create as many runner threads as are
read from the input source and start all of them. You will pass all the information read from
input source into the threads through constructor. Use RunnersName to be name of the
thread.

• This class should also include a method named finished that one of the threads can call when
it finishes the race. That method should declare the thread that calls it to be the winner and
should interrupt the other thread so it can concede the race.

• The finished method should provide for the possibility that the two or more threads will finish
the race at almost the same time. If that happens, it should ensure that only one of the threads
is declared the winner. (There are no ties!)

• The finished method in the main application class will need to know which thread called it.
**Part of the console example for default two runners.** 

Start and end of the race between a Tortoise and a Hare

**Welcome to the Marathon Race Runner Program**

Select your data source:
1. Derby database
2. XML file
3. Text file
4. Default two runners
5. Exit
Enter your choice: 2
Enter XML file name: FinalXMLData.xml

....
<program will run for however many runners are in FinalXMLData.xml file>
<The menu repeats after the conclusion and gives the choice again>
<User can select menu 1 to 4 to run the marathon, or 5 to quit>
<Second run might look like this:>
...
Dog : 1000
Dog : I finished!
The race is over! The Dog is the winner.
Hare: You beat me fair and square.
Rabbit: You beat me fair and square.
Cat: You beat me fair and square.
Press any key to continue . . .
