import java.util.List;


public class PrintPath {
	
	static DStarLite pf;

	public PrintPath(DStarLite pf) {
		PrintPath.pf = pf;
	}
	
	public void print(){
		List<State> path = pf.getPath();
		for (State i : path)
		{
			System.out.println("x: " + i.x + " y: " + i.y);
		}
	}
	
	public static int[] getValuesX(){
		List<State> path = pf.getPath();
		int[] a = new int[path.size()];
		int x = 0;
		for (State i : path)
		{
			a[x] = i.x;
			x++;
		}
		return a;
	}
	
	public static int[] getValuesY(){	
		List<State> path = pf.getPath();
		int[] a = new int[path.size()];
		int x = 0;
		for (State i : path)
		{
			a[x] = i.y;
			x++;
		}
		return a;
	}
	
	public int nextStateX(){
		List<State> path = pf.getPath();
		if (path.size() > 1){
			return path.get(0).x;
		}else if(path.isEmpty() != true){
			return path.get(0).x;
		}else{
			return 0;
		}
	}
	
	public int nextStateY(){
		List<State> path = pf.getPath();
		if (path.size() > 1){
			return path.get(1).y;
		}else if(path.isEmpty() != true){
			return path.get(0).y;
		}else{
			return 0;
		}
	}
}
