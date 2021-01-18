package fr.afpa.gestion.inscription.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.gestion.inscription.dto.CentreDTO;
import fr.afpa.gestion.inscription.model.Centre;

@SpringBootTest
class CentreRepositoryTest {

	@Autowired
	private CentreRepository centreRepository;
	
	
	@Test
	public void testFindByNom() {
		/*test findbynom nom existant*/
//		CentreDTO centreAfpa=new CentreDTO("Balma");
//		Optional<Centre>centre=centreRepository.findByNom(centreAfpa.getNom());
//		assertThat(centre.get().getNom()).isEqualTo(centreAfpa.getNom());
		
		/*test findbynom nom non existant*/
		
//		CentreDTO centreAfpa=new CentreDTO("Lille");
//		Optional<Centre>centre=centreRepository.findByNom(centreAfpa.getNom());
//		assertThat(centre.get().getNom()).isEqualTo(centreAfpa.getNom());
	}
	
	

}
