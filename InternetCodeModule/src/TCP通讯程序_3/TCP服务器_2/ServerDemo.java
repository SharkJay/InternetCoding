package TCP通讯程序_3.TCP服务器_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*Java为客户端提供了Socket类，为服务器端提供了ServerSocket类
 * 客户端发送数据，服务器端接收数据*/
public class ServerDemo {
    public static void main(String[] args) throws IOException {

        //创建服务器端Socket对象
        ServerSocket ss = new ServerSocket(10001);

        //Socket accept​() 侦听要连接到此套接字并接受它
        Socket accept = ss.accept();

        /*针对客户端来讲,是往外写的,所以是输出流
        针对服务器来讲,是往里读的,所以是输入流*/
        InputStream is = accept.getInputStream();
        int by;
        while ((by = is.read()) != -1) {
            System.out.print((char) by);
        }

        is.close();
        ss.close();
    }
}
