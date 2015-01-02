package tsp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Reader {
	private static BufferedReader br;

	static void ReadAndFillOrganizer(String pathToFile, TourOrganizer to) {
		// Read file and fill all nodes to TourOrganizer object to

		try {
			br = new BufferedReader(new FileReader(pathToFile));
			String strLine = "";
			StringTokenizer st = null;

			for (int i = 0; i < 6; i++) {
				strLine = br.readLine();
			}

			// read whitespace separated file line by line
			while ((strLine = br.readLine()) != null) {

				// break whitespace separated line using " "
				st = new StringTokenizer(strLine, " ");

				if (st.countTokens() == 3) {
					int ID = new Integer(st.nextToken());
					float X = new Float(st.nextToken());
					float Y = new Float(st.nextToken());
			        Node node = new Node(ID, X, Y);
					to.addNode(node);
				}

			}

		} catch (Exception e) {
			System.out.println("Exception while reading tsp file: " + e);
		}
	}
}
