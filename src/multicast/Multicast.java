package multicast;


import java.net.*;
import java.io.*;
import java.*;
import java.util.Scanner;

public class Multicast{
    public static void main(String args[]){ 
		// args give message contents and destination multicast group (e.g. "228.5.6.7")
		MulticastSocket s =null;
                String word;
                String entrada;
		try {
			InetAddress group = InetAddress.getByName("225.168.2.1");
                        int porta = 6789;
			s = new MulticastSocket(porta);
			s.joinGroup(group); //se junta ao grupo
                        Scanner input = new Scanner(System.in);
 			System.out.println("Digite seu nome");
                        String nome = input.nextLine();  
                       
                        //cria Thread de leitura
                        Ler mt = new Ler(s, nome);
                        Thread lendo = new Thread(mt);
                        lendo.start();
                        // Cria thread de escrita
                       
                        System.out.println("Escreva o que deseja enviar e digite enter");  
                           nome = nome + ":";//adciona diz a mensagem
                          do{
                              
                           entrada = input.nextLine(); 
                           word = nome+entrada; //adciona o nome a mensagem
                           // System.out.println("teste");
                            byte [] m = word.getBytes();
                            
                            DatagramPacket messageOut = new DatagramPacket(m, m.length, group, porta);
                            s.send(messageOut);
                            
                            
                        
                              
                        }while (!entrada.equals("sair"));
                        s.leaveGroup(group);
                        
                        
                        
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(s != null) s.close();}
	}		      	
  
    

       
}

