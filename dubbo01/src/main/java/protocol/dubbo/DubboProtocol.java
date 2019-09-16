package protocol.dubbo;

import framework.Invocation;
import framework.Protocol;
import framework.URL;

/**
 * Created by majianghua on 2019/8/29.
 */
public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new NettyServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return NettyClient.send(url.getHostname(), url.getPort(), invocation);
    }
}