package com.okproject.musicexplorer.main

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.okproject.musicexplorer.R
import com.okproject.musicexplorer.ui.preview.PreviewCombined
import com.okproject.musicexplorer.ui.theme.Dimens
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme
import kotlinx.coroutines.Dispatchers


@Composable
fun CurrentlyPlayingContent(
    modifier: Modifier = Modifier,
    title: String,
    artists: String,
    image: Bitmap?
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(Dimens.smallCornerRadius),
    ) {
        Column(
            modifier = Modifier
                .padding(Dimens.mediumPadding)
        ) {
            Text(
                text = stringResource(R.string.currently_playing),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(Dimens.mediumPadding))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier.wrapContentSize(),
                    shape = RectangleShape
                ) {
                    AsyncImage(
                        modifier = Modifier.size(60.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(image)
                            .dispatcher(Dispatchers.IO)
                            .crossfade(true)
                            .build(),
                        placeholder = rememberVectorPainter(Icons.Rounded.PlayArrow),
                        contentScale = ContentScale.Fit,
                        contentDescription = null
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1.0f)
                        .padding(Dimens.mediumPadding)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(Dimens.smallPadding))
                    Text(
                        text = artists,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@PreviewCombined
@Composable
fun CurrentlyPlayingContentPreview() {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CurrentlyPlayingContent(
                title = "Midnight",
                artists = "Lianne La Havas",
                image = null
            )
        }
    }
}