package com.nareshit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nareshit.bean.NurseBean;
import com.nareshit.domain.Nurse;
import com.nareshit.service.INurseService;
import com.nareshit.utility.NurseMapper;

@Controller
public class NurseController {


	@Autowired
	private INurseService service;


	@GetMapping(value="/addNurseDefn")	
	public String addNurse(Model model) {
		model.addAttribute("nrBean", new NurseBean());
		return "addNurseDefn";
	}

	public String addNurse(@ModelAttribute("nrBean") NurseBean nrBean, Model model) {
		Nurse n=NurseMapper.mapBeanToDomain(nrBean);
		nrBean=service.saveNurse(n);
		if(nrBean!=null && nrBean.getId()>0) {
			
			List<NurseBean> lnb=service.getAllNurses();
			model.addAttribute("nurseList", lnb);
		}
		
		return "nurBoard";
	}
	
	@GetMapping(value="/getNurseBoard")
	public String findNurse(Model model) {
	model.addAttribute("nrBean", new NurseBean());
	List<NurseBean> nBeanList=service.getAllNurses();
		return "nurBoard";
	}
	
	@GetMapping("/deleteNurse/{id}")
	public String deleteNurse(@PathVariable("id")int id, Model model) {
		service.deleteNurse(id);
		List<NurseBean> nBeanList=service.getAllNurses();
		model.addAttribute("nurseList", nBeanList);
		return "nurBoard";
	}
	
	public String editNurse(@PathVariable("id")int id, Model model) {

			NurseBean nBean=service.getNurseById(id);
			model.addAttribute("nurBean", nBean);
		return "editN";
	}
	@PostMapping(value="/updateNurse")
	public String updateNurse(@ModelAttribute("nurBean") NurseBean nurBean) {
		
		nurBean=service.updateNurse(nurBean);
		return "redirect:./getNurseBoard";
	}
	
}
