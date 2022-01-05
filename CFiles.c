//
// Created by LEEYANGY on 2022/1/1.
//
#include "stdio.h"
#include "math.h"
#include "stdlib.h"
#include "string.h"
/**
 *
 *  C���ļ��Ķ��壺
 *      C���ļ�����һ���ַ�(���ֽڣ������У���һ�����ַ����ֽڣ���˳����ɣ�һ�������������������һ���ַ������ֽ����������Ƕ��������ݣ�
 *  C�������ļ� �� ��֮�䲻���Զ����У����ļ��Ĵ�ȡ�����ַ����ֽڣ�Ϊ��λ��
 *
 *  �����ļ����ࣺ
 *      ��Ϊ ASCII �� �������ļ�
 *
 *          �������ڴ������Զ�������ʽ�洢�����������ת�����������棬���Ƕ������ļ�
 *          ������Ϊ�����Ǵ洢���ڴ������ӳ������Ҳ��֮Ϊ ӳ���ļ� ��Image file��
 *
 *          ���Ҫ������������ASCII������ʽ�洢������Ҫ����ת����ASCII�ļ��ֳ��ı��ļ�(Text File)
 *          ÿ���ֽ��ļ���һ���ַ���ASCII����
 *
 *      ��ô�洢��
 *          �ַ�һ����ASCII��ʽ�洢����ֵ�����ݼȿ�����ASCII��ʽ�洢��Ҳ����ʹ�ö�������ʽ�洢
 *
 *
 *
 *  FILE *fp;
 *  fopen ����
 *  "r"	��һ�����ڶ�ȡ���ļ������ļ�������ڡ�
 *  "w"	����һ������д��Ŀ��ļ�������ļ��������Ѵ��ڵ��ļ���ͬ�����ɾ�������ļ������ݣ��ļ�����Ϊһ���µĿ��ļ���
 *  "a"	׷�ӵ�һ���ļ���д�������ļ�ĩβ׷�����ݡ�����ļ������ڣ��򴴽��ļ���
 *  "r+"	��һ�����ڸ��µ��ļ����ɶ�ȡҲ��д�롣���ļ�������ڡ�
 *  "w+"	����һ�����ڶ�д�Ŀ��ļ���
 *  "a+"	��һ�����ڶ�ȡ��׷�ӵ��ļ���
 *
 * @return
 */
int main(void){

//    �����ļ�ָ��
    FILE *fIn;
    FILE *fOut;

    //�ļ���
    char fInName[100];
    char fOutName[100];
//    �ȴ��û�������ַ���
    char fContext;

//    �ж��ļ��Ƿ���ڣ���������ڣ����ֶ�����
    printf("Please input file name:\n");
    scanf("%99s",fInName);
//    ���ļ������ΪNULL����ʾʧ��
    if ( ( fIn = fopen(fInName,"r") ) == NULL ){
        printf("Open failed\n");
        if ( ( fOut = fopen(strcpy(fOutName,fInName),"w") ) == NULL ){
            printf("Creation failed\n");
        } else{
            printf("Working for you create file\n");
            printf("Please input char , if you want exit please in put #  to end write:");
//    ��һ�ζ����û��Ӽ���������ַ���
            fContext=getchar();
//    д��һ���ļ�
            while (fContext != '#'){
//        �����д��һ���ļ�
                fputc(fContext,fOut);
//        �Ӽ��̻�ȡ�û����������
                fContext=getchar();
            }
            printf("File created successfully\n");
        }
    } else{
        printf("This file already exists,open success ! \n");
    }
    //    �ر��ļ�,�൱��ˢ���ļ�
    fclose(fIn);
    fclose(fOut);

//    ��ѯ�ļ��Ƿ�д��ɹ�
//    printf("Please in put file name:\n");
//    scanf("%99s",fInName);
//    ���ļ������ΪNULL����ʾʧ��
    if ( ( fIn = fopen(fInName,"r") ) ==NULL ){
        printf("Open failed,file does not exist");
//        ��ֹ����
//        exit(0);
    } else{
        printf("Open successfully!\n");
//      ��ָ���ļ��ж�ȡ����
        fContext=fgetc(fIn);
//      �ļ���ȡ����eof�Ļ�
        while ( !feof(fIn) ){
//            ���ļ��е����ݷ��������Ļ��
            fputc(fContext,fOut);
//          �ٴ�ָ���ļ��ж�ȡ����
            putchar(fContext);
//          ��ָ���ļ��ж�ȡ����
            fContext=fgetc(fIn);
        }
    }

//    �ر��ļ�
    fclose(fIn);
    fclose(fOut);
    return 0;
}
