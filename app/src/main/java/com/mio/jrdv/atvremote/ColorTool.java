package com.mio.jrdv.atvremote;

import android.graphics.Color;
import android.util.Log;

/**
 * Created by joseramondelgado on 29/11/16.
 */

public class ColorTool {

        /**
         * Return true if the two colors are a pretty good match.
         * To be a good match, all three color values (RGB) must be within the tolerance value given.
         *
         * @param color1 int
         * @param color2 int
         * @param tolerance int - the max difference that is allowed for any of the RGB components
         * @return boolean
         */

        public boolean closeMatch (int color1, int color2, int tolerance) {

            Log.d("INFO","color 1 rojo "+Color.red (color1));
            Log.d("INFO","color  1 verde "+Color.green (color1));
            Log.d("INFO","color 1 blue "+Color.blue (color1));


            Log.d("INFO","color 2 rojo "+Color.red (color2));
            Log.d("INFO","color  2 verde "+Color.green (color2));
            Log.d("INFO","color 2 blue "+Color.blue (color2));


            if ((int) Math.abs (Color.red (color1) - Color.red (color2)) > tolerance ) return false;
            if ((int) Math.abs (Color.green (color1) - Color.green (color2)) > tolerance ) return false;
            if ((int) Math.abs (Color.blue (color1) - Color.blue (color2)) > tolerance ) return false;
            return true;
        } // end match

} // end class