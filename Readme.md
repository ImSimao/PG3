## Grupo nº21

### Involvidos
João Barbieri
Simão Freire

### Pergunta 1.1

1 -> Rect não redefine toString, por isso usa o de Object: nome da classe + @ + hash de identidade em hexadecimal.

2 -> no segundo system.out ele acaba por chamar toString() logo a justificação é a mesma

3 -> são dois rect com referencias diferentes (dois 'new')

4-> Rect r3 = r1; faz r3 apontar para r1 logo r1==r3 é igual

5-> Rect não redefine equals, por isso usa o de Object, que também compara referências. r1 e r2 são objetos diferentes, mesmo com w e h iguais.

### Pergunta 1.3

System.out.println(r1) não imprime o objeto “diretamente”. Para um argumento do tipo Object, o println obtém a representação em texto chamando (em última análise) r1.toString().

Por isso:

``` Java
System.out.println(r1.toString());
System.out.println(r1);
```

executam o mesmo método toString() sobre o mesmo objeto (r1). Sem override, as duas linhas mostram o Object.toString(); com override (exercício 1.2 ou 2), as duas mostrariam o texto novo — em qualquer caso, iguais entre si.




### ParseRect
```
"(1.0,2.0)->(3.0,4.0)"
        │
     split("->")
        │
   "(1.0,2.0)"   "(3.0,4.0)"
        │              │
   tira ( )         tira ( )
        │              │
   "1.0,2.0"       "3.0,4.0"
        │              │
   split(",")      split(",")
        │              │
   1.0 , 2.0       3.0 , 4.0
        │
   new Rect(1.0, 2.0, 2.0, 2.0)
```