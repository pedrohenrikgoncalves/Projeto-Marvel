package com.example.marvel.model;


public class Personagens {

        private String heroi;
        private String nome;

        public Personagens(String heroi, String nome) {
            this.heroi = heroi;
            this.nome = nome;
        }

        public String getHeroi() {
            return heroi;
        }

        public void setHeroi(String heroi) {
            this.heroi = heroi;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
