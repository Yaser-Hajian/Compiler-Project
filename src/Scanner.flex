

%%
%class nextToken
%unicode
%line
%column


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
