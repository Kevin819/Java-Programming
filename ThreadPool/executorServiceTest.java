package threadPool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class executorServiceTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});
		try {
			// String result = executorService.invokeAny(callables);
			List<Future<String>> result = executorService.invokeAll(callables);
			System.out.println(
					"result = " + result.get(0).get() + ", " + result.get(1).get() + ", " + result.get(2).get());

			test_submitRunnable(executorService);
		} catch (Exception ex) {
		}
		executorService.shutdown();

	}

	private static void test_submitRunnable(ExecutorService executorService) throws Exception {
		Future<?> future = executorService.submit(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});
		// 如果任务结束执行则返回 null
		System.out.println("future.get()=" + future.get());
	}
}
