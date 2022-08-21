package UDP通讯程序_2.接收端_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);

        //DatagramPacket​(byte[] buf, int length) 构造一个 DatagramPacket用于接收长度为 length数据包。
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        //接受礼物，将礼物放到新箱子里
        ds.receive(dp);

        //从新箱子获取礼物
        byte[] data = dp.getData();
        String s = new String(data, 0, dp.getLength());
        System.out.println(s);

        ds.close();
    }
}
