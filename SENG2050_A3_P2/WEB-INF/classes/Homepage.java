import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/Homepage"})
public class Homepage extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

        HttpSession session = request.getSession();

		MaintenanceBean maintenanceBean = (MaintenanceBean) session.getAttribute("maintenanceBean");

		if (maintenanceBean == null)
		{
			maintenanceBean = new MaintenanceBean();
			session.setAttribute("maintenance", maintenanceBean);
		}

		String[] scheduledMaintenance = maintenanceBean.loadData();

		System.out.print("[INFO] [Home] : The bean loaded the times "+scheduledMaintenance[0]+" and "+scheduledMaintenance[1]+" for maintenance: "+scheduledMaintenance[2]+"\n");

		session.setAttribute("scheduledMaintenance", scheduledMaintenance);

    RequestDispatcher dispatcher =
        this.getServletContext().getRequestDispatcher("/WEB-INF/Homepage.jsp");
    dispatcher.forward(request, response);
  }
}