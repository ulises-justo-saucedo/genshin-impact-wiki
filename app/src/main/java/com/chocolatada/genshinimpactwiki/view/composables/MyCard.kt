package com.chocolatada.genshinimpactwiki.view.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.chocolatada.genshinimpactwiki.R
import com.chocolatada.genshinimpactwiki.domain.dto.FieldMainScreenDTO
import com.chocolatada.genshinimpactwiki.view.BlueDT
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White

@Composable
fun MyCard(
    icon: Int? = null,
    iconUrl: String? = null,
    text: String,
    lambdaParameter: String,
    onClick: (String) -> Unit
) {
    var coilLoadedImage by remember { mutableStateOf(false) }
    Card(
        onClick = { onClick(lambdaParameter) },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 15.dp),
        colors = CardColors(BlueDT, White, BlueDT, White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            if(icon != null) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "$text icon",
                    modifier = Modifier.size(90.dp)
                )
            } else if(iconUrl != null) {
                if(!coilLoadedImage) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(60.dp)
                    )
                }
                AsyncImage(
                    model = iconUrl,
                    contentDescription = "$text icon",
                    modifier = Modifier.size(90.dp),
                    onSuccess = { coilLoadedImage = true }
                )
            }
            Text(
                text = text,
                color = White,
                fontFamily = GenshinImpactFont,
                modifier = Modifier.padding(end = 60.dp),
                fontSize = 20.sp
            )
        }
    }
}