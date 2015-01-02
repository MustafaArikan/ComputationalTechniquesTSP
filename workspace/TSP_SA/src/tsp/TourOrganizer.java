package tsp;

import java.util.ArrayList;

public class TourOrganizer {
	
    // Holds our nodes
    private static ArrayList<Node> destinationNodes = new ArrayList<Node>();

    // Adds a destination node
    public static void addNode(Node node) {
        destinationNodes.add(node);
    }
    
    // Get a node
    public static Node getNode(int index){
        return (Node)destinationNodes.get(index);
    }
    
    // Get the number of destination nodes
    public static int numberOfNodes(){
        return destinationNodes.size();
    }

}
