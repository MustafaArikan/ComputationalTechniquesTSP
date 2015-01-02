package tsp;

public class Node {
	private int ID;
	private float X;
	private float Y;
	
    public Node(int id, float x, float y){
        this.ID = id;
    	this.X = x;
        this.Y = y;
    }
	
    public static double getDistance(Node a, Node b) {
        float xDistance = Math.abs(a.getX() - b.getX());
        float yDistance = Math.abs(a.getY() - b.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }//endmethod getDistance
    
    // Gets node's x coordinate
    public float getX(){
        return this.X;
    }
    
    // Gets node's y coordinate
    public float getY(){
        return this.Y;
    }

    // Gets node's ID
	public int getID() {
		return this.ID;
	}
}
