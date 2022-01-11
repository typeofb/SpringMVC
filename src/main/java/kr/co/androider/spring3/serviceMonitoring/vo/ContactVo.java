package kr.co.androider.spring3.serviceMonitoring.vo;

import java.util.Map;

public class ContactVo {
    
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private Map<String, String> hobbies;
    private String country;
    
    public String getFirstname(){
        return firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getTelephone(){
        return telephone;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public Map<String, String> getHobbies() {
        return hobbies;
    }
    
    public void setHobbies(Map<String, String> hobbies) {
        this.hobbies = hobbies;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
}