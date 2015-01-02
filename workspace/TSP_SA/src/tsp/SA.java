package tsp;

public class SA {

	public static void main(String[] args) {
		// Simulated Annealing start
		String pathToFile = "berlin52.tsp"; // path to Berlin file, tsp file containing nodes

		TourOrganizer to = new TourOrganizer();
		Reader.ReadAndFillOrganizer(pathToFile, to);
		
		System.out.println("Number of Nodes: " + to.numberOfNodes());
	}

}
