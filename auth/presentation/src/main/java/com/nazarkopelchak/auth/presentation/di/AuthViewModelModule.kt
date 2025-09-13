package com.nazarkopelchak.auth.presentation.di

import com.nazarkopelchak.auth.presentation.login.LoginViewModel
import com.nazarkopelchak.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}