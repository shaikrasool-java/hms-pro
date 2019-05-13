package com.nareshit.controller;

import java.util.Iterator;
import java.util.List;

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

import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;
import com.nareshit.repository.IPatientRepository;
import com.nareshit.service.IPatientService;
import com.nareshit.utility.PatientMapper;

@Controller
@RequestMapping("/patient")
public class PatientController {

/*	@Autowired
	private IPatientRepository prepo;
*/
	@Autowired
	private IPatientService service;
	
	
	/*@RequestMapping("/addPatientPage")
	public String addPatient(Model model) {
		model.addAttribute("patBean", new PatientBean());
		return "patAdd";
	}*/

	@GetMapping(value="/addPatientDefn")
	public String addPatient(Model model) {
		System.out.println("get Patient page");
		model.addAttribute("patBean", new PatientBean());
		return "addPatientDefn";
	}
	
	
	@PostMapping(value="/addPatient")
	public String addPatient(@ModelAttribute("patBean")PatientBean patBean, Model model) {
		
		Patient pat=PatientMapper.mapBeanToDomain(patBean);
		patBean=service.savePatient(pat);
		if(patBean!=null && patBean.getId()>0) {
			List<PatientBean> lpb=service.getAllPatients();
			model.addAttribute("patientList", lpb);
		}
				
		
		return "patBoard";
	}

	/*@GetMapping(value="/addPatientDefn")
	public String addPatientDefination(Model model) {
		model.addAttribute("patBean", new PatientBean() );
		return "addPatientDefn";
	}*/
	
	
	
	@GetMapping(value="/getPatientBoard")
	public String findPatient(Model model) {
	/*
	 * below code for jpa
		
		model.addAttribute("patBean", new PatientBean());
		Iterator<Patient> ptDomainList=prepo.findAll().iterator();
		List<PatientBean> ptBeanList=PatientMapper.mapDomainListToBean(ptDomainList);
		model.addAttribute("patientList", ptBeanList);
		return "patBoard";*/
		
		model.addAttribute("patBean", new PatientBean());
		List<PatientBean> pBeanList=service.getAllPatients();
		model.addAttribute("patientList", pBeanList);
		return "patBoard";
		
		
	}
	/*@RequestMapping(value="/addPatient")
	public String addPatient(@ModelAttribute("patBean") PatientBean patBean, ModelMap map) {
	
	 * below code for jpa
		
		
		Patient pat=PatientMapper.mapBeanToDomain(patBean);
		pat=prepo.save(pat);
		patBean=PatientMapper.m apDomainToBean(pat);
		map.addAttribute("patBean", new PatientBean());
		//			return "addPatient";
		return "redirect:./getPatientBoard";	
	
		
		
		patBean=service.savePat(patBean);
			map.addAttribute("patBean", new PatientBean());
				//return "PatBoard";
		return "redirect:./getPatientBoard";
		
		
		
		
	
	}*/
	
	

/*
	@PostMapping(value="/save")
	public PatientBean savePati(@RequestBody PatientBean patBean) {

		Patient pat=PatientMapper.mapBeanToDomain(patBean);
		pat=prepo.save(pat);
		patBean=PatientMapper.mapDomainToBean(pat);
		return patBean;
	}
*/
	@GetMapping("/deletePt/{id}")
	public String deletePatient(Model model, @PathVariable("id")Integer id) {
		/*
		 * below code for jpa
		prepo.delete(id);
		Iterator<Patient> ptDomainList=prepo.findAll().iterator();
		List<PatientBean> ptBeanList=PatientMapper.mapDomainListToBean(ptDomainList);
		model.addAttribute("patientList", ptBeanList);
		return "patBoard";*/
		service.deletePatient(id);
		List<PatientBean> pList=service.getAllPatients();
		model.addAttribute("patientList", pList);
		return "patBoard";
	
	}
	@GetMapping(value="/editPt/{id}")
	public String editPatient(Model model, @PathVariable("id")Integer id) {
		/*Patient p=prepo.findOne(id);
		PatientBean ptBean=PatientMapper.mapDomainToBean(p);
		model.addAttribute("patBean", ptBean);
		return "editP";*/
		PatientBean pBean=service.getPatientById(id);
		model.addAttribute("patBean", pBean);
		return "editP";
		
	}
	@PostMapping(value="/updatePatient")
	public String updatePatient(@ModelAttribute("patBean") PatientBean patBean) {
		/*Patient pt=PatientMapper.mapBeanToDomain(patBean);
		pt=prepo.save(pt);
		patBean=PatientMapper.mapDomainToBean(pt);
		return "redirect:./getPatientBoard";*/
		
		patBean=service.updatePatient(patBean);
		return "redirect:./getPatientBoard";
		}
		
	
}


