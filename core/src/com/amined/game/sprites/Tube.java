/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amined.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 *
 * @author AmineD
 */
public class Tube {
    public static final int TUBE_WIDTH=52;
    
    private static final int FLUCTUATION=130; //between 0 and 130
    private static final int TUBE_GAP=100;  //difference between the oppenings 
    private static final int LOWEST_OPENING=100;
    
    private Texture topTube,bottomTube;
    private Vector2 posTopTube,posBotTube;
    private Rectangle boundsTop,boundsBot;
    private Random rand;
    
    
    public Tube(float x) {
        topTube=new Texture("toptube.png");
        bottomTube=new Texture("bottomtube.png");
        rand=new Random();
    
        posTopTube=new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube=new Vector2(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        
        boundsTop=new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot= new Rectangle(posBotTube.x,posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());
        
    }
    
    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
    }
    
    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop)||player.overlaps(boundsBot);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }
    
    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
    
}
