// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-30, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple stop watch, allowing for timing of a number of tasks,
 * exposing total running time and running time for each named task.
 * @author Lewis.Liu
 *
 */
public class StopWatch {

    /** Identifier of this stop watch */
    private final String id;

    private final List<Task> tasks = new ArrayList<Task>();

    /** Name of the current task */
    private String currentTaskName;

    /** Start time(millisecond) of the current task */
    private long startTimeMillis;

    /** Total running time(millisecond) of the stop watch. */
    private long totalTimeMillis;

    /** Is the stop watch running? */
    private boolean running = false;

    private Task lastTask;

    /**
     * Construct a new stop watch, the default id is "".
     */
    public StopWatch() {
        this.id = "";
    }

    /**
     * Construct a new stop watch with the given id.
     * @param id
     */
    public StopWatch(final String id) {
        this.id = id;
    }

    /**
     * Return the id of the stop watch.
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     * Start a new unnamed task within the stop watch, the default taskName is "".
     */
    public void start() throws IllegalStateException {
        start("");
    }

    /**
     * Start a new task within the stop watch.
     * @param taskName
     * @throws IllegalStateException
     */
    public void start(final String taskName) throws IllegalStateException {
        if (running) {
            throw new IllegalStateException("Cannot start the stop watch: it is already running!");
        }
        this.running = true;
        this.currentTaskName = taskName;
        this.startTimeMillis = System.currentTimeMillis();
    }

    /**
     * Stop the current task within the stop watch.
     * @throws IllegalStateException
     */
    public void stop() throws IllegalStateException {
        if (!running) {
            throw new IllegalStateException("Cannot stop the stop watch: it is not running!");
        }
        final long lastTime = System.currentTimeMillis() - this.startTimeMillis;
        this.totalTimeMillis = lastTime;
        this.lastTask = new Task(currentTaskName, lastTime);
        this.tasks.add(lastTask);
        this.currentTaskName = null;
        this.running = false;
    }

    /**
     * Return the total running time(millisecond) of the stop watch.
     * @return
     */
    public long totalTimeMillisElapsed() {
        return this.totalTimeMillis;
    }

    /**
     * Return whether the stop watch is running.
     * @return
     */
    public boolean isRunning() {
        return this.running;
    }

    /**
     * Return last task time(millisecond) elapsed.
     * @return
     * @throws IllegalStateException
     */
    public long lastTaskTimeMillisElapsed() throws IllegalStateException {
        if (lastTask == null) {
            throw new IllegalStateException("No tasks run: can't get last task interval");
        }
        return this.lastTask.timeMillisElapsed();
    }

    /**
     * Inner class to hold data about one task executed within the stop watch.
     * @author Lewis.Liu
     *
     */
    public static final class Task {

        private final String taskName;

        private final long timeMillis;

        /**
         * Construct a new task with the given taskName and timeMillis.
         * @param taskName
         * @param timeMillis
         */
        Task(final String taskName, final long timeMillis) {
            this.taskName = taskName;
            this.timeMillis = timeMillis;
        }

        public String getTaskName() {
            return taskName;
        }

        public long timeMillisElapsed() {
            return timeMillis;
        }

        public double timeSecondsElapsed() {
            return timeMillis / 1000.0;
        }
    }
}
