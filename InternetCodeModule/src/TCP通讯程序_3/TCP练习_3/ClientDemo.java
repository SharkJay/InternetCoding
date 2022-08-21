package TCP通讯程序_3.TCP练习_3;

import java.io.*;
import java.net.Socket;

//客户端
public class ClientDemo {
    public static void main(String[] args) throws IOException {

        //Socket​(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号。
        //主机名称可以是机器名称，也可以是IP地址，这里采用ip地址
        Socket socket = new Socket("127.0.0.1", 10002);

        //往外写
        OutputStream os = socket.getOutputStream();
        os.write("你特么什么玩意aaa".getBytes());//把hello写到服务器端
        //os.close();
        //os.close();在这里写close会导致整个socket关闭，Socket is closed
        //写一个结束标记，void shutdownOutput​() 禁用此套接字的输出流。
        socket.shutdownOutput();


        //读取服务器端写出的数据
        /*InputStream is = socket.getInputStream();
        int b;
        //一次读一个字节
        while ((b = is.read()) != -1){
            System.out.println((char)b);
        }*/

        /*因为服务器端写的是"你寄吧谁啊"，有中文有英文，以上的字节流一次读取一个字节，
        UTF-8一个中文用三个字节表示，所以打印出来会乱码，这里用 字符缓冲流 将字节流转换成字符流
        一次读取一整行数据*/

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        //一次读一行，利用BufferedReader中的readline方法
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();

        os.close();
        socket.close();
    }
}
