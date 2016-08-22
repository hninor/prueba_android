package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {

    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.hnino.biblioapps.greendao");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, PROJECT_DIR + "\\app\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        Entity app = addApp(schema);
        Entity category = addCategory(schema);
        Entity image = addImage(schema);

        //Relationships


        Property appId = image.addLongProperty("appId").notNull().getProperty();
        app.addToMany(image, appId, "image_app");
    }

    private static Entity addApp(final Schema schema) {
        Entity app = schema.addEntity("App");
        app.addIdProperty().primaryKey().autoincrement();
        app.addStringProperty("name").notNull();
        app.addStringProperty("category").notNull();


        return app;
    }

    private static Entity addCategory(final Schema schema) {
        Entity category = schema.addEntity("Category");
        category.addIdProperty().primaryKey().autoincrement();
        category.addStringProperty("title").notNull().unique();

        return category;
    }

    private static Entity addImage(final Schema schema) {
        Entity image = schema.addEntity("Image");
        image.addIdProperty().primaryKey().autoincrement();
        image.addStringProperty("url").notNull();
        image.addIntProperty("height").notNull();

        return image;
    }
}
