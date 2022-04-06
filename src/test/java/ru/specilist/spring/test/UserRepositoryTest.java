package ru.specilist.spring.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import ru.specialist.spring.config.DataConfig;
import ru.specialist.spring.dao.repository.UserRepository;
import ru.specialist.spring.entity.User;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:blog.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void getAll(){
        List<User> result = userRepository.findAll();
        assertEquals(1, result.size());
    }

    @Test
    public void create(){
        User user = new User();
        user.setUsername("ilya");
        user.setPassword("pass");
        user.setFirstName("test");
        user.setLastName("hlevnoy");
        user.setDtCreated(LocalDateTime.now());

        userRepository.save(user);
        assertEquals(2, userRepository.count());
        assertEquals("ilya", userRepository.findById(2L).orElseThrow().getUsername());
    }

    @Test
    public void update(){
        User user = userRepository.findById(1L).orElseThrow();
        user.setUsername("ilya");

        userRepository.save(user);
        assertEquals(1, userRepository.count());
        assertEquals("ilya", userRepository.findById(1L).orElseThrow().getUsername());
//        assertNotNull(postRepository.findById(1L).orElseThrow().getDtUpdated());
    }

    @Test
    void delete(){
        userRepository.deleteById(1L);
        assertEquals(0, userRepository.count());
    }

}
