/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast;
import java.net.*;
import java.io.*;
import java.*;
import java.net.DatagramPacket;

/**
 *
 * @author Neiva
 */
public class Ler implements Runnable{
   
    MulticastSocket s;
    
    String nome;
    public Ler(MulticastSocket s, String nome){
        
        this.s = s;
        
        
    }
    @Override
	        public void run() {
	            try{
                        byte[] buffer = new byte[1000];
                        //System.out.println("Thread de leitura iniciada");
	                do{
                            
	                    DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                            this.s.receive(messageIn);
                            
                            
                            String mensagem = new String(messageIn.getData());
                            
                            String mensagemQuebrada[] = mensagem.split(":");
                            String cod = mensagemQuebrada[1];
                            
                               System.out.println(cod);
                                
                           
                            
                            System.out.println(mensagem);
                            
	                }while(true);
	            } catch (Exception e){}

	        }
                
              
}
                
             

