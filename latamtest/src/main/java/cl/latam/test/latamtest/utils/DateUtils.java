package cl.latam.test.latamtest.utils;

import cl.latam.test.latamtest.constantes.Constantes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static int cantidadDias(String fechaInicio, String fechaFin){

        SimpleDateFormat myFormat = new SimpleDateFormat(Constantes.DD_MM_YYYY);

        try {
            Date date1 = myFormat.parse(fechaInicio);
            Date date2 = myFormat.parse(fechaFin);
            long diff = date2.getTime() - date1.getTime();
            int dias = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            return dias;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getNumeroAnios(String strDate1, String strDate2) {
        int anios = 0;

        Date fecha1, fecha2 = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat(Constantes.DD_MM_YYYY);
        SimpleDateFormat sdf2 = new SimpleDateFormat(Constantes.DD_MM_YYYY);
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

        try {
            fecha1 = (Date)sdf1.parse(strDate1);
            fecha2 = (Date)sdf2.parse(strDate2);

            int anio1 = Integer.parseInt(sdfYear.format(fecha1));
            int anio2 = Integer.parseInt(sdfYear.format(fecha2));

            anios = anio2 - anio1;
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }

        return anios;
    }


    public static String dateToString(Date fecha, String pattern){

        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        String fechaSalida = sf.format(fecha);

        return fechaSalida;
    }


    public static String obtenerCumpleanio(String fechaNac){

        String fechaNacArr[] = fechaNac.split("-");
        String anioNac = fechaNacArr[2];

        String anioActual = dateToString(new Date(), "yyyy");

        fechaNac = fechaNac.replace(anioNac,anioActual);

        return fechaNac;

    }




}
