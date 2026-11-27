package strings.level3;

import java.util.Scanner;

// Program 9: Display the calendar of a given month and year
public class CalendarDisplay {
    // Name of the month
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    // Leap year check
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Number of days in the month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // First day of the month using the Gregorian algorithm (0 = Sunday)
    public static int getFirstDay(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();
        input.close();

        // Validate the input
        if (month < 1 || month > 12 || year < 1) {
            System.out.println("Invalid month or year.");
            return;
        }

        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDay(month, year);

        // Header
        System.out.println("   " + getMonthName(month) + " " + year);
        System.out.println(" Su Mo Tu We Th Fr Sa");

        // Indentation up to the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }

        // Days of the month, new line after Saturday
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d", day);
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
