package com.kg.vg1.item;

import java.util.Random;

import com.kg.vg1.Game;
import com.kg.vg1.entity.Tail;
import com.kg.vg1.entity.mob.Player;
import com.kg.vg1.graphics.Screen;
import com.kg.vg1.graphics.Sprite;
import com.kg.vg1.level.Level;

public class Berry extends Item{
	protected Sprite sprite;
	public static int xb;
	public static int yb;
	public static boolean removed = true;
	public static int berryCounter = 0;
	
	public Berry() {
		generateBerry();
	}
	
	public void generateBerry() {
		removed = false;
		Random rand = new Random();
		xb = (rand.nextInt(Game.widthtiles-2)+1)*16;
		yb = (rand.nextInt(Game.heighttiles-2)+1)*16;
		if (duplicateBerry()) {
			generateBerry();
		}
	}
	
	public boolean duplicateBerry() {
		return ((x== xb && y == yb) || Tail.collision(xb, yb));
	}
	
	public void render(Screen screen) {
		if (removed) {
			generateBerry();
		}
		screen.renderPlayer(xb, yb, sprite.berry);
	}
	
	public static void remove() {
		removed = true;
	}
	
	public static int getxb() {
		return xb;
	}
	
	public static int getyb() {
		return yb;
	}
	
	public static void incBerry() {
		berryCounter += 1;
	}
	
	public static int getberryCounter() {
		return berryCounter;
	}
}
