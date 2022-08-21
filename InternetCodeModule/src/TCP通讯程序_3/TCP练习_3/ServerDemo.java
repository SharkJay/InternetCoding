package TCP通讯程序_3.TCP练习_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class ServerDemo {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10002);

        //等待客户端的连接
        Socket accept = serverSocket.accept();

        //一旦连接到客户端，就读取客户端写出的数据
        /*InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1){
            System.out.println((char)b);
        }*/

        //用转换流
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        //打印结束之后给客户端一个回写数据，此时对于服务器来说，他是往外写的
        /*OutputStream os = accept.getOutputStream();
        os.write("你寄吧谁啊？！".getBytes());*/

        //用转换流改写
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("你寄吧谁啊？！");
        bw.flush();
        bw.close();

        //关流
        //os.close();
        br.close();
        accept.close();
        serverSocket.close();

        //此时数据已经写到客户端了，现在到客户端写代码
    }
}
