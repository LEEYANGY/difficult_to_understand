#include "common/common.h"
int main() {
//    ��������
    struct student *current = creatLinkList();
//    ��ӡ���
    printLinkList(current);
    printf("����������ִ�гɹ���-----------\n");
//    ��id���룬�岻����ʧ��
    current=insert(current,1004,1001);
//    ��ӡ���
    printLinkList(current);
    printf("����Ԫ�غ���ִ�гɹ�-------------\n");
//    ����һ��ѧ��1004��ѧ��
    searchID(current,1004);
    printf("����Ԫ�غ���ִ�гɹ�--------------\n");
//    ��id�޸�
    current= modify(current,1001,1002);
    printLinkList(current);
    printf("�޸�Ԫ�غ���ִ�гɹ�--------------\n");
//    ��idɾ��Ԫ��
    current=del(current,1004);
    printLinkList(current);
    printf("ɾ��Ԫ�غ���ִ�гɹ�--------------\n");
    freeLinkList(current);
    printf("�ͷ��ڴ溯��ִ�гɹ�--------------\n");
    return 0;
}
