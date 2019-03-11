package chap18;

import java.io.File;

/*
 * File Ŭ���� ����
 *    - ���� �� ������ ������ �����ϴ� Ŭ���� 
 *       => ������ ������  ����Ǵ� ����, ���� �Ұ���. => ����� ��Ʈ���� ����ؾ� ��
 *    - �������� �ʾƵ� ������ ������.
 */
public class FileEx1 {
	public static void main(String[] args) {
		String filePath = "c:\\";
		File f1 = new File(filePath);// c:\ ��������
		String files[] = f1.list(); //  c:\ ��������,���� �̸� ���
		for(String f : files) {
			File f2 = new File(filePath,f); //��������,����(����)��
			if(f2.isDirectory()) //���丮?
				System.out.printf("%s : ���丮\n",f); //f : ���� ��
			else if(f2.isFile()){ //����?
				System.out.printf("%s : ����(%,d ����Ʈ)\n",f,f2.length());
			}
		}
	}
}
