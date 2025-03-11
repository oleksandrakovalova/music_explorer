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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.okproject.musicexplorer.ui.preview.providers.ImageItemProvider
import com.okproject.musicexplorer.ui.theme.Dimens
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

// TODO refactore to smaller items
@Composable
fun NumberedRowContainer(
    number: Int,
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null
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
        Surface (
            modifier = Modifier.size(40.dp),
            shape = CircleShape,
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = number.toString(),
                    modifier = Modifier.wrapContentSize().align(Alignment.Center),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
        Spacer(modifier = Modifier.width(Dimens.largePadding))
        Card(
            modifier = Modifier.wrapContentSize(),
            shape = RoundedCornerShape(Dimens.mediumCornerRadius),
            elevation = CardDefaults.outlinedCardElevation()
        ) {
            AsyncImage(
                modifier = Modifier.size(75.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
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
        }
    }
}

@PreviewLightDark
@Composable
fun NumberedRowContainerPreview(
    @PreviewParameter(ImageItemProvider::class) item: ImageItem
) {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NumberedRowContainer(
                number = 1,
                imageUrl = item.imageUrl,
                title = item.title,
                subtitle = item.subtitle
            )
        }
    }
}