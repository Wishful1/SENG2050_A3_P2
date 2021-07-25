import java.util.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;

public class MaintenanceBean implements Serializable
{
	private String maintenanceDescription;
	private String startDate;
	private String endDate;
	private String convertedStartTime;
	private String convertedEndTime;
	private String convertedTitle;
	private String[] returnStr = new String[3];

	public MaintenanceBean()
	{
		this.maintenanceDescription = "";
		this.startDate = "";
		this.endDate = "";
	}

	public void setMaintenanceDescription(String x) {this.maintenanceDescription = x;}
	public void setStartDate(String x) {this.startDate = x;}
	public void setEndDate(String x) {this.endDate = x;}

	public synchronized void saveData()
	{
		System.out.print("[INFO] [MaintenanceBean] : Begin saving data...\n");

		try
		{
			System.out.print("[QUERY] [MaintenanceBean] : INSERT INTO MaintenanceEvents (MaintenanceTitle, StartDate, EndDate) VALUES ("+this.maintenanceDescription+", "+this.startDate+", "+this.endDate+")\n");
			String query = "INSERT INTO MaintenanceEvents (MaintenanceTitle, StartDate, EndDate) VALUES (?, ?, ?)";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, this.maintenanceDescription);
			statement.setString(2, this.startDate);
			statement.setString(3, this.endDate);
			statement.executeUpdate();
			statement.close();
			conn.close();
		}
		catch (Exception e) {}
	}
	
	public synchronized String[] loadData()
	{		
		System.out.print("[INFO] [MaintenanceBean.loadData] : Begin Loading Data...\n");
		try
		{
			
			String query = ("SELECT * FROM MaintenanceEvents WHERE Maintenanceid=(SELECT max(Maintenanceid) FROM MaintenanceEvents)");
			
			System.out.print("[INFO] [MaintenanceBean.loadData] : Initialising connection!\n");
			Connection conn = ConfigBean.getConnection();
			System.out.print("[INFO] [MaintenanceBean.loadData] : Connection created!\n");

			try {

				Statement statement = conn.createStatement();
			
				ResultSet output = statement.executeQuery(query);
				System.out.print("[INFO] [MaintenanceBean.loadData] : Query executed!\n");
				output.next();
				convertedTitle = output.getString(2);
				convertedStartTime = output.getString(3);
				convertedEndTime = output.getString(4);
				System.out.print(convertedStartTime+"\n");
				System.out.print(convertedEndTime+"\n");
				System.out.print(convertedTitle+"\n");
				returnStr[0] = convertedStartTime;
				returnStr[1] = convertedEndTime;
				returnStr[2] = convertedTitle;
				statement.close();

			} catch (SQLException e) {} finally {conn.close();}
		} catch (Exception e) {}
		return returnStr;
	}
	public synchronized void deleteData()
	{
		try
		{
			String query = ("DELETE FROM MaintenanceEvents");
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			System.out.print("[INFO] [MaintenanceBean.deleteData] : Query Prepared!\n");
			statement.executeUpdate();
			System.out.print("[INFO] [MaintenanceBean.deleteData] : Query executed!\n");
			returnStr[0] = null;
			returnStr[1] = null;
			returnStr[2] = null;
			statement.close();
		}
		catch (SQLException e) {}
	}
}