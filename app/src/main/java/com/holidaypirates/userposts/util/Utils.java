package com.holidaypirates.userposts.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.WindowManager;

import com.holidaypirates.userposts.R;

/**
 * {@link Utils -- Utility method}
 * @author Sanjay Mallur
 */

public class Utils {
    private static Context context;

    private Utils(Context mContext) {
        Utils.context=mContext;
        // Method to follow java conventions
    }

    public static void showTechnicalErrorDialog(Throwable message) {
        try {
            String errorMessage = message.getMessage();
            String networkError = "java.net.UnknownHostException";
            if (errorMessage.contains(networkError)) {
                errorMessage = context.getString(R.string.connection_lost_erorr_message);
            } else {
                errorMessage = context.getString(R.string.connection_timed_out);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(errorMessage)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                 dialog.dismiss();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } catch (WindowManager.BadTokenException bte) {
            Log.e("Bad Window Exception", Log.getStackTraceString(bte));
        } catch (Exception e) {
            Log.e("Exception", Log.getStackTraceString(e));
        }
    }
}
