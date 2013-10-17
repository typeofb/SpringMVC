package kr.co.androider.spring3.serviceMonitoring.service;

import kr.co.androider.spring3.serviceMonitoring.vo.ContactVO;

import org.springframework.stereotype.Service;

@Service("IContactService")
public class ContactServiceImpl implements IContactService {

    @Override
    public ContactVO changeInfo(ContactVO ContactVO){
        
        String strManipulated = ContactVO.getFirstname() + " is checked";
        ContactVO.setFirstname(strManipulated);
        
        return ContactVO;
    }
}