package tku1b.test2;
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

public class Test2Panel extends JPanel implements ActionListener, ItemListener{
    private DrawPanel draw;
    private JPanel topPanel;
    private JPanel bottomPanel;
    
    private JPanel shapePanel;
    private JButton randgen;
    private JButton rect;
    private JButton oval;
    private JButton circle3;
    
    private JPanel actionPanel;
    private JButton clear;
    private JButton undo;
    private JButton redo;
    
    private JButton colorResetButton;
    private JButton color1Button;
    private JButton color2Button;
    private JButton color3Button;
    
    private Color color1;
    private Color color2;
    private Color color3;

    private final int RECT = 1;
    private final int OVAL = 2;
    private final int CIRCLE3 = 3;

    private int MAX = 50;
	
    public Test2Panel(){
       super();
       this.setLayout(new BorderLayout());
       draw = new DrawPanel(MAX);
       add(draw, BorderLayout.CENTER);
       topPanel= new JPanel();
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
       
       colorResetButton = new JButton("ColorReset");
       topPanel.add(colorResetButton);
       colorResetButton.addActionListener(this);
       
       Icon colorIcon = new ImageIcon( getClass().getResource( "color.png" ) );
       color1Button = new JButton("C1",colorIcon);
       topPanel.add(color1Button);
       color1Button.addActionListener(this);

       color2Button = new JButton("C2",colorIcon);
       topPanel.add(color2Button);
       color2Button.addActionListener(this);    

       color3Button = new JButton("C3",colorIcon);
       topPanel.add(color3Button);
       color3Button.addActionListener(this);    

       shapePanel = new JPanel(new GridLayout(2,3));
       randgen = new JButton("Randgen");
       shapePanel.add(randgen);
       randgen.addActionListener(this);
       rect = new JButton("Rect");
       rect.addActionListener(this);
       shapePanel.add(rect);
       oval = new JButton("Oval");
       oval.addActionListener(this);
       shapePanel.add(oval);
       circle3 = new JButton("Circle3");
       circle3.addActionListener(this);
       shapePanel.add(circle3);
       
       topPanel.add(shapePanel);
       
       add(topPanel, BorderLayout.NORTH);
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
                   Test2Panel.this, "Choose a color", color1 );
    	   color1Button.setBackground(color1);
    	   draw.setColor1(color1);
    	   
       }else if(e.getSource()==color2Button){
    	   color2 = JColorChooser.showDialog( 
                   Test2Panel.this, "Choose a color", color2 );
    	   color2Button.setBackground(color2);
    	   draw.setColor2(color2);
       }else if(e.getSource()==color3Button){
    	   color3 = JColorChooser.showDialog( 
                   Test2Panel.this, "Choose a color", color3 );
    	   color3Button.setBackground(color3);
    	   draw.setColor3(color3);
       }else if(e.getSource()==colorResetButton){
    	   color1Button.setBackground(Color.WHITE);    	   
    	   color2Button.setBackground(Color.WHITE);
    	   color3Button.setBackground(Color.WHITE);
       }else if(e.getSource()==rect){
    	  draw.setShapeType(RECT); 
       }else if(e.getSource()==oval){
    	  draw.setShapeType(OVAL); 
       }
       else if(e.getSource()==circle3){
     	  draw.setShapeType(CIRCLE3); 
        }
    }
    
    public void itemStateChanged( ItemEvent e )
    {

    } // end method itemStateChanged
    

}
