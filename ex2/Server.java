import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DatagramSocket socket = new DatagramSocket(12345);
    byte[] buffer = new byte[1024];


    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

    System.out.println("Server is running...");

    while (true) {


      socket.receive(packet);

      ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData());

      ObjectInputStream objectStream = new ObjectInputStream(byteStream);

      Voiture v = (Voiture) objectStream.readObject();

      v.setCarburant(90); // setting fuel in the car

      System.out.println("Received voiture object from client and set its carburant:");
      System.out.println("Carburant: " + v.getCarburant());
      System.out.println("Capacité: " + v.getCapacite());
      System.out.println();

    }
  }

}
