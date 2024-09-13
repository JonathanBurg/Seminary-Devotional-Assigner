import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Print operations to use both {@link java.io.PrintStream} and {@link java.io.PrintWriter}
 *
 * @author Jonathan Burgener
 * @since Wednesday, September 11, 2024
 */
public class Write {
    java.io.File File;
    PrintWriter writeLog;
    
    Write(java.io.File file, String time) {
        try {
            if(!file.exists()) {
                if(file.createNewFile()) {
                    System.out.println(ANSI.YELLOW + "Logs/" + time + "_Log.txt was successfully created!" +
                            ANSI.RESET);
                } // end if(logFile.createNewFile())
                else {
                    throw new FileNotFoundException("File not created successfully");
                } // end else
            }     // end if(!file.exists())
        }         // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + e.getStackTrace()[0] + ANSI.RESET);
            System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + e.getStackTrace()[1] + ANSI.RESET);
        } // end catch(Exception e)
        
        if(file.exists()) {
            File = file;
        } // end if(file.exists())
        
        try {
            assert File != null;
            if(File.exists()) {
                writeLog = new PrintWriter(File);
                writeLog = new PrintWriter(new FileWriter(File, true));
            } // end if(File.exists())
        }     // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
        
        writeLog.println("Logs/" + time + "_Log.txt was successfully created!");
    }     // end Write(java.io.File)
    
    // Functions that don't terminate lines
    
    /**
     * Prints a boolean value.  The string produced by {@link
     * java.lang.String#valueOf(boolean)} is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * {@link java.io.PrintStream#write(int)} method.
     *
     * @param b The {@code boolean} to be printed
     */
    public void print(boolean b) {
        try {
            System.out.print(b);
            writeLog.print(b);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(boolean)
    
    /**
     * Prints a character.  The character is translated into one or more bytes
     * according to the character encoding given to the constructor, or the
     * platform's default character encoding if none specified. These bytes
     * are written in exactly the manner of the {@link java.io.PrintStream#write(int)}
     * method.
     *
     * @param c The {@code char} to be printed
     */
    public void print(char c) {
        try {
            System.out.print(c);
            writeLog.print(c);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(char)
    
    /**
     * Prints an integer.  The string produced by {@link
     * java.lang.String#valueOf(int)} is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * {@link java.io.PrintStream#write(int)} method.
     *
     * @param i The {@code int} to be printed
     * @see java.lang.Integer#toString(int)
     */
    public void print(int i) {
        try {
            System.out.print(i);
            writeLog.print(i);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(int)
    
    /**
     * Prints a long integer.  The string produced by {@link
     * java.lang.String#valueOf(long)} is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * {@link java.io.PrintStream#write(int)} method.
     *
     * @param l The {@code long} to be printed
     * @see java.lang.Long#toString(long)
     */
    public void print(long l) {
        try {
            System.out.print(l);
            writeLog.print(l);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(long)
    
    /**
     * Prints a floating-point number.  The string produced by {@link
     * java.lang.String#valueOf(float)} is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * {@link java.io.PrintStream#write(int)} method.
     *
     * @param f The {@code float} to be printed
     * @see java.lang.Float#toString(float)
     */
    public void print(float f) {
        try {
            System.out.print(f);
            writeLog.print(f);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(float)
    
    /**
     * Prints a double-precision floating-point number.  The string produced by
     * {@link java.lang.String#valueOf(double)} is translated into
     * bytes according to the platform's default character encoding, and these
     * bytes are written in exactly the manner of the {@link
     * java.io.PrintStream#write(int)} method.
     *
     * @param d The {@code double} to be printed
     * @see java.lang.Double#toString(double)
     */
    public void print(double d) {
        try {
            System.out.print(d);
            writeLog.print(d);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(double)
    
    /**
     * Prints an array of characters.  The characters are converted into bytes
     * according to the character encoding given to the constructor, or the
     * platform's default character encoding if none specified. These bytes
     * are written in exactly the manner of the {@link java.io.PrintStream#write(int)}
     * method.
     *
     * @param s The array of chars to be printed
     * @throws NullPointerException If {@code s} is {@code null}
     */
    public void print(char[] s) {
        try {
            System.out.print(s);
            writeLog.print(s);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(char[])
    
    /**
     * Prints a string.  If the argument is {@code null} then the string
     * {@code "null"} is printed.  Otherwise, the string's characters are
     * converted into bytes according to the character encoding given to the
     * constructor, or the platform's default character encoding if none
     * specified. These bytes are written in exactly the manner of the
     * {@link java.io.PrintStream#write(int)} method.
     *
     * @param s The {@code String} to be printed
     */
    public void print(String s) {
        try {
            System.out.print(s);
            writeLog.print(s.replaceAll("\u001B\\[[;\\d]*m", ""));
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print()
    
    /**
     * Prints a string to the console and the log.  If the argument is
     * {@code null} then the string {@code "null"} is printed.  Otherwise,
     * the string's characters are converted into bytes according to the
     * character encoding given to the constructor, or the platform's
     * default character encoding if none specified. These bytes are
     * written in exactly the manner of the
     * {@link PrintStream#write(int)} method.
     *
     * @param obj The {@code Object} to be printed
     */
    void print(Object obj) {
        try {
            System.out.print(obj);
            writeLog.print(obj);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end print(Object)
    
    
    // Functions that terminate lines
    
    /**
     * Prints a String and then terminate the line.  This method behaves as
     * though it invokes {@link java.io.PrintStream#print(String)} and then
     * {@link #println()}.
     *
     * @param s The {@code String} to be printed.
     */
    void println(String s) {
        try {
            System.out.println(s);
            writeLog.println(s.replaceAll("\u001B\\[[;\\d]*m", ""));
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(String)
    
    
    /**
     * Terminates the current line by writing the line separator string.  The
     * line separator string is defined by the system property
     * {@code line.separator}, and is not necessarily a single newline
     * character ({@code '\n'}).
     */
    void println() {
        try {
            System.out.println();
            writeLog.println();
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println()
    
    /**
     * Prints a boolean value and then terminates the line.  This method behaves
     * as though it invokes {@link java.io.PrintStream#print(boolean)} and then
     * {@link #println()}.
     *
     * @param x the {@code boolean} value to be printed
     */
    public void println(boolean x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(boolean)
    
    /**
     * Prints a character and then terminates the line.  This method behaves as
     * though it invokes {@link java.io.PrintStream#print(char)} and then {@link
     * #println()}.
     *
     * @param x the {@code char} value to be printed
     */
    public void println(char x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(char)
    
    /**
     * Prints an integer and then terminates the line.  This method behaves as
     * though it invokes {@link java.io.PrintStream#print(int)} and then {@link
     * #println()}.
     *
     * @param x the {@code int} value to be printed
     */
    public void println(int x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(int)
    
    /**
     * Prints a long integer and then terminates the line.  This method behaves
     * as though it invokes {@link java.io.PrintStream#print(long)} and then
     * {@link #println()}.
     *
     * @param x the {@code long} value to be printed
     */
    public void println(long x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(long)
    
    /**
     * Prints a floating-point number and then terminates the line.  This method
     * behaves as though it invokes {@link java.io.PrintStream#print(float)} and then
     * {@link #println()}.
     *
     * @param x the {@code float} value to be printed
     */
    public void println(float x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(float)
    
    /**
     * Prints a double-precision floating-point number and then terminates the
     * line.  This method behaves as though it invokes {@link
     * java.io.PrintStream#print(double)} and then {@link #println()}.
     *
     * @param x the {@code double} value to be printed
     */
    public void println(double x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(double)
    
    /**
     * Prints an array of characters and then terminates the line.  This method
     * behaves as though it invokes {@link java.io.PrintStream#print(char[])} and then
     * {@link #println()}.
     *
     * @param x the array of {@code char} values to be printed
     */
    public void println(char[] x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println(char[])
    
    /**
     * Prints an Object and then terminates the line.  This method calls
     * at first String.valueOf(x) to get the printed object's string value,
     * then behaves as
     * though it invokes {@link java.io.PrintStream#print(String)} and then
     * {@link #println()}.
     *
     * @param x The {@code Object} to be printed.
     */
    public void println(Object x) {
        try {
            System.out.println(x);
            writeLog.println(x);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED + e + ANSI.RESET);
            for(StackTraceElement st : e.getStackTrace()) {
                System.out.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + st + ANSI.RESET);
            } // end for(StackTraceElement st:e.getStackTrace())
        }     // end catch(Exception e)
    }         // end println()
}             // end Write
