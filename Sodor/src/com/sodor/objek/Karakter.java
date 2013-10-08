package com.sodor.objek;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Karakter extends Game{
	int FRAME_COLS;
	int FRAME_ROWS;
	
	public Animation animation; 
	public Texture Sheet;
	TextureRegion[] Frames;
	TextureRegion currentFrame;
	SpriteBatch batch;
	float stateTime;
	
	
}
