package de.brotcrunsher.math.linear;

public class ThreadLocalVector3 extends ThreadLocal<Vector3>{
	@Override
	protected Vector3 initialValue() {
		return new Vector3();
	}
}
