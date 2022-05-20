#include <iostream>
#include <vector>
#include <cstring>
#include <memory>

using namespace std;

/**
 * 在c++中，可以间接的将struct认为是class
 */

/**
 * 测试数据：
 *        10 20 30 40 50 60 70 80 90 100 0
 *
 * 查找元素：
 *        20
 *
 * 删除元素：
 *        50
 *
 * 添加元素
 *        尾插 110 ok
 *
 *
 */

struct linknode{
    int val;
    linknode *next;
};

//函数声明
void printfLinkNode(linknode *p);
linknode *creatLinkNode(void);
linknode *delLinkNode(linknode *head,int del);
linknode *insertLinkNode(linknode *head,int insert,int site);
linknode *modifyData(linknode *head,int before_modify,int after_modify);
void searchLinkNode(linknode *head,int searchData);
int main() {
//    正常链表
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

//    遍历链表
void printfLinkNode(linknode *head){
    while(head!= nullptr){
        cout << head->val << " ";
        head=head->next;
    }
}

linknode *creatLinkNode(void){
    //    定义头节点
    linknode *head= new linknode;
    linknode *current =new linknode;
    linknode *ln = new linknode;
//    new class/struct
//    head= new linknode;
//    head->val=110;
//    head->next= nullptr;
//    插入元素到链表
//    current = head;
    head= nullptr;
    cout << "请输入一个整形数据(输入0结束): " << endl;
    cin >> current->val;
    while (current->val!=0){
//        判断链表是否存在
        if(head== nullptr){
//            拿到current记录的地址
            head=current;
        } else {
            ln->next=current;
        }
        ln=current;
        current = new linknode;
        cin >> current->val;
    }
//    结尾补上一个尾巴
    ln->next= nullptr;
    return head;
}
/**
 * 删除操作思路:
 *          找到元素后，把当前的
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
             * 通过调试可以知道，p1现在的位置是上一个地址，
             * p2现在指在下一个地址上
             * 我们找到的这个元素把下一个也就是p2的地址给指向p1
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

//指定位置插进去
linknode *insertLinkNode(linknode *head,int insert,int site){
//    创建两个指针，current指向head头指针
    linknode *current=head;
//    开辟一个内存空间
    linknode *ln=new linknode;
    ln->val=insert;
//    记录位置  判断链表是否为空
    while(current->next!= nullptr){
//        找位置插进去
        if(site==current->val){
            ln->next=current->next;
            current->next=ln;
            break;
        } else{
//            current向后移动
            current=current->next;
        }
    }
//    在末尾插入
    if(current->next == nullptr){
        ln->next=current->next;
        current->next=ln;
    }
    return head;
}

//改指定的元素
linknode *modifyData(linknode *head,int before_modify,int after_modify){
    linknode *current=head;
    while (current!= nullptr){
        if(before_modify==current->val){
//            找到后修改
            current->val=after_modify;
            break;
        }else{
//            指针向后移动
            current=current->next;
        }
    }
    return head;
}

//查找指定元素
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
    cout << "-------欢迎使用学生管理系统--------";
    /**
     * 正常的尾插数据
     */
    cout << "--------1.添加学生---------------";
    /**
     * 搜索进行删除
     */
    cout << "--------2.删除学生---------------";
    /**
     * 读取文件
     */
    cout << "--------3.打开文件---------------";
    /**
     * 直接删除整个保存的数据
     */
    cout << "--------4.删除数据(不可逆操作，谨慎!)";
    /**
     * 文件以乱序形式存储，打开后按需进行排序
     */
    cout << "--------5.保存数据---------------";
}

