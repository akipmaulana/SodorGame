package com.sodor.jagoan;

import com.akirah.sodor.Karakter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Pemuda extends Karakter{

	public Rectangle rectangle;
	Texture bg;
	Texture ReverseSheet;
	TextureRegion[] FramesReverse;
	TextureRegion currentFrameR;
	Animation animationR;
	boolean isLeft=false;//cek hadap kanan atau kiri
	
	TextureRegion[][] tmp;
	TextureRegion[][] tmp_reverse;

	public Pemuda() {
		// TODO Auto-generated constructor stub
		this.FRAME_COLS=6;
		this.FRAME_ROWS=5;
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		Sheet = new Texture(Gdx.files.internal("jagoan/animation_sheet.png"));
		ReverseSheet = new Texture(Gdx.files.internal("jagoan/animation_sheet_reverse.png"));
		tmp = TextureRegion.split(this.Sheet, this.Sheet.getWidth()/this.FRAME_COLS, this.Sheet.getHeight()/this.FRAME_ROWS);
		tmp_reverse = TextureRegion.split(this.ReverseSheet, this.ReverseSheet.getWidth()/this.FRAME_COLS, this.ReverseSheet.getHeight()/this.FRAME_ROWS);
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
		animation = new Animation(0.025f, Frames);
		animationR = new Animation(0.025f, FramesReverse);
		batch = new SpriteBatch();
		bg = new Texture(Gdx.files.internal("bg.jpg"));
		
		stateTime = 0f;
		rectangle = new Rectangle();
		rectangle.x = 800 / 2 - 86 / 2; // center the bucket horizontally
        rectangle.y = 20; // bottom left corner of the bucket is 20 pixels above
                                        // the bottom screen edge
        rectangle.width = 86;
        rectangle.height = 102;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		currentFrameR = animationR.getKeyFrame(stateTime, true);
		batch.begin();
			batch.draw(bg, 0, 0);
			draw();
		batch.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		batch.dispose();
		Sheet.dispose();
		bg.dispose();
		ReverseSheet.dispose();
	}
	
	private void draw() {
		// TODO Auto-generated method stub
		update();
	}
	
	private void update() {
		// TODO Auto-generated method stub
		
		if(isLeft){
			batch.draw(currentFrameR, rectangle.x, rectangle.y);
		}else{
			batch.draw(currentFrame, rectangle.x, rectangle.y);
		}
		if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            rectangle.x = touchPos.x - 86 / 2;
	    }
	    if (Gdx.input.isKeyPressed(Keys.LEFT)){
	    	rectangle.x -= 150 * Gdx.graphics.getDeltaTime();
	        batch.draw(currentFrameR, rectangle.x, rectangle.y);
	        isLeft = true;
	    }else if (Gdx.input.isKeyPressed(Keys.RIGHT)){
	        rectangle.x += 150 * Gdx.graphics.getDeltaTime();
	        batch.draw(currentFrame, rectangle.x, rectangle.y);
	        isLeft = false;
	    }
	    if (Gdx.input.isKeyPressed(Keys.DOWN)){
            rectangle.y -= 75 * Gdx.graphics.getDeltaTime();
	    }
	    if (Gdx.input.isKeyPressed(Keys.UP)){
	    	rectangle.y += 75 * Gdx.graphics.getDeltaTime();
	    }
	    if (rectangle.x < 0)
	        rectangle.x = 0;
		if (rectangle.x > 800 - 86)
	        rectangle.x = 800 - 86;
		if (rectangle.y < 0)
	        rectangle.y = 0;
		if (rectangle.y > 480 - 102)
	        rectangle.y = 480 - 102;
		
	    
	}
	
}
