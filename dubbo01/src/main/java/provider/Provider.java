package provider;

import framework.Protocol;
import framework.ProtocolFactory;
import framework.URL;
import protocol.http.HttpServer;
import register.RemoteMapRegister;

/**
 * Created by majianghua on 2019/8/29.
 */
public class Provider {

    public static void main(String[] args) {
        //本地注册
        LocalRegister.regist(HelloService.class.getName(),HelloServiceImpl.class);

        //远程注册
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regist(HelloService.class.getName(),url);

        //启动tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(new URL("localhost",8080));
//        HttpServer httpServer=new HttpServer();
//        httpServer.start("localhost",8080);
    }
}