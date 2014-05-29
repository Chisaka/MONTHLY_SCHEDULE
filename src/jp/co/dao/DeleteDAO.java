package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DeleteDAO {

    private DataSource ds;

    public DeleteDAO(){
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/crud");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void deleteSchedule(int s){
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("DELETE FROM SCHEDULELIST WHERE ID = ?")) {
            ps.setInt(1, s);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
