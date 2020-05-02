package org.example.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.codec.binary.Base64;

/**
 * Закрытие доступа лишь для ресурса /secured/...
 */
//@Provider
public class SecurityFilterForCertainResourceOnly implements ContainerRequestFilter {

  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
  private static final String SECURED_URI_PREFIX = "secured";

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    if (requestContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)) {
      List<String> authorizationHeaders = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
      if (authorizationHeaders != null && authorizationHeaders.size() > 0) {
        String authToken = authorizationHeaders.get(0); // take first one
        authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, ""); // очищаем от префикса
        byte[] decoded = Base64.decodeBase64(authToken);
        String decodedString = new String(decoded, StandardCharsets.UTF_8);
        StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
        String username = tokenizer.nextToken();
        String password = tokenizer.nextToken();
      /*
      ниже вариант лишь для упрощения!!!
       */
        if ("user".equals(username) && "12345".equals(password)) {
          return;
        }
      }
    }
    /*
    если клиент не прошел аутентификацию или заголовка с credentials нет
     */
    Response unauthorizedStatus = Response
        .status(Status.UNAUTHORIZED)
        .entity("User cannot access the resource")
        .build();
    requestContext.abortWith(unauthorizedStatus);
  }
}
