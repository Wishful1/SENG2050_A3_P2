import java.util.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;

public class RegisterBean implements Serializable
{
	private String username;
	private String fName;
	private String lName;
	private String email;
	private String phNum;
	private String pWord;

	public RegisterBean()
	{
		this.username = "";
		this.fName = "";
		this.lName = "";
		this.email = "";
		this.phNum = "";
		this.pWord = "";
	}

	public void setUsername(String x) {this.username = x;}
	public void setFName(String x) {this.fName = x;}
	public void setLName(String x) {this.lName = x;}
	public void setEmail(String x) {this.email = x;}
	public void setPhNum(String x) {this.phNum = x;}
	public void setPWord(String x) {this.pWord = x;}

	public synchronized void saveData()
	{
		try
		{
			String query = "INSERT INTO Users (UserName, FirstName, LastName, Email, Password, Phone) VALUES (?, ?, ?, ?, ?, ?)";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, this.username);
			statement.setString(2, this.fName);
			statement.setString(3, this.lName);
			statement.setString(4, this.email);
			statement.setString(5, this.pWord);
			statement.setString(6, this.phNum);
			statement.executeUpdate();
			statement.close();
			conn.close();
			String query2 = "INSERT INTO UserRoles (UserName, RoleName) VALUES (?, ?)";
			Connection conn2 = ConfigBean.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(query2);
			statement2.setString(1, this.username);
			statement2.setString(2, "MEMBER");
			statement2.executeUpdate();
			statement2.close();
			conn2.close();
		}
		catch (Exception e) {}
	}
}