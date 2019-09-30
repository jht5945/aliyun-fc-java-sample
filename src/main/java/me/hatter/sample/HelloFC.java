package me.hatter.sample;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// https://help.aliyun.com/document_detail/113518.html?spm=a2c4g.11186623.6.558.6fe668f4iye9du
public class HelloFC implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Context context) throws IOException, ServletException {

        StringBuilder sb = new StringBuilder();

        sb.append(httpServletRequest.getContextPath()).append("\n");
        sb.append(httpServletRequest.getRequestURI()).append("\n");
        sb.append(httpServletRequest.getRequestURL()).append("\n");

        String requestPath = (String) httpServletRequest.getAttribute("FC_REQUEST_PATH");
        String requestURI = (String) httpServletRequest.getAttribute("FC_REQUEST_URI");
        String requestClientIP = (String) httpServletRequest.getAttribute("FC_REQUEST_CLIENT_IP");

        sb.append(requestPath).append("\n");
        sb.append(requestURI).append("\n");
        sb.append(requestClientIP).append("\n");

        //httpServletResponse.setHeader("Content-Disposition", "inline");

        httpServletResponse.setContentType("text/plain");
        httpServletResponse.getOutputStream().write(("hello world\n" + sb.toString()).getBytes(StandardCharsets.UTF_8));
    }
}
