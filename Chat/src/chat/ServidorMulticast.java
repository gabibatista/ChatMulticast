package chat;

import java.io.IOException;
import java.net.*;

public class ServidorMulticast {
    DatagramSocket datagramSocket;
    MulticastSocket multicastSocket;
    InetAddress address;
    
    public ServidorMulticast() { //constructor
        try {
            String message;

            address = InetAddress.getByName("224.2.2.1");
           
            datagramSocket = new DatagramSocket();
            
            multicastSocket = new MulticastSocket();
            multicastSocket.joinGroup(address);
        }
        catch(Exception e) {
            System.out.println("Nao foi possível enviar a mensagem");
        }
    }

    public void sendMessage(String message) throws IOException{
        byte[] b = message.getBytes();        
        multicastSocket.send(new DatagramPacket(b, b.length, address, 12346));
    }
}