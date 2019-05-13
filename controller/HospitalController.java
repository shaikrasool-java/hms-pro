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
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.repository.IHospitalRepository;
import com.nareshit.utility.HospitalMapper;


//@RestController
@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private IHospitalRepository hospRepo;
	
	@RequestMapping
	public String getHomePage(Model model) {
		String msg = "welcome to hms pro";
		model.addAttribute("message", msg);
		return "home";
	}
	
	@GetMapping(value="/addHospitalPage")
	public String addHospotal(Model model) {
		model.addAttribute("hospBean", new HospitalBean());
		return "hospAdd";
		//return "addHospitalDefn";	
		
	}

	@GetMapping(value="/addHospitalDefn")
	public String addHospotalDefinition(Model model) {
		System.out.println("get hospital page");
		model.addAttribute("hospBean", new HospitalBean());
		return "addHospitalDefn";
	}
	
	
	@GetMapping(value="/getHospitalBoard")
	public String getHospitalBoard(ModelMap map) {
		map.addAttribute("hospBean", new HospitalBean());
		Iterator<Hospital> hospDomainList=hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList=HospitalMapper.mapDomainListToBean(hospDomainList);
		map.addAttribute("hospList", hospBeanList);
		
		return "hospBoard";
		//return "addHospitalDefn";
	}
	
	
	@PostMapping(value="/addHospital")
	public String addHospotal(@ModelAttribute("hospBean") HospitalBean hospBean, Model model) {
		
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		String msg="Hospital '"+hospBean.getName()+"' added Successfully";
		model.addAttribute("hospBean", new HospitalBean());
		model.addAttribute("message", msg);
		
		/*return "addHospital";*/

		return "redirect:./getHospitalBoard";
	}

	/*@GetMapping(value="/getAllHospitals")
	public String  findHospotal(Model  model) {
		System.out.println("from get all");
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		System.out.println(hospBeanList.size());
		return "hospList";
	}
	*/
	@GetMapping(value="/deleteHosp/{id}")
	public String  delteHospotal(Model  model,@PathVariable("id")Integer id) {
		hospRepo.delete(id);
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		return "hospBoard";
	}
	
	@GetMapping(value="/editHosp/{id}")
	public String  editHospotal(Model  model,@PathVariable("id") int id) {
		Hospital hospital = hospRepo.findOne(id);
		HospitalBean hospBean = HospitalMapper.mapDomainToBean(hospital);
		model.addAttribute("hospBean", hospBean);
		return "editH";
	}
	
	@PostMapping(value="/updateHospital")
	public String updateHospotal(@ModelAttribute("hospBean") HospitalBean hospBean) {
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		//return "addHospital";
		return "redirect:./getHospitalBoard";
		
	}
	
	
	
	@GetMapping(value="/searchAllHosp")
	public String searchAllHosp(HttpServletRequest req,Model model) {
		System.out.println("am in search all hsopiatls");
		String searchVal = req.getParameter("searchValue");
		String searchOption = req.getParameter("searchOption");
		System.out.println("search val is:\t"+searchVal);
		System.out.println("search option is:\t"+searchOption);
		
		if(searchOption != null && !searchOption.isEmpty()) {
			if(searchOption.equals("Name")||searchOption.equals("Email")) {
				List<Hospital> hospDomainList = hospRepo.findHospitalByName(searchVal.toLowerCase());
				List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainList.iterator());
				model.addAttribute("hospList", hospBeanList);
			}
		}else {
			model.addAttribute("errorMessage", "Search is not supplied.");
		}
		
		return "hospBoard";
				
		
	}
}
