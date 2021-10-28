package threads;

import java.util.concurrent.Callable;

public class mn implements Callable<Integer> {

	
		// TODO Auto-generated method stub
	

	private synchronized void test1(int count) {
		System.out.println(Thread.currentThread().getName() + "  " + (count++));

	}

	@Override
	public Integer call() throws Exception {
		int count = 0;

		for (int i = 0; i < 100; i++) {
			/*
			 * try { Thread.sleep(500); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			// System.out.println(Thread.currentThread().getName()+" "+(count++));
			test1(count);

		}
		return count;

	}
	}


