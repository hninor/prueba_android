/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;


/**
 * Generated from json example
{
  "label" : "2014-10-28T19:57:18-07:00",
  "attributes" : {
    "label" : "October28,2014"
  }
}

 */

public class ImReleaseDate {

  
  private ImReleaseDateAttributes attributes;

  
  private String label;

  public ImReleaseDateAttributes getAttributes() {
    return attributes;
  }
  public String getLabel() {
    return label;
  }

  /**
  * Builder for ImReleaseDate
  **/
  public static class ImReleaseDateBuilder {
    private ImReleaseDate toBuild = new ImReleaseDate();

    public ImReleaseDateBuilder() {
    }

    public ImReleaseDate build() {
      return toBuild;
    }

    public ImReleaseDateBuilder attributes(ImReleaseDateAttributes value) {
      toBuild.attributes = value;
      return this;
    }
    public ImReleaseDateBuilder label(String value) {
      toBuild.label = value;
      return this;
    }
  }
}
