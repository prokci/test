package com.cuo.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import static com.cuo.test.Finish.t;

public class Dialog extends DialogFragment {

   @NonNull
   public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
       // Use the Builder class for convenient dialog construction
       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       // Get the layout inflater
       LayoutInflater inflater = getActivity().getLayoutInflater();


       // Inflate and set the layout for the dialog
       // Pass null as the parent view because its going in the dialog layout

       final  View v ;
       builder.setView( v=inflater.inflate(R.layout.diolog, null));

               // Add action buttons
           builder
                   .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int id) {
                          EditText et =  v.findViewById(R.id.editText );
                          if(Objects.equals ( "7232", et.getText ().toString () ))
                             t = true;
                          Finish.getThis.onDismiss ();
                      }

                   })
                   .setNegativeButton("Отмена ", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int id) {
                           Dialog.this.getDialog().cancel();
                       }
                   })
                   .setTitle ( "Ведите пороль:" );


       return builder.create();
   }
}
