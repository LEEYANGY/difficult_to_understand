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
//����һ��ͼ�ṹ
typedef struct Graph {
//    ����
    char *vertex;
//    ��
    int **edge;
//    ��������
    int vertexNum;
//    ������
    int edgeNum;
} Graph;

//����
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
* @Description: ��ʼ��ͼ�Ķ���
*/
GraphQueue *initGraphQueue() {
//    �����ڴ�ռ�
    GraphQueue *Q = (GraphQueue *) malloc(sizeof(GraphQueue));
    Q->front = Q->rear = 0;
    return Q;
}

// ��������
void printGraphQueue(GraphQueue *Q) {
//    ��Ҫ֪�������ж���Ԫ��
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

// �ж��Ƿ��ǿն���
int isEmptyGraphQueue(GraphQueue *Q) {
    if (Q->front == Q->rear) return 1;
    else return 0;
}

//��� TODO
int enGraphQueue(GraphQueue *Q, int data) {
    if (isFullGraphQueue(Q)) return 0;
    else {
        Q->data[Q->rear] = data;
        Q->rear = (Q->rear + 1) % MAXSIZE;
        return 1;
    }
}

//���� TODO
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
* @Description: ��ʼ��һ��ͼ
*/
Graph *initGraph(int vertexNum) {
//    ��ʼ��һ��ͼ
    Graph *G = (Graph *) malloc(sizeof(Graph));
//    Ϊͼ��������ڴ�
    G->vertex = (char *) malloc(sizeof(char) * vertexNum);
//    Ϊͼ�߷����ڴ�
    G->edge = (int **) malloc(sizeof(int *) * vertexNum);
//    ��Ϊ�߷����ڴ�
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
//        ����
        G->vertex[i] = vertex[i];
        // ������ڴ�
        G->edge[i] = (int *) malloc(sizeof(int) * G->vertexNum);
        for (int j = 0; j < G->vertexNum; ++j) {
//            �����
            G->edge[i][j] = *(edge + i * G->vertexNum + j);
            if (G->edge[i][j] == 0) ++G->edgeNum;
        }
    }
//    ����������ͼ����Ҫ/2���ܵõ���ȷ������
    G->edgeNum /= 2;
}

/**
* @Param:
* @return: 
* @Author: liyangyang
* @Date: 2023/11/6 18:07
* @Description: �����������
*/
void bfs(Graph *G, int *visited, int index) {
//    ��ʼ������
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
* @Description: �����������
*/
void dfs(Graph *G, int *visited, int index) {
//    �ȷ���
    cout << G->vertex[index];
//    �޸�visited����ʾ�Ѿ������ʹ���
    visited[index] = 1;
    for (int i = 0; i < G->vertexNum; ++i) {
        if (G->edge[index][i] == 1 && !visited[i]) dfs(G, visited, i);
    }
}

#endif //DATASTRUCT_GRAPH_H
