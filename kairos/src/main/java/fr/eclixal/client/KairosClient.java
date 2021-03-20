package fr.eclixal.client;

import fr.eclixal.Kairos;
import joptsimple.OptionSet;

import java.io.IOException;

/*
 * This file KairosClient is part of a project Kairos.kairos.
 * It was created on 18/03/2021 21:08 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class KairosClient extends Kairos {

    /**
     * To make a new instance of Kairos (server/client)
     *
     * @param options all options for use Kairos
     * @throws IOException to prevent errors
     */
    public KairosClient(OptionSet options) throws IOException {
        super(options);
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }
}
