package TCP通讯程序_3.TCP练习_4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {

        //创建服务器端对象
        ServerSocket ss = new ServerSocket(10010);

        //等待链接客户端，连接上了就执行后面的代码
        Socket accept = ss.accept();

        //从网络中读取客户端传来的数据，字节缓冲流提高效率
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        //读取后再把数据写入本地文件中
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("InternetCodeModule\\2.png"));

        //边读边写
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }

        //写完之后再给客户端返回一个消息，告诉客户端我已经写完了，这里的消息包含中文，使用字符缓冲流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("上传成功！服务器端接收到客户端传来的数据了！");
        bw.newLine();
        bw.flush();

        //关流
        bos.close();
        accept.close();
        ss.close();

    }
}
