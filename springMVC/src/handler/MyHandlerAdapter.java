package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerAdapter implements HandlerAdapter{

	//�жϸÿ������Ķ����Ƿ�����ĳ�����ʵ��
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof MyHandler);
	}
	
	//�ÿ�����Ӧ�õ���ʲô������������
	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {
		return ((MyHandler)handler).test(req, resp);
	}
	
	//���ظÿ��������һ���޸ĵ�ʱ��
	@Override
	public long getLastModified(HttpServletRequest paramHttpServletRequest, Object paramObject) {
		return -1L;
	}

}