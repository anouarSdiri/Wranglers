/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.Association;
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
public class AssociationDAO {
     private Connection con= MyConnection.getInstance();
    private Statement ste;
    public AssociationDAO()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
    }
    public void ajouter(Association a) throws SQLException
    {
    String req="INSERT INTO association (nom,image,id_categorie) "
            + "VALUES ('"+a.getNom()+"', '"+a.getImage()+"','"+a.getCategorie().getId()+"');";
    ste.executeUpdate(req);
    }
    public void update(Categorie c)throws SQLException
    {
        String req = "UPDATE association SET type='"+c.getType()+"',image='"+c.getImage()+"' WHERE id="+c.getId();
        ste.executeUpdate(req);
    }
     public void afficher() throws SQLException
    {
    String sql="select * from association";
    ResultSet rs=ste.executeQuery(sql);
        while (rs.next()) {            
            System.out.println("id Association :"+rs.getInt(1));
            System.out.println("nom :"+rs.getString(2));
            System.out.println("image :"+rs.getString(9));
            findCategorieById(rs.getInt(11));
             System.out.println("-------------------------");
        }
       
    }
     public void delete(int id) throws SQLException {
            String sql="delete from association where id="+id;
            ste.executeUpdate(sql);
        }
     
     public void findCategorieById(int id) throws SQLException{
         String req = "select * from categorie where id="+id;
         ResultSet rs=ste.executeQuery(req);
        while (rs.next()) {            
            System.out.println("id categorie :"+rs.getInt("id"));
            System.out.println("type :"+rs.getString("type"));
            System.out.println("image :"+rs.getString("image"));
        }
        rs.close();
         
     }
}
