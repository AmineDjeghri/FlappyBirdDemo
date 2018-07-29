/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amined.game.states;

import com.amined.game.FlappyDemo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author AmineD
 */
public class MenuState extends State{
    
    private Texture background;
    private Texture playBtn;
    

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("bg.png");
        playBtn=new Texture("playBtn.png");
    }
    

    @Override
    public void handleInput() {
       if(Gdx.input.justTouched()){
           gsm.set(new PlayState(gsm));
           
       }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0,FlappyDemo.WIDTH,FlappyDemo.HEIGHT);
        sb.draw(playBtn,(FlappyDemo.WIDTH/2)-(playBtn.getWidth()/2),FlappyDemo.HEIGHT/2);
        sb.end();
    }
    
    @Override
    public void dispose(){
        background.dispose();
        playBtn.dispose();
        
        System.out.println("MenuState disposed");
    }
}
