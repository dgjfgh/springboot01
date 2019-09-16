package protocol.dubbo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import protocol.http.HttpServerHandler;

/**
 * Created by majianghua on 2019/8/29.
 */
public class DispatchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new NettyServerHandler().handler(req,resp);
    }
}