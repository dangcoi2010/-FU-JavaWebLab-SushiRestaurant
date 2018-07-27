/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Contact;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Version 2
 */
public class ContactDAO extends DBConnection {

    Connection con = null;

    public ContactDAO() {
        try {
            con = getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Funtion 1: get the contact
    public Contact getContact() throws Exception{
        Contact contact = null;
        String query = "SELECT * FROM Contact";
        ResultSet rs = null;
        Statement stm = null;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){
                String address = rs.getString("address");
                String telephone = rs.getString("phone");
                String email = rs.getString("email");
                contact = new Contact(address, telephone, email);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
           throw e;
        } finally{
                if(rs != null && !rs.isClosed()) rs.close();
                if(stm != null && !stm.isClosed()) stm.close();
                if(con != null && !con.isClosed()) con.close();
        }
        return contact;
    }
    
}
