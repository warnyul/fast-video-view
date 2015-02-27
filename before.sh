#!/bin/bash
chmod +x ./gradlew
chmod +x ./archive.sh
if [[ -n $"{TRAVIS_TAG}" ]]; then
    openssl aes-256-cbc -k "$super_secret_password" -in ./video/secret_key.enc -out ./video/secret_key.gpg
fi