package kr.co.androider.spring3.serviceMonitoring.service;

import kr.co.androider.spring3.serviceMonitoring.vo.ContactVo;

import org.springframework.stereotype.Service;

@Service("IContactService")
public class ContactServiceImpl implements IContactService {

    @Override
    public ContactVo changeInfo(ContactVo ContactVo){
        
        String strManipulated = ContactVo.getFirstname() + " is checked";
        ContactVo.setFirstname(strManipulated);
        
        return ContactVo;
    }
}