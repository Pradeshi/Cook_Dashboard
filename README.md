Cook Dashboard

A simple meal management dashboard for aged care residents that tracks daily menus, resident conflicts (allergies/dislikes), and special requests. Built with Java Spring Boot for the backend API, this project serves structured meal data including images for each menu item.

🏗 Project Overview

The Cook Dashboard provides:

Daily menu display: Main, second option, and dessert with ingredients and images.

Conflict checking: Automatically checks if any resident has allergies or dislikes for the day's menu.

Special requests: Tracks residents’ special meal requests by date.

RESTful API: Exposes endpoints to retrieve and manage menu items, residents, and special requests.

This project was designed to simulate real-world meal planning for aged care facilities, with a focus on easy retrieval and conflict management.

📦 Features

Menu Management

Main dish, second option, and dessert.

Each menu item includes:

Name

Type (Main / Second Option / Dessert)

Ingredients

Image URL

Conflict Checking

Checks resident allergies and dislikes.

Returns list of residents who cannot consume a specific menu.

Special Requests

Tracks and displays meals requested by residents for the current date.

REST API Endpoints

GET /api/dashboard → Returns today's menu with conflicts and specials.

POST /api/residents → Add a resident.

GET /api/residents → Get all residents.

POST /api/specials → Add a special meal request.

GET /api/specials → Get all special requests.

💾 Sample Response from /api/dashboard
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
  "conflicts": ["John Doe", "Mary Smith"],
  "specialRequests": [
    {"residentName": "Alice Johnson", "mealRequested": "Extra Veggies"}
  ]
}

⚙️ Installation & Running

Clone the repository:

git clone https://github.com/yourusername/cook-dashboard.git
cd cook-dashboard


Build and run Spring Boot app:

./mvnw spring-boot:run


Test API with Postman:

GET http://localhost:8080/api/dashboard → Check today's menu.

POST http://localhost:8080/api/residents → Add a resident with JSON body.

POST http://localhost:8080/api/specials → Add a special request.

📝 Example Resident JSON
{
  "name": "John Doe",
  "allergies": ["Peanuts", "Broccoli"],
  "dislikes": ["Tomato Sauce"]
}

📝 Example Special Request JSON
{
  "residentName": "Alice Johnson",
  "mealRequested": "Extra Veggies",
  "date": "2026-01-21"
}

🔧 Tech Stack

Backend: Java 17, Spring Boot 7.0.2

Server: Embedded Tomcat

Data Storage: In-memory ArrayLists (for demo purposes)

Frontend (optional): Any client can consume the API (Postman, React, Angular, etc.)

💡 Future Improvements

Connect to a database (MySQL/PostgreSQL) for persistent storage.

Add a frontend dashboard with images and interactive menu selection.

Automatic meal suggestions based on dietary preferences.

Export menu reports for staff.
