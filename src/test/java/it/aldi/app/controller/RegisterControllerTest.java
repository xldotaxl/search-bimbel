package it.aldi.app.controller;

import it.aldi.app.Application;
import it.aldi.app.service.BimbelUserService;
import it.aldi.app.util.ErrorMsgConstant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
@Transactional
public class RegisterControllerTest {
    private MockMvc mockMvc;

    @MockBean
    private BimbelUserService bimbelUserService;

    @MockBean
    private ErrorMsgConstant errorMsgConstant;

    @Before
    public void setup() {
        RegisterController registerController = new RegisterController(bimbelUserService, errorMsgConstant);
        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }

    @Test
    @WithAnonymousUser
    public void testRegister() throws Exception {
        mockMvc.perform(get("/register"))
            .andExpect(status().isOk())
            .andExpect(view().name("register/register"))
            .andExpect(forwardedUrl("register/register"));
    }
}
