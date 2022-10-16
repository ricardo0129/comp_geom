import java.io.*;
import java.util.*;

/*
 * merge sort optimization inspired by https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pearson/05DivideAndConquer.pdf
 */

public class Algorithms{
  static Point[] temp;
  static Point[] closest = new Point[2];
  static double best = Double.MAX_VALUE;
  public static void merge(Point[] points, int l, int r){
    Point[] merged = new Point[r-l+1];
    int m=(l+r)/2,i=l, j = m+1, s=0;
    while(i<=m && j<=r)
      merged[s++] = (points[i].getY()<points[j].getY())?points[i++]:points[j++];
    while(i<=m) merged[s++] = points[i++];
    while(j<=r) merged[s++] = points[j++];
    for(int k=l;k<=r;k++) points[k] = merged[k-l];
  }
  public static void update(int i, int j, Point[] points){
    if(points[i].distance(points[j])>=best) return;
    best = points[i].distance(points[j]);
    closest[0] = points[i]; closest[1] = points[j];
  }
  public static double solve(Point[] points, int l, int r){
    if(l>=r) return Double.MAX_VALUE;
    if(r-l==1){
      merge(points,l,r);
      update(l,l+1,points);
      return points[l].distance(points[l+1]);
    }
    int m = (l+r)/2;
    Point middle = points[m];
    //divide half of plane by x coordinates 
    double l_ans = solve(points,l,m);
    double r_ans = solve(points,m+1,r);
    double delta = Math.min(l_ans,r_ans);
    double ans = delta;
    int n1 = 0, n2=0;
    for(int i=l;i<=m;i++) if((middle.getX()-points[i].getX())<delta){
      temp[l+n1++] = points[i];
    } 
    for(int i=m+1;i<=r;i++) if((points[i].getX()-middle.getX())<delta){
      temp[m+1+n2++] = points[i];
    } 
    int j = m+1;
    //conquer using two pointers 
    for(int i=l;i<l+n1;i++){
      while(j<(m+1+n2) && temp[j].getY()<=(temp[i].getY()-delta)) j++;
      for(int k=j;k<(m+1+n2) && temp[k].getY()<(temp[i].getY()+delta);k++){
        ans = Math.min(ans,temp[i].distance(temp[k]));
        update(i,k,points);
      }
    }
    merge(points,l,r);
    return ans;
  }
  static void closestPair(Point[] P, int[] A){
    temp = new Point[P.length];
    Arrays.sort(P,(Point a, Point b) -> (int)Math.ceil(a.getX()-b.getX()) );  
    solve(P,0,P.length-1);
    for(int i=0;i<P.length;i++){
      if(closest[0]==P[i]) A[0] = i;
      if(closest[1]==P[i]) A[1] = i;
    }
  }
}
