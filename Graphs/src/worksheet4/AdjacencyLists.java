package worksheet4;

import java.util.ArrayList;

public class AdjacencyLists {
    private ArrayList<AdjacencyList> neighbourList;

    public AdjacencyLists(AdjacencyMatrix neighboursMatrix) {
        neighbourList = new ArrayList<>();
        int numVertices = neighboursMatrix.numOfVertices();

        for (int i = 0; i < numVertices; i++) {
            AdjacencyList list = new AdjacencyList(i);
            for (int j = 0; j < numVertices; j++) {
                if (neighboursMatrix.get(i, j) != 0) {
                    list.add(j);
                }
            }
            neighbourList.add(list);
        }
    }

    public AdjacencyList getNeighboursFor(int v) {
        return neighbourList.get(v);
    }
}
