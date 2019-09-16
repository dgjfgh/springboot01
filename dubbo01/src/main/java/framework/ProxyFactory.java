package framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import protocol.http.HttpClient;
import provider.HelloService;
import register.RemoteMapRegister;

/**
 * Created by majianghua on 2019/8/29.
 */
public class ProxyFactory {

    public static  <T> T getProxy(Class<T> interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Invocation invocation = new Invocation(
                        interfaceClass.getName(),
                        method.getName(),
                        method.getParameterTypes(),
                        args
                );

//                URL url = RemoteMapRegister.getRandomUrl(interfaceClass.getName());
                URL url = new URL("localhost", 8080);
                Protocol protocol = ProtocolFactory.getProtocol();
                String result = protocol.send(url, invocation);

//                String result = HttpClient.send(url.getHostname(), url.getPort(), invocation);
                return result;
            }
        });
    }

}