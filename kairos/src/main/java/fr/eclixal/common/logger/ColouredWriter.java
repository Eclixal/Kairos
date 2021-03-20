package fr.eclixal.common.logger;

import fr.eclixal.util.TextColor;
import jline.console.ConsoleReader;
import org.fusesource.jansi.Ansi;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/*
 * This file ColouredWriter is part of a project Kairos.kairos.
 * It was created on 18/03/2021 21:20 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class ColouredWriter extends Handler {

    private final Map<TextColor, String> replacements = new EnumMap<>(TextColor.class);
    private final TextColor[] colors = TextColor.values();
    private final ConsoleReader console;

    public ColouredWriter(ConsoleReader console) {
        this.console = console;

        replacements.put(TextColor.BLACK, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).boldOff().toString());
        replacements.put(TextColor.DARK_BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).boldOff().toString());
        replacements.put(TextColor.DARK_GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).boldOff().toString());
        replacements.put(TextColor.DARK_AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).boldOff().toString());
        replacements.put(TextColor.DARK_RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).boldOff().toString());
        replacements.put(TextColor.DARK_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).boldOff().toString());
        replacements.put(TextColor.GOLD, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).boldOff().toString());
        replacements.put(TextColor.GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).boldOff().toString());
        replacements.put(TextColor.DARK_GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).bold().toString());
        replacements.put(TextColor.BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).bold().toString());
        replacements.put(TextColor.GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).bold().toString());
        replacements.put(TextColor.AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).bold().toString());
        replacements.put(TextColor.RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).bold().toString());
        replacements.put(TextColor.LIGHT_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).bold().toString());
        replacements.put(TextColor.YELLOW, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).bold().toString());
        replacements.put(TextColor.WHITE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).bold().toString());
        replacements.put(TextColor.MAGIC, Ansi.ansi().a(Ansi.Attribute.BLINK_SLOW).toString());
        replacements.put(TextColor.BOLD, Ansi.ansi().a(Ansi.Attribute.UNDERLINE_DOUBLE).toString());
        replacements.put(TextColor.STRIKETHROUGH, Ansi.ansi().a(Ansi.Attribute.STRIKETHROUGH_ON).toString());
        replacements.put(TextColor.UNDERLINE, Ansi.ansi().a(Ansi.Attribute.UNDERLINE).toString());
        replacements.put(TextColor.ITALIC, Ansi.ansi().a(Ansi.Attribute.ITALIC).toString());
        replacements.put(TextColor.RESET, Ansi.ansi().a(Ansi.Attribute.RESET).toString());
    }

    public void print(String s) {
        for (TextColor color : colors) {
            s = s.replaceAll("(?i)" + color, replacements.get(color));
        }
        try {
            console.print(ConsoleReader.RESET_LINE + s + Ansi.ansi().reset());
            console.drawLine();
            console.flush();
        } catch (IOException ignored) { }
    }

    @Override
    public void publish(LogRecord record) {
        if (isLoggable(record)) {
            print(getFormatter().format(record));
        }
    }

    @Override
    public void flush() { }

    @Override
    public void close() throws SecurityException {}
}