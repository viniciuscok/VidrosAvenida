//package br.com.vidracaria.domain.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import br.com.vidracaria.domain.model.Categoria;
//import br.com.vidracaria.domain.repository.CategoriaRepository;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CategoriaServiceTest {
//
//	@Mock
//	private CategoriaRepository repository;
//	
//	@InjectMocks
//	private CategoriaService service;
//	
//	@Test
//	public void salvar() {
//		Categoria t = new Categoria();
//		t.setNome("vinicius");
//		t.setObservaçao("teste");
//		repository = mock(CategoriaRepository.class);
//		service = mock(CategoriaService.class);
//		when(repository.save(t)).thenReturn(t);
//		
//		service.salvar(t);
//		
//		verify(service, times(1)).salvar(t);
//		
//		
//	}
//	
//	@Test
//	public void buscar() {
//		Categoria t = new Categoria();
//		t.setId(1L);
//		t.setNome("vinicius");
//		t.setObservaçao("teste");
//		List<Categoria> te = new ArrayList<>();
//		te.add(t);
//		repository = mock(CategoriaRepository.class);
//		service = mock(CategoriaService.class);
//		when(repository.findAll()).thenReturn(te);
//		
//		List<Categoria> f = service.buscarTodas();
//		
//		verify(service, times(1)).buscarTodas();
//		assertEquals(te.get(0).getId(), f.get(0).getId());
//		
//		
//	}
//}
