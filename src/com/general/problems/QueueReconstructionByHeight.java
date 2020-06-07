package com.general.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people){
        int[][] result = new int[people.length][2];
        ArrayList<People> peopleList = buildPeopleList(people);
        /**
         * 1. Sort the input based on height
         *      a. If height is same then based on the second parameter.
         */
        sortByHeight(peopleList);
        People[] peopleSeats = new People[peopleList.size() + 1];
        placePeopleToPosition(peopleSeats, peopleList);
        convertPeopleListToResult(peopleSeats, result);
        return result;
    }

    private void convertPeopleListToResult(People[] peopleSeats, int[][] result) {
        for(int index = 0; index < result.length; index++){
            result[index][0] = peopleSeats[index].getHeight();
            result[index][1] = peopleSeats[index].getTallerPeopleInFront();
        }
    }

    private void placePeopleToPosition(People[] peopleSeats, ArrayList<People> peopleList) {
        for(int index = 0; index < peopleList.size(); index++){
            int seatPosition = 0;
            People people = peopleList.get(index);
            int leftCount = people.getTallerPeopleInFront();
            while(leftCount > 0 || peopleSeats[seatPosition] != null){
                //if seat is occupied
                if(peopleSeats[seatPosition] != null) {
                    if (peopleSeats[seatPosition].getHeight() >= people.getHeight() && people.getTallerPeopleInFront() > 0) {
                        leftCount--;
                    }
                    seatPosition++;
                }
                else{
                    //seat is not occupied
                    leftCount--;
                    seatPosition++;
                }
            }
            if(seatPosition < peopleSeats.length){
                peopleSeats[seatPosition] = people;
            }
        }
    }

    private void sortByHeight(ArrayList<People> peopleList) {
        Collections.sort(peopleList, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if(o1.getHeight() == o2.getHeight()){
                    return o1.getTallerPeopleInFront() - o2.getTallerPeopleInFront();
                }
                return o1.getHeight() - o2.getHeight();
            }
        });
    }

    private ArrayList<People> buildPeopleList(int[][] people) {
        ArrayList<People> peopleList = new ArrayList<>();
        for(int index = 0; index < people.length; index++){
            People people1 = new People(people[index][0], people[index][1]);
            peopleList.add(people1);
        }
        return peopleList;
    }


}

class People{
    private int height;
    private int tallerPeopleInFront;

    public People(int height, int tallerPeopleInFront) {
        this.height = height;
        this.tallerPeopleInFront = tallerPeopleInFront;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTallerPeopleInFront() {
        return tallerPeopleInFront;
    }

    public void setTallerPeopleInFront(int tallerPeopleInFront) {
        this.tallerPeopleInFront = tallerPeopleInFront;
    }
}
