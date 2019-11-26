package com.daftmobile.android4beginners3

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class LoggingLifecycleObserver: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun log(owner: LifecycleOwner, event: Lifecycle.Event) {
        println("$owner went $event")
    }
}
