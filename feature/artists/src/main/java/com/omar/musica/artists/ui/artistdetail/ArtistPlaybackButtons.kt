package com.omar.musica.artists.ui.artistdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Shuffle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun ArtistPlaybackButtons(
    modifier: Modifier,
    onPlay: () -> Unit,
    onShuffle: () -> Unit
) {

    Row(modifier = modifier) {
        LargeArtistButton(
            modifier = Modifier.weight(1f),
            icon = Icons.Rounded.PlayArrow,
            title = "Play",
            color = MaterialTheme.colorScheme.primaryContainer,
            onClick = onPlay
        )
        Spacer(modifier = Modifier.width(8.dp))
        LargeArtistButton(
            modifier = Modifier.weight(1f),
            icon = Icons.Rounded.Shuffle,
            title = "Shuffle",
            color = MaterialTheme.colorScheme.secondaryContainer,
            onClick = onShuffle
        )
    }
}


@Composable
fun LargeArtistButton(
    modifier: Modifier,
    icon: ImageVector,
    title: String,
    color: Color,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .drawBehind { drawRect(color) }
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = icon, contentDescription = title)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = title, fontWeight = FontWeight.Medium)
        }

    }

} 