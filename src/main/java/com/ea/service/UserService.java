// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月25日, Lewis.Liu created
// ============================================================================
package com.ea.service;

import com.ea.entity.User;

/**
 * @author Lewis.Liu
 *
 */
public interface UserService {

    User login(String loginId, String password);

    void logout(User user);
}
