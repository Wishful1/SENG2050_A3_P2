import java.sql.*;
import java.lang.System;

public class Maintenance {

	private int maintenanceID;
	private String startDate;
	private String endDate;

	public int maintenanceID() {return this.maintenanceID;}
	public String startDate() {return this.startDate;}
	public String endDate() {return this.endDate;}

	public void maintenanceID(int x) {this.maintenanceID = x;}
	public void startDate(String x) {this.startDate = x;}
	public void endDate(String x) {this.endDate = x;}


	public static Maintenance convert(ResultSet output) {
		Maintenance convertedMaintenance = new Maintenance();
		try {

			convertedMaintenance.maintenanceID(output.getInt(1));
			convertedMaintenance.startDate(output.getString(2));
			convertedMaintenance.startDate(output.getString(3));
		} catch (SQLException e) {System.out.print(e);}
		return convertedMaintenance;
	}
}