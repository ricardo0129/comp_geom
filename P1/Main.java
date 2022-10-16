/*
 *  merge sort optimization 
 *  insipired by https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pearson/05DivideAndConquer.pdf
 */
import java.io.*;
import java.util.*;
public class Main extends PrintWriter {
	Main() { super(System.out, true); }
	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		byte[] bb = new byte[1 << 15]; int i, n;
		byte getc() {
			if (i == n) {
				i = n = 0;
				try { n = in.read(bb); } catch (IOException e) {}
			}
			return i < n ? bb[i++] : 0;
		}
		int nextInt() {
			byte c = 0; while (c <= ' ') c = getc();
			boolean minus = c == '-'; if (minus) c = getc();
			int a = 0; while (c > ' ') { a = a * 10 + c - '0'; c = getc(); }
			return minus ? -a : a;
		}
	}
	Scanner in = new Scanner(System.in);
	public static void main(String[] $) {
		Main o = new Main(); o.main(); o.flush();
	}

  public static class Point{
    public int x,y;
    Point (int x, int y){
      this.x = x;
      this.y = y;
    }
    long distance(Point p){
      long a = x-p.x;
      long b = y-p.y;
      return a*a+b*b;
    }
  }
  public static void merge(Point[] points, int l, int r){
    Point[] merged = new Point[r-l+1];
    int m=(l+r)/2,i=l, j = m+1, s=0;
    while(i<=m && j<=r)
      merged[s++] = (points[i].y<points[j].y)?points[i++]:points[j++];
    while(i<=m) merged[s++] = points[i++];
    while(j<=r) merged[s++] = points[j++];
    for(int k=l;k<=r;k++) points[k] = merged[k-l];
  }
  static Point[] temp;
  public static long solve(Point[] points, int l, int r){
    if(l>=r) return 0x7fffffffffffffffL;
    if(r-l==1){
      merge(points,l,r);
      return points[l].distance(points[l+1]);
    }
    int m = (l+r)/2;
    Point middle = points[m];
    long l_ans = solve(points,l,m);
    long r_ans = solve(points,m+1,r);
    long delta = l_ans<=r_ans?l_ans:r_ans;
    long ans = delta;
    delta = (long)Math.ceil(Math.sqrt(delta));
    int n1 = 0, n2=0;
    for(int i=l;i<=m;i++) if((middle.x-points[i].x)<delta){
      temp[l+n1++] = points[i];
    } 
    for(int i=m+1;i<=r;i++) if((points[i].x-middle.x)<delta){
      temp[m+1+n2++] = points[i];
    } 
    int j = m+1;
    for(int i=l;i<l+n1;i++){
      int iters = 0;
      while(j<(m+1+n2) && temp[j].y<=(temp[i].y-delta)) j++;
      for(int k=j;k<(m+1+n2) && temp[k].y<(temp[i].y+delta);k++){
        ans = Math.min(ans,temp[i].distance(temp[k]));
        iters++;
      }
      assert iters<=6: "TOO MANY CHECKS";
    }
    merge(points,l,r);
    return ans;
  }
  void main(){
    int n;
    n = in.nextInt();
    Point[] points = new Point[n];
    temp = new Point[n];

    for(int i=0;i<n;i++){
      points[i] = new Point(in.nextInt(),in.nextInt());
    }
    Arrays.sort(points, (Point a, Point b) -> (a.x-b.x) );
    //for(int i=1;i<n;i++) assert points[i].x>=points[i-1].x:"HERE\n";
    long ans = solve(points,0,n-1);
    System.out.println(ans);
  }
}
