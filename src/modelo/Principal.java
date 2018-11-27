/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.LivroDAO;
import dao.UsuarioDAO;
import factory.ConnectionFactory;
import gui.LoginGUI;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alex
 */
public class Principal {
    
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioDAO usuario = new UsuarioDAO();
        usuario.cria();
        LivroDAO livro = new LivroDAO();
        livro.cria();
        LoginGUI login = new LoginGUI();
        login.setLocationRelativeTo(null); //programa inicia no meio da tela
        login.setVisible(true);
    }
    
    
}
