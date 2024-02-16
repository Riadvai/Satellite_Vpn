package com.mhr.squad.satellitevpn;

import android.net.Uri;
import com.mhr.squad.satellitevpn.R;
public class Utiles {
    //---Convert drabale Image source to String--//

    public  static String getImageUrl(int resourceId) {

        return  Uri.parse("android resourceId://" + R.class.getPackage().getName() + "/" + resourceId).toString();

    }
}
