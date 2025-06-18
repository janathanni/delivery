package com.delivery.api.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(req, res);

        // Request Header
        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        headerNames.asIterator().forEachRemaining(headerKey -> {
            var headerValue = req.getHeader(headerKey);
            
            headerValues.append("[")
                .append(headerKey)
                .append(" : ")
                .append(headerValue)
                .append("] ");
        });

        var requestBody = new String(req.getContentAsByteArray(), StandardCharsets.UTF_8);
        var uri = req.getRequestURI();
        var method = req.getMethod();



        log.info(">>>>>> Request uri : {}, method : {} header : {}, body : {}", uri, method, headerValues, requestBody);

        // Response Header
        var responseHeaderValues = new StringBuilder();

        res.getHeaderNames().forEach(headerKey -> {
            var headerValue = res.getHeader(headerKey);
            responseHeaderValues.append("[")
                .append(headerKey)
                .append(" : ")
                .append(headerValue)
                .append("] ");
        });

        var responseBody = new String(res.getContentAsByteArray(), StandardCharsets.UTF_8);

        log.info("<<<<<< Response header : {}, body : {}", responseHeaderValues, responseBody);

        res.copyBodyToResponse();
    }
}
