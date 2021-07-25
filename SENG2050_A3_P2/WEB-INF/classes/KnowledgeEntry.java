import java.sql.*;
import java.lang.System;

public class KnowledgeEntry {

	private int knowledgeID;
	private String category;
	private String title;
	private String issueDtls;
	private String dateReported;
	private String resolutionDtls;
	private String dateResolved;
	private String comments;

	public int knowledgeID() {return this.knowledgeID;}
	public String category() {return this.category;}
	public String title() {return this.title;}
	public String issueDtls() {return this.issueDtls;}
	public String dateReported() {return this.dateReported;}
	public String resolutionDtls() {return this.resolutionDtls;}
	public String dateResolved() {return this.dateResolved;}
	public String comments() {return this.comments;}

	public void knowledgeID(int x) {this.knowledgeID = x;}
	public void category(String x) {this.category = x;}
	public void title(String x) {this.title = x;}
	public void issueDtls(String x) {this.issueDtls = x;}
	public void dateReported(String x) {this.dateReported = x;}
	public void resolutionDtls(String x) {this.resolutionDtls = x;}
	public void dateResolved(String x) {this.dateResolved = x;}
	public void comments(String x) {this.comments = x;}


	public static KnowledgeEntry convert(ResultSet output) {
		KnowledgeEntry convertedEntry = new KnowledgeEntry();
		try {
			System.out.print("[INFO] [KnowledgeEntry] : Converting knowledge entry from SQL...\n");

			convertedEntry.knowledgeID(output.getInt(1));
			convertedEntry.category(output.getString(2));
			convertedEntry.title(output.getString(3));
			convertedEntry.issueDtls(output.getString(4));
			convertedEntry.dateReported(output.getString(5));
			convertedEntry.resolutionDtls(output.getString(6));
			convertedEntry.dateResolved(output.getString(7));
			convertedEntry.comments(output.getString(8));

			System.out.print("[INFO] [KnowledgeEntry] : Knowledge Entry ID: "+convertedEntry.knowledgeID()+"\n");

		} catch (SQLException e) {System.out.print(e);}
		return convertedEntry;
	}
}