import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
	private Matrix matrix;    
    final private  int matrixSize=10;
    final private int brickSize = 50; 
    private Color myColor = Color.BLUE;
    

public Panel() {
        matrix= new Matrix(matrixSize);
    }

  
    public void paintComponent(Graphics graphic) {
        int a=0;
        int b=0;
        super.paintComponent(graphic);
        setBackground(Color.BLACK);
        int [][] curMatrix= matrix.getMatrix();
        
        for (int i = 0; i < matrixSize; i++) {
        	
            for (int j = 0; j < matrixSize; j++) {
            	
                if (curMatrix[i][j] == 1) {
                	graphic.fillRect(a, b, brickSize, brickSize);
                    graphic.setColor(myColor);
                } else {
                	graphic.drawRect(a, b, brickSize, brickSize);
                    graphic.setColor(myColor);
                    
                }
                a += brickSize;
            }
            b += brickSize;
            a = 0;
        }
    }// End of paintComponent
    
    public void nextGenersion() {
        matrix.nextMatrix();
    }
}
