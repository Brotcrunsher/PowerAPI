package de.brotcrunsher.math.linear;

public class Vector2 {
	private float x;
	private float y;
	
	public static Vector2 newOnCircle(float angleRadians){
		//TESTED
		return newOnCircle(angleRadians, 1);
	}
	
	public static Vector2 newOnCircle(float angleRadians, float radius){
		//TESTED
		angleRadians = Math.mod(angleRadians, Math.PI * 2);
		float x = radius * Math.cos(angleRadians);
		float y = radius * Math.sin(angleRadians);
		return new Vector2(x, y);
	}
	
	public Vector2(){
		//TESTED
		this(0, 0);
	}
	
	public Vector2(float x){
		//TESTED
		this(x, 0);
	}
	
	public Vector2(Vector2 other){
		//TESTED
		this(other.getX(), other.getY());
	}
	
	public Vector2(float x, float y){
		//TESTED
		this.x = x;
		this.y = y;
	}
	
	public float lengthSq(){
		//TESTED
		return x*x + y*y;
	}
	public float length(){
		//TESTED
		return Math.sqrt(lengthSq());
	}
	
	public boolean isShorterThan(Vector2 other){
		//TESTED
		if(other == null){
			other = new Vector2();
		}
		
		return this.lengthSq() < other.lengthSq();
	}
	public boolean isLongerThan(Vector2 other){
		//TESTED
		if(other == null){
			other = new Vector2();
		}
		
		return this.lengthSq() > other.lengthSq();
	}
	public boolean isSameLength(Vector2 other){
		//TESTED
		if(other == null){
			other = new Vector2();
		}
		
		return this.lengthSq() == other.lengthSq();
	}
	public boolean isSameLength(Vector2 other, float epsilon){
		//TESTED
		float thisLength = this.length();
		float otherLength = 0;
		if(other != null){
			otherLength = other.length();
		}
		
		float lengthDiff = Math.abs(thisLength - otherLength);
		
		return lengthDiff <= epsilon;
	}
	public boolean isSameDirection(Vector2 other){
		//TESTED
		float scalar = dotProduct(other);
		return scalar > 0;
	}
	public boolean isOppositeDirection(Vector2 other){
		//TESTED
		float scalar = dotProduct(other);
		return scalar < 0;
	}
	public boolean isLeftOf(Vector2 other){
		//TESTED
		float scalar = this.x * other.y - this.y * other.x;
		return scalar > 0;
	}
	public boolean isRightOf(Vector2 other){
		//TESTED
		float scalar = this.x * other.y - this.y * other.x;
		return scalar < 0;
	}
	public boolean isComponentsEqual(Vector2 other, float tolerance){
		//TESTED
		float diffX = other.x - this.x;
		float diffY = other.y - this.y;
		return diffX >= -tolerance && diffX <= tolerance && diffY >= -tolerance && diffY <= tolerance;
	}
	public boolean isContainingNaN(){
		//TESTED
		return Float.isNaN(x) || Float.isNaN(y);
	}
	public boolean isContainingAnyInfinity(){
		//TESTED
		return Float.isInfinite(x) || Float.isInfinite(y);
	}
	public boolean isUnit(){
		//TESTED
		float lengthSq = lengthSq();
		return lengthSq > 0.999 && lengthSq < 1.001;
	}
	public boolean isCloseTo(Vector2 other, float maxDist){
		//TESTED
		float distSq = distanceBetweenSq(this, other);
		float maxDistSq = maxDist * maxDist;
		return distSq <= maxDistSq;
	}
	
	public float distanceTo(Vector2 other){
		//TESTED
		return distanceBetween(this, other);
	}
	
	public static float distanceBetween(Vector2 a, Vector2 b){
		//TESTED
		float distSq = distanceBetweenSq(a, b);
		return Math.sqrt(distSq);
	}
	
	public static float distanceBetweenSq(Vector2 a, Vector2 b){
		//TESTED
		float diffX = a.x - b.x;
		float diffY = a.y - b.y;
		
		return diffX * diffX + diffY * diffY;
	}
	
	public void mirrorByVectorThis(Vector2 mirror){
		//TESTED
		mirror = mirror.normalized();
		float scalar = 2 * (this.x * mirror.x + this.y * mirror.y);
		x = - x + scalar * mirror.x;
		y = - y + scalar * mirror.y;
		
	}
	
	public Vector2 mirrorByVector(Vector2 mirror){
		//TESTED
		mirror = mirror.normalized();
		float scalar = 2 * (this.x * mirror.x + this.y * mirror.y);
		float x = this.x - scalar * mirror.x;
		float y = this.y - scalar * mirror.y;
		return new Vector2(-x, -y);
	}
	
	
	public boolean isZero(){
		//TESTED
		return x == 0 && y == 0;
	}
	
	public void normalizeThis(){
		//TESTED
		float length = this.length();
		if(length == 0){
			x = 1;
			y = 0;
		}else{
			x /= length;
			y /= length;
		}
	}
	
	public Vector2 normalized(){
		//TESTED
		float length = this.length();
		if(length == 0){
			return new Vector2(1, 0);
		}
		return new Vector2(x / length, y / length);
	}
	
	public void flipThis(){
		//TESTED
		float temp = x;
		x = y;
		y = temp;
	}
	
	public Vector2 flip(){
		//TESTED
		return new Vector2(y, x);
	}
	
	public void projectThis(Vector2 projector){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public Vector2 project(Vector2 projector){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static float angleRadiansBetween(Vector2 a, Vector2 b){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void rotateThis(float radians){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public Vector2 rotate(float radians){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void rotate90ClockwiseThis(){
		//TESTED
		float temp = x;
		x = -y;
		y = temp;
	}
	
	public void rotate90CounterclockwiseThis(){
		//TESTED
		float temp = x;
		x = y;
		y = -temp;
	}
	
	public Vector2 rotate90Clockwise(){
		//TESTED
		return new Vector2(-y, x);
	}
	
	public Vector2 rotate90Counterclockwise(){
		//TESTED
		return new Vector2(y, -x);
	}
	
	public void absThis(){
		//TESTED
		x = Math.abs(x);
		y = Math.abs(y);
	}
	
	public Vector2 abs(){
		//TESTED
		return new Vector2(Math.abs(x), Math.abs(y));
	}
	
	public float getMax(){
		//TESTED
		return Math.max(x, y);
	}
	
	public float getMin(){
		//TESTED
		return Math.min(x, y);
	}
	
	public float getAbsMax(){
		//TESTED
		return Math.maxAbs(x, y);
	}
	
	public float getAbsMin(){
		//TESTED
		return Math.minAbs(x, y);
	}
	
	public void clampComponentsThis(float min, float max){
		//TESTED
		x = Math.clamp(x, min, max);
		y = Math.clamp(y, min, max);
	}
	
	public Vector2 clampComponents(float min, float max){
		//TESTED
		return new Vector2(Math.clamp(x, min, max), Math.clamp(y, min, max));
	}
	
	public float headingAngle(){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public void setX(float x){
		//TESTED
		this.x = x;
	}
	public void setY(float y){
		//TESTED
		this.y = y;
	}
	public void set(float x, float y){
		//TESTED
		this.x = x;
		this.y = y;
	}
	public void set(Vector2 other){
		//TESTED
		this.x = other.x;
		this.y = other.y;
	}
	public float getX(){
		//TESTED
		return x;
	}
	public float getY(){
		//TESTED
		return y;
	}
	
	public void addToThisX(float val){
		//TESTED
		this.x += val;
	}
	
	public void addToThisY(float val){
		//TESTED
		this.y += val;
	}
	
	public void addToThis(float x, float y){
		//TESTED
		this.x += x;
		this.y += y;
	}
	
	public void addToThis(Vector2 other){
		//TESTED
		addToThis(other.getX(), other.getY());
	}
	
	public Vector2 addX(float val){
		//TESTED
		return new Vector2(x + val, y);
	}
	
	public Vector2 addY(float val){
		//TESTED
		return new Vector2(x, y + val);
	}
	
	public Vector2 add(float x, float y){
		//TESTED
		return new Vector2(this.x + x, this.y + y);
	}
	
	public Vector2 add(Vector2 other){
		//TESTED
		return add(other.getX(), other.getY());
	}
	
	public void subFromThisX(float val){
		//TESTED
		this.x -= val;
	}
	
	public void subFromThisY(float val){
		//TESTED
		this.y -= val;
	}
	
	public void subFromThis(float x, float y){
		//TESTED
		this.x -= x;
		this.y -= y;
	}
	
	public void subFromThis(Vector2 other){
		//TESTED
		subFromThis(other.getX(), other.getY());
	}
	
	public Vector2 subX(float val){
		//TESTED
		return new Vector2(x - val, y);
	}
	
	public Vector2 subY(float val){
		//TESTED
		return new Vector2(x, y - val);
	}
	
	public Vector2 sub(float x, float y){
		//TESTED
		return new Vector2(this.x - x , this.y - y);
	}
	
	public Vector2 sub(Vector2 other){
		//TESTED
		return sub(other.getX(), other.getY());
	}
	
	public void divThisX(float val){
		//TESTED
		x /= val;
	}
	
	public Vector2 divX(float val){
		//TESTED
		return new Vector2(x / val, y);
	}
	
	public void divThisY(float val){
		//TESTED
		y /= val;
	}
	
	public Vector2 divY(float val){
		//TESTED
		return new Vector2(x, y / val);
	}
	
	public void divThis(float val){
		//TESTED
		x /= val;
		y /= val;
	}
	
	public Vector2 div(float val){
		//TESTED
		return new Vector2(x / val, y / val);
	}
	
	public void divComponentsThis(float x, float y){
		//TESTED
		this.x /= x;
		this.y /= y;
	}
	
	public Vector2 divComponents(float x, float y){
		//TESTED
		return new Vector2(this.getX() / x, this.getY() / y);
	}
	
	public Vector2 divComponents(Vector2 other){
		//TESTED
		return new Vector2(this.getX() / other.getX(), this.getY() / other.getY());
	}
	
	public void divComponentsThis(Vector2 other){
		//TESTED
		divComponentsThis(other.getX(), other.getY());
	}
	
	public Vector2 multX(float val){
		//TESTED
		return new Vector2(this.getX() * val, this.getY());
	}
	
	public void multThisX(float val){
		//TESTED
		this.x *= val;
	}
	
	public Vector2 multY(float val){
		//TESTED
		return new Vector2(this.getX(), this.getY() * val);
	}
	
	public void multThisY(float val){
		//TESTED
		this.y *= val;
	}
	
	public Vector2 mult(float val){
		//TESTED
		return new Vector2(this.getX() * val, this.getY() * val);
	}
	
	public void multThis(float val){
		//TESTED
		this.x *= val;
		this.y *= val;
	}
	
	public Vector2 multComponents(float x, float y){
		//TESTED
		return new Vector2(this.getX() * x, this.getY() * y);
	}
	
	public void multComponentsThis(float x, float y){
		//TESTED
		this.x *= x;
		this.y *= y;
	}
	
	public Vector2 multComponents(Vector2 other){
		//TESTED
		return new Vector2(this.getX() * other.getX(), this.getY() * other.getY());
	}
	
	public void multComponentsThis(Vector2 other){
		//TESTED
		multComponentsThis(other.getX(), other.getY());
	}
	
	public float dotProduct(Vector2 other){
		//TESTED
		return this.getX() * other.getX() + this.getY() * other.getY();
	}
	
	
	
	
	
	@Override
	protected Vector2 clone() {
		return new Vector2(x, y);
	}
	
	@Override
	public String toString() {
		//TESTED
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	public int hashCode() {
		return (int)(x * 7001 + y * 1009);
	}
	
	@Override
	protected final void finalize() throws Throwable {
		super.finalize();
	}
	
	@Override
	public boolean equals(Object obj) {
		//TESTED
		if(!(obj instanceof Vector2)){
			return false;
		}
		if(obj == this) return true;
		Vector2 other = (Vector2)obj;
		return other.x == this.x && other.y == this.y;
	}
}
