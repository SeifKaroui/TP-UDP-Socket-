import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1250;
            
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            
            String message = "Hello from client";
            sendData = message.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            
            String response = new String(receivePacket.getData());
            System.out.println("Response from server: " + response);
            
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
