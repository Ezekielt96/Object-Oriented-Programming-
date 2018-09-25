//Ray Klump
// This program simulates rolling two 6-sided dice
 import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.Timer;

//Worked on the program 3/23/2017 it is 11:23 PM
//Added the menu buttons and roll dice from the space bar 
//need to figure out how to change color of Dice through the menu and by pressing RGB
// need to figure out how to change size of dice when the user selects sizes from menu
//Record how many times the dice is rolled 
//reset total roll 

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Ezekiel Towner 
 //I'm suppose to make enhancements to the program 
//This was a very hard program to do because it was hard to know where to put some enhancements 
// I have an idea how to do it but my coding skills aren't experienced enough to translate my ideas 
//into JAva code :(
//luckily i got some help



class Die {
    private int value;
    private int x;
    private int y;
    public int getValue() {
        return value;
    }
    public void setValue(int v) {
        if (v < 1) {
            value = 1;
        } else if (v > 6) {
            value = 6;
        } else {
            value = v;
        }
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }
    public Die() {
        value = 1;
        x = 0;
        y = 0;
    }
    public Die(int v, int x, int y) {
        setValue(v);
        setX(x);
        setY(y);
    }
    public String toString() {
        return String.format("%d %d %d",value,x,y);
    }
}
 
/* 
The DiceManager class is a controller class. It stores two Die objects
and helps us roll them. To roll them, we need to adjust the value and
the position coordinate of the two Die.
The DiceManager makes sure the the die are rolled on a playing board of
set dimensions - rollWidth and rollHeight
*/

// THIS PROGRAM WAS SUPER HARD TO UNDERSTAND 
//
class DiceManager {
    private Die firstDie; 
    private Die secondDie;
    private int rollWidth;
    private int rollHeight;
    private Random rnd;
    public DiceManager() {
        rnd = new Random();
        firstDie = new Die();
        secondDie = new Die();
    }
    public DiceManager(int rw, int rh) {
        this();  // calls the default constructor
        setRollWidth(rw);
        setRollHeight(rh);
    }
    public int getRollWidth() {
        return rollWidth;
    }
    public void setRollWidth(int rw) {
        if (rw < 100) {
            rollWidth = 100;
        } else {
            rollWidth = rw;
        }
    }
    public int getRollHeight() {
        return rollHeight;
    }
    public void setRollHeight(int rh) {
        if (rh < 100) {
            rollHeight = 100;
        } else {
            rollHeight = rh;
        }
    }
    /* the following several functions help us learn what was actually rolled */
    public Die getFirstDie() {
        return firstDie;
    }
    public Die getSecondDie() {
        return secondDie;
    }
    public Die[] getDice() {
        Die[] result = new Die[2];
        result[0] = firstDie;
        result[1] = secondDie;
        return result;
    }
    public int getTotalRoll() {
        return firstDie.getValue() + secondDie.getValue();
    }
    public void rollDice() {
        rollDie(firstDie);
        rollDie(secondDie);
        
    }
    
 
    
    public void rollDie(Die theDie) {
        theDie.setValue(1 + rnd.nextInt(6));
        theDie.setX(rnd.nextInt(rollWidth));
        theDie.setY(rnd.nextInt(rollHeight));
    }
    public String toString() {
        return String.format("Die 1: %s   Die 2: %s",firstDie.toString(), secondDie.toString());
    }
}
class DiceDrawer { //drAWS THE DICE 
    private Font font;
    private int dieSize;
    // length of each side of the die
    private Color color;
    
    public DiceDrawer(Font f, int ds) {
        font = f;
        setDieSize(ds);
    }
    public void setDieSize(int ds) {
        if (ds < 20) {
            dieSize = 20;
        } else {
            dieSize = ds;
        }
    }
    public int getDieSize() {
        return dieSize;
    }
    public void Large(){
    	dieSize = 65;
    }
    public void Medium(){
    	dieSize = 45;
    }
    public void Small(){
    	dieSize = 25;
    }
    
    
    public void drawDice(Die[] dice, JPanel pan, Color outline ) {
        Graphics g = pan.getGraphics();
        g.setFont(font);
        g.setColor(outline);      
        FontMetrics fm = g.getFontMetrics(); 
        int textX, textY;
        for (Die d : dice) {
            g.drawRect(d.getX(),d.getY(),dieSize,dieSize);
            textX = d.getX() + dieSize / 2 - fm.stringWidth(String.valueOf(d.getValue()))/2;
            textY = d.getY() + dieSize / 2 + fm.getAscent() / 2;
            g.drawString(String.valueOf(d.getValue()),textX,textY);
        }
    }
}

class DiceFrame extends JFrame implements KeyListener, ActionListener {
    private ArrayList<Die> Dices ;
    private DiceManager dman;
    private DiceDrawer drawer;
    private JPanel panDice;
    private Font dieFont;
    private Color RGB; //to change colors of dice
    private Timer tim;// for thee auto Roll function
    private int totalRoll;
    
   
    public void actionPerformed(ActionEvent e) {
    	dman.rollDice();
        repaint();
    }
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_SPACE){
    		dman.rollDice(); // allows the user to use spacebar to roll dice 
    	} 
    	else if (e.getKeyCode() == KeyEvent.VK_R){
    		RGB = Color.RED; //Changes colors of dice to red 
    			repaint();	
    		
    	}
    	
    	else if (e.getKeyCode() == KeyEvent.VK_G){
    		RGB = Color.GREEN; //Changes color of Dice to green 
    		repaint();
    	}
    	
    	else if (e.getKeyCode() == KeyEvent.VK_B){
    		RGB = Color.BLUE; // Changes color of Dice to Blue 
    		repaint();
    		
    	}
    		 //3-24-17 Friday 
    	}
    	//note must make multiple menu classes 
    public void setupMenu() {
    	JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File"); //FILE
        JMenu mnuSize = new JMenu("Size");//SIZE
        JMenu mnuColor = new JMenu("Color");//COLOR
        JMenu mnuAR = new JMenu("Auto Roll");//AUTOROLL
        JMenuItem miExit = new JMenuItem("Exit");//allows user to exit the program 
        JMenuItem Large =  new JMenuItem("Large");
        JMenuItem Medium =  new JMenuItem("Medium");
        JMenuItem Small =  new JMenuItem("Small");
        JMenuItem R = new JMenuItem ("Red");
        JMenuItem G = new JMenuItem ("Green");
        JMenuItem B = new JMenuItem ("Blue");
        JMenuItem RE= new JMenuItem("Reset");
        JMenuItem SR= new JMenuItem ("SaveRolls"); 
        JMenuItem RO = new JMenuItem ("Roll Dice");
        JMenuItem AR = new JMenuItem("Auto Roll");
        JMenuItem ST = new JMenuItem ("Stop");
        
        miExit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                   }
                    
                    
                   
                }
            );
        RO.addActionListener( //RollDice 
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
                        dman.rollDice();
                        repaint();
                   }
        	
        			
        		});
        Large.addActionListener(//Choose size to large 
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				drawer.Large();
        				repaint();
        			}
        		}
        );
        Medium.addActionListener( //choose size to medium
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				drawer.Medium();
        				repaint();
        			}
        		}
        );
        Small.addActionListener(//choose size to medium 
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				drawer.Small();
        				repaint();
        			}
        		}
        );
        
        
        
        R.addActionListener( //Changes color to red 
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				RGB=Color.RED;
        				repaint();
        				
        				
        				
        			}
        			
        			
        		});
        G.addActionListener( //changes color to green
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				RGB=Color.GREEN;
        				repaint();
        				
        				
        				
        			}
        			
        			
        		});
        B.addActionListener( //changes color to blue 
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				RGB=Color.BLUE;
        				repaint();
        				
        				
        				
        			}
        			
        			
        		});
        AR.addActionListener( //auto roll function 
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				dman.rollDice();
        				tim.start();
        				repaint();
        				
        				
        				
        			}
        			
        			
        		});
        ST.addActionListener( //stops the auto roll
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				dman.rollDice();
        				tim.stop();
        				repaint();
        				
        				
        				
        			}
        			
        			
        		});
        
        
      //ADDS THE BUTTONS TO THE MENU BAR 
        
        mnuFile.add(miExit);
        mnuFile.add(RE);
        mnuFile.add(SR);
        mnuFile.add(RO);
        mbar.add(mnuFile);
        mbar.add(mnuSize);
        mbar.add(mnuColor);
        mbar.add(mnuAR);
        mnuSize.add(Large);
        mnuSize.add(Medium);
        mnuSize.add(Small);
        mnuColor.add(R);
        mnuColor.add(G);
        mnuColor.add(B);
        setJMenuBar(mbar);
        mnuAR.add(AR);
        mnuFile.add(miExit);
        mbar.add(mnuFile);
        mnuAR.add(ST);
        
    }
    public DiceFrame() {
        setupMenu();
        dman = new DiceManager(350,650);   // composition
        dman.rollDice();
        dieFont = new Font("Arial",Font.BOLD,18);
        drawer = new DiceDrawer(dieFont,25);
        tim = new Timer(1000,this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,500,500);
        setTitle("Vegas Baby Vegas");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        panDice = new JPanel();
        c.add(panDice,BorderLayout.CENTER);
        JPanel panButton = new JPanel();
        JButton btnRoll = new JButton("Roll Dice");
        btnRoll.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // tell a DiceManager to roll the dice
                    // force a repaint
                    dman.rollDice();
                    repaint();
                }
            }
        );
        panButton.add(btnRoll);
        c.add(panButton,BorderLayout.SOUTH);
        addKeyListener(this);
        setFocusable(true);
    }
    public void paint(Graphics g) {
        super.paint(g);
        drawer.drawDice(dman.getDice(), panDice,RGB);
    }
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//MAIN METHOD 
public class DieRoll_Towner {
    public static void main(String[] args) {
/*      DiceManager dman = new DiceManager(500,500);
        for (int i = 0; i < 10; i++) {
            dman.rollDice();
            System.out.println(dman);
        }
*/
        DiceFrame df = new DiceFrame();
        df.setVisible(true);
        
    }
}
