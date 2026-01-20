# 🍽 Cook Dashboard

A **meal management system** for aged care facilities.  
Provides daily menus, tracks resident dietary conflicts, and handles special meal requests.  
Built with **Java Spring Boot** and exposes a RESTful API.

---

## 🧩 Features

- **Daily Menu Display** – Main, second option, and dessert with ingredients and images.  
- **Conflict Checking** – Identifies residents with allergies or dislikes for the day's menu.  
- **Special Requests** – Tracks meals requested by residents for a specific date.  
- **REST API** – Easily accessible endpoints to manage menus, residents, and requests.

---

## 🚀 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/dashboard` | GET | Returns today's menu, conflicts, and special requests |
| `/api/residents` | GET | Retrieves all residents |
| `/api/residents` | POST | Add a new resident |
| `/api/specials` | GET | Retrieves all special requests |
| `/api/specials` | POST | Add a special meal request |

---

## 📝 Sample JSON Response

```json
{
  "mealTime": "Dinner",
  "menu": {
    "main": {
      "name": "Grilled Chicken",
      "type": "Mains",
      "ingredients": ["Chicken", "Salt", "Pepper"],
      "imageUrl": "https://unsplash.com/photos/cooked-dish-mjcJ0FFgdWI"
    },
    "secondOption": {
      "name": "Veggie Pasta",
      "type": "Second Option",
      "ingredients": ["Pasta", "Broccoli", "Tomato Sauce"],
      "imageUrl": "https://via.placeholder.com/400x200"
    },
    "dessert": {
      "name": "Fruit Salad",
      "type": "Dessert",
      "ingredients": ["Apple", "Banana", "Grapes"],
      "imageUrl": "https://via.placeholder.com/400x200?text=Fruit+Salad"
    }
  },
  "conflicts": ["John Doe"],
  "specialRequests": [
    {"residentName": "Alice Johnson", "mealRequested": "Extra Veggies"}
  ]
}
---

## ⚙️ Installation

1. **Clone the repository**  
```bash
git clone https://github.com/Pradeshi/cook-dashboard.git
cd cook-dashboard

2.**Build the project**
```bash
./mvnw clean install


3.**Run the Spring Boot application**

./mvnw spring-boot:run