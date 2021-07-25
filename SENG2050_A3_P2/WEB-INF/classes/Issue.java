import java.sql.*;
import java.lang.System;

public class Issue {

	private int issueID;
	private String reporterID;
	private String issueStatus;
	private String category;
	private String title;
	private String issueDtls;
	private String comments;
	private String dateReported;
	private String resolutionDtls;
	private String dateResolved;
	private Boolean lock;

	public int issueID() {return this.issueID;}
	public String reporterID() {return this.reporterID;}
	public String issueStatus() {return this.issueStatus;}
	public String category() {return this.category;}
	public String title() {return this.title;}
	public String issueDtls() {return this.issueDtls;}
	public String comments() {return this.comments;}
	public String dateReported() {return this.dateReported;}
	public String resolutionDtls() {return this.resolutionDtls;}
	public String dateResolved() {return this.dateResolved;}
	public Boolean lock() {return this.lock;}

	public void issueID(int x) {this.issueID = x;}
	public void reporterID(String x) {this.reporterID = x;}
	public void issueStatus(String x) {this.issueStatus = x;}
	public void category(String x) {this.category = x;}
	public void title(String x) {this.title = x;}
	public void issueDtls(String x) {this.issueDtls = x;}
	public void comments(String x) {this.comments = x;}
	public void dateReported(String x) {this.dateReported = x;}
	public void resolutionDtls(String x) {this.resolutionDtls = x;}
	public void dateResolved(String x) {this.dateResolved = x;}


	public static Issue convert(ResultSet output) {
		Issue convertedIssue = new Issue();
		try {
			System.out.print("[INFO] [Issue] : Converting issue from SQL...\n");

			convertedIssue.issueID(output.getInt(1));
			convertedIssue.reporterID(output.getString(2));
			convertedIssue.issueStatus(output.getString(3));
			convertedIssue.category(output.getString(4));
			convertedIssue.title(output.getString(5));
			convertedIssue.issueDtls(output.getString(6));
			convertedIssue.comments(output.getString(7));
			convertedIssue.dateReported(output.getString(8));
			convertedIssue.resolutionDtls(output.getString(9));
			convertedIssue.dateResolved(output.getString(10));

			System.out.print("[INFO] [Issue] : Issue ID: "+convertedIssue.issueID()+"\n");

		} catch (SQLException e) {System.out.print(e);}
		return convertedIssue;
	}
}