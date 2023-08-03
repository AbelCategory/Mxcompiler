grammar mx;

program: (classDef | funcDef | (varDef ';'))* mainFn;

mainFn: 'int' 'main()' suite EOF;

varDef: typename varTerm (',' varTerm)*;
varTerm: ID ('=' expr)?;

classDef: Class ID '{' (varDef ';'| funcDef | constructStat)* '}' ';';
funcDef: typename ID '(' para? ')' suite;

suite: '{' stat* '}';
constructStat : ID '(' ')' suite;

stat: varDef ';'                                                                  #def_statement
    | suite                                                                       #suite_statement
    | If '(' expr ')' (ifstat = stat) (Else (elsestat = stat))?                   #if_statement
    | Break ';'                                                                   #break_statement
    | Continue ';'                                                                #continue_statement
    | Return expr? ';'                                                            #return_statement
    | While '(' expr ')' stat                                                     #while_statement
    | For '(' (init = expr)? ';' (cond = expr)? ';' (step = expr)? ')' stat       #forExp_statement
    | For '(' (init = varDef)? ';' (cond = expr)? ';' (step = expr)? ')' stat     #forDef_statement
    | expr ';'                                                                    #expression_statement
    | ';'                                                                         #empty_statement
    ;

expr: basic_expr                                #basic_expression
    | '(' expr ')'                              #parent_expression
    | ID '(' argu? ')'                          #functionCall
    | expr '[' expr ']'                         #arrayIndex
    | expr '.' varName = ID                     #memberExp
    | expr '.' funName = ID '(' argu? ')'       #memberFun

    | expr op = ('--' | '++')                   #left_inc_dec
    | <assoc=right> op = ('--' | '++') expr     #right_inc_dec
    | <assoc=right> op = ('+' | '-') expr       #unary
    | <assoc=right> op = ('!' | '~') expr       #unary

    | expr op = ('*' | '/'| '%') expr           #binary
    | expr op = ('+' | '-') expr                #binary
    | expr op = ('<<' | '>>') expr              #binary

    | expr op = ('<' | '<=' | '>' | '>=') expr  #binary
    | expr op = ('==' | '!=') expr              #binary
    | expr op = '&' expr                        #binary
    | expr op = '^' expr                        #binary
    | expr op = '|' expr                        #binary
    | expr op = '&&' expr                       #binary
    | expr op = '||' expr                       #binary
    | <assoc=right> expr '?' expr ':' expr      #conditional
    | <assoc=right> expr '=' expr               #assign
    ;

basic_expr: const                                             #constvalue
          | ID                                                #variable
          | <assoc=right> New typename ('(' ')')?             #new_expression
          ;

argu: expr (',' expr)*;
para: typename ID (',' typename ID)*;


const: Num | True | False | Str | Null | This;

typename: (Int | Bool | Void | String | ID) bracket*;
bracket: '[' ']';

Int: 'int';
Bool: 'bool';
Void: 'void';
String: 'string';
If: 'if';
Else: 'else';
For: 'for';
While: 'while';
Break: 'break';
Continue: 'continue';
Return: 'return';
Class: 'class';
New: 'new';

fragment Digit: [0-9];
fragment PosDigit: [1-9];
fragment Letter: [a-zA-Z];
fragment StrChar: ~(["\\\r\n\u2028\u2029])
                | '\\' ('n' | '"' | '\\');

ID: Letter (Digit | Letter | '_')*;
Num: PosDigit Digit*
   | '0';
Str: '"' StrChar* '"';
True: 'true';
False: 'false';
Null: 'null';
This: 'this';
WhiteSpace: [ \t\u000B\u000C\u00A0] -> channel(HIDDEN);
NewLine: [\r\n\u2028\u2029] -> channel(HIDDEN);

LineCom: '//' ~[\r\n\u2028\u2029]* -> channel(HIDDEN);
BlockCom: '/*' .*? '*/' -> channel(HIDDEN);

LeftPa: '(';
RightPa: ')';
LeftBracket: '[';
RightBracket: ']';
LeftBrace: '{';
RightBrace: '}';

Plus: '+';
Minus: '-';
Mul: '*';
Div: '/';
Mod: '%';

Gr: '>';
Le: '<';
Greq: '>=';
Leeq: '<=';
Eq: '==';
Neq: '!=';

LogicAnd: '&&';
LogicOr: '||';
LogicNot: '!';

BitAnd: '&';
BitOr: '|';
BitXor: '^';
BitNot: '~';
Lsh: '<<';
Rsh: '>>';

Assign: '=';

Inc: '++';
Dec: '--';
Dot: '.';
Arrow: '->';

Que: '?';
Colon: ':';
Semi: ';';
Comma: ',';
Quo: '"';