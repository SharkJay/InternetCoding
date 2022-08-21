package 服务端优化_4.多线程优化_3;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class SocketRunnable implements Runnable {
    private Socket acceptSocket;

    public SocketRunnable(Socket accept) {
        this.acceptSocket = accept;
    }

    BufferedOutputStream bos = null;

    @Override
    public void run() {
        try {
            //从网络中读取客户端传来的数据，字节缓冲流提高效率
            BufferedInputStream bis = new BufferedInputStream(acceptSocket.getInputStream());
            //读取后再把数据写入本地文件中
            bos = new BufferedOutputStream(new FileOutputStream("InternetCodeModule\\" + UUID.randomUUID().toString() + ".png"));

            //边读边写
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

            //写完之后再给客户端返回一个消息，告诉客户端我已经写完了，这里的消息包含中文，使用字符缓冲流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
            bw.write("上传成功！服务器端接收到客户端传来的数据了！");
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (acceptSocket != null) {
                try {
                    acceptSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
