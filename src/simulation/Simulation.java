package simulation;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {

    public static NodeList metadoneesNodes;
    public static NodeList simulationNodes;

    /**
     * Cette classe représente l'application dans son ensemble.
     */
    public static void main(String[] args) {
        Environnement environnement = new Environnement();
        FenetrePrincipale fenetre = new FenetrePrincipale();

        environnement.addPropertyChangeListener(fenetre);
        environnement.execute();
    }
}