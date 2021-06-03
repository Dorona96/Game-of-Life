import javax.swing.*;
import java.security.SecureRandom;

public class Matrix extends JPanel{
	private  int[][] matrix;

	public Matrix(int size) {
		matrix=new int[size][size];
		fillRandomMatrix();
	}



	//fill the matrix in random values of 0 and 1.
	public  void fillRandomMatrix () {
		SecureRandom randomValues = new SecureRandom();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				int random = randomValues.nextInt(2);
				matrix[i][j] = random;
			}
		}
	}


	//paint the Brick
	public int paintBrick ( int aliveN, int currentBrick){
		if (currentBrick == 0){
			return (aliveN == 3) ? 1 : 0;
		}else {
			return (aliveN > 3||aliveN < 2) ? 0 : 1 ;
		}
	}

	//This function change the values of the giving matrix according to the rules of the game.
	public  void nextMatrix() {

		int aliveN = 0;// alive neighbors
		int[][] newMatrix = new int[matrix.length][matrix.length];

		for(int i=0;i<matrix.length;i++) {

			for(int j=0;j<matrix.length;j++) {

				if(i != 0 && i != matrix.length-1 && j!=0 && j!=matrix.length-1) { //if we at the middle (meaning we have more options)

					aliveN = matrix[i-1][j-1]  + matrix[i-1][j] + matrix[i-1][j+1]+ matrix[i][j-1] +matrix[i][j+1] +
							matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j-1];

				} 
				else {  //if we  at on or more of the edges 
					if(i == matrix.length-1) {//right column
							if(j == 0) { //top right corner
								aliveN = matrix[i][j + 1] + matrix[i - 1][j] + matrix[i - 1][j + 1];
							}
							else if(j == matrix.length-1) //bottom right corner
							{
								aliveN = matrix[i-1][j] + matrix[i-1][j-1] + matrix[i][j-1];
							}
							else //middle of the right column
							{
								aliveN = matrix[i][j-1] + matrix[i][j+1] + matrix[i-1][j-1]  + matrix[i-1][j] + matrix[i-1][j+1];
							}
						}
						else if(i == 0) { //left column
							if(j == 0) { //top left corner
								aliveN = matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+1][j];
							} else if(j == matrix.length-1) {  //bottom left corner
								aliveN = matrix[i][j-1] + matrix[i+1][j-1] + matrix[i+1][j];
							} else { //middle of the left column
								aliveN = matrix[i][j-1] + matrix[i][j+1] + matrix[i+1][j-1]  + matrix[i+1][j] + matrix[i+1][j+1];
							}
						} 
						
						else //middle brick of the edge
						{
							if(j == 0){ //middle of the top row
								aliveN = matrix[i-1][j]+ matrix[i-1][j+1] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
							} 
							else if(j == matrix.length-1) { //middle of bottom row
								aliveN = matrix[i-1][j] + matrix[i-1][j-1] +  matrix[i][j-1] + matrix[i+1][j]   + matrix[i+1][j-1];
							}
						}
				}

				newMatrix[i][j] = paintBrick(aliveN,matrix[i][j]);
			}
		}

		matrix=newMatrix;

	}// End of nextMatrix



	//return the matrix.
	public int [] [] getMatrix () {
		return matrix;
	}
}
