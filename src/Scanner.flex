// user code
// mesle package ha
// balaye code e scanner asli ezafe mishe.

%%
// Define macros and states
%class Scanner
%public
%unicode
%line
%column
%function nextToken
%type Token

// class Token {
//     String type;
//     Object value;
// }
%{
    class Token {
    String type;
    Object value;
}
    //dakhele class e scanner ezafe misheh.
    // tarif e variable va function va class dar inja tarif mishavad.
    public int ICV;
    public double RCV;

%}

Digit = [0-9]
Letter = [a-zA-Z]

DecimalInteger = {Digit}+
Hexadecimal = [0][X|x][0-9a-fA-F]+
RealNumber = {Digit}+[\.]{Digit}*
ScientificNotation =({DecimalInteger}|{RealNumber})[e|E][\-|\+]{Digit}+

Underline ="_"
Identifier = {Letter}({Letter}|{Digit}|{Underline}){0,30}

LineTerminators = \r|\n|\r\n
InputCharacters = [^\r\n]
WhiteSpace = {LineTerminators} | [ \t\f]

//comment
CommentType1 = "/*" [^*] ~"*/" | "/*"~"*/"
CommentType2 = "//" {InputCharacters}* {LineTerminators}? 
Comment = {CommentType1} | {CommentType2}
 
%%
<YYINITIAL> {

    {Comment} {
        System.out.print("Comment: " + yytext());
        return new Token("comment" , yytext());
        // return "Comment: " + yytext();
    } 
    {DecimalInteger} {
        ICV = Integer.parseInt(yytext());
        System.out.print("Number: "+ ICV + " ");
        return new Token("intConstant" , ICV);
        // return "intConstant";
      }
    {WhiteSpace} {

    }  
}
[^] {
    return new Token("Error" ,"Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext() ) ;
    }
