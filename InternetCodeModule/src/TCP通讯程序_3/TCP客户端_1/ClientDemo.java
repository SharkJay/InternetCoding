package TCP通讯程序_3.TCP客户端_1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {

        //创建客户端的Socket对象(Socket)
        //Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号
        Socket s = new Socket("127.0.0.1", 10001);

        //获取输出流，写数据
        //OutputStream getOutputStream() 返回此套接字的输出流
        OutputStream os = s.getOutputStream();
        os.write("asb".getBytes("UTF-8"));

        os.close();
        s.close();
    }
}
