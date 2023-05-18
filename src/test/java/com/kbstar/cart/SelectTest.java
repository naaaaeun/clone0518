package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectTest {
    @Autowired
    CartService service;

    @Test
    void contextLoads() throws Exception {
        List<Cart> list =null;
        try {
            list = service.getid("id04");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("시스템 장애");
        }
    }
}
