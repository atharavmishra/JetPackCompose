package android.myapplication.jetpackcompose

import android.myapplication.jetpackcompose.ui.theme.Shapes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(){
    var expandedState by remember { mutableStateOf(false) }
    val rotationstate by animateFloatAsState(targetValue = if (expandedState)180f else 0f )
    Card(modifier = Modifier
        .fillMaxSize()
        .animateContentSize(
            animationSpec = tween(
                delayMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
        shape = Shapes.medium,
        onClick = {
            expandedState = !expandedState
        }){
        Column(modifier = Modifier.fillMaxWidth()) { Row(verticalAlignment = Alignment.CenterVertically){
            Text(modifier = Modifier.weight(6f), text = "Atharv ",
                fontSize = MaterialTheme.typography.h6.fontSize, 
                fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            IconButton(modifier  = Modifier
                .alpha(ContentAlpha.medium)
                .weight(1f)
                .rotate(rotationstate),
                onClick = { expandedState = !expandedState }) { Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Drop Down Arrow"
            )
                
            }

        }
            if(expandedState)(Text(text = "Atharv +++++++++++++++++++++++++++++++++++++++++++"))
            
        }

    }
}
@Composable
@Preview
fun preview (){
    ExpandableCard()
}
