# Graph Data Structures and Visualization in Java

This repository contains Java implementations of graph data structures and a simple graphical visualization tool. The projects were developed as part of an Algorithms and Data Structures lab course.

## Project Overview

The code demonstrates fundamental graph concepts including:

- **Adjacency Matrix:** Representation of a graph using a 2D array.
- **Adjacency Lists:** Efficient neighbor representation using linked lists.
- **Graph Class:** Combines matrix and list representations, provides graph properties and path generation.
- **GraphPainter:** Visualizes the graph and highlights simple paths using Java AWT and Swing.

## Features

- Create and manage undirected graphs.
- Convert between adjacency matrix and adjacency lists.
- Generate simple non-cyclic paths of a specified length.
- Visualize the graph structure and highlight paths in a GUI window.

## How to Run

1. Clone the repository.
2. Compile all Java files in the `worksheet4` package.
3. Run the `GraphPainter` class to launch the visualization and console output.
   ```bash
   javac worksheet4/*.java
   java worksheet4.GraphPainter
   ```
4. The program will display a graph window and print neighbors and path details in the console.

## Code Structure

- `AdjacencyMatrix.java`: Manages the graph as a 2D matrix.
- `AdjacencyList.java`: Represents neighbors of a vertex as a linked list.
- `AdjacencyLists.java`: Builds adjacency lists from the matrix.
- `Graph.java`: Provides graph utilities and pathfinding.
- `GraphPainter.java`: GUI class to draw the graph and paths.

## Notes

- The visualization currently supports graphs with up to 8 vertices.
- The layout is static but can be extended for larger or dynamic graphs.
- The `somePath` method generates a simple path without cycles starting from a given vertex.

## License

This project is for educational purposes.

---

Feel free to explore and extend the code! Contributions and feedback are welcome.

