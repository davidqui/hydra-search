package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Documento;
import co.mil.ejercito.hydrasearch.repositories.DocumentoRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;
    
    /**
     * Metodo para crear un nuevo documento.
     * @param documento Objeto Documento
     * @param file Metadata del Archivo a guardar
     * @param ubicacion Url donde se guarda el archivo
     * @return Objeto Documento creado. 
     */
    public Documento create(Documento documento, MultipartFile file, String ubicacion) {
        Calendar fechaActual = Calendar.getInstance();
        documento.setFechaCreacion(fechaActual.getTime());
        documento.setNombreDoc(file.getOriginalFilename());
        documento.setExtension(file.getContentType());
        if (documento.getAccesoPrivado()!=Boolean.TRUE){
            documento.setAccesoPrivado(Boolean.FALSE);
        }
        documento.setUrlDocumento(ubicacion);
        return documentoRepository.save(documento);
    }
    
    /**
     * Metodo que permite modelar la estructura del directorio raiz donde se
     * almacenaran los archivos.
     *
     * @param directorioRoot Directorio raiz definido en el application.properties
     * @return Estructura definitiva del directorio que almacena los archivos.
     */
    public String generarEstructuraRoot(String directorioRoot){
        LocalDate actual= LocalDate.now();
        String directorio = directorioRoot+File.separator+actual.getYear();
        return directorio;
    }

    /**
     * Permite crea el directorio root y los subdirectorios validando
     * previamente si existe o no.
     *
     * @param directorioRoot Directorio principal.
     * @param subDirectorio Subdirectorio secundario.
     */
    public void crearDirectorios(String directorioRoot, String subDirectorio) {
        boolean existeDirectorioRoot = validarExistenciaDirectorio(directorioRoot);
        boolean existeSubDirectorio = validarExistenciaDirectorio(directorioRoot + File.separator + subDirectorio);
        Path dirPathObj = Paths.get(directorioRoot);
        Path sudDirPathObj = Paths.get(directorioRoot + File.separator + subDirectorio);

        try {
            if (!existeDirectorioRoot) {
                Files.createDirectories(dirPathObj);
                Files.createDirectories(sudDirPathObj);
            }

            if (!existeSubDirectorio) {
                Files.createDirectories(sudDirPathObj);
            }
        } catch (IOException ioExceptionObj) {
            System.out.println("Se genero un problema al crear el directorio = " + ioExceptionObj.getMessage());
        }
    }

    /**
     * Valida si un directorio existe.
     *
     * @param directorioValidar Directorio a evaluar.
     * @return
     */
    public boolean validarExistenciaDirectorio(Object directorioValidar) {
        return Files.exists(Paths.get(directorioValidar.toString()));
    }

    /**
     * Metodo para guardar un archivo en un directorios predeterminado.
     *
     * @param file Archivo a guardar
     * @param directorioRoot Directorio Principal
     * @param subDirectorio Directorio Secundario
     * @throws IOException Se presenta en caso de errores de acceso
     */
    public String guardarArchivo(MultipartFile file, String directorioRoot, String subDirectorio) throws IOException {
        
        if (file.isEmpty()) {
            return "No hay archivo...";
        }

        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 1000);
        String nuevoNombre = numeroAleatorio + "" + file.getOriginalFilename();

        byte[] bytes = file.getBytes();
        Path path = Paths.get(directorioRoot + File.separator + subDirectorio + File.separator
                + file.getOriginalFilename().replace(file.getOriginalFilename(), nuevoNombre));
        Files.write(path, bytes);
        return path.toString();
    }
    
}
