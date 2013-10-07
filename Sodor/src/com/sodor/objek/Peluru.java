package com.sodor.objek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Peluru extends Karakter{

	// Sheet = bolaTExture
	public Rectangle bola;
	float w,h,speedX1,speedY1;
	
	public Peluru() {
		// TODO Auto-generated constructor stub
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		Sheet = new Texture(Gdx.files.internal("bola.png"));
		bola = new Rectangle();
		bola.width=16;
		bola.height=16;
		bola.x=600;
		bola.y=20;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		batch.begin();
			batch.draw(Sheet, bola.x, bola.y);
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
		if(bola.x > w - bola.width){
			x *= -1;
		}else if(bola.x<0){
			x *= -1;
		}
		
		bola.x +=x;
		
		if(bola.y > h - bola.height){
			y *= -1;
		}else if(bola.y<0){
			y *= -1;
		}
		bola.y +=y;
		
		
		if ((bola.x < 0) || (bola.x > 800 - 16) || (bola.y < 0) || (bola.y > 480 - 17)){
	        bola.x = 800/2;
	        bola.y = 480/2;
		}
		

	}
	
	
}
