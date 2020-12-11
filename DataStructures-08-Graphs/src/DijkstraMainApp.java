public class DijkstraMainApp {
    public static void main(String[] args) {
        final WeightedGraph t = new WeightedGraph (6);
        t.setVertex (0, "Columbus");
        t.setVertex (1, "Atlanta");
        t.setVertex (2, "Detroit");
        t.setVertex  (3, "DC");
        t.setVertex  (4, "NY");
        t.setVertex  (5, "Boston");
       // From Columbus to...
        t.addEdge (0,1,5);
        t.addEdge (0,2,3);
        t.addEdge (0,3,8);
        // From Atlanta to...
        t.addEdge (1,3,8);
        // From Detroit to...
        t.addEdge (2,3,7);
        t.addEdge (2,4,9);
        // From DC to...
        t.addEdge (3,4,3);
        // From NY to...
        t.addEdge (4,5,2);
        //System.out.println("Edges of the Graph :");
        t.print();

        final int [] pred = Dijkstra.dijkstra (t, 0);

        System.out.println("Shortest Paths From Cities :");
        for (int n=0; n<6; n++) Dijkstra.printPath(t, pred, 0, n);
    }
}
