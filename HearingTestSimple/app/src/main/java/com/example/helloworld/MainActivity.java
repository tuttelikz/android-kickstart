package com.example.helloworld;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final int duration = 3; // seconds
    private final int sampleRate = 44100; //Default sampling rate
    private final int numSamples = duration * sampleRate;
    private final double sample[] = new double[numSamples];
    private final byte generatedSnd[] = new byte[2 * numSamples];

    Handler handler = new Handler();
    SeekBar freqSeekbar;
    TextView freqLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        freqSeekbar = findViewById(R.id.volumeControl);
        freqLabel = findViewById(R.id.freqText);

        int value = freqSeekbar.getProgress();
        Log.d("myTag", String.valueOf(value));

        freqSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekbarProgress = 0;
            int freq;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarProgress = progress;
                freq = seekbarProgress*200;
                // Use a new tread as this can take a while
                final Thread thread = new Thread(new Runnable() {
                    public void run() {
                        genTone(freq);
                        handler.post(new Runnable() {

                            public void run() {
                                playSound();
                            }
                        });
                    }
                });
                thread.start();
                freqLabel.setText(String.valueOf(freq));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

    @Override
    protected void onResume() {
    super.onResume();

    }

    void genTone(int freq){
        // fill out the array
        for (int i = 0; i < numSamples; ++i) {
            sample[i] = Math.sin(2 * Math.PI * i / (sampleRate/freq));
        }

        // convert to 16 bit pcm sound array
        // assumes the sample buffer is normalised.
        int idx = 0;
        for (final double dVal : sample) {
            // scale to maximum amplitude
            final short val = (short) ((dVal * 32767));
            // in 16 bit wav PCM, first byte is the low order byte
            generatedSnd[idx++] = (byte) (val & 0x00ff);
            generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);
        }
    }

    void playSound(){
        final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                sampleRate, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT, generatedSnd.length,
                AudioTrack.MODE_STATIC);
        audioTrack.write(generatedSnd, 0, generatedSnd.length);
        audioTrack.play();
    }

}
