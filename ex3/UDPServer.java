import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1250);
            byte[] receiveData = new byte[1024];
            byte[] sendData;
            
            System.out.println("Server started, waiting for client...");
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                System.out.println("Received request from: " + clientAddress + ":" + clientPort);
                
                // Get current date and time
                Date date = new Date();
                String message = "Current date and time: " + date.toString();
                sendData = message.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                
                System.out.println("Sent response to: " + clientAddress + ":" + clientPort);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
