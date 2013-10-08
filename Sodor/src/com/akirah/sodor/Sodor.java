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
import com.sodor.objek.PrajuritSenjata;
import com.sodor.objek.Peluru;
import com.sodor.objek.Karakter;
import com.sodor.objek.Pemuda;

public class Sodor implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	Pemuda akip,mobil;
	PrajuritSenjata unyu;
	//Peluru ball;
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		
		//ball = new Peluru();
		akip = new Pemuda(new Texture(Gdx.files.internal("animation_sheet.png")), new Texture(Gdx.files.internal("animation_sheet_reverse.png")),5,6);
		mobil = new Pemuda(new Texture(Gdx.files.internal("mobil_belanda.png")), new Texture(Gdx.files.internal("mobil_belanda_reverse.png")),1,4);
		unyu = new PrajuritSenjata();
		
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		//ball.dispose();
		akip.dispose();
		unyu.dispose();
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
			unyu.render();
			//ball.render();
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
}
