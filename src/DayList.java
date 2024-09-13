import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Creates a linked list to keep track of student assignments
 *
 * @author Jonathan Burgener
 * @since Wednesday, September 4, 2024
 */
public class DayList {
    /**
     * Days of Class in Seminary
     */
    private final int ClassDays;
    /**
     * Date of Assignments
     */
    private GregorianCalendar Date;
    /**
     * Students Assigned
     */
    private final String OpeningPrayer, Devotional, ClosingPrayer;
    /**
     * Numbers associated with assigned students
     */
    private final int openingPrayer, devotional, closingPrayer;
    /**
     * Linked elements in the linked list
     */
    private DayList PreviousDay, NextDay;
    /**
     * Whether to save as a new assignment
     */
    boolean newAssignment;
    String name;
    /**
     * If devotional list was reset on this assignment
     */
    boolean reset;
    
    /**
     * Creates an element in a linked list
     *
     * @param DayOfSeminary  Days of class in seminary
     * @param Date           Day of the element
     * @param Assignments    Names of Assigned Students
     * @param AssignmentNums Index of assigned students in list of Names
     * @param newDay         Whether this is a new assignment or not
     */
    DayList(int DayOfSeminary, String Date, String[] Assignments, int[] AssignmentNums, boolean newDay) {
        newAssignment = newDay;
        ClassDays = DayOfSeminary;
        setDate(Date);
        this.OpeningPrayer = Assignments[0];
        this.Devotional = Assignments[1];
        this.ClosingPrayer = Assignments[2];
        this.openingPrayer = AssignmentNums[0];
        this.devotional = AssignmentNums[1];
        this.closingPrayer = AssignmentNums[2];
        name = Date;
    } // end DayList(int, String, String[], int[], boolean)
    
    /**
     * Creates a null element
     */
    DayList() {
        ClassDays = 0;
        OpeningPrayer = "None";
        Devotional = "None";
        ClosingPrayer = "None";
        Date = new GregorianCalendar(0, Calendar.JANUARY, 1);
        newAssignment = false;
        openingPrayer = 0;
        devotional = 0;
        closingPrayer = 0;
        name = "EMPTY";
    } // end DayList()
    
    /**
     * Initializes the date in a Gregorian Calendar
     *
     * @param Date MM/DD/YYYY
     */
    void setDate(String Date) {
        String[] date = Date.split("/");
        int year = 0, month = 0, day = 1;
        try {
            day = Integer.parseInt(date[1]);
            month = Integer.parseInt(date[0]);
            year = Integer.parseInt(date[2]);
        } // end try
        catch(Exception e) {
            Main.write.println("Error for " + Date);
            Main.write.println("   " + e);
            Main.write.println("      at " + e.getStackTrace()[0]);
            Main.write.println("      at " + e.getStackTrace()[1]);
            Main.write.println("      at " + e.getStackTrace()[2]);
        } // end catch(Exception e)
        switch(month) {
            case 1:
                this.Date = new GregorianCalendar(year, Calendar.JANUARY, day);
                break;
            case 2:
                this.Date = new GregorianCalendar(year, Calendar.FEBRUARY, day);
                break;
            case 3:
                this.Date = new GregorianCalendar(year, Calendar.MARCH, day);
                break;
            case 4:
                this.Date = new GregorianCalendar(year, Calendar.APRIL, day);
                break;
            case 5:
                this.Date = new GregorianCalendar(year, Calendar.MAY, day);
                break;
            case 6:
                this.Date = new GregorianCalendar(year, Calendar.JUNE, day);
                break;
            case 7:
                this.Date = new GregorianCalendar(year, Calendar.JULY, day);
                break;
            case 8:
                this.Date = new GregorianCalendar(year, Calendar.AUGUST, day);
                break;
            case 9:
                this.Date = new GregorianCalendar(year, Calendar.SEPTEMBER, day);
                break;
            case 10:
                this.Date = new GregorianCalendar(year, Calendar.OCTOBER, day);
                break;
            case 11:
                this.Date = new GregorianCalendar(year, Calendar.NOVEMBER, day);
                break;
            case 12:
                this.Date = new GregorianCalendar(year, Calendar.DECEMBER, day);
                break;
            default:
                this.Date = new GregorianCalendar(0, Calendar.JANUARY, 1);
                break;
        } // end switch(month)
        this.Date.setFirstDayOfWeek(Calendar.SUNDAY);
        //      Formula: (Year Code + Month Code + Century Code + Date Number - Leap Year Code) mod 7
        //    Year Code: (YY + (YY div 4)) mod 7
        //   Month Code: J = 0, F = 3, M = 3, A = 6, M = 1, J = 4, J = 6, A = 2, S = 5, O = 0, N = 3, D = 5
        // Century Code: 1700s = 4, 1800s = 2, 1900s = 0, 2000s = 6, 2100s = 4, 2200s = 2, 2300s = 0
        //    Leap Year: 1 if January or February of a leap year, else 0 (Leap year is divisible by 4, but not
        //                  divisible by 100 unless divisible by 400)
        //    Week Days: 0 = Sunday, 6 = Saturday
        System.out.print(Date + ": ");
        int YY = 0, CC = 0;
        try {
            YY = Integer.parseInt(date[2].substring(2));
            CC = Integer.parseInt(date[2].substring(0, 2)) - 17;
        } // end try
        catch(Exception e) {
            Main.write.println(e);
            Main.write.println("   at " + e.getStackTrace()[0]);
            Main.write.println("   at " + e.getStackTrace()[1]);
            Main.write.println("   at " + e.getStackTrace()[2]);
        } // end catch(Exception e)
        int yearCd = Math.floorMod(YY + Math.floorDiv(YY, 4), 7);
        
        int[] MC = new int[]{0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int monthCd = MC[month - 1];
        
        int[] CCd = new int[]{4, 2, 0, 6, 4, 2, 0};
        int centuryCd = CCd[CC];
        
        boolean leapYear = false;
        if(Math.floorMod(year, 4) == 0) {
            if(Math.floorMod(year, 100) == 0) {
                if(Math.floorMod(year, 400) == 0) {
                    leapYear = true;
                } // end if(Math.floorMod(year, 400) == 0)
            }     // end if(Math.floorMod(year, 100) == 0)
            else {
                leapYear = true;
            } // end else
        }     // end if(Math.floorMod(year, 4) == 0)
        int leapCd = 0;
        if(leapYear && (month == 1 || month == 2)) {
            leapCd = 1;
        } // end if(leapYear && (month == 1 || month == 2))
        
        int weekDay = Math.floorMod(yearCd + monthCd + centuryCd + day - leapCd, 7);
        
        Main.write.println("(" + yearCd + " (" + CC + ") + " + monthCd + " + " + centuryCd + " (" + CC + ") + "
                + day + " - " + leapCd + " (" + leapYear + ")) mod 7 = " + weekDay);
        this.Date.set(Calendar.DAY_OF_WEEK, weekDay);
    } // end setDate(Date)
    
    /**
     * Gets the Students assigned to say the prayers
     *
     * @return Opening Prayer, Closing Prayer
     */
    public String[] getPrayerAssignments() {
        return new String[]{OpeningPrayer, ClosingPrayer};
    } // end getPrayerAssignments()
    
    /**
     * @return Student giving the devotional
     */
    public String getDevotional() {
        return Devotional;
    } // end getDevotional()
    
    /**
     * Gets the Students assigned to say the prayers
     *
     * @return the num associated with the students' names
     */
    int[] getPrayerAssignmentNums() {
        return new int[]{openingPrayer, closingPrayer};
    } // end getPrayerAssignmentNums()
    
    /**
     * @return Number associated with the student giving the devotional
     */
    int getDevotionalNum() {
        return devotional;
    } // end getDevotionalNum()
    
    /**
     * @return Day of seminary in current semester
     */
    int getClassDays() {
        return ClassDays;
    } // end getClassDays()
    
    /**
     * @return The date for the day
     */
    GregorianCalendar getDate() {
        return Date;
    } // end getDate()
    
    /**
     * @param lastDay Previous element in linked list
     */
    void setPreviousDay(DayList lastDay) {
        PreviousDay = lastDay;
    } // end setPreviousDay(lastDay)
    
    /**
     * @param nextDay Next element in linked list
     */
    void setNextDay(DayList nextDay) {
        NextDay = nextDay;
    } // end setNextDay(nextDay)
    
    /**
     * @return Previous element
     */
    DayList getPreviousDay() {
        return Objects.requireNonNullElseGet(PreviousDay, DayList::new);
    } // end getPreviousDay()
    
    /**
     * @return Next element
     */
    DayList getNextDay() {
        return Objects.requireNonNullElseGet(NextDay, DayList::new);
    } // end getNextDay()
    
    /**
     * @param reset Whether to restart devotional list
     */
    void setReset(boolean reset) {
        this.reset = reset;
    } // end setReset(boolean)
    
    /**
     * @return Whether to restart the list of names already used for devotional
     */
    boolean isReset() {
        return this.reset;
    } // end isReset()
    
    /**
     * Date string normally, "EMPTY" if null.
     *
     * @return name of instance
     */
    String getName() {
        return name;
    } // end getName()
    
    /**
     * Puts together date in Weekday, MM/DD/YYYY format
     *
     * @return String with date
     */
    String printDate() {
        String date = "";
        switch(Date.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY -> date += "Sunday, ";
            case Calendar.MONDAY -> date += "Monday, ";
            case Calendar.TUESDAY -> date += "Tuesday, ";
            case Calendar.WEDNESDAY -> date += "Wednesday, ";
            case Calendar.THURSDAY -> date += "Thursday, ";
            case Calendar.FRIDAY -> date += "Friday, ";
            case Calendar.SATURDAY -> date += "Saturday, ";
            default -> date += "Null Weekday, ";
        } // end switch(Date.get(Calendar.DAY_OF_WEEK))
        
        switch(Date.get(Calendar.MONTH)) {
            case Calendar.JANUARY -> date += "January ";
            case Calendar.FEBRUARY -> date += "February ";
            case Calendar.MARCH -> date += "March ";
            case Calendar.APRIL -> date += "April ";
            case Calendar.MAY -> date += "May ";
            case Calendar.JUNE -> date += "June ";
            case Calendar.JULY -> date += "July ";
            case Calendar.AUGUST -> date += "August ";
            case Calendar.SEPTEMBER -> date += "September ";
            case Calendar.OCTOBER -> date += "October ";
            case Calendar.NOVEMBER -> date += "November ";
            case Calendar.DECEMBER -> date += "December ";
        } // end switch(Date.get(Calendar.MONTH))
        
        date += Date.get(Calendar.DAY_OF_MONTH) + ", " + Date.get(Calendar.YEAR);
        return date;
    } // end printDate()
    
    /**
     * @return String of the information for the day for the records
     */
    String print() {
        String[] weekDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String restart = " ";
        if(isReset()) {
            restart = ".restart";
        } // end if(isReset())
        return leftPad0(getClassDays(), 2) + "." + padRight(OpeningPrayer + ".", 11) +
                padRight(Devotional + ".", 11) + padRight(ClosingPrayer + ".", 11) +
                leftPad0((Date.get(Calendar.MONTH) + 1), 2) + "/" + leftPad0(Date.get(Calendar.DAY_OF_MONTH), 2)
                + "/" + Date.get(Calendar.YEAR) + padRight(restart, 9) + "." +
                weekDays[Date.get(Calendar.DAY_OF_WEEK) - 1];
    } // end printDay()
    
    /**
     * Adds space padding to the right of the string
     *
     * @param s String to pad
     * @param n How wide to make string with padding
     * @return s + padding
     */
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    } // end padRight(String, int)
    
    /**
     * Adds leading zeros to an integer
     *
     * @param i Number
     * @param n how many digits to pad number two
     * @return i with leading zeros
     */
    public static String leftPad0(int i, int n) {
        return String.format("%0" + n + "d", i);
    } // end leftPad0(int, int)
}     // end DayList
