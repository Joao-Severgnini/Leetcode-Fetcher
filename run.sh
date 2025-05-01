#!/bin/bash

echo "🔄 Limpando projeto..."
mvn clean

echo "🔧 Compilando e empacotando..."
mvn package

echo "🚀 Executando aplicação..."
java -jar target/leetcode-fetcher-1.0-SNAPSHOT-all.jar
