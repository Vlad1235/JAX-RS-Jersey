package org.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.model.Message;

public class MessageService {

  private List<Message> hardCodedMessageList;

  public MessageService() {
    Message message1 = new Message(1L, "Hello World", "Mr.Jones");
    Message message2 = new Message(2L, "Hello Planet", "Mr.Beck");
    Message message3 = new Message(2L, "Hello Jersey", "Mr.Black");
    this.hardCodedMessageList = new ArrayList<>();
    Collections.addAll(hardCodedMessageList, message1, message2, message3);
  }

  public List<Message> getAllMessages() {
      return hardCodedMessageList;
  }
}
