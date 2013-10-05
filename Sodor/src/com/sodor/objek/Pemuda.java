package com.sodor.objek;

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

	Rectangle rectangle;
	Texture bg;
	

	public Pemuda() {
		// TODO Auto-generated constructor stub
		FRAME_COLS=6;
		FRAME_ROWS=5;
		create();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		Sheet = new Texture(Gdx.files.internal("animation_sheet.png"));
		TextureRegion[][] tmp = TextureRegion.split(Sheet, Sheet.getWidth()/FRAME_COLS, Sheet.getHeight()/FRAME_ROWS);
		Frames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
		int index=0;
		for(int i=0;i<FRAME_ROWS;i++){
			for(int j=0;j<FRAME_COLS;j++){
				Frames[index++]=tmp[i][j];
			}
		}
		animation = new Animation(0.025f, Frames);
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
	}
	
	private void draw() {
		// TODO Auto-generated method stub
		update();
		batch.draw(currentFrame, rectangle.x, rectangle.y);
	}
	
	private void update() {
		// TODO Auto-generated method stub
//		OrthographicCamera camera = new OrthographicCamera();
		if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            rectangle.x = touchPos.x - 86 / 2;
	    }
	    if (Gdx.input.isKeyPressed(Keys.LEFT))
	            rectangle.x -= 150 * Gdx.graphics.getDeltaTime();
	    if (Gdx.input.isKeyPressed(Keys.RIGHT))
	            rectangle.x += 150 * Gdx.graphics.getDeltaTime();
	    if (Gdx.input.isKeyPressed(Keys.DOWN))
            rectangle.y -= 75 * Gdx.graphics.getDeltaTime();
	    if (Gdx.input.isKeyPressed(Keys.UP))
            rectangle.y += 75 * Gdx.graphics.getDeltaTime();
	    if (rectangle.x < 0)
	        rectangle.x = 0;
		if (rectangle.x > 800 - 86)
	        rectangle.x = 800 - 86;
	    
	}
	
}
