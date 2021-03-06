/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;


/**
 * Generated from json example
{
  "im:id" : "6002",
  "term" : "Utilities",
  "scheme" : "https://itunes.apple.com/us/genre/ios-utilities/id6002?mt=8&uo=2",
  "label" : "Utilities"
}

 */

public class CategoryAttributes {

  
@com.google.gson.annotations.SerializedName("im:id")
  private String imId;

  
  private String label;

  
  private String scheme;

  
  private String term;

  public String getImId() {
    return imId;
  }
  public String getLabel() {
    return label;
  }
  public String getScheme() {
    return scheme;
  }
  public String getTerm() {
    return term;
  }

  /**
  * Builder for CategoryAttributes
  **/
  public static class CategoryAttributesBuilder {
    private CategoryAttributes toBuild = new CategoryAttributes();

    public CategoryAttributesBuilder() {
    }

    public CategoryAttributes build() {
      return toBuild;
    }

    public CategoryAttributesBuilder imId(String value) {
      toBuild.imId = value;
      return this;
    }
    public CategoryAttributesBuilder label(String value) {
      toBuild.label = value;
      return this;
    }
    public CategoryAttributesBuilder scheme(String value) {
      toBuild.scheme = value;
      return this;
    }
    public CategoryAttributesBuilder term(String value) {
      toBuild.term = value;
      return this;
    }
  }
}
