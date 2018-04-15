// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018-3-25, Lewis.Liu created
// ============================================================================
package com.em.entity.form;

import java.io.Serializable;

public class ScoreForm implements Serializable {

    private static final long serialVersionUID = 155725201267934733L;

    private String parentId;
    private String regularScore;
    private String midtermScore;
    private String terminalScore;
    private String score;

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setRegularScore(final String regularScore) {
        this.regularScore = regularScore;
    }

    public String getRegularScore() {
        return regularScore;
    }

    public void setMidtermScore(final String midtermScore) {
        this.midtermScore = midtermScore;
    }

    public String getMidtermScore() {
        return midtermScore;
    }

    public void setTerminalScore(final String terminalScore) {
        this.terminalScore = terminalScore;
    }

    public String getTerminalScore() {
        return terminalScore;
    }

    public void setScore(final String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }
}