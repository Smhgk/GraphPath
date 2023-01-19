
package graphpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    Scanner sc;
    int v1[];
    int v2[];
    int w[];
    int visit[];
    public Graph() throws FileNotFoundException{
    v1 = new int[14];
    v2 = new int[14];
    w = new int[14];
    visit = new int[8];
    sc = new Scanner(new File("C:\\Users\\gokse\\OneDrive\\Masaüstü\\graph.txt"));
    int x = 0;
    while(sc.hasNext()){
        v1[x] = sc.nextInt();
        v2[x] = sc.nextInt();
        w[x++] = sc.nextInt();
    }
    for(int i = 0; i< 8; i++){
        visit[i] = 0;
    }
    }
    public void sortEdges(){
        for(int i = 0; i<14;i++){
            for(int j = 0; j<13;j++){
                if(w[j]>w[j+1]){
                    int x = w[j];
                    w[j] = w[j+1];
                    w[j+1] = x;
                    x = v2[j];
                    v2[j] = v2[j+1];
                    v2[j+1] = x;
                    x = v1[j];
                    v1[j] = v1[j+1];
                    v1[j+1] = x;
                }
            }
        }
    }
    public void result(Graph g){
        g.sortEdges();
        int totalWeight = 0;
        for(int j = 0; j<8; j++){
            if(visit[v2[j]] == 0 || visit[v1[j]] == 0){
                System.out.println("Path"+ (j+1) +": "+(char)(v1[j]+65) + " " + (char)(v2[j]+65) + " " + w[j]);
                totalWeight += w[j];
                visit[v2[j]] = 1;
                visit[v1[j]] = 1;
            }
        }
        System.out.println("Total weight: " + totalWeight);
    }
    
    
}
