public class WeightedGraph {

        private int [][]  edges;  // adjacency matrix
        private static Object [] labels;

        public WeightedGraph (int n) {
            edges  = new int [n][n];
            labels = new Object[n];
        }

        public int size() { return labels.length; }

        public void   setVertex (int vertex, Object label) { labels[vertex]=label; }
        public Object getLabel (int vertex)               { return labels[vertex]; }

        public void    addEdge    (int source, int target, int w)  { edges[source][target] = w; }
        public boolean isEdge     (int source, int target)  { return edges[source][target]>0; }
        public void    removeEdge (int source, int target)  { edges[source][target] = 0; }
        public int     getWeight  (int source, int target)  { return edges[source][target]; }

       public static int getByLabel(Object theLabel){
            int vertexNum=0;
           for (int i=0;i<labels.length;i++)
                if (labels[i]==theLabel) vertexNum=i;
                    return vertexNum;
       }
        public int [] neighbors (int vertex) {
            int count = 0;
            for (int i=0; i<edges[vertex].length; i++) {
                if (edges[vertex][i]>0) count++;
            }
            final int[]answer= new int[count];
            count = 0;
            for (int i=0; i<edges[vertex].length; i++) {
                if (edges[vertex][i]>0) answer[count++]=i;
            }
            return answer;
        }

        public void print () {
            for (int j=0; j<edges.length; j++) {
                System.out.print (labels[j]+": ");
                for (int i=0; i<edges[j].length; i++) {
                    if (edges[j][i]>0) System.out.print (labels[i]+":"+edges[j][i]+" ");
                }
                System.out.println ();
            }
        }
}
