import java.io.*;
import java.time.*;
import java.util.*;
import java.time.format.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ViewKnowledgeBase"})
public class ViewKnowledgeBase extends HttpServlet {

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

    List<Issue> knowledgebases = new LinkedList<Issue>();

	  knowledgebases = dataBean.loadKB();

    session.setAttribute("entries", knowledgebases);

    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/ViewKnowledgeBase.jsp");
    dispatcher.forward(request, response);
  }
}