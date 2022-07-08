package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MathApp {
	/**
	 * Instance vars - lazy names
	 */
	int difficulty;
	int turns;
	JTextArea t;
	JButton check = new JButton("Check Solution");
	JButton mainMenu = new JButton("Return to Menu");
	JLabel turn;
	JLabel count;
	JLabel win;
	private static int[] code;
	JButton[] b = new JButton[4];
	JButton[] s;
	static JLabel[] n;
	static JLabel[] g;
	static CyclicList[] c;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MathApp window = new MathApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MathApp() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 400, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	/**
	 * Set title for application
	 */
		JTextArea title = new JTextArea();
		title.setMargin(new Insets(5, 5, 5, 5));
		title.setWrapStyleWord(true);
		title.setLineWrap(true);
		title.setFont(new Font("Dialog", Font.BOLD, 12));
		title.setEditable(false);
		title.setText("Rules:\r\nCrack the code in 6 turns by changing the values to equal the sum in the final box.\r\nYellow means you are 1 away from the correct value.");
		t = title;
		title.setBackground(Color.LIGHT_GRAY);
		title.setOpaque(true);
		title.setBounds(10, 10, 365, 80);
		frame.getContentPane().add(title);
		
	/**
	 * Button for easy mode	
	 */
		JButton easy = new JButton("Easy: 1 Row");
		b[0] = easy;
		easy.setFont(new Font("Dialog", Font.BOLD, 11));
		easy.setBounds(10, 100, 150, 20);
		frame.getContentPane().add(easy);
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initLevel(4, 225, 120);
			}
		});
	
	/**
	 * Button for medium mode
	 */
		JButton medium = new JButton("Medium: 2 Rows");
		b[1] = medium;
		medium.setFont(new Font("Dialog", Font.BOLD, 11));
		medium.setBounds(10, 130, 150, 20);
		frame.getContentPane().add(medium);
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initLevel(8, 320, 220);
			}
		});
		
	/**
	 * Button for hard mode	
	 */
		JButton hard = new JButton("Hard: 3 Rows");
		b[2] = hard;
		hard.setFont(new Font("Dialog", Font.BOLD, 11));
		hard.setBounds(225, 100, 150, 20);
		frame.getContentPane().add(hard);
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initLevel(12, 420, 320);
			}
		});

	/**
	 * Button for expert mode	
	 */
		JButton expert = new JButton("Expert: 4 Rows");
		b[3] = expert;
		expert.setFont(new Font("Dialog", Font.BOLD, 11));
		expert.setBounds(225, 130, 150, 20);
		frame.getContentPane().add(expert);
		expert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initLevel(16, 520, 420);
			}
		});		
		
	/**
	 * Checks solution, sets turn status
	 */
		check.setFont(new Font("Dialog", Font.BOLD, 11));
		check.setVisible(false);
		check.setMargin(new Insets(0, 0, 0, 0));
		frame.getContentPane().add(check);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkSol();
			}	
		});
		
	/**
	 * Return to game menu
	 */
		mainMenu.setFont(new Font("Dialog", Font.BOLD, 11));
		mainMenu.setVisible(false);
		mainMenu.setMargin(new Insets(0, 0, 0, 0));
		frame.getContentPane().add(mainMenu);
		mainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hideGame();
			}	
		});
		
	/**
	* Track Turns + win message
	*/
		turn = new JLabel();
		turn.setVisible(false);
		frame.getContentPane().add(turn);
		count = new JLabel();
		count.setHorizontalAlignment(SwingConstants.RIGHT);
		count.setVisible(false);
		frame.getContentPane().add(count);
		win = new JLabel();
		win.setHorizontalAlignment(SwingConstants.RIGHT);
		win.setVisible(false);
		frame.getContentPane().add(win);
	}
	
	
	public void initLevel(int z, int y, int x) {
		hideMenu();
		Goal a = new Goal(z);
		code = a.getCode();
		frame.setBounds(500, 400, 375, y);
		Buttons e1 = new Buttons(z);
		s = e1.getSwitches();
		Labels e2 = new Labels(z);
		n = e2.getNumbers();
		g = e2.getGoals();
		c = e2.getCycles();
		showLevel(x);
	}
	
	public void hideGame() {
		check.setVisible(false);
		turn.setVisible(false);
		count.setVisible(false);
		win.setVisible(false);
		mainMenu.setVisible(false);
		for (int i = 0; i < g.length; i++) {
			g[i].setVisible(false);
		}
		for (int i = 0; i < s.length; i++) {
			s[i].setVisible(false);
			n[i].setVisible(false);
		}
		turns = 0;
		frame.setBounds(500, 400, 400, 200);
		t.setVisible(true);
		for (int i = 0; i < b.length; i++) {
			b[i].setVisible(true);
		}
		
	}
	
	public void hideMenu() {
		t.setVisible(false);
		for (int i = 0; i < b.length; i++) {
			b[i].setVisible(false);
		}
	}
	
	public void turns() {
		count.setText(""+turns);
		if (turns == 1) {
			turn.setText("turn. " + (6 - turns) + " remaining");
		}
		else
			turn.setText("turns. " + (6-turns) + " remaining");
	}
	
	public void showLevel(int v) {
		turn.setBounds(240, v, 200, 20);
		turn.setVisible(true);
		turns();
		count.setBounds(137, v, 100, 20);
		count.setVisible(true);
		win.setBounds(137, v, 210, 20);
		check.setBounds(10, v, 100, 20);
		check.setEnabled(true);
		check.setVisible(true);
		mainMenu.setBounds(10, (v+30), 100, 20);
		mainMenu.setVisible(true);
		for (int i = 0; i < g.length; i++) {
			frame.getContentPane().add(g[i]);
		}
		for (int i = 0; i < s.length; i++) {
			frame.getContentPane().add(s[i]);
			frame.getContentPane().add(n[i]);
		}
	}
	
	public static String getGoals(int v) {
		if (v == 0) {
			return ""+(code[0]+code[1]+code[2]+code[3]);
		}
		else if (v == 1) {
			return ""+(code[4]+code[5]+code[6]+code[7]);
		}
		else if (v == 2) {
			return ""+(code[8]+code[9]+code[10]+code[11]);
		}
		else
			return ""+(code[12]+code[13]+code[14]+code[15]);
		
	}
	
	public static void adjustNum(int v) {
		c[v].current = c[v].current.next;
		n[v].setText(c[v].current.toString());
	}
	
	public void checkSol() {
		turns += 1;
		turns();
		for (int i = 0; i < n.length; i++) {
			if (Integer.parseInt(n[i].getText()) == code[i]) {
				n[i].setBackground(Color.GREEN);
				s[i].setEnabled(false);
			}
			else if (Integer.parseInt(n[i].getText()) - 1 == code[i]) {
				n[i].setBackground(Color.ORANGE);
			}
			else if (Integer.parseInt(n[i].getText()) + 1 == code[i]) {
				n[i].setBackground(Color.ORANGE);
			}
			else
				n[i].setBackground(Color.LIGHT_GRAY);
		}
		if (turns == 6 || checkBoard()) {
			endRound();
		}
		System.out.println(checkBoard());
	}
	
	public boolean checkBoard() {
		for (int i = 0; i < n.length; i++) {
			if (!n[i].getBackground().equals(Color.GREEN)) {
				return false;
			}
		}
		return true;
	}
	
	public void endRound() {
		String winm = "You cracked the code in ";
		for (int i = 0; i < s.length; i++) {
			s[i].setEnabled(false);
		}
		check.setEnabled(false);
		if (checkBoard()) {
			turn.setVisible(false);
			count.setVisible(false);
			if (turns == 1) {
				winm += turns + "turn";
			}
			else
				winm += turns + " turns";
			win.setText(winm);
			win.setVisible(true);
		}
	}
}

