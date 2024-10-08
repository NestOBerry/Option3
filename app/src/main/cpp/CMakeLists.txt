cmake_minimum_required(VERSION 3.10)

project("NativeEncryption")

# Set the C++ standard to C++17
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

# Add the shared library
add_library( # Locates the Android logging library to be used in the native code
        native-lib
        SHARED
        src/main/cpp/native-lib.cpp )

# Find the log library
find_library(
        log-lib
        log )

# Link the log library to native-lib
target_link_libraries( native-lib ${log-lib} )
