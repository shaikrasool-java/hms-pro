package com.nareshit.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.DoctorBean;
import com.nareshit.domain.Doctor;
import com.nareshit.repository.IDoctorRepository;
import com.nareshit.service.IDoctorService;
import com.nareshit.utility.DoctorMapper;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	/*@Autowired
	private IDoctorRepository drepo;*/
	
	@Autowired
	private IDoctorService service;
	
	
	
	
	@RequestMapping(value="/addDoctorPage")
	public String addDoctor(Model model) {
			model.addAttribute("docBean", new DoctorBean());
		return "docAdd";
		}
	@RequestMapping
	public String getDocorBoard(Model model) {
		model.addAttribute("docBean", new DoctorBean());
		List<DoctorBean> drBeanList=service.getAllDoctors();
		model.addAttribute("drList", drBeanList);
		return "drBoard";

				
	}

	
	
	/*
	@PostMapping(value="/save")
	public DoctorBean saveDoc(@RequestBody DoctorBean drBean) {
		
		Doctor dr=DoctorMapper.mapBeanToDomain(drBean);
		dr=drepo.save(dr);
		drBean=DoctorMapper.mapDomainToBean(dr);
		
		return drBean;
	}*/
	
	
	@GetMapping(value="/addDoctorDefn")
	public String addDoctorDefination(Model model) {
		model.addAttribute("docBean", new DoctorBean());
		return "addDoctorDefn";
	}
	
	
	@GetMapping(value="/getDoctorBoard")
	public String findDoctor(Model model) {
		/* below code for jpa ***********
		 * model.addAttribute("docBean", new DoctorBean());
		Iterator<Doctor> drDomainList=drepo.findAll().iterator();
		List<DoctorBean> drBeanList=DoctorMapper.mapDomainListToBean(drDomainList);
		model.addAttribute("drList", drBeanList);
		return "drBoard";*/

	
		model.addAttribute("docBean", new DoctorBean());
		List<DoctorBean> drBeanList=service.getAllDoctors();
		model.addAttribute("drList", drBeanList);
		return "drBoard";
	
	
	
	
		
	}
	@RequestMapping(value="/addDoctor")
	public String addDoctor(@ModelAttribute("docBean") DoctorBean docBean, ModelMap map) {
	/*	 below code for jpa 
		Doctor doc=DoctorMapper.mapBeanToDomain(docBean);
		doc=drepo.save(doc);
		docBean=DoctorMapper.mapDomainToBean(doc);
		map.addAttribute("docBean", new DoctorBean());
		String msg="Doctor '"+docBean.getFname()+"' added successfully...";
		map.addAttribute("message", msg);
		
		return "addDoctor";
		return "redirect:./getDoctorBoard";
	*/	
		docBean=service.saveDoctor(docBean);
		map.addAttribute("docBean", new DoctorBean());
		return "redirect:./getDoctorBoard";
		//return "drBoard";
	}
	@GetMapping("/getAllDoctors")
	public String showDoctors(Model model) {
		
		List<DoctorBean> drList=service.getAllDoctors();
		model.addAttribute("drList", drList);
		return "drList";
	}

	@GetMapping(value="/deleteDr/{id}")
	public String deleteDoctor(Model model, @PathVariable("id")Integer id) {
		/* below code for jpa
		 * 
		drepo.delete(id);
		Iterator<Doctor> drDomainList=drepo.findAll().iterator();
		List<DoctorBean> drBeanList=DoctorMapper.mapDomainListToBean(drDomainList);
		model.addAttribute("drList", drBeanList);
		return "drBoard";*/
		
		service.deleteDoctor(id);
		List<DoctorBean> drList=service.getAllDoctors();
		model.addAttribute("drList", drList);
		
		return "drBoard";
	}
	@GetMapping(value="/editDr/{id}")
	public String editDoctor(Model model, @PathVariable("id")int id) {
	/*	below code for jpa
		
		Doctor d=drepo.findOne(id);
		DoctorBean drBean=DoctorMapper.mapDomainToBean(d);
		model.addAttribute("drBean", drBean);
		return "editD";*/
		
		DoctorBean drBean=service.getDoctorById(id);
		model.addAttribute("docBean", drBean);
		
		return "editD";
		
	}
	
	@PostMapping(value="/updateDoctor")
	public String updateDoctor(@ModelAttribute("docBean") DoctorBean docBean, ModelMap map) {
		/*
		 * below code for jpa
		
		Doctor dr=DoctorMapper.mapBeanToDomain(drBean);
		dr=drepo.save(dr);
		drBean=DoctorMapper.mapDomainToBean(dr);
		//return "addDoctor"
		return "redirect:./getDoctorBoard";*/
		
		docBean=service.updateDoctor(docBean);
		return "redirect:./getDoctorBoard";
		//return "drList";
	}
/*	@GetMapping(value="/serachAllDoctors")
	public String searchAllDoctors(HttpServletRequest req, Model model) {
		String searchVal=req.getParameter("searchValue");
		String searchOption=req.getParameter("searchOption");
		
		if(searchOption !=null && !searchOption.isEmpty()) {
			if(searchOption.equals("Fname")) {
				List<Doctor> drDomainList=service.findDoctorByName(searchVal.toLowerCase());
				List<DoctorBean> drBeanList=DoctorMapper.mapDomainListToBean(drDomainList.iterator());
				model.addAttribute("drList", drBeanList);
			
			}
			
			
		}else {
			
			model.addAttribute("message", "Search is not supplied");
		}
		
		
		
		
		return "drBoard";
	}
*/	
}
