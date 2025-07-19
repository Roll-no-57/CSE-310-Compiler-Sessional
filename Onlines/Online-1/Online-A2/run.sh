#!/bin/bash
flex online.l
g++ lex.yy.c
./a.out in.txt