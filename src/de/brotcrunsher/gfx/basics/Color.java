package de.brotcrunsher.gfx.basics;

import de.brotcrunsher.math.linear.Vector2;

public class Color {
	public static final Color WHITE  = new Color(1, 1, 1, 1);
	public static final Color BLACK  = new Color(0, 0, 0, 1);
	public static final Color RED    = new Color(1, 0, 0, 1);
	public static final Color GREEN  = new Color(0, 1, 0, 1);
	public static final Color BLUE   = new Color(0, 0, 1, 1);
	public static final Color YELLOW = new Color(1, 1, 0, 1);
	public static final Color PINK   = new Color(1, 0, 1, 1);
	public static final Color CYAN   = new Color(0, 1, 1, 1);
	
	public static final Color AWT_BLACK      = new Color(java.awt.Color.BLACK     );
	public static final Color AWT_BLUE       = new Color(java.awt.Color.BLUE      );
	public static final Color AWT_CYAN       = new Color(java.awt.Color.CYAN      );
	public static final Color AWT_DARK_GRAY  = new Color(java.awt.Color.DARK_GRAY );
	public static final Color AWT_GRAY       = new Color(java.awt.Color.GRAY      );
	public static final Color AWT_GREEN      = new Color(java.awt.Color.GREEN     );
	public static final Color AWT_LIGHT_GRAY = new Color(java.awt.Color.LIGHT_GRAY);
	public static final Color AWT_MAGENTA    = new Color(java.awt.Color.MAGENTA   );
	public static final Color AWT_ORANGE     = new Color(java.awt.Color.ORANGE    );
	public static final Color AWT_PINK       = new Color(java.awt.Color.PINK      );
	public static final Color AWT_RED        = new Color(java.awt.Color.RED       );
	public static final Color AWT_WHITE      = new Color(java.awt.Color.WHITE     );
	public static final Color AWT_YELLOW     = new Color(java.awt.Color.YELLOW    );
	
	
	
	private float r;
	private float g;
	private float b;
	private float a;
	
	
	public Color(){
		//TESTED
		this(0, 0, 0, 1);
	}
	
	public Color(float r){
		//TESTED
		this(r, 0, 0, 1);
	}
	
	public Color(float r, float g){
		//TESTED
		this(r, g, 0, 1);
	}
	
	public Color(Vector2 rg){
		//TESTED
		this(rg.getX(), rg.getY(), 0, 1);
	}
	
	public Color(float r, float g, float b){
		//TESTED
		this(r, g, b, 1);
	}
	
	public Color(Vector2 rg, float b){
		//TESTED
		this(rg.getX(), rg.getY(), b, 1);
	}
	
	public Color(float r, Vector2 gb){
		//TESTED
		this(r, gb.getX(), gb.getY());
	}
	
	public Color(Vector2 rg, float b, float a){
		//TESTED
		this(rg.getX(), rg.getY(), b, a);
	}
	
	public Color(float r, Vector2 gb, float a){
		//TESTED
		this(r, gb.getX(), gb.getY(), a);
	}
	
	public Color(float r, float g, Vector2 ba){
		//TESTED
		this(r, g, ba.getX(), ba.getY());
	}
	
	public Color(Vector2 rg, Vector2 ba){
		//TESTED
		this(rg.getX(), rg.getY(), ba.getX(), ba.getY());
	}
	
	public Color(java.awt.Color color){
		//TESTED
		this(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
	}
	
	public Color(Color other){
		//TESTED
		this(other.getR(), other.getG(), other.getB(), other.getA());
	}
	
	public Color(float r, float g, float b, float a){
		//TESTED
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public float getR(){
		//TESTED
		return r;
	}
	public float getG(){
		//TESTED
		return g;
	}
	public float getB(){
		//TESTED
		return b;
	}
	public float getA(){
		//TESTED
		return a;
	}
	
	public void setR(float r){
		//TESTED
		this.r = r;
	}
	public void setG(float g){
		//TESTED
		this.g = g;
	}
	public void setB(float b){
		//TESTED
		this.b = b;
	}
	public void setA(float a){
		//TESTED
		this.a = a;
	}
	
	public void standardize(){
		float max = r;
		if(g > max) max = g;
		if(b > max) max = b;
		if(a > max) max = a;
		
		if(max == 0){
			r = g = b = a = 1;
		}
		else{
			r /= max;
			g /= max;
			b /= max;
			a /= max;
		}
	}
	
	@Override
	protected Color clone(){
		return new Color(getR(), getG(), getB(), getA());
	}
	
	@Override
	public boolean equals(Object obj) {
		//TESTED
		if(!(obj instanceof Color)){
			return false;
		}
		if(obj == this){
			return true;
		}
		
		Color other = (Color)obj;
		return other.getR() == this.getR() && other.getG() == this.getG() && other.getB() == this.getB() && other.getA() == this.getA();
	}
	
	@Override
	protected final void finalize() throws Throwable {
		super.finalize();
	}
	
	@Override
	public int hashCode() {
		return (int)(r * 1009 + g * 2591 + b * 4397 + a * 6619);
	}
	
	@Override
	public String toString() {
		//TESTED
		return "(" + r + ", " + g + ", " + b + ", " + a + ")";
	}
}
