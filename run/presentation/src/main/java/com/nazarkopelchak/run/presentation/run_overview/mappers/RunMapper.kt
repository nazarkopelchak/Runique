package com.nazarkopelchak.run.presentation.run_overview.mappers

import com.nazarkopelchak.core.domain.run.Run
import com.nazarkopelchak.core.presentation.ui.formatted
import com.nazarkopelchak.core.presentation.ui.toFormattedKm
import com.nazarkopelchak.core.presentation.ui.toFormattedMeters
import com.nazarkopelchak.core.presentation.ui.toFormattedPace
import com.nazarkopelchak.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd yyyy - HH:mma")
        .format(dateTimeInLocalTime)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKm(),
        maxSpeed = maxSpeedKmh.toFormattedKm(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl

    )
}