// Fig. 25.13: JTabbedPaneFrame.java
// Demonstrating JTabbedPane.


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import tku1b.painter.PainterPanel;
import tku1b.test2.Test2Panel;


public class JTabbedPaneFrame extends JFrame  
{
   // set up GUI
   public JTabbedPaneFrame()
   {
      super( "JTabbedPane Demo " );

      JTabbedPane tabbedPane = new JTabbedPane(); // create JTabbedPane 

      // set up pane11 and add it to JTabbedPane 
      
      PainterPanel painterPanel = new PainterPanel(); // create first panel
      tabbedPane.addTab( "Painter", null, painterPanel, "First Panel" ); 
     
      // set up panel2 and add it to JTabbedPane
      Test2Panel test2Panel = new Test2Panel(); // create second panel
      tabbedPane.addTab( "Test2", null, test2Panel, "Second Panel" ); 

      add( tabbedPane ); // add JTabbedPane to frame
   } // end JTabbedPaneFrame constructor
} // end class JTabbedPaneFrame

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
