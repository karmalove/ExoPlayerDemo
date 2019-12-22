package com.karma.exoplayerdemo;

import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.View;

import com.karma.exoplayerdemo.mediaclient.MediaBrowserHelper;
import com.karma.exoplayerdemo.mediaclient.MediaBrowserHelperCallback;
import com.karma.exoplayerdemo.service.MediaService;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaBrowserHelper mediaBrowserHelper = new MediaBrowserHelper(this, MediaService.class);

        mediaBrowserHelper.setMediaBrowserHelperCallback(new MediaBrowserHelperCallback() {
            @Override
            public void onPlaybackStateChanged(PlaybackStateCompat state) {
                if (state.getState() == PlaybackStateCompat.STATE_PLAYING) {
                    isPlaying = true;
                } else {
                    isPlaying = false;
                }
            }

            @Override
            public void onMediaControllerConnected(MediaControllerCompat mediaController) {
                Log.d(TAG, "onMediaControllerConnected: ");
                if (mediaController.getPlaybackState() != null &&
                        mediaController.getPlaybackState().getState() == PlaybackStateCompat.STATE_PLAYING) {
                    isPlaying = true;
                } else {
                    isPlaying = false;
                }
                if (mediaController.getMetadata() != null) {

                }

            }
        });
        mediaBrowserHelper.onStart();

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaBrowserHelper.getController().getTransportControls().play();
            }
        });
    }
}
