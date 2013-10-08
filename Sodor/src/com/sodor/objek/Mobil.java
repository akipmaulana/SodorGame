package com.sodor.objek;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Mobil extends Karakter{
	
	public Rectangle rectangle;
	Texture ReverseSheet;
	TextureRegion[] FramesReverse;
	TextureRegion currentFrameR;
	Animation animationR;
	boolean isLeft=false;//cek hadap kanan atau kiri

	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

}
