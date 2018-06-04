/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_so_threads;

import java.util.Random;

/**
 *
 * @author Beto
 */
public class IniciaCorrida {
    public static void main(String[] args) throws InterruptedException{
        
        Random random = new Random();
        int tempoVoltaMin = 1000;
        int numVoltas = 5;  
        
        boolean nextRound = true; 
        
        //instancia o farol de largada ~ perfumaria
        FarolLargada farol = new FarolLargada();
        
        //da um start no farol fazendo com que ele execute oque está no metodo run()
        farol.start();
        
        //aguarda o farol ser excecutado e finalizado
        farol.join();
        
        for(int i = 1; i <= numVoltas; i++){
                        
            if(nextRound == true){
                
                try{
                    nextRound = false;
                
                    //mensagem com numero voltas ~
                    if(i < numVoltas){
                    System.out.println("Volta: " + i);
                    }else if(i == numVoltas){
                        System.out.println("Volta Final!!!\nVencedores por ordem de chegada:");
                    }
                    
                    CarrosThread piloto1 = new CarrosThread("Sebastian Vettel", "Ferrari", random.nextInt(tempoVoltaMin + 1) + 1000); //instancia uma nova thread CarrosThread, com os atributos que o construtor nescessita 
                    CarrosThread piloto2 = new CarrosThread("Kimi Raikkonen", "Ferrari", random.nextInt(tempoVoltaMin + 1) + 1000);
                    CarrosThread piloto3 = new CarrosThread("Fernando Alonso", "McLaren", random.nextInt(tempoVoltaMin + 1) + 1000);
                    CarrosThread piloto4 = new CarrosThread("Stoffel Vandoorne", "McLaren", random.nextInt(tempoVoltaMin + 1) + 1000);
                    CarrosThread piloto5 = new CarrosThread("Lewis Hamilton", "Mercedes", random.nextInt(tempoVoltaMin + 1) + 1000);
                    CarrosThread piloto6 = new CarrosThread("Valtteri Bottas", "Mercedes", random.nextInt(tempoVoltaMin + 1) + 1000);

                
                    piloto1.join(); //espera thread piloto1 acabar;
                    piloto2.join(); //...
                    piloto3.join(); //..
                    piloto4.join(); //..
                    piloto5.join(); //..
                    piloto6.join(); //..
                    
                    
                    //verifica se o estado de todas as threads ja ta em terminado se estiver vai para proxima volta
                    if(piloto1.getState() == Thread.State.TERMINATED && piloto2.getState() == Thread.State.TERMINATED && piloto3.getState() == Thread.State.TERMINATED && piloto4.getState() == Thread.State.TERMINATED && piloto5.getState() == Thread.State.TERMINATED && piloto6.getState() == Thread.State.TERMINATED){
                        //System.out.println("todos completaram a volta.");
                        nextRound = true;
                    }
                    
                }catch(InterruptedException e){
                    //..
                }
                               
            }
            
        }
    }
    
}
