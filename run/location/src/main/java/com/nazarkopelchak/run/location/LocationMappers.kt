package com.nazarkopelchak.run.location

import android.location.Location
import com.nazarkopelchak.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.nazarkopelchak.core.domain.location.Location(
            latitude = latitude,
            longitude = longitude
        ),
        altitude = altitude
        )
}