package com.backend.lab.vendingmachine;

import com.backend.lab.approvalTesting.domain.VendingMachine;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class VendingMachineTest {

    private VendingMachine machine;

    private VendingMachinePrinter printer;
    private Map<String, Integer> coins;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
        printer = new VendingMachinePrinter(machine);
        coins = new HashMap<String, Integer>(){{
            put("penny", 1);
            put("nickel", 5);
            put("dime", 10);
            put("quarter", 25);
        }};
    }

    @Test
    public void test_accept_coins() {
        // TODO: use the printer and Approvals.verify instead of assertions

        assertEquals("INSERT COIN", machine.display());

        System.out.println(machine.display());
        machine.insertCoin(coins.get("nickel"));

        assertEquals(5, machine.balance().intValue());
        assertArrayEquals(new Integer[]{5}, machine.coins());
        assertEquals("5", machine.display());
    }

    @Test
    public void test_accept_coins_using_printer(){
        machine.insertCoin(coins.get("nickel"));
        Approvals.verify(printer.printEverything());
    }


    @Test
    public void test_return_coins() {
        machine.insertCoin(coins.get("nickel"));
        List<Integer> returns =  machine.returnCoins();

        assertEquals(0, machine.balance().intValue());
        assertEquals(5, returns.get(0).intValue());
    }

    @Test
    public void test_return_coins_using_printer(){
        machine.insertCoin(coins.get("nickel"));
        machine.returnCoins();
        Approvals.verify(printer.printEverything());
    }
}
