/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.Color;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import java.awt.event.*;
/**
 *
 * @author Administrador
 */
public class Ventana extends JFrame implements WindowListener {
    public Ventana(String tittle)
    {
        super(tittle);
        setSize(500,500);
        addWindowListener(this);
        setBackground(Color.white);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {System.exit(0);}

    @Override
    public void windowClosed(WindowEvent e) {
         }

    @Override
    public void windowIconified(WindowEvent e) {
         }

    @Override
    public void windowDeiconified(WindowEvent e) {
           }

    @Override
    public void windowActivated(WindowEvent e) {
         }

    @Override
    public void windowDeactivated(WindowEvent e) {
          }
    
}
