package worksheet4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GraphPainter extends Canvas {

	private static final long serialVersionUID = 1L;
	private Dimension screenSize;

	private Graph aGraph;
	private AdjacencyList aPath;
	
	public GraphPainter(Graph g){
		this.aGraph = g;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame("Ein Graph");
		setSize(screenSize);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setAPath(AdjacencyList l) {
		aPath = l;
	}
	
	/********************************************************************************
	 * Painting the Graph on the screen
	 ********************************************************************************/
	
	public void paint(Graphics g) {		
		int[][] positionsOfVertices = layoutOfGraph();
		
		drawVertices(g, positionsOfVertices);
		drawEdges(g, positionsOfVertices);
		drawPathEdges(g, positionsOfVertices);
	}

	private void drawVertices(Graphics g, int[][] positions){
		g.setColor(Color.black);
		for (int v = 0; v < aGraph.numOfVertices(); v++) {
			g.drawOval(positions[v][0], positions[v][1], 50, 50);
			g.drawString(""+v, positions[v][0]+20, positions[v][1]+30);
		}
	}
	
	private void drawEdges(Graphics g, int[][] positions) {
	    g.setColor(Color.blue); // Default color for all edges

	    for (int u = 0; u < aGraph.numOfVertices(); u++) {
	        for (int v = u + 1; v < aGraph.numOfVertices(); v++) {
	            if (aGraph.getWeight(u, v) != 0) {
	                g.drawLine(
	                        positions[u][0] + 25, positions[u][1] + 25,
	                        positions[v][0] + 25, positions[v][1] + 25
	                );
	            }
	        }
	    }
	}
	
	private void drawPathEdges(Graphics g, int[][] positions) {
	    if (aPath == null || aPath.size() < 2) {
	        return; // No path or too short to draw
	    }

	    g.setColor(Color.red); // Path color

	    int currentVertex = aPath.get(0); // Start with the first vertex in the path
	    for (int i = 1; i < aPath.size(); i++) {
	        int nextVertex = aPath.get(i);
	        g.drawLine(
	                positions[currentVertex][0] + 25, positions[currentVertex][1] + 25,
	                positions[nextVertex][0] + 25, positions[nextVertex][1] + 25
	        );
	        currentVertex = nextVertex; // Move to the next vertex
	    }
	}


	
	private int[][] layoutOfGraph(){
		int xMin = screenSize.width / 2;
		return new int[][] {
				{xMin +   0, 100}, 
				{xMin + 200, 200},
				{xMin + 400, 400},
				{xMin + 200, 600},
				{xMin -   0, 700},
				{xMin - 200, 600},
				{xMin - 400, 400},
				{xMin - 200, 200}};
	}
	
	/********************************************************************************
	 * Testprogram
	 ********************************************************************************/
	
	public static void main(String[] args) {
		final int H = 0;
		int[][] adjMatrix = {
				{H, 0, 0, 1, 1, 0, 0, 0}, // vertice 0 has two neighbours 3 and 4
				{0, H, 1, 0, 0, 0, 1, 0}, 
				{0, 0, H, 0, 0, 0, 0, 1}, 
				{0, 0, 0, H, 1, 0, 0, 1},
				{0, 0, 0, 0, H, 1, 0, 1},
				{0, 0, 0, 0, 0, H, 1, 1},
				{0, 0, 0, 0, 0, 0, H, 1},
				{0, 0, 0, 1, 1, 0, 0, H}};

		Graph g = new Graph(adjMatrix);
		
		GraphPainter painter = new GraphPainter(g);

		AdjacencyList aPath = g.somePath(1, 5);
		painter.setAPath(aPath);
		
		// Print all the vertices and their neighbours
		for (int v = 0; v < g.numOfVertices(); v++) {
			System.out.print("Neighbour of "+v+":");
			AdjacencyList adjList = g.getNeighboursFor(v);
			for (Integer neighbour: adjList) {
				System.out.print(" " + neighbour.toString());
			}
			System.out.println();
		}
		System.out.println("Number of edges: "+g.numOfEdges());
		
		for (Integer i : aPath) {
			System.out.println("Path i = " + i);
		}
	}
}