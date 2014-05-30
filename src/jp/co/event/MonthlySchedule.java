package jp.co.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.dao.ScheduleDAO;
import jp.co.model.Schedule;

/**
 * Servlet implementation class MonthlySchedule
 */
@WebServlet("/MonthlySchedule")
public class MonthlySchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthlySchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    Calendar calendar = Calendar.getInstance();
	    ScheduleDAO dao = new ScheduleDAO();
	    ArrayList<Schedule> scheduleList = new ArrayList<>();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH) + 1;
	    int money = 0;

	    scheduleList = dao.getSchedule(year, month);

	    for(Schedule moneycount:scheduleList){
	        money += moneycount.getMoney();
	    }

	    request.setAttribute("scheduleList", scheduleList);
	    request.setAttribute("year", year);
	    request.setAttribute("month", month);
	    request.setAttribute("money", money);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/monthlyschedule.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ScheduleDAO dao = new ScheduleDAO();
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int money = 0;

        scheduleList = dao.getSchedule(year, month);

        for(Schedule moneycount:scheduleList){
            money += moneycount.getMoney();
        }

        request.setAttribute("scheduleList", scheduleList);
        request.setAttribute("year", year);
        request.setAttribute("month", month);
        request.setAttribute("money", money);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/monthlyschedule.jsp");
        dispatcher.forward(request, response);
	}

}
