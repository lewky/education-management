// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018-3-30, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;

/**
 * Simple stop watch, allowing for timing of a number of tasks,
 * exposing total running time and running time for each named task.
 * @author Lewis.Liu
 *
 */
public class StopWatch {

    /** Short summary of the stop watch */
    private static final String STOP_WATCH_RESUME = "StopWatch '%1$s': running time (millis) = %2$d";

    private static final String NO_TASK_RUNS = "No task runs within the stop watch.";

    private static final String FORMAT_PRETTY_PRINT = "ms     %     Task name\n";

    private static final String SEPARATOR_NEW_LINE = "-----------------------------------------\n";

    private static final String SEPARATOR_NEXT_LINE = "\n";

    private static final String SEPARATOR_BLANK = "  ";

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
        this.totalTimeMillis += lastTime;
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
     * Return the total running time(second) of the stop watch.
     * @return
     */
    public double totalTimeSecondsElapsed() {
        return this.totalTimeMillis / 1000.0;
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
     * @throws IllegalStateException
     */
    public long lastTaskTimeMillisElapsed() throws IllegalStateException {
        if (lastTask == null) {
            throw new IllegalStateException("No tasks run: can't get last task interval!");
        }
        return this.lastTask.timeMillisElapsed();
    }

    /**
     * Return last task time(second) elapsed.
     * @throws IllegalStateException
     */
    public double lastTaskTimeSecondsElapsed() throws IllegalStateException {
        if (lastTask == null) {
            throw new IllegalStateException("No tasks run: can't get last task interval!");
        }
        return this.lastTask.timeSecondsElapsed();
    }

    /**
     * Return name of last task.
     * @throws IllegalStateException
     */
    public String getLastTaskName() throws IllegalStateException {
        if (lastTask == null) {
            throw new IllegalStateException("No tasks run: can't get last task name!");
        }
        return this.lastTask.getTaskName();
    }

    /**
     * Return the number of tasks timed.
     */
    public int getTaskCount() {
        return this.tasks.size();
    }

    public List<Task> geTasks() {
        return tasks;
    }

    /**
     * Return a short description of the total running time.
     * @return
     */
    public String resume() {
        return String.format(STOP_WATCH_RESUME, this.id, this.totalTimeMillis);
    }

    /**
     * Return a string with a table describing all tasks performed.
     * @return
     */
    public String prettyPrint() {
        if (CollectionUtils.isEmpty(tasks)) {
            return NO_TASK_RUNS;
        }
        final StringBuilder builder = new StringBuilder(resume());
        builder.append(SEPARATOR_NEXT_LINE);
        builder.append(SEPARATOR_NEW_LINE);
        builder.append(FORMAT_PRETTY_PRINT);
        builder.append(SEPARATOR_NEW_LINE);
        final NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumIntegerDigits(5);
        nf.setGroupingUsed(false);
        final NumberFormat pf = NumberFormat.getPercentInstance();
        pf.setMinimumIntegerDigits(3);
        pf.setGroupingUsed(false);
        for (final Task task : tasks) {
            builder.append(nf.format(task.timeMillisElapsed())).append(SEPARATOR_BLANK);
            builder.append(pf.format(task.timeSecondsElapsed() / totalTimeSecondsElapsed())).append(SEPARATOR_BLANK);
            builder.append(task.getTaskName()).append(SEPARATOR_NEXT_LINE);
        }

        return Objects.toString(builder);
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
