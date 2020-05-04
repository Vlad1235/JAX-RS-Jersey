package org.example.model;

/**
 * HATEOAS
 * Не нужна аннотация XmlRootElement. так как данный класс просто хранитель формата ссылок
 */
public class Link {

  private String link;
  private String rel;

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getRel() {
    return rel;
  }

  public void setRel(String rel) {
    this.rel = rel;
  }
}
