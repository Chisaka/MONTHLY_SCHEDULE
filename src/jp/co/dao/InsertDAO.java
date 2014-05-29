package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.co.model.Schedule;

public class InsertDAO {

    private DataSource ds;

    public InsertDAO() {
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/crud");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void splitDate(){

    }

    public void insetrSchedule(Schedule s){
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("INSERT INTO BOOKSHELF VALUES(?, ?, ?, ?, ?, ?);")) {

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
