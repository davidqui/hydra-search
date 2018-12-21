<#ftl strip_whitespace = true>
<#assign charset="UTF-8">
<#assign title="Transacciones">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
    <div class="row">
        <div class="row">
            <div class="col s12 m10">
                <div class="card blue    darken-1">
                    <div class="card-content white-text">
                        <span class="card-title">Cargando Datos</span>
                        <p>Este formulario permite cargar un documentoS</p>
                    </div>
                    <div class="card-action">
                        <a href="#">This is a link</a>
                        <a href="#">This is a link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="input-field col s8">
        <form action="/transaccion/save" method="post" enctype="multipart/form-data" >

            <div class="col s12">
            -------Datos del Documento----------
            <br>
            Seleccionar Archivo: <input type="file" name="docFile">
                <br>
                <br>
            Tipo documento:
            <select name="idTipoDoc" id="idTipoDoc" >
                <#list tipoDocs as tipoDoc>
                <option value="${tipoDoc.idTipoDoc}">${tipoDoc.tipo}</option>
                </#list>
                </select>
            </div>
            <div class="col s6">
            Clasificacion Informacion:
            <select name="idClasificacion" id="idClasificacion">
                <#list clasificaciones as clasificacion>
                    <option value="${clasificacion.idClasificacion}">${clasificacion.tipo}</option>
                </#list>
            </select>
            </div>
            <div class="col s6">
            Factor de Inestabilidad:
            <select name="factoresCollection" id="factoresCollection" multiple>
                <#list factoresInestabilidad as factor>
                <option value="${factor.idFactores}">${factor.nombre}</option>
                </#list>
                </select>
            </div>
            <div class="col s6">
            Amenaza o Area de Interes:
            <select name="amenazaCollection" id="amenazaCollection" multiple>
                <#list amenazas as amenaza>
                <option value="${amenaza.idAmenaza}">${amenaza.tipo}</option>
                </#list>
                </select>
            </div>
            <div class="col s6">
            Evaluacion Fuente:
            <select name="idCredibilidad" id="idCredibilidad">
                <#list credibilidades as credibilidad>
                <option value="${credibilidad.idCredibilidad}">${credibilidad.nombre}</option>
                </#list>
                </select>
            </div>
            <div class="col s6">
            Evaluacion Informacion:
            <select name="idExactitud" id="idExactitud">
                 <#list exactitudes as exactitud>
                <option value="${exactitud.idExactitud}">${exactitud.nombre}</option>
                </#list>
                </select>
            </div>
            <textarea name="descripcion" id="descripcion" rows="10" cols="50">Escribe aqui...</textarea>
            <br>
            <div class="col s6">
            Usuario Validador:
            <select name="usuarioValidador" id="usuarioValidador">
                <#list usuarios as usuario>
                    <option value="${usuario.login}">${usuario.login} - ${usuario.nombre}</option>
                </#list>
            </select>
            </div>
            <div class="col s6">
            Usuario Creador:
            <select name="login" id="login">
                <#list usuarios as usuario>
                    <option value="${usuario.login}">${usuario.login} - ${usuario.nombre}</option>
                </#list>
            </select>
            </div>
                Nivel de Acceso:
                <input type="checkbox" name="accesoPrivado" id="accesoPrivado" value="1">Privado
                <br>
            <br>
            <br>
            <br>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                <i class="material-icons right">send</i>
            </button>
            <br>
            <br>
            <br>
            </form>

        </div>
        </div>
        <script !src="">
            document.addEventListener('DOMContentLoaded', function() {
                var elems = document.querySelectorAll('select');
                var instances = M.FormSelect.init(elems, options);
            });

            M.AutoInit();
        </script>

        </body>
    </html>
