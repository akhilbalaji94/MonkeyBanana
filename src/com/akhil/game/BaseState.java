package com.akhil.game;

import java.awt.*;

public class BaseState {
	private GameView view;

	public BaseState(GameView view) {
		this.view = view;
	}

	public GameView getView() {
		return this.view;
	}

	public void handleKeyPressed(int keyCode) {
	}

	public void clocktick() {
	}

	public void drawOn(Graphics g) {
	}

}
