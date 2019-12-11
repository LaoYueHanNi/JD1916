package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SecondController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 接受数据并调用service层的方法
		String name = req.getParameter("name");
		System.out.println("接收到名字:" + name);
		// 最后ModelAndView的数据
		// 参数是逻辑视图
		ModelAndView mav = new ModelAndView();
		//给ModelAndView对象设置逻辑视图名
		mav.setViewName("second");
		//给ModelAndView对象设添加页面显示的数据
		mav.addObject("msg", "test "+name);
		return mav;
	}

}
