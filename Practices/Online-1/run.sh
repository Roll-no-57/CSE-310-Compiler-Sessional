#!/bin/bash
flex -o onlineB1.cpp b1solve.l
g++ onlineB1.cpp -lfl -o online.out
./online.out input.txt