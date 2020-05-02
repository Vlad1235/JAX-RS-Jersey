package org.example.filters;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * Вывести в консоль заголовок каждого входщего запроса и также каждого исходящего ответа клиенту
 */
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    System.out.println("Request Headers: "+requestContext.getHeaders());
  }

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    System.out.println("Response Headers: "+responseContext.getHeaders());
  }
}
