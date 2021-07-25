// May 2021 - Assignment 3 for SENG2050

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ReportIssue"})
public class ReportIssue extends HttpServlet {

  @Override public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher =
        this.getServletContext().getRequestDispatcher("/WEB-INF/ReportIssue.jsp");
    dispatcher.forward(request, response);
  }
  
  @Override public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/ReportedIssue.jsp");
		HttpSession session = request.getSession();
		String username = (String)request.getUserPrincipal().getName();
		DataBean dataBean = (DataBean) session.getAttribute("dataBean");

		if (dataBean == null)
		{
			dataBean = new DataBean();
			session.setAttribute("dataBean", dataBean);
		}
		String appenddtls = (String) request.getParameter("resdtls");
		
		String reporterID = "";
		String issueStatus = "";
		String category = "";
		String title = "";
		String issueDtls = "";
		String dateReported = "";
		String resolutionDtls = "";
		String dateResolved = "";
		int current_issue_id = 0;
		try { current_issue_id = Integer.parseInt(request.getParameter("current_issue_id")); } catch (NumberFormatException e) {}
		if(appenddtls == null)
		{
			try {
				
				String mark = (String) request.getParameter("mark");
				String comment = (String) request.getParameter("comment");

				try { current_issue_id = Integer.parseInt(request.getParameter("current_issue_id")); } catch (NumberFormatException e) {}

				System.out.print("[INFO] [ReportIssue.doPost] : The parameter 'mark' was equal to "+mark+"\n");

				if (mark == null && comment == null) {

					reporterID = username;
					category = (String) request.getParameter("category");
					title = (String) request.getParameter("title");
					issueDtls = (String) request.getParameter("issueDtls");

					dataBean.setReporterID(reporterID);
					dataBean.setCategory(category);
					dataBean.setTitle(title);
					dataBean.setIssueDtls(issueDtls);
					dataBean.saveData();
					dispatcher.forward(request, response);
				
				} else if (comment != null) {
					dataBean.appendComment(current_issue_id, comment, username);
					response.sendRedirect(request.getContextPath() + "/ViewSpecificIssue?issueID="+current_issue_id);
				
				} else {

					System.out.print("[INFO] [ReportIssue.doPost.markInProgress] : The issue issueID:"+current_issue_id+" was called to overwrite to "+mark+"!\n");
					if(mark.equals("RESOLVED") || mark.equals("RESOLVED - KB"))
					{
						dataBean.resolveTime(current_issue_id);
					}
					dataBean.overwriteData(current_issue_id, mark);
					response.sendRedirect(request.getContextPath() + "/ViewSpecificIssue?issueID="+current_issue_id);
				}
			} catch (Exception e) {}
		}
		else
		{
			dataBean.replaceResDtls(current_issue_id, appenddtls);
			response.sendRedirect(request.getContextPath() + "/ViewIssues");
		}
	}
}