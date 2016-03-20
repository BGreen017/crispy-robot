import java.util.Arrays;


public class MyThread extends Thread{
	public int[][] grid;
	public int id;
	public int z;
	public int y;
	public int goalz;
	public int goaly;
	public int gridz;
	public int gridy;
	public MyThread(UAV uav,int[][] grid, int goalz, int goaly){
        this.id = uav.id;
        this.z = uav.z;
        this.y = uav.y;
        this.grid = grid;
        this.gridz = grid.length;
        this.gridy = grid[0].length;
        this.goalz = goalz;
        this.goaly = goaly;
    }
    @Override
    public void run(){    	
    	if(grid[goalz][goaly] == 100){
    		System.out.println("Fail");
    	}else{
    		System.out.println("Success!");
    	}
    }
}
