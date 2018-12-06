CREATE TABLE "TIPO_DOC" (
"id_tipo_doc" serial8 NOT NULL,
"tipo" varchar(90) NOT NULL,
PRIMARY KEY ("id_tipo_doc") 
)
WITHOUT OIDS;
CREATE TABLE "AMENAZA" (
"id_amenaza" serial8 NOT NULL,
"tipo" varchar(60) NOT NULL,
PRIMARY KEY ("id_amenaza") 
)
WITHOUT OIDS;
CREATE TABLE "CLASIFICACION" (
"id_clasificacion" serial8 NOT NULL,
"tipo" varchar(60) NOT NULL,
PRIMARY KEY ("id_clasificacion") 
)
WITHOUT OIDS;
CREATE TABLE "TRANSACCION" (
"id_transaccion" serial8 NOT NULL,
"id_credibilidad" int8 NOT NULL,
"id_exactitud" int8 NOT NULL,
"id_documento" int8 NOT NULL,
"fecha_transaccion" timestamp(15) NOT NULL,
"calificacion_calculada" int8,
"descripcion" varchar(255) NOT NULL,
"usuario_validador" varchar(60) NOT NULL,
PRIMARY KEY ("id_transaccion") ,
CONSTRAINT "UNIQUE_TRANSACCION" UNIQUE ("id_transaccion")
)
WITHOUT OIDS;
CREATE TABLE "UNIDAD" (
"id_unidad" serial8 NOT NULL,
"unidad" varchar(60) NOT NULL,
PRIMARY KEY ("id_unidad") 
)
WITHOUT OIDS;
CREATE TABLE "CREDIBILIDAD" (
"id_credibilidad" serial8 NOT NULL,
"nombre" varchar(30) NOT NULL,
"valor" int8 NOT NULL,
PRIMARY KEY ("id_credibilidad") 
)
WITHOUT OIDS;
CREATE TABLE "DOCUMENTO" (
"id_clasificacion" int8 NOT NULL,
"id_tipo_doc" int8 NOT NULL,
"id_documento" serial8 NOT NULL,
"nombre_doc" varchar(60) NOT NULL,
"url_documento" varchar(255) NOT NULL,
"fecha_creacion" date NOT NULL,
"extension" varchar(100) NOT NULL,
"acceso_privado" bool NOT NULL,
PRIMARY KEY ("id_documento") 
)
WITHOUT OIDS;
CREATE TABLE "EXACTITUD" (
"id_exactitud" serial8 NOT NULL,
"nombre" varchar(60) NOT NULL,
"valor" int8 NOT NULL,
PRIMARY KEY ("id_exactitud") 
)
WITHOUT OIDS;
CREATE TABLE "FACTORES_INESTABILIDAD" (
"id_factores" serial8 NOT NULL,
"nombre" varchar(70) NOT NULL,
PRIMARY KEY ("id_factores") 
)
WITHOUT OIDS;
CREATE TABLE "FACTORES_TRANSACCION" (
"id_factores" int8 NOT NULL,
"id_transaccion" int8 NOT NULL,
PRIMARY KEY ("id_factores", "id_transaccion") 
)
WITHOUT OIDS;
CREATE TABLE "AMENAZA_TRANSACCION" (
"id_amenaza" int8 NOT NULL,
"id_transaccion" int8 NOT NULL,
PRIMARY KEY ("id_amenaza", "id_transaccion") 
)
WITHOUT OIDS;
CREATE TABLE "USUARIO" (
"id_ldap" int8,
"id_unidad" int8 NOT NULL,
"login" varchar(60) NOT NULL,
"nombre" varchar(255) NOT NULL,
"nivel_clasificacion" varchar(30) NOT NULL,
PRIMARY KEY ("login") 
)
WITHOUT OIDS;
CREATE TABLE "TRANSICION" (
"id_transaccion" int8 NOT NULL,
"login_usuario" varchar(60) NOT NULL,
"id_transicion" serial8 NOT NULL,
"estado" varchar(20) NOT NULL,
"activo" bool NOT NULL,
PRIMARY KEY ("id_transicion") 
)
WITHOUT OIDS;

ALTER TABLE "TRANSACCION" ADD CONSTRAINT "fk_TRANSACCION_CREDIBILIDAD" FOREIGN KEY ("id_credibilidad") REFERENCES "CREDIBILIDAD" ("id_credibilidad");
ALTER TABLE "TRANSACCION" ADD CONSTRAINT "fk_TRANSACCION_EXACTITUD" FOREIGN KEY ("id_exactitud") REFERENCES "EXACTITUD" ("id_exactitud");
ALTER TABLE "FACTORES_TRANSACCION" ADD CONSTRAINT "fk_FACT_TRANSACCION_FACTORES_INESTABILIDAD" FOREIGN KEY ("id_factores") REFERENCES "FACTORES_INESTABILIDAD" ("id_factores");
ALTER TABLE "AMENAZA_TRANSACCION" ADD CONSTRAINT "fk_AMENAZA_TRANSACCION_AMENAZA" FOREIGN KEY ("id_amenaza") REFERENCES "AMENAZA" ("id_amenaza");
ALTER TABLE "FACTORES_TRANSACCION" ADD CONSTRAINT "fk_FACTORES_TRANSACCION_TRANSACCION" FOREIGN KEY ("id_transaccion") REFERENCES "TRANSACCION" ("id_transaccion");
ALTER TABLE "AMENAZA_TRANSACCION" ADD CONSTRAINT "fk_AMENAZA_TRANSACCION_TRANSACCION" FOREIGN KEY ("id_transaccion") REFERENCES "TRANSACCION" ("id_transaccion");
ALTER TABLE "USUARIO" ADD CONSTRAINT "fk_USUARIO_UNIDAD" FOREIGN KEY ("id_unidad") REFERENCES "UNIDAD" ("id_unidad");
ALTER TABLE "DOCUMENTO" ADD CONSTRAINT "fk_DOCUMENTO_TIPO_DOC" FOREIGN KEY ("id_tipo_doc") REFERENCES "TIPO_DOC" ("id_tipo_doc");
ALTER TABLE "TRANSICION" ADD CONSTRAINT "fk_TRANSICION_USUARIO" FOREIGN KEY ("login_usuario") REFERENCES "USUARIO" ("login");
ALTER TABLE "TRANSICION" ADD CONSTRAINT "fk_TRANSICION_TRANSACCION" FOREIGN KEY ("id_transaccion") REFERENCES "TRANSACCION" ("id_transaccion");
ALTER TABLE "DOCUMENTO" ADD CONSTRAINT "fk_DOCUMENTO_CLASIFICACION" FOREIGN KEY ("id_clasificacion") REFERENCES "CLASIFICACION" ("id_clasificacion");
ALTER TABLE "TRANSACCION" ADD CONSTRAINT "fk_TRANSACCION_DOCUMENTO" FOREIGN KEY ("id_documento") REFERENCES "DOCUMENTO" ("id_documento");


-- ----------------------------
-- Records of AMENAZA
-- ----------------------------
BEGIN;
INSERT INTO "AMENAZA" VALUES (1, 'GAO-r');
INSERT INTO "AMENAZA" VALUES (2, 'GAO');
INSERT INTO "AMENAZA" VALUES (3, 'GAO ELN');
INSERT INTO "AMENAZA" VALUES (4, 'MEDIOS ABIERTOS');
INSERT INTO "AMENAZA" VALUES (5, 'FENOMENOS CRIMINALES');
COMMIT;

-- ----------------------------
-- Records of CLASIFICACION
-- ----------------------------
BEGIN;
INSERT INTO "CLASIFICACION" VALUES (1, 'ULTRASECRETO');
INSERT INTO "CLASIFICACION" VALUES (2, 'SECRETO');
INSERT INTO "CLASIFICACION" VALUES (3, 'RESTRINGIDO');
INSERT INTO "CLASIFICACION" VALUES (4, 'CONFIDENCIAL');
INSERT INTO "CLASIFICACION" VALUES (5, 'SIN CLASIFICACION');
COMMIT;

-- ----------------------------
-- Records of CREDIBILIDAD
-- ----------------------------
BEGIN;
INSERT INTO "CREDIBILIDAD" VALUES (2, 'B - NORMAL', 80);
INSERT INTO "CREDIBILIDAD" VALUES (1, 'A - COMPLETA', 100);
INSERT INTO "CREDIBILIDAD" VALUES (3, 'C - REGULAR', 60);
INSERT INTO "CREDIBILIDAD" VALUES (4, 'D - DUDOSA', 40);
INSERT INTO "CREDIBILIDAD" VALUES (5, 'E - MINIMA', 20);
INSERT INTO "CREDIBILIDAD" VALUES (6, 'F - NO PUEDE SER JUZGADA', 10);
COMMIT;

-- ----------------------------
-- Records of EXACTITUD
-- ----------------------------
BEGIN;
INSERT INTO "EXACTITUD" VALUES (1, '1 - CONFIRMADO', 100);
INSERT INTO "EXACTITUD" VALUES (2, '2 - PROBABLEMENTE', 80);
INSERT INTO "EXACTITUD" VALUES (5, '5 - IMPROBABLE', 20);
INSERT INTO "EXACTITUD" VALUES (3, '3 - POSIBLEMENTE', 60);
INSERT INTO "EXACTITUD" VALUES (4, '4 - DUDOSO', 40);
INSERT INTO "EXACTITUD" VALUES (6, '6 - NO PUEDE SER JUZGADO', 10);
COMMIT;

-- ----------------------------
-- Records of FACTORES_INESTABILIDAD
-- ----------------------------
BEGIN;
INSERT INTO "FACTORES_INESTABILIDAD" VALUES (1, 'SECUESTRO');
INSERT INTO "FACTORES_INESTABILIDAD" VALUES (2, 'EXTORSION');
INSERT INTO "FACTORES_INESTABILIDAD" VALUES (3, 'CONTRABANDO');
INSERT INTO "FACTORES_INESTABILIDAD" VALUES (4, 'EXPOLTACION ILICITA DE YACIMINETOS MINEROS');
INSERT INTO "FACTORES_INESTABILIDAD" VALUES (5, 'MIGRACION ILEGAL');
INSERT INTO "FACTORES_INESTABILIDAD" VALUES (6, 'NARCOTRAFICO');
INSERT INTO "FACTORES_INESTABILIDAD" VALUES (7, 'TRAFICO DE ARMAS Y MUNICIONES');
COMMIT;

-- ----------------------------
-- Records of TIPO_DOC
-- ----------------------------
BEGIN;
INSERT INTO "TIPO_DOC" VALUES (1, 'Boletín Diario de Información');
INSERT INTO "TIPO_DOC" VALUES (2, 'Boletín Diario de Tratamineto');
INSERT INTO "TIPO_DOC" VALUES (3, 'Presentación Semanal');
INSERT INTO "TIPO_DOC" VALUES (4, 'Informe Análisis Situacion Semanal');
INSERT INTO "TIPO_DOC" VALUES (5, 'Matriz de Información de Tratamiento');
INSERT INTO "TIPO_DOC" VALUES (6, 'Acta de Reunión');
INSERT INTO "TIPO_DOC" VALUES (7, 'Informe Entrevista Preliminar');
INSERT INTO "TIPO_DOC" VALUES (8, 'Informe Entrevista Militar');
INSERT INTO "TIPO_DOC" VALUES (9, 'Respuesta Requerimiento Plan de Búsqueda');
INSERT INTO "TIPO_DOC" VALUES (10, 'Otros Requerimientos');
COMMIT;

-- ----------------------------
-- Records of UNIDAD
-- ----------------------------
BEGIN;
INSERT INTO "UNIDAD" VALUES (1, 'CI3ME');
INSERT INTO "UNIDAD" VALUES (2, 'CI3MO1');
INSERT INTO "UNIDAD" VALUES (3, 'CI3MO2');
INSERT INTO "UNIDAD" VALUES (4, 'CI3MO3');
INSERT INTO "UNIDAD" VALUES (5, 'CI3MO4');
INSERT INTO "UNIDAD" VALUES (6, 'CI3MO5');
INSERT INTO "UNIDAD" VALUES (7, 'CI3MO6');
INSERT INTO "UNIDAD" VALUES (8, 'CI3MO7');
INSERT INTO "UNIDAD" VALUES (9, 'CI3MO8');
COMMIT;

-- ----------------------------
-- Records of USUARIO
-- ----------------------------
BEGIN;
INSERT INTO "USUARIO" VALUES (1, 2, 'aherreram', 'Restringido', 'Alejandro Herrera Montilla');
INSERT INTO "USUARIO" VALUES (2, 2, 'jcespedeso', 'Secreto', 'Johan Miguel Céspedes Ortega');
INSERT INTO "USUARIO" VALUES (3, 4, 'dquijanor', 'Confidencial', 'David Antonio Quijano Ramos');
COMMIT;