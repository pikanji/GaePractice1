package net.pikanji.gae.practice1;

import com.google.appengine.api.datastore.Key;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Bookmark {
    public enum Type {
        FOLDER,
        BOOKMARK
    }
    
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key mKey;
    
    @Persistent
    private Type mType;

    @Persistent
    private List<Bookmark> mChildren;
    
    @Persistent
    private String mData; // URL or Folder name

    public Bookmark(String data, Type type) {
        this.mData = data;
        this.mType = type;
        if (Type.FOLDER == type) {
        	mChildren = new ArrayList<Bookmark>();
        } else {
        	mChildren = null;
        }
    }

    public Key getKey() {
        return mKey;
    }

    public Type getType() {
        return mType;
    }
    
    public String getData() {
    	return mData;
    }

    public void setData(String data) {
        this.mData = data;
    }

}