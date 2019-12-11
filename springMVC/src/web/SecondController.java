package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SecondController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// �������ݲ�����service��ķ���
		String name = req.getParameter("name");
		System.out.println("���յ�����:" + name);
		// ���ModelAndView������
		// �������߼���ͼ
		ModelAndView mav = new ModelAndView();
		//��ModelAndView���������߼���ͼ��
		mav.setViewName("second");
		//��ModelAndView���������ҳ����ʾ������
		mav.addObject("msg", "test "+name);
		return mav;
	}

}
