// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018年3月25日, Lewis.Liu created
// ============================================================================
package com.em.service;

import com.em.entity.User;
import com.em.service.base.BaseService;

/**
 * @author Lewis.Liu
 *
 */
public interface UserService extends BaseService {

    User login(String loginId, String password);

    void logout(User user);
}
