package org.github.caishijun.tomdog.http;

import java.io.OutputStream;


public class Response {

    /**
     * 响应头信息
     */
    public static final String RESPONSE_HEADER ="HTTP/1.1 200 \r\n"
        + "Content-Type: text/html\r\n"
        + "\r\n";

    private OutputStream outputStream;

    private String write;

    public Response(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

}
