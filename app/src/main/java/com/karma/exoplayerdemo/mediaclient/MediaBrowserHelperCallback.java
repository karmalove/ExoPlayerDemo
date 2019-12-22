package com.karma.exoplayerdemo.mediaclient;

import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;

public interface MediaBrowserHelperCallback {


    void onPlaybackStateChanged(PlaybackStateCompat state);

    void onMediaControllerConnected(MediaControllerCompat mediaController);

    //netvoid onGetChildPlayList(List<MediaBrowserCompat.MediaItem> children);

}









