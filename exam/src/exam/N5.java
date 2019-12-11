package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
 
/*��ʱ��λ�����Ĺ�������Ƴ���һ���뽫�����ݾ�������İ��š�
���������뽫��Э���ü����������(��������)����Ӧ�ľ��°��ź��ƽⷽ��:
���ְ���:����]
0248:��ҹ͵Ϯ
1357:��������
2678:��������
ĳ�ξ����ж���������-������"wgfieorzouhtrrot"д��ֽ�� ��,�������Ž�ֽ������������Ӫ��������ֽ��
֮�����ϻ��⿪ʼ�������ģ��ܿ����ֽ���·�д��������������0248 (zerotwofourright), ��ʼ�˳ﱸ��ҹ
������ս�ƻ�...
(ע��:�������������������Զ��������Сд��ĸ�鲻����ֳ������ַ��벻�ɴ���ĵ�����ĸ���)
���ݽ�����ֽ�������µ�����������������Ϊ������д-�γ�����԰����������������������������Ӧ��
���ְ��ţ���д�±��˼·��*/

public class N5 {
	public String deCode(String cipher) {
		String result = "";
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		char[] c = cipher.toCharArray();
		for(int i = 0; i< c.length; i++) {
			map.put(c[i], map.getOrDefault(c[i], 0)+1);
		}
		if(map.containsKey('z')) {
			result+=0;
			map.put('z', map.get('z')-1);
			map.put('e', map.get('e')-1);
			map.put('r', map.get('r')-1);
			map.put('o', map.get('o')-1);
			if(map.get('o')==0)map.remove('o');
		}
		if(map.containsKey('w')) {
			result+=2;
			map.put('w', map.get('w')-1);
			map.put('t', map.get('t')-1);
			map.put('o', map.get('o')-1);
			if(map.get('o')==0)map.remove('o');
			if(map.get('t')==0)map.remove('t');
		}
		if(map.containsKey('u')) {
			result+=4;
			map.put('f', map.get('f')-1);
			map.put('o', map.get('o')-1);
			map.put('u', map.get('u')-1);
			map.put('r', map.get('r')-1);
			if(map.get('o')==0)map.remove('o');
			if(map.get('f')==0)map.remove('f');
		}
		if(map.containsKey('x')) {
			result+=6;
			map.put('x', map.get('x')-1);
			map.put('s', map.get('s')-1);
			map.put('i', map.get('i')-1);
			if(map.get('s')==0)map.remove('s');
			if(map.get('i')==0)map.remove('i');
		}
		if(map.containsKey('g')) {
			result+=8;
			map.put('e', map.get('e')-1);
			map.put('i', map.get('i')-1);
			map.put('g', map.get('g')-1);
			map.put('h', map.get('h')-1);
			map.put('t', map.get('t')-1);
			if(map.get('t')==0)map.remove('t');
			if(map.get('i')==0)map.remove('i');
		}
		if(map.containsKey('o')) {
			result+=1;
			map.put('o', map.get('o')-1);
			map.put('n', map.get('n')-1);
			map.put('e', map.get('e')-1);
		}
		if(map.containsKey('t')) {
			result+=3;
			map.put('t', map.get('t')-1);
			map.put('h', map.get('h')-1);
			map.put('r', map.get('r')-1);
			map.put('e', map.get('e')-2);
		}
		if(map.containsKey('f')) {
			result+=5;
			map.put('f', map.get('f')-1);
			map.put('i', map.get('i')-1);
			map.put('v', map.get('v')-1);
			map.put('e', map.get('e')-1);
			if(map.get('i')==0)map.remove('i');
		}
		if(map.containsKey('s')) {
			result+=7;
			map.put('e', map.get('e')-2);
			map.put('v', map.get('v')-1);
			map.put('s', map.get('s')-1);
			map.put('n', map.get('n')-1);
		}
		if(map.containsKey('i')) {
			result+=9;
			map.put('e', map.get('e')-1);
			map.put('i', map.get('i')-1);
			map.put('n', map.get('n')-2);
		}
		return  result;
	}
	public static void main(String[] args) {
		 System.out.println(new N5().deCode("wgfieorzouhtrrot"));
	}
}