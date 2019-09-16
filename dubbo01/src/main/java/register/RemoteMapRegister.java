package register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import framework.URL;

/**
 * Created by majianghua on 2019/8/29.
 */
public class RemoteMapRegister {
    private static Map<String, List<URL>> map = new HashMap<>();

    public static void regist(String interfaceName, URL url) {
        List<URL> urls = map.get(interfaceName);
        if (urls == null) {
            urls = new ArrayList<>();
            map.put(interfaceName, urls);
        }
        urls.add(url);
    }

    public static URL getRandomUrl(String interfaceName) {
        List<URL> urls = map.get(interfaceName);
        Random random = new Random();
        int n = random.nextInt(urls.size());
        return urls.get(n);
    }
}