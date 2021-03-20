package fr.eclixal.common.logger;

import fr.eclixal.Kairos;

import java.io.IOException;
import java.util.logging.*;

/*
 * This file KairosLog is part of a project Kairos.kairos.
 * It was created on 18/03/2021 21:14 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class KairosLog extends Logger {

    private final Log dispatcher = new Log(this);

    public KairosLog() {
        super("Kairos", null);
        this.setLevel(Level.ALL);

        try {
            FileHandler fileHandler = new FileHandler("Kairos.log", 1 << 24, 8, true);
            Formatter formatter = new ConciseFormatter();
            fileHandler.setFormatter(formatter);
            addHandler(fileHandler);

            ColouredWriter consoleHandler = new ColouredWriter(Kairos.getInstance().getConsoleReader());
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(formatter);
            addHandler(consoleHandler);
        } catch (IOException ex) {
            System.err.println("Could not register logger!");
            ex.printStackTrace();
        }
        dispatcher.start();
    }

    @Override
    public void log(LogRecord record) {
        dispatcher.queue(record);
    }

    protected void doLog(LogRecord record) {
        super.log(record);
    }
}
