package com.daftmobile.android4beginners4.lights


data class Luminosity(val lux: Float) {
    val fractionOfIndoorLight = lux/600f
}
