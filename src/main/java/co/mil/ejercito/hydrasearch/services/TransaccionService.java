package co.mil.ejercito.hydrasearch.services;

import co.mil.ejercito.hydrasearch.entities.Documento;
import co.mil.ejercito.hydrasearch.entities.Transaccion;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import co.mil.ejercito.hydrasearch.repositories.DocumentoRepository;
import co.mil.ejercito.hydrasearch.repositories.TransaccionRepository;


@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;
    
    @Autowired
    private DocumentoRepository documentoRepository;

        
    /**
     * Metodo que permite modelar la estructura del directorio raiz donde se 
     * almacenaran aleatoriamente los archivos.
     * 
     * @param directorioRoot Directorio raiz definido en el application.properties
     * @return Estructura definitiva del directorio para el evento.
     */
    public String generarEstructuraRoot(String directorioRoot){
        LocalDate actual= LocalDate.now();
        int directorioA = ThreadLocalRandom.current().nextInt(1, 12);
        int directorioB = ThreadLocalRandom.current().nextInt(1, 12);
        int directorioC = ThreadLocalRandom.current().nextInt(1, 12);
        String directorio = directorioRoot+File.separator+actual.getYear()+File.separator+directorioA+File.separator+directorioB+File.separator+directorioC;
        return directorio;
    }
    
    /**
     * Crea el directorio root y los subdirectorios del evento validando
     * previamente si existe o no.
     *
     * @param directorioRoot Directorio principal.
     * @param subDirectorioEvento Subdirectorio secundario uno por evento.
     */
    public void crearDirectorios(String directorioRoot, BigDecimal subDirectorioEvento) {
        boolean existeDirectorioRoot = validarExistenciaDirectorio(directorioRoot);
        boolean existeDirectorioEvento = validarExistenciaDirectorio(directorioRoot + File.separator + subDirectorioEvento);
        Path dirPathObj = Paths.get(directorioRoot);
        Path sudDirPathObj = Paths.get(directorioRoot + File.separator + subDirectorioEvento.toString());

        try {
            if (!existeDirectorioRoot) {
                Files.createDirectories(dirPathObj);
                Files.createDirectories(sudDirPathObj);
            }

            if (!existeDirectorioEvento) {
                Files.createDirectories(sudDirPathObj);
            }
        } catch (IOException ioExceptionObj) {
            System.out.println("Se genero un problema al crear el directorio = " + ioExceptionObj.getMessage());
        }
    }

    /**
     * Crea un directorio validando previamente si existe o no.
     *
     * @param directorio Nombre del Directorio a crear.
     */
    public void crearDirectorio(Object directorio) {
        boolean existeDirectorio = validarExistenciaDirectorio(directorio);
        Path directorioPath = Paths.get(directorio.toString());

        try {
            if (!existeDirectorio) {
                Files.createDirectories(directorioPath);
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
     * Metodo para crear un nuevo registro de Transaccion.
     * 
     * @param transaccion Coleccion de atributos y valores del objeto Transaccion.
     * @param directorioRoot Directorio principal.
     * @param subDirectorio Directorio final.
     * @return El objeto Transaccion modelado y listo para hacer persistencia con la base de datos.
     */
    public Transaccion create(Transaccion transaccion, String directorioRoot, BigDecimal subDirectorio) {
//       Modificar el objeto a guardar segun metadata automatica
        return transaccionRepository.save(transaccion);
    }

    /**
     * Metodo para crear actualizar un registro del objeto Transaccion.
     * 
     * @param transaccion Coleccion de atributos y valores del objeto transaccion.
     * @return El objeto Transaccion modelado y listo para hacer persistencia con la base de datos.
     */   
    public Transaccion update(Transaccion transaccion) {
        //       Modificar el objeto a guardar segun metadata automatica
        return transaccionRepository.save(transaccion);
    }
    
    /**
     * Metodo para listar todos las transacciones ralizadas..
     * 
     * @param sort
     * @return 
     */
    public List <Transaccion> findAll(Sort sort) {
        return transaccionRepository.findAll(sort);
    }
    
    /**
     * Busca una transaccion por su clave primaria
     * 
     * @param id
     * @return 
     */
    public Transaccion findById(Long id) {
        return transaccionRepository.findByidTransaccion(id);
    }
    
    
    /**
     * Permite validar el formato del archivo que se esta adjuntando.
     *
     * @param contentType Tipo de contenido.
     * @return {@code true} Si el tipo de contenido es válido (PDF, WORD,
     * POWERPOINT, EXCEL, JPG, JPEG, PNG); de lo contrario, {@code false}.
     */
    private boolean isValidoContentType(String contentType) {
        String[] validContentTypes = {"application/pdf",
            "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation",
            "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            "image/jpeg", "image/jpg", "image/png"};

        for (String validContentType : validContentTypes) {
            if (contentType.equals(validContentType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite agregar varios documentos adjuntos, segun contentType permitidos
     *
     * @param files Archivos seleccionados.
     * @param directorioRoot Directorio Principal.
     * @param subDirectorioEvento Directorio Secundario.
     * @throws IOException
     */
    public void guardarMultiplesArchivos(List<MultipartFile> files, String directorioRoot, BigDecimal subDirectorioEvento) throws IOException {
        for (MultipartFile file : files) {
            guardarArchivo(file, directorioRoot, subDirectorioEvento);
        }
    }

    /**
     * Metodo para guardar un archivo anexo en un directorios predeterminado.
     *
     * @param file Archivo a guardar
     * @param directorioRoot Directorio Principal
     * @param subDirectorioEvento Directorio Secundario
     * @throws IOException Se presenta en caso de errores de acceso
     */
    private void guardarArchivo(MultipartFile file, String directorioRoot, BigDecimal subDirectorio) throws IOException {
        Calendar fechaActual = Calendar.getInstance();
        Documento documento = new Documento();

        /*
        * Valida si hay archivo seleccionado o si el seleccionado esta vacio.
         */
        if (file.isEmpty()) {
            return;
        }

        /*
        * Valida si el Archivo seleccionado tiene un formato valido segun logica @code isValidoContentType.
         */
        if (!isValidoContentType(file.getContentType())) {
            return;
        }
        //    OJO    indexar metadata del archivo a guardar

        /*
        * Numero Aleatorio para renombrar el archivo formato (numeroEvento+numeroAleatorio+extension)
        * El archivo es almacenado en el directorio de destino sin extencion
         */
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 1000);
        String nuevoNombre = subDirectorio + "" + numeroAleatorio;
        byte[] bytes = file.getBytes();
        Path path = Paths.get(directorioRoot + File.separator + subDirectorio + File.separator
                + file.getOriginalFilename().replace(file.getOriginalFilename(), nuevoNombre));
        Files.write(path, bytes);
//        anexo.setCodigo(nuevoNombre);
//        anexo.setNombreFinal(nuevoNombre + "." + identificarExtencionAnexo(file));
//        anexo.setUbicacionDisco(directorioRoot + File.separator + subDirectorioEvento);
//        documentoService.create(anexo);
    }

    /**
     * Metodo que identifica la metadata de la extension de un archivo.
     *
     * @param file Archivo a evaluar.
     * @return Valor que identifica la extencion del archivo que recibio por
     * parametro.
     */
    private String identificarExtencionAnexo(MultipartFile file) {
        Map<String, String> listContentType = new HashMap<>();
        listContentType.put("application/pdf", "pdf");
        listContentType.put("application/msword", "doc");
        listContentType.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
        listContentType.put("application/vnd.ms-powerpoint", "ppt");
        listContentType.put("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
        listContentType.put("application/vnd.ms-excel", "xls");
        listContentType.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        listContentType.put("image/jpeg", "jpeg");
        listContentType.put("image/jpg", "jpg");
        listContentType.put("image/png", "png");
        return listContentType.get(file.getContentType());
    }
}
