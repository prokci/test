package com.cuo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Start extends AppCompatActivity {
     BufferedReader fil;
     static String s[];
     static Start getThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.start );
        try {
            fil = new BufferedReader ( new FileReader ( new File ( "/sdcard/documents/test.txt" ) ) );

        } catch (FileNotFoundException e) {
            Toast.makeText ( this,"Нет фаила в пути /sdcard/documents/test.txt", Toast.LENGTH_LONG).show ();
        }

        int size= 0;
        try {
            while (fil.readLine ()!=null)size++;
            s = new String[size];
            fil.close ();
            fil = new BufferedReader ( new FileReader ( new File ( "/sdcard/documents/test.txt" ) ) );
            for(int i= 0;i<size;i++)s[i]=fil.readLine ();
        } catch (IOException e) {
            e.printStackTrace ();
        }



    }

    public void start(View view) {
        int save[] = load ();
        if (save[0] == -1) {
            Test.i = 0;
            Test.ti = 0;
            Test.nGood = 0;
            Test.nBed = 0;
        }
        else  {
            Test.i = save[2];
            Test.ti = save[2];
            Test.nGood = save[0];
            Test.nBed = save[1];
        }
        getThis = this;
        if(Test.i == s.length)
            startActivity ( new Intent ( this,Finish.class ) );
        else
            startActivity(new Intent (this, Test.class));
    }
    int [] load() {
        int[] i = {0, 0, 0};
        try {


            String s[] = {
                    getPreferences ( MODE_PRIVATE ).getString ( "set1", "" ),
                    getPreferences ( MODE_PRIVATE ).getString ( "set2", "" ),
                    getPreferences ( MODE_PRIVATE ).getString ( "set3", "" )
            };


            i[ 0 ] = Integer.parseInt ( s[ 0 ] );
            i[ 1 ] = Integer.parseInt ( s[ 1 ] );
            i[ 2 ] = Integer.parseInt ( s[ 2 ] );
        }
        catch (Exception e){
            i[0] = -1;
            Toast.makeText ( this,"Впервые",Toast.LENGTH_LONG ).show ();
        }
        return i;
    }
    void save(int i1,int i2,int i3) {
        getPreferences(MODE_PRIVATE)
                .edit()
                .putString("set1", ""+i1)
                .apply ();
        getPreferences(MODE_PRIVATE)
                .edit()
                .putString("set2", ""+i2)
                .apply ();
        getPreferences(MODE_PRIVATE)
                .edit()
                .putString("set3", ""+i3)
                .apply ();
    }


}
