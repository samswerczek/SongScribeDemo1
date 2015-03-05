package com.songscribe.songscribe;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
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

    int[] soundsBass = {R.raw.guitar1, R.raw.guitar2, R.raw.guitar3};
    int[] soundsDrums = {R.raw.drums1,R.raw.drums2,R.raw.drums3};
    int[] soundsSong = {R.raw.song3, R.raw.song3, R.raw.song3};
   // int[] soundsBass = soundsDrums;

    //int[] soundsSong = soundsBass;

    int[] playing = new int[3];

    int indexBass = 0;
    int indexDrums = 0;
    int indexSong = 0;

    int lengthBass = 3;
    int lengthDrums = 3;
    int lengthSong = 3;
    int lengthUser = 3;

    int idBass = -1;
    int idDrums = -1;
    int idSong = -1;

    int test1,test2,test3;


    int[] listBass = new int[3];
    int[] listDrums = new int [3];
    int[] listSong = new int [3];

    /*
    SoundManager smBass;
    SoundManager smDrums;
    SoundManager smSong;
    SoundManager smUser;
    SoundManager sm;
*/
    SoundPool p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context test = this;

        //sm = new SoundManager(this, 1);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) p = new SoundPool.Builder().setMaxStreams(10).build();
        else p = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);

        listBass[0] = loadSound(R.raw.song3);
        listBass[1] = loadSound(R.raw.drums5);
        listBass[2] = loadSound(R.raw.fly);

        listDrums[0] = loadSound(R.raw.drums1);
        listDrums[1] = loadSound(soundsDrums[1]);
        listDrums[2] = loadSound(soundsDrums[2]);

        listSong[0] = loadSound(soundsSong[0]);
        listSong[1] = loadSound(soundsSong[1]);
        listSong[2] = loadSound(soundsSong[2]);

        test1 = p.load(this,R.raw.drums1,1);
        test2 = p.load(this,R.raw.drums2,1);
        test3 = p.load(this,R.raw.drums3,1);

        /*smBass = new SoundManager(this, lengthBass);
        smDrums = new SoundManager(this, lengthDrums);
        smSong = new SoundManager(this, lengthSong);

        smUser = new SoundManager(this, lengthUser);

        testthing = smDrums.initSound(this, R.raw.drums1);

        for(int s: soundsBass)  smBass.addSound(0, s);
        for(int s: soundsDrums)  smDrums.addSound(0, s);
        for(int s: soundsSong)  smSong.addSound(0, s);
        */
/*

        smBass.addSound(0, R.raw.drums1);
        smBass.addSound(1, R.raw.drums2);
        smBass.addSound(2, R.raw.drums3);

        smSong.addSound(0, R.raw.drums1);
        smSong.addSound(1, R.raw.drums2);
        smSong.addSound(2, R.raw.drums3);

        smDrums.addSound(0, R.raw.drums1);
        smDrums.addSound(1, R.raw.drums2);
        smDrums.addSound(2, R.raw.drums3);
*/
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

                //smBass.playSound(indexBass);
                //smDrums.playSound(indexDrums);
                //smSong.playSound(indexSong);




                if (isPlaying) {
                    isPlaying = false;
                    btnPlay.setText("Play");
                    pauseUserSong();
                    loopSong = false;
                } else {
                    isPlaying = true;
                    btnPlay.setText("Pause");
                    playUserSong();
                    loopSong = true;
                    //loopCheck();
                }


            }
        });

        btnBass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexBass >= soundsBass.length-1)indexBass=0;
                else indexBass++;

                stopAll();
                //smBass.initSound(indexBass);
                //idBass = loadSound(soundsBass[indexBass]);

                playSound(test1);

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
                if(indexSong >= soundsSong.length-1)indexSong=0;
                else indexSong++;

                stopAll();
               // smSong.initSound(indexSong);

                //idSong = loadSound(soundsSong[indexSong]);
                playSound(test2);

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
                if(indexDrums >= soundsDrums.length-1)indexDrums=0;
                else indexDrums++;

                stopAll();

               // smDrums.initSound(indexDrums);
                //idDrums = loadSound(soundsDrums[indexDrums]);
                playSound(test3);
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
                stopAll();



            }

        });


    }

    public void playSound(int loadedSound){
        playing[0] = p.play(loadedSound, 1, 1, 1, 0, 1);
    }
    public int loadSound(int rawSound){
        return p.load(this,rawSound,1);
    }
    public void stopSound(int playingSound){
        p.stop(playingSound);
    }

    public void stopAll(){
        for(int s: playing)  stopSound(s);
    }




    public void playUserSong(){

        playing[0] = p.play(test1, 1, 1, 1, 0, 1);
        playing[1] = p.play(test2, 1, 1, 1, 0, 1);
        playing[2] = p.play(test3, 1, 1, 1, 0, 1);
    }
    public void pauseUserSong(){



        p.pause(playing[0]);
        p.pause(playing[1]);
        p.pause(playing[2]);
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
