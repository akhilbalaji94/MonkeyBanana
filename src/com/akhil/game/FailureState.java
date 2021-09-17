package com.akhil.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class FailureState extends BaseState
{
	private Monkey failuremonkey;
    public FailureState(GameView view)
    {
        super(view);
        Image monkeyimage = new ImageIcon(this.getClass().getResource("/resources/failure.png")).getImage();
		this.failuremonkey = new Monkey(138, 138);
		this.failuremonkey.setImage(monkeyimage);
		this.failuremonkey.setPosition(300,400);
    }
    
    public void drawOn(Graphics g)
    {
        Rectangle bounds = this.getView().getBounds();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, bounds.width, bounds.height);
        Color darkgreen = new Color(0, 128, 0);
		g.setColor(darkgreen);
        Font font = new Font("Sans-Serif", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("SCORE: " +  this.getView().getCount(), 325,355);
        g.drawString("FAILURE! Press ESC to exit", 250, 380);
        this.failuremonkey.drawOn(g);
    }
            
    public void handleKeyPressed(int keyCode)
    {
    	switch (keyCode) {
		case KeyEvent.VK_ESCAPE:
	           System.exit(0);
	           break;
        }
    }
}