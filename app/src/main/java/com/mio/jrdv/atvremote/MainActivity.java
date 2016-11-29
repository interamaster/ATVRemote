package com.mio.jrdv.atvremote;

import android.content.pm.PackageManager;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ConsumerIrManager mCIR ;
    private SparseArray<String> irData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializae:

           mCIR = (ConsumerIrManager)getSystemService(CONSUMER_IR_SERVICE);

        Log.e("INFO","mCIR.hasIrEmitter(): " + mCIR.hasIrEmitter());
        PackageManager pm = getPackageManager();
        Log.e("INFO","pm.hasSystemFeature(PackageManager.FEATURE_CONSUMER_IR): " +
                pm.hasSystemFeature(PackageManager.FEATURE_CONSUMER_IR));


        //rellenamos los valores de cada button

        irData = new SparseArray<String>();
        irData.put(
                R.id.buttonDown,
                count2duration(hex2dec("0000 006D 0022 0002 0156 00AC 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0016 0016")));


        irData.put(
                R.id.buttonUp,
                count2duration(hex2dec("0000 006E 0022 0002 0155 00AC 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0016 0016")));


        irData.put(
                R.id.buttonRight,
                count2duration(hex2dec("0000 006E 0022 0002 0155 00AC 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0016 0016")));

        irData.put(
                R.id.buttonLeft,
                count2duration(hex2dec("0000 006E 0022 0002 0155 00AC 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0016 0016 0016 0016 0016 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0016 0016")));

        irData.put(
                R.id.buttonMenu,
                count2duration(hex2dec("0000 006E 0022 0002 0155 00AC 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0016 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0016 0016")));


        irData.put(
                R.id.buttonSelect,
                count2duration(hex2dec("0000 006F 0022 0014 0155 00AC 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0016 0016 0016 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0016 0016 0060 0016 0060 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 0590 0155 0056 0016 04C4")));

        irData.put(
                R.id.buttonPlay,
                count2duration(hex2dec("0000 006E 0022 0002 0155 00AC 0016 0016 0016 0060 0016 0060 0016 0060 0016 0016 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0016 0016 0016 0016 0060 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0016 0060 0016 0060 0016 0016 0016")));
                       


        //añdimo el longclick listener al select button


        irData.put(
                0,
                count2duration(hex2dec("0000 006D 0000 0044 0157 00AC 0015 0016 0015 0041 0015 0041 0015 0041 0015 0016 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0016 0015 0016 0015 0016 0015 0016 0015 0041 0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 0016 0015 0041 0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40" )));



        /*
              0016 0015 0041 0015 0041 0015 0041 0015 0016 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0016 0015 0016 0015 0016 0015 0016 0015 0041 0015 0041 0015 0016 0015 0041 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0689

         0000 006D 0000 0044//freq ..ignore
         0157 00AC//lead in
         0015 0016 0015 0041 0015 0041 0015 0041 0015 0016 0015 0041 0015 0041 0015 0041
         0015 0041 0015 0041 0015 0041 0015 0016 0015 0016 0015 0016 0015 0016 0015 0041
         0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 0016 0015 0041 0015 0016
         0015 0016 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041
         0015//lead out
         0689//deberia ser 05F0..LO QUE FALTA A 108 ms (108-67.5)=40ms ..>38000*.0.04= 1520 -->05F0

         se repite

         0157 0055//lead in pero con off de 2.25ms en vez de 4.5 ms (=85.5 -->55
         0015//lead out
         0E40    //hasta 110ms en off  (110-11.8125 ms=96,12 -->3648 -->0E40

         y de nuevo:

         0157 0055//lead in pero con off de 2.25ms en vez de 4.5 ms (=85.5 -->
         0015//lead out
         0E40    //hasta 110ms en off  (110-11.8125 ms=96,12 -->3648 -->0E40
         ..
         y asi hasta que se suelte
         //de moento simulo que se deja pulsado 10 ciclos...



         */

        Button selectButton=(Button)findViewById(R.id.buttonSelect);

        selectButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                Log.d("INFO", "pulsado longclick");


                String data = irData.get(0);
                if (data != null) {

                    Log.d("INFO", "pulsado longclick2");

                    //del string sacamos un array de int:

                    String[] numberStrs = data.split(",");
                    int[] numbers = new int[numberStrs.length];
                    for (int i = 0; i < numberStrs.length; i++) {
                        // Note that this is assuming valid input
                        // If you want to check then add a try/catch
                        // and another index for the numbers if to continue adding the others
                        numbers[i] = Integer.parseInt(numberStrs[i]);
                    }


                    mCIR.transmit(38028, numbers);

                }

                    return false;
            }
        });



    }


    protected String hex2dec(String irData) {
        List<String> list = new ArrayList<String>(Arrays.asList(irData
                .split(" ")));
        list.remove(0); // dummy
        int frequency = Integer.parseInt(list.remove(0), 16); // frequency
        list.remove(0); // seq1
        list.remove(0); // seq2

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)));
        }

        frequency = (int) (1000000 / (frequency * 0.241246));
        list.add(0, Integer.toString(frequency));

        irData = "";
        for (String s : list) {
            irData += s + ",";
        }
        return irData;
    }


    protected String count2duration(String countPattern) {
        List<String> list = new ArrayList<String>(Arrays.asList(countPattern.split(",")));
        int frequency = Integer.parseInt(list.get(0));
        int pulses = 1000000/frequency;
        int count;
        int duration;

        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            count = Integer.parseInt(list.get(i));
            duration = count * pulses;
            list.set(i, Integer.toString(duration));
        }

        String durationPattern = "";
        for (String s : list) {
            durationPattern += s + ",";
        }

        Log.d("INFO", "Frequency: " + frequency);
        Log.d("INFO", "Duration Pattern: " + durationPattern);

        return durationPattern;
    }


    public void MenuButton(View view) {

        String data = irData.get(view.getId());
        if (data != null) {

            Log.d("INFO", "pulsado MENU");

            //del string sacamos un array de int:

            String[] numberStrs = data.split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                // Note that this is assuming valid input
                // If you want to check then add a try/catch
                // and another index for the numbers if to continue adding the others
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }




            mCIR.transmit(38028,numbers);




        }

    }

    public void downButton(View view) {

        String data = irData.get(view.getId());
        if (data != null) {

            Log.d("INFO", "pulsado abajo");

            //del string sacamos un array de int:

            String[] numberStrs = data.split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                // Note that this is assuming valid input
                // If you want to check then add a try/catch
                // and another index for the numbers if to continue adding the others
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }




            mCIR.transmit(38028,numbers);

        }

    }


    public void upbutton(View view) {


        String data = irData.get(view.getId());
        if (data != null) {

            Log.d("INFO", "pulsado arriba");

            //del string sacamos un array de int:

            String[] numberStrs = data.split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                // Note that this is assuming valid input
                // If you want to check then add a try/catch
                // and another index for the numbers if to continue adding the others
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }




            mCIR.transmit(38028,numbers);
        }
    }


    public void leftbutton(View view) {


        String data = irData.get(view.getId());
        if (data != null) {

            Log.d("INFO", "pulsado left");

            //del string sacamos un array de int:

            String[] numberStrs = data.split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                // Note that this is assuming valid input
                // If you want to check then add a try/catch
                // and another index for the numbers if to continue adding the others
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }




            mCIR.transmit(38028,numbers);
        }
    }

    public void RightButton(View view) {

        String data = irData.get(view.getId());
        if (data != null) {

            Log.d("INFO", "pulsado derecha");

            //del string sacamos un array de int:

            String[] numberStrs = data.split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                // Note that this is assuming valid input
                // If you want to check then add a try/catch
                // and another index for the numbers if to continue adding the others
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }




            mCIR.transmit(38028,numbers);
        }
    }

    public void SelectButton(View view) {

        String data = irData.get(view.getId());
        if (data != null) {

            Log.d("INFO", "pulsado select");

            //del string sacamos un array de int:

            String[] numberStrs = data.split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                // Note that this is assuming valid input
                // If you want to check then add a try/catch
                // and another index for the numbers if to continue adding the others
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }




            mCIR.transmit(38028,numbers);
        }
    }

    public void PlayButton(View view) {


        String data = irData.get(view.getId());
        if (data != null) {

            Log.d("INFO", "pulsado play");

            //del string sacamos un array de int:

            String[] numberStrs = data.split(",");
            int[] numbers = new int[numberStrs.length];
            for(int i = 0;i < numberStrs.length;i++)
            {
                // Note that this is assuming valid input
                // If you want to check then add a try/catch
                // and another index for the numbers if to continue adding the others
                numbers[i] = Integer.parseInt(numberStrs[i]);
            }




            mCIR.transmit(38028,numbers);
        }
    }
}
