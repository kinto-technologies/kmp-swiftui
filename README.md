# SwiftUI in Compose Multiplatform of KMP

This project is a demonstration of integrating SwiftUI into Compose Multiplatform of Kotlin Multiplatform (KMP). It showcases the interoperability between SwiftUI, a declarative UI framework for Swift, and Compose Multiplatform, a declarative UI framework for Kotlin.
This project is the part of article [SwiftUI in Compose Multiplatform of KMP](https://blog.kinto-technologies.com/posts/2024-03-07-swiftui-in-compose-multiplatform/) of KINTO Tech Blog. Please read the blog for step by step process of SwiftUI integration into Compose Multiplatform.

## Overview

This is a Kotlin Multiplatform project targeting Android, iOS.
The primary goal of this project is to illustrate how SwiftUI views can be seamlessly incorporated into a Kotlin Multiplatform project leveraging Compose Multiplatform. By bridging SwiftUI with Compose Multiplatform, developers can create cross-platform applications with a unified codebase, combining the strengths of both frameworks.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)

## Getting Started

### Prerequisites

- Xcode with Swift support.
- Android Studio or IntelliJ IDEA with Kotlin Multiplatform Plugin installed.

### Installation

1. Clone this repository to your local machine.
   ```bash
   git clone https://github.com/kinto-technologies/kmp-swiftui.git
   ```

2. Open the project in Android Studio or IntelliJ IDEA.

3.  Replace [YOUR_API_KEY] with your API key for Gemini in [ApiService](composeApp/src/commonMain/kotlin/data/ApiService.kt)

4. Open the `iosApp` directory in Xcode.

5. Build and run the project on your desired platform.

Here, we used API key directly into ApiService. But in actual project, provide your API key with secure way, like adding into `local.properties` and providing through gradle build config way. You can use [BuildKonfig](https://github.com/yshrsmz/BuildKonfig) library for providing API key though gradle in your Multiplatform project.

## Usage

Explore the project to understand how SwiftUI views are integrated into the Compose Multiplatform project. Experiment with modifying the SwiftUI components and observe the changes reflected in the cross-platform application.

## Acknowledgements

Thanks to the developers of SwiftUI and Compose Multiplatform for their amazing work in advancing cross-platform UI development. And this project is inspired and based by [Chat](https://github.com/JetBrains/compose-multiplatform/tree/master/examples/chat) application of KMP samples. So, special thanks to the developer(s) of that Chat Application.