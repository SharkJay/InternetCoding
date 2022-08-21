package UDP通讯程序_2.组播代码实现_4;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();

        String s = "组播实现";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.1.0");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        ds.send(dp);

        ds.close();
    }
}
