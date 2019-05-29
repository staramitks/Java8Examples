package home.amit.java8.completableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureExample {
	
	public static void main(String... args)
	{
		
		Long startTime=System.currentTimeMillis();
		
		parallelInvocation();
		//serialInvocation();
		Long endTime=System.currentTimeMillis();
		
		System.out.println("Total time is "+(endTime-startTime)/1000);
	}

	private static void parallelInvocation() {
		Map<String,String> result= new HashMap<String,String>();
		
		
		List<Map<String,String>> subResults= new ArrayList<Map<String,String>>();
		CompletableFuture<Map<String,String>> perfMap1=CompletableFuture.supplyAsync(()->getPerformanceMap());
		
		CompletableFuture<Map<String,String>> productMap1=CompletableFuture.supplyAsync(()->getProductsMap());
		CompletableFuture<Map<String,String>> intSlack1=CompletableFuture.supplyAsync(()->getInternalSlackMap());
		CompletableFuture<Map<String,String>> extSlack1=CompletableFuture.supplyAsync(()->getExternalSlackMap());
		CompletableFuture<Map<String,String>> cacheMap1=CompletableFuture.supplyAsync(()->getCacheMap());
		CompletableFuture<Map<String,String>> fileSysMap1=CompletableFuture.supplyAsync(()->getFileSysMap());
		
		CompletableFuture<Map<String,String>> productMap2=CompletableFuture.supplyAsync(()->getProductsMap()).exceptionally(exception->{System.err.print("exception "+exception.getMessage());
		return new HashMap<String,String>();});
		CompletableFuture<Map<String,String>> intSlack2=CompletableFuture.supplyAsync(()->getInternalSlackMap());
		CompletableFuture<Map<String,String>> extSlack2=CompletableFuture.supplyAsync(()->getExternalSlackMap());
		CompletableFuture<Map<String,String>> cacheMap2=CompletableFuture.supplyAsync(()->getCacheMap());
		CompletableFuture<Map<String,String>> fileSysMap2=CompletableFuture.supplyAsync(()->getFileSysMap());
		
		
		CompletableFuture<Integer> completableFuture = CompletableFuture
	              .supplyAsync(() -> {
	                  System.out.println("running task");
	                  return 10 / 0;
	              }).exceptionally(exception -> {
	                  System.err.println("exception: " + exception);
	                  return 1;
	              });
		
		
		CompletableFuture<Void> allResults = CompletableFuture.allOf(perfMap1,productMap1,intSlack1,extSlack1,cacheMap1,fileSysMap1);
		try {
			allResults.get(5, TimeUnit.MINUTES);
		} catch (InterruptedException | ExecutionException | TimeoutException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean completionFlag=allResults.isDone();
		if (completionFlag)
		{
			System.out.println("Completed "+completionFlag);
			
			try {
			subResults.add(perfMap1.get());
			subResults.add(productMap1.get());
			subResults.add(intSlack1.get());
			subResults.add(extSlack1.get());
			subResults.add(cacheMap1.get());
			subResults.add(fileSysMap1.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mergeMapsInResult(result,subResults);
		}

		
	}

	private static void serialInvocation() {

		List<Map<String,String>> subResults= new ArrayList<Map<String,String>>();

		Map<String,String> perfMap= getPerformanceMap();
		
		Map<String,String> productsMap= getProductsMap();
		
		Map<String,String> internalMap= getInternalSlackMap();
		
		Map<String,String> externalMap= getExternalSlackMap();
		
		Map<String,String> cacheMap= getCacheMap();
		
		Map<String,String> fileSysMap= getFileSysMap();
		
		Map<String,String> result= new HashMap<String,String>();
		subResults.add(perfMap);
		subResults.add(productsMap);
		subResults.add(internalMap);
		subResults.add(externalMap);
		subResults.add(cacheMap);
		subResults.add(fileSysMap);
		
		
		mergeMapsInResult(result,subResults);
		
		
	}

	private static void mergeMapsInResult(Map<String, String> result, List<Map<String, String>> subResults) {
		subResults.forEach(val-> val.keySet().forEach(key->result.putIfAbsent(key, val.get(key))));
		System.out.println("Total Keys are "+result.keySet().size() +"count");
		
	}

	private static Map<String, String> getFileSysMap() {
		Map<String, String> subResults = new HashMap<>();
		
		try {
			
			subResults.put("file1key", "file1value");
			subResults.put("file2key", "file2value");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return subResults;
	}

	private static Map<String, String> getCacheMap() {
Map<String, String> subResults = new HashMap<>();
		
		try {
			
			subResults.put("cacheKey1", "cacheKeyVal1");
			subResults.put("cacheKey2", "cacheVal2");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return subResults;
	}

	private static Map<String, String> getExternalSlackMap() {
Map<String, String> subResults = new HashMap<>();
		
		try {
			
			subResults.put("extSlackKey1", "extSlackVal1");
			subResults.put("exSlackKey2", "exSlackVal2");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return subResults;
	}

	private static Map<String, String> getInternalSlackMap() {
		Map<String, String> subResults = new HashMap<>();
		
		try {
			
			subResults.put("intSlackKey1", "IntSlackVal1");
			subResults.put("intSlackKey2", "intSlackVal2");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return subResults;
	}

	private static Map<String, String> getProductsMap() {
		Map<String, String> subResults = new HashMap<>();
		
		try {
			
			subResults.put("producyk1", "prodkeyval1");
			subResults.put("prodkey2", "prodval2");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-nerated catch block
			e.printStackTrace();
		}
		
		
		return subResults;
	}

	private static Map<String, String> getPerformanceMap() {
		Map<String, String> subResults = new HashMap<>();
		
		try {
			
			subResults.put("perfk1", "perfval1");
			subResults.put("perfk2", "perfval2");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return subResults;
	}

	
	private static String getHello()
	{
		return "Hello";
	}
	
	private static String getWorld()
	{
		return "World";
	}
	
	private static String getBakwas()
	{
		return "Kya hai be";
	}
}
