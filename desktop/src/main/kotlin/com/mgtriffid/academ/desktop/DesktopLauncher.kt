package com.mgtriffid.academ.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mgtriffid.academ.client.AcademLauncher

fun main(args: Array<String>) {
    val config = LwjglApplicationConfiguration()
    LwjglApplication(AcademLauncher(), config)
}
