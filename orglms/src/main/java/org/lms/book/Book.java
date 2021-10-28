package org.lms.book;

import java.util.List;
import lombok.Data;

@Data
public abstract class Book {

  private String title;
  private String author;
  private List<String> publishers;
  private String isbn;
  private String rackId;
}
