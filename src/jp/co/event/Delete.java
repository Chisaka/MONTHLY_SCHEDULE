package jp.co.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/crud")
    private DataSource ds;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/delete.jsp");
	        dispatcher.forward(request, response);

	        try (Connection con = ds.getConnection();
	                PreparedStatement ps = con
	                        .prepareStatement("DELETE FROM SCHEDULELIST ")) {
	            ps.setString(1, "%" +  + "%");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
