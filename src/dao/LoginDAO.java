/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alex
 */
public class LoginDAO {
    
    private Connection connection;
    
    public LoginDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    public boolean validaLogin(String usuario, String senha) throws Exception{ 
        
        String sql = "SELECT 1 FROM usuario WHERE nome = ? and senha = ?";
        
        PreparedStatement stmt;
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, usuario);
        stmt.setString(2, senha);
        
        try {
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next())return true;
        } catch (SQLException ex) {
            
            throw ex;
        } finally {
            
            stmt.close();
        }
        return false;
    }
}
