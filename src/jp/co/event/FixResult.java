package jp.co.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.dao.FixDAO;
import jp.co.model.Schedule;

/**
 * Servlet implementation class FixResult
 */
@WebServlet("/FixResult")
public class FixResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixResult() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Schedule scheduleList = new Schedule();
        FixDAO dao = new FixDAO();
        String result = "変更";
        int id = Integer.parseInt(request.getParameter("id"));

        String[] date = dao.splitDate(request.getParameter("date"));
        String schedule = request.getParameter("schedule");
        int money = Integer.parseInt(dao.zeroCheck(request.getParameter("money")));
        scheduleList.setId(id);
        scheduleList.setYear(Integer.parseInt(date[0]));
        scheduleList.setMonth(Integer.parseInt(date[1]));
        scheduleList.setDay(Integer.parseInt(date[2]));
        scheduleList.setSche(schedule);
        scheduleList.setMoney(money);
        dao.FixSchedule(scheduleList);

        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Result.jsp");
        dispatcher.forward(request, response);
    }
}
