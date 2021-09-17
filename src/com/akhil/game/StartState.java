package com.akhil.game;

import java.awt.*;
import java.awt.event.*;

public class StartState extends BaseState {
	
	private int refreshrate = 15; //60 FPS i.e 15ms 
	
	public StartState(GameView view) {
		super(view);
	}

	public void drawOn(Graphics g) {
		Rectangle bounds = this.getView().getBounds();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, bounds.width, bounds.height);
		Color darkgreen = new Color(0, 128, 0);
		g.setColor(darkgreen);
		Font font = new Font("Sans-Serif", Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Press SPACE to start game!", 220, 350);
	}

	public void handleKeyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_SPACE:
			System.out.println("Game Started");
			this.getView().startTimer(refreshrate);
			this.getView().setState(new PlayState(this.getView()));
        }

	}
}
