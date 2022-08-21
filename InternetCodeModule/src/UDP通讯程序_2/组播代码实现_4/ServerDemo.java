package UDP通讯程序_2.组播代码实现_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//接收端
public class ServerDemo {
    public static void main(String[] args) throws IOException {

        // 1. 创建接收端Socket对象(MulticastSocket)
        //MulticastSocket​(int port) 创建组播套接字并将其绑定到特定端口。
        MulticastSocket ms = new MulticastSocket(10000);

        // 2. 创建一个箱子,用于接收数据
        //DatagramPacket​(byte[] buf, int length) 构造一个 DatagramPacket用于接收长度为 length数据包。
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        // 3. 把当前计算机绑定一个组播地址,表示添加到这一组中.
        //void joinGroup​(InetAddress mcastaddr) 加入组播组。
        ms.joinGroup(InetAddress.getByName("224.0.1.0"));

        // 4. 将数据接收到箱子中
        ms.receive(dp);

        // 5. 解析数据包,并打印数据
        byte[] data = dp.getData();
        int length = dp.getLength();
        String s = new String(data,0,length);
        System.out.println(s);

        ms.close();
    }
}
