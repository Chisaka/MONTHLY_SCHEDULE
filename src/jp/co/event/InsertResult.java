package jp.co.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.dao.InsertDAO;
import jp.co.model.Schedule;

/**
 * Servlet implementation class InsertResult
 */
@WebServlet("/InsertResult")
public class InsertResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    Schedule scheduleList = new Schedule();
	    InsertDAO dao = new InsertDAO();

	    String[] date = dao.splitDate(request.getParameter("date"));
	    String schedule = request.getParameter("schedule");
	    String result = "追加";
	    int money = Integer.parseInt(dao.zeroCheck(request.getParameter("money")));
	    scheduleList.setYear(Integer.parseInt(date[0]));
	    scheduleList.setMonth(Integer.parseInt(date[1]));
	    scheduleList.setDay(Integer.parseInt(date[2]));
	    scheduleList.setSche(schedule);
	    scheduleList.setMoney(money);
	    dao.insertSchedule(scheduleList);

	    request.setAttribute("result", result);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Result.jsp");
        dispatcher.forward(request, response);

	}

}
