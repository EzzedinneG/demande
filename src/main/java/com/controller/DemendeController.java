package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Demende;
import com.service.*;


@RestController
@CrossOrigin()
@RequestMapping("test")
public class DemendeController {
	@Autowired
	private DemendeService demendeService;
	 
	
	

	@GetMapping("/demende")
	public Page<Demende> getall(Pageable page)
	{
		return demendeService.findallDemende(page);
		
	}
	
	
	
	@PostMapping("/add")

	public ResponseEntity<?> AddDemende ( @RequestBody  Demende demende)
	{
		
		demendeService.AddDemende(demende);
	return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	
	
	@GetMapping("/{id}")
	
	public ResponseEntity<?> FindById(@PathVariable Long id)
	{
		Optional<Demende> Opt = demendeService.FindById(id);
		if( Opt.isPresent())
		
		{
		
		 return new ResponseEntity<Demende>( Opt.get(),HttpStatus.FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
@PutMapping("/update")
	
	public ResponseEntity<?> Update ( @RequestBody  Demende demende)
	{
		Optional<Demende> Opt = demendeService.UpdateDemende(demende);
	
		if(Opt.isPresent())
			
		{
			return new ResponseEntity<Demende>( Opt.get(),HttpStatus.OK);
		}
		
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    }
@DeleteMapping("delete/{id}")


public  ResponseEntity<?> delete(@PathVariable Long id)
{
	Optional<Demende> opt = demendeService.Deletebyid(id);
	if( opt.isPresent())
	{
		
	 return new ResponseEntity<Demende>( opt.get(),HttpStatus.OK);
	 
	}
	
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

}




}
