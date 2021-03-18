package fr.eclixal.common.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/*
 * This file ConciseFormatter is part of a project Kairos.kairos.
 * It was created on 18/03/2021 21:17 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class ConciseFormatter extends Formatter {

    private final DateFormat date = new SimpleDateFormat("HH:mm:ss");

    @Override
    @SuppressWarnings("ThrowableResultIgnored")
    public String format(LogRecord record) {
        StringBuilder formatted = new StringBuilder();

        formatted.append(date.format(record.getMillis()));
        formatted.append(" [");
        formatted.append(record.getLevel().getLocalizedName());
        formatted.append("] ");
        formatted.append(formatMessage(record));
        formatted.append('\n');
        if (record.getThrown() != null) {
            StringWriter writer = new StringWriter();
            record.getThrown().printStackTrace(new PrintWriter(writer));
            formatted.append(writer);
        }
        return formatted.toString();
    }

}
