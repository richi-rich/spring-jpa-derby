package com.capgemini.demo.test;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.capgemini.demo.beans.Employee;
import com.capgemini.demo.controller.crudEmployeeController;
import com.capgemini.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(crudEmployeeController.class)
public class EmployeeTest {
	
	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	public EmployeeService empService;
	
	  @MockBean
	    private TestRestTemplate restTemplate;

	
	/*@Test
	public void testGetAllEmployee() throws Exception {
		this.mockMvc.perform(get("/emp")).andExpect(status().isOk()).andExpect(content().string(containsString("Hello Employee")));
	}
	
	@Test
	public void testGetAllEmpRequest() throws Exception{
		Employee alex = new Employee("alex","1");
		Employee rich = new Employee("rich","2");
		 
	    List<Employee> allEmployees = Arrays.asList(alex,rich);
	 
	    when(empService.getAllEmp()).thenReturn(allEmployees);
	 
	    this.mockMvc.perform(get("/getAllEmp")).andExpect(status().isOk()); 
	     
	}
	
	@Test
	public void testEmpRequest() throws Exception{
		Employee alex = new Employee("alex","1");			    
	    when(empService.getEmp("1")).thenReturn(alex);
	    this.mockMvc.perform(get("/getEmp/1"))
	    .andExpect(status().isOk())	    
	    .andExpect(jsonPath("$.id").value("1")); 	     
	}*/
	
	@Test
	public void testAddEmpRequest() throws Exception{
		Employee alex = new Employee("alex","1");
		Employee ayu = new Employee("ayu","3");
		Employee rich = new Employee("rich","2");
		 List<Employee> allEmployees = Arrays.asList(alex,rich,ayu);
		 
	    when(empService.addEmp(alex)).thenReturn(allEmployees);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<List<Employee>> entity = new HttpEntity<List<Employee>>(allEmployees, headers);
	    
	    ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/addEmp", HttpMethod.POST, entity, String.class, "");
	    assertThat(response.getBody().equals("true")); 
	    
	}
	

}
