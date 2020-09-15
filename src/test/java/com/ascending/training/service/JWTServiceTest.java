package com.ascending.training.service;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ascending.training.ApplicationBootstrap;
import com.ascending.training.model.User;
import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= ApplicationBootstrap.class)
public class JWTServiceTest {
    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserService userService;

//    @Test
//    public void generateTokenTest(){
//        User user = new User();
//        user.setId(1L);
//        user.setName("WendyCheng");
//        String token = jwtService.generateToken(user);
//        //assertion
//        assertNotNull(token);
//        String[] tArray = token.split("\\.");
//        assertEquals(tArray.length,3);
//    }

    @Test
    public void generateTokenTest(){
        User user = userService.getUserByEmail("dwang@training.ascendingdc.com");
        String token = jwtService.generateToken(user);
        //assertion
        assertNotNull(token);
        String[] tArray = token.split("\\.");
        assertEquals(tArray.length, 3);
    }


    @Test
    public void decryptJwtTokenTest(){
        User user = new User();
        user.setId(1L);
        user.setName("WendyCheng");
        String token = jwtService.generateToken(user);
        Claims c = jwtService.decryptJwtToken(token);

        Assert.assertNotNull(c);
        Assert.assertEquals(c.getSubject(),"WendyCheng");
    }

}


