# Runique - A Modern Android Running Tracker

Runique is a multi-module running tracker Android application built entirely with Jetpack Compose.

## 📝 Project Overview

Runique allows users to track their runs in real-time using the Google Maps API. It's designed as an "offline-first" application, ensuring a seamless user experience even without a stable internet connection. All run data is initially saved to a local Room database.
When a connection becomes available, the data is automatically synchronized with a remote server, ensuring user data is always backed up and accessible across sessions.

## ✨ Key Features

- Real-Time Run Tracking: Utilizes Google Maps API to draw the user's path and track key metrics like distance and time.
- Offline-First Architecture: Runs are saved to a local Room database, allowing the app to be fully functional offline.
- Automatic Data Sync: Intelligently syncs local data with the remote server once an internet connection is established.
- Secure Authentication: Implements a complete OAuth 2.0 system with token management and automatic token refresh.
- 100% Jetpack Compose: The entire UI is built with Jetpack Compose, showcasing a modern, declarative UI approach.
- Multi-Module Architecture: The codebase is organized into logical, decoupled modules for better scalability and maintainability.
- Clean Architecture: Follows Clean Architecture principles to create a separation of concerns, making the code easier to test and understand.

## 🏛️ Architecture

This project follows a clean, multi-module architecture to promote separation of concerns and reusability.
- Multi-Module Setup: The project is divided into several modules:
  - `:app` The main application module that integrates all other modules.
  - `:core` Contains shared utilities, data storage, base classes, and helper functions used across the application.
  - `:auth` A feature module containing all logic related to user authentication (login, registration, token handling).
  - `:run` A feature module responsible for run tracking, location logic, and presentation.
  - `:build-logic` A module which contains conventional plugins for gradle

## 🛠️ Tech Stack & Dependencies

- **UI:** Jetpack Compose for building the declarative UI.
- **Asynchronous Programming:** Kotlin Coroutines & Flow for managing background threads and data streams.
- **Dependency Injection:** Koin for managing dependencies.
- **Database:** Room for local, persistent storage.
- **Networking:** Ktor for making API calls.
- **Architecture Components:** ViewModel, Lifecycle.
- **Maps:** Google Maps API for location tracking and map display.
