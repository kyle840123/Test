package tku1b.test2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener{
    private Shape shapes[];
    private Shape currentShape;
    private int MAX;
    private int numShapes;
    private int x1, y1, x2, y2,x3,y3;
    private boolean filled;
    private Color color1;
    private Color color2;
    private Color color3;
    private boolean gradient;

    
    
    private int shapeType=1;
    private final int shapeCount = 3;
    private final int RECT = 1;
    private final int OVAL = 2;
    private final int CIRCLE3 = 3;
    
    Random rand;
    
    public DrawPanel(int MAX){
       this.MAX = MAX;
       shapes = new Shape[MAX];
       rand = new Random();
       color1 = Color.BLACK;
       color2 = Color.WHITE;
       color3 = Color.blue;
       
       addMouseListener(this);
       addMouseMotionListener(this);

       repaint();
    }
    
    public void setColor1(Color color1){
      this.color1 = color1;
    }
    
    public void setColor2(Color color2){
        this.color2 = color2;
      }

    public void setColor3(Color color3){
        this.color3 = color3;
      }
    
    public void randgen(int n){
       Random rand = new Random();
       Color rcolor1;
       Color rcolor2;

       for(int i=0;i<n;i++){
         
         x1 = rand.nextInt(800);
         y1 = rand.nextInt(600);
         x2 = rand.nextInt(800);
         y2 = rand.nextInt(600);
         x3 = rand.nextInt(800);
         y3 = rand.nextInt(600);
         rcolor1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
         rcolor2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
         filled = rand.nextBoolean();
         shapeType = rand.nextInt(shapeCount)+1;
         switch(shapeType){
         case RECT: 
            shapes[numShapes++] = new Rect(x1,y1,x2,y2,rcolor1,rcolor2,filled);
            break;
         case OVAL:
            shapes[numShapes++] = new Oval(x1,y1,x2,y2,rcolor1,rcolor2,filled);
            break;

         }
       }  
       repaint();
    }
    
    public void setShapeType(int shapeType){
    	this.shapeType = shapeType;
    }
    
    public void addShape(int shapeType){
        x1 = rand.nextInt(800);
        y1 = rand.nextInt(600);
        x2 = rand.nextInt(800);
        y2 = rand.nextInt(600);
        filled = rand.nextBoolean();
        switch(shapeType){
        case RECT: 
           shapes[numShapes++] = new Rect(x1,y1,x2,y2,color1,color2,filled);
           break;
        case OVAL:
           shapes[numShapes++] = new Oval(x1,y1,x2,y2,color1,color2,filled);
           break; 
        }  
        //System.out.println("Add ShapeType = "+shapeType+" ; ShapeCount ="+numShapes);

        repaint();
    }
    public void clear(){
        numShapes = 0;
        repaint();
    }
    
    public void undo(){
        numShapes--;
        repaint();
    }
    
    public void redo(){
        numShapes++;
        repaint();
    }
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      for(int i=0;i<numShapes;i++){
         shapes[i].draw(g);
      }
      if(currentShape!=null)
    	  currentShape.draw(g);
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();		
		currentShape.setX2(x2);
		if(shapeType==CIRCLE3){
		  if(y1>y2)
		    y2 = y1 - Math.abs(x1-x2);  
		  else
		    y2 = y1 + Math.abs(x1-x2);
		}
		currentShape.setY2(y2);
		System.out.printf("MouseDragged: (x1,y1)=(%d,%d), (x2,y2)=(%d,%d)\n", x1, y1, x2, y2);
		System.out.println("MouseDragged: "+ currentShape);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y1;
		switch(shapeType){
		case RECT:
			currentShape = new Rect(x1,y1,x2,y2,color1,color2,filled);
			break;
		case OVAL:
			currentShape = new Oval(x1,y1,x2,y2,color1,color2,filled);
		    break;
		case CIRCLE3:
			currentShape = new Circle3(x1,y1,x2,y2,color1,color2,color3,filled);
			System.out.println("MousePressed: "+ currentShape);
		    break;    
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		currentShape.setX2(e.getX());
//		currentShape.setY2(e.getY());
		x2 = e.getX();
		y2 = e.getY();		
		currentShape.setX2(x2);
		if(shapeType==CIRCLE3){
		  if(y1>y2)
		    y2 = y1 - Math.abs(x1-x2);  
		  else
		    y2 = y1 + Math.abs(x1-x2);
		}
		currentShape.setY2(y2);
		System.out.printf("MouseReleased: (x1,y1)=(%d,%d), (x2,y2)=(%d,%d)\n", x1, y1, x2, y2);
		System.out.println("MouseReleased: "+ currentShape);
		shapes[numShapes++] = currentShape;
		currentShape = null;
		repaint();
	}
    
    
    
}
