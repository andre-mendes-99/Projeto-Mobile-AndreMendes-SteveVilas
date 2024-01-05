package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 5405529104069955535L;
    public AlreadyExistsException(String id, String elemType, String idName) {
    super(elemType+" with "+idName+" "+id+" already exists");   
}
}