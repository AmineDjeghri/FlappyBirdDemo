/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amined.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
/**
 *
 * @author AmineD
 */
public abstract class State {

    
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }
    
    protected abstract void handleInput();
    public abstract void update(float dt);  //dt=detlta time
    public abstract void render (SpriteBatch sb);
    public abstract void dispose();
}
