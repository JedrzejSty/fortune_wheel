package com.example.kolo_fortuny;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String[] hasla;
    private String[] na_kole;
    private String current;
    private String tekst_na_kole;
    private int current_length;
    int word_number;
    int wheel_number;
    private String currentLetter;
    private char [] currentLetter2;
    int licznik;
    boolean player = true;
    int points_p1 = 0;
    int points_p2 = 0;
    int czy_litera;
    boolean wheelFlag = true;
    boolean letterFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView word = (TextView) findViewById(R.id.textView);
        final TextView w0 = (TextView) findViewById(R.id.textView0);
        final TextView w1 = (TextView) findViewById(R.id.textView1);
        final TextView w2 = (TextView) findViewById(R.id.textView2);
        final TextView w3 = (TextView) findViewById(R.id.textView3);
        final TextView w4 = (TextView) findViewById(R.id.textView4);
        final TextView w5 = (TextView) findViewById(R.id.textView5);
        final TextView w6 = (TextView) findViewById(R.id.textView6);
        final TextView w7 = (TextView) findViewById(R.id.textView7);
        final TextView w8 = (TextView) findViewById(R.id.textView8);
        final TextView w9 = (TextView) findViewById(R.id.textView9);
        final TextView w10 = (TextView) findViewById(R.id.textView10);
        final TextView w11 = (TextView) findViewById(R.id.textView11);
        final TextView w12 = (TextView) findViewById(R.id.textView12);
        final TextView w13 = (TextView) findViewById(R.id.textView13);
        final TextView w14 = (TextView) findViewById(R.id.textView14);
        final TextView w15 = (TextView) findViewById(R.id.textView15);
        final TextView w16 = (TextView) findViewById(R.id.textView16);
        final TextView w17 = (TextView) findViewById(R.id.textView17);
        final TextView w18 = (TextView) findViewById(R.id.textView18);
        final TextView w19 = (TextView) findViewById(R.id.textView19);
        final TextView w20 = (TextView) findViewById(R.id.textView20);
        final TextView w21 = (TextView) findViewById(R.id.textView21);
        final TextView w22 = (TextView) findViewById(R.id.textView22);
        final TextView onWheel = (TextView) findViewById(R.id.textView24);
        final TextView p1_textview = (TextView) findViewById(R.id.textView25);
        final TextView p2_textview = (TextView) findViewById(R.id.textView26);
        final TextView help = (TextView) findViewById(R.id.textView27);

        final ImageView wheel = (ImageView) findViewById(R.id.wheel);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        final EditText letterBox = (EditText) findViewById(R.id.editText);
        hasla = getResources().getStringArray(R.array.hasla_txt);
        na_kole = getResources().getStringArray(R.array.kwoty);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                word_number = rand.nextInt(9)*2+1;

                current = hasla[word_number-1];
                current_length=current.length();
                word.setText(hasla[word_number]);
                w22.setText("Zakręć kołem i podaj literę ");

                int maxLength = current_length;
                letterBox.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                /*
                w0.setText(current.substring(0,1));
                w1.setText(current.substring(1,2));
                w2.setText(current.substring(2,3));
                w3.setText(current.substring(3,4));
                w4.setText(current.substring(4,5));
                w5.setText(current.substring(5,6));
                w6.setText(current.substring(6,7));
                w7.setText(current.substring(7,8));
                w8.setText(current.substring(8,9));
                w9.setText(current.substring(9,10));
                if(i==0)w0.setText(current.substring(i,i+1));
                    if(i==1)w1.setText(current.substring(i,i+1));
                    if(i==2)w2.setText(current.substring(i,i+1));
                    if(i==3)w3.setText(current.substring(i,i+1));
                    if(i==4)w4.setText(current.substring(i,i+1));
                    if(i==5)w5.setText(current.substring(i,i+1));
                    if(i==6)w6.setText(current.substring(i,i+1));
                    if(i==7)w7.setText(current.substring(i,i+1));
                    if(i==8)w8.setText(current.substring(i,i+1));
                    if(i==9)w9.setText(current.substring(i,i+1));
                    if(i==10)w10.setText(current.substring(i,i+1));
                    if(i==11)w11.setText(current.substring(i,i+1));
                */

                w0.setText(" ");
                w1.setText(" ");
                w2.setText(" ");
                w3.setText(" ");
                w4.setText(" ");
                w5.setText(" ");
                w6.setText(" ");
                w7.setText(" ");
                w8.setText(" ");
                w9.setText(" ");
                w10.setText(" ");
                w11.setText(" ");

                for(int i = 0; i < current_length; i++){

                    char c = current.charAt(i);
                    if(c != ' ') {
                        if (i == 0) w0.setText("*");
                        if (i == 1) w1.setText("*");
                        if (i == 2) w2.setText("*");
                        if (i == 3) w3.setText("*");
                        if (i == 4) w4.setText("*");
                        if (i == 5) w5.setText("*");
                        if (i == 6) w6.setText("*");
                        if (i == 7) w7.setText("*");
                        if (i == 8) w8.setText("*");
                        if (i == 9) w9.setText("*");
                        if (i == 10) w10.setText("*");
                        if (i == 11) w11.setText("*");
                    }
                    else{
                        if (i == 0) w0.setText(" ");
                        if (i == 1) w1.setText(" ");
                        if (i == 2) w2.setText(" ");
                        if (i == 3) w3.setText(" ");
                        if (i == 4) w4.setText(" ");
                        if (i == 5) w5.setText(" ");
                        if (i == 6) w6.setText(" ");
                        if (i == 7) w7.setText(" ");
                        if (i == 8) w8.setText(" ");
                        if (i == 9) w9.setText(" ");
                        if (i == 10) w10.setText(" ");
                        if (i == 11) w11.setText(" ");
                    }
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (letterFlag == true) {
                    //letterFlag = false;
                    closeKeybord();
                    wheelFlag = true;
                    currentLetter = letterBox.getText().toString();
                    currentLetter = currentLetter.toLowerCase();
                    currentLetter2 = currentLetter.toCharArray();
                    w22.setText(" ");
                    letterBox.getText().clear();
                    czy_litera = 0;
                    for (int i = 0; i < current_length; i++) {
                        if (currentLetter2.length == 1) {
                            if (currentLetter2[0] == 'a' || currentLetter2[0] == 'e' || currentLetter2[0] == 'i' || currentLetter2[0] == 'o' || currentLetter2[0] == 'u' || currentLetter2[0] == 'y') {
                                w22.setText("Nie możesz wprowadzić samogłoski");
                                player = !player;
                                help.setText(String.valueOf("Negacja1"));
                            } else {
                                if (currentLetter2[0] == current.charAt(i)) {
                                    w22.setText("Podaj kolejna litere");
                                    if (i == 0) {
                                        w0.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 1) {
                                        w1.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 2) {
                                        w2.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 3) {
                                        w3.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 4) {
                                        w4.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 5) {
                                        w5.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 6) {
                                        w6.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 7) {
                                        w7.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 8) {
                                        w8.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 9) {
                                        w9.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 10) {
                                        w10.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }
                                    if (i == 11) {
                                        w11.setText(current.substring(i, i + 1));
                                        czy_litera++;
                                        if (player == true) {
                                            points_p1 = points_p1 + Integer.valueOf(na_kole[wheel_number]);
                                        } else {
                                            points_p2 = points_p2 + Integer.valueOf(na_kole[wheel_number]);
                                        }
                                    }

                                } else if (i == current_length - 1 && czy_litera == 0) {
                                    w22.setText("Brak litery!");
                                    player = !player;
                                    if(player == true){
                                        help.setText(String.valueOf("Gracz 1"));
                                    }
                                    else{
                                        help.setText(String.valueOf("Gracz 2"));
                                    }

                                }
                            }

                        //}
                    }


                    if (currentLetter2.length > 1) {
                        licznik = 0;
                        for (int j = 0; j < currentLetter2.length; j++) {

                            if (currentLetter2[j] == current.charAt(j)) {
                                licznik++;
                                if (licznik == current.length()) {
                                    for (int k = 0; k < current_length; k++) {
                                        if (k == 0) w0.setText(current.substring(k, k + 1));
                                        if (k == 1) w1.setText(current.substring(k, k + 1));
                                        if (k == 2) w2.setText(current.substring(k, k + 1));
                                        if (k == 3) w3.setText(current.substring(k, k + 1));
                                        if (k == 4) w4.setText(current.substring(k, k + 1));
                                        if (k == 5) w5.setText(current.substring(k, k + 1));
                                        if (k == 6) w6.setText(current.substring(k, k + 1));
                                        if (k == 7) w7.setText(current.substring(k, k + 1));
                                        if (k == 8) w8.setText(current.substring(k, k + 1));
                                        if (k == 9) w9.setText(current.substring(k, k + 1));
                                        if (k == 10) w10.setText(current.substring(k, k + 1));
                                        if (k == 11) w11.setText(current.substring(k, k + 1));
                                        w22.setText("Gratulacje! Poprawna odpowiedz");
                                        player = !player;
                                        if(player == true){
                                            help.setText(String.valueOf("Gracz 1"));
                                        }
                                        else{
                                            help.setText(String.valueOf("Gracz 2"));
                                        }
                                    }
                                }
                            } else {
                                w22.setText("Hssło nieprawidłowe");
                                player = !player;
                                if(player == true){
                                    help.setText(String.valueOf("Gracz 1"));
                                }
                                else{
                                    help.setText(String.valueOf("Gracz 2"));
                                }
                                break;
                            }
                        }
                    }
                    p1_textview.setText(String.valueOf(points_p1));
                    p2_textview.setText(String.valueOf(points_p2));
                    //help.setText(String.valueOf(player));

                }
            }

        });

        wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wheelFlag == true) {
                    wheelFlag = false;
                    letterFlag = true;
                    RotateAnimation rotateAnimation = new RotateAnimation(0, 7 * 360, RotateAnimation.RELATIVE_TO_SELF, .5f, RotateAnimation.RELATIVE_TO_SELF, .5f);
                    rotateAnimation.setDuration(2000);
                    wheel.startAnimation(rotateAnimation);

                    Random rand = new Random();
                    wheel_number = rand.nextInt(20);
                    tekst_na_kole = na_kole[wheel_number];

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            onWheel.setText(tekst_na_kole);
                        }
                    }, 2000);
                    //onWheel.setText(tekst_na_kole);
                    if(wheel_number== 5 || wheel_number == 14){
                        if (player == true) {
                            points_p1 = 0;
                            wheelFlag = true;
                            player = false;
                            letterFlag = false;
                            Handler handler2 = new Handler();
                            handler2.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    p1_textview.setText(String.valueOf(points_p1));
                                }
                            }, 2000);

                        } else {
                            points_p2 = 0;
                            wheelFlag = true;
                            player = true;
                            p2_textview.setText(String.valueOf(points_p2));
                            letterFlag = false;
                            Handler handler3 = new Handler();
                            handler3.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    p2_textview.setText(String.valueOf(points_p2));
                                }
                            }, 2000);



                        }
                    }

                }
            }
        });
    }
    private void closeKeybord(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
