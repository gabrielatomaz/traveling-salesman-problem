
# 🚀 Project Overview

This project implements algorithms to solve the Traveling Salesman Problem (TSP). The TSP is a well-known problem in combinatorial optimization where the goal is to find the shortest possible route that visits a set of cities and returns to the origin city.

## ✨ Approaches Implemented
1. **Brute Force Approach**:
 - Description: Evaluates all possible permutations of cities to find the shortest route.
 - Usage: Suitable for small datasets due to its exhaustive nature.
2. **Minimum Spanning Tree (MST) Approach**:
 - Description: Constructs a minimum spanning tree of city connections to approximate the shortest route.
 - Usage: Efficient for larger datasets where brute force is impractical.

## 📂 Project Structure

The project is organized into the following directories:

- **bin**: contains all compiled Java class files.
- **src**
  - **approaches**: contains all the approaches and logic for each algorithm.
  - **matrices**: contains all test files.
  - **utils**: contains a static class to convert the matrices to a matrix format used by the algorithms.
  - **App**: main application class to run the project.

## 🚀 How to Run

1. Ensure you have Java installed on your system.
2. Run the main application:
   ```sh
   java -cp bin App
   ```

## 📜 Dependencies

No external dependencies are required for this project.

## 👤 Author

- **Gabriela Ribeiro**
