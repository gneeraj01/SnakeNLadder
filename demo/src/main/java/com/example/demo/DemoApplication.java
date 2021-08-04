package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@Order(1)
public class DemoApplication  implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("started");

		// Register a user
		//[2,3,5,3,9,2] - 2

		//int[] Array = {2,3,5,3,9,2};
		int Array[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int recJump = minJumps(Array, 0, Array.length-1);

		System.out.println("Min Move : "+recJump);


	}

	int minJumps(int[] arr, int l, int h) {
		

		if(h == l )
			return 0;

		int len = arr.length-1;
		
		 if (arr[l] == 0)
	            return Integer.MAX_VALUE;
		 int min = Integer.MAX_VALUE;
		//int left =0;
		for (int i = l + 1; i <= h
				&& i <= l + arr[l];
				i++) {
			int jumps = minJumps(arr, i, h);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}

		return min;

	}
}
