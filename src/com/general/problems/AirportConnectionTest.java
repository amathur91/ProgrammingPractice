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
        String[] airports = {"BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN",
                "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"};
        List<String> airportList = Arrays.asList(airports);
        List<List<String>> routes = new ArrayList<List<String>>();
        routes.add(Arrays.asList(new String[]{"DSM","ORD"}));
        routes.add(Arrays.asList(new String[]{"ORD","BGI"}));
        routes.add(Arrays.asList(new String[]{"BGI","LGA"}));
        routes.add(Arrays.asList(new String[]{"SIN","CDG"}));
        routes.add(Arrays.asList(new String[]{"CDG","SIN"}));
        routes.add(Arrays.asList(new String[]{"CDG","BUD"}));
        routes.add(Arrays.asList(new String[]{"DEL","DOH"}));
        routes.add(Arrays.asList(new String[]{"DEL","CDG"}));
        routes.add(Arrays.asList(new String[]{"TLV","DEL"}));
        routes.add(Arrays.asList(new String[]{"EWR","HND"}));
        routes.add(Arrays.asList(new String[]{"HND","ICN"}));
        routes.add(Arrays.asList(new String[]{"HND","JFK"}));
        routes.add(Arrays.asList(new String[]{"ICN","JFK"}));
        routes.add(Arrays.asList(new String[]{"JFK","LGA"}));
        routes.add(Arrays.asList(new String[]{"EYW","LHR"}));
        routes.add(Arrays.asList(new String[]{"LHR","SFO"}));
        routes.add(Arrays.asList(new String[]{"SFO","SAN"}));
        routes.add(Arrays.asList(new String[]{"SFO","DSM"}));
        routes.add(Arrays.asList(new String[]{"SAN","EYW"}));
        int result = AirportProgram.airportConnections(airportList, routes, "LGA");
        System.out.println(result);
    }
}
