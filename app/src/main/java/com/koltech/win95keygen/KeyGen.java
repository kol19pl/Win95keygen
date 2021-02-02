package com.koltech.win95keygen;

import android.view.View;

import java.util.Random;

public class KeyGen {



    public String GenerujTrujkę(){
        int trujka;

        int min = 1;
        int max = 998;
        Random r = new Random();
        trujka = r.nextInt(max-min+1)+min;
        if (trujka==333||trujka==444||trujka==555||trujka==666||trujka==777||trujka==888||trujka==999){
           trujka = r.nextInt(max-min+1)+min;    //kalkulacja
        }

        String trujkaS= String.valueOf(trujka);


        int sumix = trujkaS.length();
        while (sumix < 3)
        {
            trujkaS=trujkaS+"0";
            sumix = trujkaS.length();
        }

        return trujkaS;
    }



    public String GenerujSiedem(){
        int jeden   =0;
        int dwa    = 0;
        int trzy   = 0;
        int cztery = 0;
        int pięć   = 0;
        int sześć  = 0;
        int siedem = 0;



        int suma =4;

        while ((suma%7)!=0) {

           dwa = GenSiedem();
           trzy = GenSiedem();
           cztery = GenSiedem();
           pięć = GenSiedem();
           sześć = GenSiedem();
           siedem = GenSiedem();

           suma = jeden+dwa+trzy+cztery+pięć+sześć+siedem;
        }

        String jedenS = String.valueOf(jeden);
        String dwaS = String.valueOf(dwa);
        String trzyS = String.valueOf(trzy);
        String czteryS = String.valueOf(cztery);
        String pięćS = String.valueOf(pięć);
        String sześćS = String.valueOf(sześć);
        String siedemS = String.valueOf(siedem);
        String siedemex = jedenS+dwaS+trzyS+czteryS+pięćS+sześćS+siedemS;

        return siedemex;
    }

    public void Sprawćsiedem(int suma,String siedem){
        if((suma%4)==0){
       //   siudemka = siedem;
        }
        else {
            GenerujSiedem();
        }
    }

    public int GenSiedem(){
       int num = 0;
        Random r = new Random();
        num = r.nextInt(9-0+1)+0;
      return num;
    }

    public String Gendzień(){
        int dzień;
        Random r = new Random();
        dzień = r.nextInt(366-1)+1;

        String dzieńS = String.valueOf(dzień);
        int sumix = dzieńS.length();

        while (sumix < 3)
        {
            dzieńS="0"+dzieńS;
            sumix = dzieńS.length();
        }

        return dzieńS;
    }

    public String Genrok(){
        int rok;
        String rokS;
        Random r = new Random();
        int los = r.nextInt(2);
        if (los ==1){
            rok = r.nextInt(2);
            rokS = "0"+ String.valueOf(rok);
        }
        else {
             rok = r.nextInt(99-95)+95;
             rokS = String.valueOf(rok);

        }

        return rokS;
    }


    public String GenPienc(){
        Random r = new Random();
        int koncowepięć = r.nextInt(99999);
        String koncowepięćS = String.valueOf(koncowepięć);
        int sumix = koncowepięćS.length();
        while (sumix < 5)
        {
            koncowepięćS="0"+koncowepięćS;
            sumix = koncowepięćS.length();
        }
        return koncowepięćS;
    }


}
