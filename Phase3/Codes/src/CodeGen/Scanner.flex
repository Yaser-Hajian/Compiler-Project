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
%function My_Next_Token
%type Token
%state STRING
%implements Lexical

%{
     public class Token {
     public String type;
     public Object value;
     public int lineNumber;
     public Token(String type , Object value , int lineNumber){
         this.value=value;
         this.type=type;
         this.lineNumber=lineNumber;
     }
    }
    public String nextToken(){
      try{
          while (true){
              Token current = My_Next_Token();
                        if (current  == null){
                            return "$";
                        }
                        if (current.type.equals("Comment") || current.type.equals("WhiteSpace")){
                            continue;
                        }
                        if (current.type.equals("Reserved")){
                            return String.valueOf(current.value);
                        }
                        if (current.type.equals("Operators")) {
                            if (current.value.equals(",")){
                                return "comma";
                            }else {
                                return String.valueOf(current.value);
                            }
                        }
                        return current.type;
          }

      }catch (Exception e){
          e.printStackTrace();
          return null;
      }
    }
    //dakhele class e scanner ezafe misheh.
    // tarif e variable va function va class dar inja tarif mishavad.
    public int ICV;
    public double RCV;
    public Token current_Token;
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
                "in_int"|"print"|"len"|"true"|"false"

%%

<YYINITIAL> {

    {ReservedWord} {
        current_Token =   new Token("Reserved",yytext() , yyline);
        return current_Token;
    }
    {Identifier} {
          current_Token = new Token("identifiers",yytext() , yyline);
        return current_Token;
    }
    {Comment} {
          current_Token=new Token("Comment",yytext() , yyline);
        return current_Token;
    }
    {ScientificNotation} {
        String sNumber = yytext();
        RCV = Double.parseDouble(sNumber);
        System.out.println("ScientificNotation: "+ sNumber + " " + "with decimal value of "+ RCV);
        current_Token=new Token("Real",sNumber, yyline);
        return current_Token;
    }
    {Hexadecimal} {
        String hex_number = yytext();
        ICV = Integer.parseInt(hex_number.substring(2) , 16);
        System.out.println("HexNumber: "+ hex_number + " " + "with decimal value of "+ ICV);
        current_Token = new Token("Integer",hex_number, yyline);
        return current_Token;
    }
    {DecimalInteger} {
        ICV = Integer.parseInt(yytext());
        System.out.println("Number: "+ ICV + " ");
        current_Token = new Token("Integer",ICV, yyline);
        return current_Token;
    }
    {RealNumber} {
        RCV = Double.parseDouble(yytext());
        System.out.println("RealNumber: "+ RCV + " ");
        current_Token = new Token("Real", RCV, yyline);
        return current_Token;
    }
    {Operators} {
        current_Token=new Token("Operators",yytext(), yyline);
        return current_Token;
    }
    {WhiteSpace} {
          current_Token =  new Token("WhiteSpace",yytext(), yyline);
        return current_Token;
    }
   "\"" {
        yybegin(STRING);
        current_Token = new Token("StringLiteral",yytext(), yyline);
        return current_Token;
    }
}

<STRING> {
    \"  {
        yybegin(YYINITIAL);
        current_Token = new Token("StringLiteral",yytext(), yyline);
        return current_Token;
    }
    {WhiteSpace} {
          current_Token = new Token("WhiteSpace",yytext(), yyline);
        return current_Token;
    }
    [^\n\r\"\\] {
          current_Token = new Token("String",yytext(), yyline);
        return current_Token;
        }
    {SpecialChar} {
          current_Token = new Token("Special Characters",yytext(), yyline);
        return current_Token;
    }
}


[^] {
//    return "Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext()  ;
     System.out.println("Error at line: "+yyline + "index: "+ yycolumn + "character = "+ yytext());
     current_Token = new Token("Undefined", yytext() , yyline) ;
     return current_Token;
    }