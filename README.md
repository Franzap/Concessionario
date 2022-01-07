# Concessionario
Java's Project representing a veichle dealer

Scrivere un package di classi (interfacce, classi astratte... tutto ciò che abbiamo visto e si ritiene necessario),
di supporto alla gestione di un concessionario che vende automobili, macchine agricole e che in futuro consideri altri tipi di veicoli.
I veicoli sono individuati da una marca, un modello, una targa, una cilindrata ed un costo (di tipo double) 
e possiedono un campo proprietario di tipo Persona (individuato da nome, cognome, età) se queste sono state vendute.

Le macchine agricole possiedono un campo relativo alla capacità di traino ( tonnellate, di tipo int).

Abbiamo una interfaccia concessionario che esporta i seguenti metodi (vedi codice ConcessionarioInterface)

Vogliamo scrivere una classe Concessionario che implementi l’interfaccia ConcessionarioInterface, al cui
interno sia presente un Array di Veicoli e che ovviamente esporti tutti i metodi della ConcessionarioInterface.
