//
// Created by LEEYANGY on 2022/5/21.
//

#include "../common.h"

/**
 *  fwrite 和 fread  向二进制文件读写数据的函数
 *  用法：
 *      第一个参数是buffer 常用来把地址传入，
 *      第二个参数 数据块的大小 单位 字节
 *      第三个参数 是要读写多少项
 *      第四个参数 文件指针
 *  演示：
 *  struct youstructtype[];
 *  FILE *fp=fopen(内容省略)；
 *  fwrite(fp
 */

void readFile() {
    char filename[100] = "/tmp/tmp.XScG2EA2hw/out/test.txt";
    struct student *head;
    struct student stu[100];
    FILE *wf = fopen(filename, "r");
    for (int i = 0; i < 5; ++i) {
        fscanf(wf, "%s %d %lf %lf", stu[i].name, &stu[i].id, &stu[i].score_c, &stu[i].score_web);
//        fscanf(wf,"%s",stu[i].name);
//        fscanf(wf,"%d",&stu[i].id);
//        fscanf(wf,"%lf",&stu[i].score_c);
//        fscanf(wf,"%lf",&stu[i].score_web);

        printf("%-20s %5d %.2lf %.2lf\n", stu[i].name, stu[i].id, stu[i].score_c, stu[i].score_web);
    }
//    int i=0;
//    while (fscanf(wf,"%s",stu[i].name)!=-1){
//        fscanf(wf,"%s %d %lf %lf",stu[i].name,&stu[i].id,&stu[i].score_c,&stu[i].score_web);
////        fscanf(wf,"%d",&stu[i].id);
////        fscanf(wf,"%lf",&stu[i].score_c);
////        fscanf(wf,"%lf",&stu[i].score_web);
//        printf("%-20s %5d %.2lf %.2lf\n",stu[i].name,stu[i].id,stu[i].score_c,stu[i].score_web);
//        i++;
//    }
//    int flag=0;
//    while(flag){
//        if(head==NULL)
//    }
    fclose(wf);
}