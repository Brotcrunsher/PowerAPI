package de.brotcrunsher.input;

import java.awt.event.MouseEvent;

public class MouseMappingSwing implements MouseMapping{
	private float offsetX;
	private float offsetY;
	
	public MouseMappingSwing(float offsetX, float offsetY){
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	
	
	@Override
	public MouseButton rawToMouseButton(int button) {
		switch(button){
		case MouseEvent.BUTTON1:
			return MouseButton.left;
		case MouseEvent.BUTTON2:
			return MouseButton.middle;
		case MouseEvent.BUTTON3:
			return MouseButton.right;
		default:
			return MouseButton.unknown;
		}
	}

	@Override
	public float transformXPos(float x) {
		return x - offsetX;
	}

	@Override
	public float transformYPos(float y) {
		return y - offsetY;
	}

}
