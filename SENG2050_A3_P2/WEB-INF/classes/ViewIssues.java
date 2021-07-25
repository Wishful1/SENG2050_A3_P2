import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ViewIssues"})
public class ViewIssues extends HttpServlet {

  @Override public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/ViewIssues.jsp");

    HttpSession session = request.getSession();

		DataBean dataBean = (DataBean) session.getAttribute("dataBean");

		if (dataBean == null)
		{
			dataBean = new DataBean();
			session.setAttribute("dataBean", dataBean);
		}

		String username = (String)request.getUserPrincipal().getName();

    List<Issue> issues = new LinkedList<Issue>();

    if (request.isUserInRole("STAFF")) issues = dataBean.loadStaffData();
    else issues = dataBean.loadData(username);
    
    session.setAttribute("issues", issues);

    dispatcher.forward(request, response);
  }

  @Override public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    doGet(request, response);
	}
}