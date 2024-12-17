package com.infogain.config

import org.jetbrains.exposed.sql.transactions.transaction
import org.yaml.snakeyaml.Yaml
import java.io.InputStream

// creating singleton object.
object DatabaseConfig {
    // hard coded values.

    fun init(){
        // Reading yaml function call
        readYAML()
        // Db.connect
        dbConnect()
        transaction{
            // to manage our DB.


        }
    }

    fun readYAML(){

        val inputStream: InputStream =
            this::class.java.getResourceAsStream("/application.yaml")
                ?: throw IllegalArgumentException("application.yml not found")

        val yaml = Yaml()
        // load method will load entire yaml file
        // which includes ktor related and db related props are
        // there
        // above details will be stored/hold by config.


        val config = yaml.load(inputStream) as Map<String,Any>


        // we need only database
        val dbConfig = config["database"] as Map<String,String>
    }
    fun dbConnect(){

    }


}