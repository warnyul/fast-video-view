#!/bin/bash
if [[ -n $"{TRAVIS_TAG}" ]]; then
    if [[ $"{TRAVIS_BRANCH}"="develop" ]]; then
        echo "upload snapshot"
        ./gradlew :video:uploadArchives -PNEXUS_USERNAME="${NEXUS_USERNAME}" -PNEXUS_PASSWORD="${NEXUS_PASSWORD}"
    fi
else
    echo "upload release"
    ./gradlew :video:uploadArchives -PNEXUS_USERNAME="${NEXUS_USERNAME}" -PNEXUS_PASSWORD="${NEXUS_PASSWORD}" -Psigning.keyId="${SIGNING_KEY_ID}" -Psigning.password="${SIGNING_PASSWORD}" -Psigning.secretKeyRingFile="${SIGNING_KEY_RING_FILE}"
fi
