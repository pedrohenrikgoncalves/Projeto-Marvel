package com.example.marvel.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Personagens implements Parcelable {
        private int image;
        private String heroi;
        private String nome;

        public Personagens(int image, String heroi, String nome) {
            this.image = image;
            this.heroi = heroi;
            this.nome = nome;
        }

    public int getImage() {
        return image;
    }


    protected Personagens(Parcel in) {
        image = in.readInt();
        heroi = in.readString();
        nome = in.readString();
    }

    public static final Creator<Quadrinhos> CREATOR = new Creator<Quadrinhos>() {
        @Override
        public Quadrinhos createFromParcel(Parcel in) {
            return new Quadrinhos(in);
        }

        @Override
        public Quadrinhos[] newArray(int size) {
            return new Quadrinhos[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(heroi);
        dest.writeString(nome);
    }
}
