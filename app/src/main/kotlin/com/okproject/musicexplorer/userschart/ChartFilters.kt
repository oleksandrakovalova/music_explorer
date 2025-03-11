package com.okproject.musicexplorer.userschart

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.okproject.musicexplorer.R
import com.okproject.musicexplorer.domain.userschart.ChartPeriod
import com.okproject.musicexplorer.mapper.toChipId
import com.okproject.musicexplorer.ui.component.ChipItem


@Composable
internal fun chartPeriodFilters(): List<ChipItem> =
    listOf(
        ChipItem(
            id = ChartPeriod.YEAR.toChipId(),
            label = stringResource(R.string.year)
        ),
        ChipItem(
            id = ChartPeriod.SIX_MONTHS.toChipId(),
            label = stringResource(R.string.six_months)
        ),
        ChipItem(
            id = ChartPeriod.MONTH.toChipId(),
            label = stringResource(R.string.month)
        )
    )