import java.util.Random;

public class MyThread2 extends Thread{
	private static int[][] grid = new int[8][8];
	private int id;
	private int z;
	private int y;
	private static int ballz;
	private static int bally;
	//private int ballzloc;
	//private int ballyloc;
	private int gridz = grid.length;
	private int gridy = grid[0].length;
	private Random rand = new Random(); 
	
	public MyThread2(UAV uav){
        this.id = uav.id;
        this.z = uav.z;
        this.y = uav.y;
        /*
        this.ballzloc = uav.ballz;
        this.ballyloc = uav.bally;*/
        grid[3][3] = 100;
    }

    @Override
    public void run(){
	    	// 5 is arbitrary number selected to test multiple movements
	    	for(int x = 1; x < 6; x++){
	    		//synchronized(grid){
	    		System.out.println("Loop " + x + " On UAV " + id);
	    		for(int a = 0; a < gridy; a++){
	    			for(int b = 0; b < gridz; b++){
	    				if(grid[a][b] == 100){
	    					ballz = a;
	    					bally = b;
	    				}
	    			}
	    		}
	    		System.out.println("UAV " +id+ " Current Balloon Coordinates are Z:" + ballz + "Y:" + bally);
	    		if(z == ballz && y == bally){
	    			System.out.println("Balloon popped. FAIL");
	    			break;
	    		}
	    		while(!((z == ballz-2 || z == ballz+2) && (y == bally-2 || y == bally+2))){
	    			if(z<ballz){
						z = ballz-2;
						System.out.println("UAV "+id+ " moved to left of balloon");
					}else if(z>ballz){
						z = ballz+2;
						System.out.println("UAV "+id+ " moved to right of balloon");
					}else if(z == ballz){
						z = ballz-2;
						System.out.println("UAV "+id+ " moved to left of balloon");
					}
	    			if(y<bally){
						y = bally-2;
						System.out.println("UAV "+id+ " moved to up of balloon");
					}else if(y>bally){
						y = bally+2;
						System.out.println("UAV "+id+ " moved to down of balloon");
					}else if(y == bally){
						y = bally-2;
						System.out.println("UAV "+id+ " moved to up of balloon");
					}
	    		}
	    		System.out.println("UAV "+id+ " Good Spot!");
	    		
	    		System.out.println("Current UAV "+ id + " Coordinates are Z:" + z + "Y:" + y);
				
	    		int n = rand.nextInt(8) + 1;
	    		
	    		switch(n){
	    		case 1: grid[ballz][bally] = 0;
	    			if(bally < gridy -1){
	    				bally++;
	    			}
	    			grid[ballz][bally] = 100;
	    			break;
	    		case 2: grid[ballz][bally] = 0;
	    			if(bally < gridy -1){
	    				bally++;
	    			}
	    			if(ballz < gridz -1){
	    				ballz++;
	    			}
	    			grid[ballz][bally] = 100;
					break;
	    		case 3: grid[ballz][bally] = 0;
	    			if(ballz < gridz -1){
	    				ballz++;
	    			}
	    			grid[ballz][bally] = 100;
					break;
	    		case 4: grid[ballz][bally] = 0;
		    		if(bally > 0){
		    			bally--;
		    		}
		    		if(ballz < gridz -1){
		    			ballz++;
		    		}
		    		grid[ballz][bally] = 100;
					break;
	    		case 5: grid[ballz][bally] = 0;
	    			if(bally > 0){
	    				bally--;
	    			}
	    			grid[ballz][bally] = 100;
					break;
	    		case 6: grid[ballz][bally] = 0;
		    		if(bally > 0){
	    				bally--;
	    			}
		    		if(ballz > 0){
	    				ballz--;
	    			}
		    		grid[ballz][bally] = 100;
		    		break;
	    		case 7: grid[ballz][bally] = 0;
		    		if(ballz > 0){
	    				ballz--;
	    			}
	    			grid[ballz][bally] = 100;
	    			break;
	    		case 8: grid[ballz][bally] = 0;
		    		if(bally < gridy -1){
		    			bally++;
		    		}
	    			if(ballz > 0){
	    				ballz--;
	    			}
		    		grid[ballz][bally] = 100;
		    		break;
	    		}
	    		System.out.println("UAV "+id+ " Direction: " + n);
	    		System.out.println("UAV "+id+ " New Balloon Coordinates are Z:" + ballz + "Y:" + bally);
	    		
	    		System.out.println();
	    		try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	    	}
		//}
    }
}
    

