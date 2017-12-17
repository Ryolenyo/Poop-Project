package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ControlButton {
	SpriteBatch batch;
	Button button;
	PoopScreen poopScreen;
	
	int point = 0;
	Random rand = new Random();
	int n = rand.nextInt(4);
		
	public void control() {
		if (point == 10) {
			n = rand.nextInt(8);
			choose(n);
		}
		else
			choose(n);
	}
	
	public void choose(int toggle) {
		if (toggle == 0) {
			batch.draw(button.buttonBox(0,1),200,120);
			inputButton(poopScreen.state,"w");
		}
		else if (toggle == 1){
			batch.draw(button.buttonBox(1,1),130,50);
			inputButton(poopScreen.state,"a");
		}
		else if (toggle == 2){
			batch.draw(button.buttonBox(2,1),200,50);
			inputButton(poopScreen.state,"s");
		}
		else if (toggle == 3){
			batch.draw(button.buttonBox(3,1),270,50);
			inputButton(poopScreen.state,"d");
		}
		else if (toggle == 4) {
			batch.draw(button.buttonBox(4,1),780,120);
			inputButton(poopScreen.state,"up");
		}
		else if (toggle == 5){
			batch.draw(button.buttonBox(5,1),710,50);
			inputButton(poopScreen.state,"left");
		}
		else if (toggle == 6){
			batch.draw(button.buttonBox(6,1),780,50);
			inputButton(poopScreen.state,"down");
		}
		else if (toggle == 7){
			batch.draw(button.buttonBox(7,1),850,50);
			inputButton(poopScreen.state,"right");
		}
		
	}
	
	
	public void inputButton(int state,String inp) {
		if (Gdx.input.isKeyJustPressed(Keys.W)) {
			if (inp == "w")
				upPoint();
			else if (inp != "w")
				downState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.A)) {
			if (inp == "a")
				upPoint();
			else if (inp != "a")
				downState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.S)) {
			if (inp == "s")
				upPoint();
			else if (inp != "d")
				downState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.D)) {
			if (inp == "d")
				upPoint();
			else if (inp != "d")
				downState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.UP)) {
			if (inp == "up")
				upPoint();
			else if (inp != "up")
				downState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			if (inp == "left")
				upPoint();
			else if (inp != "left")
				downState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if (inp == "down")
				upPoint();
			else if (inp != "down")
				downState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			if (inp == "right")
				upPoint();
			else if (inp != "right")
				downState();
		}
		
	}
	
	public void upPoint() {
		point ++;
		System.out.println(point);
		if (point == 10) {
			upState();
			control();
			point = 0;
		}
	}
	
	public void upState() {
		poopScreen.state++;
		if (poopScreen.state==11) {
			poopScreen.state = 0;
//			poopScreen.youWin();
		}
	}
	
	public void downState() { 
		if (poopScreen.state>9) {
			poopScreen.state = poopScreen.state - 1;
		}
	}

}