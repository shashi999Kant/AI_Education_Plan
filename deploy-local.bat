@echo off

REM Define the deployment directory
set "DEPLOY_DIR=C:\Users\Satyam Tiwari\Documents\workspace-spring-tool-suite-4-4.19.1.RELEASE\aiExamPortal"

REM Create the deployment directory if it doesn't exist
if not exist "%DEPLOY_DIR%" mkdir "%DEPLOY_DIR%"

REM Copy the JAR file to the deployment directory
copy target\aiExamPortal-0.0.1-SNAPSHOT.jar "%DEPLOY_DIR%"

REM Optionally, start the Spring Boot application
java -jar "%DEPLOY_DIR%\aiExamPortal-0.0.1-SNAPSHOT.jar"
