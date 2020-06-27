package com.general.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalenderMatchingTest {

    @Test
    public void test1(){
        List<CalenderMatching.StringMeeting> calender1 = new ArrayList<>();
        calender1.add(new CalenderMatching.StringMeeting("9:00", "10:30"));
        calender1.add(new CalenderMatching.StringMeeting("12:00", "13:00"));
        calender1.add(new CalenderMatching.StringMeeting("16:00", "18:00"));

        CalenderMatching.StringMeeting dailyBounds = new CalenderMatching.StringMeeting("9:00", "20:00");

        List<CalenderMatching.StringMeeting> calender2 = new ArrayList<>();
        calender2.add(new CalenderMatching.StringMeeting("10:00", "11:30"));
        calender2.add(new CalenderMatching.StringMeeting("12:30", "14:30"));
        calender2.add(new CalenderMatching.StringMeeting("14:30", "15:00"));
        calender2.add(new CalenderMatching.StringMeeting("16:00", "17:00"));

        CalenderMatching.StringMeeting dailyBounds2 = new CalenderMatching.StringMeeting("10:00", "18:30");
        int meetingDuration = 45;

        CalenderMatching.calendarMatching(calender1, dailyBounds, calender2, dailyBounds2, meetingDuration);

    }


    @Test
    public void test2(){
        List<CalenderMatching.StringMeeting> calender1 = new ArrayList<>();
        calender1.add(new CalenderMatching.StringMeeting("9:00", "10:30"));
        calender1.add(new CalenderMatching.StringMeeting("12:00", "13:00"));
        calender1.add(new CalenderMatching.StringMeeting("16:00", "18:00"));

        CalenderMatching.StringMeeting dailyBounds = new CalenderMatching.StringMeeting("8:00", "20:00");

        List<CalenderMatching.StringMeeting> calender2 = new ArrayList<>();
        calender2.add(new CalenderMatching.StringMeeting("10:00", "11:30"));
        calender2.add(new CalenderMatching.StringMeeting("12:30", "14:30"));
        calender2.add(new CalenderMatching.StringMeeting("14:30", "15:00"));
        calender2.add(new CalenderMatching.StringMeeting("16:00", "17:00"));

        CalenderMatching.StringMeeting dailyBounds2 = new CalenderMatching.StringMeeting("07:00", "18:30");
        int meetingDuration = 45;

        CalenderMatching.calendarMatching(calender1, dailyBounds, calender2, dailyBounds2, meetingDuration);

    }

    @Test
    public void test3(){
        List<CalenderMatching.StringMeeting> calender1 = new ArrayList<>();

        CalenderMatching.StringMeeting dailyBounds = new CalenderMatching.StringMeeting("9:30", "20:00");

        List<CalenderMatching.StringMeeting> calender2 = new ArrayList<>();

        CalenderMatching.StringMeeting dailyBounds2 = new CalenderMatching.StringMeeting("09:00", "16:30");
        int meetingDuration = 45;

        CalenderMatching.calendarMatching(calender1, dailyBounds, calender2, dailyBounds2, meetingDuration);

    }
}
