/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;


/**
 * Generated from json example
{
  "href" : "https://itunes.apple.com/us/developer/bitstrips/id694701217?mt=8&uo=2"
}

 */

public class ImArtistAttributes {

  
  private String href;

  public String getHref() {
    return href;
  }

  /**
  * Builder for ImArtistAttributes
  **/
  public static class ImArtistAttributesBuilder {
    private ImArtistAttributes toBuild = new ImArtistAttributes();

    public ImArtistAttributesBuilder() {
    }

    public ImArtistAttributes build() {
      return toBuild;
    }

    public ImArtistAttributesBuilder href(String value) {
      toBuild.href = value;
      return this;
    }
  }
}
