package com.general.problems;

import java.util.*;

class AirportProgram {
    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
        HashMap<String, AirportNode> airportNodeMap = new HashMap<>();
        List<AirportNode> airportNodeList = new ArrayList<>();
        buildAdjancencyList(airports, routes, airportNodeMap, airportNodeList);
        //Now lets do DFS
        doDFSAndUpdateNeighbours(airports, airportNodeMap, airportNodeList);
        //sort the airportNodeList
        sortTheNodeListDecending(airportNodeList);

        /**
         * Start from the starting Airport
         * 1. Create a Set and add all the neighbours of starting airport
         * 2. Now start picking from the sorted list
         * 3. go on and pick if the new set addition is unique
         */
        int count = connectAirportsAndFindCount(startingAirport, airportNodeMap, airportNodeList);
        return count;
    }

    private static int connectAirportsAndFindCount(String startingAirport, HashMap<String, AirportNode> airportNodeMap, List<AirportNode> airportNodeList) {
        HashSet<String> finalSet = new HashSet<>();
        AirportNode startingNode = airportNodeMap.get(startingAirport);
        for(String existingNeighbours : startingNode.getNeighbourNodes()){
            finalSet.add(existingNeighbours);
        }

        int count = 0;
        for(AirportNode airportNode :  airportNodeList){
            //decide if we should pick this or not
            Set<String> neighbourNodes = airportNode.getNeighbourNodes();
            boolean result = checkIfDifferentSets(finalSet, neighbourNodes, startingAirport);
            String airportName = airportNode.getAirportName();
            if(result && !finalSet.contains(airportNode.getAirportName()) && !airportName.equalsIgnoreCase(startingAirport)){
                //add this to final Set
                count++;
                for(String node : neighbourNodes){
                    finalSet.add(node);
                    finalSet.add(airportNode.getAirportName());
                }
            }
        }
        return count;
    }

    private static boolean checkIfDifferentSets(HashSet<String> finalSet, Set<String> neighbourNodes, String startingAirport) {
        for(String node : neighbourNodes){
            if(finalSet.contains(node) && !node.equalsIgnoreCase(startingAirport)){
                return false;
            }
        }
        return true;
    }

    private static void doDFSAndUpdateNeighbours(List<String> airports, HashMap<String, AirportNode> airportNodeMap, List<AirportNode> airportNodeList) {
        HashMap<String, List<String>> newAdditionMap = new HashMap<>();
        for(String airport : airports){
            newAdditionMap.put(airport, new ArrayList<>());
        }
        for(AirportNode airportNode : airportNodeList){
            HashSet<String> visited = new HashSet<>();
            doDFSUtil(airportNode, airportNodeMap, visited, newAdditionMap);
        }

        for(String airport : newAdditionMap.keySet()){
            List<String> newNeighbours = newAdditionMap.get(airport);
            Set<String> neighbourNodes = airportNodeMap.get(airport).getNeighbourNodes();
            for(String neighbour: newNeighbours){
                neighbourNodes.add(neighbour);
            }
        }
    }

    private static void sortTheNodeListDecending(List<AirportNode> airportNodeList) {
        Collections.sort(airportNodeList, new Comparator<AirportNode>() {
            @Override
            public int compare(AirportNode o1, AirportNode o2) {
                return o2.getNeighbourNodes().size() - o1.getNeighbourNodes().size();
            }
        });
    }

    private static void doDFSUtil(AirportNode airportNode, HashMap<String, AirportNode> airportNodeMap, HashSet<String> visited, HashMap<String, List<String>> newAdditionMap) {
        visited.add(airportNode.getAirportName());
        for(String neighbour : airportNode.getNeighbourNodes()){
            doDFS(airportNode, airportNodeMap.get(neighbour), airportNodeMap, visited, newAdditionMap);
        }
    }

    private static void doDFS(AirportNode sourceNode, AirportNode currentNode, HashMap<String, AirportNode> airportNodeMap,
                              HashSet<String> visited, HashMap<String, List<String>> newAdditionMap) {
        if(!visited.contains(currentNode.getAirportName())) {
            visited.add(currentNode.getAirportName());
            newAdditionMap.get(sourceNode.getAirportName()).add(currentNode.getAirportName());
            for (String neighbour : currentNode.getNeighbourNodes()) {
                doDFS(sourceNode, airportNodeMap.get(neighbour), airportNodeMap, visited, newAdditionMap);
            }
        }
    }


    private static void buildAdjancencyList(List<String> airports, List<List<String>> routes, HashMap<String, AirportNode> airportNodeMap, List<AirportNode> airportNodeList) {
        for(String airport : airports){
            AirportNode airportNode = new AirportNode();
            airportNode.setAirportName(airport);
            airportNodeList.add(airportNode);
            airportNodeMap.put(airport, airportNode);
        }
        for(List<String> route : routes){
            String source = route.get(0);
            String destination = route.get(1);
            AirportNode airportNode = airportNodeMap.get(source);
            airportNode.getNeighbourNodes().add(destination);
        }
    }
}

class AirportNode{
    private String airportName;
    private Set<String> neighbourNodes;
    private int neighbourCount;

    public AirportNode(){
        this.neighbourNodes = new HashSet<>();
        this.neighbourCount = 0;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Set<String> getNeighbourNodes() {
        return neighbourNodes;
    }

    public void setNeighbourNodes(Set<String> neighbourNodes) {
        this.neighbourNodes = neighbourNodes;
    }

    public int getNeighbourCount() {
        return neighbourCount;
    }

    public void setNeighbourCount(int neighbourCount) {
        this.neighbourCount = neighbourCount;
    }
}

