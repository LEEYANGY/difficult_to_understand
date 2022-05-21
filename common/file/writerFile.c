//
// Created by LEEYANGY on 2022/5/21.
//

#include "../common.h"

//文件路径由于是在服务器上做测试的，暂时写死
char filename[100]="/tmp/tmp.XScG2EA2hw/out/test.txt";
/**
 *
 * @param filename
 */
void saveFile(struct student *head){
//    定义一个文件指针 writefile-->wf
    FILE *wf= fopen(filename,"aw");
    fprintf(wf,"%s ",head->name);
    fprintf(wf,"%d ",head->id);
    fprintf(wf,"%.2lf ",head->score_c);
    fprintf(wf,"%.2lf\n",head->score_web);
    fclose(wf);
}

/**
 * 检查文件是否打开成功
 * @param filename
 * @return
 */
int checkfile(){

    FILE *wf;
    if((wf= fopen("/tmp/tmp.XScG2EA2hw/out/test.txt","wb"))==NULL){
        printf("打开文件失败\n");
        return 0;
    }
    return 1;
}
