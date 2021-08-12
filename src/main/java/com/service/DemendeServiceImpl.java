package com.service;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.model.Demende;
import com.repository.DemendeRepository;
@Service
public class DemendeServiceImpl implements DemendeService{
	@Autowired
	private DemendeRepository demendeRepository;

	@Override
	public Page<Demende> findallDemende(Pageable page) {
		 return  demendeRepository.findAll(page);
	}

	
	@Override
	public Optional<Demende> FindById(long id) {		
		return demendeRepository.findById(id);
	}
	   
	

	@Override
	public void AddDemende(Demende demende) {
		demendeRepository.save(demende);
		
	}
	
	

	@Override
	public Optional<Demende> UpdateDemende(Demende demende) {

		Optional<Demende> resulta = demendeRepository.findById(demende.getId());
	if (resulta.isPresent())
	{ 
		Demende ExistDe = resulta.get();
		if(demende.getTitre() != null)
		{
			ExistDe.setTitre(demende.getTitre()); 
		}
		if(demende.getRemarque() != null)
		{
			ExistDe.setRemarque(demende.getRemarque()); 
	    }
		demendeRepository.save(ExistDe);
	   return Optional.of(ExistDe);
	}
	return Optional.empty();

	}


	@Override
	public Optional<Demende> Deletebyid(long id) {
		Optional<Demende> DemendeOp = demendeRepository.findById(id);
		if (DemendeOp.isPresent())
	    {
			demendeRepository.delete(DemendeOp.get());
			System.out.print(DemendeOp.get());
			return(DemendeOp);
		}
		return Optional.empty();
	}

}
