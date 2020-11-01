# Android Clean Architecture
[![agustiyann](https://circleci.com/gh/agustiyann/Android-Clean-Architecture.svg?style=svg)](https://circleci.com/gh/agustiyann/Android-Clean-Architecture)
![GitHub](https://img.shields.io/github/license/agustiyann/Android-Clean-Architecture?color=blue)
![GitHub last commit](https://img.shields.io/github/last-commit/agustiyann/Android-Clean-Architecture?color=informational)

## What is Clean Architecture?
Clean Architecture is a software engineering development architecture created by Uncle Bob (**Robert C. Martin**). The essence of this architecture is separation of concern. So that we can read the code in the project more easily.

In addition, the main idea of ​​using Clean Architecture is to produce a system that is **Independent of Framework**, **Testable**, **Independent of UI**, **Independent of Database**, and **Independent of External**.
This is an overview to represent Clean Architecture suggested by Robert C. Martin:
<img src="images/clean arch layer.jpeg">

## Use this pattern in an Android project
In a typical android project it is divided into 3 layers like this:
<img src="images/android representation.jpeg">

 - **Presentation Layer** contains the UI and Presenter / ViewModel which will control the views. This UI will depend heavily on the Use Case.
 - **Domain Layer** contains Entities, Use Case, Repository Interface. This is the most core layer and is associated with business processes.
 - **Data Layer** contains Repository Implementation and DataSource which can be Local DataSource (database) and Remote DataSource (network).

## Modularization
Modularization is a technique of breaking an Android project into sections called modules. With modularization we will get a lot of advantages over implementing the monolith (only one part) in our project.
<img src="images/app module.PNG">

<img src="images/core module.PNG">

<img src="images/favorite module.PNG">

## Tech stack & Open-source libraries

 -   [Kotlin](https://kotlinlang.org/)  based,  [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)  +  [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)  for asynchronous.
 - [Koin](https://insert-koin.io) for dependency injection.
 - Jetpack Libraries
	-   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify domain layer data to views.
	-   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - UI related data holder, lifecycle aware.
	-   [Room Persistence](https://developer.android.com/topic/libraries/architecture/room) - construct a database using the abstract layer.
 - Architecture
	 -   MVVM Architecture (View - DataBinding - ViewModel - Model)
	 -   Repository pattern
 -   [Glide](https://github.com/bumptech/glide) - loading images.
 -   [Retrofit2 & OkHttp3](https://github.com/square/retrofit)  - construct the REST APIs and paging network data.
 -   [Gson](https://github.com/google/gson)  - JSON representation.
 -   [Timber](https://github.com/JakeWharton/timber)  - logging.
 -   [Material-Components](https://github.com/material-components/material-components-android)  - Material design components.
 - [Leak Canary](https://square.github.io/leakcanary/) - memory leak detection library for Android.
 - Security
	 - [SQLCipher](https://www.zetetic.net/sqlcipher/) - protecting data.
	 - ProGuard - disguise the code so that it is difficult to read by others after reverse engineering.
	 - Certificate Pinning - secure connection from mobile to server.
 - [Lottie](https://lottiefiles.com/) - displays animation in JSON format.
 - [Shimmer](https://facebook.github.io/shimmer-android/) - create a shimmer effect on the application.
 
 ## License
 ```
    Copyright 2020 Agus Tiyansyah Syam

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 ```
