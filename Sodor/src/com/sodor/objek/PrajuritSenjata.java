package com.sodor.objek;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class PrajuritSenjata extends Karakter{

	Rectangle prajurit;
	Texture ReverseSheet;
	TextureRegion[] FramesReverse;
	TextureRegion currentFrameR;
	Animation animationR;
	boolean isLeft=false;
	
	public PrajuritSenjata() {
		// TODO Auto-generated constructor stub
		FRAME_COLS=9;
		FRAME_ROWS=2;
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		Sheet = new Texture(Gdx.files.internal("prajurit_senjata.png"));
		ReverseSheet = new Texture(Gdx.files.internal("prajurit_senjata_reverse.png"));
		TextureRegion[][] tmp = TextureRegion.split(Sheet, Sheet.getWidth()/FRAME_COLS, Sheet.getHeight()/FRAME_ROWS);
		TextureRegion[][] tmp_reverse = TextureRegion.split(ReverseSheet, ReverseSheet.getWidth()/FRAME_COLS, ReverseSheet.getHeight()/FRAME_ROWS);
		Frames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
		FramesReverse = new TextureRegion[FRAME_COLS*FRAME_ROWS];
		int index=0;
		for(int i=0;i<FRAME_ROWS;i++){
			for(int j=0;j<FRAME_COLS;j++){
				Frames[index++]=tmp[i][j];
			}
		}
		//Reverse
		int indexR=0;
		for(int i=0;i<FRAME_ROWS;i++){
			for(int j=FRAME_COLS-1;j>=0;j--){
				FramesReverse[indexR++]=tmp_reverse[i][j];
			}
		}		
		animation = new Animation(0.2f, Frames);
		animationR = new Animation(0.2f, FramesReverse);
		batch = new SpriteBatch();
		stateTime = 0f;
		prajurit = new Rectangle();
		prajurit.x=100;
		prajurit.y=100;
		prajurit.width=42;
		prajurit.height=41;
//		peluru = new Peluru((int)prajurit.x+(int)prajurit.width, (int)prajurit.y+(int)(prajurit.height/2));
		
		
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		currentFrameR = animationR.getKeyFrame(stateTime, true);
		batch.begin();
			draw();
//			font.draw(batch, "State Time : "+ (int)stateTime, 500, 500);
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
		batch.draw(currentFrame, prajurit.x, prajurit.y);
		update();
	}
	
	public void update() {
		// TODO Auto-generated method stub
		if((int)stateTime!=1.1)
			prajurit.x+=0.5;
	    if (prajurit.x < 0)
	        prajurit.x = 0;
		if (prajurit.x > 800 - 86)
	        prajurit.x = 800 - 86;
		if (prajurit.y < 0)
	        prajurit.y = 0;
		if (prajurit.y > 480 - 102)
	        prajurit.y = 480 - 102;

		
		
		
		
	}
	
	
	
}
