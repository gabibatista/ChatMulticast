package chat;

import java.net.*;

public class ClienteMulticast {
    MulticastSocket multicastSocket;
    InetAddress address;
    public ClienteMulticast() {
        while(true) {
            try {
                multicastSocket = new MulticastSocket(12345);
                address = InetAddress.getByName("224.2.2.1");
                multicastSocket.joinGroup(address);
                byte rec[] = new byte[256];
                DatagramPacket datagramPacket = new DatagramPacket(rec, rec.length);
                multicastSocket.receive(datagramPacket);
                String data = new String(datagramPacket.getData());
                System.out.println("Outro:" + data);
            }
            catch(Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}