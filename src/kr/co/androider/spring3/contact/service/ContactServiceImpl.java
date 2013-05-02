package kr.co.androider.spring3.contact.service;

import org.springframework.stereotype.Service;

import kr.co.androider.spring3.contact.vo.ContactVo;

@Service("IContactService")
public class ContactServiceImpl implements IContactService {

    @Override
    public ContactVo changeInfo(ContactVo ContactVo){
        
        String strManipulated = ContactVo.getFirstname() + " is checked";
        ContactVo.setFirstname(strManipulated);
        
        return ContactVo;
    }
}