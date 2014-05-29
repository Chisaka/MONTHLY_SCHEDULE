package jp.co.event;

import java.io.IOException;
import java.util.ArrayList;

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

	    ArrayList<Schedule> scheduleList = new ArrayList<>();

	    String date = request.getParameter("date");
	    String schedule = request.getParameter("schedule");
	    int money = Integer.parseInt(request.getParameter("money"));
	    InsertDAO dao = new InsertDAO();
	}

}
