package com.example.demo23082024.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun ConfirmationDialog (
    openAlertDialog : MutableState<Boolean>,
    onConfirmation : () -> Unit
){
    when {
        openAlertDialog.value -> {
            AlertDialog(
                icon = {
                    Icon(Icons.Filled.Warning, contentDescription = "Example Icon")
                },
                text = {
                    Text(text = "Are you sure you want to log out?")
                },
                onDismissRequest = {
                    openAlertDialog.value = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onConfirmation()
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openAlertDialog.value = false
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}