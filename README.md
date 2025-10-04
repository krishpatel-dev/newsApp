📰 News App (Android)

A Kotlin-based Android application that fetches and displays the latest news using [NewsAPI](https://newsapi.org).  
The app shows articles in a clean, scrollable list with images, headlines, and descriptions.

---

✨ Features

- Fetches real-time news from **NewsAPI**  
- Pull-to-refresh support (SwipeRefreshLayout)  
- Clean and responsive UI with **Material Design 3**  
- Display news in a **RecyclerView with CardViews**  
- Efficient image loading using **Coil**  
- REST API integration using **Retrofit + Gson**

---

🛠 Tech Stack

- **Language**: Kotlin  
- **Networking**: Retrofit + Gson  
- **Image Loading**: Coil  
- **UI Components**: RecyclerView, SwipeRefreshLayout, MaterialCardView  
- **API**: [NewsAPI](https://newsapi.org)  

---

📂 Project Structure

newsApp/
│
├── app/ # Android app module
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/... # Kotlin source files
│ │ │ └── res/ # Layouts, drawables, values
│ └── AndroidManifest.xml
│
├── gradle/ # Gradle wrapper files
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
└── README.md


---

🚀 Getting Started

1. Clone the repository
bash
git clone https://github.com/krishpatel-dev/newsApp.git

2. Get a NewsAPI key

Go to NewsAPI
Create a free account and get your API key

3. Add API key in project

In your local.properties or BuildConfig, add:
NEWS_API_KEY="YOUR_API_KEY_HERE"

4. Run the project

Open the project in Android Studio
Sync Gradle and run on an emulator or device
