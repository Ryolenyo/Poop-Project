package com.jittat.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gauge {

	
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
