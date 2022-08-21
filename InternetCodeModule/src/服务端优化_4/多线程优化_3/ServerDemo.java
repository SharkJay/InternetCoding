package 服务端优化_4.多线程优化_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerDemo {
    public static void main(String[] args) throws IOException {

        //创建服务器端对象
        ServerSocket ss = new ServerSocket(10010);

        while (true) {
            //等待链接客户端，连接上了就执行后面的代码
            Socket accept = ss.accept();
            SocketRunnable sr = new SocketRunnable(accept);

            //一旦有客户端请求，就开启一条线程运行，main线程则继续while循环，等待下一个客户端连接，再开启新一条线程
            //实现同时跟多个客户端通讯
            new Thread(sr).start();
        }
        //ss.close();

    }
}
