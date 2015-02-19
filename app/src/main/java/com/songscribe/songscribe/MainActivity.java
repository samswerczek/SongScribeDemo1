package com.songscribe.songscribe;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play_button=(Button)findViewById(R.id.button1);
        Button chords_button=(Button)findViewById(R.id.button3);
        Button leads_button=(Button)findViewById(R.id.button5);
        Button drums_button=(Button)findViewById(R.id.button4);
        Button button2=(Button)findViewById(R.id.button2);

        final MediaPlayer chord_player = MediaPlayer.create(MainActivity.this, R.raw.ssad);
        final MediaPlayer drum_player = MediaPlayer.create(MainActivity.this, R.raw.lovebinds);
        final MediaPlayer lead_player = MediaPlayer.create(MainActivity.this, R.raw.fly);


        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chord_player.seekTo(0);
                drum_player.seekTo(0);
                lead_player.seekTo(0);

                drum_player.start();
                chord_player.start();
                lead_player.start();
            }
        });

        chords_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chord_player.seekTo(0);
                chord_player.start();
            }
        });

        drums_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drum_player.seekTo(0);
                drum_player.start();
            }
        });

        leads_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lead_player.seekTo(0);
                lead_player.start();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chord_player.pause();
                drum_player.pause();
                lead_player.pause();


            }

        });


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
}
