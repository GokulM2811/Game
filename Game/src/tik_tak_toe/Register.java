package tik_tak_toe;

import java.util.*;
import java.sql.*;

public class Register {
	
	Scanner sc = new Scanner(System.in);
	String name;
	String ph;
	String email;
	String password;
	int u_id=0;
	
	public boolean register() {
		boolean success = open();
		if(success) {
			
			try{
				DBHandler db = new DBHandler();
				Connection con = db.getConnection();
				PreparedStatement pst = con.prepareStatement("select u_id_sequence.nextval from dual");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					u_id = rs.getInt(1);
				}
				PreparedStatement query = con.prepareStatement("insert into userDetails values(?,?,?,?,?)");
				query.setInt(1, u_id);
				query.setString(2, name);
				query.setString(3, ph);
				query.setString(4, email);
				query.setString(5, password);
				query.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean open() {
		boolean sure = false;
		System.out.print("Name: ");
		name = sc.nextLine();
		
		boolean phmatch = false;
		do {
			System.out.print("Phone number: ");
			ph = sc.nextLine();
			phmatch = ph.matches("[0-9]{10}");
			if(!phmatch) {
				System.out.println("Enter valid Phone Number");
			}
		}while(!phmatch);
		
		System.out.print("Email: ");
		email = sc.nextLine();
		
		boolean passmatch = false;
		do {
			do {
				System.out.print("Password: ");
				password = sc.nextLine();
				passmatch = password.matches("[0-9a-zA-Z@#$%&*]{6,15}");
				if(!passmatch) {
					System.out.println("Invalid Password/Password already taken");
				}
			}while(!passmatch);
			if(passExist()) {
				System.out.println("Invalid Password/Password already taken");
			}
		}while(passExist());
			
		char s;
		do {
			System.out.print("Are you sure to register?(y/n):");
			s = sc.next().charAt(0);
		}while(s!='y' && s!='n');
		
		
		if(s=='y') {
			sure = true;
		}
		else if(s=='n') {
			System.out.println("Returning to Home......");
			sure = false;
		}
	
		return sure;
	}
	
	public boolean passExist() {
		boolean exist = true;
		DBHandler db = new DBHandler();
		Connection con;
		try {
			con = db.getConnection();
			PreparedStatement pst = con.prepareStatement("select count(*) from userDetails where name=? and password=?");
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			int d = -1;
			while(rs.next()) {
				d = rs.getInt(1);
			}
			if(d==0) {
				exist = false;
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return exist;
	}

}
