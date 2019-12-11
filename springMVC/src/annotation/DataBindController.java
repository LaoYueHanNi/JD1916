package annotation;

import java.io.Reader;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Customer;

@Controller
public class DataBindController {
	
	@RequestMapping("/data1")
	public String data1() {
		return "dataBind";
	}
	
	//���ܷ����Ĳ���2
	@RequestMapping("/data2")
	public String data2(Reader r,Writer w) {
		System.out.println("r:"+r);
		System.out.println("w:"+w);
		return "dataBind";
	}
	
	//Ҫ�����в�����key��java bean ���е�������һ��,�����Զ�ƥ��ֵ
	@RequestMapping("/data5")
	public String data5(Customer cus) {
		System.out.println(cus);
		return "dataBind";
	}
	
	@RequestMapping("/data6")
	public String data6(String name) {
		System.out.println(name);
		return "dataBind";
	}
}