package com.example.mycheflogin.Model;
import android.graphics.Bitmap;

public class DbModelClass {

    String imageDes;
    Bitmap ourImage;
    String recipeSteps;

    public DbModelClass(String imageDes, Bitmap ourImage, String recipeSteps) {
        this.imageDes = imageDes;
        this.ourImage = ourImage;
        this.recipeSteps=recipeSteps;
    }

    public String getImageDes() {
        return imageDes;
    }

    public void setImageDes(String imageDes) {
        this.imageDes = imageDes;
    }

    public Bitmap getOurImage() {
        return ourImage;
    }

    public void setOurImage(Bitmap ourImage) {
        this.ourImage = ourImage;
    }

    public String getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(String recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}
