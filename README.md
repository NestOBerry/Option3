Prerequisites
1. Java Development Kit (JDK): Version 17 or higher
2. CMake: Version 3.10 or higher
3. Android Studio: For building and running the application

Compilation Steps
1. Open Android Studio:
Launch Android Studio and open the project.
2. Install Required SDKs:
Ensure the necessary Android SDKs are installed. Go to File > Project Structure > SDK Location.
3. Build the Project:
Navigate to Build > Rebuild Project in the menu. This will compile both Java and native C++ code.

Creating the JAR File
1. Open Terminal in Android Studio:
You can find the terminal at the bottom of the IDE.
2. Run the Gradle Command:
Execute the following command to create the JAR file:
./gradlew createJar
3. Locate the JAR File:
After successful execution, the JAR file will be located in the app/build/libs directory.

Running the Application
1. Open a Command Prompt or Terminal.
2. Navigate to the JAR Directory:
cd app/build/libs
3. Execute the JAR File:
java -jar your-app-name-1.0.jar
*Replace 'your-app-name' with the actual name of the JAR file.

Notes
*Make sure to have the public key URL correctly set in the application code.
*Ensure that your environment variables for Java and CMake are properly configured.
