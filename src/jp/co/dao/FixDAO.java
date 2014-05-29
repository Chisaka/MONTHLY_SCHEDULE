package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.co.model.Schedule;

public class FixDAO {

    private DataSource ds;

    public FixDAO() {
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/crud");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public String[] splitDate(String date){
        String[] str = date.split("/");
        return str;
    }

    public void FixSchedule(Schedule s){
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement(" UPDATE SCHEDULELIST SET year = ?, month = ?, day = ?, schedule = ?, money = ? WHERE id = ?")) {
            ps.setInt(1, s.getYear());
            ps.setInt(2, s.getMonth());
            ps.setInt(3, s.getDay());
            ps.setString(4, s.getSche());
            ps.setInt(5, s.getMoney());
            ps.setInt(6, s.getID());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String zeroCheck(String money){
        if(money == ""){
            money = "0";
        }
        return money;
    }

}
