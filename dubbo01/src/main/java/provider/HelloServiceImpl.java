package provider;

/**
 * Created by majianghua on 2019/8/29.
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayhello(String userName) {
        String s = "hello:" + userName;
        System.out.println(s);
        return s;
    }
}