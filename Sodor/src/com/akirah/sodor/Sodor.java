package com.akirah.sodor;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sodor.jagoan.Pemuda;
import com.sodor.mobil.Mobil;
import com.sodor.mobil.MobilRusak;

import enemy.Peluru;
import enemy.PrajuritSenjata;

public class Sodor implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	Pemuda akip;
	Mobil mobil, mobilReverse;
	MobilRusak mobilRusak, mobilRusak2;
	
	boolean isOK=true;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		
		//ball = new Peluru();
		akip = new Pemuda();
		mobil = new Mobil(new Texture(Gdx.files.internal("mobil/mobil_belanda.png")), false);
		mobilReverse = new Mobil(new Texture(Gdx.files.internal("mobil/mobil_belanda_reverse.png")), true);
	}

	@Override
	public void dispose() {
		batch.dispose();
		//ball.dispose();
		akip.dispose();
		mobilRusak.dispose();
		mobilRusak2.dispose();
		mobil.dispose();
		mobilReverse.dispose();
	}

	@Override
	public void render() {	
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//if(akip.rectangle.overlaps(ball.bola)){
			//ball.update(5,5);
		//}
		
		//camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			akip.render();
			update();
			if(isOK){
				mobil.render();
				mobilReverse.render();
			}else{
				
				mobilRusak.render();
				mobilRusak2.render();
			}
			
				
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	private void update() {
		// TODO Auto-generated method stub
		if(mobil.rectangle.overlaps(mobilReverse.rectangle) && isOK){	
			isOK=false;
			mobilRusak = new MobilRusak(new Texture(Gdx.files.internal("mobil/mobil_rusak.png")), false, (int)mobil.rectangle.x, (int)mobil.rectangle.y );
			mobilRusak2 = new MobilRusak(new Texture(Gdx.files.internal("mobil/mobil_rusak_reverse.png")), true, (int)mobilReverse.rectangle.x, (int)mobilReverse.rectangle.y);
		}
	}
}
