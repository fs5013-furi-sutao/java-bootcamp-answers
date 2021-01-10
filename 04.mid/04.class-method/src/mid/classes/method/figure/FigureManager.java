package mid.classes.method.figure;

public class FigureManager {
    
    public static void main(String[] args) {
        
        double triangleWidth = 10;
        double triangleHeiht = 20;
        double triangleArea = Figure.calcTriangleArea(
                triangleWidth, triangleHeiht
            );

        System.out.printf(
            "底辺が %.1f cm で、高さが %.1f cm の三角形の面積 => %.1f %n",
            triangleWidth, 
            triangleHeiht,
            triangleArea
        );
    }
}
