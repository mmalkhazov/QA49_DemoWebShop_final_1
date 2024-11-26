package com.demowebshop.utils;

import com.demowebshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {


    @DataProvider
    public Iterator<Object[]> addNewUser(){

        List<Object[]> list =new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int generatedNum = (int) ((System.currentTimeMillis() / 1000 + i) % 3600);
            list.add(new Object[]{"Maynard", "Keenan", "maynard0000" + generatedNum + "@gmail.com", "Maynard@gmail1234", "Maynard@gmail1234"});
        }

//        list.add(new Object[]{"Maynard", "Keenan", "maynard0000" + i + "@gmail.com", "Maynard@gmail1234", "Maynard@gmail1234"});
//        list.add(new Object[]{"Maynard", "Keenan", "maynard0000" + i + "@gmail.com","Maynard@gmail1234", "Maynard@gmail1234"});
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> addNewUserWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));
        String line=reader.readLine();

//        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
//        String generatedEmail ="maynard0000" + i + "@gmail.com";

        while(line !=null){
            String[] split= line.split(",");
            list.add(new Object[]{new User()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPassword(split[4])
            });
            line = reader.readLine();
        }
        return list.iterator();
    }

}
