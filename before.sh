#!/bin/bash
chmod +x ./gradlew
chmod +x ./archive.sh
if [[ -z $"{TRAVIS_TAG}" ]]; then
    echo "prepare signing"
    openssl aes-256-cbc -K $encrypted_0cd30212d19a_key -iv $encrypted_0cd30212d19a_iv -in ./video/fast-video-view.gpg.enc -out ./video/fast-video-view.gpg -d
fi