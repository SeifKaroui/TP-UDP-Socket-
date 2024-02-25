import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress serverAddress = InetAddress.getByName("localhost");

    int serverPort = 12345;

    Voiture v = new Voiture("Tesla", "3");


    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
    objectStream.writeObject(v);

    objectStream.flush();

    byte[] data = byteStream.toByteArray();
    DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);

    socket.send(packet);

    System.out.println("Sent voiture object to server.");

    socket.close();

  }
}
