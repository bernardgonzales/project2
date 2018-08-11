package edu.sdsu.cs;

import edu.sdsu.cs.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    static Set<IVertex<String>> vertexSet;
    static WDGraph<String, Integer> graph;

    static Map<String, IVertex<String >> vertexMap;
    public static void main(String[] args) {
        //vertexMap = new HashMap<>();
        //vertexSet = new HashSet<>();
        //graph = new WDGraph<>();
        /**
         * Cities, then edges will come in
         */
        /*
        FileReader fileReader = reader("cities.csv");
        BufferedReader cities = new BufferedReader(fileReader);
        fileReader = reader("edges.csv");
        BufferedReader edges = new BufferedReader(fileReader);
        //addVertices(cities);
        addEdges(edges);

        System.out.println(graph);
        System.out.println();
        System.out.println();
        IVertex<String> sanDiego = vertexMap.get("San diego");
        IVertex<String> lemonGrove = vertexMap.get("Lemon grove");
        System.out.println(graph.minimumDistance(sanDiego, lemonGrove));
//        File file = createFile();
        */

        WDGraph<String, Integer> wdGraph = new WDGraph<>();
        IVertex<String> A = new GraphVertex<>("A");
        IVertex<String> B = new GraphVertex<>("B");
        IVertex<String> C = new GraphVertex<>("C");
        IVertex<String> D = new GraphVertex<>("D");
        IVertex<String> E = new GraphVertex<>("E");

        IEdge<Integer> A2B = new WeightedEdge<>(A, B, 6);
        IEdge<Integer> A2D = new WeightedEdge<>(A, D, 1);

        IEdge<Integer> B2A = new WeightedEdge<>(B, A, 6);
        IEdge<Integer> B2D = new WeightedEdge<>(B, D, 2);
        IEdge<Integer> B2E = new WeightedEdge<>(B, E, 2);
        IEdge<Integer> B2C = new WeightedEdge<>(B, C, 5);

        IEdge<Integer> C2B = new WeightedEdge<>(C, B, 5);
        IEdge<Integer> C2E = new WeightedEdge<>(C, E, 5);

        IEdge<Integer> D2A = new WeightedEdge<>(D, A, 1);
        IEdge<Integer> D2B = new WeightedEdge<>(D, B, 2);
        IEdge<Integer> D2E = new WeightedEdge<>(D, E, 1);

        IEdge<Integer> E2D = new WeightedEdge<>(E, D, 1);
        IEdge<Integer> E2B = new WeightedEdge<>(E, B, 2);
        IEdge<Integer> E2C = new WeightedEdge<>(E, C, 5);



        wdGraph.addVertex(A);
        wdGraph.addVertex(B);
        wdGraph.addVertex(C);
        wdGraph.addVertex(D);
        wdGraph.addVertex(E);

        wdGraph.addEdge(A2B);
        wdGraph.addEdge(A2D);

        wdGraph.addEdge(B2A);
        wdGraph.addEdge(B2D);
        wdGraph.addEdge(B2E);
        wdGraph.addEdge(B2C);

        wdGraph.addEdge(C2B);
        wdGraph.addEdge(C2E);

        wdGraph.addEdge(D2A);
        wdGraph.addEdge(D2B);
        wdGraph.addEdge(D2E);

        wdGraph.addEdge(E2D);
        wdGraph.addEdge(E2B);
        wdGraph.addEdge(E2C);


        int test = wdGraph.minimumDistance(A,C);
        System.out.println("min: " + test);
        System.out.println();
        System.out.println();




    }

    private static void addEdges(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                IVertex<String> start = vertexMap.get(arr[0].trim());
                IVertex<String> end = vertexMap.get(arr[1].trim());
                Integer thing = Integer.parseInt(arr[2].trim());
                IEdge<Integer> edge = new WeightedEdge<>(start, end, thing);
                graph.addEdge(edge);
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addVertices(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                IVertex<String> vertex = new GraphVertex<>(line);
                vertexSet.add(vertex);
                vertexMap.put(vertex.getName(), vertex);
                graph.addVertex(vertex);
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static File createFile() {
        try {
            File file = new File("edges.csv");
            file.createNewFile();
            return file;
        }   catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static FileReader reader(String line) {
        try {
            FileReader fileReader = new FileReader(line);
            return fileReader;
        }   catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
