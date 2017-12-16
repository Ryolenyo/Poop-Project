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
	
	Button button = null;
	Gauge gauge = null;
	ControlButton controlButton = null;
	
	int state = 0;
	boolean count = false;
	
	public void update() {
		
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			count = true;
		}
		if (count & Gdx.input.isKeyPressed(Keys.UP)==false)
		{
			state += 1;
			count = false;
		}
			
		//System.out.println(state);
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		String x = "bg.png";
		background = new Texture(x);
				
	}



	public void render () {
		batch.begin();
		update();
		
		batch.draw(background, 0, 0);
		
		batch.draw(button.buttonBox(0,0),220,120);
		batch.draw(button.buttonBox(1,0),150,50);
		batch.draw(button.buttonBox(2,0),220,50);
		batch.draw(button.buttonBox(3,0),290,50);
		
		batch.draw(gauge.callGauge(state), 50,200);
		
//		controlButton.randomInt(0);
	
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
	

}