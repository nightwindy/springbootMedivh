package com.windy.medivh.common.util;

import java.util.Calendar;

/**
 * Created by alex on 2016/11/8.
 */
public class SnowFlake {

    private static final Long workerIdBits = 10L;
    private static final Long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private static final Long sequenceBits = 12L;
    private static final Long maxSequence = -1L ^ (-1L << sequenceBits);

    private static final Long workerIdShift = sequenceBits;
    private static final Long timestampLeftShift = sequenceBits + workerIdBits;

    private final Long workerId;

    private Long sequence = 0L;
    private Long lastTimestamp = -1L;

    private Long since = 0l;

    public SnowFlake(final Long workerId) {
        super();

        if ((workerId > this.maxWorkerId) || (workerId < 0)) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    this.maxWorkerId));
        }

        this.workerId = workerId;

        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.NOVEMBER, 3, 0, 0, 0);

        this.since = calendar.getTimeInMillis();
    }

    public synchronized Long nextId() throws Exception {
        long timestamp = this.timeGen();

        if (this.lastTimestamp == timestamp) {
            this.sequence = (this.sequence + 1) & this.maxSequence;

            if (this.sequence == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0l;
        }

        if (timestamp < this.lastTimestamp) {
            throw new Exception(
                    String.format(
                            "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                            this.lastTimestamp - timestamp));
        }

        this.lastTimestamp = timestamp;

        return ((timestamp - since) << timestampLeftShift) | (this.workerId << this.workerIdShift) | (this.sequence);
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }

        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

}
