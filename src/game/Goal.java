package game;

import java.util.Random;

public class Goal {
	private int[] code;
	
	public Goal(int v) {
		genGoal(v);
	}

	private void genGoal(int v) {
		code = new int[v];
		int max = 6;
		Random r = new Random();
		for (int i = 0; i < code.length; i++) {
			code[i] = r.nextInt(max);
		}
		
	}

	public int[] getCode() {
		return code;
	}
	
	

}
