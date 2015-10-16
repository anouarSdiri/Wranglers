/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.Categorie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pijava.utils.MyConnection;

/**
 *
 * @author Anouar
 */
public class CategorieDAO {
     private Connection con= MyConnection.getInstance();
    private Statement ste;
    public CategorieDAO()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
    }
    public void ajouter(Categorie p) throws SQLException
    {
    String req="INSERT INTO categorie (type,image) "
            + "VALUES ('"+p.getType()+"', '"+p.getImage()+"');";
    ste.executeUpdate(req);
    }
    public void update(Categorie c)throws SQLException
    {
        String req = "UPDATE categorie SET type='"+c.getType()+"',image='"+c.getImage()+"' WHERE id="+c.getId();
        ste.executeUpdate(req);
    }
     public void afficher() throws SQLException
    {
    String sql="select * from categorie";
    ResultSet rs=ste.executeQuery(sql);
        while (rs.next()) {            
            System.out.println("id :"+rs.getInt(1));
            System.out.println("type :"+rs.getString(2));
            System.out.println("image :"+rs.getString(3));
        }
       
    }
     public void delete(int id) throws SQLException {
            String sql="delete from categorie where id="+id;
            ste.executeUpdate(sql);
        }
     
     
}
