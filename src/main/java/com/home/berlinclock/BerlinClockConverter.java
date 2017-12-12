package com.home.berlinclock;

import java.time.LocalTime;

public class BerlinClockConverter {

    private static final char OFF = 'O';
    private static final char YELLOW = 'Y';
    private static final char RED = 'R';

    private LocalTime time;

    public void time(LocalTime time) {
        this.time = time;
    }

    public String singleMinutesRow() {
        char[] singleMinuteRow = new char[]{OFF, OFF, OFF, OFF};

        int singleMinutes = (time.getMinute() % 10);

        singleMinutes = singleMinutes >= 5 ? singleMinutes - 5 : singleMinutes;

        for (int i = 0; i < singleMinutes; i++) {
            singleMinuteRow[i] = YELLOW;
        }

        return String.valueOf(singleMinuteRow);
    }

    public String fiveMinutesRow() {
        char[] fiveMinuteRow = new char[]{OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF};

        int fiveMinutes = time.getMinute() / 5;

        for (int i = 0; i < fiveMinutes; i++) {
            if ((i + 1) % 3 == 0)
                fiveMinuteRow[i] = RED;
            else
                fiveMinuteRow[i] = YELLOW;
        }

        return String.valueOf(fiveMinuteRow);
    }

    public String singleHoursRow() {
        char[] singleHoursRow = new char[]{OFF, OFF, OFF, OFF};
        int singleHours = time.getHour() % 5;

        for (int i = 0; i < singleHours; i++) {
            singleHoursRow[i] = RED;
        }

        return String.valueOf(singleHoursRow);
    }

    public String fiveHoursRow() {
        char[] fiveHoursRow = new char[]{OFF, OFF, OFF, OFF};
        int fiveHours = time.getHour() / 5;

        for (int i = 0; i < fiveHours; i++) {
            fiveHoursRow[i] = RED;
        }

        return String.valueOf(fiveHoursRow);
    }

    public String secondsLamp() {
        return (time.getSecond() % 2 == 0 )? String.valueOf(YELLOW) : String.valueOf(OFF);
    }

    public String entireClock() {
        return secondsLamp() + fiveHoursRow() + singleHoursRow() + fiveMinutesRow() + singleMinutesRow();
    }
}
