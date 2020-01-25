package com.example.hamzeh.xxxooo;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class xo extends AppCompatActivity {
    public static final int xx = 1;
    public static final int oo = 2;
    public static final int oxo = 0;
    public static final int nobarandeh=-1;
    int[] jadval = {oxo, oxo, oxo,
            oxo, oxo, oxo,
            oxo, oxo, oxo};
    int baze = xx;
    int[][] winnere = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    int winner=nobarandeh;
    int o=0;
    int x=0;
    int i;
    Button reset;
    TextView tvo;
    TextView tvx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);
        reset= (Button) findViewById(R.id.reset);
        tvo=(TextView) findViewById(R.id.tvo);
        tvx= (TextView) findViewById(R.id.tvx);

    }

    public void onclickxoro(View view) {
        int tag = Integer.parseInt((String) view.getTag());
       if (winner!=nobarandeh||(jadval[tag]!= oxo)) {
            return;
        }
        ImageView xo = (ImageView) view;
        xo.setScaleY(0);
        xo.setScaleX(0);

        if (baze == xx) {
            xo.setImageResource(R.drawable.xxx);
            xo.animate().rotationBy(3 * 360).scaleX(1f).scaleY(1f).setDuration(1000);
            jadval[tag] = xx;
            baze = oo;
        } else if (baze == oo) {
            jadval[tag] = oo;
            baze = xx;
            xo.setImageResource(R.drawable.o);
            xo.animate().rotationBy(3 * 360).scaleX(1f).scaleY(1f).setDuration(1000);
        }
         winner=barandeh();
        if(winner!=nobarandeh||por()){
            {  if (winner==xx)x++;else if (winner==oo)o++;
           }
           tvo.setText("o ="+ ""+o);
            tvx.setText( "x ="+ ""+x);
            Toast.makeText(this, ((winner==xx)?"برنده بازیx":(winner==oo)?   "برنده بازیo"  :"بازی برنده نداره"),
                    Toast.LENGTH_SHORT).show();
            if(x==9||o==9){
                Toast.makeText(this,((x==10)?  "برنده کامل X" :"برنده کامل o"),Toast.LENGTH_LONG );
                x=0;
                o=0;
            }
        }
    }
    public int barandeh(){
        for (int[]macan:winnere) {
            if(jadval[macan[0]]==jadval[macan[1]]
                    &&jadval[macan[1]]==jadval[macan[2]]
                    &&jadval[macan[0]]!=oxo){
                return jadval[macan[0]];
            }

        }
        return nobarandeh;
    }
    public boolean por(){
        for (int i=0;i<jadval.length;i++){
            if(jadval[i]==oxo){
                return false;
            }
        }
        return true;
    }
    public void Rist(View b){
 if (b.getId()==R.id.reset) {
     if(i%2==0){
         baze=oo;
         Toast.makeText(xo.this,"شروع بازی با o" ,Toast.LENGTH_LONG).show();
     }
     else {
         baze=xx;
         Toast.makeText(xo.this,"شروع بازی با x" ,Toast.LENGTH_LONG).show();
     }
     i++;
     winner = nobarandeh;
     for (int pak = 0; pak < jadval.length; pak++) {
         jadval[pak] = oxo;
     }
     LinearLayout zmbz = (LinearLayout) findViewById(R.id.base);
     for (int somares = 0; somares < zmbz.getChildCount(); somares++) {
         LinearLayout childer = (zmbz.getChildAt(somares) instanceof LinearLayout) ?
                 (LinearLayout) zmbz.getChildAt(somares) : null;
         if (childer == null) return;
         for (int i = 0; i < childer.getChildCount(); i++) {
             ImageView kh = (childer.getChildAt(i) instanceof ImageView) ?
                     (ImageView) childer.getChildAt(i) : null;
             if (childer == null) return;
             kh.setImageResource(0);

         }
     }
 }
    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuItem next=menu.add("about");
        next.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent f=new Intent(xo.this,xnext.class);
                startActivity(f);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);


    }

}

