package net.pikanji.gae.practice1;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class TkgBmUser {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    // Can be used as key?
    @Persistent
    private User mUser;
    
    @Persistent
    private List<Bookmark> mChildren;

    public TkgBmUser(User user) {
    	mUser = user;
    	mChildren = new ArrayList<Bookmark>();
    }
}