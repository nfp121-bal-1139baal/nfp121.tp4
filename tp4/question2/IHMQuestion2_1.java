package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
public class IHMQuestion2_1 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);
    private boolean testSouris = false;
 
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); 
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();

        add("North", enHaut);
        add("Center", contenu); 
        if (testSouris)
            enHaut.setBackground(Color.magenta);
        else
            enHaut.setBackground(Color.blue);

        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3
        boutonA.addActionListener(new JButtonObserver("JButon1", contenu));
        boutonA.addActionListener(new JButtonObserver("JButon2", contenu));
        boutonA.addActionListener(new JButtonObserver("JButon3", contenu));
        
        // le bouton B a 2 observateurs jbo1 et jbo2
        boutonB.addActionListener(new JButtonObserver("JButton 2", contenu));
        boutonB.addActionListener(new JButtonObserver("JButton2.2", contenu));

        // le bouton C a 1 observateur jbo1
        boutonC.addActionListener(new JButtonObserver("JButton1", contenu));

        if (testSouris) {
     
            boutonA.addMouseListener(new JMouseObserver("JMouse 1", contenu));
          
            boutonB.addMouseListener(new JMouseObserver("JMouse 2", contenu));
          
            boutonC.addMouseListener(new JMouseObserver(" JMouse 3", contenu)); 
        }

      
    }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}
