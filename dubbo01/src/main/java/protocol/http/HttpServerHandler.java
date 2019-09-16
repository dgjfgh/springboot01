package protocol.http;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Invocation;
import provider.LocalRegister;

/**
 * Created by majianghua on 2019/8/29.
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){
        //处理请求返回结果
        try {
            ServletInputStream is = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Invocation invocation = (Invocation) ois.readObject();


            Class implClass = LocalRegister.get(invocation.getInterfaceName());
            Method method = implClass.getDeclaredMethod(invocation.getMethodName(), invocation.getParamsType());
            method.setAccessible(true);

            Object result = method.invoke(implClass.newInstance(), invocation.getParams());

            IOUtils.write(result.toString(),resp.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}