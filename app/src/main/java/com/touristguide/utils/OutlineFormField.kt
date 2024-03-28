package com.touristguide.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.touristguide.ui.theme.brown
import com.touristguide.ui.theme.red

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun OutlineFormField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.Sentences,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    horizontalPadding : Dp = 0.dp,
    verticalPadding : Dp = 3.dp,
    colors : TextFieldColors? = null,
    label : @Composable (() -> Unit)? = null,
) {

    OutlinedTextField(
        value = value,
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, capitalization = keyboardCapitalization),
        visualTransformation = visualTransformation,
        enabled = isEnabled,
        readOnly = readOnly,
        label = label,
        maxLines = 1,
        singleLine = true,
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp,
            color = Color.DarkGray, fontWeight = FontWeight.Medium),
        modifier = Modifier
            .padding(vertical = verticalPadding, horizontal = horizontalPadding)
            .fillMaxWidth()
            .focusable(false).clickable(onClick = onClick),
        colors = colors
            ?: TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = red,
                unfocusedBorderColor = red,
                disabledBorderColor = red,
            ),
        onValueChange = onValueChange,
        placeholder = {
            Text(placeholder, color = Color.Gray, fontSize = 16.sp)
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}