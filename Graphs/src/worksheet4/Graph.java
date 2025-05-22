package worksheet4;

import java.util.ArrayList;

public class Graph {
    private AdjacencyMatrix neighboursMatrix;
    private AdjacencyLists neighboursLists;

    public Graph(int[][] adjMatrix) {
        this.neighboursMatrix = new AdjacencyMatrix(adjMatrix);
        this.neighboursLists = new AdjacencyLists(neighboursMatrix);
    }

    public AdjacencyList getNeighboursFor(int v) {
        return neighboursLists.getNeighboursFor(v);
    }
 
    public int numOfVertices() {
        return neighboursMatrix.numOfVertices();
    }

    public int numOfEdges() {
        int edges = 0;
        for (int i = 0; i < neighboursMatrix.numOfVertices(); i++) {
            for (int j = i + 1; j < neighboursMatrix.numOfVertices(); j++) {
                if (neighboursMatrix.get(i, j) != 0) {
                    edges++;
                }
            }
        }
        return edges;
    }

    public int getWeight(int u, int v) {
        return neighboursMatrix.get(u, v);
    }

    /**
     * Generate a simple path from vertex u with the given length.
     * Ensures no cycles in the path.
     */
    public AdjacencyList somePath(int u, int length) {
        AdjacencyList path = new AdjacencyList(u); // Initialize path with the starting vertex
        path.add(u); // Explicitly add the starting vertex to the path
        ArrayList<Integer> visited = new ArrayList<>(); // To track visited vertices
        visited.add(u);

        int currentVertex = u;

        while (path.size() < length) {
            AdjacencyList neighbors = getNeighboursFor(currentVertex);
            boolean foundNext = false;

            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    path.add(neighbor);
                    currentVertex = neighbor;
                    foundNext = true;
                    break; // Move to the next vertex
                }
            }

            if (!foundNext) {
                // If no unvisited neighbor is found, terminate the path early
                break;
            }
        }
        return path;
    }

}
