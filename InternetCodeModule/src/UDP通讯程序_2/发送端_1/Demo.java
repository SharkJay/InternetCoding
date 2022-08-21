package UDP通讯程序_2.发送端_1;

import java.io.IOException;
import java.net.*;

public class Demo {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();

        String s = "我要发送的数据";
        byte[] bytes = s.getBytes();
        /*DatagramPacket​(byte[] buf, int length, InetAddress address, int port)
         构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号。  */
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),10086);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
