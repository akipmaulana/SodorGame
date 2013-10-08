package com.sodor.mobil;

import com.akirah.sodor.Karakter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Mobil extends Karakter{
	
	TextureRegion[][] tmp;
	TextureRegion[][] tmp_reverse;
	public Rectangle rectangle;
	boolean isReverse;

	public Mobil(Texture texture, boolean isReverese) {
		// TODO Auto-generated constructor stub
		this.FRAME_COLS=4;
		this.FRAME_ROWS=1;
		this.isReverse=isReverese;
		Sheet = texture;//new Texture(Gdx.files.internal("mobil_belanda.png"));
		tmp = TextureRegion.split(this.Sheet, this.Sheet.getWidth()/this.FRAME_COLS, this.Sheet.getHeight()/this.FRAME_ROWS);
		Frames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
		int index=0;
		if(this.isReverse){
			for(int i=0;i<FRAME_ROWS;i++){
				for(int j=FRAME_COLS-1;j>=0;j--){
					Frames[index++]=tmp[i][j];
				}
			}
		}else{
			for(int i=0;i<FRAME_ROWS;i++){
				for(int j=0;j<FRAME_COLS;j++){
					Frames[index++]=tmp[i][j];
				}
			}
		}
		
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
		animation = new Animation(0.025f, Frames);
		batch = new SpriteBatch();
		stateTime = 0f;
		checkReverse();
	}
	
	protected void checkReverse() {
		// TODO Auto-generated method stub
		rectangle = new Rectangle();
		rectangle.width = 104;
	    rectangle.height = 56;
		if(isReverse){
			rectangle.x = 800; 
	        rectangle.y = 200;
		}else{
			rectangle.x = 0; 
	        rectangle.y = 200;
		}
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
	
	protected void draw() {
		// TODO Auto-generated method stub
		batch.draw(currentFrame, rectangle.x, rectangle.y);
		update();

	}
	
	protected void update() {
		// TODO Auto-generated method stub
		if(isReverse){
			rectangle.x-=2;
		}else{
			rectangle.x+=2;
		}
		
		if (rectangle.x < -104)//jika lebih kurang dari -25 blik ke 800
	        rectangle.x = 800;
		if (rectangle.x > 800)
	        rectangle.x = 0;
		if (rectangle.y < 0)
	        rectangle.y = 480;
		if (rectangle.y > 480)
	        rectangle.y = 0;
		
		
	}


}
