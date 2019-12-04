package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService implements IBookService {
	@Autowired
	public List<IBookSupplier> suppliers = new ArrayList<IBookSupplier>();


	public BookService() {
/*
		IBookSupplier amazon = new Amazon();
		IBookSupplier barnesandnoble = new BarnesAndNoble();
		IBookSupplier ebooks = new EBooks();
		IBookSupplier borders = new Borders();

		suppliers.add(amazon);
		suppliers.add(barnesandnoble);
		suppliers.add(ebooks);
		suppliers.add(borders);
*/
	}//end_bookservice

	public void buy(Book book) {
		System.out.println("Title: " + book.getTitle());
		double lowestPrice = 0;
		IBookSupplier cheapestSupplier = null;
		// find the cheapest supplier
		for (IBookSupplier supplier : suppliers) {
			double price = supplier.computePrice(book.getIsbn());
			if (cheapestSupplier == null) {
				cheapestSupplier = supplier;
				lowestPrice = price;
			} else {
				if (price < lowestPrice) {
					cheapestSupplier = supplier;
					lowestPrice = price;
				}
			}
		}
		// buy with the cheapest supplier
		if (cheapestSupplier != null) {
			cheapestSupplier.order(book);
		}

	}//end_buy
}