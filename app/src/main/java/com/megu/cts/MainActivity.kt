package com.megu.cts

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make the activity window transparent
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,  // Make the window not touchable
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )

        // Set the background to transparent
        window.setBackgroundDrawableResource(android.R.color.transparent)

        // Execute the command
        try {
            val processBuilder = ProcessBuilder("su", "-c", "input keyevent --longpress 3")
            processBuilder.redirectErrorStream(true)
            val process = processBuilder.start()
            process.waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Finish the activity so it doesn't block other content
        finish()
    }
}
