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
%type String

%{
    public int ICV;
    public double RCV;

%}

Digit = [0-9]
Letter = [a-zA-Z]
DecimalInteger = {Digit}+


LineTerminators = \r | \n \ \r\n
InputCharacters = [^\r\n]
WhiteSpace = {LineTerminators} | [ \t\f]


%%
<YYINITIAL> {
    {DecimalInteger} {
          return "salam";
      }
      
}
