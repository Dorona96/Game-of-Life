/*Game Of Life by Doron Sharaby
 * ID: 204862197
 * Date: 14/3/2021
 * */

import javax.swing.*;

public class Tester{
	public static void main(String[] args) {
		final int frameSize =550;

		JFrame frame = new JFrame("Game Of Life");
		frame.setSize(frameSize, frameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Panel panel = new Panel();
		frame.add(panel);
		frame.setVisible(true);

		//continue until the user press "no" or "cancel"
		while (JOptionPane.showConfirmDialog(null, "Do you wish to move to the next generation? \n") == 0) {
			panel.nextGenersion();
			panel.repaint();
		}
	}
}//End of main


