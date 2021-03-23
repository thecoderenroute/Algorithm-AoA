package Utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GraphGen {

    public static void main(String[] args) {

        int[][] graph = generateRandomGraph(5, 6);
        int[][] graph2 = getCustomGraph();

        System.out.println("1:");
        printGraph(graph);

        System.out.println("\n2:");
        printGraph(graph2);
    }

    private static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    public static int[][] getUnWeightedCustomGraph(int n){
        Scanner scanner = new Scanner(System.in);

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.out
                    .println("Enter connections for " + i + "[-1 to break, will overwrite, so don't mention double]: ");
            while (true) {
                System.out.print("Node: ");
                int node = scanner.nextInt();
                if (node == -1)
                    break;

                // System.out.print("Length: ");
                // int length = scanner.nextInt();

                if (node < 0 || node >= n)
                    continue;

                graph[i][node] = 1;
                graph[node][i] = 1;
            }

        }
        scanner.close();
        return graph;
    }

    public static int[][] getUnWeightedCustomGraph() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        scanner.close();

        return getUnWeightedCustomGraph(n);

    }

    public static int[][] generateRandomUnWeightedGraph(int l){

        int[][] graph = new int[l][l];

        Random random = new Random();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {

                if (i == j) {
                    graph[i][j] = 0;
                    graph[i][j] = 0;
                } else {
                    if (random.nextDouble() > 0.33) {
                        // int temp = random.nextInt(max) + 1;
                        graph[j][i] = 1;
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }

        return graph;
        
    }

    public static int[][] getCustomGraph(int n) {

        Scanner scanner = new Scanner(System.in);

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.out
                    .println("Enter connections for " + i + "[-1 to break, will overwrite, so don't mention double]: ");
            while (true) {
                System.out.print("Node: ");
                int node = scanner.nextInt();
                if (node == -1)
                    break;

                System.out.print("Length: ");
                int length = scanner.nextInt();

                if (node < 0 || node >= n || length < 0)
                    continue;

                graph[i][node] = length;
                graph[node][i] = length;
            }

        }
        scanner.close();
        return graph;
    }

    public static int[][] getCustomGraph() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        scanner.close();

        return getCustomGraph(n);

    }

    public static int[][] generateRandomGraph(int l, int max) {

        int[][] graph = new int[l][l];

        Random random = new Random();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {

                if (i == j) {
                    graph[i][j] = 0;
                    graph[i][j] = 0;
                } else {
                    if (random.nextDouble() > 0.33) {
                        int temp = random.nextInt(max) + 1;
                        graph[j][i] = temp;
                        graph[i][j] = temp;
                    }
                }
            }
        }


        return graph;
    }
}
