package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.model.dto.ArchivoDto;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.service.FileService;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/file")
public class FileController {
    private FileService fileService;
    @PostMapping("")
    public ResponseEntity<ArchivoDto> subirArchivo(
            @RequestParam("archivo")MultipartFile multipartFile
    ) throws Exception{
        if (multipartFile.getSize() > 25 * 1024 * 1024) {
            throw new MaxUploadSizeExceededException(25 * 1024 * 1024);
        }
        fileService.guardarArchivo(multipartFile);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Archivo subido correctamente").build(),
                HttpStatus.OK);
    }
}
