
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
