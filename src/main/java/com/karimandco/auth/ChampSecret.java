/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.auth;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;

/**
 *
 * @author Damien F, Pawel R, Théo M
 */
public class ChampSecret extends JPasswordField implements KeyListener {

    public ChampSecret() {
        super();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Cette méthode vérifie le format du mot de passe et retourne vrai ou faux.
     *
     * @return Boolean true or false
     */
    public Boolean verifPassword() {
        Boolean passwordOK = true;
        String password = String.valueOf(this.getPassword());

        if (password.equals("")) {
            passwordOK = false;
        } else {
            Pattern p = Pattern.compile("^(\\p{Digit}){6,12}");
            Matcher m = p.matcher(password);
            passwordOK = m.matches();
        }

        return passwordOK;
    }
}
