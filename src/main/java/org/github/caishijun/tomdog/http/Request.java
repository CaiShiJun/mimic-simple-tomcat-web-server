package org.github.caishijun.tomdog.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Request {

    private String method;

    private String url;

    public Request(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String[] methodAndUrl = bufferedReader.readLine().split(" ");
        this.method = methodAndUrl[0];
        this.url = methodAndUrl[1];
        System.out.println("请求类型："+ method);
        System.out.println("请求路径："+ url);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
