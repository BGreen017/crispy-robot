public class Thread3 {
	public int[][] readThreads(UAV[] urls) {
		MyThread3[] ap = new MyThread3[urls.length];
		for (int i = 0; i < urls.length; i++) {
			ap[i] = new MyThread3(urls[i]);
			ap[i].start();
		}
		for (int j = 0; j < ap.length; j++) {
			try {
				ap[j].join();
			} catch (InterruptedException e) {
			}
		}
		/*
		int[] a = new int[100];
		for(int j = 0; j < 100; j++){
			a[j] = 2*j;
		}
		int[] b = new int[100];
		for(int j = 0; j < 100; j++){
			b[j] = j*j;
		}*/
		
		int[] a = MyThread3.getValueZ();
		int[] b = MyThread3.getValueY();
		
		int[][] c = new int[2][100];
		c[0] = a;
		c[1] = b;
		return c;
		

	}
}
