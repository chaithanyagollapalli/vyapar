<h1 align="center">Vyapar - A Businness and Inventory Manager App Clone</h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=23"><img alt="API" src="https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center">  
This is a an android project based on modern Android application tech-stacks and MVVM architecture. Tried new technologies like Jetpack Compose and Hilt. Used Room database to store the data. It can dynamically update the amounts depending on the entries of expenses and purchases. We also added an option to choose Hindi as the language used in app.
</p>

## App Screenshots

<table>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/44438444/111024224-77867180-8403-11eb-846b-4e62a6e78736.png" width="300"/></td>
    <td><img src="https://user-images.githubusercontent.com/44438444/111024236-8f5df580-8403-11eb-88fe-c910114f038c.png" width="300"/></td>
    <td><img src="https://user-images.githubusercontent.com/44438444/111024245-9c7ae480-8403-11eb-98e2-e2b7633a55d1.png" width="300"/></td>
  </tr>
 </table>

## Libraries & Tech Used
- Minimum SDK level 23
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous handling.
- [Hilt (stable)](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
- JetPack
  - LiveData - notify domain layer data to views.
  - Lifecycle - observing data when lifecycle state changes.
  - ViewModel - lifecycle aware UI related data holder.
  - [Compose](https://developer.android.com/jetpack/compose/setup#groovy) - for the main screen UI.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model) 
- [Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation) for hamburger menu navigation.

