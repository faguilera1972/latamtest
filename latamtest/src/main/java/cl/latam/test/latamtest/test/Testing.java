package cl.latam.test.latamtest.test;

import cl.latam.test.latamtest.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Testing {

    public static void main(String args[]){


        String inputString1 = "25-02-2020";
        String inputString2 = "17-04-1972";

        String cumple = DateUtils.obtenerCumpleanio(inputString2);

        System.out.println("Cumple :"+cumple);

    }
}
