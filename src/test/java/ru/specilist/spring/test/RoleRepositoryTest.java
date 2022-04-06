package ru.specilist.spring.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import ru.specialist.spring.config.DataConfig;
import ru.specialist.spring.dao.repository.RoleRepository;
import ru.specialist.spring.entity.Role;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:blog.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class RoleRepositoryTest {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleRepositoryTest(RoleRepository userRepository) {
        this.roleRepository = userRepository;
    }

    @Test
    public void getAll(){
        List<Role> result = roleRepository.findAll();
        assertEquals(5, result.size());
    }

    @Test
    public void create(){
        Role role = new Role();
        role.setName("Test123");

        roleRepository.save(role);
        assertEquals(6, roleRepository.count());
        assertEquals("Test123", roleRepository.findById(6L).orElseThrow().getName());
    }

    @Test
    public void update(){
        Role role = roleRepository.findById(1L).orElseThrow();
        role.setName("Test1234");

        roleRepository.save(role);
        assertEquals(5, roleRepository.count());
        assertEquals("Test1234", roleRepository.findById(1L).orElseThrow().getName());
//        assertNotNull(postRepository.findById(1L).orElseThrow().getDtUpdated());
    }

    @Test
    void delete(){
        roleRepository.deleteById(1L);
        assertEquals(4, roleRepository.count());
    }

}
