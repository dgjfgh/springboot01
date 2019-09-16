package protocol.http;

import framework.Invocation;
import framework.Protocol;
import framework.URL;
import protocol.dubbo.NettyClient;
import protocol.dubbo.NettyServer;

/**
 * Created by majianghua on 2019/8/29.
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return HttpClient.send(url.getHostname(), url.getPort(), invocation);
    }
}