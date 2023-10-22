package com.backend.lab.vendingmachine;

import com.backend.lab.approvalTesting.domain.VendingMachine;

import java.util.Arrays;
import java.util.HashMap;

public class VendingMachinePrinter {

    private final int columns;
    private final VendingMachine machine;

    public VendingMachinePrinter(VendingMachine machine) {
        this.columns = 60;
        this.machine = machine;
    }

    public String printEverything() {
       return print();
    }

    private String print(){
        StringBuilder text = new StringBuilder();
        text.append("VendingMachine\n");
        // TODO: finish this
        text.append(formatLineWithWhitespace("Display", machine.display()));

        HashMap<String, String> fields = new HashMap<String, String>(){{
            put("Balance", String.valueOf(machine.balance()));
            put("Coins", Arrays.toString(machine.coins()));
            put("Returns", Arrays.toString(machine.returns().toArray()));

        }};

        fields.forEach((name, value) -> text.append(formatLineWithWhitespace(name, value)));

        return text.toString();
    }

    /** Convenience function that lays out a name and a value at either ends of a fixed-width line.
     eg if you call it with name="Foo" value="Bar" it will return
     Foo                                       Bar
     */
    private String formatLineWithWhitespace(String name, String value) {
        int whitespaceSize = columns - name.length() - value.length();
        String whiteSpace = " ".repeat(whitespaceSize);
        return String.format("%s%s%s%n", name, whiteSpace, value);
    }

}
