package tsp;

import javax.swing.SwingUtilities;

import vis.Nodes;

public class SA {

	public static void main(String[] args) {
		// Simulated Annealing start
		String pathToFile = "berlin52.tsp"; // path to Berlin file, tsp file containing nodes

		final TourOrganizer to = new TourOrganizer();
		Reader.ReadAndFillOrganizer(pathToFile, to);
		
		System.out.println("Number of Nodes: " + to.numberOfNodes());
		
        // Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize intial solution
        final Tour currentSolution = new Tour();
        currentSolution.generateIndividual();
        
        System.out.println("Initial solution distance: " + currentSolution.getDistance());
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Nodes ps = new Nodes(to, currentSolution);
                ps.setVisible(true);
            }
        });
	}
}