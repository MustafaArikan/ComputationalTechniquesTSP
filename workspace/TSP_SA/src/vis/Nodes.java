package vis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tsp.Tour;
import tsp.TourOrganizer;

class Surface extends JPanel {
	private static final long serialVersionUID = 1L;
	private Tour tour;

	public Surface(Tour showTour) {
		tour = showTour;
		// TODO Auto-generated constructor stub
	}

	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.red);

		Dimension size = getSize();
		Insets insets = getInsets();

		int w = size.width - insets.left - insets.right;
		int h = size.height - insets.top - insets.bottom;

		for (int i = 0; i < TourOrganizer.numberOfNodes(); i++) {
			g2d.setColor(Color.red);
			float x = (TourOrganizer.getNode(i).getX()/2)+20;
			float y = (TourOrganizer.getNode(i).getY()/2)+20;
			g2d.drawString("" + (i + 1), x, y);

			g2d.setColor(Color.blue);
			if (i < TourOrganizer.numberOfNodes()-1) {
				int x1 = ((int) tour.getNode(i).getX()/2)+20;
				int y1 = ((int) tour.getNode(i).getY()/2)+20;
				int x2 = ((int) tour.getNode(i + 1).getX()/2)+20;
				int y2 = ((int) tour.getNode(i + 1).getY()/2)+20;
				g2d.drawLine(x1, y1, x2, y2);
			}
		}
	}

	private void addTour(Tour currentSolution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}

public class Nodes extends JFrame {
	private static final long serialVersionUID = 1L;
	private TourOrganizer showTo;
	private Tour showTour;

	public Nodes(TourOrganizer to, Tour currentSolution) {
		showTour = currentSolution;
		initUI();
	}

	private void initUI() {

		setTitle("Nodes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new Surface(showTour));

		setSize(350, 250);
		setLocationRelativeTo(null);
	}
}