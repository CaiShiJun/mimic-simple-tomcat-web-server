package org.github.caishijun.tomdog.servlet;

import org.github.caishijun.tomdog.http.Request;
import org.github.caishijun.tomdog.http.Response;


public abstract class AbstractServlet {

    public abstract void doGet(Request request, Response response);

    public abstract void doPost(Request request, Response response);
}
