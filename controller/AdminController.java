package com.nareshit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.DoctorBean;
import com.nareshit.bean.NurseBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.Nurse;
import com.nareshit.domain.Patient;
import com.nareshit.service.IDoctorService;
import com.nareshit.service.INurseService;
import com.nareshit.service.IPatientService;
import com.nareshit.utility.DoctorMapper;
import com.nareshit.utility.NurseMapper;
import com.nareshit.utility.PatientMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {

	/*	@Autowired
	private IAdminRepository aRepo;


	@Autowired
	private IAdminService service;
	 */
	@Autowired
	private IDoctorService drservice;

	@Autowired
	private IPatientService ptService;

	@Autowired
	private INurseService nrService;



	@RequestMapping
	public String getAdminBoard(Model model) {
		List<DoctorBean> drBeanList=drservice.getAllDoctors();
		model.addAttribute("drList", drBeanList);
		return "adminBoard";
	}

	/***********************Docotor Curd Operations *************************/
	@RequestMapping(value="/doctorMgmt")
	public String getDoctorBoard(Model model) {
		List<DoctorBean> drBeanList=drservice.getAllDoctors();
		model.addAttribute("drList", drBeanList);
		return "adminBoard";
	}

	@RequestMapping(value="/doctorMgmt/addDoctorDefn")
	public String addDoctorByAdmin(Model model) {
		System.out.println("admin going to add doctor");
		model.addAttribute("docBean", new DoctorBean());
		System.out.println("admin added successfully");
		return "addDoctorDefnByAdmin";
	}
	@RequestMapping(value="/doctorMgmt/addDoctor")
	public String addDoctor(@ModelAttribute("docBean") DoctorBean docBean, Model model) {
		System.out.println("add doctor method");
		Doctor dr=DoctorMapper.mapBeanToDomain(docBean);
		System.out.println("map bean to domain");
		docBean=drservice.saveDoctor(dr);
		System.out.println("doctor added successfully.....");

		if(docBean != null && docBean.getId()>0) {
			System.out.println("going to get all doctors");
			List<DoctorBean> drBeanList=drservice.getAllDoctors();
			model.addAttribute("drList", drBeanList);
			System.out.println("list of doctors");
		}
		return "adminBoard";
	}

	@GetMapping(value="/doctorMgmt/editDoctor/{id}")
	public String editDoctorByAdmin(@PathVariable("id")int id, Model model) {

		DoctorBean docBean=drservice.getDoctorById(id);
		model.addAttribute("docBean", docBean);
		return "adminDoctorEditBoard";

	}

	@PostMapping(value="/doctorMgmt/updateDoctor")
	public String updateDoctor(@ModelAttribute("docBean")DoctorBean docBean, Model model) {
		Doctor dr=DoctorMapper.mapBeanToDomain(docBean);
		docBean=drservice.updateDoctor(docBean);
		if(docBean!=null && docBean.getId()>0) {
			List<DoctorBean> drList=drservice.getAllDoctors();
			model.addAttribute("drList", drList);
		}

		return "adminBoard";
	}

	@GetMapping(value="/doctorMgmt/deleteDocotor/{id}")
	public String deleteDoctor(@PathVariable("id") int id, Model model) {

		drservice.deleteDoctor(id);
		List<DoctorBean> docBeanList=drservice.getAllDoctors();
		model.addAttribute("drList", docBeanList);
		return "adminBoard";
	}

	@GetMapping(value = "/doctorMgmt/searchDoctor")
	public String searchDoctorByNameOrEmail(HttpServletRequest req,Model model) {
		System.out.println("search patient");
		String searchVal = req.getParameter("searchValue");
		String searchOption = req.getParameter("searchOption");
		if(searchOption != null && !searchOption.isEmpty()) {
			if(searchOption.equals("Name")||searchOption.equals("Email")) {
				List<DoctorBean> docBeanList = drservice.searchDoctor(searchVal, searchOption);
				System.out.println(docBeanList);
				model.addAttribute("drList", docBeanList);
			}
		}
		return "adminBoard";
	}






	/***************************************Patient Curd Operations*******************/	

	@RequestMapping(value="/patientMgmt")
	public String getPatientBoard(Model model) {

		List<PatientBean> lpb=ptService.getAllPatients();
		model.addAttribute("patientList", lpb);

		return "adminPatientBoard";
	}

	@RequestMapping(value="/patientMgmt/addPatientDefn")
	public String addPatientByAdmin(Model model) {
		model.addAttribute("patBean", new PatientBean());
		return "addPatientDefnByAdmin";
	}

	@RequestMapping(value="/patientMgmt/addPatient")
	public String addPatient(@ModelAttribute("patBean") PatientBean patBean, Model model) {
		Patient pat=PatientMapper.mapBeanToDomain(patBean);
		patBean=ptService.savePatient(pat);

		if(patBean !=null && patBean.getId()>0) {
			List<PatientBean> patientList=ptService.getAllPatients();
			model.addAttribute("patientList", patientList);
		}
		return"adminPatientBoard";
	}

	@GetMapping(value="/patientMgmt/editPatient/{id}")
	public String editPatient(@PathVariable("id") int id, Model model) {

		PatientBean patBean=ptService.getPatientById(id);
		model.addAttribute("patBean", patBean);
		return "adminPatientEditBoard";
	}
	@PostMapping(value="/patientMgmt/updatePatient")
	public String updatePatient(@ModelAttribute("patBean") PatientBean patBean, Model model) {

		Patient pat=PatientMapper.mapBeanToDomain(patBean);
		patBean=ptService.updatePatient(pat);
		if(patBean !=null && patBean.getId()>0) {
			List<PatientBean> patientList=ptService.getAllPatients();
			model.addAttribute("patientList", patientList);
		}

		return "adminPatientBoard";
	}

	@GetMapping(value="/patientMgmt/deletePatient/{id}")
	public String deletePatient(@PathVariable("id") int id, Model model) {
		ptService.deletePatient(id);
		List<PatientBean> patientList=ptService.getAllPatients();
		model.addAttribute("patientList", patientList);

		return  "adminPatientBoard";
	}

	@GetMapping(value = "/patientMgmt/searchPatient")
	public String searchPatientByNameorEmail(HttpServletRequest req, Model model ) {

		String searchVal=req.getParameter("searchValue");
		String searchOption =req.getParameter("searchOption");

		if(searchOption != null && !searchOption.isEmpty()) {

			if(searchOption.equals("Name")||searchOption.equals("Email")) {
				List<PatientBean> patientList=ptService.searchPatient(searchVal, searchOption);
				model.addAttribute("patientList", patientList);
			}
		}
		return "adminPatientBoard"; 
	}



	/****************************** Nurse Curd Operations *********************************************************	  */ 

	@RequestMapping(value="/nurseMgmt")
	public String getNurseBoard(Model model) {

		List<NurseBean> nrBeanList=nrService.getAllNurses();
		model.addAttribute("nrBeanList", nrBeanList);
		return "adminBoard";

	}

	@RequestMapping(value="/nurseMgmt/addNurseDefn")
	public String addNurseByAdmin(Model model) {
		model.addAttribute("nrBean", new NurseBean());
		return "addNurseDefnByAdmin";
	}

	@RequestMapping(value="/nurseMgmt/addNurse")
	public String addNruse(@ModelAttribute("nrBean") NurseBean nrBean, Model model) {

		Nurse nr=NurseMapper.mapBeanToDomain(nrBean);
		nrBean=nrService.saveNurse(nr);
		if(nrBean !=null && nrBean.getId()>0) {

			List<NurseBean> nrBeanList=nrService.getAllNurses();
			model.addAttribute("nrBeanList", nrBeanList);
		}

		return "adminNurseBoard";
	}

	@GetMapping(value="/nurseMgmt/editNurse/{id}")
	public String editNurse(@PathVariable("id") int id, Model model) {

		NurseBean nrBean=nrService.getNurseById(id);
		model.addAttribute("nrBean", nrBean);
		return "adminNurseEditBoard";
	}

	@PostMapping(value="/nurseMgmt/updateNurse")
	public String updateNurse(@ModelAttribute("nrBean") NurseBean nrBean, Model model) {
		Nurse n=NurseMapper.mapBeanToDomain(nrBean);
		nrBean=nrService.updateNurse(n);
		if(nrBean !=null && nrBean.getId()>0) {
			List<NurseBean> nrBeanList=nrService.getAllNurses();
			model.addAttribute("nrBeanList", nrBeanList);
		}

		return "adminNurseBoard";
	}


	@GetMapping(value="/nurseMgmt/deleteNurse/{id}")
	public String deleteNurse(@PathVariable("id")int id, Model model) {
		nrService.deleteNurse(id);
		List<NurseBean> nrBeanList=nrService.getAllNurses();
		model.addAttribute("nrBeanList", nrBeanList);
		return "adminBoard";
	}
	@GetMapping(value="/nurseMgmt/searchNurse")
	public String searchNurseByNameOrEmail(HttpServletRequest req, Model model ) {
		
		String searchVal=req.getParameter("searchValue");
		String searchOption =req.getParameter("searchOption");
		if(searchOption !=null && !searchOption.isEmpty()) {
			if(searchOption.equals("Name")||searchOption.equals("Email")) {
				
				List<NurseBean> nrBeanList=nrService.searchNurse(searchVal, searchOption);
				model.addAttribute("nrBeanList", nrBeanList);
			}
		}
		
		return "adminNurseBoard";
	}
	










































	/*	@RequestMapping(value="/addAdminPage")
	public String addAdmin(Model model) {
	//	model.addAttribute("adminBean", new AdminBean());
		return "adminAdd";
	}


	@PostMapping(value="/save")
	public AdminBean saveAdmin(@RequestBody AdminBean adminBean) {
		Admin ad=AdminMapper.mapBeanToDomain(adminBean);
		ad=aRepo.save(ad);
		adminBean=AdminMapper.mapDomainToBean(ad);
		return adminBean;
	}
	@GetMapping(value="/addAdminDefn")
	public String addAdminDefination(Model model) {
		model.addAttribute("adminBean", new AdminBean());
		return "addAdminDefn";
	}



	@GetMapping(value="/getAdminBoard")
	public String getAdminBoard(Model model) {
			map.addAttribute("adminBean", new AdminBean());
		Iterator<Admin> adDominList=aRepo.findAll().iterator();
		List<AdminBean> admBeansList=AdminMapper.mapDominListToBean(adDominList);
		map.addAttribute("adList", admBeansList);
		return "adminBoard";

		model.addAttribute("adminBean", new AdminBean());
		List<AdminBean> adminList=service.getAllAdmins();
		model.addAttribute("adminList", adminList);		
		return "adminBoard";
	}

	@PostMapping(value="/addAdmin")
	public String addAdmin(@ModelAttribute("adminBean") AdminBean adminBean, ModelMap map) {

		Admin ad=AdminMapper.mapBeanToDomain(adminBean);
		ad=aRepo.save(ad);
		adminBean=AdminMapper.mapDomainToBean(ad);
		model.addAttribute("adminBean", new AdminBean());

		return "redirect:./getAdminBoard";
		adminBean=service.saveAdmin(adminBean);
		map.addAttribute("adminBean", new AdminBean());
		return "redirect:./getAdminBoard";
	}

	@GetMapping(value="/deleteAdmin/{id}")
	public String deletAdmin(Model model,@PathVariable("id")Integer id) {
		aRepo.delete(id);
		Iterator<Admin> adDominList=aRepo.findAll().iterator();
		List<AdminBean> admBeansList=AdminMapper.mapDominListToBean(adDominList);
		model.addAttribute("adList", admBeansList);
		return "adminBoard";

		service.deleteAdmin(id);
		List<AdminBean> adList=service.getAllAdmins();
		model.addAttribute("adminList", adList);
		return "adminBoard";

	}
	@GetMapping(value="/editAdmin/{id}")
	public String editAdmin(Model model, @PathVariable("id")Integer id) {
		Admin ad=aRepo.findOne(id);
		AdminBean adBean=AdminMapper.mapDomainToBean(ad);
		model.addAttribute("adminBean", adBean);
		return "editA";


		AdminBean adm=service.getAdminById(id);
		model.addAttribute("adminBean", adm);
		return "editA";


	}

	@PostMapping(value="/updateAdmin")
	public String updateAdmin(@ModelAttribute("adminBean") AdminBean adminBean) {
		Admin ad=AdminMapper.mapBeanToDomain(adminBean);
		ad=aRepo.save(ad);
		adminBean=AdminMapper.mapDomainToBean(ad);
		return "redirect:./getAdminBoard";

		adminBean=service.updateAdmin(adminBean);
		return "redirect:./getAdminBoard";

	}
*/
}