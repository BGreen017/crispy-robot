public class Thread2 {

	
	public void readThreads(UAV[] urls) {

		MyThread2[] ap = new MyThread2[urls.length];
		for (int i = 0; i < urls.length; i++) {
			ap[i] = new MyThread2(urls[i]);
			ap[i].start();
		}
		for (int j = 0; j < ap.length; j++) {
			try {
				ap[j].join();
			} catch (InterruptedException e) {
			}
		}

	}
}
