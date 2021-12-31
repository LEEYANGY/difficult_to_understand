cmake_minimum_required(VERSION 3.21)
project(firstC C)

set(CMAKE_C_STANDARD 11)

add_executable(firstC main.c pointer.c Tic_Tac_Toe/Game.h Tic_Tac_Toe/Game.c learn_const.c strings.c structs.c structArrayList.c Link.c typedefs.c enums.c unions.c CFiles.c)
