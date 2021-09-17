package com.akhil.game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class SuccessState extends BaseState
{
	private Monkey successmonkey;
    public SuccessState(GameView view)
    {
        super(view);
        Image monkeyimage = new ImageIcon(this.getClass().getResource("/resources/success.png")).getImage();
		this.successmonkey = new Monkey(138, 138);
		this.successmonkey.setImage(monkeyimage);
		this.successmonkey.setPosition(300,400);
		
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
        g.drawString("SUCCESS! Press ESC to exit", 250, 380);
        this.successmonkey.drawOn(g);
        
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