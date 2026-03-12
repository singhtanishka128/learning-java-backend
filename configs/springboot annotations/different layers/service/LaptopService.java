package com.kenny.app.service;

import com.kenny.app.repo.LaptopRepository;
import com.kenny.app.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap){
        repo.save(lap);
    }

    public boolean isGoodForProgramming(Laptop lap){
        return true;
    }
}
