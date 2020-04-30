package org.example.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.example.model.Message;
import org.example.service.MessageService;

@Path("/messages")
public class MessageResource {

  MessageService messageService = new MessageService();

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public List<Message> getMessages() {
      return messageService.getAllMessages();
  }

}
