/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade.main;

import br.com.ifba.atividade03.Viewcalculadora;
import br.com.ifba.atividade04.view.Viewgenio;
import br.com.ifba.atividade05.view.TelaFatorial;

/**
 *
 * @author edina
 */

public class main {
    
   
    public static void main(String[] args) {
        // Abre a calculadora por padrão
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new Viewcalculadora().setVisible(true);
                //new Viewgenio().setVisible(true);
                new TelaFatorial().setVisible(true);
            }
        });
    }
}
    

