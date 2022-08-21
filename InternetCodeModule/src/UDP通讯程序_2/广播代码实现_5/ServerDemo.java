package UDP通讯程序_2.广播代码实现_5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//广播与单播的接收端代码一致
public class ServerDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(10000);

        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);

        ds.receive(dp);

        System.out.println(new String(dp.getData(), 0, dp.getLength()));

        ds.close();
    }
}
