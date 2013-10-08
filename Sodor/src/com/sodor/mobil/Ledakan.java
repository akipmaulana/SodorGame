package com.sodor.mobil;

import com.akirah.sodor.Karakter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Ledakan extends Karakter {

	Rectangle ledakan;
	float w,h,speedX1,speedY1;
	int x,y;
	
	public Ledakan(int x, int y) {
		// TODO Auto-generated constructor stub
		FRAME_COLS=5;
		FRAME_ROWS=4;
		this.x=x;
		this.y=y;
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		Sheet = new Texture(Gdx.files.internal("mobil/ledakan.png"));
		TextureRegion[][] tmp = TextureRegion.split(this.Sheet, this.Sheet.getWidth()/this.FRAME_COLS, this.Sheet.getHeight()/this.FRAME_ROWS);
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
		ledakan = new Rectangle();
		ledakan.width=113;
		ledakan.height=110;
		ledakan.x=x;
		ledakan.y=y;
		
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, false);
		batch.begin();
			batch.draw(currentFrame, ledakan.x, ledakan.y);
		batch.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		batch.dispose();
		Sheet.dispose();
	}

}
