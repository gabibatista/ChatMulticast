/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author u15173
 */
public class Chat {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ServidorMulticast server = new ServidorMulticast();
        
        new Thread(() -> {
            while (true){
                try{
                    String message = reader.readLine();
                    server.sendMessage(message);
                }
                catch(IOException error){
                    
                }
            }
        }).start();
        
        ClienteMulticast client = new ClienteMulticast();
    }
    
}
