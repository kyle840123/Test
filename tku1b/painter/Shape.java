package tku1b.painter;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
   protected int x1, y1, x2, y2;
   protected Color color1;
   protected Color color2;
   protected boolean gradient;
   protected boolean filled;

   public Shape(int x1, int y1, int x2, int y2, Color color1, Color color2, boolean filled){
     this.x1 = x1;
     this.y1 = y1;
     this.x2 = x2;
     this.y2 = y2;
     this.color1 = color1;
     this.color2 = color2;
     this.filled = filled;
   }
   
   
   
   public int getX1() {
	return x1;
}



public void setX1(int x1) {
	this.x1 = x1;
}



public int getY1() {
	return y1;
}



public void setY1(int y1) {
	this.y1 = y1;
}



public int getX2() {
	return x2;
}



public void setX2(int x2) {
	this.x2 = x2;
}



public int getY2() {
	return y2;
}



public void setY2(int y2) {
	this.y2 = y2;
}



public Color getColor1() {
	return color1;
}



public void setColor1(Color color1) {
	this.color1 = color1;
}



public Color getColor2() {
	return color2;
}



public void setColor2(Color color2) {
	this.color2 = color2;
}



public boolean isGradient() {
	return gradient;
}



public void setGradient(boolean gradient) {
	this.gradient = gradient;
}



public boolean isFilled() {
	return filled;
}



public void setFilled(boolean filled) {
	this.filled = filled;
}



public abstract void draw(Graphics g);
}
