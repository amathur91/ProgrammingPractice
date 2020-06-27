package com.general.problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Solution for Calender Matching Algoexpert
 */

public class CalenderMatching {
    public static List<StringMeeting> calendarMatching(List<StringMeeting> calendar1, StringMeeting dailyBounds1,
            List<StringMeeting> calendar2, StringMeeting dailyBounds2, int meetingDuration) {
        List<StringMeeting> availableMeetingSlots = new ArrayList<>();
        List<StringMeeting> person1FreeTimeSlot = new ArrayList<>();
        List<StringMeeting> person2FreeTimeSlot = new ArrayList<>();
        populatePersonFreeTimeSlots(person1FreeTimeSlot, dailyBounds1, calendar1);
        populatePersonFreeTimeSlots(person2FreeTimeSlot, dailyBounds2, calendar2);
        if(calendar1.isEmpty() && calendar2.isEmpty()){
            findOverlappingFreeSlots(new ArrayList<>(Arrays.asList(dailyBounds1)), new ArrayList<>(Arrays.asList(dailyBounds2)), meetingDuration, availableMeetingSlots);
        }else {
            findOverlappingFreeSlots(person1FreeTimeSlot, person2FreeTimeSlot, meetingDuration, availableMeetingSlots);
        }
        return availableMeetingSlots;
    }

    private static void findOverlappingFreeSlots(List<StringMeeting> person1FreeTimeSlot, List<StringMeeting> person2FreeTimeSlot, int meetingDuration, List<StringMeeting> availableMeetingSlots) {
        int freeSlot1Index = 0;
        int freeSlot2Index = 0;

        while (freeSlot1Index < person1FreeTimeSlot.size() && freeSlot2Index < person2FreeTimeSlot.size()) {
            StringMeeting overlap = findOverlap(person1FreeTimeSlot.get(freeSlot1Index), person2FreeTimeSlot.get(freeSlot2Index), meetingDuration);
            if (overlap!= null) {
                availableMeetingSlots.add(overlap);
            }
            if(isTimeAfter(person1FreeTimeSlot.get(freeSlot1Index).end, person2FreeTimeSlot.get(freeSlot2Index).end)){
                freeSlot1Index++;
            }else{
                freeSlot2Index++;
            }
        }
    }

    private static StringMeeting findOverlap(StringMeeting freeSlot1, StringMeeting freeSlot2, int meetingDuration) {
        if(isTimeAfter(freeSlot2.start, freeSlot1.start) && isTimeAfter(freeSlot1.start, freeSlot2.end) && isTimeAfter(freeSlot2.end, freeSlot1.end)){
            StringMeeting slot = new StringMeeting(freeSlot1.start, freeSlot2.end);
            if(isSlotSufficientForMeeting(meetingDuration, slot)){
                return slot;
            }
        }

        if(isTimeAfter(freeSlot1.start, freeSlot2.start) && isTimeAfter(freeSlot2.start, freeSlot1.end) && isTimeAfter(freeSlot1.end, freeSlot2.end)){
            StringMeeting slot = new StringMeeting(freeSlot2.start, freeSlot1.end);
            if(isSlotSufficientForMeeting(meetingDuration, slot)){
                return slot;
            }
        }

        if(isTimeAfter(freeSlot1.start, freeSlot2.start) && isTimeAfter(freeSlot2.end, freeSlot1.end)){
            StringMeeting slot = new StringMeeting(freeSlot2.start, freeSlot2.end);
            if(isSlotSufficientForMeeting(meetingDuration, slot)){
                return slot;
            }
        }

        if(isTimeAfter(freeSlot1.start, freeSlot2.start) && isTimeAfter(freeSlot2.start, freeSlot1.end) && isTimeAfter(freeSlot1.end, freeSlot2.end)){
            StringMeeting slot = new StringMeeting(freeSlot2.start, freeSlot1.end);
            if(isSlotSufficientForMeeting(meetingDuration, slot)){
                return slot;
            }
        }

        if(isTimeAfter(freeSlot2.start, freeSlot1.start) && isTimeAfter(freeSlot1.start, freeSlot2.end) && isTimeAfter(freeSlot2.end, freeSlot1.end)){
            StringMeeting slot = new StringMeeting(freeSlot1.start, freeSlot2.end);
            if(isSlotSufficientForMeeting(meetingDuration, slot)){
                return slot;
            }
        }

        if(isTimeAfter(freeSlot2.start, freeSlot1.start) && isTimeAfter(freeSlot1.end, freeSlot2.end)){
            StringMeeting slot = new StringMeeting(freeSlot1.start, freeSlot1.end);
            if(isSlotSufficientForMeeting(meetingDuration, slot)){
                return slot;
            }
        }
        return null;
    }

    private static boolean isSlotSufficientForMeeting(int meetingDuration, StringMeeting slot) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date startTime = sdf.parse(slot.start);
            Date endTime = sdf.parse(slot.end);
            long timeDifference = Math.abs(endTime.getTime() - startTime.getTime());
            long minutesDifference = TimeUnit.MINUTES.convert(timeDifference, TimeUnit.MILLISECONDS);
            return minutesDifference >= meetingDuration;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isTimeAfter(String time1, String time2) {
        int hour1 = Integer.valueOf(time1.split(":")[0]);
        int mins1 = Integer.valueOf(time1.split(":")[1]);
        int hour2 = Integer.valueOf(time2.split(":")[0]);
        int mins2 = Integer.valueOf(time2.split(":")[1]);
        if(hour2 == hour1){
            return mins2 >= mins1;
        }
        else if(hour2 >= hour1){
            return true;
        }
        return false;
    }

    private static void populatePersonFreeTimeSlots(List<StringMeeting> person1FreeTimeSlot, StringMeeting dailyBounds1,
                                                    List<StringMeeting> calendar1) {
        String startTime = dailyBounds1.start;
        for(StringMeeting meeting : calendar1) {
            if (!checkIfTwoTimeAreSame(startTime, meeting.start)) {
                person1FreeTimeSlot.add(new StringMeeting(startTime, meeting.start));
            }
            startTime = meeting.end;
        }
        if (!checkIfTwoTimeAreSame(startTime, dailyBounds1.end)) {
            person1FreeTimeSlot.add(new StringMeeting(startTime,dailyBounds1.end));
        }
    }

    private static int getMinutesDifference(String startTime, String firstMeeting) {
        return Math.abs(Integer.valueOf(firstMeeting.split(":")[1]) - Integer.valueOf(startTime.split(":")[1]));
    }

    private static int getHourDifference(String startTime, String firstMeeting) {
        return Math.abs(Integer.valueOf(firstMeeting.split(":")[0]) - Integer.valueOf(startTime.split(":")[0]));
    }

    private static boolean checkIfTwoTimeAreSame(String startTime, String firstMeeting) {
        int hour1 = Integer.valueOf(startTime.split(":")[0]);
        int min1 = Integer.valueOf(startTime.split(":")[1]);
        int hour2 = Integer.valueOf(firstMeeting.split(":")[0]);
        int min2 = Integer.valueOf(firstMeeting.split(":")[1]);
        return hour1 == hour2 && min1 == min2;
    }
    
    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
