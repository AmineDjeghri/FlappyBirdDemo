/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amined.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author AmineD
 */
public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime; //how long a frame stays before we switch to the next one
    private float currentFrameTime; //the time that the animation has been in the current frame
    private int frameCount; //number of frames
    private int frame; //the nimber of frame we're actually in

    public Animation(TextureRegion region, int frameCount,float cycleTime) {
        frames =new Array<TextureRegion>();
        int frameWidth =region.getRegionWidth()/frameCount;
        
        for(int i=0;i<frameCount;i++){
            frames.add(new TextureRegion(region, i*frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        
        this.frameCount=frameCount;
        maxFrameTime=cycleTime/frameCount;
        frame=0;
    }
    
    public void update(float dt){
        currentFrameTime+=dt;
        if(currentFrameTime>maxFrameTime){
            frame++;
            currentFrameTime=0;
        }
        if(frame>=frameCount)
            frame=0;
    }
    
    public TextureRegion getFrame(){
        return frames.get(frame);
    }
    
}
