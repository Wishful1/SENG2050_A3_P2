import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ScheduleMaintenance"})
public class ScheduleMaintenance extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher =
        this.getServletContext().getRequestDispatcher("/WEB-INF/ScheduleMaintenance.jsp");
    dispatcher.forward(request, response);
	  }
  
  @Override public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		MaintenanceBean maintenanceBean = (MaintenanceBean) session.getAttribute("maintenanceBean");
		
		if (maintenanceBean == null)
		{
			maintenanceBean = new MaintenanceBean();
			session.setAttribute("maintenance", maintenanceBean);
		}
		
		String schedule = (String) request.getParameter("schedule");
		
		System.out.print("[INFO] [ScheduleMaintenance.doPost] : Schedule is currently: "+schedule+"\n");

		if (schedule != null)
		{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/ScheduledMaintenance.jsp");
			if (maintenanceBean == null)
			{
				maintenanceBean = new MaintenanceBean();
				session.setAttribute("maintenanceBean", maintenanceBean);
			}
			String maintenanceDescription = "";
			String startDate = "";
			String endDate = "";		

			try 
			{
				maintenanceDescription = (String) request.getParameter("mainTitle");
				startDate = (String) request.getParameter("dateStart");
				endDate = (String) request.getParameter("dateEnd");
			} catch (Exception e) {}


			maintenanceBean.setMaintenanceDescription(maintenanceDescription);
			maintenanceBean.setStartDate(startDate);
			maintenanceBean.setEndDate(endDate);

			System.out.print("[INFO] [ScheduleMaintenance] : Call saving data...\n");
			maintenanceBean.saveData();
			dispatcher.forward(request, response);
		} else {
			if (maintenanceBean != null) {
				System.out.print("[INFO] [ScheduleMaintenance] : Delete date from maintenance bean called!\n");
				maintenanceBean.deleteData();
			} else {
				System.out.print("[ERROR] [ScheduleMaintenance] : maintenanceBean is currently null! This should not be possible!!!\n");
			}
			session.setAttribute("scheduledMaintenance", null);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/ScheduledMaintenance.jsp");
			dispatcher.forward(request, response);
		}
	}
}