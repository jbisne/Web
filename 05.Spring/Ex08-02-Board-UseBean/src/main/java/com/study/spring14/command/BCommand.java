package com.study.spring14.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.study.spring14.dao.BDao;
import com.study.spring14.dto.BDto;

public interface BCommand
{
	void execute(HttpServletRequest request , Model model); 
}

