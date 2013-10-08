package com.akirah.sodor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Karakter extends Game{
	public int FRAME_COLS;
	public int FRAME_ROWS;
	
	public Animation animation; 
	public Texture Sheet;
	public TextureRegion[] Frames;
	public TextureRegion currentFrame;
	public SpriteBatch batch;
	public float stateTime;
	
	
}
