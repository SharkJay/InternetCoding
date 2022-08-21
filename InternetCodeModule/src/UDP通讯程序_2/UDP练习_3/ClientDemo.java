package UDP通讯程序_2.UDP练习_3;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();

        //DatagramPacket​(byte[] buf, int length, InetAddress address, int port)
        // 构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号。

        while (true) {
            String s = sc.nextLine();
            //如果输入的数据有886，就结束传输
            if("886".equals(s)){
                break;
            }

            byte[] bytes = s.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 10000;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

            ds.send(dp);
        }

        ds.close();

    }
}
