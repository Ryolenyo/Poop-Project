package com.jittat.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PoopScreen extends ApplicationAdapter {
	Gauge guage;
	
	SpriteBatch batch;
	Texture background;
	
	Button button = null;
	Gauge gauge = null;
	ControlButton controlButton = null;
	
	int state = 0;
	boolean count = false;
	
	public void update(String x) {
		boolean unstop = true;
		int key = 0;
		if (x == "w") {
			key = Keys.W;
		}
		else if (x == "a") {
			key = Keys.A;
		}
		else if (x == "s") {
			key = Keys.S;
		}
		else if (x == "d") {
			key = Keys.D;
		}
		
		if (state==10)
		{
			unstop = false;
		}
		
		if (Gdx.input.isKeyPressed(key) & unstop) {
			count = true;
		}
		if (count & Gdx.input.isKeyPressed(key)==false & unstop)
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

	public void control(int state) {
		int n = 0;
		for (int i = 0 ; i < state+1 ; i++)
		{
			Random rand = new Random();
			n = rand.nextInt(4);
			choose(n);
			
		///////////////DELAY///////////////
//		try {
//			TimeUnit.SECONDS.sleep(1);
///		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		///////////////////////////////////
			
//			System.out.println(n);
		}
	}
	
	
	public void choose(int toggle) {
		
		if (toggle == 0) {
			batch.draw(button.buttonBox(0,1),220,120);
		}
		else if (toggle == 1){
			batch.draw(button.buttonBox(1,1),150,50);
		}
		else if (toggle == 2){
			batch.draw(button.buttonBox(2,1),220,50);
		}
		else if (toggle == 3){
			batch.draw(button.buttonBox(3,1),290,50);
		}
	}
	

	public void render () {
		
		batch.begin();
		
		batch.draw(background, 0, 0);
		
		///////////////BUTTON///////////////
				
		batch.draw(button.buttonBox(0,0),220,120);
		batch.draw(button.buttonBox(1,0),150,50);
		batch.draw(button.buttonBox(2,0),220,50);
		batch.draw(button.buttonBox(3,0),290,50);
		
		control(state); //show sequence with red button

		
		batch.draw(gauge.callGauge(state), 50,200);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
	

}