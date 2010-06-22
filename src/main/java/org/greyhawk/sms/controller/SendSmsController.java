package org.greyhawk.sms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.greyhawk.sms.vo.SendingMessage;
import org.greyhawk.sms.ws.client.SmsSendTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SendSmsController implements Controller {
	
	private SmsSendTemplate template;
	
	public SendSmsController(SmsSendTemplate smsSendTemplate) {
		this.template = smsSendTemplate;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView();
		String address = (String)request.getParameter("address");
		String message = (String)request.getParameter("message");
		System.out.println("address:"+address+" message:"+message);
		SendingMessage smsMessage = new SendingMessage(null, null, address, null, message);
		template.SendSms(smsMessage);
		view.setViewName("message");
		view.addObject("messageState", "短信已发送");
		return view;
	}

}
