
package ödev.son.fatih;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class undoredo extends JFrame{
    JPanel panel;
    JButton btn1,btn2,btn3;
    JScrollPane pane;
    JTextArea area;
    
    UndoManager ig = new UndoManager();
    
    public undoredo(){
        panel = new JPanel();
        pane = new JScrollPane();
        btn1 = new JButton("italik");
        btn2 = new JButton("bold");
        btn3 = new JButton("backround color");
        area = new JTextArea(5,48);
    
        
        
        area.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == 25){
                    ig.redo();
                }
                if(e.getKeyChar()== 26){
                    ig.undo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setFont(new Font("italic",Font.ITALIC,18));
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setFont(new Font("bold",Font.BOLD,20));
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setBackground(Color.yellow);
            }
        });
        area.getDocument().addUndoableEditListener(new UndoableEditListener(){
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                ig.addEdit(e.getEdit());
            }
            
        });
     
        panel.add(pane);
        panel.add(area);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        
      
        add(panel);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
    

}
