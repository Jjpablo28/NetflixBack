package co.edu.unbosque.miprimerspingboot.dto;

public class FactDTO {

  private String id;
  private String text;
  private String source;
  private String source_url;
  private String language;
  private String permalink;

  public FactDTO() {
    // TODO Auto-generated constructor stub
  }

  public FactDTO(String text, String source, String source_url, String language, String permalink) {
    super();
    this.text = text;
    this.source = source;
    this.source_url = source_url;
    this.language = language;
    this.permalink = permalink;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSource_url() {
    return source_url;
  }

  public void setSource_url(String source_url) {
    this.source_url = source_url;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getPermalink() {
    return permalink;
  }

  public void setPermalink(String permalink) {
    this.permalink = permalink;
  }

  @Override
  public String toString() {
    return "FactDTO [id="
        + id
        + ", text="
        + text
        + ", source="
        + source
        + ", source_url="
        + source_url
        + ", language="
        + language
        + ", permalink="
        + permalink
        + "]";
  }
}
