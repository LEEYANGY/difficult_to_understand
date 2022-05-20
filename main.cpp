#include <iostream>
#include <vector>
#include <cstring>
#include <memory>

using namespace std;

/**
 * ��c++�У����Լ�ӵĽ�struct��Ϊ��class
 */

/**
 * �������ݣ�
 *        10 20 30 40 50 60 70 80 90 100 0
 *
 * ����Ԫ�أ�
 *        20
 *
 * ɾ��Ԫ�أ�
 *        50
 *
 * ���Ԫ��
 *        β�� 110 ok
 *
 *
 */

struct linknode{
    int val;
    linknode *next;
};

//��������
void printfLinkNode(linknode *p);
linknode *creatLinkNode(void);
linknode *delLinkNode(linknode *head,int del);
linknode *insertLinkNode(linknode *head,int insert,int site);
linknode *modifyData(linknode *head,int before_modify,int after_modify);
void searchLinkNode(linknode *head,int searchData);
int main() {
//    ��������
    cout << "----You input the linklist:----" << endl;
    /**
     * test data
     *          10 20 30 40 50 0
     */
    linknode *current=creatLinkNode();
    printfLinkNode(current);

    cout << endl << "----del element after the linklist:----" << endl;
    /**
     * test data
     *          10 20 30 40 50 0
     */
    current=delLinkNode(current,50);
    printfLinkNode(current);

    cout << endl << "----you insert after linklist----" <<endl;
    /**
     *  test input data
     *                  10 20 30 40 50 0
     */
    current = insertLinkNode(current,50,40);
    printfLinkNode(current);

    cout << endl << "----you modify after linklist----" <<endl;
    /**
     *  test input data
     *                  10 20 30 40 50 0
     */
    current = modifyData(current,40,520);
    printfLinkNode(current);
    searchLinkNode(current,520);
    return 0;
}

//    ��������
void printfLinkNode(linknode *head){
    while(head!= nullptr){
        cout << head->val << " ";
        head=head->next;
    }
}

linknode *creatLinkNode(void){
    //    ����ͷ�ڵ�
    linknode *head= new linknode;
    linknode *current =new linknode;
    linknode *ln = new linknode;
//    new class/struct
//    head= new linknode;
//    head->val=110;
//    head->next= nullptr;
//    ����Ԫ�ص�����
//    current = head;
    head= nullptr;
    cout << "������һ����������(����0����): " << endl;
    cin >> current->val;
    while (current->val!=0){
//        �ж������Ƿ����
        if(head== nullptr){
//            �õ�current��¼�ĵ�ַ
            head=current;
        } else {
            ln->next=current;
        }
        ln=current;
        current = new linknode;
        cin >> current->val;
    }
//    ��β����һ��β��
    ln->next= nullptr;
    return head;
}
/**
 * ɾ������˼·:
 *          �ҵ�Ԫ�غ󣬰ѵ�ǰ��
 * @param head
 * @param del
 * @return
 */
linknode *delLinkNode(linknode *head,int del){
    linknode *prev,*current=head;
    cout << "head add = " << head->next << " head->val = " << head->val<< endl;
    while (current!= nullptr){
        cout << "current->next add = " << current->next << " " << "current->val = " << current->val << endl;
        if(del==current->val){
            /**
             * ͨ�����Կ���֪����p1���ڵ�λ������һ����ַ��
             * p2����ָ����һ����ַ��
             * �����ҵ������Ԫ�ذ���һ��Ҳ����p2�ĵ�ַ��ָ��p1
             *
             */
            prev->next=current->next;
            break;
        } else{
            prev=current;
            current=current->next;
        }
    }
//    cout << "current->next add = " << cu current->next << " " << "current->val = " << current->val << endl;
    return head;
}

//ָ��λ�ò��ȥ
linknode *insertLinkNode(linknode *head,int insert,int site){
//    ��������ָ�룬currentָ��headͷָ��
    linknode *current=head;
//    ����һ���ڴ�ռ�
    linknode *ln=new linknode;
    ln->val=insert;
//    ��¼λ��  �ж������Ƿ�Ϊ��
    while(current->next!= nullptr){
//        ��λ�ò��ȥ
        if(site==current->val){
            ln->next=current->next;
            current->next=ln;
            break;
        } else{
//            current����ƶ�
            current=current->next;
        }
    }
//    ��ĩβ����
    if(current->next == nullptr){
        ln->next=current->next;
        current->next=ln;
    }
    return head;
}

//��ָ����Ԫ��
linknode *modifyData(linknode *head,int before_modify,int after_modify){
    linknode *current=head;
    while (current!= nullptr){
        if(before_modify==current->val){
//            �ҵ����޸�
            current->val=after_modify;
            break;
        }else{
//            ָ������ƶ�
            current=current->next;
        }
    }
    return head;
}

//����ָ��Ԫ��
void searchLinkNode(linknode *head,int searchData){
    linknode *current=head;
    int flag=0;
    while(current->next!= nullptr){
        if(current->val==searchData){
            flag=1;
            break;
        } else{
            current=current->next;
        }
    }
    if(flag==1){
        cout << endl << searchData << " Found!";
    }else{
        cout << endl << searchData << " No Found!";
    }
}

void menu(){
    cout << "-------��ӭʹ��ѧ������ϵͳ--------";
    /**
     * ������β������
     */
    cout << "--------1.���ѧ��---------------";
    /**
     * ��������ɾ��
     */
    cout << "--------2.ɾ��ѧ��---------------";
    /**
     * ��ȡ�ļ�
     */
    cout << "--------3.���ļ�---------------";
    /**
     * ֱ��ɾ���������������
     */
    cout << "--------4.ɾ������(���������������!)";
    /**
     * �ļ���������ʽ�洢���򿪺����������
     */
    cout << "--------5.��������---------------";
}

