package com.koltech.win95keygen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    ///aktywacja menu w pasku aktywacji
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    //dodanie lisnerów na pasku
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_exit:
                finish();  ///do zmiany na shut down splash
        }
        return super.onOptionsItemSelected(item);
    }

    // Resources res = getResources();
    // Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.), null);


   public void GenerujKlucz(View v){
       TextView klucz1 = findViewById(R.id.textViewKlucz1);

       KeyGen keyGen = new KeyGen();

       String trzy = keyGen.GenerujTrujkę();
       String siedem = keyGen.GenerujSiedem();


       String EX=trzy+" - "+siedem;
       klucz1.setText(EX);
    }

    public void GenerujKluczOEM(View v){
        TextView klucz1 = findViewById(R.id.textViewOEM1);

        KeyGen keyGen = new KeyGen();

        String dzień = keyGen.Gendzień();
        String rok = keyGen.Genrok();
        String siedem = keyGen.GenerujSiedem();
        String piec = keyGen.GenPienc();


        String EX=dzień+rok+" - OEM - "+siedem+" - "+piec;
        klucz1.setText(EX);

    }

    public void Sprawc(View v){

        EditText Inkey=findViewById(R.id.editTextNumberSigned);
        String key= Inkey.getText().toString();
        SprawcKlucz sprawcKlucz = new SprawcKlucz();
        String Odp = sprawcKlucz.Sprawć(key,this);
        String Key = sprawcKlucz.Key(key);
       // Toast toast= Toast.makeText(this,Odp,Toast.LENGTH_LONG);
       // toast.show();

      //  AlertDialog.Builder builder = new AlertDialog.Builder(this);
      //  builder.setMessage(Odp);
      //  builder.setTitle("R.string.dialog_title");
      //  builder.setPositiveButton("R.string.ok", new DialogInterface.OnClickListener() {
      //      public void onClick(DialogInterface dialog, int id) {
       //       dialog.dismiss();
      //      }
      //  });
     //   AlertDialog dialog = builder.create();
    //    dialog.show();



        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog, viewGroup, false);
        builder.setView(dialogView);
        TextView Tytuł= dialogView.findViewById(R.id.dialogTytul);
        Tytuł.setText(Odp);
        TextView content = dialogView.findViewById(R.id.DialogText);
        content.setText(Key);
        Button ok =dialogView.findViewById(R.id.DialogOK);
        AlertDialog Dialog = builder.create();
        Dialog.show();
        ok.setOnClickListener(  new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Dialog.cancel();
            }
        });

    }


}