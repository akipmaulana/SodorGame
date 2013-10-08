package com.sodor.objek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Peluru extends Karakter{

	// Sheet = peluruTExture
	public Vector2 position;
	public Rectangle peluru;
	float w,h,speedX1,speedY1;
	int x,y;
	
	public Peluru(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		Sheet = new Texture(Gdx.files.internal("peluru.png"));
		peluru = new Rectangle();
		peluru.width=3;
		peluru.height=3;
		peluru.x=x;
		peluru.y=y;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		batch.begin();
			batch.draw(Sheet, peluru.x, peluru.y);
		batch.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		batch.dispose();
		Sheet.dispose();
	}
	
	public void update(int x, int y) {
		// TODO Auto-generated method stub
		
			peluru.x+=0.5;
	    if (peluru.x < 0)
	        peluru.x = 0;
		if (peluru.x > 800 - 3)
	        peluru.x = 800 - 3;
		if (peluru.y < 0)
	        peluru.y = 0;
		if (peluru.y > 480 - 3)
	        peluru.y = 480 - 3;
//		if(peluru.x > w - peluru.width){
//			x *= -1;
//		}else if(peluru.x<0){
//			x *= -1;
//		}
//		
//		peluru.x +=x;
//		
//		if(peluru.y > h - peluru.height){
//			y *= -1;
//		}else if(peluru.y<0){
//			y *= -1;
//		}
//		peluru.y +=y;
//		
//		
//		if ((peluru.x < 0) || (peluru.x > 800 - 16) || (peluru.y < 0) || (peluru.y > 480 - 17)){
//	        peluru.x = 800/2;
//	        peluru.y = 480/2;
//		}
		

	}
	
	
}
