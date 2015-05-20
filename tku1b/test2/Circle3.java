package tku1b.test2;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle3 extends Oval{
	private Color color3;
	private int divWidth;
	
	   /**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param color1
	 * @param color2
	 * @param color3
	 * @param filled
	 */
	public Circle3(int x1, int y1, int x2, int y2, Color color1, Color color2, Color color3, boolean filled){
		    super(x1,y1,x2,y2,color1, color2, filled);
		    this.color3 = color3;		      
		   }   
		   
 public void draw(Graphics g){
    Graphics2D g2d = ( Graphics2D ) g;
    System.out.println(this);
    divWidth =  (int)Math.abs(x1-x2)/6;
    g2d.setPaint(color1);
    g2d.fillOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
    g2d.setPaint(color2);
    g2d.fillOval(Math.min(x1,x2)+divWidth,Math.min(y1,y2)+divWidth,Math.abs(x1-x2)-2*divWidth,Math.abs(y1-y2)-2*divWidth);
    g2d.setPaint(color3); 
    g2d.fillOval(Math.min(x1,x2)+2*divWidth,Math.min(y1,y2)+2*divWidth,Math.abs(x1-x2)-4*divWidth,Math.abs(y1-y2)-4*divWidth);
 }

@Override
public String toString() {
	return "Circle3 [color3=" + color3 + ", divWidth=" + divWidth + ", x1="
			+ x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", color1="
			+ color1 + ", color2=" + color2 + "]";
}
 
}
