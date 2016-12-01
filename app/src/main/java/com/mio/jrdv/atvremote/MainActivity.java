package com.mio.jrdv.atvremote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.ConsumerIrManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    ConsumerIrManager mCIR ;
    private SparseArray<String> irData;

    //para el sonido del CODIGO
    private MediaPlayer mp;


    //para el long press
    boolean longpressed=false;

    //apar cambiar imagen fondo

    ImageView imagenfondo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_old_remote);

        //initializae:

        mCIR = (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);

        Log.e("INFO", "mCIR.hasIrEmitter(): " + mCIR.hasIrEmitter());
        PackageManager pm = getPackageManager();
        Log.e("INFO", "pm.hasSystemFeature(PackageManager.FEATURE_CONSUMER_IR): " +
                pm.hasSystemFeature(PackageManager.FEATURE_CONSUMER_IR));


        //INITILIZE DE LA IMAGEN PARA DETCET BUTTONS

          imagenfondo = (ImageView) findViewById(R.id.imageoldmando);
        if (imagenfondo != null) {
            imagenfondo.setOnTouchListener(this);
        }

        //initializa el sonido
        int sonidomp3 = getResourceID("click", "raw", getApplicationContext());
        mp = MediaPlayer.create(MainActivity.this, sonidomp3);

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
                count2duration(hex2dec("0000 006D 0000 0044 0157 00AC 0015 0016 0015 0041 0015 0041 0015 0041 0015 0016 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0016 0015 0016 0015 0016 0015 0016 0015 0041 0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 0016 0015 0041 0015 0016 0015 0016 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0041 0015 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40 0157 0055 0015 0E40")));



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
         //de moento simulo que se deja pulsado 10 ciclos...pero no funciona..



         */


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////LONG TOUCH..PTE//////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       /* Button selectButton=(Button)findViewById(R.id.buttonSelect);

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

*/


    }


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////// ///////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Put this into the class
    final Handler handler = new Handler();
    Runnable mLongPressed = new Runnable() {
        public void run() {
            longpressed = true;
            //TODO Code for long click
            Log.d("INFO","iniciado longpress!!");

        }
    };


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////touch listener///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean onTouch(View v, MotionEvent ev) {


        boolean handledHere = false;

        final int action = ev.getAction();

        final int evX = (int) ev.getX();
        final int evY = (int) ev.getY();
        int nextImage = -1;			// TODO posible usar para efecto irda ?¿?¿resource id of the next image to display

        // If we cannot find the imageView, return.
        ImageView imageView = (ImageView) v.findViewById (R.id.imageoldmando);
        if (imageView == null) return false;

        // When the action is Down, see if we should show the "pressed" image for the default image.
        // We do this when the default image is showing. That condition is detectable by looking at the
        // tag of the view. If it is null or contains the resource number of the default image, display the pressed image.
        Integer tagNum = (Integer) imageView.getTag ();
        int currentResource = (tagNum == null) ? R.drawable.remote_orig_2 : tagNum.intValue ();

        // Now that we know the current resource being displayed we can handle the DOWN and UP events.

        switch (action) {
            case MotionEvent.ACTION_DOWN :






                int touchColor2 = getHotspotColor (R.id.image_areas, evX, evY);

                if (touchColor2!=Color.TRANSPARENT){

                    //solo si no es un pubnto transparent3e suenna y empieza el delay dellong press

                 //SONIDO AL PULSAR:

                    SuenaClick();


                    ColorTool ct = new ColorTool ();
                    int tolerance = 25;

                     if (ct.closeMatch (Color.WHITE, touchColor2, tolerance))//este es el color que detecta en vez del magenta..
                    {
                        //TODO nextImage = R.drawable.p2_ship_default;
                        Log.d("INFO", "Se pulso SELECT/play/pause...iniciado el timer para long press:");
                        //inicio le detecatr long press si es mas de 1 seg es long press
                        handler.postDelayed(mLongPressed, 100);;


                    }
                }




                if (currentResource == R.drawable.remote_orig_2) {
                    //TODO nextImage = R.drawable.p2_ship_pressed;
                    handledHere = true;
       /*
       } else if (currentResource != R.drawable.p2_ship_default) {
         nextImage = R.drawable.p2_ship_default;
         handledHere = true;
       */
                } else handledHere = true;
                break;

            case MotionEvent.ACTION_UP :
                // On the UP, we do the click action.
                // The hidden image (image_areas) has three different hotspots on it.
                // The colors are red, blue, and yellow.
                // Use image_areas to determine which region the user touched.


                int touchColor = getHotspotColor (R.id.image_areas, evX, evY);


                //se anula el longpress a levantar el deo

                handler.removeCallbacks(mLongPressed);

                //code 4 single click:

                //si es transparente lo ignora:

                if (touchColor==Color.TRANSPARENT){
                    return false;
                }

                // Compare the touchColor to the expected values. Switch to a different image, depending on what color was touched.
                // Note that we use a Color Tool object to test whether the observed color is close enough to the real color to
                // count as a match. We do this because colors on the screen do not match the map exactly because of scaling and
                // varying pixel density.
                ColorTool ct = new ColorTool ();
                int tolerance = 25;
                //TODO nextImage = R.drawable.p2_ship_default;

                if (ct.closeMatch (Color.CYAN, touchColor, tolerance)) {
                    //TODO nextImage = R.drawable.p2_ship_alien;
                    Log.d("INFO", "pulsado arriba");

                }
                else if (ct.closeMatch (Color.GREEN, touchColor, tolerance))

                {
                   //TODO  nextImage = R.drawable.p2_ship_powered;
                    Log.d("INFO", "pulsado abajo");

                }
                else if (ct.closeMatch (Color.BLACK, touchColor, tolerance))
                {
                    //TODO nextImage = R.drawable.p2_ship_no_star;
                    Log.d("INFO", "pulsado derecha");
                }
                else if (ct.closeMatch (Color.YELLOW, touchColor, tolerance))
                {
                   //TODO  nextImage = R.drawable.p2_ship_default;

                    Log.d("INFO", "pulsado izqda");
                }

                else if (ct.closeMatch (Color.WHITE, touchColor, tolerance))
                {
                    //TODO nextImage = R.drawable.p2_ship_default;

                    if (!longpressed){
                        //veiamos deun longpressed no ejectuamos el manda la seq de SELECT!!
                        Log.d("INFO", "pulsado play/pause");
                        //lo pnemos de nuevo a false para detectar nuvo longpress
                        longpressed=false;
                    }


                    else {
                        Log.d("INFO", "NO SE PROCEDE A SELECT/PLAY/PAUSE POR VENOR DE LONGPRESS");

                        //pero al sltar de nuevo lo poenos a
                        longpressed=false;
                    }

                }

                else if (ct.closeMatch (Color.argb(1,255,64,255), touchColor, tolerance))//este es el color que detecta en vez del magenta..
                {
                    //TODO nextImage = R.drawable.p2_ship_default;
                    Log.d("INFO", "pulsado menu");
                }


                // If the next image is the same as the last image, go back to the default.
                // toast ("Current image: " + currentResource + " next: " + nextImage);
                if (currentResource == nextImage) {
                    nextImage = R.drawable.remote_orig_2;
                }
                handledHere = true;
                break;

            default:
                handledHere = false;
        } // end switch

        if (handledHere) {

            if (nextImage > 0) {
                imageView.setImageResource (nextImage);
                imageView.setTag (nextImage);
            }
        }
        return handledHere;
    }



    /**
     * Get the color from the hotspot image at point x-y.
     *
     */

    public int getHotspotColor (int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        if (img == null) {
            Log.d ("ImageAreasActivity", "Hot spot image not found");
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
            if (hotspots == null) {
                Log.d ("ImageAreasActivity", "Hot spot bitmap was not created");
                return 0;
            }

            else {
                img.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////CLICK SOUNDS//////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void SuenaClick() {

       // int sonidomp3 = getResourceID("click", "raw", getApplicationContext());
       // mp = MediaPlayer.create(MainActivity.this, sonidomp3);
        //iiciado en oncreate
        mp.start();

        //y de propian vibra:

        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
    }


    protected final static int getResourceID (final String resName, final String resType, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {


            //en vez de una excepcion que lo ponga en el log solo

            Log.e("INFO", "ojo no existe el resource: " + resName);
            return 0;


        } else {
            return ResourceID;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////CONVERTER DE HEX A INT DE INT A STRING//////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////BUTTON DETECT OLD XML///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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


    public void CambioMandoPulsado(View view) {

        imagenfondo.setImageResource(R.drawable.remote_orig_1);

        //lo hacemos animado mejo!!

        final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce); // Use bounce interpolator with amplitude 0.2 and frequency 20
        BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        imagenfondo.startAnimation(myAnim);
    }
}
