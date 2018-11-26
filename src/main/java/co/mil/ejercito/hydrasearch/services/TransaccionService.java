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

import co.mil.ejercito.hydrasearch.entities.Transicion;
import co.mil.ejercito.hydrasearch.entities.Usuario;
import co.mil.ejercito.hydrasearch.repositories.TransicionRepository;
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

    @Autowired
    private TransicionRepository transicionRepository;


    public Transaccion create(Transaccion transaccion, Documento documento) {
        Calendar fechaActual = Calendar.getInstance();
        transaccion.setFechaTransaccion(fechaActual.getTime());
        transaccion.setIdDocumento(documento);
        return transaccionRepository.save(transaccion);
    }

    public Documento create(Documento documento, MultipartFile file, String ubicacion) {
        Calendar fechaActual = Calendar.getInstance();
        documento.setFechaCreacion(fechaActual.getTime());
        documento.setNombreDoc(file.getOriginalFilename());
        documento.setExtension(file.getContentType());
//        if (documento.getAccesoPrivado()){
//            documento.setAccesoPrivado(Boolean.TRUE);
//        }
        documento.setAccesoPrivado(Boolean.TRUE);
        documento.setUrlDocumento(ubicacion);
        return documentoRepository.save(documento);
    }


    public Transicion create(Transicion transicion) {
        return transicionRepository.save(transicion);
    }


    public Transicion createTransicionUserCreador(Transaccion transaccionData, Usuario usuarioCreador) {

        Transicion transicionCreacion = new Transicion();
        transicionCreacion.setIdTransaccion(transaccionData);
        transicionCreacion.setLoginUsuario(usuarioCreador);
        transicionCreacion.setEstado("Creado");
        transicionCreacion.setActivo(Boolean.FALSE);

        return transicionRepository.save(transicionCreacion);
    }

    public Transicion createTransicionUserAsignado(Transaccion transaccionData, Usuario usuarioAsignado) {

        Transicion transicionAsignacion = new Transicion();
        transicionAsignacion.setIdTransaccion(transaccionData);
        transicionAsignacion.setLoginUsuario(usuarioAsignado);
        transicionAsignacion.setEstado("Asignado");
        transicionAsignacion.setActivo(Boolean.TRUE);
        create(transicionAsignacion);

        return transicionRepository.save(transicionAsignacion);
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
     * Crea el directorio root y los subdirectorios validando
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
        /*
         * Valida si hay archivo seleccionado o si el seleccionado esta vacio.
         */
        if (file.isEmpty()) {
            return "No hay archivo...";
        }

        /*
         * Numero Aleatorio para renombrar el archivo formato (nombreOriginal+numeroAleatorio+extension)
         * El archivo es almacenado en el directorio de destino sin extencion
         */
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 1000);
        String nuevoNombre = numeroAleatorio + "" + file.getOriginalFilename();

        byte[] bytes = file.getBytes();
        Path path = Paths.get(directorioRoot + File.separator + subDirectorio + File.separator
                + file.getOriginalFilename().replace(file.getOriginalFilename(), nuevoNombre));
        Files.write(path, bytes);
        return path.toString();
    }

}
