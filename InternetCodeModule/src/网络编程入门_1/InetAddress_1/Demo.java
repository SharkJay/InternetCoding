package 网络编程入门_1.InetAddress_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo {
    public static void main(String[] args) throws UnknownHostException {

    /*static InetAddress getByName(String host) 确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
    String getHostName() 获取此IP地址的主机名
    String getHostAddress() 返回文本显示中的IP地址字符串*/

        //返回一个InetAddress对象
        InetAddress byName = InetAddress.getByName("DESKTOP-M2D95M3");

        String hostName = byName.getHostName();
        System.out.println("主机名为：" + hostName);

        String hostAddress = byName.getHostAddress();
        System.out.println("ip地址为：" + hostAddress);

    }
}
