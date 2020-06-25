/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author EDUARDO
 */
public class SituacaoNotas {

    float nota1, nota2, nota3, nota4;
    float media;

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    public float getMedia() {
        float media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public String situacao() {
        
        if(getMedia() > 5.999999999999){
            return "Aprovado";
        }
        if (getMedia() < 4){
            return "Reprovado";
            
        }else{
            return "Recuperacao";
        }

    }

}
