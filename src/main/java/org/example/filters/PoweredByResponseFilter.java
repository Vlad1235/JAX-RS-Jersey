package org.example.filters;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * Хотим чтобы в каждом заголовке ответа клиенту была надпись powered by javabrains
 */
@Provider // регистрируем
public class PoweredByResponseFilter implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    responseContext.getHeaders().add("X-Powered-By","JavaBrains");
  }
}
