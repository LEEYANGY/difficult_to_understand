cmake_minimum_required(VERSION 3.27)
project(DataStruct)

set(CMAKE_CXX_STANDARD 11)

add_executable(DataStruct main.cpp
        linklist/singlelinklist.h
        linklist/doublelinklist.h
        linklist/looplinklist.h
        linklist/staticlinklist.h
        linklist/doublelooplinklist.h
        string/forceMatch.h
)
