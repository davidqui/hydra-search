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
        <form action="/action_page.php" method="get">
            Seleccionar Archivo: <input type="file" name="docFile"><br>
            Tipo documento:
            
            <select name="idTipoDoc" id="idTipoDoc">
                <#list tipoDocs as tipoDoc>
                <option value="${tipoDoc.idTipoDoc}">${tipoDoc.tipo}</option>
                </#list>
                </select>
            
            <br>
            Amenaza o Area de Interes:
            
            <select name="idAmenaza" id="idAmenaza">
                <#list Amenazas as amenaza>
                <option value="${amenaza.idAmenaza}">${amenaza.tipo}</option>
                </#list>
                </select>
            <br>
            Evaluacion Fuente:
            
            <select name="idTipoDoc" id="idTipoDoc">
                <#list tipoDocs as tipoDoc>
                <option value="${tipoDoc.idTipoDoc}">${tipoDoc.tipo}</option>
                </#list>
                </select>
            <br>
            Evaluacion Informacion:
           
            <select name="idTipoDoc" id="idTipoDoc">
                 <#list tipoDocs as tipoDoc>
                <option value="${tipoDoc.idTipoDoc}">${tipoDoc.tipo}</option>
                </#list>
                </select>
            <br>
            Clasificacion Informacion:
            
            <select name="idTipoDoc" id="idTipoDoc">
                <#list tipoDocs as tipoDoc>
                <option value="${tipoDoc.idTipoDoc}">${tipoDoc.tipo}</option>
                </#list>
                </select>
            <br>
            </form>
        

        </body>
    </html>
