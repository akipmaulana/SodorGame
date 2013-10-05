package com.sodor.objek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bayi extends Karakter{

	public Bayi() {
		// TODO Auto-generated constructor stub
		FRAME_COLS=4;
		FRAME_ROWS=4;
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		Sheet = new Texture(Gdx.files.internal("bocah.png"));
		TextureRegion[][] tmp = TextureRegion.split(Sheet, Sheet.getWidth()/FRAME_COLS, Sheet.getHeight()/FRAME_ROWS);
		Frames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
		int index=0;
		for(int i=0;i<FRAME_ROWS;i++){
			for(int j=0;j<FRAME_COLS;j++){
				Frames[index++]=tmp[i][j];
			}
		}
		animation = new Animation(0.25f, Frames);
		batch = new SpriteBatch();
		stateTime = 0f;
		
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		batch.begin();
			draw();
		batch.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		batch.dispose();
		Sheet.dispose();
	}
	
	private void draw() {
		// TODO Auto-generated method stub
		batch.draw(currentFrame, 100, 100);

	}
	
	
	
}
