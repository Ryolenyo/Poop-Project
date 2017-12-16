package com.jittat.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gauge {
	static Texture callGauge(int state) {
		Texture[] gaugeArray = new Texture[11];
		
		gaugeArray[0] = new Texture(Pic(0));
		gaugeArray[1] = new Texture(Pic(1));
		gaugeArray[2] = new Texture(Pic(2));
		gaugeArray[3] = new Texture(Pic(3));
		gaugeArray[4] = new Texture(Pic(4));
		gaugeArray[5] = new Texture(Pic(5));
		gaugeArray[6] = new Texture(Pic(6));
		gaugeArray[7] = new Texture(Pic(7));
		gaugeArray[8] = new Texture(Pic(8));
		gaugeArray[9] = new Texture(Pic(9));
		gaugeArray[10] = new Texture(Pic(10));
		
		return gaugeArray[state];
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
