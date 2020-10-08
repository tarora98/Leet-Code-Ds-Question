import java.util.ArrayList;

public class BasicGraph{

    public static class Edge{
        int v = 0;
        int w = 0;

        public Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }

    static int N = 7;
    
    @SuppressWarnings("unchecked")
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u,int v,int w){ //Bidirectional 
        graph[u].add(new Edge(v,w)); 
        graph[v].add(new Edge(u,w));
    }

    public static void display(){
        for(int i=0;i<N;i++){
            System.out.print(i + " -> ");
            for(Edge e: graph[i]){
                System.out.print("(" + e.v + ", " + e.w + "), ");
            }

            System.out.println();
        }
    }

    public static int searchVtx(int u,int v){
        for(int i=0;i<graph[u].size();i++){
            Edge e = graph[u].get(i);
            if(e.v == v) return i;
        }

        return -1;
    }

    public static void removeEdge(int u,int v){
        int l1 = searchVtx(u,v);
        graph[u].remove(l1);

        int l2 = searchVtx(v,u);
        graph[v].remove(l2);
    }

    public static void removeVtx(int u){
        for(int i = graph[u].size()-1;i>=0;i--){
            Edge e = graph[u].get(i);
            removeEdge(u,e.v);
        }
    }

    public static boolean hasPath(int src,int dest,boolean[] vis){
        if(src == dest) return true;

        vis[src] = true;
        boolean res = false;
        for(Edge e: graph[src]){
            if(!vis[e.v])
               res = res || hasPath(e.v,dest,vis);
        }

        return res;
    }

    public static int allPath(int src,int dest,boolean[] vis,String psf,int wsf){
        if(src == dest){
            System.out.println(psf + src + "@" + wsf);
            return 1;
        }

        vis[src] = true;
        int count = 0;
        for(Edge e: graph[src]){
            if(!vis[e.v])
            count+=allPath(e.v,dest,vis,psf + src + " ", wsf + e.w);
            
        }
        
        vis[src] = false;
        return count;
    }

    public static class pair{
        String path = "";
        int weight = 0;

        pair(String path,int weight){
            this.path = path;
            this.weight = weight;
        }
    }

    public static pair maxWeightPath(int src,int dest,boolean[] vis){
        if(src==dest){
            return new pair(src + "",0);
        }

        vis[src] = true;
        
        pair myAns = new pair("",0);
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                pair recAns = maxWeightPath(e.v,dest,vis);
                if(recAns.weight + e.w > myAns.weight){
                    myAns.weight = recAns.weight + e.w;
                    myAns.path = src + " " + recAns.path;
                }
            }
        }
        vis[src] = false;
        return myAns;
    }
    public int HamitonainPath(int src,int osrc,boolean[] vis,int edgeCount,String psf){

    }

    public static void constructGraph(){
        for(int i = 0;i<N;i++) 
        	graph[i] = new ArrayList<Edge>();

        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);

        // removeVtx(3);
        display();

        boolean[] vis = new boolean[N];
        // System.out.println(allPath(0,6,vis,"",0));
        pair ans = maxWeightPath(0,6,vis);
        System.out.println(ans.path + " @ " + ans.weight);
    }

    public static void main(String[] args){
        constructGraph();
    }
}