package com.nazarkopelchak.run.presentation.active_run

import com.nazarkopelchak.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(val error: UiText): ActiveRunEvent
    data object RunSaved: ActiveRunEvent
}