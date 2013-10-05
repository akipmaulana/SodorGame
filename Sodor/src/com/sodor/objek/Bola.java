package com.sodor.objek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bola extends Karakter{

	// Sheet = bolaTExture
	Rectangle bola;
	float w,h,speedX1,speedY1;
	
	public Bola() {
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
	
	private void update() {
		// TODO Auto-generated method stub
		if(bola.x > w - bola.width){
			speedX1 *= -1;
		}else if(bola.x<0){
			speedX1 *= -1;
		}
		
		bola.x +=speedX1;
		
		if(bola.y > h - bola.height){
			speedY1 *= -1;
		}else if(bola.y<0){
			speedY1 *= -1;
		}
		bola.y +=speedY1;

	}
	
	
}
