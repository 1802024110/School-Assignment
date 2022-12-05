package com.example.videos.exception;

import com.example.videos.note.EmailCheck;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@Provider
@EmailCheck
public class EmailCheckFilter implements ContainerResponseFilter {
    /**
     * @param containerRequestContext
     * @param containerResponseContext
     * @throws IOException
     */
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        log.info("Email check");
        log.info(containerRequestContext.getRequest().toString());
    }
}
