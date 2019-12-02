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

		//bean1 from ProductService class
		ProductService ps = ac.getBean("productService", ProductService.class);
        System.out.println("ps :" + ps);

        ProductService ps1 = ac.getBean("productService",ProductService.class);
        System.out.println("ps1 : " + ps1);

		Product p1 = ps.getProduct(423);
		if(p1 != null) {
			System.out.println(p1);
		}
		Product p2 = ps.getProduct(239);
		if(p2 != null){
			System.out.println(p2);
		}

		/*
		//bean2 from InventoryService class
		//InventoryService is = ac.getBean("bean2",InventoryService.class);
		System.out.println("we have " + ps.getNumberInstock(423) + " products with productNumber423 in stock");
		System.out.println("we have " + ps.getNumberInstock(239) + " products with productNumber239 in stock");
*/
	}//end_main
}//end_App
