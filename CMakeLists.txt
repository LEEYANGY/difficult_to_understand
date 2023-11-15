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
        string/KMPMatch.h
        tree/tree.h
        tree/treeNonRecursive.h
        tree/tagTree/inThreadTree.h
        tree/solver/treeMaxDepth.h
        tree/bst/bstTree.h
        tree/bst-avl/avlTree.h
        tree/huffman/huffmanTree.h
        graph/graph.h
        tree/btree/BTree.h
)
