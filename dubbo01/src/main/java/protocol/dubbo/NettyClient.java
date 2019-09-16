package protocol.dubbo;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import framework.Invocation;

/**
 * Created by majianghua on 2019/8/29.
 */
public class NettyClient {
    public static String send(String hostName, int port, Invocation invocation) {
        try {
            System.out.println("netty");
            URL url = new URL("http", hostName, port, "/");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream os = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream is = httpURLConnection.getInputStream();
            String result = IOUtils.toString(is);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}