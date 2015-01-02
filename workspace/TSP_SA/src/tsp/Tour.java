/*
* Tour.java
* Stores a candidate tour through all nodes
*/

package tsp;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
	
    // Holds our tour of nodes
    private ArrayList<Node> tour = new ArrayList<Node>();
    private int distance = 0;
    
    // Constructs a empty tour
    public Tour(){
        for (int i = 0; i < TourOrganizer.numberOfNodes(); i++) {
            tour.add(null);
        }
    }
    
    // Returns tour information
    public ArrayList<Node> getTour(){
        return tour;
    }

    // Creates a random individual
    public void generateIndividual() {
        // Loop through all our destination nodes and add them to our tour
        for (int nodeIndex = 0; nodeIndex < TourOrganizer.numberOfNodes(); nodeIndex++) {
          setNode(nodeIndex, TourOrganizer.getNode(nodeIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    // Gets a node from the tour
    public Node getNode(int tourPosition) {
        return (Node)tour.get(tourPosition);
    }

    // Sets a node in a certain position within a tour
    public void setNode(int tourPosition, Node node) {
        tour.set(tourPosition, node);
        // If the tours been altered we need to reset the fitness and distance
        distance = 0;
    }
    
    // Gets the total distance of the tour
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            // Loop through our tour's nodes
            for (int nodeIndex=0; nodeIndex < tourSize(); nodeIndex++) {
                // Get node we're traveling from
                Node fromNode = getNode(nodeIndex);
                // Node we're traveling to
                Node destinationNode;
                // Check we're not on our tour's last node, if we are set our
                // tour's final destination node to our starting node
                if(nodeIndex+1 < tourSize()){
                    destinationNode = getNode(nodeIndex+1);
                }
                else{
                    destinationNode = getNode(0);
                }
                // Get the distance between the two nodes
                tourDistance += Node.getDistance(fromNode, destinationNode);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // Get number of nodes on our tour
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getNode(i)+"|";
        }
        return geneString;
    }

}
