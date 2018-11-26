<#ftl strip_whitespace = true>
<#assign charset="UTF-8">
<#assign title="Transacciones">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <h1>Cargando Datos</h1>
        <form action="/transaccion/save" method="post" enctype="multipart/form-data">

            -------Datos del Documento----------
            <br>
            Seleccionar Archivo: <input type="file" name="docFile"><br>
            Tipo documento:
            <select name="idTipoDoc" id="idTipoDoc">
                <#list tipoDocs as tipoDoc>
                <option value="${tipoDoc.idTipoDoc}">${tipoDoc.tipo}</option>
                </#list>
                </select>
            <br>
            Clasificacion Informacion:
            <select name="idClasificacion" id="idClasificacion">
                <#list clasificaciones as clasificacion>
                    <option value="${clasificacion.idClasificacion}">${clasificacion.tipo}</option>
                </#list>
            </select>
            <br>
            <br>
            <br>
            ------Datos de la Transaccion----------
            <br>
            Factor de Inestabilidad:
            <select name="idFactores" id="idFactores">
                <#list factoresInestabilidad as factor>
                <option value="${factor.idFactores}">${factor.nombre}</option>
                </#list>
                </select>
            <br>
            Amenaza o Area de Interes:
            <select name="idAmenaza" id="idAmenaza">
                <#list amenazas as amenaza>
                <option value="${amenaza.idAmenaza}">${amenaza.tipo}</option>
                </#list>
                </select>
            <br>

            Evaluacion Fuente:
            
            <select name="idCredibilidad" id="idCredibilidad">
                <#list credibilidades as credibilidad>
                <option value="${credibilidad.idCredibilidad}">${credibilidad.nombre}</option>
                </#list>
                </select>
            <br>

            Evaluacion Informacion:
           
            <select name="idExactitud" id="idExactitud">
                 <#list exactitudes as exactitud>
                <option value="${exactitud.idExactitud}">${exactitud.nombre}</option>
                </#list>
                </select>
            <br>

            <textarea name="descripcion" id="descripcion" rows="10" cols="50">Escribe aqui...</textarea>
            <br>
            Usuario Validador:
            <select name="usuarioValidador" id="usuarioValidador">
                <#list usuarios as usuario>
                    <option value="${usuario.login}">${usuario.login} - ${usuario.nombre}</option>
                </#list>
            </select>
            <br>
            Usuario Creador:
            <select name="login" id="login">
                <#list usuarios as usuario>
                    <option value="${usuario.login}">${usuario.login} - ${usuario.nombre}</option>
                </#list>
            </select>
            <br>
            <button type="submit">Guardar y Asignar</button>
            </form>

        </body>
    </html>
