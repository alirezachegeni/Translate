package com.example.translatetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.translatetest.ui.Home
import com.example.translatetest.ui.HomeViewModel
import com.example.translatetest.ui.theme.TranslateTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranslateTestTheme {
                // A surface container using the 'background' color from the theme
                val context = LocalContext.current.applicationContext
                val repository = (context as App).repository
                Home(homeViewModel = viewModel(
                    factory = HomeViewModel.provideFactory(
                        repository = repository,
                        application = application
                    )
                )
                )
            }
        }
    }
}

