import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet 
{

  @Override public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp");
	  dispatcher.forward(request, response);
  }

  @Override public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Registered.jsp");
		HttpSession session = request.getSession();
		RegisterBean registerBean = (RegisterBean) session.getAttribute("registerBean");

		if (registerBean == null)
		{
			registerBean = new RegisterBean();
			session.setAttribute("registerBean", registerBean);
		}
		
		String username = "";
		String fName = "";
		String lName = "";
		String email = "";
		String phNum = "";
		String pWord = "";	

		try 
		{

			username = (String) request.getParameter("username");
			fName = (String) request.getParameter("fname");
			lName = (String) request.getParameter("lname");
			email = (String) request.getParameter("email");
			phNum = (String) request.getParameter("phnum");
			pWord = (String) request.getParameter("password");
		} catch (Exception e) {}

		registerBean.setUsername(username);
		registerBean.setFName(fName);
		registerBean.setLName(lName);
		registerBean.setEmail(email);
		registerBean.setPhNum(phNum);
		registerBean.setPWord(pWord);
		System.out.println(username);
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(email);
		System.out.println(phNum);
		System.out.println(pWord);
		registerBean.saveData();
		dispatcher.forward(request, response);
	}
}