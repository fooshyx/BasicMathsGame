package game;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Buttons implements ActionListener {
	private JButton[] switches;
	
	public Buttons(int v) {
		makeButtons(v);
	}

	public void makeButtons(int v) {
		switches = new JButton[v];
		int x1 = 10;
		int y1 = 10;
		for (int i = 0; i < switches.length; i++) {
			if (i == 4 || i == 8 || i == 12) { x1 = 10; y1 += 100;
			}
			switches[i] = new JButton("Switch");
			switches[i].setFont(new Font("Dialog", Font.BOLD, 9));
			switches[i].setMargin(new Insets(0, 0, 0, 0));
			switches[i].setBounds(x1, y1, 60, 15);
			switches[i].addActionListener(this);
			x1 += 70;
		}
	}
	
	public JButton[] getSwitches() {
		return switches;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		while (e.getSource() != switches[i]) {
			i++;
		}
		MathApp.adjustNum(i);		
	}

}
