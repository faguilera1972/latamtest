package cl.latam.test.latamtest.test;

import cl.latam.test.latamtest.utils.DateUtils;

public class Testing {

    public static void main(String args[]){


        String inputString1 = "26-02-2020";
        String inputString2 = "17-01-1972";

        int cumple = DateUtils.getNumeroAnios(inputString2, inputString1);

        System.out.println("Cumple :"+cumple);

    }
}
