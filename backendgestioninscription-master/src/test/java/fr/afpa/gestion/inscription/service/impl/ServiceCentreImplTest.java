package fr.afpa.gestion.inscription.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.gestion.inscription.dto.CentreDTO;
import fr.afpa.gestion.inscription.service.ServiceCentre;

@SpringBootTest
//(classes=BackEndGestionInscriptionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource("/application-test.properties")
class ServiceCentreImplTest {


	
	@Autowired
	private  ServiceCentre serviceCentreTest;


	

	
//	@Test
//	public void testcreateCentre() {
				
				/*test creation d'un centre*/
			
//				CentreDTO newCentre = new CentreDTO("Montpellier");
//			
//				CentreDTO centredto=serviceCentreTest.create(newCentre);
//				assertThat(centredto.getNom()).isEqualTo(newCentre.getNom());
//				System.out.println("la première creation est ok "+centredto);
				
				/*test creation nom deja existant*/
				
//				CentreDTO newCentre = new CentreDTO("Montpellier");
//				
//				CentreDTO centredto=serviceCentreTest.create(newCentre);
//				assertThat(centredto.getNom()).isEqualTo(newCentre.getNom());
//				System.out.println("la première creation est ok "+centredto);
			
				/*test creation nom null*/
				
//				CentreDTO newCentre = new CentreDTO("");
//		
//				CentreDTO centredto=serviceCentreTest.create(newCentre);
//		
//				System.out.println("la première creation est ok "+centredto);
//}
	
//	@Test
//	public void testupdateCentre() {
		/*test update*/
		//CentreDTO newCentre = new CentreDTO("Toulouse");
		//newCentre=serviceCentreTest.update(25,newCentre);
		
		/*test update dun nom déjà existant et id different*/
		//CentreDTO newCentre = new CentreDTO("Toulouse");
		//newCentre=serviceCentreTest.update(26,newCentre);
		
		/*test update dun nom null*/
		//CentreDTO newCentre = new CentreDTO("");
		//newCentre=serviceCentreTest.update(26,newCentre);
		
		
		/*test update autre champ que nom*/
		//CentreDTO newCentre = new CentreDTO(null, "10 rue des" , "Balma", null);
		//newCentre=serviceCentreTest.update(2,newCentre);
		
		/*test update id inconnu*/
		//CentreDTO newCentre = new CentreDTO("Clermont");
		//newCentre=serviceCentreTest.update(55,newCentre);
//	}
	
	//@Test
	//public void testdeleteCentre() {
		/*test delete id inconnu*/
		//serviceCentreTest.delete(55);
		
		/*test delete id existant*/
		//serviceCentreTest.delete(26);
	//}
	
//	@Test
//	public void testfindAllCentre() {
//		List<CentreDTO> listDTO=new ArrayList<CentreDTO>();
//		listDTO=serviceCentreTest.findAll();
//		System.out.println(listDTO);
//	}
	
}
