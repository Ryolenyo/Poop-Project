package com.jittat.gdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Button {
	
	static Texture buttonBox(int type,int color){
		Texture buttonArray[][] = new Texture[10][2];
		for (int x = 0 ; x < 10 ; x++) {
			for (int y = 0 ; y < 2 ; y++) {
				buttonArray[x][y] = new Texture(callButton(x,y));
			}
		}
		return buttonArray[type][color];
	}
	
	static String callButton(int type,int color) {
		String[][] button = {
						{"blue_w.png","red_w.png"},
						{"blue_a.png","red_a.png"},
						{"blue_s.png","red_s.png"},
						{"blue_d.png","red_d.png"},
						{"blue_up.png","red_up.png"},
						{"blue_left.png","red_left.png"},
						{"blue_down.png","red_down.png"},
						{"blue_right.png","red_right.png"},
						{"blue_f.png","red_f.png"},
						{"blue_sla.png","red_sla.png"}
				};

		
		
		return button[type][color];
	}
}
