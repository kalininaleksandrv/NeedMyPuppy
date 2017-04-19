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
       - imageId

       следующие переменные пока не реализуем n.к. нет ответной части в main logic
       - indep склонность к самостоятельному принятию решения
       - prot_qual охранные качества
       - pet_hunt склонность охотиться на других питомцев
       - dog_agres агрессивность по отношению к другим собакам
       - escaping склонность к побегам

       TODO  консультация с профессионалом
       TODO создать усложненную логику из нереализованных параметров
       */

Breed (int ID, String breed_title, String breed_descr, String FCI_linc, int obid, int activ, int size, int imageId ){

        this.ID = ID;
        this.breed_title = breed_title;
        this.breed_descr = breed_descr;
        this.FCI_linc = FCI_linc;
        this.obid = obid;
        this.activ = activ;
        this.size = size;
        this.imageId = imageId;
    }

    //возвращаем полное описание текстовой части

    public String getBreedFullDescription() {
        String res = breed_title.concat(" ").concat(breed_descr).concat(" ").concat(FCI_linc);

        return res;
    }

    // возвращаем ID записи и картинки

    public int getID() {
        return ID;
    }

    public int getImageId() {
        return imageId;
    }

    // возвращаем только числовые параметры для логики

    public int getObid() {
        return obid;
    }

    public int getActiv() {
        return activ;
    }

    public int getSize() {
        return size;
    }

    // возвращаем тайтл и дескрипшн отдельно

    public String getBreed_title() {
        return breed_title;
    }

    public String getBreed_descr() {
        return breed_descr;
    }

    public String getFCI_linc() {
        return FCI_linc;
    }

}
