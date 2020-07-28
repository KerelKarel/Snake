package com.kg.vg1.level.tile;

import com.kg.vg1.graphics.Screen;
import com.kg.vg1.graphics.Sprite;

public class BorderTile extends Tile {

	public BorderTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return true;
	}
}
