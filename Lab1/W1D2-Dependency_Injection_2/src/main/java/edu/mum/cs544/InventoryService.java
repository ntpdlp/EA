package edu.mum.cs544;

import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {
    public InventoryService(){}

    @Override
    public int getNumberInstock(int productNumber) {
        return productNumber - 200;
    }
}
