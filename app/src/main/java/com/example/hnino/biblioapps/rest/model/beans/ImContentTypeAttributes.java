/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;


/**
 * Generated from json example
{
  "term" : "Application",
  "label" : "Application"
}

 */

public class ImContentTypeAttributes {

  
  private String label;

  
  private String term;

  public String getLabel() {
    return label;
  }
  public String getTerm() {
    return term;
  }

  /**
  * Builder for ImContentTypeAttributes
  **/
  public static class ImContentTypeAttributesBuilder {
    private ImContentTypeAttributes toBuild = new ImContentTypeAttributes();

    public ImContentTypeAttributesBuilder() {
    }

    public ImContentTypeAttributes build() {
      return toBuild;
    }

    public ImContentTypeAttributesBuilder label(String value) {
      toBuild.label = value;
      return this;
    }
    public ImContentTypeAttributesBuilder term(String value) {
      toBuild.term = value;
      return this;
    }
  }
}
