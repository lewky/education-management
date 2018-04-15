// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION ea.1.0.0
// ============================================================================
// CHANGE LOG
// ea.1.0.0 : 2018-04-12, Lewis.Liu created
// ============================================================================
package com.em.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lewis.Liu
 *
 */
public abstract class AbstractBaseService implements BaseService {

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
