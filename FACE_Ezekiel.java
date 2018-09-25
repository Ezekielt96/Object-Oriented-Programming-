//Ezekiel Towner
//Object Oriented Programming CS245
//This Program Draws Faces 
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
//Model Class
class Face {
    private int x;
    private int y;
    private int width;
    private int height;
	private int w;
	private int h;
	private int ss; //smilestatus
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
		return width;		
    	
    }
    public int getHeight(){
    	return height;
    }
    public int getSS(){
    	return ss;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSS(int ss){
    	this.ss = ss;
    }
    public void setWidth(int width){
    	this.width = width;
    }
    public void setHeight(int height){
    	this.height = height;
    }
    
    public Face() {
        x = 0;
        y = 0;
        ss=0;
        width=0;
        height=0;
        
    }
    public Face(int x, int y, int width, int height,int ss) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setSS(ss);
        //ToString Function 
    }
    public String ToString(){
    	return String.format("x=&d,y=&d,ss&d,width%d,height%d",getX(),getY(),getWidth(),getHeight() );
    }
}


//This part does all the drawing 
class FacePanel extends JPanel {
    private ArrayList<Face> faces;
    public FacePanel(ArrayList<Face> faces) {
        this.faces = faces;  //aggregation
    } 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
    
        //Need to initilize the variables
        for (Face f : faces) {
        	 int eyexR; //right eye 
             int eyeXL;//left eye 
             int eyeH;//height eye
             int eyeW;//width of eye 
             int eyeY;//y cordinate 
             int mouthx;//x cordinate
             int mouthy;//y cordinate 
             int mouthh;//mouth height
             int mouthw;// mouthwidth 
             
        	//structure of the face
            g.drawOval(f.getX(),f.getY(),f.getWidth(),
                    f.getHeight());
            //Lefteye computation width of one eye
             eyeXL= (f.getX()+(int)(f.getWidth()/3));
            //Righteye computation width of one eye
            eyexR= (f.getX()+(int)(2*f.getWidth()/3));
            //eye height
            eyeH= (int)(.1* f.getHeight());
            //eye width
            eyeW=(int)(.1* f.getWidth());
            //eyeY axis
            eyeY= (f.getY()+(int)(f.getHeight()/3));
           
            //lefteye
            g.drawOval(eyeXL, eyeY, eyeW, eyeH);
           //right eye
            g.drawOval(eyexR, eyeY, eyeW,eyeH);
            
            //Draw Mouth
            if(f.getSS()==1){
            	mouthx= (f.getX()+(int)(f.getWidth()/4));
                mouthy= (f.getY()+(int)(f.getHeight()/2));
                mouthw=(int)(.5*f.getWidth());
                mouthh=(int)(.5*f.getHeight());
                g.drawArc(mouthx, mouthy, mouthw,mouthh, 0 , -180);
            }//FIGURING OUT THE MATH WAS THE HARDEST BUT I GOT HELP AT 
            //THE MATH STUDY TABLES THANKS TO LEWIS UNIVERSITY
           
            else if (f.getSS()==2){
            	mouthx= (f.getX()+(int)(f.getWidth()/4));
                mouthy= (f.getY()+(int)(f.getHeight()/2));
                mouthw=(int)(.5*f.getWidth());
                mouthh=(int)(.5*f.getHeight());
                g.drawArc(mouthx, mouthy, mouthw,mouthh, 0 , 180);
            	
            }
            else{
            	g.drawLine(f.getX()+ (int)(f.getWidth()/2),f.getY()+(int)(f.getHeight()/1.5),
            	f.getX() + (int)(f.getWidth()/3),f.getY()+(int)(f.getHeight()/1.5));
            }
           // NEVER WAIT TILL THE LAST MINUTE TO PROGRAM I LEARN MY LESSON 
            //HA H
            
            //ILL DO EVEN BETTER ON THE NEXT ASSIGNMENT
            
            //I procrastinated all weekend
              
            
        }
        
        
        
    }
}

//This part creates the user interface 
class FaceFrame extends JFrame {
    public FaceFrame(ArrayList<Face> faces) {
        setBounds(100,50,500,500);
        setTitle("Circles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        FacePanel panfaces = new FacePanel(faces);
        c.add(panfaces,BorderLayout.CENTER);
    }
}
//MainMethod 
public class Ezekiel {
    public static void main(String[] args) {
        Random rnd = new Random();
        int faceCount = 3 + rnd. nextInt(10);
        Face f;
        ArrayList<Face> faces = new ArrayList<Face>();
        for (int i = 0; i < faceCount; i++) {
            f = new Face(rnd.nextInt(500), rnd.nextInt(500),
                    5+rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(3));
            faces.add(f);
            for(Face w: faces)
            	System.out.println(w);
        }
        FaceFrame ff = new FaceFrame(faces);
        ff.setVisible(true);
    }

}
//next time figure out how to draw the faces using drawArch 2/26/2017
//fIGURED IT OUT FINALLY GOT THE FACES TO PRINT 


