package tik_tak_toe;

public class Update {

	public boolean updatePossible(int[][] a, int x, int y) {
		if (a[x - 1][y - 1] != 0) {
			return false;
		}
		return true;
	}

}
