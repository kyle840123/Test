package tku1b.painter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PainterPanel extends JPanel implements ActionListener, ItemListener{
    private DrawPanel draw;
    private JPanel bottomPanel;
    
    private JPanel shapePanel;
    private JButton randgen;
    private JButton rect;
    private JButton oval;
    private JButton triangle;
    
    private JPanel actionPanel;
    private JButton clear;
    private JButton undo;
    private JButton redo;
    
    private JButton color1Button;
    private JButton color2Button;
    private Color color1;
    private Color color2;

    private final int RECT = 1;
    private final int OVAL = 2;

    private int MAX = 50;
	
    public PainterPanel(){
       super();
       this.setLayout(new BorderLayout());
       draw = new DrawPanel(MAX);
       add(draw, BorderLayout.CENTER);
       bottomPanel = new JPanel();
       
       actionPanel = new JPanel(new GridLayout(1,3));
       clear = new JButton("Clear");
       clear.addActionListener(this);
       actionPanel.add(clear);
       undo = new JButton("Undo");
       undo.addActionListener(this);
       actionPanel.add(undo);
       redo = new JButton("Redo");
       redo.addActionListener(this);
       actionPanel.add(redo);
       bottomPanel.add(actionPanel);
       
       shapePanel = new JPanel(new GridLayout(1,4));
       randgen = new JButton("Randgen");
       shapePanel.add(randgen);
       randgen.addActionListener(this);
       rect = new JButton("Rect");
       rect.addActionListener(this);
       shapePanel.add(rect);
       oval = new JButton("Oval");
       oval.addActionListener(this);
       shapePanel.add(oval);
       triangle = new JButton("Tri");
       triangle.addActionListener(this);
       shapePanel.add(triangle);
       
       bottomPanel.add(shapePanel);
       
       color1Button = new JButton("Color1");
       bottomPanel.add(color1Button);
       color1Button.addActionListener(this);

       color2Button = new JButton("Color2");
       bottomPanel.add(color2Button);
       color2Button.addActionListener(this);       
       add(bottomPanel, BorderLayout.SOUTH);
       
    }
    
    public void actionPerformed(ActionEvent e){
		if (e.getSource() == randgen)
          draw.randgen(10);   
       else if(e.getSource()==clear)
          draw.clear();
       else if(e.getSource()==undo)
           draw.undo();
       else if(e.getSource()==redo)
           draw.redo();
       else if(e.getSource()==color1Button){
    	   color1 = JColorChooser.showDialog( 
                   PainterPanel.this, "Choose a color", color1 );
    	   color1Button.setBackground(color1);
    	   draw.setColor1(color1);
    	   
       }else if(e.getSource()==color2Button){
    	   color2 = JColorChooser.showDialog( 
                   PainterPanel.this, "Choose a color", color2 );
    	   color2Button.setBackground(color2);
    	   draw.setColor2(color2);
       }else if(e.getSource()==rect){
    	  draw.setShapeType(RECT); 
       }else if(e.getSource()==oval){
    	  
       }
    }
    
    public void itemStateChanged( ItemEvent e )
    {

    } // end method itemStateChanged
    

}
