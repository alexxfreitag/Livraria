/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import gui.LoginGUI;

/**
 *
 * @author Alex
 */
public class Principal {
    
    public static void main(String[] args) {
        // TODO code application logic here
        LoginGUI login = new LoginGUI();
        login.setLocationRelativeTo(null); //programa inicia no meio da tela
        login.setVisible(true);
    }
}
