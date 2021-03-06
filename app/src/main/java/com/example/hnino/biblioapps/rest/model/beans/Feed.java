/**
 * File generated by Magnet rest2mobile 1.1 - 21/08/2016 03:42:06 PM
 * @see {@link http://developer.magnet.com}
 */

package com.example.hnino.biblioapps.rest.model.beans;

import java.util.List;

/**
 * Generated from json example
{
  "author" : {
    "name" : {
      "label" : "iTunesStore"
    },
    "uri" : {
      "label" : "http://www.apple.com/itunes/"
    }
  },
  "entry" : [ {
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
        ...

 */

public class Feed {

  
  private Author author;

  
  private List<Entry> entry;

  
  private Icon icon;

  
  private Id id;

  
  private List<Link> link;

  
  private Rights rights;

  
  private Title title;

  
  private Updated updated;

  public Author getAuthor() {
    return author;
  }
  public List<Entry> getEntry() {
    return entry;
  }
  public Icon getIcon() {
    return icon;
  }
  public Id getId() {
    return id;
  }
  public List<Link> getLink() {
    return link;
  }
  public Rights getRights() {
    return rights;
  }
  public Title getTitle() {
    return title;
  }
  public Updated getUpdated() {
    return updated;
  }

  /**
  * Builder for Feed
  **/
  public static class FeedBuilder {
    private Feed toBuild = new Feed();

    public FeedBuilder() {
    }

    public Feed build() {
      return toBuild;
    }

    public FeedBuilder author(Author value) {
      toBuild.author = value;
      return this;
    }
    public FeedBuilder entry(List<Entry> value) {
      toBuild.entry = value;
      return this;
    }
    public FeedBuilder icon(Icon value) {
      toBuild.icon = value;
      return this;
    }
    public FeedBuilder id(Id value) {
      toBuild.id = value;
      return this;
    }
    public FeedBuilder link(List<Link> value) {
      toBuild.link = value;
      return this;
    }
    public FeedBuilder rights(Rights value) {
      toBuild.rights = value;
      return this;
    }
    public FeedBuilder title(Title value) {
      toBuild.title = value;
      return this;
    }
    public FeedBuilder updated(Updated value) {
      toBuild.updated = value;
      return this;
    }
  }
}
