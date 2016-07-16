package de.brotcrunsher.math.linear;

public class Vector2 {
	private float x;
	private float y;
	
	public static Vector2 newOnCircle(float angleRadians){
		return newOnCircle(angleRadians, 1);
	}
	
	public static Vector2 newOnCircle(float angleRadians, float radius){
		float x = radius * Math.cos(angleRadians);
		float y = radius * Math.sin(angleRadians);
		return new Vector2(x, y);
	}
	
	public Vector2(){
		this(0, 0);
	}
	
	public Vector2(float x){
		this(x, 0);
	}
	
	public Vector2(Vector2 other){
		this(other.getX(), other.getY());
	}
	
	public Vector2(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float lengthSq(){
		return x*x + y*y;
	}
	public float length(){
		return Math.sqrt(lengthSq());
	}
	
	public boolean isShorterThan(Vector2 other){
		if(other == null){
			other = new Vector2();
		}
		
		return this.lengthSq() < other.lengthSq();
	}
	public boolean isLongerThan(Vector2 other){
		if(other == null){
			other = new Vector2();
		}
		
		return this.lengthSq() > other.lengthSq();
	}
	public boolean isSameLength(Vector2 other){
		if(other == null){
			other = new Vector2();
		}
		
		return this.lengthSq() == other.lengthSq();
	}
	public boolean isSameLength(Vector2 other, float epsilon){
		float thisLength = this.lengthSq();
		float otherLength = 0;
		if(other != null){
			otherLength = other.lengthSq();
		}
		float epsilonSq = epsilon * epsilon;
		
		float lengthDiff = Math.abs(thisLength - otherLength);
		
		return lengthDiff <= epsilonSq;
	}
	public boolean isSameDirection(Vector2 other){
		float scalar = dotProduct(other);
		return scalar > 0;
	}
	public boolean isOppositeDirection(Vector2 other){
		float scalar = dotProduct(other);
		return scalar < 0;
	}
	public boolean isLeftOf(Vector2 other){
		float scalar = this.x * other.x - this.y * other.y;
		return scalar > 0;
	}
	public boolean isRightOf(Vector2 other){
		float scalar = this.x * other.x - this.y * other.y;
		return scalar < 0;
	}
	public boolean isComponentsEqual(Vector2 other, float tolerance){
		float diffX = other.x - this.x;
		float diffY = other.y - this.y;
		return diffX >= -tolerance && diffX <= tolerance && diffY >= -tolerance && diffY <= tolerance;
	}
	public boolean isContainingNaN(){
		//TESTED
		return Float.isNaN(x) || Float.isNaN(y);
	}
	public boolean isContainingAnyInfinity(){
		return Float.isInfinite(x) || Float.isInfinite(y);
	}
	public boolean isUnit(){
		float lengthSq = lengthSq();
		return lengthSq > 0.999 && lengthSq < 1.001;
	}
	public boolean isCloseTo(Vector2 other, float maxDist){
		float distSq = distanceBetween(this, other);
		float maxDistSq = maxDist * maxDist;
		return distSq <= maxDistSq;
	}
	
	public static float distanceBetween(Vector2 a, Vector2 b){
		float distSq = distanceBetweenSq(a, b);
		return Math.sqrt(distSq);
	}
	
	public static float distanceBetweenSq(Vector2 a, Vector2 b){
		float diffX = a.x - b.x;
		float diffY = a.y - b.y;
		
		return diffX * diffX + diffY * diffY;
	}
	
	public void mirrorByVectorThis(Vector2 mirror){
		mirror = mirror.normalized();
		float scalar = 2 * (this.x * mirror.x + this.y * mirror.y);
		x = - x + scalar * mirror.x;
		y = - y + scalar * mirror.y;
		
	}
	
	public Vector2 mirrorByVector(Vector2 mirror){
		mirror = mirror.normalized();
		float scalar = 2 * (this.x * mirror.x + this.y * mirror.y);
		return new Vector2(-x + scalar * mirror.x, -y + scalar * mirror.y);
	}
	
	
	public boolean isZero(){
		return x == 0 && y == 0;
	}
	
	public void normalizeThis(){
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
		float length = this.length();
		if(length == 0){
			return new Vector2(1, 0);
		}
		return new Vector2(x / length, y / length);
	}
	
	public void flipThis(){
		float temp = x;
		x = y;
		y = temp;
	}
	
	public Vector2 flip(){
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
		float temp = x;
		x = -y;
		y = temp;
	}
	
	public void rotate90CounterclockwiseThis(){
		float temp = x;
		x = y;
		y = -temp;
	}
	
	public Vector2 rotate90Clockwise(){
		return new Vector2(-y, x);
	}
	
	public Vector2 rotate90Counterclockwise(){
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
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public void set(float x, float y){
		this.x = x;
		this.y = y;
	}
	public void set(Vector2 other){
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
		this.x -= val;
	}
	
	public void subFromThisY(float val){
		this.y -= val;
	}
	
	public void subFromThis(float x, float y){
		this.x -= x;
		this.y -= y;
	}
	
	public void subFromThis(Vector2 other){
		subFromThis(other.getX(), other.getY());
	}
	
	public Vector2 subX(float val){
		return new Vector2(x - val, y);
	}
	
	public Vector2 subY(float val){
		return new Vector2(x, y - val);
	}
	
	public Vector2 sub(float x, float y){
		return new Vector2(this.x + x , this.y + y);
	}
	
	public Vector2 sub(Vector2 other){
		return sub(other.getX(), other.getY());
	}
	
	public void divThisX(float val){
		x /= val;
	}
	
	public Vector2 divX(float val){
		return new Vector2(x / val, y);
	}
	
	public void divThisY(float val){
		y /= val;
	}
	
	public Vector2 divY(float val){
		return new Vector2(x, y / val);
	}
	
	public void divThis(float val){
		x /= val;
		y /= val;
	}
	
	public Vector2 div(float val){
		return new Vector2(x / val, y / val);
	}
	
	public void divComponentsThis(float x, float y){
		this.x /= x;
		this.y /= y;
	}
	
	public Vector2 divComponents(Vector2 other){
		return new Vector2(this.getX() / other.getX(), this.getY() / other.getY());
	}
	
	public void divComponentsThis(Vector2 other){
		divComponentsThis(other.getX(), other.getY());
	}
	
	public Vector2 multX(float val){
		return new Vector2(this.getX() * val, this.getY());
	}
	
	public void multThisX(float val){
		this.x *= val;
	}
	
	public Vector2 multY(float val){
		return new Vector2(this.getX(), this.getY() * val);
	}
	
	public void multThisY(float val){
		this.y *= val;
	}
	
	public Vector2 mult(float val){
		return new Vector2(this.getX() * val, this.getY() * val);
	}
	
	public void multThis(float val){
		this.x *= val;
		this.y *= val;
	}
	
	public Vector2 multComponents(float x, float y){
		return new Vector2(this.getX() * x, this.getY() * y);
	}
	
	public void multComponentsThis(float x, float y){
		this.x *= x;
		this.y *= y;
	}
	
	public Vector2 multComponents(Vector2 other){
		return new Vector2(this.getX() * other.getX(), this.getY() * other.getY());
	}
	
	public void multComponentsThis(Vector2 other){
		multComponentsThis(other.getX(), other.getY());
	}
	
	public float dotProduct(Vector2 other){
		return this.getX() * other.getX() + this.getY() * other.getY();
	}
	
	
	
	
	
	@Override
	protected Vector2 clone() {
		return new Vector2(x, y);
	}
	
	@Override
	public String toString() {
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
		if(!(obj instanceof Vector2)){
			return false;
		}
		if(obj == this) return true;
		Vector2 other = (Vector2)obj;
		return other.x == this.x && other.y == this.y;
	}
}
