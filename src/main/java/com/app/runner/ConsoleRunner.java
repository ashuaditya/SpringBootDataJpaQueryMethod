package com.app.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	public void run(String... args) throws Exception {
		
		repo.getMyData().forEach(System.out::println);
		System.out.println("==================================");
		repo.getCostOnly().forEach(System.out::println);
		System.out.println("==================================");
		//repo.getInfo().forEach(System.out::println);
		List<Object[]> list = repo.getInfo();
		for(Object[] ob : list)
		{
			System.out.println(ob[0]+", "+ob[1]);
		}
		System.out.println("===================================");
		repo.getNewData(12, 3.1).forEach(System.out::println);
		
		System.out.println("===================================");
		repo.getNewDataName(11, 2.1).forEach(System.out::println);
		
	}

}
