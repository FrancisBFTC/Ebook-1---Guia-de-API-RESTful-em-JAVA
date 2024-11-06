package br.com.dio;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveRetornarSucessoComCredenciaisValidas() throws Exception {
		URI uri = new URI("/auth/signin");
		
		String content = "{ \"username\": \"wendersonanjos\" , \"senha\" : \"BruteForce001\"}";
		
		mockMvc.perform(MockMvcRequestBuilders
						.post(uri)
						.content(content)
						.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void deveRetornarErroComCredenciaisInvalidas() throws Exception {
		URI uri = new URI("/auth/signin");
		
		String content = "{ \"username\": \"wendersonanjos\" , \"senha\" : \"BruteForce00\"}";
		
		MockHttpServletResponse response;
		mockMvc.perform(MockMvcRequestBuilders
						.post(uri)
						.content(content)
						.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.content()
				.string("CREDENCIAIS INVALIDAS"));
		
	}
	
	@Test
	public void deveRetornarErroDeNaoAutorizado() throws Exception {
		URI uri = new URI("/produto/save");
		
		String content = "{{\r\n"
							+ "    \"nome\": \"Arroz\",\r\n"
							+ "    \"preco\": 19.90\r\n"
							+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
						.post(uri)
						.content(content)
						.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status().is(401));
		
	}
}
