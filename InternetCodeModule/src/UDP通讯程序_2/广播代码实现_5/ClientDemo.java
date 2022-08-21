package UDP通讯程序_2.广播代码实现_5;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();

        //DatagramPacket​(byte[] buf, int length, InetAddress address, int port)
        String s = "广播代码实现";
        byte[] bytes = s.getBytes();
        int length = bytes.length;
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, length, address, port);

        ds.send(dp);

        ds.close();
    }
}
