// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-15, Lewis.Liu created
// ============================================================================
package com.ea.dao;

import java.util.List;

import com.ea.entity.Role;

/**
 * @author Lewis.Liu
 */
public interface RoleDao {

    List<Role> listAllRoles();
}
