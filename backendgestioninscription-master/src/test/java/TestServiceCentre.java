

import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.gestion.inscription.dto.CentreDTO;
import fr.afpa.gestion.inscription.model.Centre;
import fr.afpa.gestion.inscription.repository.CentreRepository;
import fr.afpa.gestion.inscription.service.impl.ServiceCentreImpl;
import fr.afpa.gestion.inscription.service.util.CentreLinkCreator;

@SpringBootTest
class TestServiceCentre {
	
	
	public class UserServiceImplTest {
		 
	    private ServiceCentreImpl serviceCentreImpl;
	    private CentreRepository centreRepository;
	    private CentreLinkCreator lCr;
	    
	    @BeforeEach
	    public void setup() {
	    	
	    	centreRepository = Mockito.mock(CentreRepository.class);
	    	
			serviceCentreImpl = new ServiceCentreImpl(centreRepository, lCr);
	    }
	    
	    @Test
	    public void testFindCentre() throws Exception {
	    	Centre centre = new Centre(null,"Marseille",null,null);
	    	List<Centre> allCentre = Arrays.asList(centre);
	        Mockito.when(centreRepository.findAll()).thenReturn(allCentre);
	    	verify(centreRepository).findAll();
	    }
	    
	    @Test
	    public void testSaveUser() throws Exception {
	    	CentreDTO centremock=new CentreDTO("Amiens");
	    	Optional<Centre>optCentre=null;
	    	Mockito.when(centreRepository.findByNom(centremock.getNom())).thenReturn(optCentre);
	    	Mockito.when(serviceCentreImpl.create((centremock))).thenReturn(centremock);
	    }
	    
	}}

//	private static ServiceCentreImpl serviceCentreTest;
//	private CentreRepository centreRep;
//	private CentreLinkCreator lCr;
//
//	
//	@BeforeEach
//	public void initUtilisateurDaoImpl() {
//		serviceCentreTest = new ServiceCentreImpl(centreRep, lCr);
//		System.out.println("init");
//
//	}
//	
//	
//	@AfterEach
//	public void closeUtilisateurDaoImpl() {
//	System.out.println("le test est fini");
//	serviceCentreTest=null;
//	}
//	
//	@Test
//	public void testcreateCentre() {
//		
//				/*test creation d'un centre*/
//				System.out.println("debut test création");
//				CentreDTO newCentre = new CentreDTO("Montpellier");
//				System.out.println(newCentre);
//				CentreDTO centredto=serviceCentreTest.create(newCentre);
//				//assertThat(centredto.getNom()).isEqualTo(newCentre.getNom());
//				System.out.println("la première creation est ok "+centredto);
				
				/*test avec nom existant déjà*/
				//newCentre=serviceCentreTest.create(newCentre);
				
				/*test creation nom null*/
				//newCentre.setNom(null);
				//newCentre=serviceCentreTest.create(newCentre);
				
				
			
	
//		@Test
//		public void editerThemeTest() {
//			//ThemeDTO newTheme = new ThemeDTO(25,"jobDating","rouge","oui","ok");
//			//Theme theme=ServiceThemeTest.editerTheme(newTheme);
//			//assertThat(theme.getCouleur()).isEqualTo("orange");
//		}
//		
//		
//		
//		@Test
//		public void supprimerThemeTest(){
//			//ThemeDTO newTheme=new ThemeDTO(25);
//			//ServiceThemeTest.creationTheme(newTheme);
//			//ServiceThemeTest.supprimerTheme(newTheme.getId());
//		}
//		
//		
//		@Test
//		public void afficherThemeTest(){
//		
//			//List<Theme> list =ServiceThemeTest.afficherTheme();
//			//System.out.println(list);
//		
//		}
//		@Test
//		public void rechercherThemeTest() {
//			ThemeDTO newTheme=new ThemeDTO(2);
//			Theme theme = ServiceThemeTest.rechercherTheme(newTheme);
//			System.out.println(theme);
		
		

