# fast-video-view [![Build Status](https://travis-ci.org/warnyul/fast-video-view.svg?branch=develop)](https://travis-ci.org/warnyul/fast-video-view)
## Requirements
Android API Level >= 14 (Ice Cream Sandwich)

## Overview

This implementation can only be used in a hardware accelerated window. When rendered in software, FastVideoView will display nothing.

Unlike basic [VideoView](http://developer.android.com/reference/android/widget/VideoView.html) on Android, does not create a separate window, but behaves as a regular view. This key difference allows a FastViewView to be moved, transformed, animated, etc. For instance, you can make a FastVideoView semi-translucent by calling `videoView.setAlpha(0.5)`. FastVideoView has featuring all of the TextureView.

Using a FastVideoView is simple: all you need is get its basic [VideoView](http://developer.android.com/reference/android/widget/VideoView.html) on Android. The following examples demonstrate how to use a VideoView:

    <com.warnyul.android.widget.FastVideoView
            android:id="@+id/video"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:alpha="0.5"
            android:rotation="45"/>

Java code:

    public class MainActivity extends Activity {
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            FastVideoView videoView = (FastVideoView)findViewById(R.id.video);
            videoView.setMediaController(new MediaController(this));
            videoView.setVideoPath("http://yourwebsite.com/customvideo.3gp");
            videoView.setAlpha(0.5f);       // Set transparency.
            videoView.setRotation(45.0f);   // Set rotation.
            videoView.start();
        }
    }

## Download
### Gradle
    compile 'com.warnyul.android.fast-video-view:fast-video-view:1.0.1-SNAPSHOT'

### Maven
    <dependency>
        <groupId>com.warnyul.android.fast-video-view</groupId>
        <artifactId>fast-video-view</artifactId>
        <version>1.0.1-SNAPSHOT</version>
    </dependency>

## Licence
Copyright © 2014 Balázs Varga

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.