package com.jittat.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.Random;


public class PoopScreen extends ApplicationAdapter {
	Gauge guage;
	
	SpriteBatch batch;
	Texture background;
	Texture poop;
	Texture over;
	
	BitmapFont font;
	
	Button button = null;
	Gauge gauge = null;
	ControlButton controlButton = null;
	
	boolean play = true;
	boolean gOver = false;
	
	int state = 0;
	int count = 0;
	
	private Music music;
	private Sound yes;
	private Sound no;
	private Sound win;
	private Sound fail;
	
	private Integer worldTimer = 60;
	private float timeCount;
	
	int maxpoint = 15;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		String x = "bg.png";
		String y = "poop.png";
		String z = "over.png";
		background = new Texture(x);
		poop = new Texture(y);
		over = new Texture(z);
	
		
		music = Gdx.audio.newMusic(Gdx.files.internal("BGM.mp3"));
		music.setLooping(true);
		music.setVolume(0.8f);
		
		yes = Gdx.audio.newSound(Gdx.files.internal("yes.mp3"));
		no = Gdx.audio.newSound(Gdx.files.internal("no.mp3"));
		win = Gdx.audio.newSound(Gdx.files.internal("win.mp3"));
		fail = Gdx.audio.newSound(Gdx.files.internal("fail.mp3"));
		
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().scale(1);
	}
	
	Random rand = new Random();
	int n = rand.nextInt(4);
		
	public void control(int st) {
		if (point == maxpoint) {
			n = rand.nextInt(8); 
			point = 0;
			choose(n);
		}
		else
			choose(n);
	}
	
	int score = 0;
	
	public void choose(int toggle) {
		if (toggle == 0) {
			batch.draw(button.buttonBox(0,1),200,120);
			inputButton(state,"w");
		}
		else if (toggle == 1){
			batch.draw(button.buttonBox(1,1),130,50);
			inputButton(state,"a");
		}
		else if (toggle == 2){
			batch.draw(button.buttonBox(2,1),200,50);
			inputButton(state,"s");
		}
		else if (toggle == 3){
			batch.draw(button.buttonBox(3,1),270,50);
			inputButton(state,"d");
		}
		else if (toggle == 4) {
			batch.draw(button.buttonBox(4,1),780,120);
			inputButton(state,"up");
		}
		else if (toggle == 5){
			batch.draw(button.buttonBox(5,1),710,50);
			inputButton(state,"left");
		}
		else if (toggle == 6){
			batch.draw(button.buttonBox(6,1),780,50);
			inputButton(state,"down");
		}
		else if (toggle == 7){
			batch.draw(button.buttonBox(7,1),850,50);
			inputButton(state,"right");
		}
		
	}
	
	int point = 0;
	
	public void inputButton(int state,String inp) {
		if (Gdx.input.isKeyJustPressed(Keys.W)) {
			if (inp == "w") {
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "w") {
				System.out.println("nw");
				downState();
				no.play();
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.A)) {
			if (inp == "a"){
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "a"){
				System.out.println("na");
				downState();
				no.play();
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.S)) {
			if (inp == "s"){
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "s"){
				System.out.println("ns");
				downState();
				no.play();
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.D)) {
			if (inp == "d"){
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "d"){
				System.out.println("nd");
				downState();
				no.play();
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.UP)) {
			if (inp == "up"){
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "up"){
				System.out.println("nup");
				downState();
				no.play();
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			if (inp == "left"){
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "left"){
				System.out.println("nl");
				downState();
				no.play();
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if (inp == "down"){
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "down"){
				System.out.println("ndo");
				downState();
				no.play();
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			if (inp == "right"){
				System.out.println("y");
				upPoint();
				yes.play();
			}
			else if (inp != "right"){
				System.out.println("nr");
				downState();
				no.play();
			}
		}
		
	}
	
	public void upPoint() {
		point ++;
		if (point == maxpoint) {
			upState();
		}
	}
	
	public void upState() {
		state++;
		System.out.println(state);
		if (state==11) {
			state = 0;
			youWin();
		}
	}
	
	public void downState() { ///BUG	
		if (state == 0) {
			state = 0;
		}
		else {
			state--;
		}
	}
	
	public void gameOver() {
		play = false;
		gOver = true;
		fail.play();
	}
	
	public void youWin() {
		play = false;
		win.play();
	}
	

	public void render () {
		
		batch.begin();
		
		batch.draw(background, 0, 0);
		
		///////////////BUTTON///////////////
				
		batch.draw(button.buttonBox(0,0),200,120);
		batch.draw(button.buttonBox(1,0),130,50);
		batch.draw(button.buttonBox(2,0),200,50);
		batch.draw(button.buttonBox(3,0),270,50);
		
		batch.draw(button.buttonBox(4,0),780,120);
		batch.draw(button.buttonBox(5,0),710,50);
		batch.draw(button.buttonBox(6,0),780,50);
		batch.draw(button.buttonBox(7,0),850,50);
		
		if (play == true ) {
			control(state);
			update(System.nanoTime());
			music.play();
		}
		else {
			music.stop();
			if (gOver == false)
				batch.draw(poop,0,0);
			else
				batch.draw(over,0,0);
		}
			
		font.draw(batch, "TIME:", 470, 700);
		String time = String.valueOf(worldTimer);
		font.draw(batch, time, 495,650);
		
		batch.draw(gauge.callGauge(state), 50,200); //update gauge
		
		batch.end();
	}
	
	public void update(float dt) {
		timeCount += dt%5;
		if (timeCount >= 35 ){
			if (worldTimer != 0) {
				worldTimer--;
			}
			else {
				gameOver();
			}
			timeCount = 0;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		music.dispose();
		font.dispose();
	}
	

}