/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;


/**
 * Generated from json example
{
  "label" : "2016-08-21T12:27:52-07:00"
}

 */

public class Updated {

  
  private String label;

  public String getLabel() {
    return label;
  }

  /**
  * Builder for Updated
  **/
  public static class UpdatedBuilder {
    private Updated toBuild = new Updated();

    public UpdatedBuilder() {
    }

    public Updated build() {
      return toBuild;
    }

    public UpdatedBuilder label(String value) {
      toBuild.label = value;
      return this;
    }
  }
}
