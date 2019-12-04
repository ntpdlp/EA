package edu.mum.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {

//		//This is old programming style:
//		IProductService productService = new ProductService();
//
//		Product product1 = productService.getProduct(423);
//		if (product1 != null) {
//			System.out.println(product1.toString());
//		}
//		Product product2 = productService.getProduct(239);
//		if (product2 != null) {
//			System.out.println(product2.toString());


		/*Apply the spring style */
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

		//get from ProductService class
		ProductService ps = ac.getBean("productService", ProductService.class);
        System.out.println("ps :" + ps);

		Product p1 = ps.getProduct(423);
		if(p1 != null) {
			System.out.println(p1);
		}
		Product p2 = ps.getProduct(239);
		if(p2 != null){
			System.out.println(p2);
		}

		System.out.println("we have " + ps.getNumberInstock(423)
				+ " product(s) with productNumber 423 in stock");
		System.out.println("we have " + ps.getNumberInstock(239)
				+ " product(s) with productNumber 239 in stock");
	}//end_main
}//end_App
