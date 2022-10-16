public class Algorithms{
  public static void closestPairOfPoints(Point[] points, int[] indx){
    double mini = Double.MAX_VALUE;
    int n = points.length;
    for(int i=0;i<n;i++){
      for(int j=0;j<i;j++){
        double val = points[i].distance(points[j]);
        if(val<mini){
          mini = val;
          indx[0] = i;
          indx[1] = j;
        }
      }
    }
  }
  int turn(Point p0, Point p1, Point p2){
    double d = (p0.getX()*p1.getY()+p1.getX()*p2.getY()+p2.getX()*p0.getY())
   -(p1.getX()*p0.getY()+p2.getX()*p1.getY()+p0.getX()*p2.getY());
    if(d>0) return 1;
    if(d<0) return -1;
    return 0;
  }
  public static int isPointInSet(Rectangle[] rArray,Point p){
    for(int i=0;i<rArray.length;i++){
      if(rArray[i].isPointInRectangle(p)) return i;
    } 
    return -1;
  }
   

}
