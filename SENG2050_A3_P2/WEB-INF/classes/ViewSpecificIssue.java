import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ViewSpecificIssue"})
public class ViewSpecificIssue extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int issueID = -1;

    try {
      issueID = Integer.parseInt(request.getParameter("issueID"));
    } catch (NumberFormatException e) {}

    HttpSession session = request.getSession();

		DataBean dataBean = (DataBean) session.getAttribute("dataBean");

		if (dataBean == null)
		{
			dataBean = new DataBean();
			session.setAttribute("dataBean", dataBean);
		}

    Issue issue;

    if (request.isUserInRole("STAFF")) issue = dataBean.loadStaffIssue(issueID);
    else issue = dataBean.loadIssue(issueID, (String) request.getUserPrincipal().getName());

    System.out.print("[INFO] [ViewSpecificIssue] : The issue with ID "+issue.issueID()+" was loaded, attempted to retrieve "+issueID+"...\n");

    request.setAttribute("issue", issue);

    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/ViewSpecificIssue.jsp");
    dispatcher.forward(request, response);
  }
}