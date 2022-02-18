package us.mattroberts.weedbuddy.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import us.mattroberts.weedbuddy.model.entity.WBUser;
import us.mattroberts.weedbuddy.repository.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserRepository userRepository;

	@Test
	public void test() {
		final String testIdpIdentifier = "testIdpIdentifier";
		final String testUsername = "testUsername";

		final WBUser mockedUser = WBUser.builder().username(testUsername).idpIdentifier(testIdpIdentifier).build();

		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(mockedUser));
		WBUser returnedUser = userController.getUserDetails(1L);

		assertThat(returnedUser).isNotNull();
		assertThat(mockedUser).isNotNull();
		assertThat(returnedUser.getUsername()).isEqualTo(mockedUser.getUsername());
		assertThat(returnedUser.getIdpIdentifier()).isEqualTo(mockedUser.getIdpIdentifier());
	}


}