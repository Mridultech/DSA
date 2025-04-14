public class ShortestPath{

    public static float shortestPath(String path){
        int x = 0, y = 0;
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'n'){
                y++;
            }else if(path.charAt(i) == 's'){
                y--;
            }else if(path.charAt(i) == 'e'){
                x++;
            }else if(path.charAt(i) == 'w'){
                x--;
            }
        }

        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String[] args){
        System.out.println("Program to find shortest path till till end cordinates through given path direction by use of south(s), east(e), west(w), north(n) directions");
        String path = "nnnneeee";
        System.out.println("Shortest Path is : " + shortestPath(path));
    }
}