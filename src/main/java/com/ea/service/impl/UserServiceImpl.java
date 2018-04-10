// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月25日, Lewis.Liu created
// ============================================================================
package com.ea.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ea.entity.User;
import com.ea.service.UserService;

/**
 * @author Lewis.Liu
 *
 */
public class UserServiceImpl implements UserService {

    /* (non-Javadoc)
     * @see com.ea.service.UserService#login(java.lang.String, java.lang.String)
     */
    @Override
    public User login(final String loginId, final String password) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.ea.service.UserService#logout(com.ea.entity.User)
     */
    @Override
    public void logout(final User user) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ea.service.base.BaseService#queryById(java.lang.String, java.lang.Class, java.io.Serializable)
     */
    @Override
    public <T> Object queryById(final String sql, final Class<T> clazz, final Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.ea.service.base.BaseService#insert(java.lang.String, java.lang.Object)
     */
    @Override
    public void insert(final String sql, final Object obj) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ea.service.base.BaseService#delete(java.lang.String, java.lang.Object)
     */
    @Override
    public void delete(final String sql, final Object obj) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ea.service.base.BaseService#update(java.lang.String, java.lang.Object)
     */
    @Override
    public void update(final String sql, final Object obj) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ea.service.base.BaseService#getResult(java.lang.String, java.lang.Object[])
     */
    @Override
    public <T> List<T> getResult(final String sql, final Object... params) {
        // TODO Auto-generated method stub
        return null;
    }

}
