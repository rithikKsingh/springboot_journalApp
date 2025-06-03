package com.project.journalApp.service;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    //whole one function is considered one test case
    @Disabled// to disable a function ,so it doesn't get tested
    @Test
    public void testFindByUserName(){

        assertEquals(4,2+2);
        assertNotNull(userRepository.findByUserName("Rithik7"));

        User user=userRepository.findByUserName("Rithik6");
        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
//    @CsvSource({
//            "Rithik6",
//            "Rithik7",
//            "Ram"
//    })
    @ValueSource(strings={
            "Rithik6",
            "Rithik7",
            "Ram"
    })
    public void testFindByUserName2nd(String name){
        assertNotNull(userRepository.findByUserName(name),"failed for "+name);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
//            "3,3,9"
    })
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);
    }

}

//there are other annotations like:
//@BeforeAll , @BeforeEach, @AfterAll, AfterEach