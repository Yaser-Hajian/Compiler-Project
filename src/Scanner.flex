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
%state STRING

%{
     public class Token {
     String type;
     Object value;
     public Token(String type , Object value){
         this.value=value;
         this.type=type;
     }
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
Assignment="<-"
SpecialChar=[\\][n|t|r||\\|\'|\"]
Operators= ([\+\*\-\>\<\/\!][\=]?|[\+\-\=\|\&]{2}|[\%\|\&\^\.\,\;\[\]\(\)\{\}]|{Assignment})
// dont know add '' to Op or not?? because read that for strings

Identifier = {Letter}({Letter}|{Digit}|{Underline}){0,30}

LineTerminators = \r|\n|\r\n
InputCharacters = [^\r\n]
WhiteSpace = {LineTerminators} | [ \t\f]

//comment
CommentType1 = "/*" [^*] ~"*/" | "/*"~"*/"
CommentType2 = "//" {InputCharacters}* {LineTerminators}? 
Comment = {CommentType1} | {CommentType2}

ReservedWord = "let"|"void"|"int"|"real"|"bool"|"string"|
                "static"|"class"|"for"|"rof"|"loop"|"pool"|
                "while"|"break"|"continue"|"if"|"fi"|"else"|
                "then"|"new"|"Array"|"return"|"in_string"|
                "in_int"|"print"|"len"

%%

<YYINITIAL> {

    {ReservedWord} {
            return new Token("Reserved",yytext());
      }
    {Identifier} {
            return new Token("Identifiers",yytext());
      }
    {Comment} {
         return new Token("Comment",yytext());
    }
    {ScientificNotation} {
            return new Token("Integer",yytext());
      }
    {Hexadecimal} {
                  return new Token("Integer",yytext());
     }
    {DecimalInteger} {
        ICV = Integer.parseInt(yytext());
        System.out.print("Number: "+ ICV + " ");
        return new Token("Integer",ICV);
      }
    {RealNumber} {
                      return new Token("Real",yytext());
       }
//    "\"" {
//        yybegin(STRING);return new Token("Operators and Punctuations",yytext());
//    }
    {Operators} {
        return new Token("Operators and Punctuations",yytext());
    }
    {WhiteSpace} { }

}
//<STRING> {
//    "\"" {
//        yybegin(YYINITIAL);
//        return new Token( "Operators and Punctuations",yytext());
//        }
//	{SpecialChar}   {
//          return new Token("Special Characters",yytext());
//      }
//	.               {
//          return new Token("String",yytext());
//      }
//}


[^] {
//    return "Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext()  ;
     return new Token("Error" ,"Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext() ) ;
    }
