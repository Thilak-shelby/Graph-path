package worksheet4;

import java.util.Iterator;
import java.util.LinkedList;

public class AdjacencyList implements Iterable<Integer> {
    private LinkedList<Integer> adjacencies;
    private int id;

    public AdjacencyList(int id) {
        this.id = id;
        this.adjacencies = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void add(int neighbour) {
        adjacencies.add(neighbour);
    }

    public boolean contains(int v) {
        return adjacencies.contains(v);
    }

    public int size() {
        return adjacencies.size();
    }

    public int get(int index) {
        return adjacencies.get(index);
    }

    @Override
    public Iterator<Integer> iterator() {
        return adjacencies.iterator();
    }
}
