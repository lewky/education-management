// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-14, Lewis.Liu created
// ============================================================================
package com.ea.entity;

/**
 * @author Lewis.Liu
 */
public class Score extends BaseEntity {

    private static final long serialVersionUID = 4473818443035549413L;

    private Long parentId;
    private Float regularScore;
    private Float midtermScore;
    private Float terminalScore;
    private Float score;

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(final Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the regularScore
     */
    public Float getRegularScore() {
        return regularScore;
    }

    /**
     * @param regularScore
     *            the regularScore to set
     */
    public void setRegularScore(final Float regularScore) {
        this.regularScore = regularScore;
    }

    /**
     * @return the midtermScore
     */
    public Float getMidtermScore() {
        return midtermScore;
    }

    /**
     * @param midtermScore
     *            the midtermScore to set
     */
    public void setMidtermScore(final Float midtermScore) {
        this.midtermScore = midtermScore;
    }

    /**
     * @return the terminalScore
     */
    public Float getTerminalScore() {
        return terminalScore;
    }

    /**
     * @param terminalScore
     *            the terminalScore to set
     */
    public void setTerminalScore(final Float terminalScore) {
        this.terminalScore = terminalScore;
    }

    /**
     * @return the score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     *            the score to set
     */
    public void setScore(final Float score) {
        this.score = score;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String baseEntityStr = super.toString();
        return "Score [parentId=" + parentId + ", regularScore=" + regularScore + ", midtermScore=" + midtermScore
                + ", terminalScore=" + terminalScore + ", score=" + score + ", " + baseEntityStr + "]";
    }

}
