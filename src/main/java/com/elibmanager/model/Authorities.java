package com.elibmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wcc on 2016/8/8.
 */

@Entity
public class Authorities {

    @Id
    @GeneratedValue
    private int anthoritiesId;
    private String username;
    private String authority;

    public int getAnthoritiesId() {
        return anthoritiesId;
    }

    public void setAnthoritiesId(int anthoritiesId) {
        this.anthoritiesId = anthoritiesId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
