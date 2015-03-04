package com.songscribe.songscribe;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private static boolean isPlaying = false;
    private static boolean loopSong = false;
    SongThread song = new SongThread();

    int[] sounds = {R.raw.fly, R.raw.ssad, R.raw.lovebinds};
    SoundManager bass = new SoundManager(this, sounds.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] soundsBass = {R.raw.bass1, R.raw.bass2, R.raw.bass3};
        int[] soundsDrums = {R.raw.drums1,R.raw.drums2,R.raw.drums3};
        int[] soundsSong = {R.raw.song1, R.raw.song2, R.raw.song3};

        for(int s: soundsBass)  bass.addSound(0, s);
        for(int s: soundsDrums)  bass.addSound(0, s);
        for(int s: soundsSong)  bass.addSound(0, s);

        final Button play_button=(Button)findViewById(R.id.button1);
        final Button chords_button=(Button)findViewById(R.id.button3);
        final Button leads_button=(Button)findViewById(R.id.button5);
        final Button drums_button=(Button)findViewById(R.id.button4);
        final Button stop=(Button)findViewById(R.id.button2);
/*
        final MediaPlayer chord_player = MediaPlayer.create(MainActivity.this, R.raw.ssad);
        final MediaPlayer drum_player = MediaPlayer.create(MainActivity.this, R.raw.lovebinds);
        final MediaPlayer lead_player = MediaPlayer.create(MainActivity.this, R.raw.fly);

*/

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPlaying){
                    /*
                    if(drum_player.isPlaying())drum_player.pause();
                    if(chord_player.isPlaying()) chord_player.pause();
                    if(lead_player.isPlaying())lead_player.pause();
                    */
                    isPlaying=false;
                    play_button.setText("Play");
                    loopSong = false;
                }else{

                    isPlaying=true;
                    play_button.setText("Pause");

                    /*
                    if(!drum_player.isPlaying())drum_player.start();

                    if(!lead_player.isPlaying())lead_player.start();


                    if(!chord_player.isPlaying())chord_player.start();

*/
                    loopSong = true;
                    //loopCheck();
                }



            }
        });

        chords_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chord_player.seekTo(0);
                /*
                if(chord_player.isPlaying()) chord_player.stop();
                else chord_player.start();
                */

            }
        });

        drums_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //drum_player.seekTo(0);
                /*
                if(drum_player.isPlaying()) drum_player.stop();
                else drum_player.start();
            */
            }
        });

        leads_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lead_player.seekTo(0);
                /*
                if(lead_player.isPlaying()) lead_player.stop();
                else lead_player.start();
            */
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                if(drum_player.isPlaying())drum_player.pause();
                if(chord_player.isPlaying()) chord_player.pause();
                if(lead_player.isPlaying())lead_player.pause();
                drum_player.seekTo(0);
                chord_player.seekTo(0);
                lead_player.seekTo(0);
                */
                isPlaying=false;

                play_button.setText("Play");
                loopSong = false;


            }

        });


    }

    public class SongThread extends Thread {

        public void run() {
            if (loopSong){

            }else{

            }
        }

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
