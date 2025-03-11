package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.okproject.musicexplorer.ui.preview.providers.ImageItemProvider
import com.okproject.musicexplorer.ui.theme.Dimens
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun ImageContainer(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(Dimens.mediumCornerRadius),
            elevation = CardDefaults.outlinedCardElevation()
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth().aspectRatio(1.0f),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = rememberVectorPainter(Icons.Rounded.PlayArrow),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(Dimens.mediumPadding))
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = Dimens.mediumPadding),
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if (subtitle != null) {
            Spacer(modifier = Modifier.height(Dimens.mediumPadding))
            Text(
                text = subtitle,
                modifier = Modifier.padding(horizontal = Dimens.mediumPadding),
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(Dimens.mediumPadding))
    }
}

@PreviewLightDark
@Composable
fun ImageContainerPreview(
    @PreviewParameter(ImageItemProvider::class) item: ImageItem
) {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ImageContainer(
                imageUrl = item.imageUrl,
                title = item.title,
                subtitle = item.subtitle
            )
        }
    }
}