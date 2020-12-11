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
( "Sanji" | "SANJI" | "sanji" ) {lexeme=yytext(); return SANJI;}

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

( "los" ) {lexeme=yytext(); return LOS;}

/*Cantidad UN y UNA*/
( "un" ) {lexeme=yytext(); return CANT_UN;}
( "una" ) {lexeme=yytext(); return CANT_UNA;}

/*Cantidades plurales*/
( "dos" | "tres" | "cuatro" | "cinco" | "seis"| "siete" | "ocho" | "nueve" | "diez" | "once" | "doce" | "trece" | "catorce" | "quince" ) {lexeme=yytext(); return CANT_PLURALES;}

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
