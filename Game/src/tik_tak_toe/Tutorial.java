package tik_tak_toe;

import java.util.Scanner;

public class Tutorial {
	
	
	public void tutorial() {
		show();
		System.out.println("Press 1 to START PLAY");
		System.out.println("Press 2 to HOME");
		int d = getStep();
		if(d==1) {
			App app = new App();
			app.start();
		}
		else if(d==2) {
			Home home = new Home();
			home.open();
		}
	}
	
	public void show() {
		
		Display dis = new Display();
		System.out.println("TUTORIAL");
		System.out.println("========\n");
		System.out.println("\t  Column");
		System.out.println("\t     |");
		System.out.println("\t     v");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print("   ");
				if(i==0 && j==2) {
					System.out.print("  <-- Row");
				}
				if(j!=2) {
					System.out.print(" | ");
				}
			}

			if(i!=2) {
				System.out.println("\n----|-----|----");				
			}
		}
		System.out.println("\n\nEnter the Position: HINT(Row, Column)");
		System.out.println("1,2\n");
		int[][] a = new int[3][3];
		a[0][1]=1;
		dis.display(a);
		
	}
	
	
	public int getStep() {
		Scanner sc = new Scanner(System.in);
		int d =-1;
		do {
			System.out.println("Option: ");
			d = sc.nextInt();
			sc.nextLine();
			if(d!=1 && d!=2) {
				System.out.println("Invalid");
			}
		}while(d!=1 && d!=2);
		return d;
	}

}
