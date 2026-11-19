# 1.º Trabalho Prático de SAD – 1.º Sprint

Repositório com a resolução do 1.º Sprint do trabalho prático de **Segurança de Aplicações e Dados (SAD)** – ISEP 2026/2027.

## Elementos do Grupo

- **1231543** – José Henrique Correia Leite
    - Hash: `NSWI PIMXI HXXIMZWXWZBWRVW`
- **1241582** – Artur Cardoso Bernardes
    - Hash: `DUWXU EHUQDUGHV BNCVMBODJBQIAWAY`
- **1251659** – Guillermo Enrique Ferreira Rendon
    - Hash: `CQEHDANIK NAJZKJ WSCKIBMLZITDMO`

## Exercício 1 – Cifra de César

Foi desenvolvido um programa em Java para desencriptar as primeiras palavras de cada hash, correspondentes aos nomes dos elementos do grupo, utilizando a cifra de César e testando os 26 deslocamentos possíveis.

- **José Henrique:** `NSWI PIMXI` – Deslocamento K = 4 → `JOSE LEITE`
- **Artur Bernardes:** `DUWXU EHUQDUGHV` – Deslocamento K = 3 → `ARTUR BERNARDES`
- **Guillermo Rendon:** `CQEHDANIK NAJZKJ` – Deslocamento K = 22 → `GUILHERMO RENDON`

## Exercício 2 – Desencriptação com Salts

Foi desenvolvido um programa em Java para identificar os dois salts de cada hash e desencriptar a palavra principal, testando as diferentes posições dos salts e os deslocamentos possíveis.

- **José Henrique**
    - Hash: `HXXIMZWXWZBWRVW`
    - Salts: `HXX` (início) e `RVW` (fim)
    - Deslocamento K = 8
    - Palavra: **AEROPORTO**

- **Artur Bernardes**
    - Hash: `BNCVMBODJBQIAWAY`
    - Salts: `QIA` e `WAY` (fim)
    - Deslocamento K = 1
    - Palavra: **AMBULANCIA**

- **Guillermo Rendon**
    - Hash: `WSCKIBMLZITDMO`
    - Salts: `WSC` (início) e `DMO` (fim)
    - Deslocamento K = 8
    - Palavra: **CATEDRAL**

O programa apresenta também a tabela de desencriptação dos salts, com os deslocamentos de 0 a 25.

## Ficheiros

- `DecriptadorEx1.java` – Programa de desencriptação da cifra de César.
- `DecriptadorEx2.java` – Programa de identificação dos salts e desencriptação da palavra principal.
- `README.md` – Descrição do trabalho.
