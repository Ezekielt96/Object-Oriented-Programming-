//Ezekiel Towner
//Object Oriented Programming 
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//This program creates a colored mosaic 

//Model Class
class Tile {
    private String text;
    private int shape;
    private int row;
    private int col;
    private Color background;
    private Color foreground;
     
    public Color getBackgound(){
    	return background;
    }
    public void setBackground(Color background){
    	this.background= background;
    	
    }
    public Color getForeground(){
    	return foreground;
    }
    public void setForeground(Color foreground){
     this.foreground= foreground;
    	
    }
    public int getRow(){
    	return row;
    }
    public void setRow(int row){
    	this.row= row;
    	
    }
    public int getCol(){
    	return col;
    }
    public void setCol(int col){
    	this.col= col;
    }
    
   
    
    public String getText() {
        return text;
    }
    public void setText(String str) {
        text = str;
    }
    public int getShape() {
        return shape;
    }
    public void setShape(int shape) {
        this.shape= shape;
    }
    //Default Constructor
    
    public Tile(String text, int shape, int row, int col, Color foreground,Color background) {
        setText(text);
        setShape(shape);
        setRow(row);
        setCol(col);
        setForeground(foreground);
        setBackground(background);
    }
    //to String 
    public String toString() {
        return String.format("%s %d %d %d  ",text,shape,row,col);
    }
}//Prints Array List into tostring function 
class TilePrinter{
	public void printTiles(ArrayList<Tile> tiles){
		for (Tile t : tiles) {
	         System.out.println(t);  	
		}
			
	}
		    }
	
	
//Creates Frame
	class TileFrame extends JFrame {
		private TileDrawer drawer;
		private ArrayList<Tile> tiles;
		private JPanel panCircles;
		public TileFrame(ArrayList<Tile> Tiles) {
			drawer = new TileDrawer();
			tiles = Tiles;
	        setBounds(50,50,500,500);
	        setTitle("Tile");
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        Container c = getContentPane();
	        c.setLayout(new BorderLayout());
	        panCircles = new JPanel();
	        c.add(panCircles,BorderLayout.CENTER);
	        JPanel panButton = new JPanel();
	        JButton btnRandomize = new JButton("Randomize");
	        btnRandomize.addActionListener(
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    
	                    repaint();
	                }
	            }
	        );
	        panButton.add(btnRandomize);
	        c.add(panButton,BorderLayout.SOUTH);
		}
		public void paint(Graphics g) {
	        super.paint(g);  // border, background and LW components are drawn
	        drawer.drawTiles(tiles,panCircles);
	    }
	}

	class TileDrawer {
	    private Font font;
	  
	 //TileDrawer 
	    public TileDrawer() {
	        font = new Font("Arial",Font.BOLD,25);
	     
	        
	    }	//Draw Tiles Function	
	    	public void drawTiles(ArrayList<Tile> tiles, JPanel pan) {
	            Graphics g = pan.getGraphics();
	            for (Tile t : tiles){
	            	int Tilex = t.getRow()*50; //intilize Tile Variables
	            	int Tiley = t.getCol()*50;// initilize Tile Variables 
	            	
	            	int ranShape = t.getShape();
	            	
	            	g.setFont(font);
	            	FontMetrics fm = g.getFontMetrics();//never heard of this function FontMetrics it was pretty useful
	            	g.setColor(t.getBackgound());
	            	 if (ranShape == 0) {//if Random Shape equal 0 then its a circle 
	            		 g.fillOval(Tilex,Tiley, 50, 50);
	            	 }
	            	 else {
	            		 g.fillRect(Tilex,Tiley,50,50);
	            	 }
	            	 //Figuring out the math was the hardest part of programming, so i went to the study tables to figure that part out 
	            	g.setColor(t.getForeground());
	            	 g.drawString(t.getText(),Tilex+(40/2)-fm.stringWidth(t.getText())/2,Tiley+(40/2)+(fm.getAscent()-fm.getDescent()/2));
	            	 
	            	
	            	 
	            }
	       
	    	}   	
	    
	
	}
	//THIS PROGRAM WAS SUPER HARD TO FIGURE BUT I PUT IT OFF MOST OF MY SPRINGBREAK
class TileRandomizer{
	
		private Random  rnd;
		private Tile rndTile;
		public TileRandomizer() {
		       rnd = new Random();
		       ArrayList<Tile> tiles = new ArrayList<>();
		   }
	public void  buildTile(int row, int col, ArrayList<Tile> tiles) { 
		Tile t;
			//BUILDs TILE 
			for(int a = 0; a < row; a++){
				for (int b = 0; b < col; b++){
					t = new Tile("text",0, a,b,Color.white, Color.BLACK);
					ChangeTile(t);
					tiles.add(t);
				}
			}
			//FIGURES OUT THE BACKGROUND AND FORGRPUND AND RANDOMIZES THE COLORS
		int br, bb, bg;
        int fr, fb, fg;
        br = rnd.nextInt(256);
        bg = rnd.nextInt(256);
        bb = rnd.nextInt(256);
        Color background = new Color(br,bg,bb);
        fr = (br + 128) % 256;
        fg = (bg + 128) % 256;
        fb = (bb + 128) % 256;
        Color foreground = new Color(fr,fg,fb);
    }
	
		//public Tile ChangeTile(ArrayList<Tile>tiles){
		//	return object;
			
		//
		
		public void ChangeTile(Tile t){
			Random rnd = new Random();
			int bR = rnd.nextInt(256);
			int bG= rnd.nextInt(256);
			int bB= rnd.nextInt(256);
			int fR= (bR + 128) % 256;
			int fG= (bG + 128) % 256;
			int fB=(bB + 128) % 256;
			int FindLetter = (int)'A' + rnd.nextInt((int)'z' +1 -(int)'A');
			int FindShape = rnd.nextInt(2);
			
			t.setBackground(new Color (bR,bG,bB));
			t.setForeground(new Color (fR,fG,fB));
			t.setShape(FindShape);
			t.setText(Character.toString((char)FindLetter));
			
				
			}
		public void ChangeTiles(ArrayList<Tile>tiles){
			for (Tile t: tiles){
				ChangeTile(t);
			}
		}
			
		}

 //MAINMETHOD   
public class Tiles_Towner { 
	  public static void main(String[] args){
		  
		   ArrayList<Tile> Tiles = new ArrayList<Tile>();
		   System.out.println("Hello Welcome to my program ");
		   TileRandomizer tr = new TileRandomizer();
		   TilePrinter tp = new TilePrinter();
		   tr.buildTile(10,10,Tiles);
		   tp.printTiles(Tiles);
		   
		   TileFrame tf = new TileFrame(Tiles);
		   tf.setVisible(true);
		   
		   
		   
		   
		   }

	   }

	
	
	         


	


