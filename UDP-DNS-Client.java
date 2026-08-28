import java.io.*;
import java.net.*;

public class UDPDNSClient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress ipAddress;
        int portAddr = 1362;  // You can change this to match the server port

        // Determine IP address
        if (args.length == 0) {
            ipAddress = InetAddress.getLocalHost();
        } else {
            ipAddress = InetAddress.getByName(args[0]);
        }

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        // Read hostname from user
        System.out.print("Enter the hostname: ");
        String sentence = br.readLine();
        sendData = sentence.getBytes();

        // Create and send packet to server
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, portAddr);
        clientSocket.send(sendPacket);

        // Receive reply from server
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        // Extract and display the result
        String modified = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("IP Address: " + modified);

        // Close socket
        clientSocket.close();
    }
}