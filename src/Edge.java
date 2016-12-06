/**
 * Created by Usman on 06/12/2016.
 */
public class Edge
{
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
        cost = costVal;
        target = targetNode;

    }
}
