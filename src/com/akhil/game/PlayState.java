package com.akhil.game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

public class PlayState extends BaseState {
	private Monkey player;
	private Banana banana;
	private int time = 60;
	private int bananaTime = 10;
	private int tick = 0;
	private int K = 10;
	private int blockx = 15;
	private int blocky = 15;
	private int N = 50;
	private Random random = new Random();

	public PlayState(GameView view) {
		super(view);
		this.getView().setCount(0);
		Image monkeyimage = new ImageIcon(this.getClass().getResource("/resources/front.png")).getImage();
		this.player = new Monkey(blockx, blocky);
		this.player.setImage(monkeyimage);
		this.player.setPosition(random.nextInt(N) * blockx, random.nextInt(N) * blocky);

		Image bananaimage = new ImageIcon(this.getClass().getResource("/resources/banana.png")).getImage();
		this.banana = new Banana();
		this.banana.setImage(bananaimage);
		this.banana.setPosition(random.nextInt(N) * blockx, random.nextInt(N) * blockx);

	}

	public void drawOn(Graphics g) {
		Rectangle bounds = this.getView().getBounds();
		Color darkgreen = new Color(0, 128, 0);
		g.setColor(darkgreen);
		g.fillRect(0, 0, bounds.width, bounds.height);
		g.setColor(Color.WHITE);
		Font font = new Font("Sans-Serif", Font.BOLD, 15);
		g.setFont(font);
		this.player.drawOn(g);
		this.banana.drawOn(g);
		g.drawString("Score: " + this.getView().getCount(), 0, 20);
		g.drawString("Time: " + time, 0, 40);
		g.drawString("BananaTime: " + bananaTime, 0, 60);
	}

	public void clocktick() {

		if (this.player.getRect().intersects(this.banana.getRect())) {
			this.getView().setCount(this.getView().getCount() + 1);
			bananaTime = 10;
			System.out.println("Score: " + this.getView().getCount());
			this.banana.setPosition(random.nextInt(N) * blockx, random.nextInt(N) * blockx);
		}
		if (bananaTime == 0) {
			bananaTime = 10;
			this.banana.setPosition(random.nextInt(N) * blockx, random.nextInt(N) * blockx);
		}
		if (this.getView().getCount() == K) {
			this.getView().stopTimer();
			this.getView().setState(new SuccessState(this.getView()));
		}

		if (time == 0) {
			this.getView().stopTimer();
			if (this.getView().getCount() == K)
				this.getView().setState(new SuccessState(this.getView()));
			else
				this.getView().setState(new FailureState(this.getView()));
		}

		if (tick % 60 == 0) {
			time--;
			bananaTime--;
		}
		tick++;
	}

	public void handleKeyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			this.player.setImage(new ImageIcon(this.getClass().getResource("/resources/back.png")).getImage());
			if (player.getY() > 0)
				player.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			this.player.setImage(new ImageIcon(this.getClass().getResource("/resources/front.png")).getImage());
			if (player.getY() < 735)
				player.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			this.player.setImage(new ImageIcon(this.getClass().getResource("/resources/left.png")).getImage());
			if (player.getX() > 0)
				player.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.player.setImage(new ImageIcon(this.getClass().getResource("/resources/right.png")).getImage());
			if (player.getX() < 735)
				player.moveRight();
			break;
		}
	}

}
