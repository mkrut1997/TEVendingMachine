package com.techelevator;

import com.techelevator.models.MachineBank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MachineBankTest {
    private MachineBank test = new MachineBank();

    @Test
    public void assert_change_is_properly_counted(){
        test.setBalance(new BigDecimal("3.44"));
        String expected = "Your change is: 3 dollar(s), 1 quarter(s), 1 dime(s), 1 nickel(s), 4 pennies";
        Assert.assertEquals(expected, test.getChange());
    }




}
