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
 * Servlet implementation class Fix
 */
@WebServlet("/Fix")
public class Fix extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fix() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        FixDAO dao = new FixDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Schedule schedule = new Schedule();

        schedule = dao.getSchedule(id);

        request.setAttribute("schedule", schedule);

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("WEB-INF/jsp/FixEvent.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

}
