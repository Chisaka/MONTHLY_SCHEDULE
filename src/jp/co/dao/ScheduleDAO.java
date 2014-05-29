package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.co.model.Schedule;

public class ScheduleDAO {

    private DataSource ds;

    public ScheduleDAO() {
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/crud");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Schedule> getSchedule(int year, int month) {

        ArrayList<Schedule> scheduleList = new ArrayList<>();
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("SELECT * FROM SCHEDULELIST WHERE YEAR=? AND MONTH=? ORDER BY DAY")) {

            ps.setInt(1, year);
            ps.setInt(2, month);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Schedule schedule = new Schedule();
                    schedule.setYear(rs.getInt("YEAR"));
                    schedule.setMonth(rs.getInt("MONTH"));
                    schedule.setDay(rs.getInt("DAY"));
                    schedule.setSche(rs.getString("SCHEDULE"));
                    schedule.setMoney(rs.getInt("MONEY"));
                    scheduleList.add(schedule);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }
}
