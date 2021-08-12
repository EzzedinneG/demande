package com.model;
import java.util.Objects; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
@Entity
public class Demende
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String titre;
	@NonNull
	private String remarque;
	
	public Demende()
	{
		super();
	}
	
	public Demende(Long id, String titre, String remarque) 
	{
		super();
		this.id = id;
		this.titre = titre;
		this.remarque = remarque;
	}
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getTitre()
	{
		return titre;
	}
	
	public void setTitre(String titre)
	{
		this.titre = titre;
	}
	
	public String getRemarque()
	{
		return remarque;
	}
	
	public void setRemarque(String remarque) 
	{
		this.remarque = remarque;	
	}
	
	@Override
	public String toString() 
	{
		return "Demende [id=" + id + ", titre=" + titre + ", remarque=" + remarque + "]";
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(id, remarque, titre);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demende other = (Demende) obj;
		return Objects.equals(id, other.id) && Objects.equals(remarque, other.remarque)
				&& Objects.equals(titre, other.titre);
	}

	

}
