# TriviaApp
Simple trivia app built for QuadSolutions
# Setup
Open two terminals both at the root of the project. We'll call them terminalAPI and terminalReact.
## terminalAPI
Open the backend folder and type "mvn clean install package". This should build the .jar file we want to run.
Now type "java -jar target" and press tab twice. You should get something like this: "java -jar .\target\api-0.0.1-SNAPSHOT.jar" if you're in windows powershell.
Press enter and the API should be up and running!
## terminalReact
Open the frontend folder and open a terminal. Type "npm install" to download and install all of the dependencies and then type "npm run start" to run the development server.
Now checkout the application on http://localhost:3000. Have fun!

# Testing
## backend
You can run the tests by going into the backend folder and opening a terminal. Now type "mvn clean install test".
The tests should be running now!
## Postman
If you would like to checkout the API without the frontend. You can use Postman by copying this link, https://www.getpostman.com/collections/5452dafc8573bba3ecda, to Postman and checking out the available requests!
