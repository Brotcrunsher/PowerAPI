package de.brotcrunsher.math.linear;

public class ThreadLocalVector2 extends ThreadLocal<Vector2>{
	@Override
	protected Vector2 initialValue() {
		return new Vector2();
	}
}
