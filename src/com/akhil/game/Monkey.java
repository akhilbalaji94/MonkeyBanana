package com.akhil.game;

import java.awt.*;

public class Monkey {
	private Image image;
	private Rectangle rect;

	public Monkey(int blk_x, int blk_y) {
		this.image = null;
		this.rect = new Rectangle(0, 0, blk_x, blk_y);
	}

	public Rectangle getRect() {
		return this.rect;
	}

	public int getX() {
		return this.rect.x;
	}

	public int getY() {
		return this.rect.y;
	}

	public int getWidth() {
		return this.rect.width;
	}

	public int getHeight() {
		return this.rect.height;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setPosition(int x, int y) {
		this.rect.x = x;
		this.rect.y = y;
	}

	public void moveUp() {
		System.out.println("Moving up");
		this.setPosition(this.rect.x,this.rect.y - 15);
		System.out.println("(" + this.rect.x + "," + this.rect.y + ")");
	}

	public void moveDown() {
		System.out.println("Moving down");
		this.setPosition(this.rect.x,this.rect.y + 15);
		System.out.println("(" + this.rect.x + "," + this.rect.y + ")");
	}

	public void moveLeft() {
		System.out.println("Moving left");
		this.setPosition(this.rect.x - 15,this.rect.y);
		System.out.println("(" + this.rect.x + "," + this.rect.y + ")");
	}

	public void moveRight() {
		System.out.println("Moving right");
		this.setPosition(this.rect.x + 15,this.rect.y);
		System.out.println("(" + this.rect.x + "," + this.rect.y + ")");
	}

	public void drawOn(Graphics g) {
		g.drawImage(this.image, this.rect.x, this.rect.y, this.rect.width, this.rect.height, null);
	}

}
