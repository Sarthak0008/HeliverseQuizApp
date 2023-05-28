# HeliverseQuizApp
# Base Url - heliversequizapp-production.up.railway.app
# create a Quiz

   - URL: https://heliversequizapp-production.up.railway.app/create

   - Method: POST

   - Request Body:
    
    {
        "question": "What is your name?",
        "options": ["Ram", "Sarthak", "Rahul", "Amit"],
        "rightAnswerIndex": 1,
        "startDate": "2023-05-29T09:35",
        "endDate": "2023-05-29T09:40"
        
    }
    
       Response Body:

    {
        "id": 1,
        "question": "What is your name?",
        "options": ["Ram", "Sarthak", "Rahul", "Amit"],
        "rightAnswerIndex": 1,
        "startDate": "2023-05-29T09:35",
        "endDate": "2023-05-29T09:40,
        "status": "INACTIVE"
    }
 ###  Get Active Quizzes
   - URL: https://heliversequizapp-production.up.railway.app/active

   - Method: GET

   - Description: Get a list of active quizzes (quizzes that are currently between their start time and end time).

   - Response Body:

    [
        {
         "id": 1,
        "question": "What is your name?",
        "options": ["Ram", "Sarthak", "Rahul", "Amit"],
        "rightAnswerIndex": 1,
        "startDate": "2023-05-29T09:35",
        "endDate": "2023-05-29T09:40,
            "status": "ACTIVE"
        },
        ...
    ]
    
   ### Get Quiz Result
   -  URL: https://heliversequizapp-production.up.railway.app/{id}/result
   -  Method: GET
   - Description: Get the result of a quiz by its ID.
   - Path Variable:
   - {id}: ID of the quiz
   - Response Body:

         {
          "question": "What is your name?",
          "options": ["Ram", "Sarthak", "Rahul", "Amit"],
          "answer": "Sarthak"
          }
          
### Get All Quizzes
   - URL: https://heliversequizapp-production.up.railway.app/all
   - Method: GET
   - Description: Get a list of all quizzes.
   - Response Body:
    
          {
               "id": 1,
             "question": "What is your name?",
             "options": ["Ram", "Sarthak", "Rahul", "Amit"],
             "rightAnswerIndex": 1,
             "startDate": "2023-05-29T09:35",
             "endDate": "2023-05-29T09:40,
              "status": "INACTIVE"
          }
