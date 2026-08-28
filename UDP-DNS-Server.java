import java.io.*;
import java.net.*;

public class udpdnsserver {
    public static void main(String args[]) throws IOException {

        DatagramSocket serversocket = new DatagramSocket(1362);

        byte[] receivedata = new byte[1024];
        byte[] senddata = new byte[1024];

        System.out.println("DNS Server Started...");

        while (true) {

            DatagramPacket recvpack =
                new DatagramPacket(receivedata, receivedata.length);

            serversocket.receive(recvpack);

            String hostname =
                new String(recvpack.getData(), 0, recvpack.getLength());

            System.out.println("Client requested: " + hostname);

            InetAddress clientaddress = recvpack.getAddress();
            int clientport = recvpack.getPort();

            String ipaddress;

            try {
                InetAddress address =
                    InetAddress.getByName(hostname);

                ipaddress = address.getHostAddress();
            }
            catch (UnknownHostException e) {
                ipaddress = "Host not found";
            }

            senddata = ipaddress.getBytes();

            DatagramPacket sendpack =
                new DatagramPacket(
                    senddata,
                    senddata.length,
                    clientaddress,
                    clientport
                );

            serversocket.send(sendpack);

            System.out.println("IP Address sent: " + ipaddress);
        }
    }
}