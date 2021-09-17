# MonkeyBanana
Swing based game made using JAVA. Have fun!

Design : 
The game uses a timer, keyboard input and makes use of a state design pattern. The game timer redraws every 15ms for smooth gameplay and the keyboard input consists of SPACE, ESC, UP, DOWN, LEFT and RIGHT. The state design pattern for the game consists of four states:  the START STATE, the PLAY STATE, THE SUCCESS STATE and the FAILURE STATE. The game begins in the START STATE and transitions to the PLAY STATE on the SPACE keypress. The game remains in the PLAY STATE while timer < 60 and count < K. On the event when timer = 60 and count < K the game transitions to the FAILURE STATE while timer <= 60 and count =K results in the game transitioning to the SUCCESS STATE. The game then exits from SUCCESS STATE or FAILURE STATE on the ESC keypress.

Implementation: 
The MonkeyBananaGame class contains a JAVA Swing Jframe and initializing an instance of GameView. The GameView class extends JComponent and contains the TimerHandler, KeyHandler, count and paintComponent functionality. The TimerHandler implements ActionListener for keeping time and repainting, the KeyHandler extends KeyAdapter to handle keypresses, count keeps track of the users score and paintComponent draws onto the frame. 

In MonkeyBanana, GameView is initialized and state is set to an instance of StartState. All States have a parent class BaseState which abstracts the state functionality. StartState extends BaseState and waits for a SPACE keypress to transition to the PlayState by setting the GameView state to an instance of PlayState. 

Once in the PlayState, the background along with score, time and bananatime is drawn. An instance of the Monkey class and the banana class are drawn at random initial locations. The UP, DOWN, LEFT and RIGHT keypresses move the monkey location accordingly. Every timer tick, the monkey-banana intersection check is carried out and then scored if matched and bananatimer less than 10. The Banana is redrawn at a random location every 10 seconds. If the score reaches K before the timer reaches 60 seconds the GameView state is set to an instance of SuccessState, whereas if the timer reaches 60 second before the score reaches K then its state set to the FailureState.

Once in the SuccessState or FailureState, the final score is displayed along with a successmonkey or failuremonkey image respectively and waits for the ESC keypress to exit the game.
