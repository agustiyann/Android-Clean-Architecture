# Clean Architecture
[![agustiyann](https://circleci.com/gh/agustiyann/Android-Clean-Architecture.svg?style=svg)](https://circleci.com/gh/agustiyann/Animesuta)

## What is Clean Architecture?
Clean Architecture is a software engineering development architecture created by Uncle Bob (**Robert C. Martin**). The essence of this architecture is separation of concern. So that we can read the code in the project more easily.

In addition, the main idea of ​​using Clean Architecture is to produce a system that is **Independent of Framework**, **Testable**, **Independent of UI**, **Independent of Database**, and **Independent of External**.
This is an overview to represent Clean Architecture suggested by Robert C. Martin:
<img src="images/clean arch layer.jpeg">

## Use this pattern in an Android project
In a typical android project it is divided into 3 layers like this:
![enter image description here](https://lh3.googleusercontent.com/fife/ABSRlIqal0uS1cxwInpaGil0r6F7i1d9D0sqvYESBucJFi_J-KTZ3qFYi52x8d2_yg7neRtMVNufa3vGxmd9JzLxGiO8L4zjgWTUiT9f3RoTw_pWdEXm68AUkS_xlp-kOPPvwjMPY0L092q6bv3iOqh0dxLZeVQj0bwa62rqxFs3TYlPAbOew2z4QZiDuc3jiLXotCO_WLPPZ_csXO0nYsU-ImfmhAGPnURwLilJVwA0W-6dp310r7ugf48NnTUdO1AMHvUDaLWzMdUOp8hrOxpIm3ViSfcXtD_zU7khUIti5EpZW8LGPev3iGo5InRJ6mh3A1j6sWx00uXigQY2OtQiib3fDdWtej9wNAdBheqS1ByAlIBwdH2mbsWumOse9NdzyLpQcok-f3acj3ZhCYjiuZJg1Zn46HxiyqberQvIJGxAKMjUegza8kK6ynTYJtNarSOhTNhqmI8eCzethnP3evuHP_n77bn-CTfqc4AskQHx-G8atNI1ozPFoJzj0yi4OvtR8b7Dr0sGIbTNxiihDN_4eewhYsxAJs8kml7DD3IqU8FPNYI2V78kake1o2KEytxAJI3ob2oKzOE2tazDrWNazbfwxIH06q3X5XAq4baQ-mNEXtKzWRqWLt4O5b9el_XA7vVKHEJOKysT1yDzMXY5lFQHj86cGNv-AAfKTS_Yk6ECwaZjooGsAfQdWLQG5llTXsc2Shd2KvvwqDi_R9gqp1sVHRdc8gu1=s1280-w1280-h720-no?authuser=0)

 - **Presentation Layer** contains the UI and Presenter / ViewModel which will control the views. This UI will depend heavily on the Use Case.
 - **Domain Layer** contains Entities, Use Case, Repository Interface. This is the most core layer and is associated with business processes.
 - **Data Layer** contains Repository Implementation and DataSource which can be Local DataSource (database) and Remote DataSource (network).

## Modularization
Modularization is a technique of breaking an Android project into sections called modules. With modularization we will get a lot of advantages over implementing the monolith (only one part) in our project.
![enter image description here](https://lh3.googleusercontent.com/JsIhXR4fJwC-Cmz1-fHIxlMFg_b3vKV1Bd-CwKRZN3AfaQhD_VhtpkrHmGw0cDkHkv6LDUieMIv_wMUxid-4CMdusCvV-SHeHA8Su9Y_WCw-mEFcae60eO5MgQMpzMbXMRVg5scJUJ9xRZwe7fs1U_PneFdCjphMMshd_GaQTd-7uoWlZW2sO8JzCT0d1cclqvpFiVC4EddldM6DXQCAmJ1Vvi_8lYLNYrM_6CEo1Fktesj6d-OGP61THXS__sJeQ6QYvItzJxT4Ee1DzLiJXDMi8144w8idtlHerLW6EhaChzGOluylnFBemyJfV1hzq28YDDD2VumJ1DhzjYdtkKSWCJ8b78_9x1NpWbfFX5De-gZx6sHscSJVinY22sjXuT0tLIe8f7HPosDiDmBtLrizcnTpJKdiDP8YOUHg-CiKTXvQCIf9uT_AW5u43ZzArLq5GjtSvArdrjbsPFwcBGsiHLTJNajosRzmPXx-sFIjfCHZvKfqixYwvkA5LtCZZj9BwoipJ-e1mombS59ezR6irvRy-cgFmC4GEbAHB5kYessVwJt_BU8hEruGOQggyuiZNch8lh6FgK36YhGkHSgmwXIYZdYT7xIVeZzl6h8s0Bd__oz8OlOrN3qg9xYl4UK2P5iVsWPdMfvmT4cRgZDavkUi5y8YhTcbraUm6bVaY1-4Nt75eOptdH-i=w589-h306-no?authuser=0)![enter image description here](https://lh3.googleusercontent.com/HKQH9QYvJjGxGkN1VAqrhP2sabTSxvHglYILEnkJStCJkiApoEsm-nNFjtY1-QkVsKOJMD4gwWdnYRV6n80XuXBQNcJPKs76QH0odJZZKBOaWe9HrLy071VrC6YnMkQVn9E8sC7DBC5aymSMVCI08McgzU6aRQjYRN08aAB-D3yLgi3PDSLMq8_9I8cYWUKqzb-qeZsD8OgdoDF6epQTuKTIeYOsPusT8Fzu7vtHxqtZVhAdE1V4ALh9duqwOL00izTqvjpSPm_hp9t63DQLeNyuJa0RpnwW-zDCITnJx-IvcGVOSzbpc0fm2X_4H6igcpmciFSFG-ugrL3Xnxdv9K9jfRon1-6k-c-jn0ZFA_ldc3ajKX-Od8IU6ZZ7o-wRyVfVwENSg6fmD_Uejjjng_ZG8lk0WjeHQ78tGFOJdWgq8atlBZo_pQpHFRMzFWAlKf0A9lNBxl5OV4Dpz-Esk4l-p-kfnIojwtfAVc7RZ0pMYfSOueoLUbGaAH7-SWgatmvB81Ong3TENvlZIMZWwe4kC7Mj5VrnFSvn1s7FdHn_z1iCHuMqIUjCbxyNjhk44IkKVnMcybYvqbQQaiKm4SAE7pr5sBWS9m4rwi-MJ_ZBoGf6_YBZWIIRwXQDAzFRe3DfnD-my-5JBQ0swlCJybWwoNW1m1jqBmyRh8stDDgu2ScAg68QLpDmfaLl=w539-h402-no?authuser=0)![enter image description here](https://lh3.googleusercontent.com/7fJNhhnYJC7F82oKWChjHHygGxSRq4VMl_5pNcK7Y5gKjW4wJ_25xy3c4TK_7xx8CZnwv8wsl_ecY-u_eOfChQ0RaryXafVtuUu_-zFLUCR2E2zoYERXeNwYxSUMVPObiWptvmuAYG57TDBOSGwKXBJrXzvinvl4upp-Yq53R74vDPm48FryVGf67k0oR73Hx2epy-pGe57PjksnueirXj4K2r9eGxDi8adh9FnzKBV84xBDJJjGD7zgRdsJq_WrtDzwzuBOh78oQsC0u_FM70H0iOjbuZgYcOyacIdHrBL8ClXe7hlvw9B4aNKIK8uJlx-iHUs8PGbzyQpcJ7R2NiyB3-UsjFC1vZ-NYaQlgkjHJ0mTbkpHW2sUtwZXBXv1hThYEvrEolu0zvQ2J0ZijmXiaeGWnZo9kG0QF7k_a-eVlK9tfx6pwhZ4-BH6iryrhCmvZVsEW4Ggj6YsPMQ0lCYHWV4ozqyM1G24X8cujRqtaZNsgTIB0Tlynw6Ubh0yV0LQJ3vRWtUXFZPmlv2RysGP39nmoQWJh3bYMhM8CPLLMTN-DnfYWxrmMftK0k3HKn66FFYDJal7mfY12_S1-D46qIsypNIbtn2KKB_T0LKQEs5k4WuZzoFzCCMSlpamQjR_5OVST4snKi2qRiT-5aqpmiP2HOtGb3jWVECOnKsDZM9Ri41h7sV4-o1d=w506-h223-no?authuser=0)

## Tech stack & Open-source libraries

 -   [Kotlin](https://kotlinlang.org/)  based,  [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)  +  [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)  for asynchronous.
 - [Koin](https://insert-koin.io) for dependency injection.
 - Jetpack Libraries
	-   LiveData - notify domain layer data to views.
	-   Lifecycle - dispose of observing data when lifecycle state changes.
	-   ViewModel - UI related data holder, lifecycle aware.
	-   Room Persistence - construct a database using the abstract layer.
 - Architecture
	 -   MVVM Architecture (View - DataBinding - ViewModel - Model)
	 -   Repository pattern
 -   [Glide](https://github.com/bumptech/glide),  [GlidePalette](https://github.com/florent37/GlidePalette)  - loading images.
 -   [Retrofit2 & OkHttp3](https://github.com/square/retrofit)  - construct the REST APIs and paging network data.
 -   [Moshi](https://github.com/square/moshi/)  - A modern JSON library for Kotlin and Java.
 -   [Timber](https://github.com/JakeWharton/timber)  - logging.
 -   [Material-Components](https://github.com/material-components/material-components-android)  - Material design components.
 - [Leak Canary](https://square.github.io/leakcanary/) - memory leak detection library for Android.
 - Security
	 - [SQLCipher](https://www.zetetic.net/sqlcipher/) - protecting data.
	 - ProGuard - disguise the code so that it is difficult to read by others after reverse engineering.
	 - Certificate Pinning - secure connection from mobile to server.
 - [Lottie](https://lottiefiles.com/) - displays animation in JSON format.
 - [Shimmer](https://facebook.github.io/shimmer-android/) - create a shimmer effect on the application.
