cmake_minimum_required(VERSION 3.21)
project(studentManager C)

set(CMAKE_C_STANDARD 99)

add_executable(studentManager main.c common/common.h common/display.c common/counter.c common/freeLinkList.c common/insert.c common/printLinkList.c common/creatLinkList.c common/del.c common/modify.c common/searchID.c)
