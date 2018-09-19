package com.cuo.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends AppCompatActivity implements View.OnClickListener  {
    LinearLayout.LayoutParams lParams;
    static int counter;
    static int tCount;
    int good  ;


    static int nGood = 0,nBed = 0;
    LinearLayout  l;
    boolean f;
    static int i = 0,ti = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.test );
        l = findViewById ( R.id.lin );
        i = ti;



           TextView t =  findViewById (R.id.qs  );
           t.setText ( Start.s[i] );
           i++;


        begin ();
        f = false;

        for(;i<Start.s.length;){
                String str = Start.s[i];
                if (Start.s[i].charAt (Start. s[i].length () - 1 ) == '@') {
                    good = counter;
                    str= Start.s[i].substring ( 0, Start.s[i].length () - 1 );
                } else if (Start.s[i].charAt ( Start.s[i].length () - 1 ) == '#') {
                    f = true;
                    str= Start.s[i].substring ( 0, Start.s[i].length () - 1 );
                }
                newRadBut ( str);
                i++;
                if (f) break;
            }
          Start.getThis.save ( nGood,nBed,ti );




    }
    void begin(){
        lParams = new LinearLayout.LayoutParams ( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        lParams.gravity = Gravity.LEFT;
        tCount = counter;
    }
    void newRadBut(String str){
        RadioButton rb = new RadioButton ( this );
        rb.setText ( str );
        rb.setId ( counter );
        counter++;
        rb.setOnClickListener ( this );
        l.addView ( rb, lParams );
    }




    public void onClick(View v) {
        if(v.getId () == good)
            nGood++;
        else nBed++;
        ti = i;
        if(f)
        startActivity(new Intent (this, Test.class));
        else startActivity(new Intent (this, Finish.class));
    }
    public void onBackPressed() {
        Toast.makeText ( this,"Не разрешенно",Toast.LENGTH_LONG ).show ();
    }

}
