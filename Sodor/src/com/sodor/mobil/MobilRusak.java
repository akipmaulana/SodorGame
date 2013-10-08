package com.sodor.mobil;

import com.akirah.sodor.Karakter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class MobilRusak extends Karakter{

	TextureRegion[][] tmp;
	TextureRegion[][] tmp_reverse;
	public Rectangle rectangle;
	int x,y;
	boolean isReverse, isExploide;
	Ledakan ledakan;
	
	
	public MobilRusak(Texture texture, boolean isReverese, int x, int y) {
		// TODO Auto-generated constructor stub
		this.FRAME_COLS=5;
		this.FRAME_ROWS=1;
		this.x=x;
		this.y=y;
		this.isReverse=isReverese;
		isExploide=false;
		Sheet = texture;//new Texture(Gdx.files.internal("mobil_belanda.png"));
		tmp = TextureRegion.split(this.Sheet, this.Sheet.getWidth()/this.FRAME_COLS, this.Sheet.getHeight()/this.FRAME_ROWS);
		Frames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
		int index=0;
		if(!this.isReverse){//dibalik
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
		ledakan = new Ledakan(x,y);
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		animation = new Animation(0.25f, Frames);
		batch = new SpriteBatch();
		stateTime = 0f;
		checkReverse();
	}
	
	protected void checkReverse() {
		// TODO Auto-generated method stub
		rectangle = new Rectangle();
		rectangle.width = 104;
	    rectangle.height = 53;
		if(isReverse){
			rectangle.x = x; 
	        rectangle.y = y;
		}else{
			rectangle.x = x; 
	        rectangle.y = y;
		}
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, false);
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
		ledakan.dispose();
	}
	
	protected void draw() {
		// TODO Auto-generated method stub
		if(isExploide){
			ledakan.render();
		}else{
			batch.draw(currentFrame, rectangle.x, rectangle.y);
		}
		
		update();

	}
	
	protected void update() {
		// TODO Auto-generated method stub
		//ledakan
		if(animation.isAnimationFinished(stateTime)){
			isExploide=true;
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
