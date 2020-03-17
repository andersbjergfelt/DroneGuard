#!/bin/bash
clear
cd DroneGuardSystem
dotnet run
cd ..
cd src
javac TCPClient.java
java TCPClient

watch -n 5 "curl --raw http://localhost.com/5000/healthcheck"