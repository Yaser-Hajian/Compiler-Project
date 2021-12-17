// user code
// mesle package ha
// balaye code e scanner asli ezafe mishe.

%%
// Define macros and states
%class My_Scanner
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
     int lineNumber;
     public Token(String type , Object value , int lineNumber){
         this.value=value;
         this.type=type;
         this.lineNumber=lineNumber;
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
Hexadecimal = [0][Xx][0-9a-fA-F]+
RealNumber = {Digit}+[\.]{Digit}*
ScientificNotation =({DecimalInteger}|{RealNumber})[eE][\-\+]?{Digit}+

Underline ="_"
SpecialChar=[\\][ntr\\\'\"]
Operators= ([\+\*\-\>\<\/\!\=][\=]?|[\+\-\|\&]{2}|[\%\|\&\^\.\,\;\[\]\(\)\{\}])

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
        return new Token("Reserved",yytext() , yyline);
    }
    {Identifier} {
        return new Token("Identifiers",yytext() , yyline);
    }
    {Comment} {
        return new Token("Comment",yytext() , yyline);
    }
    {ScientificNotation} {
        String sNumber = yytext();
        RCV = Double.parseDouble(sNumber);
        System.out.println("ScientificNotation: "+ sNumber + " " + "with decimal value of "+ RCV);
        return new Token("Real",sNumber, yyline);
    }
    {Hexadecimal} {
        String hex_number = yytext();
        ICV = Integer.parseInt(hex_number.substring(2) , 16);
        System.out.println("HexNumber: "+ hex_number + " " + "with decimal value of "+ ICV);
        return new Token("Integer",hex_number, yyline);
    }
    {DecimalInteger} {
        ICV = Integer.parseInt(yytext());
        System.out.println("Number: "+ ICV + " ");
        return new Token("Integer",ICV, yyline);
    }
    {RealNumber} {
        RCV = Double.parseDouble(yytext());
        System.out.println("RealNumber: "+ RCV + " ");
        return new Token("Real", RCV, yyline);
    }
    {Operators} {
        return new Token("Operators",yytext(), yyline);
    }
    {WhiteSpace} {
        return new Token("WhiteSpace",yytext(), yyline);
    }
   "\"" {
        yybegin(STRING);
        return new Token("StringLiteral",yytext(), yyline);
    }
}

<STRING> {
    \"  {
        yybegin(YYINITIAL);
        return new Token("StringLiteral",yytext(), yyline);
    }
    {WhiteSpace} {
        return new Token("WhiteSpace",yytext(), yyline);
    }
    [^\n\r\"\\] {
        return new Token("StringLiteral",yytext(), yyline);
        }
    {SpecialChar} {
        return new Token("Special Characters",yytext(), yyline);
    }
}


[^] {
//    return "Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext()  ;
     System.out.println("Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext());
     return new Token("Undefined", yytext() , yyline) ;
    }