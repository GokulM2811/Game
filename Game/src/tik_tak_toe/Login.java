package tik_tak_toe;

import java.sql.*;
import java.util.*;

public class Login {

	DBHandler db = new DBHandler();
	
	String username="";
	String password="";
	int u_id=0;
	
	
	public boolean login() {
		Scanner sc = new Scanner(System.in);
		boolean verified = false;
		boolean success = false;
		do {
			getCredentials();
			success = isUserExist();
			if(success) {
				verified = true;
			}
			else{
				System.out.println("Invalid Username/Password");
				System.out.println("Press 1 to try LOGIN again");
				System.out.println("Press 2 for Main Menu");
				int d = incorrect();
				if(d==1) {
					success = false;
				}
				else if(d==2) {
					success = true;
					verified = false;
				}
				
			}
		}while(!success);
		return verified;
	}
	
	public int incorrect() {
		Scanner sc = new Scanner(System.in);
		int d=0;
		do{
			System.out.println("Option: ");
			d = sc.nextInt();
			sc.nextLine();
		}while(d!=1 && d!=2);
		return d;
	}
	
	public void getCredentials() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		username = sc.nextLine();
		System.out.println("Password: ");
		password = sc.nextLine();		
	}
	
	public boolean isUserExist() {
		boolean exist = false;
		try {
			DBHandler db = new DBHandler();
			Connection con = db.getConnection();			
			
			PreparedStatement pst = con.prepareStatement("select count(*) from userDetails where name=? and password=?");
			pst.setString(1,username);
			pst.setString(2,password);
			ResultSet rs = pst.executeQuery();
			int d=0;
			while(rs.next()) {
				d = rs.getInt(1);
			}
			if(d>0) {
				PreparedStatement pst2 = con.prepareStatement("select id from userDetails where name=? and password=?");
				pst2.setString(1,username);
				pst2.setString(2,password);
				ResultSet id = pst2.executeQuery();
				while(id.next()) {
					u_id=id.getInt(1);
				}
				exist = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}

}
