package com.general.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirportConnectionTest {
    @Test
    public void test1(){
        String[] airports = {  "BGI","CDG","DEL","DOH", "DSM","EWR","EYW","HND",
                "ICN","JFK","LGA","LHR","ORD","SAN","SFO","SIN","TLV","BUD"};
        List<String> airportList = Arrays.asList(airports);
        List<List<String>> routes = new ArrayList<List<String>>() ;
        routes.add(Arrays.asList(new String[]{"LGA", "DSM"}));
        routes.add(Arrays.asList(new String[]{"DSM", "ORD"}));
        routes.add(Arrays.asList(new String[]{"EYW", "JFK"}));
        routes.add(Arrays.asList(new String[]{"EYW", "EWR"}));
        routes.add(Arrays.asList(new String[]{"JFK", "ICN"}));
        routes.add(Arrays.asList(new String[]{"LGA", "ICN"}));
        routes.add(Arrays.asList(new String[]{"ICN", "ORD"}));
        routes.add(Arrays.asList(new String[]{"ICN", "EWR"}));
        routes.add(Arrays.asList(new String[]{"JFK", "DSM"}));
        routes.add(Arrays.asList(new String[]{"ICN", "JFK"}));
        routes.add(Arrays.asList(new String[]{"ORD", "DSM"}));
        routes.add(Arrays.asList(new String[]{"DSM", "LGA"}));
        routes.add(Arrays.asList(new String[]{"JFK", "LGA"}));
        routes.add(Arrays.asList(new String[]{"JFK", "HND"}));
        routes.add(Arrays.asList(new String[]{"SFO", "SIN"}));
        routes.add(Arrays.asList(new String[]{"SFO", "CDG"}));
        routes.add(Arrays.asList(new String[]{"SFO", "LHR"}));
        routes.add(Arrays.asList(new String[]{"LHR", "DEL"}));
        routes.add(Arrays.asList(new String[]{"DEL", "BGI"}));
        routes.add(Arrays.asList(new String[]{"DEL", "DOH"}));
        routes.add(Arrays.asList(new String[]{"DOH", "SAN"}));
        int result = AirportProgram.airportConnections(airportList, routes,"LGA");
        System.out.println(result);
    }

    @Test
    public void test2(){
        String[] airports = {
                "BGI",
                "CDG",
                "DEL",
                "DOH",
                "DSM",
                "EWR",
                "EYW",
                "HND",
                "ICN",
                "JFK",
                "LGA",
                "LHR",
                "ORD",
                "SAN",
                "SFO",
                "SIN",
                "TLV",
                "BUD"};
        List<String> airportList = Arrays.asList(airports);
        List<List<String>> routes = new ArrayList<List<String>>();
        routes.add(Arrays.asList(new String[]{"LGA", "DSM"}));
        routes.add(Arrays.asList(new String[]{"SIN", "BGI"}));
        routes.add(Arrays.asList(new String[]{"SIN", "CDG"}));
        routes.add(Arrays.asList(new String[]{"SIN", "DEL"}));
        routes.add(Arrays.asList(new String[]{"SIN", "DOH"}));
        routes.add(Arrays.asList(new String[]{"SIN", "DSM"}));
        routes.add(Arrays.asList(new String[]{"SIN", "EWR"}));
        routes.add(Arrays.asList(new String[]{"SIN", "EYW"}));
        routes.add(Arrays.asList(new String[]{"SIN", "HND"}));
        routes.add(Arrays.asList(new String[]{"SIN", "ICN"}));
        routes.add(Arrays.asList(new String[]{"SIN", "JFK"}));
        routes.add(Arrays.asList(new String[]{"SIN", "LHR"}));
        routes.add(Arrays.asList(new String[]{"SIN", "ORD"}));
        routes.add(Arrays.asList(new String[]{"SFO", "SIN"}));
        routes.add(Arrays.asList(new String[]{"SFO", "SAN"}));
        int result = AirportProgram.airportConnections(airportList, routes, "LGA");
        System.out.println(result);
    }
}
