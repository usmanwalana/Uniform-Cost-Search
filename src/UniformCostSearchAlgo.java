import java.util.*;

/**
 * Created by Usman on 06/12/2016.
 */
public class UniformCostSearchAlgo
{
    public static void main(String[] args){
        int dist=10;
        //initialize the graph base on the Romania map
        Node n1 = new Node("Start");
        Node n2 = new Node("A");
        Node n3 = new Node("B");
        Node n4 = new Node("C");
        Node n5 = new Node("D");
        Node n6 = new Node("E");
        Node n7 = new Node("F");
        Node n8 = new Node("H");
        Node n9 = new Node("P");
        Node n10 = new Node("q");
        Node n11 = new Node("R");
        Node n12 = new Node("Goal");
        //initialize the edges
        n1.adjacencies = new Edge[]{
                new Edge(n5,3),
                new Edge(n6,9),
                new Edge(n9,1)
        };

        n2.adjacencies = new Edge[]{
        };

        n3.adjacencies = new Edge[]{
                new Edge(n2,2),
        };

        n4.adjacencies = new Edge[]{
                new Edge(n2,2),
        };

        n5.adjacencies = new Edge[]{
                new Edge(n4,8),
                new Edge(n3,1),
                new Edge(n6,2),
        };

        n6.adjacencies = new Edge[]{
                new Edge(n8,8),
                new Edge(n11,2),
        };

        n7.adjacencies = new Edge[]{
                new Edge(n12,2),
                new Edge(n4,3),
        };

        n8.adjacencies = new Edge[]{
                new Edge(n9,4),
                new Edge(n10,4)
        };

        n9.adjacencies = new Edge[]{
                new Edge(n10,15),
        };

        n10.adjacencies = new Edge[]{
        };

        n11.adjacencies = new Edge[]{
                new Edge(n7,1),
        };

        n12.adjacencies = new Edge[]{
        };

        UniformCostSearch(n1,n12);

        List<Node> path = printPath(n12);

        System.out.println("Path: " + path);
        System.out.println("The distance from Start to Goal is: "+dist);

    }

    public static void UniformCostSearch(Node source, Node goal){

        source.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>(){

                    //override compare method
                    public int compare(Node i, Node j){
                        if(i.pathCost > j.pathCost){
                            return 1;
                        }

                        else if (i.pathCost < j.pathCost){
                            return -1;
                        }

                        else{
                            return 0;
                        }
                    }
                }

        );


        queue.add(source);
        Set<Node> explored = new HashSet<Node>();
        boolean found = false;

        //while frontier is not empty
        do{

            Node current = queue.poll();
            explored.add(current);


            if(current.value.equals(goal.value)){
                found = true;


            }




            for(Edge e: current.adjacencies){
                Node child = e.target;
                double cost = e.cost;
                child.pathCost = current.pathCost + cost;



                if(!explored.contains(child) && !queue.contains(child)){

                    child.parent = current;
                    queue.add(child);

                    System.out.println(child);
                    System.out.println(queue);
                    System.out.println();

                }




                else if((queue.contains(child))&&(child.pathCost>current.pathCost)){

                    child.parent=current;

                    queue.remove(child);
                    queue.add(child);

                }


            }
        }while(!queue.isEmpty());

    }

    public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;

    }
}
