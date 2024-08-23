@echo off
echo Starting Spring Boot application...

rem Navigate to backend directory and run Spring Boot application
start cmd /k "cd /d C:\Users\Asus\OneDrive\Desktop\My-Projects\Projects\Project_Cinema Website\backend && mvnw.cmd spring-boot:run"

rem Wait for 3 minutes (180 seconds) to ensure Spring Boot starts up properly
timeout /t 180

echo Starting React application...

rem Navigate to frontend directory and run React application
start cmd /k "cd /d C:\Users\Asus\OneDrive\Desktop\My-Projects\Projects\Project_Cinema Website\frontend && npm start"
