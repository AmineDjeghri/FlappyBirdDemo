/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amined.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author AmineD
 */
public class Bird {
    private static final int GRAVITY=-15;
    private static final int MOUVEMENT=100;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Animation birdAnimation;
    
    
    private Texture texture;
    
    public Bird(int x, int y){
        position =new Vector3(x, y, 0);
        velocity=new Vector3(0, 0, 0); //not moving
        texture =new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture),3, 0.3f);
        bounds = new Rectangle(x, y, texture.getWidth()/3, texture.getDepth());
    }
    
    public void jump(){
        velocity.y=250;
    }
    
    public void update(float dt){
        birdAnimation.update(dt);
        if(position.y>0)
        velocity.add(0,GRAVITY, 0); //adding gravity to the Y axis
        velocity.scl(dt);
        position.add(MOUVEMENT*dt,velocity.y,0);
        
        if(position.y<0)
           position.y=0;
        
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public Rectangle getBounds(){
        return bounds;
    }
    
    public void dispose(){
        texture.dispose();
    }
}
