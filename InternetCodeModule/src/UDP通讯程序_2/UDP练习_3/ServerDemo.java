package UDP通讯程序_2.UDP练习_3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(10000);

//DatagramPacket​(byte[] buf, int length) 构造一个 DatagramPacket用于接收长度为 length数据包。
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

            ds.receive(dp);

            byte[] data = dp.getData();
            int length = dp.getLength();
            String s = new String(data, 0, length);
            System.out.println(s);
        }


    }
}
