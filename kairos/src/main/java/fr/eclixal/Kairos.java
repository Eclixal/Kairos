package fr.eclixal;

import jline.console.ConsoleReader;
import joptsimple.OptionSet;

import java.io.IOException;
import java.util.UUID;

/*
 * This file KairosClient is part of a project Kairos.kairos.
 * It was created on 18/03/2021 21:08 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public abstract class Kairos {

    public static Kairos KAIROS;
    private UUID uuid;
    private boolean running;
    private ConsoleReader consoleReader;

    /**
     * To make a new instance of Kairos (server/client)
     *
     * @param options all options for use Kairos
     * @throws IOException to prevent errors
     */
    public Kairos(OptionSet options) throws IOException {
       KAIROS = this;
       this.uuid = UUID.randomUUID();

       this.consoleReader = new ConsoleReader();
       this.consoleReader.setExpandEvents(false);

       this.running = true;
    }

    public static Kairos getInstance() {
        return KAIROS;
    }

    public boolean isRunning() {
        return running;
    }

    public ConsoleReader getConsoleReader() {
        return consoleReader;
    }

    public abstract void load();
    public abstract void unload();
}