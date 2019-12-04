package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
	private Collection<Product> productList = new ArrayList<Product>();
	@Autowired
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
