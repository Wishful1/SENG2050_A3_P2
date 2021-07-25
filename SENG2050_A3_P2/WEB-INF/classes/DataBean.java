import java.util.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;  

public class DataBean implements Serializable
{
	private String reporterID;
	private String category;
	private String title;
	private String issueDtls;

	public DataBean()
	{
		this.reporterID = "";
		this.category = "";
		this.title = "";
		this.issueDtls = "";
	}

	public void setReporterID(String x) {this.reporterID = x;}
	public void setCategory(String x) {this.category = x;}
	public void setTitle(String x) {this.title = x;}
	public void setIssueDtls(String x) {this.issueDtls = x;}

	public synchronized void saveData()
	{
		try
		{
			System.out.print("[INFO] [DataBean.saveData] : The reported issue by "+this.reporterID+" had the title "+this.title+", category "+this.category+", and details "+this.issueDtls+"\n");
			String query = "INSERT INTO Issues (ReporterId, Category, Title, IssueDtls) VALUES (?, ?, ?, ?)";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			System.out.print("[INFO] [DataBean.saveData] : Initial statement prepared...\n");
			statement.setString(1, this.reporterID);
			statement.setString(2, this.category);
			statement.setString(3, this.title);
			statement.setString(4, this.issueDtls);
			System.out.println(statement);
			statement.executeUpdate();
			System.out.print("[INFO] [DataBean.saveData] : Statement Executed!\n");
			statement.close();
			conn.close();
		}
		catch (Exception e) {}
	}

	public synchronized void overwriteData(int issueID, String issueStatus)
	{
		try
		{
			System.out.print("[INFO] [DataBean.overwriteData] : Overwriting issueID: "+issueID+" issue status to "+issueStatus+"...\n");
			String query = "UPDATE Issues SET IssueStatus='"+issueStatus+"' WHERE IssueId='"+issueID+"'";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			System.out.print("[INFO] [DataBean.overwriteData] : Initial statement prepared...\n");
			System.out.println(statement);
			statement.executeUpdate();
			System.out.print("[INFO] [DataBean.overwriteData] : Statement Executed!\n");
			statement.close();
			conn.close();
		}
		catch (Exception e) {}
	}
	
	public synchronized void resolveTime(int issueID)
	{
		try
		{
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formatDateTime = LocalDateTime.now().format(format);  
			String query = "UPDATE Issues SET DateResolved='"+formatDateTime+"' WHERE IssueId='"+issueID+"'";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			System.out.println(statement);
			statement.executeUpdate();
			statement.close();
			conn.close();
			System.out.println("Hello!");
		}
		catch (Exception e) {}
	}

	public synchronized List<Issue> loadKB()
    {
        List<Issue> knowledgebases = new LinkedList<Issue>();

        
        try
        {
            System.out.print("[INFO] [DataBean.loadKB] : Load KB was called!\n");
            String query = ("SELECT * FROM Issues WHERE IssueStatus='COMPLETED - KB' OR IssueStatus='RESOLVED - KB'");
            
            Connection conn = ConfigBean.getConnection();

            try {

                PreparedStatement statement = conn.prepareStatement(query);
                System.out.print("[INFO] [DataBean.loadKB] : Statement prepared...\n");
                ResultSet output = statement.executeQuery();
                System.out.print("[INFO] [DataBean.loadKB] : Statement executed...\n");
                while (output.next()) knowledgebases.add(Issue.convert(output));
    
    
                System.out.print("[INFO] [DataBean.loadKB] : Query Executed! Number of KB loaded into list: "+knowledgebases.size()+"\n");
                statement.close();

            } catch (SQLException e) {} finally {conn.close();}
        } catch (Exception e) {}
        return knowledgebases;
    }

	public synchronized void appendComment(int issueID, String commentToAdd, String username)
	{
		try
		{
			System.out.print("[INFO] [DataBean.appendComment] : Adding comment "+commentToAdd+" to issue "+issueID+"\n");
			String query = "UPDATE Issues SET IssueComments=CONCAT(IssueComments, '  "+username+": "+commentToAdd+" //') WHERE IssueId='"+issueID+"'";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			System.out.print("[INFO] [DataBean.appendComment] : Initial statement prepared...\n");
			System.out.println(statement);
			statement.executeUpdate();
			System.out.print("[INFO] [DataBean.appendComment] : Statement Executed!\n");
			statement.close();
			conn.close();
		}
		catch (Exception e) {}
	}
	
	public synchronized void replaceResDtls(int issueID, String resDtls)
	{
		try
		{
			String query = "UPDATE Issues SET ResolutionDtls='"+resDtls+"' WHERE IssueId='"+issueID+"'";
			Connection conn = ConfigBean.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			System.out.println(statement);
			statement.executeUpdate();
			statement.close();
			conn.close();
		}
		catch (Exception e) {}
	}

	public synchronized List<Issue> loadStaffData()
	{
		List<Issue> issues = new LinkedList<Issue>();

		System.out.print("[WARN] [DataBean.loadStaffData] : Retrieving ALL issues! Please ensure that this is staff login if testing...\n");
		
		try
		{
			
			String query = "SELECT * FROM Issues";
			
			Connection conn = ConfigBean.getConnection();

			try {

				Statement statement = conn.createStatement();
				System.out.print("[INFO] [DataBean.loadStaffData] : Statement prepared...\n");
			
				ResultSet output = statement.executeQuery(query);
				while (output.next()) issues.add(Issue.convert(output));
	
	
				System.out.print("[INFO] [DataBean.loadStaffData] : Query Executed! Number of issues loaded into list: "+issues.size()+"\n");
				statement.close();

			} catch (SQLException e) {} finally {conn.close();}
		} catch (Exception e) {}
		return issues;
	}

	public synchronized List<Issue> loadData(String username)
	{
		List<Issue> issues = new LinkedList<Issue>();

		System.out.print("[WARN] [DataBean.loadStaffData] : Retrieving issues for MEMBER "+username+"!\n");
		
		try
		{
			
			String query = ("SELECT * FROM Issues WHERE ReporterId='"+username+"'");
			
			Connection conn = ConfigBean.getConnection();

			try {

				PreparedStatement statement = conn.prepareStatement(query);
				System.out.print("[INFO] [DataBean.loadStaffData] : Statement prepared...\n");
				ResultSet output = statement.executeQuery();
				while (output.next()) issues.add(Issue.convert(output));
	
	
				System.out.print("[INFO] [DataBean.loadStaffData] : Query Executed! Number of issues loaded into list: "+issues.size()+"\n");
				statement.close();

			} catch (SQLException e) {} finally {conn.close();}
		} catch (Exception e) {}
		return issues;
	}

	public synchronized Issue loadIssue(int issueID, String username)
	{
		Issue issue = new Issue();

		System.out.print("[INFO] [DataBean.loadIssue] : Retrieving issue with ID "+issueID+", for MEMBER "+username+"!\n");
		
		try
		{
			
			String query = ("SELECT * FROM Issues WHERE IssueId='"+issueID+"' AND ReporterId='"+username+"'");
			Connection conn = ConfigBean.getConnection();

			try {

				PreparedStatement statement = conn.prepareStatement(query);
				System.out.print("[INFO] [DataBean.loadStaffData] : Statement prepared...\n");
				ResultSet output = statement.executeQuery();
				while (output.next()) issue = Issue.convert(output);
	
	
				System.out.print("[INFO] [DataBean.loadStaffData] : Query Executed!");
				statement.close();

			} catch (SQLException e) {} finally {conn.close();}
		} catch (Exception e) {}
		return issue;
	}

	public synchronized Issue loadStaffIssue(int issueID)
	{
		Issue issue = new Issue();

		System.out.print("[INFO] [DataBean.loadIssue] : Retrieving issue with ID "+issueID+", for STAFF!\n");
		
		try
		{
			
			String query = ("SELECT * FROM Issues WHERE IssueId='"+issueID+"'");
			Connection conn = ConfigBean.getConnection();

			try {

				PreparedStatement statement = conn.prepareStatement(query);
				System.out.print("[INFO] [DataBean.loadStaffData] : Statement prepared...\n");
				ResultSet output = statement.executeQuery();
				while (output.next()) issue = Issue.convert(output);
	
	
				System.out.print("[INFO] [DataBean.loadStaffData] : Query Executed!\n");
				statement.close();

			} catch (SQLException e) {} finally {conn.close();}
		} catch (Exception e) {}
		return issue;
	}

}