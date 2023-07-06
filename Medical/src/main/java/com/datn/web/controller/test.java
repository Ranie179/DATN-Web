package com.datn.web.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.ServletContext;

public class test {
	
    public static String example() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        ServletContext servletContext = attr.getRequest().getServletContext();
        String realPath = servletContext.getRealPath("/");

        return realPath;
    }
    
    public static void main (String[] args ) {
    	System.out.print(example());
    	}
}
