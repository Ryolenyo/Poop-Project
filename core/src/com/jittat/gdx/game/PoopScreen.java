package com.jittat.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PoopScreen extends ApplicationAdapter {
	Gauge guage;
	
	SpriteBatch batch;
	Texture background;
	Texture buttonPic1;
	Texture buttonPic2;
	Texture buttonPic3;
	Texture buttonPic4;
	
	Texture[] gaugeArray = new Texture[11];
	
	int state = 0;
	int count = 0;
	
	public void update() {
		Gauge gauge = null;
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			count += 1;
			if (count > 3) { //delay button
				state += 1;
				count = 0;
			}
			System.out.println(count);
			System.out.println(state);
		}		
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		String x = "bg.png";
		background = new Texture(x);
		
		Button button = null;
		
		buttonPic1 = new Texture(button.callButton(0,0)); //w
		buttonPic2 = new Texture(button.callButton(1,0)); //a
		buttonPic3 = new Texture(button.callButton(2,0)); //s
		buttonPic4 = new Texture(button.callButton(3,0)); //d
		
		Gauge gauge = null;
		gaugeArray[0] = new Texture(guage.Pic(0));
		gaugeArray[1] = new Texture(guage.Pic(1));
		gaugeArray[2] = new Texture(guage.Pic(2));
		gaugeArray[3] = new Texture(guage.Pic(3));
		gaugeArray[4] = new Texture(guage.Pic(4));
		gaugeArray[5] = new Texture(guage.Pic(5));
		gaugeArray[6] = new Texture(guage.Pic(6));
		gaugeArray[7] = new Texture(guage.Pic(7));
		gaugeArray[8] = new Texture(guage.Pic(8));
		gaugeArray[9] = new Texture(guage.Pic(9));
		gaugeArray[10] = new Texture(guage.Pic(10));
		
		
		
	}



	public void render () {
		batch.begin();
		update();
		batch.draw(background, 0, 0);
		batch.draw(buttonPic1, 220,120);
		batch.draw(buttonPic2, 150,50);
		batch.draw(buttonPic3, 220,50);
		batch.draw(buttonPic4, 290,50);
		batch.draw(gaugeArray[state], 50,200);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
	

}