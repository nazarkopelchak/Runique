package com.nazarkopelchak.auth.data.di

import com.nazarkopelchak.auth.data.AuthRepositoryImpl
import com.nazarkopelchak.auth.data.EmailPatternValidator
import com.nazarkopelchak.auth.domain.AuthRepository
import com.nazarkopelchak.auth.domain.PatternValidator
import com.nazarkopelchak.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}