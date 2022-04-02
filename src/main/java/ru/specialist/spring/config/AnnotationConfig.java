package ru.specialist.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.specialist.spring.bean.*;

import java.util.List;

@Configuration
@ComponentScan("ru.specialist.spring.bean")
public class AnnotationConfig {

    @Bean
    public List<RAM> ramList(){
        return List.of(kingstonRam(), sonyRAM(), kingstonRam());
    }

    @Bean
    public List<Screen> screenList(){
        return List.of(DellScreen(),PhillipsScreen());
    }

    @Bean
    public List<Storage> storageList(){
        return List.of(SeagateStorage(),WDStorage());
    }


    @Bean
    @Scope("prototype")
    public RAM kingstonRam(){
        return new KingstonRAM();
    }

    @Bean
    @Scope("prototype")
    public RAM sonyRAM(){
        return new SonyRAM();
    }

    @Bean
    @Scope("prototype")
    public Screen PhillipsScreen(){ return  new PhillipsScreen();}

    @Bean
    @Scope("prototype")
    public Screen DellScreen(){ return  new DellScreen();}

    @Bean
    @Scope("prototype")
    public Storage SeagateStorage(){ return  new SeagateStorage();}

    @Bean
    @Scope("prototype")
    public Storage WDStorage(){ return  new WDStorage();}
}
