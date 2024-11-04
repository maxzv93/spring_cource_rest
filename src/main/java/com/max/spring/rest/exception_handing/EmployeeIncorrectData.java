package com.max.spring.rest.exception_handing;

/**
 * @author ZuevMYu
 * @since 03.11.2024
 */
public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData() {
    }

    public EmployeeIncorrectData(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
