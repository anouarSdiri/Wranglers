/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pijava;

import DAO.AssociationDAO;
import DAO.CategorieDAO;
import Entity.Association;
import Entity.Categorie;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijava.utils.MyConnection;



/**
 *
 * @author Anouar
 */
public class PiJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Categorie  categorie= new Categorie();
        categorie.setId(1);
       
        Association a = new Association();
        a.setNom("association name");
        a.setImage("association image");
        a.setCategorie(categorie);
        CategorieDAO categorieDAO = new CategorieDAO();
        AssociationDAO associationDAO = new AssociationDAO();
        try {
           // categorieDAO.ajouter(categorie);
            //categorieDAO.update(categorie);
            //categorieDAO.afficher();
            //categorieDAO.delete(2);
            //associationDAO.ajouter(a);
            associationDAO.afficher();
            
        } catch (SQLException ex) {
            Logger.getLogger(PiJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     
    }
    
}
