/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Version 2
 */
public class ProductDAO extends DBConnection {

    Connection con = null;

    //get Connection
    public ProductDAO() {
        try {
            con = getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Product> listProduct() {
        List<Product> products = new ArrayList<>();
        String selectQuery = "SELECT * FROM Product";
        Statement stm = null;
        ResultSet rs = null;
        Product p = null;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(selectQuery);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("pid"));
                String name = rs.getString("pname");
                double price = Double.parseDouble(rs.getString("price"));
                String image = rs.getString("image");
                String desc = rs.getString("description");
                String short_desc = rs.getString("short_descript");
                p = new Product(id, name, price, image, desc, short_desc);
                products.add(p);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }

    public List<Product> listProduct(int pageIndex, int pageSize) {
        List<Product> products = new ArrayList<>();
        Product p = null;
        int start = pageIndex * pageSize;
        int end = start + pageSize;

        String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER ( ORDER BY pid) AS r, * FROM Product) AS A WHERE A.r > ? AND A.r <= ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, start);
            pstm.setInt(2, end);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("pid"));
                String name = rs.getString("pname");
                double price = Double.parseDouble(rs.getString("price"));
                String image = rs.getString("image");
                String desc = rs.getString("description");
                String short_desc = rs.getString("short_descript");
                p = new Product(id, name, price, image, desc, short_desc);
                products.add(p);
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }

    public Product getProductById(int id) {
        Product p = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String query = "SELECT * FROM Product WHERE pid = ?";
        try {
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("pname");
                double price = Double.parseDouble(rs.getString("price"));
                String image = rs.getString("image");
                String desc = rs.getString("description");
                String short_desc = rs.getString("short_descript");
                p = new Product(id, name, price, image, desc, short_desc);
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }

    public int countProduct() {
        int n = 0;
        String sql = "SELECT * FROM Product";
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                n++;
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Product p = dao.getProductById(2);
        System.out.println(p.getDesc());
    }
}
