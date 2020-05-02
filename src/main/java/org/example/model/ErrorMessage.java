package org.example.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Json format error message
 * Сами создаем формат, в котором ошибки будут отправляться в response
 */

@XmlRootElement
public class ErrorMessage {

  private String errorMessage;
  private int errorCode;
  private String documentation; // куда обратиться чтоб решить

  public ErrorMessage() {
  }

  public ErrorMessage(String errorMessage, int errorCode, String documentation) {
    this.errorMessage = errorMessage;
    this.errorCode = errorCode;
    this.documentation = documentation;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getDocumentation() {
    return documentation;
  }

  public void setDocumentation(String documentation) {
    this.documentation = documentation;
  }
}
