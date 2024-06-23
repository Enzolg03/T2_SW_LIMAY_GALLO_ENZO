package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    void guardarArchivo(MultipartFile archivo) throws Exception;
}
