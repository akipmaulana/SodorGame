package com.sodor.objek;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Orang extends Game{

	private static final int FRAME_COLS=6;
	private static final int FRAME_ROWS=5;
	
	public Animation walkAnimation; 
	public Texture walkSheet;
	TextureRegion[] walkFrames;
	TextureRegion currentFrame;
	SpriteBatch batch;
	float stateTime;
	String aset;
	public Orang() {
		// TODO Auto-generated constructor stub
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		walkSheet = new Texture(Gdx.files.internal("animation_sheet.png"));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);
		walkFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
		int index=0;
		for(int i=0;i<FRAME_ROWS;i++){
			for(int j=0;j<FRAME_COLS;j++){
				walkFrames[index++]=tmp[i][j];
			}
		}
		walkAnimation = new Animation(0.025f, walkFrames);
		batch = new SpriteBatch();
		stateTime = 0f;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		batch.begin();
			draw();
		batch.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		batch.dispose();
		walkSheet.dispose();
		
	}
	
	private void draw() {
		// TODO Auto-generated method stub
		batch.draw(currentFrame, 50, 50);
	}

}
