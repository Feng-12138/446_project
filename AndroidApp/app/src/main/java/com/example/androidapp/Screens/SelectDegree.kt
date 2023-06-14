package com.example.androidapp.Screens
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController


@Composable
fun SelectDegree(navController: NavController){
    val context = LocalContext.current
    val programs = arrayOf("Computer Science", "Cappuccino", "Espresso", "Latte", "Mocha")
    val years = arrayOf("2018-2019", "2019-2020", "2020-2021", "2021-2022", "2022-2023")
    val sequences = arrayOf("Sequence 1", "Sequence 2", "Sequence 3", "Sequence 4")
    val minors = arrayOf("Computing", "CO", "Stats", "PMath")
    val specializations = arrayOf("Not Applicable", "Software Engineering", "Business Administration", "Computer Hardware")

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            Modifier
                .fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            SelectList(programs, context)
            SelectList(years, context)
            SelectList(sequences, context)
            SelectList(minors, context)
            SelectList(specializations, context)
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .height(60.dp)
                .widthIn(200.dp),
            onClick = { /* Handle button click */ }
        ) {
            Text("Generate Schedule")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectList(choices: Array<String>, context:Context){
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(choices[0]) }

    Box(Modifier.padding(12.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                choices.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

