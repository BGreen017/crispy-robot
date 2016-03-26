//import java.util.Random;

public class MyThread3 extends Thread{
	//private static int[][] grid = new int[8][8];
	private int id;
	private int z;
	private int y;
	private static int ballz;
	private static int bally;
	private static int[] cordz;
	private static int[] cordy;
	//private int gridz = grid.length;
	//private int gridy = grid[0].length;
	//private Random rand = new Random(); 
	
	public MyThread3(UAV uav){
        this.id = uav.id;
        this.z = uav.z;
        this.y = uav.y;
        MyThread3.ballz = uav.ballz;
        MyThread3.bally = uav.bally;
    }

    @Override
    public void run(){
	    	// 5 is arbitrary number selected to test multiple movements
	    	for(int x = 1; x < 2; x++){
	    		//System.out.println("UAV " +id+ " Current Balloon Coordinates are Z:" + ballz + "Y:" + bally);
	    		if(z == ballz && y == bally){
	    			System.out.println("Balloon popped. FAIL");
	    			break;
	    		}
	    		System.out.println("UAV " + id + " On loop" + x);
	    		DStarLite pf = new DStarLite();
	    		pf.init(z,y,ballz,bally);
	    		pf.updateCell(2, 1, -1);
	    		pf.updateCell(2, 0, -1);
	    		pf.updateCell(2, 2, -1);
	    		pf.updateCell(3, 0, -1);
	    		
	    		PrintPath p = new PrintPath(pf);
	    		
	    		/*
	    		System.out.println("Start node: (0,1)");
	    		System.out.println("End node: (3,1)");
				*/
	    		//Time the replanning
	    		//pf.updateStart(z, y);
	    		//pf.replan();
	    		double begin = System.currentTimeMillis();
	    		//pf.updateStart(p.nextStateX(), p.nextStateY());
	    		pf.updateStart(z+x,y+x);
	    		pf.replan();
	    		double end = System.currentTimeMillis();

	    		System.out.println("Time: " + (end-begin) + "ms");
	    		p.print();
	    		
	    		cordz = p.getValuesX();
	    		cordy = p.getValuesY();
	    		

	    		System.out.println();
	    		try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	    	}
		//}
    }
    
    public static int[] getValueZ() {
        return cordz;
    }
    
    public static int[] getValueY() {
        return cordy;
    }

}
    

