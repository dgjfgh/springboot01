package framework;

import java.util.Iterator;
import java.util.ServiceLoader;

import protocol.dubbo.DubboProtocol;
import protocol.http.HttpProtocol;

/**
 * Created by majianghua on 2019/8/29.
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {

        //java spi 机制
        ServiceLoader<Protocol> serviceLoader=ServiceLoader.load(Protocol.class);
        Iterator<Protocol> iterator = serviceLoader.iterator();
        return iterator.next();

        //Java启动参数机制
//        String name = System.getProperty("protocolName");
//        if (name == null || name.equals("")) {
//            name = "http";
//        }
//
//        switch (name) {
//            case "http":
//                return new HttpProtocol();
//            case "dubbo":
//                return new DubboProtocol();
//            default:
//                return new HttpProtocol();
//        }
    }
}