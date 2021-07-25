// May 2021 - Assignment 3 for SENG2050

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ReportedIssue"})
public class ReportedIssue extends HttpServlet {

  @Override public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher =
        this.getServletContext().getRequestDispatcher("/WEB-INF/ReportedIssue.jsp");
    dispatcher.forward(request, response);
  }
  
}