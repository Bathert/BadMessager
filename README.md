# Bad Chat

Bad Chat is a simple Android chat application that stores messages in
[Firebase Realtime Database](https://firebase.google.com/docs/database).
The project was originally created as a learning exercise and contains a
minimal UI for sending and displaying short text messages.

## Features

- Realtime messaging backed by Firebase
- RecyclerView with a custom adapter to display messages
- Basic input validation: empty messages and messages longer than
  150 characters are rejected
- A random numeric identifier is assigned to each user on startup

## Project structure

```
app/src/main/java/com/example/batth/bad_chat_v3/   # Activity and adapter classes
app/src/main/res/                                 # Layouts, drawables and strings
```

Firebase configuration is expected to be placed in `app/google-services.json`.

## Build

1. Ensure that the Android SDK and build tools are installed and that the
   `ANDROID_HOME` environment variable is set.
2. Run Gradle to build a debug APK:

   ```bash
   ./gradlew assembleDebug
   ```

The generated APK can be found under `app/build/outputs/apk/` and can be
installed on an Android device or emulator.

## License

This project is provided as-is without any specific license.

