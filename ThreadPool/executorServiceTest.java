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
      // System.out.println("result = " + result);    // result = Task 1 or 2 or 3
			List<Future<String>> result = executorService.invokeAll(callables);
			System.out.println(
					"result = " + result.get(0).get() + ", " + result.get(1).get() + ", " + result.get(2).get());
      // "result = Task 1, Task 3, Task 2" will be printed.
		} catch (Exception ex) {
		}
		executorService.shutdown();
	}
}
