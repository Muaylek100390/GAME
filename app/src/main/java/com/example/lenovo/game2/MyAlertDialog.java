package com.example.lenovo.game2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyAlertDialog {

    private AlertDialog.Builder objAlert;

    public void NoChooseEveryThing (Context context){
        objAlert = new AlertDialog.Builder(context);
        objAlert.setIcon(R.drawable.warning);
        objAlert.setTitle("Please Choose Answer ?");
        objAlert.setMessage("Please Choose Answer on Radiobutton");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objAlert.show();

    }
}
