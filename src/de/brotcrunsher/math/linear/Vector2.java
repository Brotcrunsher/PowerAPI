package de.brotcrunsher.math.linear;

public class Vector2 {
	private static final Vector2 zero = new Vector2();

	private static final ThreadLocalVector2 workingVector = new ThreadLocalVector2();
	
	
	private static Vector2 initializeIfNull(Vector2 result){
		if(result == null){
			return new Vector2();
		}
		return result;
	}

	private float x;
	private float y;

	public static Vector2 newOnCircle(Vector2 result, float angleRadians){
		//TESTED
		return newOnCircle(result, angleRadians, 1);
	}

	public static Vector2 newOnCircle(Vector2 result, float angleRadians, float radius){
		//TESTED
		result = initializeIfNull(result);
		angleRadians = FMath.mod(angleRadians, FMath.PI * 2);
		result.x = radius * FMath.cos(angleRadians);
		result.y = radius * FMath.sin(angleRadians);
		return result;
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
		return FMath.sqrt(lengthSq());
	}
	
	public static float lengthSq(float x, float y){
		//TODO TEST
		return x * x + y * y;
	}
	
	public static float length(float x, float y){
		//TODO TEST
		return FMath.sqrt(lengthSq(x, y));
	}

	public boolean isShorterThan(Vector2 other){
		//TESTED
		if(other == null){
			other = zero;
		}

		return this.lengthSq() < other.lengthSq();
	}
	public boolean isLongerThan(Vector2 other){
		//TESTED
		if(other == null){
			other = zero;
		}

		return this.lengthSq() > other.lengthSq();
	}
	public boolean isSameLength(Vector2 other){
		//TESTED
		if(other == null){
			other = zero;
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

		float lengthDiff = FMath.abs(thisLength - otherLength);

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
		return distanceBetween(a.getX(), a.getY(), b.getX(), b.getY());
	}
	
	public static float distanceBetween(Vector2 a, float x1, float y1){
		//TODO TEST
		return distanceBetween(a.getX(), a.getY(), x1, y1);
	}
	
	public static float distanceBetween(float x0, float y0, Vector2 b){
		//TODO TEST
		return distanceBetween(x0, y0, b.getX(), b.getY());
	}
	
	public static float distanceBetween(float x0, float y0, float x1, float y1){
		//TODO TEST
		float diffX = x0 - x1;
		float diffY = y0 - y1;
		
		return FMath.sqrt(diffX * diffX + diffY * diffY);
	}

	public static float distanceBetweenSq(Vector2 a, Vector2 b){
		//TESTED
		return distanceBetweenSq(a.getX(), a.getY(), b.getX(), b.getY());
	}

	public static float distanceBetweenSq(Vector2 v, float x, float y){
		//TODO TEST
		return distanceBetweenSq(v.getX(), v.getY(), x, y);
	}

	public static float distanceBetweenSq(float x, float y, Vector2 v){
		//TODO TEST
		return distanceBetweenSq(x, y, v.getX(), v.getY());
	}

	public static float distanceBetweenSq(float x0, float y0, float x1, float y1){
		//TODO TEST
		float diffX = x0 - x1;
		float diffY = y0 - y1;

		return diffX * diffX + diffY * diffY;
	}

	public Vector2 mirrorByVectorThis(Vector2 mirror){
		//TESTED
		Vector2 working = workingVector.get();
		mirror.normalized(working);

		float scalar = 2 * (this.x * working.x + this.y * working.y);
		x = - x + scalar * working.x;
		y = - y + scalar * working.y;

		return this;
	}

	public Vector2 mirrorByVector(Vector2 result, Vector2 mirror){
		//TESTED
		result = initializeIfNull(result);
		Vector2 working = workingVector.get();
		mirror.normalized(working);
		float scalar = 2 * (this.x * working.x + this.y * working.y);
		float x = this.x - scalar * working.x;
		float y = this.y - scalar * working.y;
		result.x = -x;
		result.y = -y;

		return result;
	}


	public boolean isZero(){
		//TESTED
		return x == 0 && y == 0;
	}

	public Vector2 normalizeThis(){
		//TESTED
		float length = this.length();
		if(length == 0){
			x = 1;
			y = 0;
		}else{
			x /= length;
			y /= length;
		}
		return this;
	}

	public Vector2 normalized(Vector2 result){
		//TESTED
		result = initializeIfNull(result);
		float length = this.length();
		if(length == 0){
			result.x = 1;
			result.y = 0;
			return result;
		}
		result.x = x / length;
		result.y = y / length;
		return result;
	}

	public Vector2 flipThis(){
		//TESTED
		float temp = x;
		x = y;
		y = temp;
		return this;
	}

	public Vector2 flip(Vector2 result){
		//TESTED
		result = initializeIfNull(result);
		result.x = y;
		result.y = x;
		return result;
	}

	public Vector2 projectThis(Vector2 projector){
		//TESTED
		float scalar = projector.dotProduct(this) / projector.lengthSq();
		this.x = projector.x * scalar;
		this.y = projector.y * scalar;
		return this;
	}

	public Vector2 project(Vector2 result, Vector2 projector){
		//TESTED
		result = initializeIfNull(result);
		float scalar = projector.dotProduct(this) / projector.lengthSq();
		result.x = projector.x * scalar;
		result.y = projector.y * scalar;
		return result;
	}

	public static float angleRadiansBetween(Vector2 a, Vector2 b){
		//TESTED
		return FMath.acos(a.dotProduct(b) / a.length() / b.length());
	}

	public Vector2 rotateThis(float radians){
		//TESTED
		float cos = FMath.cos(radians);
		float sin = FMath.sin(radians);
		float tempX = x;
		x = cos * x     - sin * y;
		y = sin * tempX + cos * y;
		return this;
	}

	public Vector2 rotate(Vector2 result, float radians){
		//TESTED
		result = initializeIfNull(result);
		float cos = FMath.cos(radians);
		float sin = FMath.sin(radians);
		result.x = cos * x - sin * y;
		result.y = sin * x + cos * y;
		return result;
	}

	public Vector2 setLengthThis(float length){
		//TESTED
		normalizeThis();
		x *= length;
		y *= length;
		return this;
	}

	public Vector2 setLength(Vector2 result, float length){
		//TESTED
		result = initializeIfNull(result);
		normalized(result);
		result.multThis(length);
		return result;
	}

	public Vector2 rotate90ClockwiseThis(){
		//TESTED
		float temp = x;
		x = -y;
		y = temp;
		return this;
	}

	public Vector2 rotate90CounterclockwiseThis(){
		//TESTED
		float temp = x;
		x = y;
		y = -temp;
		return this;
	}

	public Vector2 rotate90Clockwise(Vector2 result){
		//TESTED
		result = initializeIfNull(result);
		result.x = -y;
		result.y = x;
		return result;
	}

	public Vector2 rotate90Counterclockwise(Vector2 result){
		//TESTED
		result = initializeIfNull(result);
		result.x = y;
		result.y = -x;
		return result;
	}

	public Vector2 absThis(){
		//TESTED
		x = FMath.abs(x);
		y = FMath.abs(y);
		return this;
	}

	public Vector2 rotateAroundThis(Vector2 rotationCenter, float radians){
		//TODO Test
		float diffX = rotationCenter.x - this.x;
		float diffY = rotationCenter.y - this.y;

		float cos = FMath.cos(radians);
		float sin = FMath.sin(radians);
		
		float xx = cos * diffX - sin * diffY + this.x;
		float yy = sin * diffX + cos * diffY + this.y;
		
		this.x = xx;
		this.y = yy;
		
		return this;
	}

	public Vector2 rotateAround(Vector2 result, Vector2 rotationCenter, float radians){
		//TODO Test
		result = initializeIfNull(result);
		
		result.set(x, y);
		
		result.rotateAroundThis(rotationCenter, radians);
		return result;
	}

	public Vector2 abs(Vector2 result){
		//TESTED
		result = initializeIfNull(result);
		result.x = FMath.abs(x);
		result.y = FMath.abs(y);
		return result;
	}

	public float getMax(){
		//TESTED
		return FMath.max(x, y);
	}

	public float getMin(){
		//TESTED
		return FMath.min(x, y);
	}

	public float getAbsMax(){
		//TESTED
		return FMath.maxAbs(x, y);
	}

	public float getAbsMin(){
		//TESTED
		return FMath.minAbs(x, y);
	}

	public Vector2 clampComponentsThis(float min, float max){
		//TESTED
		x = FMath.clamp(x, min, max);
		y = FMath.clamp(y, min, max);
		return this;
	}

	public Vector2 clampComponents(Vector2 result, float min, float max){
		//TESTED
		result = initializeIfNull(result);
		result.x = FMath.clamp(x, min, max);
		result.y = FMath.clamp(y, min, max);
		return result;
	}

	public float headingAngle(){
		//TESTED
		float angle = FMath.acos(x / length());
		if(y >= 0){
			return angle;
		}else{
			return FMath.PI * 2 - angle;
		}
	}

	public Vector2 setX(float x){
		//TESTED
		this.x = x;
		return this;
	}
	public Vector2 setY(float y){
		//TESTED
		this.y = y;
		return this;
	}
	public Vector2 set(float x, float y){
		//TESTED
		this.x = x;
		this.y = y;
		return this;
	}
	public Vector2 set(Vector2 other){
		//TESTED
		this.x = other.x;
		this.y = other.y;
		return this;
	}
	public float getX(){
		//TESTED
		return x;
	}
	public float getY(){
		//TESTED
		return y;
	}

	public Vector2 addToThisX(float val){
		//TESTED
		this.x += val;
		return this;
	}

	public Vector2 addToThisY(float val){
		//TESTED
		this.y += val;
		return this;
	}

	public Vector2 addToThis(float x, float y){
		//TESTED
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2 addToThis(Vector2 other){
		//TESTED
		addToThis(other.getX(), other.getY());
		return this;
	}

	public Vector2 addX(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = x + val;
		result.y = y;
		return result;
	}

	public Vector2 addY(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = x;
		result.y = y + val;
		return result;
	}

	public Vector2 add(Vector2 result, float x, float y){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.x + x;
		result.y = this.y + y;
		return result;
	}

	public Vector2 add(Vector2 result, Vector2 other){
		//TESTED
		result = initializeIfNull(result);
		add(result, other.getX(), other.getY());
		return result;
	}

	public Vector2 subFromThisX(float val){
		//TESTED
		this.x -= val;
		return this;
	}

	public Vector2 subFromThisY(float val){
		//TESTED
		this.y -= val;
		return this;
	}

	public Vector2 subFromThis(float x, float y){
		//TESTED
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2 subFromThis(Vector2 other){
		//TESTED
		subFromThis(other.getX(), other.getY());
		return this;
	}

	public Vector2 subX(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = x - val;
		result.y = y;
		return result;
	}

	public Vector2 subY(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = x;
		result.y = y - val;
		return result;
	}

	public Vector2 sub(Vector2 result, float x, float y){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.x - x;
		result.y = this.y - y;
		return result;
	}

	public Vector2 sub(Vector2 result, Vector2 other){
		//TESTED
		result = initializeIfNull(result);
		sub(result, other.getX(), other.getY());
		return result;
	}

	public Vector2 divThisX(float val){
		//TESTED
		x /= val;
		return this;
	}

	public Vector2 divX(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = x / val;
		result.y = y;
		return result;
	}

	public Vector2 divThisY(float val){
		//TESTED
		y /= val;
		return this;
	}

	public Vector2 divY(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = x;
		result.y = y / val;
		return result;
	}

	public Vector2 divThis(float val){
		//TESTED
		x /= val;
		y /= val;
		return this;
	}

	public Vector2 div(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = x / val;
		result.y = y / val;
		return result;
	}

	public Vector2 divComponentsThis(float x, float y){
		//TESTED
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2 divComponents(Vector2 result, float x, float y){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.getX() / x;
		result.y = this.getY() / y;
		return result;
	}

	public Vector2 divComponents(Vector2 result, Vector2 other){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.getX() / other.getX();
		result.y = this.getY() / other.getY();
		return result;
	}

	public Vector2 divComponentsThis(Vector2 other){
		//TESTED
		divComponentsThis(other.getX(), other.getY());
		return this;
	}

	public Vector2 multX(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.getX() * val;
		result.y = this.getY();
		return result;
	}

	public Vector2 multThisX(float val){
		//TESTED
		this.x *= val;
		return this;
	}

	public Vector2 multY(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.getX();
		result.y = this.getY() * val;
		return result;
	}

	public Vector2 multThisY(float val){
		//TESTED
		this.y *= val;
		return this;
	}

	public Vector2 mult(Vector2 result, float val){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.getX() * val;
		result.y = this.getY() * val;
		return result;
	}

	public Vector2 multThis(float val){
		//TESTED
		this.x *= val;
		this.y *= val;
		return this;
	}

	public Vector2 multComponents(Vector2 result, float x, float y){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.getX() * x;
		result.y = this.getY() * y;
		return result;
	}

	public Vector2 multComponentsThis(float x, float y){
		//TESTED
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2 multComponents(Vector2 result, Vector2 other){
		//TESTED
		result = initializeIfNull(result);
		result.x = this.getX() * other.getX();
		result.y = this.getY() * other.getY();
		return result;
	}

	public Vector2 multComponentsThis(Vector2 other){
		//TESTED
		multComponentsThis(other.getX(), other.getY());
		return this;
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
		//TODO TEST
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
