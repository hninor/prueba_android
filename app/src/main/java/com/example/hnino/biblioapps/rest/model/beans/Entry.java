/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;

import java.util.List;

/**
 * Generated from json example
{
  "im:name" : {
    "label" : "BitmojiKeyboard-YourAvatarEmoji"
  },
  "im:image" : [ {
    "label" : "http://is1.mzstatic.com/image/thumb/Purple60/v4/f9/ca/a3/f9caa3f6-81ed-285d-b1e1-1492f8ead754/mzl.rhmornbv.png/53x53bb-85.png",
    "attributes" : {
      "height" : "53"
    }
  }, {
    "label" : "http://is5.mzstatic.com/image/thumb/Purple60/v4/f9/ca/a3/f9caa3f6-81ed-285d-b1e1-1492f8ead754/mzl.rhmornbv.png/75x75bb-85.png",
    "attributes" : {
      "height" : "75"
    }
  }, {
    "label" : "http://is2.mzstatic.com/image/thumb/Purple60/v4/f9/ca/a3/f9caa3f6-81ed-285d-b1e1-1492f8ead754/mzl.rhmornbv.png/100x100bb-85.png",
    "attributes" : {
      "height" : "100"
    }
  } ],
    ...

 */

public class Entry {

  
  private Category category;

  
  private Id id;

  
@com.google.gson.annotations.SerializedName("im:artist")
  private ImArtist imArtist;

  
@com.google.gson.annotations.SerializedName("im:contentType")
  private ImContentType imContentType;

  
@com.google.gson.annotations.SerializedName("im:image")
  private List<ImImage> imImage;

  
@com.google.gson.annotations.SerializedName("im:name")
  private ImName imName;

  
@com.google.gson.annotations.SerializedName("im:price")
  private ImPrice imPrice;

  
@com.google.gson.annotations.SerializedName("im:releaseDate")
  private ImReleaseDate imReleaseDate;

  
  private Link link;

  
  private Rights rights;

  
  private Summary summary;

  
  private Title title;

  public Category getCategory() {
    return category;
  }
  public Id getId() {
    return id;
  }
  public ImArtist getImArtist() {
    return imArtist;
  }
  public ImContentType getImContentType() {
    return imContentType;
  }
  public List<ImImage> getImImage() {
    return imImage;
  }
  public ImName getImName() {
    return imName;
  }
  public ImPrice getImPrice() {
    return imPrice;
  }
  public ImReleaseDate getImReleaseDate() {
    return imReleaseDate;
  }
  public Link getLink() {
    return link;
  }
  public Rights getRights() {
    return rights;
  }
  public Summary getSummary() {
    return summary;
  }
  public Title getTitle() {
    return title;
  }

  /**
  * Builder for Entry
  **/
  public static class EntryBuilder {
    private Entry toBuild = new Entry();

    public EntryBuilder() {
    }

    public Entry build() {
      return toBuild;
    }

    public EntryBuilder category(Category value) {
      toBuild.category = value;
      return this;
    }
    public EntryBuilder id(Id value) {
      toBuild.id = value;
      return this;
    }
    public EntryBuilder imArtist(ImArtist value) {
      toBuild.imArtist = value;
      return this;
    }
    public EntryBuilder imContentType(ImContentType value) {
      toBuild.imContentType = value;
      return this;
    }
    public EntryBuilder imImage(List<ImImage> value) {
      toBuild.imImage = value;
      return this;
    }
    public EntryBuilder imName(ImName value) {
      toBuild.imName = value;
      return this;
    }
    public EntryBuilder imPrice(ImPrice value) {
      toBuild.imPrice = value;
      return this;
    }
    public EntryBuilder imReleaseDate(ImReleaseDate value) {
      toBuild.imReleaseDate = value;
      return this;
    }
    public EntryBuilder link(Link value) {
      toBuild.link = value;
      return this;
    }
    public EntryBuilder rights(Rights value) {
      toBuild.rights = value;
      return this;
    }
    public EntryBuilder summary(Summary value) {
      toBuild.summary = value;
      return this;
    }
    public EntryBuilder title(Title value) {
      toBuild.title = value;
      return this;
    }
  }
}