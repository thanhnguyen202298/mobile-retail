package com.ssk.retailshop.utilities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.ssk.retailshop.R;

public class DialogProcess {
    Dialog dialog;
    Context ctx;

    public DialogProcess(Activity activity) {
        dialog = new Dialog(activity);
        ctx = activity;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialogprogress);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setOwnerActivity(activity);
    }

    public Dialog getDialog(){
        return dialog;
    }

    public void setVisible(boolean show) {
        if (show) dialog.show();
        else
            dialog.dismiss();
    }

    public void setVisibleWithContext(boolean show) {
        if (show) dialog.show();
        else {
            Activity myActivity = dialog.getOwnerActivity();
            if (!myActivity.isFinishing() && dialog != null) {
                dialog.dismiss();
            }
        }
    }
}
