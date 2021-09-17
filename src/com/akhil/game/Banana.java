package com.akhil.game;

import java.awt.*;

public class Banana
{
    private Image image;
    private Rectangle rect;
    
    public Banana()
    {
        this.image = null;
        this.rect = new Rectangle(0, 0, 15, 15);
    }
    
    public void setImage(Image image)
    {
        this.image = image;
    }
    
    public void setPosition(int x, int y)
    {
        this.rect.x = x;
        this.rect.y = y;
    }
    
    public Rectangle getRect()
    {
        return this.rect;
    }

    public int getX()
    {
        return this.rect.x;
    }
    
    public int getY()
    {
        return this.rect.y;
    }

    public int getWidth()
    {
        return this.rect.width;
    }
    
    public int getHeight()
    {
        return this.rect.height;
    }
    
    
    public void drawOn(Graphics g)
    {
        g.drawImage(this.image, this.rect.x, this.rect.y, this.rect.width, this.rect.height, null);
    }
    
}