
<h1 align="center">Wearable Wisdom</h1>

**Wearable Wisdom** is a smartwatch app built with **Flutter** and **Spring Boot**, delivering a fresh motivational quote each day on your Wear OS device.

<p align="center">
  <img src="https://github.com/adarshpandey18/wearable-wisdom/blob/main/resources/demo.gif" alt="Wearable Wisdom Watch Demo" width="280"/>
</p>

---

##  Features

- Daily quote selection powered by Spring Boot
- Flutter Wear OS app with clean UI
- Random quote rotation via scheduler
- PostgreSQL-backed persistence
- REST API integration with Provider
- Gesture-based interaction (tap to refresh quote)

---

## Tech Stack

| Layer        | Tech Used                  |
|--------------|----------------------------|
| **Frontend** | Flutter (Wear OS), Provider |
| **Backend**  | Spring Boot (Java)         |
| **Database** | PostgreSQL                 |
| **API**      | RESTful JSON               |
| **Dev Tools**| Postman, DBeaver           |

---

## Project Structure

<details>
<summary>Click to expand folder structure</summary>

```

📦 wearable\_wisdom\_ui/
├── lib/
│   ├── constants/
│   ├── models/
│   ├── providers/
│   ├── screens/
│   ├── services/
│   ├── theme/
│   ├── utils/
│   └── widgets/
├── android/  ios/  macos/  web/  windows/
├── pubspec.yaml

```
```

📦 wearable\_wisdom\_api/
├── src/
│   ├── main/
│   │   ├── java/com/adarsh/wearable/wearable\_wisdom\_api/
│   │   │   ├── advice/
│   │   │   ├── configs/
│   │   │   ├── controllers/
│   │   │   ├── dtos/
│   │   │   ├── entities/
│   │   │   ├── repositories/
│   │   │   ├── scheduler/
│   │   │   ├── services/
│   │   │   └── WearableWisdomApplication.java
│   │   └── resources/
│   │       ├── application.properties

````

</details>

---

## API Endpoints

| Method | Endpoint                | Description             |
|--------|-------------------------|-------------------------|
| `POST` | `/wearable-wisdom/api/post`   | Add a single quote       |
| `GET`  | `/wearable-wisdom/api/random` | Get a random quote       |
| `GET`  | `/wearable-wisdom/api/daily`  | Get today’s daily quote  |

---

## Running the App

### Backend (Spring Boot)

```bash
cd wearable_wisdom_api
./mvnw spring-boot:run
````

> Make sure PostgreSQL is running and configured in `application.properties`.

### Frontend (Flutter)

```bash
cd wearable_wisdom_ui
flutter run
```

> Use a Wear OS emulator or physical device.

---

## License

This project is licensed under the [MIT License](LICENSE)

---

## 🌱 Coming Soon

* Admin dashboard to manage quotes
* Offline support with Hive

