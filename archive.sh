#!/bin/bash
if [[ -n $"{TRAVIS_TAG}" ]]; then
    if [[ $"{TRAVIS_BRANCH}"="develop" ]]; then
        echo "upload snapshot"
        ./gradlew :video:uploadArchives -PNEXUS_USERNAME="${NEXUS_USERNAME}" -PNEXUS_PASSWORD="${NEXUS_PASSWORD}"
    fi
else
    echo "upload release"
    openssl aes-256-cbc -K $encrypted_1d5880f7ca01_key -iv $encrypted_1d5880f7ca01_iv -in ./video/fast-video-view.gpg.enc -out ./video/fast-video-view.gpg -d
fi
