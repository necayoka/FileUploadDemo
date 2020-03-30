package com.mvc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

	@RequestMapping("home")
	public String home() {
		return "home.jsp";
	}
//****************************************************************************************************************************
	@RequestMapping("upload")
	public String upload(@RequestParam("name") String name, @RequestParam("file") CommonsMultipartFile file) {
		Slika slika = new Slika();
		slika.setName(name);
		slika.setFile(file.getBytes());
		
		Hibernate.saveSlika(slika);
		
		return "home.jsp";
	}
//****************************************************************************************************************************	
	@RequestMapping("getSlikaForm")
	public String getSlikaForm() {
		return "getSlika.jsp";
	}
//****************************************************************************************************************************	
	@RequestMapping("getSlika")
	public ModelAndView getSlika(@RequestParam("id") int id) throws SQLException, IOException {
		ModelAndView mv = new ModelAndView();
		
		byte[] file = Base64.getEncoder().encode(Hibernate.getFajl(id));
		String slika = new String(file, "UTF-8");
		mv.addObject("slika", slika);
		mv.setViewName("display.jsp");
		
		return mv;
	}
//****************************************************************************************************************************	
	
}
