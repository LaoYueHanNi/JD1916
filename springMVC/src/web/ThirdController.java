package web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ThirdController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//直接通过输出流写数据
		res.setCharacterEncoding("GBK");
		PrintWriter pw = res.getWriter();
		pw.println("xixihaha");
		pw.println("直接输出");
		
		return null;
	}

}
