package consumer;

import framework.Invocation;
import framework.ProxyFactory;
import protocol.http.HttpClient;
import provider.HelloService;

/**
 * Created by majianghua on 2019/8/29.
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        helloService.sayhello("马江华asd");

//        Invocation invocation = new Invocation(
//                HelloService.class.getName(),
//                "sayhello",
//                new Class[]{String.class},
//                new Object[]{"马江华1"}
//        );
//        String result = HttpClient.send("localhost", 8080, invocation);
    }
}