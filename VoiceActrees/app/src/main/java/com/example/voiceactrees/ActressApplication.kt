package com.example.voiceactrees

import android.app.Application
import com.example.voiceactrees.data.actresses
import com.example.voiceactrees.repositories.ActressRepository

class ActressApplication:Application() {
    val actressRepository: ActressRepository by lazy {
        ActressRepository(actresses)
    }
}