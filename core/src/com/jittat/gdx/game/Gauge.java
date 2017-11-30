package com.jittat.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gauge {
	SpriteBatch batch;
	Texture test;
	
	public void create () {
		batch = new SpriteBatch();
		test = new Texture(Pic(0));
	}
	
	public void render() {
		batch.begin();
		batch.draw(test,50,200);
		batch.end();
	}
	
	static String Pic(int state){
		String[] gaugepic = {"G00.png",
							"G01.png",
							"G02.png",
							"G03.png",
							"G04.png",
							"G05.png",
							"G06.png",
							"G07.png",
							"G08.png",
							"G09.png",
							"G10.png",
							};  
		return gaugepic[state];
	}
}
