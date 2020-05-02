package org.example.interceptors;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 * сжимаем тело любого ответа перед отправкой клиенту
 */
//@Provider
public class GZIPWriterInterceptor implements WriterInterceptor {

  @Override
  public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
    final OutputStream outputStream = context.getOutputStream();
    context.setOutputStream(new GZIPOutputStream(outputStream));
    context.proceed();
  }
}
