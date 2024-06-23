package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FilesService implements IFilesService {
    private final Path pathFolder = Paths.get("uploads");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        String fileName = archivo.getOriginalFilename();
        if (!isValidExtension(fileName)) {
            throw new IllegalArgumentException("Extensión inválida en archivo: " + fileName);
        }
        Files.copy(archivo.getInputStream(), this.pathFolder.resolve(fileName));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivoList) throws Exception {
        if (archivoList.size() != 3) {
            throw new IllegalArgumentException("Son requeridos 3 archivos");
        }

        for (MultipartFile archivo : archivoList) {
            this.guardarArchivo(archivo);
        }
    }
    private boolean isValidExtension(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        return extension.equals("pdf") || extension.equals("png") || extension.equals("docx");
    }
}
