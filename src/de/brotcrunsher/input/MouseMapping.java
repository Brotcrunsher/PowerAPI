package de.brotcrunsher.input;

public interface MouseMapping {
	public MouseButton rawToMouseButton(int button);
	
	public float transformXPos(float x);
	public float transformYPos(float y);
}
