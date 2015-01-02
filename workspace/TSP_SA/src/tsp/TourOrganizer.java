package tsp;

import java.util.ArrayList;

public class TourOrganizer {
	
    // Holds our nodes
    private static ArrayList<Node> destinationNodes = new ArrayList<Node>();

    // Adds a destination node
    public static void addCity(Node node) {
        destinationNodes.add(node);
    }
    
    // Get a node
    public static Node getCity(int index){
        return (Node)destinationNodes.get(index);
    }
    
    // Get the number of destination nodes
    public static int numberOfCities(){
        return destinationNodes.size();
    }

}
