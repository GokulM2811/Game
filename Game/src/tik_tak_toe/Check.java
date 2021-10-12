package tik_tak_toe;

public class Check {

	public int check(int[][] a) {
		if (a[0][0] != 0) {
			if (a[0][0] == a[0][1]) {
				if (a[0][0] == a[0][2]) {
					if (a[0][0] == 1) {
						return 1;
					} else if (a[0][0] == 2) {
						return 2;
					}
				}
			}
		}
		if (a[0][0] != 0) {
			if (a[0][0] == a[1][1]) {
				if (a[0][0] == a[2][2]) {
					if (a[0][0] == 1) {
						return 1;
					} else if (a[0][0] == 2) {
						return 2;
					}
				}
			}
		}
		if (a[0][0] != 0) {
			if (a[0][0] == a[1][0]) {
				if (a[0][0] == a[2][0]) {
					if (a[0][0] == 1) {
						return 1;
					} else if (a[0][0] == 2) {
						return 2;
					}
				}
			}
		}
		if (a[0][1] != 0) {
			if (a[0][1] == a[1][1]) {
				if (a[0][1] == a[2][1]) {
					if (a[0][1] == 1) {
						return 1;
					} else if (a[0][1] == 2) {
						return 2;
					}
				}
			}
		}
		if (a[0][2] != 0) {
			if (a[0][2] == a[1][1]) {
				if (a[0][2] == a[2][0]) {
					if (a[0][2] == 1) {
						return 1;
					} else if (a[0][2] == 2) {
						return 2;
					}
				}
			}
		}
		if (a[0][2] != 0) {
			if (a[0][2] == a[1][2]) {
				if (a[0][2] == a[2][2]) {
					if (a[0][2] == 1) {
						return 1;
					} else if (a[0][2] == 2) {
						return 2;
					}
				}
			}
		}
		if (a[1][0] != 0) {
			if (a[1][0] == a[1][1]) {
				if (a[1][0] == a[1][2]) {
					if (a[1][0] == 1) {
						return 1;
					} else if (a[1][0] == 2) {
						return 2;
					}
				}
			}
		}
		if (a[2][0] != 0) {
			if (a[2][0] == a[2][1]) {
				if (a[2][0] == a[2][2]) {
					if (a[2][0] == 1) {
						return 1;
					} else if (a[2][0] == 2) {
						return 2;
					}
				}
			}
		}
		return 0;
	}

}
