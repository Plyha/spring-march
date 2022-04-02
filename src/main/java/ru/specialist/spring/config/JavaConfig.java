package ru.specialist.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.specialist.spring.bean.*;

import java.util.List;

@Configuration
public class JavaConfig {

    @Bean("myComputer")
    public Computer computer(){
        Computer computer = new Computer();
        computer.setCpu(intelCpu());
        computer.setRamList(List.of(sonyRAM(), kingstonRam(), sonyRAM()));
        computer.setScreen(List.of(PhillipsScreen(),DellScreen()));
        computer.setStorageList(List.of(SeagateStorage(), WDStorage()));
        return computer;
    }

    @Bean
    public CPU amdCpu(){
        return new AmdCPU();
    }

    @Bean
    public CPU intelCpu(){
        return new IntelCPU();
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
