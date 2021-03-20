package fr.eclixal.common.logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.LogRecord;

/*
 * This file Log is part of a project Kairos.kairos.
 * It was created on 18/03/2021 21:16 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class Log extends Thread {

    private final KairosLog kairosLog;

    private final BlockingQueue<LogRecord> queue = new LinkedBlockingQueue<>();

    public Log(KairosLog kairosLog) {
        super("Kairos Logger Thread");
        this.kairosLog = kairosLog;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            LogRecord record;
            try {
                record = queue.take();
            } catch (InterruptedException ex) {
                continue;
            }

            kairosLog.doLog(record);
        }
        queue.forEach(kairosLog::doLog);
    }

    public void queue(LogRecord record) {
        if (!isInterrupted()) {
            queue.add(record);
        }
    }
}