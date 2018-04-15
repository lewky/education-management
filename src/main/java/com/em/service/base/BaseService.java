// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION ea.1.0.0
// ============================================================================
// CHANGE LOG
// ea.1.0.0 : 2018-04-09, Lewis.Liu created
// ============================================================================
package com.em.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lewis.Liu
 *
 */
public interface BaseService {

    /** Query object from db by id. */
    <T> Object queryById(String sql, Class<T> clazz, Serializable id);

    /** Insert object into db. */
    void insert(String sql, Object obj);

    /** Delete object from db. */
    void delete(String sql, Object obj);

    /** Update object into db. */
    void update(String sql, Object obj);

    /** Query object from db by params. */
    <T> List<T> getResult(String sql, Object... params);
}
