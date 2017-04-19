package dev.eyesless.needmypuppy;

/**
 * Created by Eyesless on 19.04.2017.
 */

public class Breed {

    private final int ID;
    private final String breed_title;
    private final String breed_descr;
    private final String FCI_linc;
    private final int obid;
    private final int activ;
    private final int size;
    private final int indep;
    private final int prot_qual;
    private final int pet_hunt;
    private final int dog_agres;
    private final int escaping;
    private final int imageId;


    /*
       конструктор класса определяет основные параметры собаки, поля int должны содержать значение
       от 0 до 10 где 0 отсутствие признака а 10 максимально выраженный признак
       - ID = номер по классификации FCI
       - название
       - описание
       - ссылка на страницу породы на сайте  FCI
       - obid послушность
       - activ активность, необходимость много гулять и тратить энергию, темперамент в поведении
       - size размер
       - indep склонность к самостоятельному принятию решения
       - prot_qual охранные качества
       - pet_hunt склонность охотиться на других питомцев
       - dog_agres агрессивность по отношению к другим собакам
       - escaping склонность к побегам
       - imageId

       TODO  консультация с профессионалом
       */

Breed (int ID, String breed_title, String breed_descr, String FCI_linc, int obid, int activ, int size,
                   int indep, int prot_qual, int pet_hunt, int dog_agres, int escaping, int imageId){

        this.ID = ID;
        this.breed_title = breed_title;
        this.breed_descr = breed_descr;
        this.FCI_linc = FCI_linc;
        this.obid = obid;
        this.activ = activ;
        this.size = size;
        this.indep = indep;
        this.prot_qual = prot_qual;
        this.pet_hunt = pet_hunt;
        this.dog_agres = dog_agres;
        this.escaping = escaping;
        this.imageId = imageId;

    }

    public String getBreedParam() {
        String res = breed_title.concat(" ").concat(breed_descr).concat(" ").concat(FCI_linc);

        return res;
    }
}
