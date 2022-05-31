package com.example.translatetest.ui

import com.example.translatetest.model.Model


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Home(
    homeViewModel: HomeViewModel,
) {
    val orange = Color(0XffFF6347)
    val state = homeViewModel.state.value
    var query by remember {
        mutableStateOf("")
    }
    var translate by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp), contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = {
                    Box(contentAlignment = Alignment.Center) {

                        Text(
                            text = if (translate == "fa") {
                                "One Word like ..."
                            } else {
                                "... کلمه مورد نظر وارد کنید"
                            }, color = Color.Unspecified
                        )
                    }
                },
                maxLines = 1,
                shape = RoundedCornerShape(//topEnd = 15.dp, topStart = 15.dp
                    15.dp
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.DarkGray,
                    unfocusedBorderColor = Color.DarkGray,
                ),

                )

            Spacer(modifier = Modifier.height(15.dp))

//            Card(
//                shape = RoundedCornerShape(10.dp),
//                modifier = Modifier.size(30.dp),
//                backgroundColor = Color.Cyan
//            ) {
//                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                    Text(text = translate, color = orange)
//                }
//            }

            Spacer(modifier = Modifier.height(5.dp))

            Box(contentAlignment = Alignment.Center) {
                Row() {
                    Button(
                        onClick = { translate = "en" },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
                    ) {
                        Text(text = "to english", color = Color.Cyan)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = { translate = "fa" },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
                    ) {
                        Text(text = "to persian", color = Color.Cyan)
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { homeViewModel.getTranslate(query, translate) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "translate", color = orange, fontSize = 14.sp)
                }

            }
            text(query = state.query, text = translate)
        }
    }
}

@Composable
fun text(
    query: Model?, text: String
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {

        query?.translate?.let { Text(text = " $it", fontSize = 25.sp, color = Color.DarkGray) }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .width(2.dp)
        )

    }
}

