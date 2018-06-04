/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_so_threads;

/**
 *
 * @author Beto
 */
public class FarolLargada extends Thread{
    
    public void run(){
        try {
            System.out.println("Preparados?");
            Thread.sleep(500);
            System.out.println("3");
            Thread.sleep(500);
            System.out.println("2");
            Thread.sleep(500);
            System.out.println("1");
            Thread.sleep(500);
            System.out.println("foi dada a largada!");
            Thread.sleep(300);
            
        } catch (Exception e) {
        }
    }
}
