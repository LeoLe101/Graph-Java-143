package cs143;

import cs143.AbstractGraph.Tree;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Phuc Hong Le
 */
public class EastAngliaTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        String[] town = {"Blaxhall", "Clacton", "Dunwich",
            "Feering", "Harwich", "Maldon", "Tiptree", "Alton", "Fenley"};

        // Edge array for graph in Figure 28.1
        int[][] roads = {
            {0, 2}, {0, 3}, {0, 4},
            {1, 4}, {1, 5}, {1, 6},
            {2, 0}, {2, 4},
            {3, 0}, {3, 5}, {3, 6},
            {4, 0}, {4, 1}, {4, 2}, {4, 6},
            {5, 1}, {5, 3}, {5, 6},
            {6, 1}, {6, 3}, {6, 5},
            {7, 8}, {8, 7}
        };
        UnweightedGraph<String> graph = new UnweightedGraph<>(town, roads);
        System.out.println("Blaxhall to Tiptree: "
                + graph.isConnected("Blaxhall", "Tiptree"));
        System.out.println("Blaxhall to Fenley: "
                + graph.isConnected("Blaxhall", "Fenley"));
        System.out.println("1. Blaxhall");
        System.out.println("2. Clacton");
        System.out.println("3. Dunwich");
        System.out.println("4. Feering");
        System.out.println("5. Harwich");
        System.out.println("6. Maldon");
        System.out.println("7. Tiptree");
        System.out.println("8. Alton");
        System.out.println("9. Fenley");
        do {
            System.out.println("Select first town: ");
            int selection1 = scan.nextInt();
            System.out.println("Select the second town: ");
            int selection2 = scan.nextInt();
            List<String> path = graph.dfsPath(town[selection1], town[selection2]);
            //test the path in order to get there
            if (path == null) {
                System.out.println("You cannot get there from here!");
            } else {
                System.out.println("One path: " + path);
            }
            Tree tree = graph.bfs(selection2);
            path = tree.getPath(selection1);
            if (!path.contains(town[selection1])
                    || !path.contains(town[selection2])) {
                System.out.println("No shortest path available!");
            } else {
                System.out.println("Shortest path: " + path);
            }
            if (graph.getNeighbors(selection2).contains(selection1)) {
                System.out.println("you can get there right away");
            } else {
                System.out.println("you cannot get there right away");
            }
            System.out.println("Do it again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int ans = scan.nextInt();
            if (ans == 2) {
                check = true;
            }
        } while (check == false);

    }

}
