package com.elibmanager.dao;

import com.elibmanager.model.Authorities;

/**
 * Created by wcc on 2016/8/11.
 */
public interface AuthoritiesDao {

    void addAuthorities(Authorities authorities);

    void editAuthorities(Authorities authorities);

    void deleteAuthorities(Authorities authorities);

    Authorities getAuthoritiesByUsername(String username);

    void deleteAuthoritiesByUsername(String username);
}
