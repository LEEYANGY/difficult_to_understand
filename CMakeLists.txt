cmake_minimum_required(VERSION 3.27)
project(server)

set(CMAKE_CXX_STANDARD 11)

add_executable(server main.cpp
        class/Box.h
        alg/binSearch.h
        class/animal/Animal.h
        class/animal/Dog.h
        class/shape/Shape.cpp
        class/shape/Shape.h
        class/shape/Rectangle.cpp
        class/shape/Rectangle.h
        class/shape/PaintCost.h
        class/Line.cpp
        class/Line.h
        class/SmailBox.h
)
