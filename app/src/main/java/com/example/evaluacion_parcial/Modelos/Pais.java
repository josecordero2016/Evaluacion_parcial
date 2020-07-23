package com.example.evaluacion_parcial.Modelos;

public class Pais {
    private String name, flag, demonym,alpha2Code, capital,subregion,nativeName,region;
    private Lenguajes[] languages;

    public Pais(String name, String flag, String demonym, String alpha2Code, String capital, String subregion, String nativeName, String region, Lenguajes[] languages) {
        this.name = name;
        this.flag = flag;
        this.demonym = demonym;
        this.alpha2Code = alpha2Code;
        this.capital = capital;
        this.subregion = subregion;
        this.nativeName = nativeName;
        this.region = region;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Lenguajes[] getLanguages() {
        return languages;
    }

    public void setLanguages(Lenguajes[] languages) {
        this.languages = languages;
    }

    class Lenguajes
     {
        private String name,iso639_1;

         public Lenguajes(String name) {
             this.name = name;
         }

         public String getIso639_1() {
             return iso639_1;
         }

         public void setIso639_1(String iso639_1) {
             this.iso639_1 = iso639_1;
         }
     }
}
