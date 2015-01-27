package tsp;

import javax.swing.SwingUtilities;

import vis.Nodes;

public class SA {

	public static void main(String[] args) {
		
		for(int i=0; i<1;i++)
		{
		int counter = 0;
		// Simulated Annealing start
		String pathToFile = "berlin52.tsp"; // path to Berlin file, tsp file containing nodes

		final TourOrganizer to = new TourOrganizer();
		Reader.ReadAndFillOrganizer(pathToFile, to);
		
		System.out.println("Number of Nodes: " + to.numberOfNodes());
		
        // Set initial temp
		double initTemp = 10000;
        double temp = 10000;
        double N = 119;

        // Cooling rate
        double coolingRate = 0.00001;

        // Initialize intial solution
        Tour currentSolution = new Tour();
        final Tour solutionforGraphicalOutout = new Tour();
        currentSolution.generateIndividual();
        
        System.out.println("Initial solution distance: " + currentSolution.getDistance());
        
        // Set as current best
        Tour best = new Tour();
        best.setTour(currentSolution.getTour());
        
        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour();
            newSolution.setTour(currentSolution.getTour());

            // Get a random positions in the tour
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // Get the cities at selected positions in the tour
            Node nodeSwap1 = newSolution.getNode(tourPos1);
            Node nodeSwap2 = newSolution.getNode(tourPos2);

            // Swap them
            newSolution.setNode(tourPos2, nodeSwap1);
            newSolution.setNode(tourPos1, nodeSwap2);
            
            // Get energy of solutions
            float currentEnergy = currentSolution.getDistance();
            float neighbourEnergy = newSolution.getDistance();

            // Decide if we should accept the neighbour
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentSolution = new Tour();
                currentSolution.setTour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour();
                best.setTour(currentSolution.getTour());
                counter++;
            }
            
            // Cool system
            temp = temp * ( 1-coolingRate );
            
            //temp = initTemp * ( 1 - (counter/N) );
            //temp = temp - (0.001) ;
        }

			if (best.getDistance() < 7555) {
				System.out.println("Final solution distance: "+ best.getDistance());
				System.out.println("Optimal solution distance: " + 7542);
				System.out.println("Tour: " + best.toString());
				System.out.println("Number of iterations: " + counter);

				solutionforGraphicalOutout.setTour(currentSolution.getTour());
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						Nodes ps = new Nodes(to, solutionforGraphicalOutout);
						ps.setVisible(true);
					}
				});
			}
	}
	}
	
    // Calculate the acceptance probability
    public static double acceptanceProbability(float distance, float newDistance, double temperature) {
        // If the new solution is better, accept it
        if (newDistance < distance) {
            return 1.0;
        }
        
        //return 0.0;
        // If the new solution is worse, calculate an acceptance probability
        //System.out.println("acceptance rate: " + (distance - newDistance) / temperature);
		//System.out.println("exp:"+ Math.exp((distance - newDistance) / temperature));
		return Math.exp((distance - newDistance) / temperature);
		//return (distance / newDistance);
        //return (distance / newDistance) * (temperature / 10000);
    }
}