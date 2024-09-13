/**
 * <p>ANSI colors to use in other modules/classes
 * </p><p>Wayne Cook
 * </p><p>Created: 3 April 2021: Basic colors.
 * </p><p>Modified: 12 September 2024 by Jonathan Burgener:
 * </p><ul>
 * <li>Added Italics, text styles, oranges, and grayscale colors.</li>
 * <li><a href="https://i.sstatic.net/KTSQa.png">Color Code Source</a></li>
 * </ur>
 */
public class ANSI {
    // Regular Colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String REDORANGE = "\u001b[38;5;202m";
    public static final String ORANGE = "\u001b[38;5;214m";
    public static final String WHITE = "\u001B[37m";
    
    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";      // BLACK
    public static final String RED_BOLD = "\033[1;31m";        // RED
    public static final String GREEN_BOLD = "\033[1;32m";      // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m";     // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";       // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m";     // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";       // CYAN
    public static final String REDORANGE_BOLD = "\033[1;202m"; // RED-ORANGE
    public static final String ORANGE_BOLD = "\033[1;214m";    // ORANGE
    public static final String WHITE_BOLD = "\033[1;37m";      // WHITE
    
    // Bold Italics
    public static final String BLACK_BOLD_ITALICS = "\033[1;3;30m";      // BLACK
    public static final String RED_BOLD_ITALICS = "\033[1;3;31m";        // RED
    public static final String GREEN_BOLD_ITALICS = "\033[1;3;32m";      // GREEN
    public static final String YELLOW_BOLD_ITALICS = "\033[1;3;33m";     // YELLOW
    public static final String BLUE_BOLD_ITALICS = "\033[1;3;34m";       // BLUE
    public static final String PURPLE_BOLD_ITALICS = "\033[1;3;35m";     // PURPLE
    public static final String CYAN_BOLD_ITALICS = "\033[1;3;36m";       // CYAN
    public static final String REDORANGE_BOLD_ITALICS = "\033[1;3;202m"; // RED-ORANGE
    public static final String ORANGE_BOLD_ITALICS = "\033[1;3;214m";    // ORANGE
    public static final String WHITE_BOLD_ITALICS = "\033[1;3;37m";      // WHITE
    
    // Italicised
    public static final String BLACK_ITALICS = "\033[3;30m";      // BLACK
    public static final String RED_ITALICS = "\033[3;31m";        // RED
    public static final String GREEN_ITALICS = "\033[3;32m";      // GREEN
    public static final String YELLOW_ITALICS = "\033[3;33m";     // YELLOW
    public static final String BLUE_ITALICS = "\033[3;34m";       // BLUE
    public static final String PURPLE_ITALICS = "\033[3;35m";     // PURPLE
    public static final String CYAN_ITALICS = "\033[3;36m";       // CYAN
    public static final String REDORANGE_ITALICS = "\033[3;202m"; // RED-ORANGE
    public static final String ORANGE_ITALICS = "\033[3;214m";    // ORANGE
    public static final String WHITE_ITALICS = "\033[3;37m";      // WHITE
    
    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";      // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";        // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";      // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m";     // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";       // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m";     // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";       // CYAN
    public static final String REDORANGE_UNDERLINED = "\033[4;202m"; // RED-ORANGE
    public static final String ORANGE_UNDERLINED = "\033[4;214m";    // ORANGE
    public static final String WHITE_UNDERLINED = "\033[4;37m";      // WHITE
    
    // Background Colors
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_REDORANGE_BACKGROUND = "\033[48;5;202m";
    public static final String ANSI_ORANGE_BACKGROUND = "\033[48;5;214m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    // Text Styles
    public static final String BOLD = "\u001b[1m";
    public static final String NO_STYLE = "\u001b[2m";
    public static final String ITALICS = "\u001b[3m";
    public static final String UNDERLINE = "\u001b[4m";
    public static final String BOLD_ITALICS = "\u001b[1;3m";
    public static final String BOLD_UNDERLINE = "\u001b[1;4m";
    public static final String ITALICS_UNDERLINE = "\u001b[3;4m";
    public static final String ALL_STYLES = "\u001b[1;3;4m";
    
    // Grayscale Colors
    /**
     * Cod Gray
     * <ul>
     *     <li>RGB: <code>(7, 7, 7)</code></li>
     *     <li>HEX: <code>#070707</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_0 = "\u001b[38;5;232m";
    /**
     * Cod Gray
     * <ul>
     *     <li>RGB: <code>(17, 17, 17)</code></li>
     *     <li>HEX: <code>#111111</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_1 = "\u001b[38;5;233m";
    /**
     * Cod Gray
     * <ul>
     *     <li>RGB: <code>(27, 27, 27)</code></li>
     *     <li>HEX: <code>#1b1b1b</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_2 = "\u001b[38;5;234m";
    /**
     * Mine Shaft
     * <ul>
     *     <li>RGB: <code>(37, 37, 37)</code></li>
     *     <li>HEX: <code>#252525</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_3 = "\u001b[38;5;235m";
    /**
     * Mine Shaft
     * <ul>
     *     <li>RGB: <code>(47, 47, 47)</code></li>
     *     <li>HEX: <code>#2f2f2f</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_4 = "\u001b[38;5;236m";
    /**
     * Mine Shaft
     * <ul>
     *     <li>RGB: <code>(57, 57, 57)</code></li>
     *     <li>HEX: <code>#393939</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_5 = "\u001b[38;5;237m";
    /**
     * Tundora
     * <ul>
     *     <li>RGB: <code>(67, 67, 67)</code></li>
     *     <li>HEX: <code>#434343</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_6 = "\u001b[38;5;238m";
    /**
     * Tundora
     * <ul>
     *     <li>RGB: <code>(77, 77, 77)</code></li>
     *     <li>HEX: <code>#4d4d4d</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_7 = "\u001b[38;5;239m";
    /**
     * Scorpion
     * <ul>
     *     <li>RGB: <code>(87, 87, 87)</code></li>
     *     <li>HEX: <code>#575757</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_8 = "\u001b[38;5;240m";
    /**
     * Dove Gray
     * <ul>
     *     <li>RGB: <code>(97, 97, 97)</code></li>
     *     <li>HEX: <code>#616161</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_9 = "\u001b[38;5;241m";
    /**
     * Storm Dust
     * <ul>
     *     <li>RGB: <code>(107, 107, 107)</code></li>
     *     <li>HEX: <code>#6b6b6b</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_10 = "\u001b[38;5;242m";
    /**
     * Boulder
     * <ul>
     *     <li>RGB: <code>(117, 117, 117)</code></li>
     *     <li>HEX: <code>#757575</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_11 = "\u001b[38;5;243m";
    /**
     * Gray
     * <ul>
     *     <li>RGB: <code>(127, 127, 127)</code></li>
     *     <li>HEX: <code>#7f7f7f</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_12 = "\u001b[38;5;244m";
    /**
     * Gray
     * <ul>
     *     <li>RGB: <code>(137, 137, 137)</code></li>
     *     <li>HEX: <code>#898989</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_13 = "\u001b[38;5;245m";
    /**
     * Gray
     * <ul>
     *     <li>RGB: <code>(147, 147, 147)</code></li>
     *     <li>HEX: <code>#939393</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_14 = "\u001b[38;5;246m";
    /**
     * Silver Chalice
     * <ul>
     *     <li>RGB: <code>(157, 157, 157)</code></li>
     *     <li>HEX: <code>#9d9d9d</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_15 = "\u001b[38;5;247m";
    /**
     * Silver Chalice
     * <ul>
     *     <li>RGB: <code>(167, 167, 167)</code></li>
     *     <li>HEX: <code>#a7a7a7</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_16 = "\u001b[38;5;248m";
    /**
     * Silver Chalice
     * <ul>
     *     <li>RGB: <code>(177, 177, 177)</code></li>
     *     <li>HEX: <code>#b1b1b1</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_17 = "\u001b[38;5;249m";
    /**
     * Silver
     * <ul>
     *     <li>RGB: <code>(187, 187, 187)</code></li>
     *     <li>HEX: <code>#bbbbbb</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_18 = "\u001b[38;5;250m";
    /**
     * Silver
     * <ul>
     *     <li>RGB: <code>(197, 197, 197)</code></li>
     *     <li>HEX: <code>#c5c5c5</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_19 = "\u001b[38;5;251m";
    /**
     * Alto
     * <ul>
     *     <li>RGB: <code>(207, 207, 207)</code></li>
     *     <li>HEX: <code>#cfcfcf</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_20 = "\u001b[38;5;252m";
    /**
     * Alto
     * <ul>
     *     <li>RGB: <code>(217, 217, 217)</code></li>
     *     <li>HEX: <code>#d9d9d9</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_21 = "\u001b[38;5;253m";
    /**
     * Mercury
     * <ul>
     *     <li>RGB: <code>(227, 227, 227)</code></li>
     *     <li>HEX: <code>#e3e3e3</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_22 = "\u001b[38;5;254m";
    /**
     * Gallery
     * <ul>
     *     <li>RGB: <code>(237, 237, 237)</code></li>
     *     <li>HEX: <code>#ededed</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_23 = "\u001b[38;5;255m";
    
    
    // Grayscale Background
    /**
     * Cod Gray
     * <ul>
     *     <li>RGB: <code>(7, 7, 7)</code></li>
     *     <li>HEX: <code>#070707</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_0_BACKGROUND = "\u001b[48;5;232m";
    /**
     * Cod Gray
     * <ul>
     *     <li>RGB: <code>(17, 17, 17)</code></li>
     *     <li>HEX: <code>#111111</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_1_BACKGROUND = "\u001b[48;5;233m";
    /**
     * Cod Gray
     * <ul>
     *     <li>RGB: <code>(27, 27, 27)</code></li>
     *     <li>HEX: <code>#1b1b1b</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_2_BACKGROUND = "\u001b[48;5;234m";
    /**
     * Mine Shaft
     * <ul>
     *     <li>RGB: <code>(37, 37, 37)</code></li>
     *     <li>HEX: <code>#252525</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_3_BACKGROUND = "\u001b[48;5;235m";
    /**
     * Mine Shaft
     * <ul>
     *     <li>RGB: <code>(47, 47, 47)</code></li>
     *     <li>HEX: <code>#2f2f2f</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_4_BACKGROUND = "\u001b[48;5;236m";
    /**
     * Mine Shaft
     * <ul>
     *     <li>RGB: <code>(57, 57, 57)</code></li>
     *     <li>HEX: <code>#393939</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_5_BACKGROUND = "\u001b[48;5;237m";
    /**
     * Tundora
     * <ul>
     *     <li>RGB: <code>(67, 67, 67)</code></li>
     *     <li>HEX: <code>#434343</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_6_BACKGROUND = "\u001b[48;5;238m";
    /**
     * Tundora
     * <ul>
     *     <li>RGB: <code>(77, 77, 77)</code></li>
     *     <li>HEX: <code>#4d4d4d</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_7_BACKGROUND = "\u001b[48;5;239m";
    /**
     * Scorpion
     * <ul>
     *     <li>RGB: <code>(87, 87, 87)</code></li>
     *     <li>HEX: <code>#575757</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_8_BACKGROUND = "\u001b[48;5;240m";
    /**
     * Dove Gray
     * <ul>
     *     <li>RGB: <code>(97, 97, 97)</code></li>
     *     <li>HEX: <code>#616161</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_9_BACKGROUND = "\u001b[48;5;241m";
    /**
     * Storm Dust
     * <ul>
     *     <li>RGB: <code>(107, 107, 107)</code></li>
     *     <li>HEX: <code>#6b6b6b</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_10_BACKGROUND = "\u001b[48;5;242m";
    /**
     * Boulder
     * <ul>
     *     <li>RGB: <code>(117, 117, 117)</code></li>
     *     <li>HEX: <code>#757575</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_11_BACKGROUND = "\u001b[48;5;243m";
    /**
     * Gray
     * <ul>
     *     <li>RGB: <code>(127, 127, 127)</code></li>
     *     <li>HEX: <code>#7f7f7f</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_12_BACKGROUND = "\u001b[48;5;244m";
    /**
     * Gray
     * <ul>
     *     <li>RGB: <code>(137, 137, 137)</code></li>
     *     <li>HEX: <code>#898989</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_13_BACKGROUND = "\u001b[48;5;245m";
    /**
     * Gray
     * <ul>
     *     <li>RGB: <code>(147, 147, 147)</code></li>
     *     <li>HEX: <code>#939393</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_14_BACKGROUND = "\u001b[48;5;246m";
    /**
     * Silver Chalice
     * <ul>
     *     <li>RGB: <code>(157, 157, 157)</code></li>
     *     <li>HEX: <code>#9d9d9d</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_15_BACKGROUND = "\u001b[48;5;247m";
    /**
     * Silver Chalice
     * <ul>
     *     <li>RGB: <code>(167, 167, 167)</code></li>
     *     <li>HEX: <code>#a7a7a7</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_16_BACKGROUND = "\u001b[48;5;248m";
    /**
     * Silver Chalice
     * <ul>
     *     <li>RGB: <code>(177, 177, 177)</code></li>
     *     <li>HEX: <code>#b1b1b1</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_17_BACKGROUND = "\u001b[48;5;249m";
    /**
     * Silver
     * <ul>
     *     <li>RGB: <code>(187, 187, 187)</code></li>
     *     <li>HEX: <code>#bbbbbb</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_18_BACKGROUND = "\u001b[48;5;250m";
    /**
     * Silver
     * <ul>
     *     <li>RGB: <code>(197, 197, 197)</code></li>
     *     <li>HEX: <code>#c5c5c5</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_19_BACKGROUND = "\u001b[48;5;251m";
    /**
     * Alto
     * <ul>
     *     <li>RGB: <code>(207, 207, 207)</code></li>
     *     <li>HEX: <code>#cfcfcf</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_20_BACKGROUND = "\u001b[48;5;252m";
    /**
     * Alto
     * <ul>
     *     <li>RGB: <code>(217, 217, 217)</code></li>
     *     <li>HEX: <code>#d9d9d9</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_21_BACKGROUND = "\u001b[48;5;253m";
    /**
     * Mercury
     * <ul>
     *     <li>RGB: <code>(227, 227, 227)</code></li>
     *     <li>HEX: <code>#e3e3e3</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_22_BACKGROUND = "\u001b[48;5;254m";
    /**
     * Gallery
     * <ul>
     *     <li>RGB: <code>(237, 237, 237)</code></li>
     *     <li>HEX: <code>#ededed</code></li>
     * </ul>
     */
    public static final String GRAYSCALE_23_BACKGROUND = "\u001b[48;5;255m";
    
}