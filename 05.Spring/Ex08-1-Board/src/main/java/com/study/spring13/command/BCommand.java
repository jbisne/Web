package com.study.spring13.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.study.spring13.dao.BDao;
import com.study.spring13.dto.BDto;

public interface BCommand
{
	void execute(HttpServletRequest request , Model model); 
}

