package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens

D=[0-9]+
MM=[a-zA-Z_-ñÑ]+



espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

/* Comillas */
", " {lexeme=yytext(); return Coma;}
( "Sanji" | "SANJI" | "sanji" | Marvin ) {lexeme=yytext(); return SANJI;}

/* Tipos de datos */
( "trae" | "traeme" ) {lexeme=yytext(); return TRAER;}

/*Oye*/
( "oye" | "Oye" ) {lexeme=yytext(); return OYE;}

/*Quiero*/
( "quiero" | "Quiero" ) {lexeme=yytext(); return QUIERO;}

/*hacer*/
( "hacer", "realizar") {lexeme=yytext(); return HACER;}

/*pedido*/
( "pedido") {lexeme=yytext(); return PEDIDO;}

( "la" ) {lexeme=yytext(); return LA;}

( "y" ) {lexeme=yytext(); return Y;}

( "el" ) {lexeme=yytext(); return EL;}

( "las" ) {lexeme=yytext(); return LAS;}

/*Pepsi*/
( "pepsi") {lexeme=yytext(); return PEPSI;}



/*--------- Pedir la cuenta ------------*/
( "cuenta" ) {lexeme=yytext(); return CUENTA;}
( "traeme" | "dame" | "tráeme" ) {lexeme=yytext(); return TRAER;}
/*--------- Fin pedir la cuenta --------*/



 /*-------------------Mostrar Menu-------------------*/
( "muestrame" | "enseñame" | "muéstrame" ) {lexeme=yytext(); return MOSTRAR;}
( "ver" | "mirar" ) {lexeme=yytext(); return VER;}
( "menu" | "menú") {lexeme=yytext(); return MENU;}
( "carta" ) {lexeme=yytext(); return CARTA;}
( "léeme" | "leeme" | "dictame" ) {lexeme=yytext(); return LEER;}
/*--------------------Fin mostrar Menu----------------*/



/*--------------------Platillos-----------------------*/
/* Sushi de camaron				$80.00*/
("sushi de camaron" | "sushi de camarón") {lexeme=yytext(); return SUSHI_CAMARON;}
/*Sushi de pollo				$80.00*/
("sushi de pollo") {lexeme=yytext(); return SUSHI_POLLO;}
/*Sushi de res					$80.00*/
("sushi de res") {lexeme=yytext(); return SUSHI_RES;}
/*Camaronito					$100.00*/
("camaronito") {lexeme=yytext(); return CAMARONITO;}
/*Bombazo					$100.00*/
("bombazo") {lexeme=yytext(); return BOMBAZO;}
/*Hamburguesa de arroz                          $90.00*/
("hamburguesa") {lexeme=yytext(); return HAMBURGUESA_ARROZ;}
/*Teriyaki					$120.00*/
("teriyaki") {lexeme=yytext(); return TERIYAKI;}
/*Helado de vainilla				$30.00*/
("helado de vainilla") {lexeme=yytext(); return HELADO_VAINILLA;}
/*Fruta en caramelo				$28.00*/
("fruta en caramelo") {lexeme=yytext(); return FRUTA_CARAMELO;}
/*Fondant					$40.00*/
("fondant") {lexeme=yytext(); return FONDANT;}
/*Helado de cacao				$30.00*/
("helado de cacao") {lexeme=yytext(); return HELADO_CACAO;}
/*Pie de limón					$26.00*/
("pay de limon" | "pay de limón") {lexeme=yytext(); return PIE_LIMON;}
/*Pie de fresa					$26.00*/
("pay de fresa") {lexeme=yytext(); return PIE_FRESA;}
/*Pie de mora					$26.00*/
("pay de mora") {lexeme=yytext(); return PIE_MORA;}
/*Pie de queso					$28.00*/
("pay de queso") {lexeme=yytext(); return PIE_QUESO;}
/*Churros					$6.00*/
("churros") {lexeme=yytext(); return CHURROS;}
/*Café						$20.00*/
("cafe") {lexeme=yytext(); return CAFE;}
/*Expresso					$35.00*/
("expresso") {lexeme=yytext(); return EXPRESSO;}
/*Martini					$45.00*/
("martini" | "martíni") {lexeme=yytext(); return MARTINI;}
/*Limonada					$22.00*/
("limonada") {lexeme=yytext(); return LIMONADA;}
/*Naranjada					$22.00*/
("naranjada") {lexeme=yytext(); return NARANJADA;}
/*Coca-cola					$18.00*/
("coca cola") {lexeme=yytext(); return COCA_COLA;}
/*Corona					$39.00*/
("corona") {lexeme=yytext(); return CORONA;}
/*Victoria					$39.00*/
("victoria") {lexeme=yytext(); return VICTORIA;}
/*Piña colada 					$45.00*/
("piña colada") {lexeme=yytext(); return PIÑA_COLADA;}
/*Jugo						$25.00*/
("jugo") {lexeme=yytext(); return JUGO;}
/*Vampiro					$55.00*/
("vampiro") {lexeme=yytext(); return VAMPIRO;}
/*------------------------------------------------------------------------------*/

/*------------Cantidades plurales-------------*/
( "dos" ) {lexeme=yytext(); return DOS;}
( "tres" ) {lexeme=yytext(); return TRES;}
( "cuatro" ) {lexeme=yytext(); return CUATRO;}
( "cinco" ) {lexeme=yytext(); return CINCO;}
( "seis" ) {lexeme=yytext(); return SEIS;}
( "siete" ) {lexeme=yytext(); return SIETE;}
( "ocho" ) {lexeme=yytext(); return OCHO;}
( "nueve" ) {lexeme=yytext(); return NUEVE;}
( "diez" ) {lexeme=yytext(); return DIEZ;}
( "once" ) {lexeme=yytext(); return ONCE;}
( "doce" ) {lexeme=yytext(); return DOCE;}
( "trece" ) {lexeme=yytext(); return TRECE;}
( "catorce" ) {lexeme=yytext(); return CATORCE;}
( "quince" ) {lexeme=yytext(); return QUINCE;}


/*------------Cantidad Singulares-------------*/
( "un" ) {lexeme=yytext(); return CANT_UN;}
( "una" ) {lexeme=yytext(); return CANT_UNA;}


( "los" ) {lexeme=yytext(); return LOS;}

/*de*/
( "de" ) {lexeme=yytext(); return DE;}

( "por" )      {lexeme = yytext(); return POR;}

( "favor" )      {lexeme = yytext(); return FAVOR;}

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Salto de linea */
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}

{MM}* {lexeme=yytext(); return CADENA;} 

 . {return ERROR;}
