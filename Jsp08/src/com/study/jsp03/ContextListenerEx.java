package com.study.jsp03;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//굳이 이거말고 2번 쓰는게좋다.
//@WebListener
public class ContextListenerEx implements ServletContextListener 
{

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
    	System.out.println("어플리케이션 종료");
    }
    
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
    	System.out.println("어플리케이션 시작");
    	
    	// Ex#1
    	ServletContext sc = event.getServletContext();
    	sc.setAttribute("schedule", 1000);
    }
    // 다른 앱에서 다음과 같이 사용 가능
    /*
     * int nTime = request.getSession().getServletContext().getAttribute("schedule");
     */
    
    // 서버 중지시 어플리케이션 제거가 뜬다. (가장 늦게 실행)

}
