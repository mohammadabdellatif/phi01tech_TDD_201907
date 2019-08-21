package com.phi01tech.um.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://www.phi01tech.com/um/ws")
public interface UserManagementWebService {

    @WebMethod(operationName = "add-user")
    @ResponseWrapper(localName = "result")
    Result addUser(@XmlElement(name = "user-info") UserInfo info);
}
