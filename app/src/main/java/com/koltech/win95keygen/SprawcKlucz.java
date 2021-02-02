package com.koltech.win95keygen;

import android.content.Context;
import android.content.res.Resources;


public class SprawcKlucz {



    public String Sprawć(String key, Context context){
        boolean poprawny;
        String EXIT="404";

        Resources res = context.getResources();

        int długość = key.length();

        if (długość<10) {
            poprawny = false;

            EXIT =  res.getString(R.string.Kluczjestzakrutki);
        }
        else if (długość == 10) {
            String trujkaS = key.substring(0,3);
            String siedemSR = key.substring(3);
            int trujka = Integer.valueOf(trujkaS);
            if (trujka==333||trujka==444||trujka==555||trujka==666||trujka==777||trujka==888||trujka==999){
                EXIT=res.getString(R.string.Klucz_bledny);
            }
            else {
                    String jedenS = String.valueOf(siedemSR.charAt(0));
                    String dwaS = String.valueOf(siedemSR.charAt(1));
                    String trzyS = String.valueOf(siedemSR.charAt(2));
                    String czteryS = String.valueOf(siedemSR.charAt(3));
                    String pięćS = String.valueOf(siedemSR.charAt(4));
                    String sześćS = String.valueOf(siedemSR.charAt(5));
                    String siedemS = String.valueOf(siedemSR.charAt(6));


                    int jeden = Integer.valueOf(jedenS);
                    int dwa = Integer.valueOf(dwaS);
                    int trzy = Integer.valueOf(trzyS);
                    int cztery = Integer.valueOf(czteryS);
                    int pięć = Integer.valueOf(pięćS);
                    int sześć = Integer.valueOf(sześćS);
                    int siedem = Integer.valueOf(siedemS);

                int  suma = jeden+dwa+trzy+cztery+pięć+sześć+siedem;
                if (((suma%7)==0)){
                    EXIT=res.getString(R.string.Klucz_Poprawny);
                }
                else {
                    EXIT=res.getString(R.string.Klucz_bledny);
                }

            }
        }

        else if (długość > 10 && długość < 17) {
            EXIT=res.getString(R.string.Klucz_bledny);
        }
        else if (długość == 17) {
            String dzienS = key.substring(0,3);
            int dzien = Integer.valueOf(dzienS);
            if (dzien<=366){
               String rokS = key.substring(3,5);
               int rok =Integer.valueOf(rokS);
               if(rok>=95||rok<=02){

                   String siedemSR = key.substring(5,12);
                   String jedenS = String.valueOf(siedemSR.charAt(0));
                   String dwaS = String.valueOf(siedemSR.charAt(1));
                   String trzyS = String.valueOf(siedemSR.charAt(2));
                   String czteryS = String.valueOf(siedemSR.charAt(3));
                   String pięćS = String.valueOf(siedemSR.charAt(4));
                   String sześćS = String.valueOf(siedemSR.charAt(5));
                   String siedemS = String.valueOf(siedemSR.charAt(6));


                   int jeden = Integer.valueOf(jedenS);
                   int dwa = Integer.valueOf(dwaS);
                   int trzy = Integer.valueOf(trzyS);
                   int cztery = Integer.valueOf(czteryS);
                   int pięć = Integer.valueOf(pięćS);
                   int sześć = Integer.valueOf(sześćS);
                   int siedem = Integer.valueOf(siedemS);

                   int  suma = jeden+dwa+trzy+cztery+pięć+sześć+siedem;
                   if (((suma%7)==0)){
                       EXIT=res.getString(R.string.KluczOEMPoprawny);
                   }
                   else {
                       EXIT=res.getString(R.string.Klucz_bledny);
                   }
               }
               else {
                   EXIT=res.getString(R.string.Klucz_bledny);
               }
           }
            else {
                EXIT=res.getString(R.string.Klucz_bledny);
            }
        }
        else if (długość > 17) {
            EXIT=res.getString(R.string.Kluczjestzadługi);;

        }
        else {
                EXIT = String.valueOf(R.string.Nastompiłnieprzewidzianybłąd);
        }


         return EXIT;
    }


    public String Key(String key) {
        String ret="xxx-xxx-xxx";
        int dlugosc = key.length();
        if(dlugosc==10){
            ret =  key.substring(0,3)+" - " +key.substring(3);
        }
        else if(dlugosc==17){
            ret = key.substring(0,5)+" - OEM - "+key.substring(5,12)+" - "+key.substring(12);
        }
        else {
            ret = key;
        }

        return ret;
    }
}
