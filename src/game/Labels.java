package game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Labels {
	private JLabel[] numbers;
	private JLabel goals;
	private CyclicList[] cycles;
	private int[] code;
	
	public Labels(int v, int[] c) {
		makeLabels(v);
		code = c;
		makeGoals();
	}
	
	private void makeGoals() {
		goals = new JLabel();
		int x1 = 290;
		int y1 = 30;
		for (int i = 0; i < numbers.length; i++) {
			if (i == 4 || i == 8 || i == 12) { x1 = 290; y1 += 100;
			}
		}
		goals = new JLabel(getGoals());
		goals.setOpaque(true);
		goals.setFont(new Font("Dialog", Font.BOLD, 30));
		goals.setHorizontalAlignment(SwingConstants.CENTER);
		goals.setBounds(x1, y1, 60, 60);
		goals.setForeground(Color.PINK);
		goals.setBackground(Color.DARK_GRAY);
		y1 += 100;
	}

	public void makeLabels(int v) {
		numbers = new JLabel[v];
		cycles = new CyclicList[v];
		int x1 = 10;
		int y1 = 30;
		for (int i = 0; i < numbers.length; i++) {
			if (i == 4 || i == 8 || i == 12) { x1 = 10; y1 += 100;
			}
			cycles[i] = new CyclicList(5);
			numbers[i] = new JLabel(cycles[i].current.toString());
			numbers[i].setOpaque(true);
			numbers[i].setFont(new Font("Dialog", Font.BOLD, 30));
			numbers[i].setHorizontalAlignment(SwingConstants.CENTER);
			numbers[i].setBounds(x1, y1, 60, 60);
			numbers[i].setBackground(Color.LIGHT_GRAY);
			x1 += 70;
			}
	}
	
	public JLabel getGoal() {
		return goals;
	}
	
	public JLabel[] getNumbers() {
		return numbers;
	}
	
	public String getGoals() {
		int result = 0;
		for (int i = 0; i < code.length; i++) {
			result += code[i];
		}
		return "" + result;	
	}
	
	public CyclicList[] getCycles() {
		return cycles;
	}
}