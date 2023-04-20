import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Graph;
import org.graphstream.algorithm.generator.RandomGenerator;
 
/**
 * Se crea una grafica aleatoria en donde los nodos con al menos un vecino
 * tienen el mismo color y los que no se dibujan con colores diferentes.
 * @author Gaitan Sandra
 */
public class Neighbors{

   
    /**
     * Metodo que genera una grafica aleatoria cada que es llamado.
     * @param size Un entero que representa el numero de nodos que tendra la grafica.
     * @return La grafica generada.
     */
    public Graph generatesGraph(int size){
        Graph g = new SingleGraph("Random");
        RandomGenerator gen = new RandomGenerator();
        gen.addSink(g);
        gen.begin();
        for(int i = 0; i < size; i++)
            gen.nextEvents();
        gen.end();
        return g;
    }
    
    
    /**
     * Metodo que pinta los nodos de la grafica aleatoria pasada como parametro.
     * De color negro los nodos que tienen al menos un vecino. De cualquier otro color
     * los nodos que no tienen vecinos.
     * @param g Una grafica aleatoria.
     */
    public void painterGraph(Graph g){
        Graph graph = g;
        for(int i = 0; i < graph.getNodeCount(); i++){
            if(graph.getNode(i).getDegree() >= 1){//Si tiene un vecino se pinta de negro
                graph.getNode(i).addAttribute("ui.class", "Black");  
            }else{//Si no tiene vecinos se pinta de otro color.
                if(i % 5 == 0){
                    graph.getNode(i).addAttribute("ui.class", "Pink");
                }else if(i % 5 == 1){
                    graph.getNode(i ).addAttribute("ui.class", "Blue");
                }else if(i % 5 == 2){
                    graph.getNode(i ).addAttribute("ui.class", "Green");
                }else if(i % 5 == 3){
                    graph.getNode(i).addAttribute("ui.class", "Orange");
                }else{
                    graph.getNode(i).addAttribute("ui.class", "Red");
                }
            } 
        }
     
        String css = " node.Black{fill-color:black;}  node.Pink{fill-color:pink;}  node.Blue{fill-color:blue;} " 
                    + " node.Green{fill-color:green;}  node.Orange{fill-color:orange;} node.Red{fill-color:red;}";
        graph.addAttribute("ui.stylesheet", css);
        graph.display();
    }
    
    /**
     * Metodo principal. Se genera una grafica de 120 nodos.
     */
    public static void main( String[] args ){
        Neighbors nbs = new Neighbors();
        nbs.painterGraph(nbs.generatesGraph(120));
    }

}
