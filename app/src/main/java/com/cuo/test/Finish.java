package com.cuo.test;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.cuo.test.Test.i;
import static com.cuo.test.Test.nBed;
import static com.cuo.test.Test.nGood;

public class Finish extends AppCompatActivity {
    static boolean t  = false;
    static Finish getThis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.finish );
        TextView t = findViewById ( R.id.pr );
        t.setText ( ""+(nGood*100/(nGood+ nBed))+"%" );
        TextView t1 = findViewById ( R.id.rezult );
        t1.setText (""+ nGood+" из "+(nGood + nBed));
        Start.getThis.save ( nGood,nBed,i );


    }
    public void onBackPressed() {
        Toast.makeText ( this,"Не разрешенно",Toast.LENGTH_LONG ).show ();
    }
    public void confirmFireMissiles(View v) {
        getThis = this;
        DialogFragment newFragment = new Dialog ();
        newFragment.show(getSupportFragmentManager(), "missiles");

    }
    public void onDismiss (){
        if(t){
            t = false;
            Start.getThis.save ( 0,0,0 );
            Test.i = 0;
            Test.ti = 0;
            Test.nGood = 0;
            Test.nBed = 0;
            startActivity ( new Intent(this,Test.class) );
        }
        else {
            Toast.makeText ( this,"Не верный пороль!",Toast.LENGTH_LONG ).show ();
            confirmFireMissiles ( findViewById ( R.id.button ) );
        }
    }

}

