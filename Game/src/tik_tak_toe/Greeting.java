package tik_tak_toe;

import java.util.*;

public class Greeting {
	
	static int u_id=0;
	
	public int getVerificationMethod() {
		Scanner sc = new Scanner(System.in);
		int d=0;
		do{
			System.out.println("Option: ");
			d = sc.nextInt();
			sc.nextLine();
		}while(d!=1 && d!=2);
		return d;
	}
	
	
	public void greetMessage() {
		System.out.println("Welcome");
		System.out.println("-------");
		System.out.println("Press 1 to LOGIN");
		System.out.println("Press 2 to REGISTER");
	}
	
	public boolean logInStatus() {
		boolean success;
		System.out.println("Login");
		System.out.println("-----");
		Login log = new Login();
		success = log.login();
		if(success) {
			u_id=log.u_id;
		}
		return success;
	}
	
	public boolean registerStatus() {
		boolean success;
		System.out.println("Register");
		System.out.println("--------");
		Register reg = new Register();
		success = reg.register();
		if(success) {
			u_id=reg.u_id;
		}
		return success;
	}
	
	public boolean showHome() {
		boolean success = false;
		do {
			greetMessage();
			int d = getVerificationMethod();
			if(d==1) {
				success=logInStatus();
			}
			else if(d==2) {
				success=registerStatus();
			}
		}while(!success);
		return success;
	}

	public static void main(String[] args) {
		Greeting greet = new Greeting();
		boolean success = greet.showHome();
		if(success) {
			Home home = new Home();
			home.open();
			
		}
	}

}
