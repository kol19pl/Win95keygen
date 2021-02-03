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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {
    private AdView adView;
    private FrameLayout adContainerView;
    private static final String AD_UNIT_ID = "ca-app-pub-4834003578511022/9181878928";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adContainerView = findViewById(R.id.AdmbFrame);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(AD_UNIT_ID);
        adContainerView.addView(adView);
        loadBanner();


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










    private void loadBanner() {
        // Create an ad request. Check your logcat output for the hashed device ID
        // to get test ads on a physical device, e.g.,
        // "Use AdRequest.Builder.addTestDevice("ABCDE0123") to get test ads on this
        // device."
        AdRequest adRequest =
                new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();

        AdSize adSize = getAdSize();
        // Step 4 - Set the adaptive ad size on the ad view.
        adView.setAdSize(adSize);


        // Step 5 - Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }


}