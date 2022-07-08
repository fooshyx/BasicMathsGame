package game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Labels {
	private JLabel[] numbers;
	private JLabel[] goals;
	private CyclicList[] cycles;
	
	public Labels(int v) {
		makeLabels(v);
		makeGoals(v);
	}
	
	private void makeGoals(int v) {
		goals = new JLabel[v/4];
		int x1 = 290;
		int y1 = 30;
		for (int i = 0; i < goals.length; i++) {
			goals[i] = new JLabel(MathApp.getGoals(i));
			goals[i].setOpaque(true);
			goals[i].setFont(new Font("Dialog", Font.BOLD, 30));
			goals[i].setHorizontalAlignment(SwingConstants.CENTER);
			goals[i].setBounds(x1, y1, 60, 60);
			goals[i].setForeground(Color.PINK);
			goals[i].setBackground(Color.DARK_GRAY);
			y1 += 100;
		}
		
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
	
	public JLabel[] getNumbers() {
		return numbers;
	}
	
	public JLabel[] getGoals() {
		return goals;
	}
	
	public CyclicList[] getCycles() {
		return cycles;
	}
}