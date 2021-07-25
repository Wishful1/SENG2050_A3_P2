import java.util.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;

public class KnowledgeBean implements Serializable
{
	private String category;
	private String title;
	private String issueDtls;
	private String dateReported;
	private String resolutionDtls;
	private String dateResolved;
	private String comments;

	public KnowledgeBean()
	{
		this.category = "";
		this.title = "";
		this.issueDtls = "";
		this.dateReported = "";
		this.resolutionDtls = "";
		this.dateResolved = "";
		this.comments = "";
	}

	public void setCategory(String x) {this.category = x;}
	public void setTitle(String x) {this.title = x;}
	public void setIssueDtls(String x) {this.issueDtls = x;}
	public void setDateReported(String x) {this.dateReported = x;}
	public void setResolutionDtls(String x) {this.resolutionDtls = x;}
	public void setDateResolved(String x) {this.dateResolved = x;}
	public void setComments(String x) {this.comments = x;}

	public synchronized void saveData()
	{
		try
		{
			System.out.print("[INFO] [KnowledgeBean.saveData] : New entry created with title "+this.title+", category "+this.category+", and details "+this.issueDtls+"\n");
			String query = "INSERT INTO KnowledgeBase (Category, Title, IssueDtls, DateReported, ResolutionDtls, DateResolved, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			System.out.print("[INFO] [KnowledgeBean.saveData] : Initial statement prepared...\n");
			statement.setString(1, this.category);
			statement.setString(2, this.title);
			statement.setString(3, this.issueDtls);
			statement.setString(4, this.dateReported);
			statement.setString(5, this.resolutionDtls);
			statement.setString(6, this.dateResolved);
			statement.setString(7, this.comments);
			System.out.println(statement);
			statement.executeUpdate();
			System.out.print("[INFO] [KnowledgeBean.saveData] : Statement Executed!\n");
			statement.close();
			conn.close();
		}
		catch (Exception e) {}
	}

	public synchronized List<KnowledgeEntry> loadKnowledgeData()
	{
		List<KnowledgeEntry> entries = new LinkedList<KnowledgeEntry>();

		System.out.print("[INFO] [KnowledgeBean.loadKnowledgeData] : Retrieving all entries!\n");
		
		try
		{
			
			String query = "SELECT * FROM KnowledgeBase";
			
			Connection conn = ConfigBean.getConnection();

			try {

				Statement statement = conn.createStatement();
				System.out.print("[INFO] [KnowledgeBean.loadKnowledgeData]: Statement prepared...\n");
			
				ResultSet output = statement.executeQuery(query);
				while (output.next()) entries.add(KnowledgeEntry.convert(output));
	
	
				System.out.print("[INFO] [KnowledgeBean.loadKnowledgeData]: Query Executed! Number of entries loaded into list: "+entries.size()+"\n");
				statement.close();

			} catch (SQLException e) {} finally {conn.close();}
		} catch (Exception e) {}
		return entries;
	}
}