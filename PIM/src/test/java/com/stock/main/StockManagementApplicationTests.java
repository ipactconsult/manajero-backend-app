package com.stock.main;

import com.stock.main.business.businessimpl.CategoryBusiness;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockManagementApplicationTests {

    @Autowired
    CategoryBusiness categoryBusiness;
    
    @Test
    public void getAllCategories() {
        categoryBusiness.getAllCategories();
    }

}
