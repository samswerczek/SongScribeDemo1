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

    int[] soundsBass = {R.raw.bass1, R.raw.bass2, R.raw.bass3};
    int[] soundsDrums = {R.raw.drums1,R.raw.drums2,R.raw.drums3};
    int[] soundsSong = {R.raw.song1, R.raw.song2, R.raw.song3};

    int indexBass = 0;
    int indexDrums = 0;
    int indexSong = 0;

    SoundManager smBass = new SoundManager(this, soundsBass.length);
    SoundManager smDrums = new SoundManager(this, soundsDrums.length);
    SoundManager smSong = new SoundManager(this, soundsSong.length);

    SoundManager smUser = new SoundManager(this, soundsSong.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int s: soundsBass)  smBass.addSound(0, s);
        for(int s: soundsDrums)  smDrums.addSound(0, s);
        for(int s: soundsSong)  smSong.addSound(0, s);

        final Button btnPlay=(Button)findViewById(R.id.button1);
        final Button btnBass=(Button)findViewById(R.id.button3);
        final Button btnDrums=(Button)findViewById(R.id.button5);
        final Button btnSong=(Button)findViewById(R.id.button4);
        final Button btnStop=(Button)findViewById(R.id.button2);
/*
        final MediaPlayer chord_player = MediaPlayer.create(MainActivity.this, R.raw.ssad);
        final MediaPlayer drum_player = MediaPlayer.create(MainActivity.this, R.raw.lovebinds);
        final MediaPlayer lead_player = MediaPlayer.create(MainActivity.this, R.raw.fly);

*/

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                smBass.playSound(indexBass);
                smDrums.playSound(indexDrums);
                smSong.playSound(indexSong);

                if (isPlaying) {
                    /*
                    if(drum_player.isPlaying())drum_player.pause();
                    if(chord_player.isPlaying()) chord_player.pause();
                    if(lead_player.isPlaying())lead_player.pause();
                    */
                    isPlaying = false;
                    btnPlay.setText("Play");
                    loopSong = false;
                } else {

                    isPlaying = true;
                    btnPlay.setText("Pause");

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

        btnBass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexBass == smBass.getSize())indexBass=0;
                else indexBass++;
                smBass.playSound(indexBass);
                //chord_player.seekTo(0);
                /*
                if(chord_player.isPlaying()) chord_player.stop();
                else chord_player.start();
                */

            }
        });

        btnSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexSong == smSong.getSize())indexSong=0;
                else indexSong++;
                smSong.playSound(indexSong);
                //drum_player.seekTo(0);
                /*
                if(drum_player.isPlaying()) drum_player.stop();
                else drum_player.start();
            */
            }
        });

        btnDrums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexDrums == smDrums.getSize())indexDrums=0;
                else indexDrums++;
                smDrums.playSound(indexDrums);
                //lead_player.seekTo(0);
                /*
                if(lead_player.isPlaying()) lead_player.stop();
                else lead_player.start();
            */
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
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
                isPlaying = false;

                btnPlay.setText("Play");
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
