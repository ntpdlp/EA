package edu.mum.cs544;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductService implements IProductService {
	private Collection<Product> productList = new ArrayList<Product>();
	private IInventoryService inventoryService; //inject

	public ProductService() {
		productList.add(new Product(234, "LCD TV", 895.50));
		productList.add(new Product(239, "DVD player", 315.00));
		productList.add(new Product(423, "Plasma TV", 992.55));
	}

	public Product getProduct(int productNumber) {
		for (Product product : productList) {
			if (product.getProductNumber() == productNumber)
				return product;
		}
		return null;
	}

	@Override
	public int getNumberInstock(int productNumber) {
		return inventoryService.getNumberInstock(productNumber);
	}

}
