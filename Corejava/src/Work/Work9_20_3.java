package Work;

import java.util.*;

public class Work9_20_3 {
	public static void main(String[] args) {
		// ����map����б�ŵĹ���վ��
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "�ֶ����԰");
		map.put(2, "�д����");
		map.put(3, "��ҵ����");
		map.put(4, "����ѧԺ");
		map.put(5, "���κ�ׯ");
		map.put(6, "����·����·");
		map.put(7, "�ĺ���԰");
		map.put(8, "з�г�");
		map.put(9, "����·ӭ��·");
		map.put(10, "õ��԰");
		map.put(11, "�Ǳ���·��ͤ·");
		map.put(12, "�����о���");
		map.put(13, "������");
		map.put(14, "����ɽ��");
		map.put(15, "����ѧԺ ");
		map.put(16, "��ɽ·˼��·");
		map.put(17, "ɭ�ֹ�԰");
		map.put(18, "ɭ�ְ뵺");
		map.put(19, "��ɽ·¹��· ");
		map.put(20, "�������");
		// ��������ֵ,���ڴ�Ź���վ�ı��
		int start = 0;
		int end = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������ʼվ:");
		String strStart = scanner.nextLine();
		// �ж���ʼվ�ı�Ų����
		for (int key = 1; key <= map.size(); key++) {
			String s = map.get(key);
			if (strStart.equals(s)) {
				start = key;
				break;
			}
		}
		// �ж��Ƿ������һ��
		if (start == 0) {
			System.out.println("���ϴ���");
		} else {
			// ���뵽��վ���ж�
			System.out.println("�����뵽��վ:");
			String strEnd = scanner.nextLine();
			for (int key = 1; key <= map.size(); key++) {
				String t = map.get(key);
				if (strEnd.equals(t)) {
					end = key;
					break;
				}
			}
			// �ж��Ƿ������һ��
			if (end == 0) {
				System.out.println("���ϴ���");
			} else {
				// ����վ
				int a = Math.abs(start - end);
				// �жϳ���
				if (a <= 4) {
					System.out.println("��" + strStart + "��" + strEnd + "��" + a + "վ,�շ�" + 1 + "Ԫ");
				}
				if (a > 4 && a <= 8) {
					System.out.println("��" + strStart + "��" + strEnd + "��" + a + "վ,�շ�" + 2 + "Ԫ");
				}
				if (a > 8 && a <= 12) {
					System.out.println("��" + strStart + "��" + strEnd + "��" + a + "վ,�շ�" + 3 + "Ԫ");
				}
				if (a > 12 && a <= 16) {
					System.out.println("��" + strStart + "��" + strEnd + "��" + a + "վ,�շ�" + 4 + "Ԫ");
				}
				if (a > 16) {
					System.out.println("��" + strStart + "��" + strEnd + "��" + a + "վ,�շ�" + (a - 16 + 4) + "Ԫ");
				}
			}
		}
	}

}
