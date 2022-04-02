package ru.specialist.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Computer {


    private CPU cpu;
    private List<RAM> ramList;
    private List<Screen> screenList;
    private List<Storage> storageList;

    public Computer() {
    }


    public Computer(CPU cpu) {
        this.cpu = cpu;
    }


    public Computer(@Qualifier("myCpu") CPU cpu,
                    @Qualifier("ramList") List<RAM> ramList) {
        this.cpu = cpu;
        this.ramList = ramList;
    }
    @Autowired
    public Computer(@Qualifier("myCpu")CPU cpu,
                    @Qualifier("ramList")List<RAM> ramList,
                    @Qualifier("screenList")List<Screen> screenList,
                    @Qualifier("storageList")List<Storage> storageList) {
        this.cpu = cpu;
        this.ramList = ramList;
        this.screenList = screenList;
        this.storageList = storageList;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public List<RAM> getRamList() {
        return ramList;
    }

    public void setRamList(List<RAM> ramList) {
        this.ramList = ramList;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreen(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Storage> getStorageList() {
        return storageList;
    }

    public void setStorageList(List<Storage> storageList) {
        this.storageList = storageList;
    }

    @Override
    public String toString() {
        return "Computer{\n" +
                "   CPU = " + getCpu().getName() + "\n" +
                "   RAM list = " + getRamList().stream()
                                        .map(Device::getName)
                                        .collect(Collectors
                                        .joining(", ")) + "\n" +
                "   Screen = " + getScreenList().stream()
                                                .map(Device::getName).filter(x -> x.equals("PhillipsScreen"))
                                                .collect(Collectors.joining(", ")) + "\n" +
                "   Storage list = " + getStorageList().stream()
                                        .map(Device::getName)
                                        .collect(Collectors
                                        .joining(", ")) + "\n" +
                '}';
    }

}
