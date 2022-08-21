package 服务端优化_4.循环_1;

import java.io.*;
import java.net.Socket;

//目标：把1.png文件写到服务器端，服务器端收到后写回一个收到信息
public class ClientDemo {
    public static void main(String[] args) throws IOException {

        //创建TCP客户端对象
        Socket socket = new Socket("127.0.0.1", 10010);
        //把1.png从硬盘读取到内存中，利用字节缓冲流，速度会大幅提升
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("InternetCodeModule\\1.png"));
        //写到服务器，利用网络中的流写出
        OutputStream os = socket.getOutputStream();
        //利用字节缓存输出流写出，提高效率
        BufferedOutputStream bos = new BufferedOutputStream(os);

        //边读边写
        int b;
        while ((b = bis.read()) != -1) {
            os.write(b);
        }
        //写出完成后，告诉服务器，给他一个结束标记
        socket.shutdownOutput();

        //接收服务器传来的中文消息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //利用字符缓冲流特有的readline方法一次读一行数据
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        socket.close();
        bis.close();

    }
}
