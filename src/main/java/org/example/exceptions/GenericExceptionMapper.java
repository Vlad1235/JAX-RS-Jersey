package org.example.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import org.example.model.ErrorMessage;

/**
 * Перехват асолютно всех возможных(не обработанных нами самостоятельно как например DataNotFoundExceptionMapper) исключений.
 */
//@Provider  отключил, чтобы работало WebApplicationException
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable exception) {
    ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "http://example.com");
    return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
  }
}
