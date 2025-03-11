package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist
import com.okproject.musicexplorer.ui.preview.providers.SimplifiedPlaylistProvider
import com.okproject.musicexplorer.ui.theme.Dimens
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun InfocardContainer(
    title: String,
    image: String,
    subtitle: String? = null,
    description: String? = null,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(Dimens.mediumPadding),
        shape = RoundedCornerShape(Dimens.smallCornerRadius)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Dimens.largePadding,
                    vertical = Dimens.mediumPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ElevatedCard(
                modifier = Modifier.wrapContentSize(),
                shape = RectangleShape
            ) {
                AsyncImage(
                    modifier = Modifier.size(75.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    placeholder = rememberVectorPainter(Icons.Rounded.PlayArrow),
                    contentScale = ContentScale.Fit,
                    contentDescription = null
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Dimens.largePadding,
                    vertical = Dimens.mediumPadding
                )
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (subtitle != null) {
                    Spacer(modifier = Modifier.height(Dimens.mediumPadding))
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.labelSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (description != null) {
                    Spacer(modifier = Modifier.height(Dimens.mediumPadding))
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun InfocardContainerPreview(
    @PreviewParameter(SimplifiedPlaylistProvider::class) data: SimplifiedPlaylist
) {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            InfocardContainer(
                title = data.name,
                image = data.image,
                subtitle = data.owner,
                description = data.description,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}