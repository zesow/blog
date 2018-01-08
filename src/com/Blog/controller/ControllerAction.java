package com.Blog.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerAction extends HttpServlet{
	
//	string,object 가 들어감. 객체들 저장소.
	private Map commandMap = new HashMap();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		loadProperties("com/Blog/properties/Command");
	}
	
	private void loadProperties(String path) {
//		서블릿 엔진이 실행될 때 path에 있는 경로의 클래스 인스턴스를 만들어 저장. 
		// TODO Auto-generated method stub
		ResourceBundle rbHome =ResourceBundle.getBundle(path);
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while(actionEnumHome.hasMoreElements()) {
			String command = actionEnumHome.nextElement(); //key
			String className = rbHome.getString(command); //value
			
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				
				commandMap.put(command, commandInstance);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		requestPro(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		requestPro(req,resp);
	}

	private void requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		// TODO Auto-generated method stub
//		객체 실행. 
		String view = null;
		CommandAction com = null;
		
		try {
//			URI가 요청하는 객체 찾기.
			String command = req.getRequestURI();
			if(command.indexOf(req.getContextPath()) == 0) {
				command = command.substring(req.getContextPath().length());
			}
			com = (CommandAction) commandMap.get(command);
			if(com == null) {
				System.out.println("not found : " + command);
				return;
			}
			
			view = com.requestPro(req, resp);
			if(view == null)
				return;
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		System.out.println(view);
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
	}

}
