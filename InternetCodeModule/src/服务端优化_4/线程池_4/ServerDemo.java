package 服务端优化_4.线程池_4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerDemo {
    public static void main(String[] args) throws IOException {

        //创建服务器端对象
        ServerSocket ss = new ServerSocket(10010);
        //创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                /*核心线程数量*/
                3,
                /*最大线程数量*/
                10,
                /*空闲线程最大存活时间*/
                60,
                /*时间单位*/
                TimeUnit.SECONDS,
                /*阻塞队列*/
                new ArrayBlockingQueue<>(5),
                /*创建线程的方式*/
                Executors.defaultThreadFactory(),
                /*任务的拒绝策略*/
                new ThreadPoolExecutor.AbortPolicy()
        );

        while (true) {
            //等待链接客户端，连接上了就执行后面的代码
            Socket accept = ss.accept();
            SocketRunnable sr = new SocketRunnable(accept);

            //一旦有客户端请求，就开启一条线程运行，main线程则继续while循环，等待下一个客户端连接，再开启新一条线程
            //实现同时跟多个客户端通讯
            //new Thread(sr).start();
            threadPoolExecutor.submit(sr);
        }
        //ss.close();

    }
}
