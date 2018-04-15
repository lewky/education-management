// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018-3-15, Lewis.Liu created
// ============================================================================
package com.em.dao;

import java.util.List;

import com.em.entity.Score;

/**
 * @author Lewis.Liu
 */
public interface ScoreDao {

    List<Score> listAllScores();
}
