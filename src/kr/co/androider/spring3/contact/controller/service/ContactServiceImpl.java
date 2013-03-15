package kr.co.androider.spring3.contact.controller.service;

import org.springframework.stereotype.Service;

import kr.co.androider.spring3.contact.controller.bean.ContactBean;

@Service("IContactService")
public class ContactServiceImpl implements IContactService {

    @Override
    public ContactBean changeInfo(ContactBean contactBean){
        
        String strManipulated = contactBean.getFirstname() + " is checked";
        contactBean.setFirstname(strManipulated);
        
        return contactBean;
    }
}