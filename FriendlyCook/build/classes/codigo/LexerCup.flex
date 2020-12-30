
package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

D=[0-9]+
MM=[a-zA-Z_-ñÑ]+



espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }
    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }
%}
%%

/* Comillas */
", " {return new Symbol(sym.Coma,yychar,yyline,yytext());}

/*Sanji*/
( "Sanji" | "SANJI" | "sanji" | "Marvin" ) {return new Symbol(sym.SANJI,yychar,yyline,yytext());}

/* Tipos de datos */
( "trae" | "traeme" ) {return new Symbol(sym.TRAER,yychar,yyline,yytext());}

/*Oye*/
( "oye" | "Oye" ) {return new Symbol(sym.OYE,yychar,yyline,yytext());}

/*Quiero*/
( "quiero" | "Quiero" ) {return new Symbol(sym.QUIERO,yychar,yyline,yytext());}

/* hacer */ 
( "hacer" | "realizar" ) {return new Symbol(sym.HACER,yychar,yyline,yytext());}

/* pedido */ 
( "pedido" ) {return new Symbol(sym.PEDIDO,yychar,yyline,yytext());}

( "la" ) {return new Symbol(sym.LA,yychar,yyline,yytext());}

( "y" ) {return new Symbol(sym.Y,yychar,yyline,yytext());}

( "el" ) {return new Symbol(sym.EL,yychar,yyline,yytext());}

( "las" ) {return new Symbol(sym.LAS,yychar,yyline,yytext());}

/*Pepsi*/
( "pepsi") {return new Symbol(sym.PEPSI,yychar,yyline,yytext());}




/*--------- Pedir la cuenta ------------*/
( "cuenta" ) {return new Symbol(sym.CUENTA,yychar,yyline,yytext());}
( "traeme" | "dame" | "tráeme") {return new Symbol(sym.TRAER,yychar,yyline,yytext());}
/*--------- Fin pedir la cuenta --------*/

/*--------- Liberar a Marvin -----------*/
( "listo" | "Listo" ) {return new Symbol(sym.LISTO,yychar,yyline,yytext());}
/*--------- Fin Liberar a Marvin -------*/

 /*-------------------Mostrar Menu-------------------*/
( "muestrame" | "enseñame" | "muéstrame") {return new Symbol(sym.MOSTRAR,yychar,yyline,yytext());}
( "ver" | "mirar" ) {return new Symbol(sym.VER,yychar,yyline,yytext());}
( "menu" | "menú" ) {return new Symbol(sym.MENU,yychar,yyline,yytext());}
( "carta" ) {return new Symbol(sym.CARTA,yychar,yyline,yytext());}
( "léeme" | "leeme" | "dictame" | "díctame") {return new Symbol(sym.LEER,yychar,yyline,yytext());}
/*--------------------Fin mostrar Menu----------------*/


/*-------------------- PLATILLOS (MENU) -----------------------*/
/* Sushi de camaron				$80.00*/
("sushi de camaron") {return new Symbol(sym.SUSHI_CAMARON,yychar,yyline,yytext());}
/*Sushi de pollo				$80.00*/
("sushi de pollo") {return new Symbol(sym.SUSHI_POLLO,yychar,yyline,yytext());}
/*Sushi de res					$80.00*/
("sushi de res") {return new Symbol(sym.SUSHI_RES,yychar,yyline,yytext());}
/*Camaronito					$100.00*/
("camaronito") {return new Symbol(sym.CAMARONITO,yychar,yyline,yytext());}
/*Bombazo					$100.00*/
("bombazo") {return new Symbol(sym.BOMBAZO,yychar,yyline,yytext());}
/*Hamburguesa de arroz                          $90.00*/
("hamburguesa") {return new Symbol(sym.HAMBURGUESA_ARROZ,yychar,yyline,yytext());}
/*Teriyaki					$120.00*/
("teriyaki") {return new Symbol(sym.TERIYAKI,yychar,yyline,yytext());}
/*Helado de vainilla				$30.00*/
("helado de vainilla") {return new Symbol(sym.HELADO_VAINILLA,yychar,yyline,yytext());}
/*Fruta en caramelo				$28.00*/
("fruta en caramelo") {return new Symbol(sym.FRUTA_CARAMELO,yychar,yyline,yytext());}
/*Fondant					$40.00*/
("fondant") {return new Symbol(sym.FONDANT,yychar,yyline,yytext());}
/*Helado de cacao				$30.00*/
("helado de cacao") {return new Symbol(sym.HELADO_CACAO,yychar,yyline,yytext());}
/*Pie de limón					$26.00*/
("pay de limon" | "pay de limón") {return new Symbol(sym.PIE_LIMON,yychar,yyline,yytext());}
/*Pie de fresa					$26.00*/
("pay de fresa") {return new Symbol(sym.PIE_FRESA,yychar,yyline,yytext());}
/*Pie de mora					$26.00*/
("pay de mora") {return new Symbol(sym.PIE_MORA,yychar,yyline,yytext());}
/*Pie de queso					$28.00*/
("pay de queso") {return new Symbol(sym.PIE_QUESO,yychar,yyline,yytext());}
/*Churros					$6.00*/
("churros") {return new Symbol(sym.CHURROS,yychar,yyline,yytext());}
/*Café						$20.00*/
("cafe" | "café") {return new Symbol(sym.CAFE,yychar,yyline,yytext());}
/*Expresso					$35.00*/
("expresso") {return new Symbol(sym.EXPRESSO,yychar,yyline,yytext());}
/*Martini					$45.00*/
("martini" | "martíni") {return new Symbol(sym.MARTINI,yychar,yyline,yytext());}
/*Limonada					$22.00*/
("limonada") {return new Symbol(sym.LIMONADA,yychar,yyline,yytext());}
/*Naranjada					$22.00*/
("naranjada") {return new Symbol(sym.NARANJADA,yychar,yyline,yytext());}
/*Coca-cola					$18.00*/
("coca cola") {return new Symbol(sym.COCA_COLA,yychar,yyline,yytext());}
/*Corona					$39.00*/
("corona") {return new Symbol(sym.CORONA,yychar,yyline,yytext());}
/*Victoria					$39.00*/
("victoria") {return new Symbol(sym.VICTORIA,yychar,yyline,yytext());}
/*Piña colada 					$45.00*/
("piña colada") {return new Symbol(sym.PIÑA_COLADA,yychar,yyline,yytext());}
/*Jugo						$25.00*/
("jugo") {return new Symbol(sym.JUGO,yychar,yyline,yytext());}
/*Vampiro					$55.00*/
("vampiro") {return new Symbol(sym.VAMPIRO,yychar,yyline,yytext());}
/*--------------------------------------------------------------*/

/*-------------- Utencilios ------------------*/
("vasos") {return new Symbol(sym.VASOS,yychar,yyline,yytext());}
("servilletas") {return new Symbol(sym.SERVILLETAS,yychar,yyline,yytext());}
("cucharas") {return new Symbol(sym.CUCHARAS,yychar,yyline,yytext());}
("tenedores") {return new Symbol(sym.TENEDORES,yychar,yyline,yytext());}
/*--------------------------------------------*/


/*---------- Entregar pedido -----------------*/

("mesa uno") {return new Symbol(sym.MESAA,yychar,yyline,yytext());}
("mesa dos") {return new Symbol(sym.MESAB,yychar,yyline,yytext());}
("mesa tres") {return new Symbol(sym.MESAC,yychar,yyline,yytext());}
("mesa cuatro") {return new Symbol(sym.MESAD,yychar,yyline,yytext());}
/*--------------------------------------------*/
("adios" | "Adios" | "adiós"| "Adiós") {return new Symbol(sym.ADIOS,yychar,yyline,yytext());}
/*----------------- Adios ------------------------------------*/

/*------------------------Cantidades plurales-----------------------*/
( "dos" ) {return new Symbol(sym.DOS,yychar,yyline,yytext());}
( "tres" ) {return new Symbol(sym.TRES,yychar,yyline,yytext());}
( "cuatro" ) {return new Symbol(sym.CUATRO,yychar,yyline,yytext());}
( "cinco" ) {return new Symbol(sym.CINCO,yychar,yyline,yytext());}
( "seis" ) {return new Symbol(sym.SEIS,yychar,yyline,yytext());}
( "siete" ) {return new Symbol(sym.SIETE,yychar,yyline,yytext());}
( "ocho" ) {return new Symbol(sym.OCHO,yychar,yyline,yytext());}
( "nueve" ) {return new Symbol(sym.NUEVE,yychar,yyline,yytext());}
( "diez" ) {return new Symbol(sym.DIEZ,yychar,yyline,yytext());}
( "once" ) {return new Symbol(sym.ONCE,yychar,yyline,yytext());}
( "doce" ) {return new Symbol(sym.DOCE,yychar,yyline,yytext());}
( "trece" ) {return new Symbol(sym.TRECE,yychar,yyline,yytext());}
( "catorce" ) {return new Symbol(sym.CATORCE,yychar,yyline,yytext());}
( "quince" ) {return new Symbol(sym.QUINCE,yychar,yyline,yytext());}


/*------------------Cantidad UN y UNA------------------------------*/
( "un" ) {return new Symbol(sym.CANT_UN,yychar,yyline,yytext());}
( "una" ) {return new Symbol(sym.CANT_UNA,yychar,yyline,yytext());}



( "los" ) {return new Symbol(sym.LOS,yychar,yyline,yytext());}

( "de" ) {return new Symbol(sym.DE,yychar,yyline,yytext());}

( "por" ) {return new Symbol(sym.POR,yychar,yyline,yytext());}

( "favor" ) {return new Symbol(sym.FAVOR,yychar,yyline,yytext());}

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}



 . {return new Symbol (sym.ERROR,yychar,yyline,yytext());}
