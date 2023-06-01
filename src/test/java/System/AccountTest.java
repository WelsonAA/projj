package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AccountTest {
    LocalDate dt1 = LocalDate.parse("2003-03-24");
    Account a=new Account("welson","123456",2500.0, dt1);
    @Test
    void TestConstructor() {
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        assertEquals("welson",a.getUserName());
        assertEquals("123456",a.getPassword());
        assertEquals("2003-03-24",a.getBirthDate().toString());
    }
    @Test
    void TestDeposit(){

    }

}