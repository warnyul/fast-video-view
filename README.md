# VideoView
## Overview

This implementation can only be used in a hardware accelerated window. When rendered in software, ViewView will display nothing.

Unlike basic [VideoView](http://developer.android.com/reference/android/widget/VideoView.html) on Android, does not create a separate window, but behaves as a regular view. This key difference allows a ViewView to be moved, transformed, animated, etc. For instance, you can make a VideoView semi-translucent by calling `videoView.setAlpha(0.5)`. VideoView has featuring all of the TextureView.

Using a VideoView is simple: all you need is get its basic [VideoView](http://developer.android.com/reference/android/widget/VideoView.html) on Android. The following example demonstrates how to use a VideoView:

    public class MainActivity extends Activity {
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            VideoView videoView = (VideoView)findViewById(R.id.video);
            videoView.setMediaController(new MediaController(this));
            videoView.setVideoPath("http://www.pocketjourney.com/downloads/pj/video/famous.3gp");
            videoView.start();
        }
    }