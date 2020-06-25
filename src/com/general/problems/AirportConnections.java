package com.general.problems;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Airport%20Connections
 * Algorithm:
 * 1. Build a Map from input data to have a connectivity map.
 * 2. Do DFS and build a map which tells a airport's indirect connectivity.
 * 3. Now create a structure to store the data generated after DFS.
 * 4. Sort this data store based on the max connectivity links.
 * 5. Now create a empty set
 * 6. Iterate over the data store and pick the airport which has maximum
 *    connectivity and not included in final set
 * 7. the check should be that if all of the linked airports are included then exclude it***
 * 8. At last there might be airports which are isolated and then should be picked.
 */
class AirportProgram {
    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
        if(routes.size() == 0){
            return airports.size() - 1;
        }
        HashMap<String,  List<String>> routeMap = new HashMap<>();
        HashMap<String, List<String>> connectionMap = new HashMap<>();
        for(String airport : airports){
            routeMap.put(airport, new ArrayList<>());
        }
        buildRouteMap(routes, routeMap, startingAirport, airports);
        for(String airport : airports){
            connectionMap.put(airport, new ArrayList<>());
            Set<String> visitedAirports = new HashSet<>();
            doDFS(airport, routeMap, connectionMap, airport, visitedAirports);
        }
        List<Airport> airportList = new ArrayList<>();
        for(Map.Entry<String, List<String>> entrySet : connectionMap.entrySet()){
            Airport airport = new Airport(entrySet.getKey(), entrySet.getValue());
            airportList.add(airport);
        }
        Collections.sort(airportList, (o1, o2) -> {
            return o2.getConnectedAirports().size() - o1.getConnectedAirports().size();
        });

        Set<String> finalSet = new HashSet<>();
        List<String> initialConnectivity = connectionMap.get(startingAirport);
        if(null != initialConnectivity){
            for(String airport : initialConnectivity){
                finalSet.add(airport);
            }
        }
        int count = 0;
        for(Airport airport : airportList){
            if(!checkIfAlreadyPartOfSet(airport, finalSet) && !airport.getAirportName().equalsIgnoreCase(startingAirport)){
                addCurrentAirportAndConnectityToSet(airport, finalSet);
                count++;
            }
        }
        if(finalSet.size() + 1 != airportList.size()){
            count += airportList.size() - (finalSet.size() + 1);
        }
        return count;
    }

    private static void addCurrentAirportAndConnectityToSet(Airport airport, Set<String> finalSet) {
        finalSet.add(airport.getAirportName());
        for(String neighbour : airport.getConnectedAirports()){
            finalSet.add(neighbour);
        }
    }

    private static boolean checkIfAlreadyPartOfSet(Airport connectedAirports, Set<String> finalSet) {
        int sizeOfConnected = connectedAirports.getConnectedAirports().size();
        int count = 0;
        for(String airport : connectedAirports.getConnectedAirports()){
            if(finalSet.contains(airport)){
                count++;
            }
        }
       if(count == sizeOfConnected){
           return true;
       }
        return false;
    }

    private static void doDFS(String airport, HashMap<String, List<String>> routeMap, HashMap<String, List<String>> connectionMap, String parentAirport, Set<String> visitedAirports) {
        if(routeMap.containsKey(airport)  && !visitedAirports.contains(airport)){
            visitedAirports.add(airport);
            List<String> immediateNeighbours = routeMap.get(airport);
            for(String immediateNeighbour : immediateNeighbours) {
                addToParentConnectivityMap(immediateNeighbour, parentAirport, connectionMap);
                doDFS(immediateNeighbour, routeMap, connectionMap, parentAirport, visitedAirports);
            }
        }
    }

    private static void addToParentConnectivityMap(String connectedNeighbour, String parentAirport, HashMap<String, List<String>> connectionMap) {
        if(!parentAirport.equalsIgnoreCase(connectedNeighbour)) {
            if (connectionMap.containsKey(parentAirport)) {
                connectionMap.get(parentAirport).add(connectedNeighbour);
            } else {
                ArrayList connectedNeighbourList = new ArrayList();
                connectedNeighbourList.add(connectedNeighbour);
                connectionMap.put(parentAirport, connectedNeighbourList);
            }
        }
    }

    private static void buildRouteMap(List<List<String>> routes, HashMap<String, List<String>> routeMap, String startingAirport, List<String> airports) {
        for(List<String> route : routes){
            String source = route.get(0);
            String destination = route.get(1);
            if(!destination.equalsIgnoreCase(startingAirport)) {
                if (routeMap.containsKey(source) && routeMap.get(source).size() > 0) {
                    //append this destination to the List
                    routeMap.get(source).add(destination);
                } else {
                    //create this new entry
                    ArrayList<String> destinationList = new ArrayList<>();
                    destinationList.add(destination);
                    routeMap.put(source, destinationList);
                }
            }
        }
    }

}

class Airport{
    private String airportName;
    private List<String> connectedAirports;

    public Airport(String airportName, List<String> connectedAirports) {
        this.airportName = airportName;
        this.connectedAirports = connectedAirports;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public List<String> getConnectedAirports() {
        return connectedAirports;
    }

    public void setConnectedAirports(List<String> connectedAirports) {
        this.connectedAirports = connectedAirports;
    }
}

