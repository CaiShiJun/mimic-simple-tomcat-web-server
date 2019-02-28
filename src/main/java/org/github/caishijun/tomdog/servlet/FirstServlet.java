package org.github.caishijun.tomdog.servlet;

import org.github.caishijun.tomdog.http.Request;
import org.github.caishijun.tomdog.http.Response;


public class FirstServlet extends AbstractServlet {

    @Override
    public void doGet(Request request, Response response) {
        String threadName = Thread.currentThread().getName();

        response.setWrite(threadName);
    }

    @Override
    public void doPost(Request request, Response response) {
        this.doGet(request, response);
    }
}
