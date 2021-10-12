package tik_tak_toe;

import java.util.*;
import java.sql.*;

public class Home {
	Greeting greet = new Greeting();
	int u_id = greet.u_id;
	String name;
	
	public void open() {
		Scanner sc = new Scanner(System.in);
		getUserName(u_id);
		System.out.println("Welcome "+name);
		System.out.println("Press 1 for Tutorial");
		System.out.println("Press 2 to Start the game");
		int d=0;
		do {
			System.out.print("Option: ");
			d = sc.nextInt();
		}while(d!=1 && d!=2);
		if(d==1) {
			Tutorial tut = new Tutorial();
			tut.tutorial();
		}
		else if(d==2) {
			App app = new App();
			app.start();
		}
	}
	
	public void getUserName(int u_id) {
		try {
			DBHandler db = new DBHandler();
			Connection con = db.getConnection();
			PreparedStatement pst = con.prepareStatement("select name from userDetails where id = ?");
			pst.setInt(1, u_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				name = rs.getString(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
