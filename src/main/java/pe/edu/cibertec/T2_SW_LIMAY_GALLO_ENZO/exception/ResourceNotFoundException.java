package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
