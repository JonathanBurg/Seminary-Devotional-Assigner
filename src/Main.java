import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Generates new Assignments for Seminary devotionals and prayers
 *
 * @author Jonathan Burgener
 * @since Wednesday, September 4, 2024
 */
public class Main {
    static ArrayList<String> students;
    
    static File recordsFile;
    static File studentsFile;
    static File recentFile;
    static File logFile;
    
    static DayList nullDay;
    static DayList lastResetDay;
    static DayList LatestDay;
    static int testNum;
    static int getDays;
    static Write write;
    static int totalDays;
    
    public static void main(String[] args) {
        testNum = 0;
        totalDays = 0;
        
        // Initialize files and writeLog
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            String time = dtf.format(now);
            studentsFile = new File("Control_Files/Students.txt");
            recordsFile = new File("Control_Files/Records.txt");
            recentFile = new File("Control_Files/Latest.txt");
            logFile = new File("Logs/" + time + "_Log.txt");
            write = new Write(logFile, time);
        } // end try
        catch(Exception e) {
            System.out.println(ANSI.RED_BOLD + e);
            System.out.println(ANSI.BOLD_ITALICS + "    at " + e.getStackTrace()[0] + ANSI.RESET);
        } // end catch(Exception e)
        
        getDays = 1;
        
        getStudents(); // Store student names
        DayList CurrentDay = readRecords(); // Collect previous days
        
        // Take user input to choose how many days to add
        // Scanner in = new Scanner(System.in);
        // write.print("How many days do you want? ");
        // int getDays = in.nextInt();
        
        // Generate assignments for new days
        for(int d = 0; d < getDays; d++) {
            write.println(ANSI.RESET);
            int classDay = CurrentDay.getClassDays() + 1;
            GregorianCalendar oldDate = CurrentDay.getDate();
            GregorianCalendar date = incrementDate(oldDate);
            
            int[] randStudents = new int[3];
            
            DayList currentDay = lastResetDay;
            ArrayList<Integer> previousDevotional = new ArrayList<>();
            ArrayList<Integer> previousPrayer = new ArrayList<>();
            ArrayList<Integer> unassignedNames = new ArrayList<>();
            
            for(int i = 0; i < students.size(); i++) {
                unassignedNames.add(i);
            } // end for(int i < students.size())
            
            // Check previous days to prevent over-assigning a student.
            previousDevotional.add(currentDay.getDevotionalNum());
            unassignedNames.set(currentDay.getDevotionalNum(), -1);
            previousPrayer.add(currentDay.getPrayerAssignmentNums()[0]);
            previousPrayer.add(currentDay.getPrayerAssignmentNums()[1]);
            
            while(currentDay != LatestDay) {
                currentDay = currentDay.getNextDay();
                previousDevotional.add(currentDay.getDevotionalNum());
                unassignedNames.set(currentDay.getDevotionalNum(), -1);
                previousPrayer.add(currentDay.getPrayerAssignmentNums()[0]);
                previousPrayer.add(currentDay.getPrayerAssignmentNums()[1]);
            } // end while(currentDay != CurrentDay)
            
            unassignedNames.removeAll(Collections.singleton(-1));
            write.println(ANSI.WHITE + "Unassigned: " + ANSI.BOLD + unassignedNames + ANSI.RESET);
            
            ArrayList<Integer> PrayerTemp = new ArrayList<>();
            for(int i = previousPrayer.size() - 1; (i > previousPrayer.size() - (2 * students.size() / 3)) && i >= 0; i--) {
                PrayerTemp.add(previousPrayer.get(i));
            }
            previousPrayer = PrayerTemp;
            
            write.print(ANSI.WHITE + "Previous Devotional: " + ANSI.BOLD + previousDevotional + ANSI.RESET);
            if(LatestDay == lastResetDay) {
                write.println(ANSI.YELLOW_ITALICS + "   (Reset)" + ANSI.RESET);
            } // end if(CurrentDay.getPreviousDay().isReset())
            else {
                write.println();
            } // end else
            write.println(ANSI.WHITE + "Previous Prayer: " + ANSI.BOLD + previousPrayer + ANSI.RESET);
            
            randStudents[0] = assignStudent(0, previousPrayer, new int[]{});
            
            for(int i = 0; i < unassignedNames.size(); i++) {
                if(unassignedNames.get(i) == randStudents[0]) {
                    unassignedNames.remove(i);
                    break;
                } // end if(unassignedNames.get(i) == randStudents[0])
            }     // end for(int i < unassignedNames.size())
            
            randStudents[1] = assignStudent(unassignedNames, randStudents[0]);
            randStudents[2] = assignStudent(2, previousPrayer, new int[]{
                    randStudents[0], randStudents[1]
            });
            
            String[] weekDays = new String[]{
                    "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            };
            String dateStr = (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.DAY_OF_MONTH) + "/" +
                    date.get(Calendar.YEAR);
            write.println(ANSI.YELLOW + "Date: " + ANSI.BOLD + weekDays[date.get(Calendar.DAY_OF_WEEK) - 1] + ", " +
                    ANSI.ORANGE + dateStr + ANSI.RESET);
            write.println(ANSI.GREEN + "      Day of Class: " + ANSI.BOLD + classDay + ANSI.RESET);
            write.println(ANSI.CYAN + "    Opening Prayer: " + ANSI.BLUE + students.get(randStudents[0]) + ANSI.PURPLE
                    + " (" + randStudents[0] + ")" + ANSI.RESET);
            write.println(ANSI.CYAN + "        Devotional: " + ANSI.BLUE + students.get(randStudents[1]) + ANSI.PURPLE
                    + " (" + randStudents[1] + ")" + ANSI.RESET);
            write.println(ANSI.CYAN + "    Closing Prayer: " + ANSI.BLUE + students.get(randStudents[2]) + ANSI.PURPLE
                    + " (" + randStudents[2] + ")" + ANSI.RESET);
            
            String[] names = new String[3];
            for(int i = 0; i < 3; i++) {
                names[i] = students.get(randStudents[i]);
            } // end for(int i < 3)
            
            
            DayList newDay = new DayList(classDay, dateStr, names, randStudents, true);
            totalDays++;
            
            if(Objects.equals(lastResetDay.getName(), "EMPTY")) {
                lastResetDay = newDay;
                lastResetDay.setReset(true);
            } // end if(lastResetDay.getName() != "EMPTY")
            
            newDay.setPreviousDay(CurrentDay);
            newDay.setNextDay(nullDay);
            CurrentDay.setNextDay(newDay);
            CurrentDay = newDay;
            LatestDay = CurrentDay;
        } // end for(int d < getDays)
        
        storeRecord();
        
        // Check to make sure the days were stored properly.
        int iter = 2;
        ArrayList<String> dayNames = new ArrayList<>();
        DayList currentDay = CurrentDay.getPreviousDay();
        dayNames.add(currentDay.getName());
        while(!Objects.equals(currentDay.getPreviousDay().getName(), "EMPTY")) {
            currentDay = currentDay.getPreviousDay();
            dayNames.add(currentDay.getName());
            iter++;
            try {
                if(iter >= totalDays + 20) {
                    throw new ArrayStoreException("Critical Error: File pointers failure:");
                } // end if(iter >= totalDays + 20)
            }     // end try
            catch(Exception e) {
                write.println(ANSI.RED + e);
                for(StackTraceElement st : e.getStackTrace()) {
                    write.println(ANSI.RED + ANSI.BOLD_ITALICS + "   at " + st + ANSI.RESET);
                } // end for(StackTraceElement st:e.getStackTrace())
                write.println(ANSI.ORANGE + "   Iterations: " + ANSI.YELLOW + iter + ANSI.RESET);
                write.println(ANSI.ORANGE + "   Elements: " + ANSI.YELLOW + totalDays + ANSI.RESET);
                write.print(ANSI.YELLOW + "   Day track: " + ANSI.ORANGE + CurrentDay.getName() + ANSI.RESET);
                for(String s : dayNames) {
                    write.print(ANSI.RED + ", " + ANSI.ORANGE + s + ANSI.RESET);
                } // end for(String s : dayNames)
                write.println(ANSI.RESET);
                write.println(ANSI.RED_BOLD + "Stopping Program" + ANSI.RESET);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String time = dtf.format(now);
                write.writeLog.println(ANSI.RED + "Program Terminated at " + ANSI.ORANGE + time + ANSI.RESET);
                System.exit(0);
            } // end catch(Exception e)
        }     // end while(currentDay.getName() != "EMPTY")
        
        
        write.println();
        write.println();
        write.println(ANSI.ORANGE + "Assignments:" + ANSI.RESET);
        write.println();
        
        write.println(ANSI.GREEN + currentDay.printDate() + ":" + ANSI.YELLOW + "  (Day " + currentDay.getClassDays() + ")" + ANSI.RESET);
        write.println(ANSI.BLUE + "      Opening: " + ANSI.CYAN + currentDay.getPrayerAssignments()[0] + ANSI.RESET);
        write.print(ANSI.BLUE + "   Devotional: " + ANSI.CYAN + currentDay.getDevotional() + ANSI.RESET);
        if(currentDay.isReset()) {
            write.println(ANSI.PURPLE + "  (Reset)" + ANSI.RESET);
        } // end if(currentDay.isReset())
        else {
            write.println(ANSI.RESET);
        } // end else
        write.println(ANSI.BLUE + "      Closing: " + ANSI.CYAN + currentDay.getPrayerAssignments()[1] + ANSI.RESET);
        
        while(!Objects.equals(currentDay.getName(), CurrentDay.getName())) {
            currentDay = currentDay.getNextDay();
            write.println(ANSI.GREEN + currentDay.printDate() + ":" + ANSI.YELLOW + "  (Day " +
                    currentDay.getClassDays() + ")" + ANSI.RESET);
            write.println(ANSI.BLUE + "      Opening: " + ANSI.CYAN + currentDay.getPrayerAssignments()[0] +
                    ANSI.RESET);
            write.print(ANSI.BLUE + "   Devotional: " + ANSI.CYAN + currentDay.getDevotional() + ANSI.RESET);
            if(currentDay.isReset()) {
                write.println(ANSI.PURPLE + "  (Reset)" + ANSI.RESET);
            } // end if(currentDay.isReset())
            else {
                write.println(ANSI.RESET);
            } // end else
            write.println(ANSI.BLUE + "      Closing: " + ANSI.CYAN + currentDay.getPrayerAssignments()[1] +
                    ANSI.RESET);
        } // end while(currentDay.getName() != CurrentDay.getName())
        
        
        write.println(ANSI.ORANGE + "\nHello World!\n" + ANSI.RESET);
        write.writeLog.close();
    } // end main()
    
    /**
     * Collects the names of students from the files and stores them in an ArrayList
     */
    static void getStudents() {
        try(Scanner studentsRead = new Scanner(studentsFile)) {
            students = new ArrayList<>();
            
            while(studentsRead.hasNext()) {
                String name = studentsRead.nextLine();
                name = name.replaceAll("[^A-Za-z*]", "");
                if(name.charAt(0) != '*') {
                    students.add(name.replaceAll("[^A-Za-z]", ""));
                } // end if(name.charAt(0) != '-')
            }     // end while(hasNext())
        }         // end try(studentsRead)
        catch(Exception e) {
            write.println(ANSI.RESET);
            write.println(ANSI.RED + e + ANSI.RESET);
            write.println(ANSI.RED_ITALICS + "    at " + ANSI.BOLD + e.getStackTrace()[0] + ANSI.RESET);
            write.println(ANSI.RED_ITALICS + "    at " + ANSI.BOLD + e.getStackTrace()[1] + ANSI.RESET);
        } // end catch(e)
        write.print(ANSI.CYAN + "Students: " + ANSI.YELLOW + students.get(0) + ANSI.WHITE + " (0)" + ANSI.RESET);
        for(int i = 1; i < students.size(); i++) {
            write.print(ANSI.WHITE + ", " + ANSI.RESET);
            if(Math.floorMod(i, 6) == 0) {
                write.print("\n          " + ANSI.RESET);
            } // end if(Math.floorMod(i, 6) == 0)
            write.print(ANSI.YELLOW + students.get(i) + ANSI.WHITE + " (" + i + ")" + ANSI.RESET);
        } // end for(int i < students.size()
        write.println(ANSI.RESET);
    } // end getStudents()
    
    /**
     * Reads the files and stores the records in DayLists
     *
     * @return The DayList for the latest day
     */
    static DayList readRecords() {
        DayList CurrentDay = new DayList();
        try(Scanner readRecords = new Scanner(recentFile)) {
            // classday.OpeningName.DevotionalName.ClosingName.MM/DD/YYYY
            //String classDay, opening, devotional, closing, date;
            nullDay = new DayList();
            DayList previousDay;
            DayList currentDay = nullDay;
            readRecords.nextLine();
            
            String daysLine = readRecords.nextLine().replaceAll("[^0-9]", "");
            if(!daysLine.isEmpty()) {
                getDays = Integer.parseInt(daysLine);
            } // end if(!daysLine.isEmpty())
            
            readRecords.nextLine();
            
            while(readRecords.hasNext()) {
                previousDay = currentDay;
                
                String recordLine = readRecords.nextLine();
                recordLine = recordLine.replaceAll(" ", "");
                write.println(ANSI.WHITE + recordLine + ANSI.RESET);
                String[] splitRec = recordLine.split("\\.");
                
                String[] names = new String[]{splitRec[1], splitRec[2], splitRec[3]};
                int[] nums = new int[3];
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < students.size(); j++) {
                        if(Objects.equals(students.get(j), names[i])) {
                            nums[i] = j;
                            break;
                        } // end if(names[i] == students.get(j))
                    }     // end for(int j < students.size())
                }         // end for(int i < 3)
                
                int classDay = 0;
                try {
                    classDay = Integer.parseInt(splitRec[0]);
                } // end try
                catch(Exception e) {
                    write.println(e);
                } // end catch(Exception e)
                currentDay = new DayList(classDay, splitRec[4], names, nums, false);
                totalDays++;
                
                if(splitRec.length >= 6) {
                    currentDay.setReset(Objects.equals(splitRec[5], "restart"));
                } // end if(splitRec.length >= 6)
                if(currentDay.isReset()) {
                    lastResetDay = currentDay;
                } // end if(currentDay.isReset())
                
                previousDay.setPreviousDay(currentDay);
                currentDay.setNextDay(previousDay);
            } // end while(readRecords.hasNext && daysBack <= students.size() + 1)
            
            lastResetDay = currentDay;
            currentDay.setPreviousDay(nullDay);
            CurrentDay = currentDay;
            
            while(currentDay != nullDay) {
                if(CurrentDay.isReset()) {
                    lastResetDay = CurrentDay;
                } // end if(CurrentDay.getPreviousDay().isReset())
                CurrentDay = currentDay;
                currentDay = CurrentDay.getNextDay();
            } // end while(currentDay != nullDay)
            LatestDay = CurrentDay;
        } // end try(readRecords)
        catch(Exception e) {
            write.println(ANSI.RED + e + ANSI.RESET);
            write.println(ANSI.RED_ITALICS + "    at " + ANSI.BOLD + e.getStackTrace()[0] + ANSI.RESET);
            write.println(ANSI.RED_ITALICS + "    at " + ANSI.BOLD + e.getStackTrace()[1] + ANSI.RESET);
        } // end catch(e)
        return CurrentDay;
    } // end readRecords()
    
    /**
     * Stores the assignment information in "Records/Records.txt"
     */
    static void storeRecord() {
        ArrayList<String> storeRecords = new ArrayList<>();
        
        DayList CurrentDay = LatestDay;
        DayList currentDay = CurrentDay;
        
        // Check to make sure the days were stored properly.
        int iter = 1;
        ArrayList<String> dayNames = new ArrayList<>();
        dayNames.add(CurrentDay.getName());
        while(!Objects.equals(currentDay.getName(), "EMPTY")) {
            CurrentDay = currentDay;
            currentDay = CurrentDay.getPreviousDay();
            dayNames.add(currentDay.getName());
            iter++;
            try {
                if(iter >= totalDays + 20) {
                    throw new ArrayStoreException("Critical Error: File pointers failure:");
                } // end if(iter >= totalDays + 20)
            }     // end try
            catch(Exception e) {
                write.println(ANSI.RED + e);
                for(StackTraceElement st : e.getStackTrace()) {
                    write.println(ANSI.RED + ANSI.BOLD_ITALICS + "   at " + st + ANSI.RESET);
                } // end for(StackTraceElement st:e.getStackTrace())
                write.println(ANSI.ORANGE + "   Iterations: " + ANSI.YELLOW + iter + ANSI.RESET);
                write.println(ANSI.ORANGE + "   Elements: " + ANSI.YELLOW + totalDays + ANSI.RESET);
                write.print(ANSI.YELLOW + "   Day track: " + ANSI.ORANGE + dayNames.get(0) + ANSI.RESET);
                for(int i = 1; i < dayNames.size(); i++) {
                    write.print(ANSI.RED + ", " + ANSI.ORANGE + dayNames.get(i) + ANSI.RESET);
                } // end for(int i = 1 < dayNames.size())
                write.println(ANSI.RESET);
                write.println(ANSI.RED_BOLD + "Stopping Program" + ANSI.RESET);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String time = dtf.format(now);
                write.writeLog.println(ANSI.RED + "Program Terminated at " + ANSI.ORANGE + time + ANSI.RESET);
                System.exit(0);
            } // end catch(Exception e)
        }     // end while(currentDay.getName() != "EMPTY")
        
        currentDay = LatestDay;
        while(!Objects.equals(currentDay.getName(), "EMPTY")) {
            storeRecords.add(currentDay.print());
            currentDay = currentDay.getPreviousDay();
        } // end while(currentDay.getName() != "EMPTY")
        
        try(PrintWriter writeRecord = new PrintWriter(recordsFile)) {
            writeRecord.println("##.Opening.   Devotional.Closing.   DD/MM/YYYY.restart  WeekDay");
            writeRecord.println("-----------------------------------------------------------------");
            for(String s : storeRecords) {
                writeRecord.println(s);
            } // end for(String s : storeRecords)
        }     // end try(PrintWriter writeRecord)
        catch(Exception e) {
            write.println(ANSI.RED + e + ANSI.RESET);
            write.println(ANSI.RED_ITALICS + "    at " + ANSI.BOLD + e.getStackTrace()[0] + ANSI.RESET);
            write.println(ANSI.RED_ITALICS + "    at " + ANSI.BOLD + e.getStackTrace()[1] + ANSI.RESET);
        } // end catch(Exception e)
    }     // end storeRecord()
    
    /**
     * Increments the date given
     * <br>Will only increment to weekdays, will skip over weekends.
     *
     * @param oldDate Old date to increment from
     * @return New incremented date
     */
    public static GregorianCalendar incrementDate(GregorianCalendar oldDate) {
        int day = oldDate.get(Calendar.DAY_OF_MONTH);
        int weekDay = oldDate.get(Calendar.DAY_OF_WEEK) - 1;
        int month = oldDate.get(Calendar.MONTH);
        int year = oldDate.get(Calendar.YEAR);
        String oldDayStr = (month + 1) + "/" + day + "/" + year;
        
        day++;
        weekDay++;
        if(weekDay > 5) { // Check for week turnover
            day += 2;
            weekDay += 2;
            if(weekDay > 6) {
                weekDay -= 7;
            } // end if(weekDay > 6)
        }     // end if(weekDay > 5)
        
        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(oldDate.isLeapYear(year)) { // Adjusts length of February for leap year
            daysInMonth[1] = 29;
        } // end if(oldDate.isLeapYear(year))
        
        if(day > daysInMonth[month]) { // Check for month turnover
            day = 1;
            month++;
        } // end if(day > daysInMonth[month])
        
        if(month > 11) { // Check for year turnover
            month = 0;
            year++;
        } // end if(month > 11)
        
        GregorianCalendar newDate = getGregorianCalendar(month, year, day);
        newDate.set(Calendar.DAY_OF_WEEK, weekDay + 1); // Stores the day of the week
        
        String newDayStr = (month + 1) + "/" + day + "/" + year;
        String[] weekDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        write.println(ANSI.YELLOW + "Old Date: " + ANSI.BOLD + weekDays[oldDate.get(Calendar.DAY_OF_WEEK) - 1] + ", " +
                oldDayStr + ANSI.RESET);
        write.println(ANSI.YELLOW + "New Date: " + ANSI.BOLD + weekDays[weekDay] + ", " + newDayStr + ANSI.RESET);
        
        return newDate;
    } // end incrementDate(oldDate)
    
    /**
     * Creates a GregorianCalendar
     *
     * @param month January = 0, December = 11
     * @param year  Year of assignment
     * @param day   Day of month
     * @return GregorianCalendar created
     */
    private static GregorianCalendar getGregorianCalendar(int month, int year, int day) {
        // end switch(month)
        GregorianCalendar newDate = switch(month) { // Check for which month and initializes newDate
            case 0 -> new GregorianCalendar(year, Calendar.JANUARY, day);
            case 1 -> new GregorianCalendar(year, Calendar.FEBRUARY, day);
            case 2 -> new GregorianCalendar(year, Calendar.MARCH, day);
            case 3 -> new GregorianCalendar(year, Calendar.APRIL, day);
            case 4 -> new GregorianCalendar(year, Calendar.MAY, day);
            case 5 -> new GregorianCalendar(year, Calendar.JUNE, day);
            case 6 -> new GregorianCalendar(year, Calendar.JULY, day);
            case 7 -> new GregorianCalendar(year, Calendar.AUGUST, day);
            case 8 -> new GregorianCalendar(year, Calendar.SEPTEMBER, day);
            case 9 -> new GregorianCalendar(year, Calendar.OCTOBER, day);
            case 10 -> new GregorianCalendar(year, Calendar.NOVEMBER, day);
            case 11 -> new GregorianCalendar(year, Calendar.DECEMBER, day);
            default -> new GregorianCalendar(0, Calendar.JANUARY, 1);
        }; // New incremented date
        
        newDate.setFirstDayOfWeek(Calendar.SUNDAY);
        return newDate;
    }
    
    /**
     * @param assignmentType      Opening (0), Devotional (1), or Closing (2)
     * @param PreviousAssignments Either PreviousDevotional or PreviousPrayer
     * @param AssignmentsToday    Students already assigned to a position for the day
     * @return Student assigned
     */
    static int assignStudent(int assignmentType, ArrayList<Integer> PreviousAssignments, int[] AssignmentsToday) {
        switch(assignmentType) {
            case 0 -> write.println(ANSI.WHITE + "Opening Prayer: " + ANSI.RESET);
            case 2 -> write.println(ANSI.WHITE + "Closing Prayer:" + ANSI.RESET);
        } // end switch(assignmentType)
        
        int iteration = 0;
        int rand = -1;
        while(rand < 0) {
            rand = Math.floorMod((int) Math.floor(Math.random() * 1000000), students.size());
            
            write.println(ANSI.WHITE + "   Num: " + ANSI.BOLD + rand + ANSI.RESET);
            
            for(int i : AssignmentsToday) {
                if(i == rand) {
                    rand = -1;
                    break;
                } // end if(i == rand)
            }     // end for(int i : AssignmentsToday)
            
            for(int i : PreviousAssignments) {
                if(i == rand) {
                    rand = -1;
                    break;
                } // end if(i == rand)
            }     // end for(int i : PreviousAssignments)
            iteration++;
            if(iteration > 10 && AssignmentsToday.length > 1) {
                write.println(ANSI.YELLOW + rand + ANSI.RESET);
                try {
                    throw new RuntimeException("Assignment Failure (" + iteration + ")");
                } // end try
                catch(Exception e) {
                    write.println(ANSI.RED + e.getMessage() + ANSI.RESET);
                    write.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + e.getStackTrace()[0] + ANSI.RESET);
                    write.println(ANSI.RED_ITALICS + "   at " + ANSI.BOLD + e.getStackTrace()[1] + ANSI.RESET);
                    rand = 0;
                    break;
                } // end catch(Exception e)
            }     // end if(iteration > 10 && AssignmentsToday.length > 1)
        }         // end while(rand < 0)
        
        if(assignmentType == 2) {
            AssignmentsToday = new int[]{AssignmentsToday[0], AssignmentsToday[1], rand};
            write.println(ANSI.WHITE + "Assigned Today: " + ANSI.BOLD + Arrays.toString(AssignmentsToday) + ANSI.RESET);
        } // end if(assignmentType == 2)
        
        return rand;
    } // end assignStudent(int, ArrayList<Integer>, int[])
    
    static int assignStudent(ArrayList<Integer> unassignedNames, int opening) {
        if(unassignedNames.isEmpty()) {
            for(int i = 0; i < students.size(); i++) {
                unassignedNames.add(i);
            } // end for(int i < students.size())
            unassignedNames.remove(opening);
            lastResetDay = new DayList();
        } // end if(unassignedNames.isEmpty())
        
        write.println(ANSI.WHITE + "Devotional:" + ANSI.RESET);
        
        int rand = -1;
        while(rand < 0) {
            rand = unassignedNames.get(Math.floorMod((int) Math.floor(Math.random() * 1000000),
                    unassignedNames.size()));
            
            write.println(ANSI.WHITE + "   Num: " + ANSI.BOLD + rand + ANSI.RESET);
        } // end while(rand < 0)
        
        return rand;
    } // end assignStudent(ArrayList<Integer>, int)
}     // end Main

/*
7.Mason.Zac.Alex.9/6/2024.false.false
6.Zac.Emma.Mabry.9/5/2024.false.false
5.Emma.Shawn.Mason.9/4/2024.false.false
4.Alex.Mason.Rachel.9/3/2024.false.false
3.Jonathan.Avery.Zac.8/30/2024.false.false
2.Mabry.Alex.Rachel.8/29/2024.false.false
1.Ethan.Jonathan.Mason.8/28/2024.false.false
 */