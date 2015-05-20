package tku1b.painter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Oval extends Shape{
	   public Oval(int x1, int y1, int x2, int y2, Color color1, Color color2, boolean filled){
		      super(x1,y1,x2,y2,color1, color2,filled);
		   }   
		   
    public void draw(Graphics g){
       Graphics2D g2d = ( Graphics2D ) g;
       if(gradient){
          g2d.setPaint( new GradientPaint( 5, 30, color1, 35, 100, color2, true ));  
       }else
         g2d.setPaint(color1);
       g2d.setStroke( new BasicStroke( 10.0f ) ); 
       if(filled)
         g2d.fillOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
       else 
         g2d.drawOval(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
    }
}
