package edu.mum.cs544;

public class InventoryService implements IInventoryService {
    public InventoryService(){}

    @Override
    public int getNumberInstock(int productNumber) {
        return productNumber - 200;
    }
}
