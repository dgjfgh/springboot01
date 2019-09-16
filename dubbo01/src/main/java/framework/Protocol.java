package framework;

/**
 * Created by majianghua on 2019/8/29.
 */
public interface Protocol {
    void start(URL url);

    String send(URL url, Invocation invocation);
}