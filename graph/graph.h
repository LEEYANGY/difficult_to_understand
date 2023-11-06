/**
******************************************************************************  
* File Name      : graph.h  
* Author         : leeyangy  
* E-mail         : liyangyang0713@foxmail.com  
* Create         : 2023/11/6 17:06  
******************************************************************************  
*/

#ifndef DATASTRUCT_GRAPH_H
#define DATASTRUCT_GRAPH_H

#include <iostream>

#define MAXSIZE 5

using namespace std;
//定义一个图结构
typedef struct Graph {
//    顶点
    char *vertex;
//    边
    int **edge;
//    顶点数量
    int vertexNum;
//    边数量
    int edgeNum;
} Graph;

//队列
typedef struct GraphQueue {
    int front;
    int rear;
    int data[MAXSIZE];
} GraphQueue;

/**
* @Param: [ *G ]
* @return:
* @Author: liyangyang
* @Date: 2023/11/6 18:14
* @Description: 初始化图的队列
*/
GraphQueue *initGraphQueue() {
//    开辟内存空间
    GraphQueue *Q = (GraphQueue *) malloc(sizeof(GraphQueue));
    Q->front = Q->rear = 0;
    return Q;
}

// 遍历队列
void printGraphQueue(GraphQueue *Q) {
//    想要知道队列有多少元素
    int length = (Q->rear - Q->front + MAXSIZE) % MAXSIZE;
    int index = Q->front;
    for (int i = 0; i < length; ++i) {
        cout << Q->data[index];
        index = (index + 1) % MAXSIZE;
    }
    cout << endl;
}

int isFullGraphQueue(GraphQueue *Q) {
    if ((Q->rear + 1) % MAXSIZE == Q->front) return 1;
    else return 0;
}

// 判断是否是空队列
int isEmptyGraphQueue(GraphQueue *Q) {
    if (Q->front == Q->rear) return 1;
    else return 0;
}

//入队 TODO
int enGraphQueue(GraphQueue *Q, int data) {
    if (isFullGraphQueue(Q)) return 0;
    else {
        Q->data[Q->rear] = data;
        Q->rear = (Q->rear + 1) % MAXSIZE;
        return 1;
    }
}

//出队 TODO
int deGraphQueue(GraphQueue *Q) {
    if (isEmptyGraphQueue(Q)) return -1;
    else {
        int data = Q->data[Q->front];
        Q->front = (Q->front + 1) % MAXSIZE;
        return data;
    }
}

/**
* @Param: [ vertexNum, edgeMun ]
* @return:
* @Author: liyangyang
* @Date: 2023/11/6 17:09
* @Description: 初始化一个图
*/
Graph *initGraph(int vertexNum) {
//    初始化一个图
    Graph *G = (Graph *) malloc(sizeof(Graph));
//    为图顶点分配内存
    G->vertex = (char *) malloc(sizeof(char) * vertexNum);
//    为图边分配内存
    G->edge = (int **) malloc(sizeof(int *) * vertexNum);
//    在为边分配内存
//    for (int i = 0; i < vertexNum; ++i) G->edge = (int **) malloc(sizeof(int) * vertexNum);
    G->vertexNum = vertexNum;
    G->edgeNum = 0;
    return G;
}

/**
* @Param: [ *G, *ch, vertexNum ]
* @return:
* @Author: liyangyang
* @Date: 2023/11/6 17:16
* @Description:
*/
void createGraph(Graph *G, char *vertex, int *edge) {
    for (int i = 0; i < G->vertexNum; ++i) {
//        顶点
        G->vertex[i] = vertex[i];
        // 分配边内存
        G->edge[i] = (int *) malloc(sizeof(int) * G->vertexNum);
        for (int j = 0; j < G->vertexNum; ++j) {
//            分配边
            G->edge[i][j] = *(edge + i * G->vertexNum + j);
            if (G->edge[i][j] == 0) ++G->edgeNum;
        }
    }
//    由于是无向图，需要/2才能得到正确变数量
    G->edgeNum /= 2;
}

/**
* @Param:
* @return: 
* @Author: liyangyang
* @Date: 2023/11/6 18:07
* @Description: 广度优先搜索
*/
void bfs(Graph *G, int *visited, int index) {
//    初始化队列
    GraphQueue *Q = initGraphQueue();
    cout << G->vertex[index];
    enGraphQueue(Q,index);
    visited[index] = 1;
    while (!isEmptyGraphQueue(Q)){
        int i = deGraphQueue(Q);
        for (int j = 0; j < G->vertexNum; ++j) {
            if (G->edge[i][j] == 1 && !visited[j]) {
                cout << G->vertex[j];
                visited[j]=1;
                enGraphQueue(Q,j);
            }
        }
    }
}

/**
* @Param:
* @return:
* @Author: liyangyang
* @Date: 2023/11/6 18:08
* @Description: 深度优先搜索
*/
void dfs(Graph *G, int *visited, int index) {
//    先访问
    cout << G->vertex[index];
//    修改visited，表示已经被访问过了
    visited[index] = 1;
    for (int i = 0; i < G->vertexNum; ++i) {
        if (G->edge[index][i] == 1 && !visited[i]) dfs(G, visited, i);
    }
}

#endif //DATASTRUCT_GRAPH_H
