package cs143;

import java.util.Scanner;

/**
 *
 * @author Phuc Hong Le
 */
public class EastAngliaTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        String[] vertices = {"Blaxhall", "Clacton", "Dunwich",
            "Feering", "Harwich", "Maldon", "Tiptree"};

        // Edge array for graph in Figure 28.1
        int[][] edges = {
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 1},
            {0, 1, 0, 1, 1, 1, 0}};
        Graph<String> graph1 = new UnweightedGraph<>(vertices, edges);
        System.out.println("1. Blaxhall");
        System.out.println("2. Clacton");
        System.out.println("3. Dunwich");
        System.out.println("4. Feering");
        System.out.println("5. Harwich");
        System.out.println("6. Maldon");
        System.out.println("7. Tiptree");
        while (check == false) {
            System.out.println("Select first town: ");
            int selection1 = scan.nextInt();
            System.out.println("Select the second town: ");
            int selection2 = scan.nextInt();
            if (graph1.getNeighbors(selection2).contains(selection1)) {
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
        }

    }

}
