/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;


/**
 * Generated from json example
{
  "label" : "©BitstripsInc."
}

 */

public class Rights {

  
  private String label;

  public String getLabel() {
    return label;
  }

  /**
  * Builder for Rights
  **/
  public static class RightsBuilder {
    private Rights toBuild = new Rights();

    public RightsBuilder() {
    }

    public Rights build() {
      return toBuild;
    }

    public RightsBuilder label(String value) {
      toBuild.label = value;
      return this;
    }
  }
}
