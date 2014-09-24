/*
 * Copyright (C) 2014 Balázs Varga
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.warnyul.android.fastvideoview.sample.screens;

import android.os.Bundle;
import android.widget.MediaController;

import org.warnyul.android.fastvideoview.R;
import org.warnyul.android.fastvideoview.sample.BaseSampleActivity;
import org.warnyul.android.widget.FastVideoView;

import java.util.concurrent.TimeUnit;

/**
 * Sample Activity for VideoView class simple usage.
 */
public class VideoSampleActivity extends BaseSampleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_video_sample);

        FastVideoView videoView = (FastVideoView)findViewById(R.id.video);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("http://www.pocketjourney.com/downloads/pj/video/famous.3gp");
        videoView.seekTo((int) TimeUnit.SECONDS.toMillis(1));
    }
}
