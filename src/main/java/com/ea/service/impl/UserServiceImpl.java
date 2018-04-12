// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月25日, Lewis.Liu created
// ============================================================================
package com.ea.service.impl;

import com.ea.entity.User;
import com.ea.service.UserService;
import com.ea.service.base.AbstractBaseService;

/**
 * @author Lewis.Liu
 *
 */
public class UserServiceImpl extends AbstractBaseService implements UserService {

    private UserServiceImpl() {}

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

    /**
     * Inner class to hold singleton instance of outer class.
     * @author Lewis.Liu
     *
     */
    private static class SingletonHolder {
        private static UserService instance = new UserServiceImpl();
    }

    /**
     * Return singleton instance.
     * @return
     */
    public static UserService getInstance() {
        return SingletonHolder.instance;
    }
}
