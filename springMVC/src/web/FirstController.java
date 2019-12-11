package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FirstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// ���ܿͻ��˴���������
		String name = req.getParameter("name");
		System.out.println("���յ�����:" + name);
		
		//����service��ķ���,�������ݲ���������
		
		//����ModelAndView����
		ModelAndView mav = new ModelAndView();
		//��ModelAndView���������߼���ͼ��
		mav.setViewName("first");
		//��ModelAndView����������ҳ����ʾ������
		mav.addObject("msg", "test "+name);
		return mav;
	}

}