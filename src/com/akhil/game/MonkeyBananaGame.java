package com.akhil.game;

import java.awt.*;
import javax.swing.*;

public class MonkeyBananaGame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MonkeyBananaGame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(50, 50);
		this.setResizable(false);
		this.setSize(757, 795);
		this.setTitle("Monkey Banana Game");
		GameView view = new GameView();
		view.setState(new StartState(view));
		this.add(view, BorderLayout.CENTER);
		this.setVisible(true);

	} 

	public static void main(String[] args) {
		new MonkeyBananaGame();
	}
}
