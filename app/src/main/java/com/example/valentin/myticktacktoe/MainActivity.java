package com.example.valentin.myticktacktoe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean moveCross = false;
    boolean end = false;
    int[] playing_field = new int[9];
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtView = (TextView)findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected void movePlayer(int type, View v) {
        if(end != true) {
            int cellVal = Integer.valueOf(playing_field[type]);
            if( cellVal == 0 ) {
                Button btn = (Button)findViewById(v.getId());
                if(moveCross) {
                    playing_field[type] = 1;
                    btn.setText("X");
                    moveCross = false;
                    txtView.setText( "ход O" );
                } else {
                    playing_field[type] = 2;
                    btn.setText("O");
                    moveCross = true;
                    txtView.setText( "ход X" );
                }

                if(
                                (playing_field[0] == playing_field[1] && playing_field[0] == playing_field[2] && playing_field[0] > 0) ||
                                (playing_field[3] == playing_field[4] && playing_field[3] == playing_field[5] && playing_field[3] > 0) ||
                                (playing_field[6] == playing_field[7] && playing_field[6] == playing_field[8] && playing_field[6] > 0) ||

                                (playing_field[0] == playing_field[3] && playing_field[0] == playing_field[6] && playing_field[0] > 0) ||
                                (playing_field[1] == playing_field[4] && playing_field[1] == playing_field[7] && playing_field[1] > 0) ||
                                (playing_field[2] == playing_field[5] && playing_field[2] == playing_field[6] && playing_field[2] > 0) ||

                                (playing_field[0] == playing_field[4] && playing_field[0] == playing_field[8] && playing_field[0] > 0) ||
                                (playing_field[2] == playing_field[4] && playing_field[2] == playing_field[6] && playing_field[2] > 0)
                        ) {
                    end = true;
                    txtView.setText( "Конец игры" );
                }

            } else {
                txtView.setText( "Недопустимый ход" );
            }
        }

    }

    public void clickButton1(View view) {
        movePlayer(0, view);
    }

    public void clickButton2(View view) {
        movePlayer(1, view);
    }

    public void clickButton3(View view) {
        movePlayer(2, view);
    }

    public void clickButton4(View view) {
        movePlayer(3, view);
    }

    public void clickButton5(View view) {
        movePlayer(4, view);
    }

    public void clickButton6(View view) {
        movePlayer(5, view);
    }

    public void clickButton7(View view) {
        movePlayer(6, view);
    }

    public void clickButton8(View view) {
        movePlayer(7, view);
    }

    public void clickButton9(View view) {
        movePlayer(8, view);
    }

    public void clickButton10(View view) {
        moveCross = false;
        end = false;
        playing_field = new int[9];
        txtView.setText(R.string.labelTop);
        Button btn;
        btn = (Button)findViewById(R.id.button1);
        btn.setText("");
        btn = (Button)findViewById(R.id.button2);
        btn.setText("");
        btn = (Button)findViewById(R.id.button3);
        btn.setText("");
        btn = (Button)findViewById(R.id.button4);
        btn.setText("");
        btn = (Button)findViewById(R.id.button5);
        btn.setText("");
        btn = (Button)findViewById(R.id.button6);
        btn.setText("");
        btn = (Button)findViewById(R.id.button7);
        btn.setText("");
        btn = (Button)findViewById(R.id.button8);
        btn.setText("");
        btn = (Button)findViewById(R.id.button9);
        btn.setText("");
    }
}
