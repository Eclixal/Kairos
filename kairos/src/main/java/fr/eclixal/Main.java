package fr.eclixal;

import fr.eclixal.client.KairosClient;
import fr.eclixal.server.KairosServer;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/*
 * This file Main is part of a project Kairos.kairos.
 * It was created on 18/03/2021 20:54 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class Main {

    public static void main(String... args) {
        OptionParser optionParser = new OptionParser();
        optionParser.acceptsAll(Arrays.asList("?", "help"), "Show the help");
        optionParser.acceptsAll(Collections.singletonList("client"), "Be the client");
        optionParser.acceptsAll(Collections.singletonList("server"), "Be the server");
        optionParser.acceptsAll(Arrays.asList("c", "config"), "Configuration file").withRequiredArg().ofType(String.class);
        optionParser.acceptsAll(Arrays.asList("d", "default"), "Create a default configuration file");

        try {
            OptionSet optionSet = optionParser.parse(args);
            if (optionSet == null || !optionSet.hasOptions() || optionSet.has("?") || optionSet.has("help")) {
                try {
                    optionParser.printHelpOn(System.out);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }

            if (!optionSet.has("client") && !optionSet.has("server")) {
                System.err.println("You must start Kairos as a client or a server!");
                System.exit(-1);
            } else if (optionSet.has("client") && optionSet.has("server")) {
                System.err.println("Kairos can't be a server and a client :(");
                System.exit(-1);
            }

            Kairos kairos = null;

            if (optionSet.has("server"))
                kairos = new KairosServer(optionSet);
            else if (optionSet.has("client"))
                kairos = new KairosClient(optionSet);

            assert kairos != null;

            while (kairos.isRunning()) {
                String line;
                try {
                    line = kairos.getConsoleReader().readLine(">");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (OptionException | IOException e) {
            e.printStackTrace();
        }
    }

}