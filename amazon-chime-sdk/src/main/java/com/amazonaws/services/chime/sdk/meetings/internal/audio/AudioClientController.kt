/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.amazonaws.services.chime.sdk.meetings.internal.audio

import com.amazonaws.services.chime.sdk.meetings.audiovideo.PrimaryMeetingPromotionObserver
import com.amazonaws.services.chime.sdk.meetings.audiovideo.audio.AudioMode
import com.amazonaws.services.chime.sdk.meetings.audiovideo.audio.AudioRecordingPresetOverride
import com.amazonaws.services.chime.sdk.meetings.audiovideo.audio.AudioStreamType
import com.amazonaws.services.chime.sdk.meetings.session.MeetingSessionCredentials

/**
 * [AudioClientController]'s responsibility is to handle AudioClient API calls such as starting
 * and stopping audio session
 *
 * Interface was created in response to difficulty in refactoring [AudioClientController] into
 * [DefaultAudioClientController] and [DefaultAudioClientObserver] without breaking the rest of code
 */
interface AudioClientController {
    fun getRoute(): Int
    fun setRoute(route: Int): Boolean
    fun start(
        audioFallbackUrl: String,
        audioHostUrl: String,
        meetingId: String,
        attendeeId: String,
        joinToken: String,
        audioMode: AudioMode,
        audioStreamType: AudioStreamType,
        audioRecordingPresetOverride: AudioRecordingPresetOverride,
        enableAudioRedundancy: Boolean
    )

    fun stop()
    fun setMute(isMuted: Boolean): Boolean
    fun setVoiceFocusEnabled(enabled: Boolean): Boolean
    fun isVoiceFocusEnabled(): Boolean
    fun promoteToPrimaryMeeting(credentials: MeetingSessionCredentials, observer: PrimaryMeetingPromotionObserver)
    fun demoteFromPrimaryMeeting()
}
