
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
( "Sanji" | "SANJI" | "sanji" ) {return new Symbol(sym.SANJI,yychar,yyline,yytext());}

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

/*Cantidad UN y UNA*/
( "un" ) {return new Symbol(sym.CANT_UN,yychar,yyline,yytext());}
( "una" ) {return new Symbol(sym.CANT_UNA,yychar,yyline,yytext());}

/*Cantidades plurales*/
( "dos" | "tres" | "cuatro" | "cinco" | "seis"| "siete" | "ocho" | "nueve" | "diez" | "once" | "doce" | "trece" | "catorce" | "quince" ) {return new Symbol(sym.CANT_PLURALES,yychar,yyline,yytext());}

/*-------------------- PLATILLOS (MENU) -----------------------*/
/* Sushi de camaron				$80.00*/
("sushi de camaron") {return new Symbol(sym.SUSHI_CAMARON,yychar,yyline,yytext());}
/*Sushi de pollo				$80.00*/
(“sushi de pollo”) {return new Symbol(sym.SUSHI_POLLO,yychar,yyline,yytext());}
/*Sushi de res					$80.00*/
(“sushi de res”) {return new Symbol(sym.SUSHI_RES,yychar,yyline,yytext());}
/*Camaronito					$100.00*/
(“camaronito”) {return new Symbol(sym.CAMARONITO,yychar,yyline,yytext());}
/*Bombazo					$100.00*/
(“bombazo”) {return new Symbol(sym.BOMBAZO,yychar,yyline,yytext());}
/*Cielo, mar y tierra				$90.00*/
(“cielo mar y tierra”) {return new Symbol(sym.CIELO_MAR_TIERRA,yychar,yyline,yytext());}
/*Tres quesos					$90.00*/
(“tres quesos”) {return new Symbol(sym.TRES_QUESOS,yychar,yyline,yytext());}
/*Mar y tierra					$85.00*/
(“mar y tierra”) {return new Symbol(sym.MAR_TIERRA,yychar,yyline,yytext());}
/*Hamburguesa de arroz                          $90.00*/
(“hamburguesa de arroz”) {return new Symbol(sym.HAMBURGUESA_ARROZ,yychar,yyline,yytext());}
/*Teriyaki					$120.00*/
(“teriyaki”) {return new Symbol(sym.TERIYAKI,yychar,yyline,yytext());}
/*Helado de vainilla				$30.00*/
(“helado de vainilla”) {return new Symbol(sym.HELADO_VAINILLA,yychar,yyline,yytext());}
/*Fruta en caramelo				$28.00*/
(“fruta en caramelo”) {return new Symbol(sym.FRUTA_CARAMELO,yychar,yyline,yytext());}
/*Fondant					$40.00*/
(“fondant”) {return new Symbol(sym.FONDANT,yychar,yyline,yytext());}
/*Helado de cacao				$30.00*/
(“helado de cacao”) {return new Symbol(sym.HELADO_CACAO,yychar,yyline,yytext());}
/*Pie de limón					$26.00*/
(“pie de limon”) {return new Symbol(sym.PIE_LIMON,yychar,yyline,yytext());}
/*Pie de fresa					$26.00*/
(“pie de fresa”) {return new Symbol(sym.PIE_FRESA,yychar,yyline,yytext());}
/*Pie de mora					$26.00*/
(“pie de mora”) {return new Symbol(sym.PIE_MORA,yychar,yyline,yytext());}
/*Pie de queso					$28.00*/
(“pie de queso”) {return new Symbol(sym.PIE_QUESO,yychar,yyline,yytext());}
/*Churros					$6.00*/
(“churros”) {return new Symbol(sym.CHURROS,yychar,yyline,yytext());}
/*Dulce de leche				$12.00*/
(“dulce de leche”) {return new Symbol(sym.DULCE_LECHE,yychar,yyline,yytext());}
/*Café						$20.00*/
(“cafe”) {return new Symbol(sym.CAFE,yychar,yyline,yytext());}
/*Expresso					$35.00*/
(“expresso”) {return new Symbol(sym.EXPRESSO,yychar,yyline,yytext());}
/*Martini					$45.00*/
(“martini”) {return new Symbol(sym.MARTINI,yychar,yyline,yytext());}
/*Limonada					$22.00*/
(“limonada”) {return new Symbol(sym.LIMONADA,yychar,yyline,yytext());}
/*Naranjada					$22.00*/
(“naranjada”) {return new Symbol(sym.NARANJADA,yychar,yyline,yytext());}
/*Coca-cola					$18.00*/
(“coca cola”) {return new Symbol(sym.COCA_COLA,yychar,yyline,yytext());}
/*Corona					$39.00*/
(“corona”) {return new Symbol(sym.CORONA,yychar,yyline,yytext());}
/*Victoria					$39.00*/
(“victoria”) {return new Symbol(sym.VICTORIA,yychar,yyline,yytext());}
/*Piña colada 					$45.00*/
(“piña colada”) {return new Symbol(sym.PIÑA_COLADA,yychar,yyline,yytext());}
/*Jugo						$25.00*/
(“jugo”) {return new Symbol(sym.JUGO,yychar,yyline,yytext());}
/*Vampiro					$55.00*/
(“vampiro”) {return new Symbol(sym.VAMPIRO,yychar,yyline,yytext());}

/*--------------------------------------------------------------*/

( "los" ) {return new Symbol(sym.LOS,yychar,yyline,yytext());}

( "de" ) {return new Symbol(sym.DE,yychar,yyline,yytext());}

( "por" ) {return new Symbol(sym.POR,yychar,yyline,yytext());}

( "favor" ) {return new Symbol(sym.FAVOR,yychar,yyline,yytext());}

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

{MM}* {return new Symbol(sym.CADENA,yychar,yyline,yytext());}

 . {return new Symbol (sym.ERROR,yychar,yyline,yytext());}
