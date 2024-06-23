package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.model.dto.ArchivoDto;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.service.FilesService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/files")
public class FilesController {
    private FilesService filesService;
    @PostMapping("")
    public ResponseEntity<ArchivoDto> subirArchivos(
            @RequestParam("archivos")List<MultipartFile> multipartFileList
    ) throws Exception{
        filesService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Archivos subidos correctamente").build(),
                HttpStatus.OK);
    }
}
