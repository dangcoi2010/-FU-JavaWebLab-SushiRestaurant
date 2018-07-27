/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ImageSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Version 2
 */
public class ImageSourceDAO extends DBConnection {

    Connection con = null;

    public ImageSourceDAO() {
        try {
            con = getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ImageSourceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //GET PATH
    public ImageSource getImageById(int id) throws Exception {
        ImageSource img = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "SELECT * FROM ImgSource WHERE id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String path = rs.getString("imgPath");
                img = new ImageSource(id, path);
            }
            pstm.close();
            rs.close();
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
        return img;
    }

}
