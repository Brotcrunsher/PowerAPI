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
		this(0, 0, 0, 1);
	}
	
	public Color(float r){
		this(r, 0, 0, 1);
	}
	
	public Color(float r, float g){
		this(r, g, 0, 1);
	}
	
	public Color(Vector2 rg){
		this(rg.getX(), rg.getY(), 0, 1);
	}
	
	public Color(float r, float g, float b){
		this(r, g, b, 1);
	}
	
	public Color(Vector2 rg, float b){
		this(rg.getX(), rg.getY(), b, 1);
	}
	
	public Color(float r, Vector2 gb){
		this(r, gb.getX(), gb.getY());
	}
	
	public Color(Vector2 rg, float b, float a){
		this(rg.getX(), rg.getY(), b, a);
	}
	
	public Color(float r, Vector2 gb, float a){
		this(r, gb.getX(), gb.getY(), a);
	}
	
	public Color(float r, float g, Vector2 ba){
		this(r, g, ba.getX(), ba.getY());
	}
	
	public Color(Vector2 rg, Vector2 ba){
		this(rg.getX(), rg.getY(), ba.getX(), ba.getY());
	}
	
	public Color(java.awt.Color color){
		this(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
	}
	
	public Color(Color other){
		this(other.getR(), other.getG(), other.getB(), other.getA());
	}
	
	public Color(float r, float g, float b, float a){
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public float getR(){
		return r;
	}
	public float getG(){
		return g;
	}
	public float getB(){
		return b;
	}
	public float getA(){
		return a;
	}
	
	public void setR(float r){
		this.r = r;
	}
	public void setG(float g){
		this.g = g;
	}
	public void setB(float b){
		this.b = b;
	}
	public void setA(float a){
		this.a = a;
	}
	
	
	@Override
	protected Color clone(){
		return new Color(getR(), getG(), getB(), getA());
	}
	
	@Override
	public boolean equals(Object obj) {
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
		return "(" + r + ", " + g + ", " + b + ", " + a + ")";
	}
}
