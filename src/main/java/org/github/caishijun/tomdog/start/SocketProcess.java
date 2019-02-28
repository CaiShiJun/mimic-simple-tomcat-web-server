package org.github.caishijun.tomdog.start;

import org.github.caishijun.tomdog.http.Request;
import org.github.caishijun.tomdog.http.Response;
import org.github.caishijun.tomdog.servlet.AbstractServlet;

import java.io.OutputStream;
import java.net.Socket;


public class SocketProcess extends Thread{

    protected Socket socket;

    public SocketProcess(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());
            String servletName = (String) Tomdog.SERVLET_MAPPING.get(request.getUrl());
            if(servletName!=null && !servletName.isEmpty()) {
                //映射有的话找到对应的对象
                AbstractServlet servlet = (AbstractServlet) Tomdog.SERVLET.get(servletName);
                if(servlet!=null) {
                    servlet.doGet(request, response);
                }else {
                    System.out.println("找不到对应的servlet");
                }
            }else {
                System.out.println("找不到对应的servletMapping");
            }
            String res = Response.RESPONSE_HEADER + response.getWrite();
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(res.getBytes("GBK"));
            outputStream.flush();
            outputStream.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
