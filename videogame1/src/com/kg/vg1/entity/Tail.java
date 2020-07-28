package com.kg.vg1.entity;

import java.util.ArrayList;

import com.kg.vg1.Game;
import com.kg.vg1.entity.mob.Player;
import com.kg.vg1.graphics.Screen;
import com.kg.vg1.graphics.Sprite;

public class Tail extends Entity{
	protected Sprite sprite;
	private static ArrayList<int[]> taillist = new ArrayList<int[]>();
	
	
	
	public Tail() {
		
	}
	
	public static void updatenormal(int x, int y) {
		if (taillist.size() > 0) {
			taillist.remove(0);
			updateberry(x,y);
		}
	}
	public static void updateberry(int x, int y) {
		int[] temp = new int[2];
		temp[0] = x;
		temp[1] = y;
		taillist.add(temp);
	}
	
	public static boolean collision(int x, int y) {
		for (int i = 0; i < taillist.size(); i++) {
			int xtail = taillist.get(i)[0];
			int ytail = taillist.get(i)[1];
			if (xtail == x && ytail == y) {
				return true;
			}
		}
		return false;
	}
	public void render(Screen screen) {
		for (int i = 0; i < taillist.size(); i++) {
			int x = taillist.get(i)[0];
			int y = taillist.get(i)[1];
			screen.renderPlayer(x,y,sprite.player);
		}
	}
}
