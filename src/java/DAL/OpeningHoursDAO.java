/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.OpeningHours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Version 2
 */
public class OpeningHoursDAO extends DBConnection {

    Connection con;

    public OpeningHoursDAO() {
        try {
            con = getConnection();
        } catch (Exception ex) {
            Logger.getLogger(OpeningHoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Function 1: get Openning Hour
    public List<OpeningHours> listOpeningHours() throws Exception {
        List<OpeningHours> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM OpeningHours";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String dayInWeek = rs.getString(2);
                int openTime = rs.getInt(3);
                int closeTime = rs.getInt(4);
                boolean isActive = rs.getBoolean(5);
                list.add(new OpeningHours(dayInWeek, openTime, closeTime, isActive));
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
        }
        return list;
    }

}
