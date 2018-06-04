/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_so_threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beto
 */
public class CarrosThread extends Thread{
    
    private String nome;
    private String equipe;
    private int tempoVolta;

    //metodo construtor
    public CarrosThread(String nome, String equipe, int tempo){
        this.nome = nome;
        this.equipe = equipe;
        this.tempoVolta = tempo;
        start(); //auto starta o run()
    }

    public void run(){        
        try {
            Thread.sleep(tempoVolta);
            System.out.println(nome + "da Equipe: " + equipe + " completou a volta em: " + tempoVolta);            
        } catch (InterruptedException ex) {
            Logger.getLogger(CarrosThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
