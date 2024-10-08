package com.example.ej03_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class Option(
    var checked: Boolean,
    var onCheckedChange: (Boolean) -> Unit = {},
    var label: String,
    var enable: Boolean = true
)
@Composable
fun CheckboxListExample(){
    val ingredientes = listOf("Tomate","Cebolla","Mostaza","Mayonesa","Patatas")
    val options = ingredientes.map {
        var checked by rememberSaveable { mutableStateOf(false) }
        Option(
            checked = checked,
            onCheckedChange = {checked = it},
            //se podria entender mejor puesto asi:
            //onCheckedChange = {myNewChecked -> checked.value = myNewChecked},
            label = it
        )
    }
    CheckBoxList(options = options, listTitle = "¿Cómo quieres la hamburguesa?")
}
@Composable
fun CheckBoxList(options:List<Option>,listTitle: String){
    Column {
        Text(listTitle, textAlign = TextAlign.Justify)
        Spacer(Modifier.size(16.dp))
        options.forEach{options ->
            LabelledCheckBox(
                checked = options.checked,
                onCheckedChange = options.onCheckedChange,
                label = options.label,
                enable = options.enable
            )
        }
    }
}


@Composable
fun CheckBoxExample(modifier:Modifier){
    val checked = remember{ mutableStateOf(true)}
    LabelledCheckBox(checked = checked.value,
        onCheckedChange = {checked.value = it},
        label = "Checkbox con etiqueta")
    }


@Composable
fun LabelledCheckBox(checked:  Boolean, onCheckedChange:(Boolean) -> Unit,
                  label:String,
                  //modifier:Modifier,
                  enable:Boolean= true,
                  color: CheckboxColors = CheckboxDefaults.colors()) {
    Row(
        modifier = Modifier.height(38.dp), verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(Modifier.width(15.dp))
        Text(label)
    }

    @Composable
    fun MyChekbox(modifier: Modifier) {
        var state by rememberSaveable { mutableStateOf(false) }
        Row(
            modifier = Modifier.height(45.dp), verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = state,
                onCheckedChange = { state = !state },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Yellow,
                    checkmarkColor = Color.Blue
                )
            )
            Spacer(Modifier.width(15.dp))
            Text(text = "Label")
        }
    }
}