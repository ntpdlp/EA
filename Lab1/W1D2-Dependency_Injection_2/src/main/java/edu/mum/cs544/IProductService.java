package edu.mum.cs544;

public interface IProductService {
	public Product getProduct(int productNumber);
	public int getNumberInstock(int productNumber);
}
