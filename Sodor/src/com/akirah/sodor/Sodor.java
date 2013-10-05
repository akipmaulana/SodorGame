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
import com.sodor.objek.Bayi;
import com.sodor.objek.Bola;
import com.sodor.objek.Karakter;
import com.sodor.objek.Pemuda;

public class Sodor implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	
	Pemuda akip;
	Bayi unyu;
	Bola ball;
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		
		ball = new Bola();
		akip = new Pemuda();
		unyu = new Bayi();
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		ball.dispose();
		akip.dispose();
		unyu.dispose();
	}

	@Override
	public void render() {	
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		//camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			akip.render();
			unyu.render();
			ball.render();
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
