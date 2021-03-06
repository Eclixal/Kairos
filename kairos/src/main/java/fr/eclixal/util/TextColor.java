package fr.eclixal.util;

/*
 * This file TextColor is part of a project Kairos.kairos.
 * It was created on 18/03/2021 21:21 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from Kairos author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public enum TextColor {

        BLACK('0', 0x00),
        DARK_BLUE('1', 0x1),
        DARK_GREEN('2', 0x2),
        DARK_AQUA('3', 0x3),
        DARK_RED('4', 0x4),
        DARK_PURPLE('5', 0x5),
        GOLD('6', 0x6),
        GRAY('7', 0x7),
        DARK_GRAY('8', 0x8),
        BLUE('9', 0x9),
        GREEN('a', 0xA),
        AQUA('b', 0xB),
        RED('c', 0xC),
        LIGHT_PURPLE('d', 0xD),
        YELLOW('e', 0xE),
        WHITE('f', 0xF),
        MAGIC('k', 0x10, true),
        BOLD('l', 0x11, true),
        STRIKETHROUGH('m', 0x12, true),
        UNDERLINE('n', 0x13, true),
        ITALIC('o', 0x14, true),
        RESET('r', 0x15);

        public static final char COLOR_CHAR = '\u00A7';
        private final String toString;

        TextColor(char code, int intCode) {
            this(code, intCode, false);
        }

        TextColor(char code, int intCode, boolean isFormat) {
            this.toString = new String(new char[]{COLOR_CHAR, code});
        }

        @Override
        public String toString() {
            return toString;
        }
}