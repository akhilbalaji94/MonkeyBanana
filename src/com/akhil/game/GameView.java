package com.akhil.game;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class GameView extends JComponent {
	private static final long serialVersionUID = 1L;
	private BaseState state;
	private Timer timer;
	private int count;

	public GameView() {
		this.addKeyListener(new KeyHandler());
		this.setFocusable(true);
		this.transferFocus();
	}
	
	public int getCount() {
		return count;
	}
	
	public void setState(BaseState state) {
		this.state = state;
		this.repaint();
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	class KeyHandler extends KeyAdapter {
		public void keyPressed(KeyEvent event) {
			state.handleKeyPressed(event.getKeyCode());
		}
	}
	class TimerHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            state.clocktick();
            repaint();
        }
    }
	public void startTimer(int milliseconds) {
		timer = new Timer(milliseconds,new TimerHandler());
		timer.start();
	}

	public void stopTimer() {
		this.timer.stop();
	}

	public void paintComponent(Graphics g) {
		state.drawOn(g);
	}

}
