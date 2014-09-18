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
package org.vargaba.app.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.vargaba.app.sample.screen.AlphaSampleActivity;
import org.vargaba.app.sample.screen.RotatedSampleActivity;
import org.vargaba.app.sample.screen.VideoSampleActivity;

/**
 * Activity for listing VideoView samples.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button videoSample = (Button)findViewById(R.id.video_sample_button);
        Button rotatedSample = (Button)findViewById(R.id.rotated_sample_button);
        Button alphaSample = (Button)findViewById(R.id.alpha_sample_button);

        videoSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideoSample();
            }
        });

        rotatedSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRotatedSample();
            }
        });

        alphaSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlphaSample();
            }
        });
    }

    /**
     * Starts the simple video sample activity.
     */
    private void startVideoSample() {
        Intent intent = new Intent(this, VideoSampleActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the rotated video sample activity.
     */
    private void startRotatedSample() {
        Intent intent = new Intent(this, RotatedSampleActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the alpha video sample activity.
     */
    private void startAlphaSample() {
        Intent intent = new Intent(this, AlphaSampleActivity.class);
        startActivity(intent);
    }
}
