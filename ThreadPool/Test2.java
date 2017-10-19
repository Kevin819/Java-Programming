package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
	public static void main(String[] args) {
		ExecutorService execSvc = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			execSvc.execute(myTask);
			// System.out.println("线程池中线程数目：" + execSvc..getPoolSize() +
			// "，队列中等待执行的任务数目：" + executor.getQueue().size()
			// + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		execSvc.shutdown();
	}
}
