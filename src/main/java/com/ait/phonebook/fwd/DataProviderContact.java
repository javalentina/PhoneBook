package com.ait.phonebook.fwd;

import com.ait.phonebook.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> addContactWithData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Lisa", "Wolf", "98743289871", "lis@lis.de", "Alufeira", "Sing Alone"});
        list.add(new Object[]{"Lesha", "Welf", "3453589871", "lesha@lis.de", "Silves", "Sing together"});
        list.add(new Object[]{"Nina", "Wilf", "34534567589871", "nina@lis.de", "Faro", "Sing no"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setSurName(split[1]).setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
