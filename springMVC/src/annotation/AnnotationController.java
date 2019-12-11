package annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//����������
@Controller
@RequestMapping("/test")
public class AnnotationController {

		//����ModelAndView�Ķ���
		//��������÷���
		@RequestMapping("/h1.action")
		public ModelAndView test1() {
			ModelAndView mv = new ModelAndView("first");
			mv.addObject("msg","annotation");
			return mv;
		}
		
		//����ֵ2:����String,�߼���ͼ��
			//�������:Model����
		@RequestMapping("/h2.action")
		public String test(Model model) {
			model.addAttribute("msg", "annotation2");
			return "first";
		}
		
		//����ֵ3:����void,����Ҫ��ͼ������
		@RequestMapping("/h3.action")
		public void test3(HttpServletResponse resp,HttpServletRequest req) {
			try {
				PrintWriter pw = resp.getWriter();
				pw.println("xixihaha1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	/*
	 * //ע�Ṧ�� public String test4(User user) { //����service��ķ�������ҵ���߼����� }
	 */

}