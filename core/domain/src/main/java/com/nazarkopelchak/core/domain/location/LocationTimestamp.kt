package com.nazarkopelchak.core.domain.location

import kotlin.time.Duration

data class LocationTimestamp(
    val location: Location,
    val timestamp: Duration
)
