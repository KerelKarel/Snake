package com.kg.vg1.item;

import java.util.Random;

import com.kg.vg1.level.Level;

public class Item {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	
	public void init(Level level) {
		this.level = level;
	}
}
