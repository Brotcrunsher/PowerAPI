package de.brotcrunsher.math.linear;

public class Vector3 {
	private static final Vector3 zero = new Vector3();

	private static final ThreadLocalVector3 workingVector = new ThreadLocalVector3();
	
	
	private static Vector3 initializeIfNull(Vector3 result){
		if(result == null){
			return new Vector3();
		}
		return result;
	}
	private static Vector2 initializeIfNull(Vector2 result){
		if(result == null){
			return new Vector2();
		}
		return result;
	}

	private float x;
	private float y;
	private float z;

	public static Vector3 newOnCircle(Vector3 result, float angleRadians){
		//TODO TEST
		return newOnCircle(result, angleRadians, 1);
	}

	public static Vector3 newOnCircle(Vector3 result, float angleRadians, float radius){
		//TODO TEST
		result = initializeIfNull(result);
		angleRadians = FMath.mod(angleRadians, FMath.PI * 2);
		result.x = radius * FMath.cos(angleRadians);
		result.y = radius * FMath.sin(angleRadians);
		result.z = 0;
		return result;
	}

	public Vector3(){
		//TODO TEST
		this(0, 0, 0);
	}

	public Vector3(float x){
		//TODO TEST
		this(x, 0, 0);
	}

	public Vector3(Vector3 other){
		//TODO TEST
		this(other.getX(), other.getY(), other.getZ());
	}
	
	public Vector3(Vector2 xy){
		//TODO TEST
		this(xy.getX(), xy.getY(), 0);
	}
	
	public Vector3(Vector2 xy, float z){
		//TODO TEST
		this(xy.getX(), xy.getY(), z);
	}
	
	public Vector3(float x, Vector2 yz){
		//TODO TEST
		this(x, yz.getX(), yz.getY());
	}

	public Vector3(float x, float y){
		//TODO TEST
		this(x, y, 0);
	}
	
	public Vector3(float x, float y, float z){
		//TODO TEST
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float lengthSq(){
		//TODO TEST
		return x*x + y*y + z*z;
	}
	public float length(){
		//TODO TEST
		return FMath.sqrt(lengthSq());
	}
	
	public static float lengthSq(float x, float y, float z){
		//TODO TEST
		return x * x + y * y + z * z;
	}
	
	public static float length(float x, float y, float z){
		//TODO TEST
		return FMath.sqrt(lengthSq(x, y, z));
	}

	public boolean isShorterThan(Vector3 other){
		//TODO TEST
		if(other == null){
			other = zero;
		}

		return this.lengthSq() < other.lengthSq();
	}
	public boolean isLongerThan(Vector3 other){
		//TODO TEST
		if(other == null){
			other = zero;
		}

		return this.lengthSq() > other.lengthSq();
	}
	public boolean isSameLength(Vector3 other){
		//TODO TEST
		if(other == null){
			other = zero;
		}

		return this.lengthSq() == other.lengthSq();
	}
	public boolean isSameLength(Vector3 other, float epsilon){
		//TODO TEST
		float thisLength = this.length();
		float otherLength = 0;
		if(other != null){
			otherLength = other.length();
		}

		float lengthDiff = FMath.abs(thisLength - otherLength);

		return lengthDiff <= epsilon;
	}
	public boolean isSameDirection(Vector3 other){
		//TODO TEST
		float scalar = dotProduct(other);
		return scalar > 0;
	}
	public boolean isOppositeDirection(Vector3 other){
		//TODO TEST
		float scalar = dotProduct(other);
		return scalar < 0;
	}
	public boolean isLeftOf(Vector3 other){
		//TODO TEST
		float scalar = this.x * other.y - this.y * other.x;
		return scalar > 0;
	}
	public boolean isRightOf(Vector3 other){
		//TODO TEST
		float scalar = this.x * other.y - this.y * other.x;
		return scalar < 0;
	}
	public boolean isComponentsEqual(Vector3 other, float tolerance){
		//TODO TEST
		float diffX = other.x - this.x;
		float diffY = other.y - this.y;
		float diffZ = other.z - this.z;
		return diffX >= -tolerance && diffX <= tolerance 
				&& diffY >= -tolerance && diffY <= tolerance
				&& diffZ >= -tolerance && diffZ <= tolerance;
	}
	public boolean isContainingNaN(){
		//TODO TEST
		return Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z);
	}
	public boolean isContainingAnyInfinity(){
		//TODO TEST
		return Float.isInfinite(x) || Float.isInfinite(y) || Float.isInfinite(z);
	}
	public boolean isUnit(){
		//TODO TEST
		float lengthSq = lengthSq();
		return lengthSq > 0.999 && lengthSq < 1.001;
	}
	public boolean isCloseTo(Vector3 other, float maxDist){
		//TODO TEST
		float distSq = distanceBetweenSq(this, other);
		float maxDistSq = maxDist * maxDist;
		return distSq <= maxDistSq;
	}

	public float distanceTo(Vector3 other){
		//TODO TEST
		return distanceBetween(this, other);
	}

	public static float distanceBetween(Vector3 a, Vector3 b){
		//TODO TEST
		return distanceBetween(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
	}
	
	public static float distanceBetween(Vector3 a, float x1, float y1, float z1){
		//TODO TEST
		return distanceBetween(a.getX(), a.getY(), a.getZ(), x1, y1, z1);
	}
	
	public static float distanceBetween(float x0, float y0, float z0, Vector3 b){
		//TODO TEST
		return distanceBetween(x0, y0, z0, b.getX(), b.getY(), b.getZ());
	}
	
	public static float distanceBetween(float x0, float y0, float z0, float x1, float y1, float z1){
		//TODO TEST
		float diffX = x0 - x1;
		float diffY = y0 - y1;
		float diffZ = z0 - z1;
		
		return FMath.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
	}

	public static float distanceBetweenSq(Vector3 a, Vector3 b){
		//TODO TEST
		return distanceBetweenSq(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
	}

	public static float distanceBetweenSq(Vector3 v, float x, float y, float z){
		//TODO TEST
		return distanceBetweenSq(v.getX(), v.getY(), v.getZ(), x, y, z);
	}

	public static float distanceBetweenSq(float x, float y, float z, Vector3 v){
		//TODO TEST
		return distanceBetweenSq(x, y, z, v.getX(), v.getY(), v.getZ());
	}

	public static float distanceBetweenSq(float x0, float y0, float z0, float x1, float y1, float z1){
		//TODO TEST
		float diffX = x0 - x1;
		float diffY = y0 - y1;
		float diffZ = z0 - z1;

		return diffX * diffX + diffY * diffY + diffZ * diffZ;
	}

	public Vector3 mirrorByVectorThis(Vector3 mirror){
		//TODO implement
		if(true) throw new UnsupportedOperationException();
		Vector3 working = workingVector.get();
		mirror.normalized(working);

		float scalar = 2 * (this.x * working.x + this.y * working.y);
		x = - x + scalar * working.x;
		y = - y + scalar * working.y;

		return this;
	}

	public Vector3 mirrorByVector(Vector3 result, Vector3 mirror){
		//TODO implement
		if(true) throw new UnsupportedOperationException();
		result = initializeIfNull(result);
		Vector3 working = workingVector.get();
		mirror.normalized(working);
		float scalar = 2 * (this.x * working.x + this.y * working.y);
		float x = this.x - scalar * working.x;
		float y = this.y - scalar * working.y;
		result.x = -x;
		result.y = -y;

		return result;
	}


	public boolean isZero(){
		//TODO TEST
		return x == 0 && y == 0 && z == 0;
	}

	public Vector3 normalizeThis(){
		//TODO TEST
		float length = this.length();
		if(length == 0){
			x = 1;
			y = 0;
			z = 0;
		}else{
			x /= length;
			y /= length;
			z /= length;
		}
		return this;
	}

	public Vector3 normalized(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		float length = this.length();
		if(length == 0){
			result.x = 1;
			result.y = 0;
			result.z = 0;
			return result;
		}
		result.x = x / length;
		result.y = y / length;
		result.z = z / length;
		return result;
	}

	public Vector3 flipXYThis(){
		//TODO TEST
		float temp = x;
		x = y;
		y = temp;
		return this;
	}
	
	public Vector3 flipXZThis(){
		//TODO TEST
		float temp = x;
		x = z;
		z = temp;
		return this;
	}
	
	public Vector3 flipYZThis(){
		//TODO TEST
		float temp = y;
		y = z;
		z = temp;
		return this;
	}
	
	public Vector3 flipBackward(){
		//TODO TEST
		float temp = x;
		x = y;
		y = z;
		z = temp;
		return this;
	}
	
	public Vector3 flipForward(){
		//TODO TEST
		float temp = x;
		x = z;
		z = y;
		y = temp;
		return this;
	}

	public Vector3 flipXY(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = y;
		result.y = x;
		return result;
	}
	
	public Vector3 flipXZ(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = z;
		result.z = x;
		return result;
	}
	
	public Vector3 flipYZ(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.y = z;
		result.z = y;
		return result;
	}
	
	public Vector3 flipBackward(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = y;
		result.y = z;
		result.z = x;
		return result;
	}
	
	public Vector3 flipForward(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = z;
		result.y = x;
		result.z = y;
		return result;
	}

	public Vector3 projectThis(Vector3 projector){
		//TODO implement
		float scalar = projector.dotProduct(this) / projector.lengthSq();
		this.x = projector.x * scalar;
		this.y = projector.y * scalar;
		return this;
	}

	public Vector3 project(Vector3 result, Vector3 projector){
		//TODO implement
		result = initializeIfNull(result);
		float scalar = projector.dotProduct(this) / projector.lengthSq();
		result.x = projector.x * scalar;
		result.y = projector.y * scalar;
		return result;
	}

	public static float angleRadiansBetween(Vector3 a, Vector3 b){
		//TODO implement
		return FMath.acos(a.dotProduct(b) / a.length() / b.length());
	}

	public Vector3 rotateThis(float radians){
		//TODO implement
		float cos = FMath.cos(radians);
		float sin = FMath.sin(radians);
		float tempX = x;
		x = cos * x     - sin * y;
		y = sin * tempX + cos * y;
		return this;
	}

	public Vector3 rotate(Vector3 result, float radians){
		//TODO implement
		result = initializeIfNull(result);
		float cos = FMath.cos(radians);
		float sin = FMath.sin(radians);
		result.x = cos * x - sin * y;
		result.y = sin * x + cos * y;
		return result;
	}

	public Vector3 setLengthThis(float length){
		//TODO TEST
		normalizeThis();
		x *= length;
		y *= length;
		z *= length;
		return this;
	}

	public Vector3 setLength(Vector3 result, float length){
		//TODO TEST
		result = initializeIfNull(result);
		normalized(result);
		result.multThis(length);
		return result;
	}

	public Vector3 rotate90ClockwiseThis(){
		//TODO TEST
		float temp = x;
		x = -y;
		y = temp;
		return this;
	}

	public Vector3 rotate90CounterclockwiseThis(){
		//TODO TEST
		float temp = x;
		x = y;
		y = -temp;
		return this;
	}

	public Vector3 rotate90Clockwise(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = -y;
		result.y = x;
		return result;
	}

	public Vector3 rotate90Counterclockwise(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = y;
		result.y = -x;
		return result;
	}

	public Vector3 absThis(){
		//TODO TEST
		x = FMath.abs(x);
		y = FMath.abs(y);
		z = FMath.abs(z);
		return this;
	}

	public Vector3 rotateAroundThis(Vector3 rotationCenter, float radians){
		//TODO implements
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

	public Vector3 rotateAround(Vector3 result, Vector3 rotationCenter, float radians){
		//TODO implement
		result = initializeIfNull(result);
		
		result.set(x, y, z);
		
		result.rotateAroundThis(rotationCenter, radians);
		return result;
	}

	public Vector3 abs(Vector3 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = FMath.abs(x);
		result.y = FMath.abs(y);
		result.z = FMath.abs(z);
		return result;
	}

	public float getMax(){
		//TODO TEST
		return FMath.max(x, y, z);
	}

	public float getMin(){
		//TODO TEST
		return FMath.min(x, y, z);
	}

	public float getAbsMax(){
		//TODO TEST
		return FMath.maxAbs(x, y, z);
	}

	public float getAbsMin(){
		//TODO TEST
		return FMath.minAbs(x, y, z);
	}

	public Vector3 clampComponentsThis(float min, float max){
		//TODO TEST
		x = FMath.clamp(x, min, max);
		y = FMath.clamp(y, min, max);
		z = FMath.clamp(z, min, max);
		return this;
	}

	public Vector3 clampComponents(Vector3 result, float min, float max){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = FMath.clamp(x, min, max);
		result.y = FMath.clamp(y, min, max);
		result.z = FMath.clamp(z, min, max);
		return result;
	}

	public float headingAngle(){
		//TODO TEST
		float angle = FMath.acos(x / length());
		if(y >= 0){
			return angle;
		}else{
			return FMath.PI * 2 - angle;
		}
	}

	public Vector3 setX(float x){
		//TODO TEST
		this.x = x;
		return this;
	}
	public Vector3 setY(float y){
		//TODO TEST
		this.y = y;
		return this;
	}
	public Vector3 setZ(float z){
		//TODO TEST
		this.z = z;
		return this;
	}
	public Vector3 setXY(float x, float y){
		//TODO TEST
		this.x = x;
		this.y = y;
		return this;
	}
	public Vector3 setXY(Vector2 xy){
		//TODO TEST
		return setXY(xy.getX(), xy.getY());
	}
	public Vector3 setXZ(float x, float z){
		//TODO TEST
		this.x = x;
		this.z = z;
		return this;
	}
	public Vector3 setXZ(Vector2 xz){
		//TODO TEST
		return setXZ(xz.getX(), xz.getY());
	}
	public Vector3 setYZ(float y, float z){
		//TODO TEST
		this.y = y;
		this.z = z;
		return this;
	}
	public Vector3 setYZ(Vector2 yz){
		//TODO TEST
		return setYZ(yz.getX(), yz.getY());
	}
	public Vector3 set(float x, float y, float z){
		//TODO TEST
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	public Vector3 set(Vector3 other){
		//TODO TEST
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
		return this;
	}
	public float getX(){
		//TODO TEST
		return x;
	}
	public float getY(){
		//TODO TEST
		return y;
	}
	public float getZ(){
		//TODO TEST
		return z;
	}
	public Vector2 getXY(Vector2 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.setX(x);
		result.setY(y);
		return result;
	}
	public Vector2 getXZ(Vector2 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.setX(x);
		result.setY(z);
		return result;
	}
	public Vector2 getYZ(Vector2 result){
		//TODO TEST
		result = initializeIfNull(result);
		result.setX(y);
		result.setY(z);
		return result;
	}

	public Vector3 addXThis(float val){
		//TODO TEST
		this.x += val;
		return this;
	}

	public Vector3 addYThis(float val){
		//TODO TEST
		this.y += val;
		return this;
	}
	
	public Vector3 addZThis(float val){
		//TODO TEST
		this.z += val;
		return this;
	}

	public Vector3 addXYThis(float x, float y){
		//TODO TEST
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector3 addXYThis(Vector3 other){
		//TODO TEST
		addXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 addXYThis(Vector2 other){
		//TODO TEST
		addXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 addXZThis(float x, float z){
		//TODO TEST
		this.x += x;
		this.z += z;
		return this;
	}
	
	public Vector3 addXZThis(Vector3 other){
		//TODO TEST
		addXZThis(other.x, other.z);
		return this;
	}
	
	public Vector3 addXZThis(Vector2 other){
		//TODO TEST
		addXZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 addYZThis(float y, float z){
		//TODO TEST
		this.y += y;
		this.z += z;
		return this;
	}
	
	public Vector3 addYZThis(Vector3 other){
		//TODO TEST
		addYZThis(other.getY(), other.getZ());
		return this;
	}
	
	public Vector3 addYZThis(Vector2 other){
		//TODO TEST
		addYZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 addThis(float x, float y, float z){
		//TODO TEST
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}
	
	public Vector3 addThis(Vector3 other){
		//TODO TEST
		this.x += other.x;
		this.y += other.y;
		this.z += other.z;
		return this;
	}
	
	public Vector3 addThis(Vector2 xy, float z){
		//TODO TEST
		this.x += xy.getX();
		this.y += xy.getY();
		this.z += z;
		return this;
	}
	
	public Vector3 addThis(float x, Vector2 yz){
		//TODO TEST
		this.x += x;
		this.y += yz.getX();
		this.z += yz.getY();
		return this;
	}

	public Vector3 addX(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x + val;
		result.y = y;
		result.z = z;
		return result;
	}

	public Vector3 addY(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y + val;
		result.z = z;
		return result;
	}
	
	public Vector3 addZ(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y;
		result.z = z + val;
		return result;
	}

	public Vector3 addXY(Vector3 result, float x, float y){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x + x;
		result.y = this.y + y;
		result.z = this.z;
		return result;
	}

	public Vector3 addXY(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		addXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 addXY(Vector3 result, Vector2 other){
		//TODO TEST
		result = initializeIfNull(result);
		addXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 addXZ(Vector3 result, float x, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x + x;
		result.y = this.y;
		result.z = this.z + z;
		return result;
	}
	
	public Vector3 addXZ(Vector3 result, Vector3 other){
		//TODO TEST
		return addXZ(result, other.getX(), other.getZ());
	}
	
	public Vector3 addXZ(Vector3 result, Vector2 other){
		//TODO TEST
		return addXZ(result, other.getX(), other.getY());
	}
	
	public Vector3 addYZ(Vector3 result, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = this.y + y;
		result.z = this.z + z;
		return result;
	}
	
	public Vector3 addYZ(Vector3 result, Vector3 other){
		//TODO TEST
		return addYZ(result, other.getY(), other.getZ());
	}
	
	public Vector3 addYZ(Vector3 result, Vector2 other){
		//TODO TEST
		return addYZ(result, other.getX(), other.getY());
	}
	
	public Vector3 add(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x + other.x;
		result.y = this.y + other.y;
		result.z = this.z + other.z;
		return this;
	}
	
	public Vector3 add(Vector3 result, float x, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x + x;
		result.y = this.y + y;
		result.z = this.z + z;
		return this;
	}
	
	public Vector3 add(Vector3 result, Vector2 xy, float z){
		//TODO TEST
		return add(result, xy.getX(), xy.getY(), z);
	}
	
	public Vector3 add(Vector3 result, float x, Vector2 yz){
		//TODO TEST
		return add(result, x, yz.getX(), yz.getY());
	}
	
	public Vector3 subXThis(float val){
		//TODO TEST
		this.x -= val;
		return this;
	}

	public Vector3 subYThis(float val){
		//TODO TEST
		this.y -= val;
		return this;
	}
	
	public Vector3 subZThis(float val){
		//TODO TEST
		this.z -= val;
		return this;
	}

	public Vector3 subXYThis(float x, float y){
		//TODO TEST
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector3 subXYThis(Vector3 other){
		//TODO TEST
		subXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 subXYThis(Vector2 other){
		//TODO TEST
		subXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 subXZThis(float x, float z){
		//TODO TEST
		this.x -= x;
		this.z -= z;
		return this;
	}
	
	public Vector3 subXZThis(Vector3 other){
		//TODO TEST
		subXZThis(other.x, other.z);
		return this;
	}
	
	public Vector3 subXZThis(Vector2 other){
		//TODO TEST
		subXZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 subYZThis(float y, float z){
		//TODO TEST
		this.y -= y;
		this.z -= z;
		return this;
	}
	
	public Vector3 subYZThis(Vector3 other){
		//TODO TEST
		subYZThis(other.getY(), other.getZ());
		return this;
	}
	
	public Vector3 subYZThis(Vector2 other){
		//TODO TEST
		subYZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 subThis(float x, float y, float z){
		//TODO TEST
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}
	
	public Vector3 subThis(Vector3 other){
		//TODO TEST
		this.x -= other.x;
		this.y -= other.y;
		this.z -= other.z;
		return this;
	}
	
	public Vector3 subThis(Vector2 xy, float z){
		//TODO TEST
		this.x -= xy.getX();
		this.y -= xy.getY();
		this.z -= z;
		return this;
	}
	
	public Vector3 subThis(float x, Vector2 yz){
		//TODO TEST
		this.x -= x;
		this.y -= yz.getX();
		this.z -= yz.getY();
		return this;
	}

	public Vector3 subX(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x - val;
		result.y = y;
		result.z = z;
		return result;
	}

	public Vector3 subY(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y - val;
		result.z = z;
		return result;
	}
	
	public Vector3 subZ(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y;
		result.z = z - val;
		return result;
	}

	public Vector3 subXY(Vector3 result, float x, float y){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x - x;
		result.y = this.y - y;
		result.z = this.z;
		return result;
	}

	public Vector3 subXY(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		subXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 subXY(Vector3 result, Vector2 other){
		//TODO TEST
		result = initializeIfNull(result);
		subXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 subXZ(Vector3 result, float x, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x - x;
		result.y = this.y;
		result.z = this.z - z;
		return result;
	}
	
	public Vector3 subXZ(Vector3 result, Vector3 other){
		//TODO TEST
		return subXZ(result, other.getX(), other.getZ());
	}
	
	public Vector3 subXZ(Vector3 result, Vector2 other){
		//TODO TEST
		return subXZ(result, other.getX(), other.getY());
	}
	
	public Vector3 subYZ(Vector3 result, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = this.y - y;
		result.z = this.z - z;
		return result;
	}
	
	public Vector3 subYZ(Vector3 result, Vector3 other){
		//TODO TEST
		return subYZ(result, other.getY(), other.getZ());
	}
	
	public Vector3 subYZ(Vector3 result, Vector2 other){
		//TODO TEST
		return subYZ(result, other.getX(), other.getY());
	}
	
	public Vector3 sub(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x - other.x;
		result.y = this.y - other.y;
		result.z = this.z - other.z;
		return this;
	}
	
	public Vector3 sub(Vector3 result, float x, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x - x;
		result.y = this.y - y;
		result.z = this.z - z;
		return this;
	}
	
	public Vector3 sub(Vector3 result, Vector2 xy, float z){
		//TODO TEST
		return add(result, xy.getX(), xy.getY(), z);
	}
	
	public Vector3 sub(Vector3 result, float x, Vector2 yz){
		//TODO TEST
		return add(result, x, yz.getX(), yz.getY());
	}

	public Vector3 divXThis(float val){
		//TODO TEST
		this.x /= val;
		return this;
	}

	public Vector3 divYThis(float val){
		//TODO TEST
		this.y /= val;
		return this;
	}
	
	public Vector3 divZThis(float val){
		//TODO TEST
		this.z /= val;
		return this;
	}

	public Vector3 divXYThis(float x, float y){
		//TODO TEST
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector3 divXYThis(Vector3 other){
		//TODO TEST
		divXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 divXYThis(Vector2 other){
		//TODO TEST
		divXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 divXZThis(float x, float z){
		//TODO TEST
		this.x /= x;
		this.z /= z;
		return this;
	}
	
	public Vector3 divXZThis(Vector3 other){
		//TODO TEST
		divXZThis(other.x, other.z);
		return this;
	}
	
	public Vector3 divXZThis(Vector2 other){
		//TODO TEST
		divXZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 divYZThis(float y, float z){
		//TODO TEST
		this.y /= y;
		this.z /= z;
		return this;
	}
	
	public Vector3 divYZThis(Vector3 other){
		//TODO TEST
		divYZThis(other.getY(), other.getZ());
		return this;
	}
	
	public Vector3 divYZThis(Vector2 other){
		//TODO TEST
		divYZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 divThis(float x, float y, float z){
		//TODO TEST
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}
	
	public Vector3 divThis(Vector3 other){
		//TODO TEST
		this.x /= other.x;
		this.y /= other.y;
		this.z /= other.z;
		return this;
	}
	
	public Vector3 divThis(Vector2 xy, float z){
		//TODO TEST
		this.x /= xy.getX();
		this.y /= xy.getY();
		this.z /= z;
		return this;
	}
	
	public Vector3 divThis(float scalar){
		//TODO TEST
		this.x /= scalar;
		this.y /= scalar;
		this.z /= scalar;
		return this;
	}
	
	public Vector3 divThis(float x, Vector2 yz){
		//TODO TEST
		this.x /= x;
		this.y /= yz.getX();
		this.z /= yz.getY();
		return this;
	}

	public Vector3 divX(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x / val;
		result.y = y;
		result.z = z;
		return result;
	}

	public Vector3 divY(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y / val;
		result.z = z;
		return result;
	}
	
	public Vector3 divZ(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y;
		result.z = z / val;
		return result;
	}

	public Vector3 divXY(Vector3 result, float x, float y){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x / x;
		result.y = this.y / y;
		result.z = this.z;
		return result;
	}

	public Vector3 divXY(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		divXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 divXY(Vector3 result, Vector2 other){
		//TODO TEST
		result = initializeIfNull(result);
		divXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 divXZ(Vector3 result, float x, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x / x;
		result.y = this.y;
		result.z = this.z / z;
		return result;
	}
	
	public Vector3 divXZ(Vector3 result, Vector3 other){
		//TODO TEST
		return divXZ(result, other.getX(), other.getZ());
	}
	
	public Vector3 divXZ(Vector3 result, Vector2 other){
		//TODO TEST
		return divXZ(result, other.getX(), other.getY());
	}
	
	public Vector3 divYZ(Vector3 result, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = this.y / y;
		result.z = this.z / z;
		return result;
	}
	
	public Vector3 divYZ(Vector3 result, Vector3 other){
		//TODO TEST
		return divYZ(result, other.getY(), other.getZ());
	}
	
	public Vector3 divYZ(Vector3 result, Vector2 other){
		//TODO TEST
		return divYZ(result, other.getX(), other.getY());
	}
	
	public Vector3 div(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x / other.x;
		result.y = this.y / other.y;
		result.z = this.z / other.z;
		return this;
	}
	
	public Vector3 div(Vector3 result, float x, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x / x;
		result.y = this.y / y;
		result.z = this.z / z;
		return this;
	}
	
	public Vector3 div(Vector3 result, Vector2 xy, float z){
		//TODO TEST
		return div(result, xy.getX(), xy.getY(), z);
	}
	
	public Vector3 div(Vector3 result, float x, Vector2 yz){
		//TODO TEST
		return div(result, x, yz.getX(), yz.getY());
	}
	
	public Vector3 div(Vector3 result, float scalar){
		return div(result, scalar, scalar, scalar);
	}

	public Vector3 multXThis(float val){
		//TODO TEST
		this.x *= val;
		return this;
	}

	public Vector3 multYThis(float val){
		//TODO TEST
		this.y *= val;
		return this;
	}
	
	public Vector3 multZThis(float val){
		//TODO TEST
		this.z *= val;
		return this;
	}

	public Vector3 multXYThis(float x, float y){
		//TODO TEST
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector3 multXYThis(Vector3 other){
		//TODO TEST
		multXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 multXYThis(Vector2 other){
		//TODO TEST
		multXYThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 multXZThis(float x, float z){
		//TODO TEST
		this.x *= x;
		this.z *= z;
		return this;
	}
	
	public Vector3 multXZThis(Vector3 other){
		//TODO TEST
		multXZThis(other.x, other.z);
		return this;
	}
	
	public Vector3 multXZThis(Vector2 other){
		//TODO TEST
		multXZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 multYZThis(float y, float z){
		//TODO TEST
		this.y *= y;
		this.z *= z;
		return this;
	}
	
	public Vector3 multYZThis(Vector3 other){
		//TODO TEST
		multYZThis(other.getY(), other.getZ());
		return this;
	}
	
	public Vector3 multYZThis(Vector2 other){
		//TODO TEST
		multYZThis(other.getX(), other.getY());
		return this;
	}
	
	public Vector3 multThis(float x, float y, float z){
		//TODO TEST
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}
	
	public Vector3 multThis(Vector3 other){
		//TODO TEST
		this.x *= other.x;
		this.y *= other.y;
		this.z *= other.z;
		return this;
	}
	
	public Vector3 multThis(Vector2 xy, float z){
		//TODO TEST
		this.x *= xy.getX();
		this.y *= xy.getY();
		this.z *= z;
		return this;
	}
	
	public Vector3 multThis(float scalar){
		//TODO TEST
		this.x *= scalar;
		this.y *= scalar;
		this.z *= scalar;
		return this;
	}
	
	public Vector3 multThis(float x, Vector2 yz){
		//TODO TEST
		this.x *= x;
		this.y *= yz.getX();
		this.z *= yz.getY();
		return this;
	}

	public Vector3 multX(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x * val;
		result.y = y;
		result.z = z;
		return result;
	}

	public Vector3 multY(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y * val;
		result.z = z;
		return result;
	}
	
	public Vector3 multZ(Vector3 result, float val){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = y;
		result.z = z * val;
		return result;
	}

	public Vector3 multXY(Vector3 result, float x, float y){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x * x;
		result.y = this.y * y;
		result.z = this.z;
		return result;
	}

	public Vector3 multXY(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		multXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 multXY(Vector3 result, Vector2 other){
		//TODO TEST
		result = initializeIfNull(result);
		multXY(result, other.getX(), other.getY());
		return result;
	}
	
	public Vector3 multXZ(Vector3 result, float x, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x * x;
		result.y = this.y;
		result.z = this.z * z;
		return result;
	}
	
	public Vector3 multXZ(Vector3 result, Vector3 other){
		//TODO TEST
		return multXZ(result, other.getX(), other.getZ());
	}
	
	public Vector3 multXZ(Vector3 result, Vector2 other){
		//TODO TEST
		return multXZ(result, other.getX(), other.getY());
	}
	
	public Vector3 multYZ(Vector3 result, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = x;
		result.y = this.y * y;
		result.z = this.z * z;
		return result;
	}
	
	public Vector3 multYZ(Vector3 result, Vector3 other){
		//TODO TEST
		return multYZ(result, other.getY(), other.getZ());
	}
	
	public Vector3 multYZ(Vector3 result, Vector2 other){
		//TODO TEST
		return multYZ(result, other.getX(), other.getY());
	}
	
	public Vector3 mult(Vector3 result, Vector3 other){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x * other.x;
		result.y = this.y * other.y;
		result.z = this.z * other.z;
		return this;
	}
	
	public Vector3 mult(Vector3 result, float x, float y, float z){
		//TODO TEST
		result = initializeIfNull(result);
		result.x = this.x * x;
		result.y = this.y * y;
		result.z = this.z * z;
		return this;
	}
	
	public Vector3 mult(Vector3 result, Vector2 xy, float z){
		//TODO TEST
		return mult(result, xy.getX(), xy.getY(), z);
	}
	
	public Vector3 mult(Vector3 result, float x, Vector2 yz){
		//TODO TEST
		return mult(result, x, yz.getX(), yz.getY());
	}
	
	public Vector3 mult(Vector3 result, float scalar){
		return mult(result, scalar, scalar, scalar);
	}

	public float dotProduct(Vector3 other){
		//TODO TEST
		return this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ();
	}

	public Vector3 crossProduct(Vector3 result, Vector3 other){
		//TODO implement
		throw new UnsupportedOperationException();
	}



	@Override
	protected Vector3 clone() {
		return new Vector3(x, y, z);
	}

	@Override
	public String toString() {
		//TODO TEST
		return "(" + x + ", " + y + ", " + z + ")";
	}

	@Override
	public int hashCode() {
		//TODO TEST
		return (int)(x * 7001 + y * 1009 + z * 8819);
	}

	@Override
	protected final void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public boolean equals(Object obj) {
		//TODO TEST
		if(!(obj instanceof Vector3)){
			return false;
		}
		if(obj == this) return true;
		Vector3 other = (Vector3)obj;
		return other.x == this.x && other.y == this.y && other.z == this.z;
	}
}
